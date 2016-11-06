package com.healthcare.data.server.protobuf.rpc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Hashtable;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.reflect.MethodUtils;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessage;
import com.healthcare.data.server.ServiceEndpoint;
import com.healthcare.data.server.constants.ControlCharacters;
import com.healthcare.data.server.model.EndpointDiscriper;
import com.healthcare.data.server.protobuf.rpc.RpcMessageProtos.RpcMessage;
import com.healthcare.data.server.protobuf.rpc.RpcMessageProtos.RpcMessage.Call;
import com.healthcare.data.server.protobuf.rpc.RpcMessageProtos.RpcMessage.Parameter;
import com.healthcare.data.server.protobuf.rpc.RpcMessageProtos.RpcMessage.Result;

public class RPCRequestManager implements RPCCallRequestHandler{

	private static Hashtable<String, Class<ServiceEndpoint>> endpoints;
	
	private static RPCRequestManager instance;
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RPCRequestManager.class);
	
	private RPCRequestManager(InputStream configure) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(com.healthcare.data.server.model.ServiceEndpoint.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			com.healthcare.data.server.model.ServiceEndpoint data = (com.healthcare.data.server.model.ServiceEndpoint)unmarshaller.unmarshal(configure);
			endpoints = new Hashtable<String, Class<ServiceEndpoint>>();
			for(EndpointDiscriper ed : data.getDiscriper()){
				try{
					Class cls = Class.forName(ed.getClssName());
					if(ServiceEndpoint.class.isAssignableFrom(cls)){
						endpoints.put(ed.getName(), cls);
					}else{
						System.out.println("Service must implemented from ServiceEndpoint");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void onClientRequested(RPCSSLConnector connector,
			RPCRawMessage message) {
		try {
			
			OutputStream out = connector.getSocket().getOutputStream();
			
			//Sends ACK for response receiving data
			out.write(ControlCharacters.ACK.getCode());
			
			RpcMessage msg = RpcMessageProtos.RpcMessage.parseFrom(message.getDataStream());
			String sessionId = msg.getSessionId();
			
			Thread t = Thread.currentThread();
			if(t instanceof RPCClientThread){
				((RPCClientThread)t).setSessionId(sessionId);
			}
			if(msg.hasCallMessage()){
				Call call = msg.getCallMessage();
				String endpoint = call.getService();
				String method = call.getMethod();
				if(endpoints.containsKey(endpoint)){
					
					Class<ServiceEndpoint> cls = endpoints.get(endpoint);
					ServiceEndpoint enp = cls.newInstance();
					Object[] prams = getParams(call.getParametersList());
					Class[] clss = getParamTypes(call.getParametersList());
					
					RpcMessage result= invokeMethod(enp,method,prams,clss,msg);
					
					
					ByteBuffer bb = ByteBuffer.allocate(8);
					
					byte[] bytes = result.toByteArray();
					long dataLength = bytes.length;
					bb.putLong(dataLength);
					
					out.write(ControlCharacters.STX.getCode());
					out.write(message.getType());
					out.write(bb.array());
					out.write(bytes);
					
					//System.out.println(Arrays.toString(bytes));
					out.flush();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
	private RpcMessage invokeMethod(ServiceEndpoint ep,String methodName, Object[] prams, Class[] types,RpcMessage request){
		RpcMessageProtos.RpcMessage.Builder resultBuilder = RpcMessageProtos.RpcMessage.newBuilder();
		resultBuilder.setId(request.getId());
		
		Result.Builder result = Result.newBuilder();
		try {
			resultBuilder.setSessionId("111");//TODO ep.getCurrentSession().getId());
			logger.debug("ep:"+ep+", me:"+methodName+", ");
			Object returnValue = MethodUtils.invokeExactMethod(ep, methodName, prams, types);
			
			if(request.getCallMessage().getExpectsResult()){
				Parameter.Builder parambuilder = Parameter.newBuilder();
			
				if(returnValue==null){
					parambuilder.setIsNull(true);
					parambuilder.setObjectType("null");
				}else{
					if(returnValue instanceof Integer){
						parambuilder.setIntParam((int)returnValue);
						parambuilder.setUintParam((int)returnValue);
						parambuilder.setObjectType("int");
					}else if(returnValue instanceof Double){
						parambuilder.setDoubleParam((double)returnValue);
						parambuilder.setObjectType("double");
					}else if(returnValue instanceof Boolean){
						parambuilder.setBoolParam((boolean)returnValue);
						parambuilder.setObjectType("bool");
					}else if(returnValue instanceof Long){
						parambuilder.setInt64Param((long)returnValue);
						parambuilder.setUint64Param((long)returnValue);
						parambuilder.setObjectType("long");
					}else if(returnValue instanceof String){
						parambuilder.setStringParam((String)returnValue);
						parambuilder.setObjectType("string");
					}else if(returnValue instanceof GeneratedMessage){
						GeneratedMessage gm = (GeneratedMessage)returnValue;
						ByteString bs = gm.toByteString();
						parambuilder.setProtoParam(bs);
						parambuilder.setObjectType(gm.getClass().getName());
					}
				}
				result.setCallResult(parambuilder.build());
			}
			
			
		} catch (Exception e) {
			
			result.setIsFailed(true);
			if(e.getMessage()!=null){
				result.setErrorMessage(e.getMessage());
			}
		}
		
		resultBuilder.setResultMessage(result.build());
		
		return resultBuilder.build();
		
	}
	
	
	
	private static Class[] getParamTypes(List<Parameter> pams)throws ClassNotFoundException{
		Class[] result = new Class[pams.size()];
		for(int i=0;i<pams.size();i++){
			result[i]=getParamType(pams.get(i));
		}
		return result;
	}
	
	private static Object[] getParams(List<Parameter> pams)throws ClassNotFoundException{
		Object[] result = new Object[pams.size()];
		for(int i=0;i<pams.size();i++){
			result[i] = getParam(pams.get(i));
		}
		return result;
	}
	
	
	
	private static Class<?> getParamType(Parameter pam) throws ClassNotFoundException{
		Class<?> result = null;
		if(pam.getIsNull()){
			return Object.class;
		}else if(pam.hasBoolParam() && pam.getObjectType().equals("bool")){
			return boolean.class;
		}else if(pam.hasDoubleParam()|| pam.getObjectType().equals("double")){
			return double.class;
		}else if(pam.hasFloatParam() || pam.getObjectType().equals("float")){
			return float.class;
		}else if(pam.hasStringParam() || pam.getObjectType().equals("string")){
			return String.class;
		}else if((pam.hasInt64Param()  || pam.getObjectType().equals("int64")) ||
				( pam.hasUint64Param()|| pam.getObjectType().equals("uint64"))){
			return long.class;
		}else if((pam.hasIntParam() || pam.getObjectType().equals("int")) || 
				(pam.hasUintParam()||pam.getObjectType().equals("unit")) ){
			return int.class;
		}else if(pam.hasObjectType()){
			logger.debug("Object Type OTH:"+pam.getObjectType());
			return Class.forName(pam.getObjectType());
		}
		return result;
	}
	
	private static Object getParam(Parameter pam) throws ClassNotFoundException{
		Object result = null;
		if(pam.getIsNull()){
			return null;
		}else if(pam.hasBoolParam() || pam.getObjectType().equals("bool")){
			return pam.getBoolParam();
		}else if(pam.hasDoubleParam() || pam.getObjectType().equals("double")){
			return pam.getDoubleParam();
		}else if(pam.hasFloatParam() || pam.getObjectType().equals("float")){
			return pam.getFloatParam();
		}else if(pam.hasStringParam() || pam.getObjectType().equals("string")){
			return pam.getStringParam();
		}else if(pam.hasInt64Param() || pam.getObjectType().equals("int64")){
			return pam.getInt64Param();
		}else if(pam.hasUint64Param() || pam.getObjectType().equals("uint64")){
			return pam.getUint64Param();
		}else if(pam.hasIntParam() || pam.getObjectType().equals("int")){
			return pam.getIntParam();	
		}else if(pam.hasUintParam() || pam.getObjectType().equals("uint")){
			return pam.getUintParam();
		}else if(pam.hasObjectType()){
			Class c = Class.forName(pam.getObjectType());
			if(GeneratedMessage.class.isAssignableFrom(c)){
				try{					
					Method m = c.getMethod("parseFrom", ByteString.class);
					result = m.invoke(c, pam.getProtoParam());
					
				}catch(NoSuchMethodException ne){
					ne.printStackTrace();
				}catch(InvocationTargetException ie) {
					ie.printStackTrace();
				}catch(IllegalAccessException iae){
					iae.printStackTrace();
				}
			}else{
				throw new ClassNotFoundException();
			}
		}
		return result;
	}
	
	public static RPCRequestManager getInstance(){
		
		if(instance!=null)
			return instance;
		
		InputStream in=null;

		try{
			if(RPCConfigured.getConfigured().containsKey("ServiceEndpointFile")){
				in = new FileInputStream(RPCConfigured.getConfigured().getProperty("ServiceEndpointFile"));
			}else if(RPCConfigured.getConfigured().containsKey("ServiceEndpointResource")){
				in = RPCRequestManager.class.getResourceAsStream(RPCConfigured.getConfigured().getProperty("ServiceEndpointResource"));
			}else{
				in = RPCRequestManager.class.getResourceAsStream("/com/healthcare/data/server/ServiceEndpoint.xml");
			}
		}catch(Exception e){

		}
		
		instance = new RPCRequestManager(in);
		return instance;
	}
	
}
