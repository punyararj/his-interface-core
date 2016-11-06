package com.healthcare.data.server.protobuf.rpc;

import java.util.Date;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;

import com.healthcare.data.server.constants.ConnectionState;
import com.healthcare.data.server.constants.ControlCharacters;
import com.healthcare.data.server.exception.SSLConnectionException;

public class RPCSSLConnector implements HandshakeCompletedListener,Runnable {

	private int connectionTimeout;
	private SSLSocket socket;
	private ConnectionState connectionState;
	private boolean isStart;
	private RPCCallRequestHandler handler;
	
	public RPCSSLConnector(int timeout,SSLSocket socket){
		this.connectionTimeout = timeout;
		this.connectionState = ConnectionState.CLOSED;
		this.socket = socket;
	}
	
	public void close(){
		isStart = false;
	}
	
	public boolean isStart() {
		return isStart;
	}
	
	public SSLSocket getSocket() {
		return socket;
	}
	
	public void setHandler(RPCCallRequestHandler handler) {
		this.handler = handler;
	}
	
	public RPCCallRequestHandler getHandler() {
		return handler;
	}

	@Override
	public void handshakeCompleted(HandshakeCompletedEvent event) {
		this.connectionState = ConnectionState.OPEN;
	}

	@Override
	public void run(){
		try{
			
			this.socket.addHandshakeCompletedListener(this);
			this.socket.startHandshake();
			
			this.connectionState = ConnectionState.ESTABLISHING;
			
			waitForMessage();
			
			this.connectionState = ConnectionState.OPEN;
			isStart = true;
			while(isStart){
				RPCRawMessage msg = RPCRawMessage.decode(this.socket.getInputStream());
				if(handler!=null){
					handler.onClientRequested(this, msg);
				}
				waitForMessage();
			}
			
		}catch(Exception e){
			System.out.println("Client Shutdown:");
			//e.printStackTrace();
		}finally{
			try{
				this.socket.close();
			}catch(Exception ex){}
		}
	}
	
	private boolean waitForMessage() throws SSLConnectionException{
		try{
			long starttime = new Date().getTime();
			long currenttime = starttime;
			int ch = -1;
			while( ( (starttime+connectionTimeout ) > currenttime) 
					&& (this.connectionState != ConnectionState.CLOSED) ){
				if( this.connectionState == ConnectionState.OPEN ){
					ch = this.socket.getInputStream().read();
					if(ch==-1){
						throw new SSLConnectionException();
					}
					if(ch==ControlCharacters.STX.getCode()){
						return true;
					}	
				}
				currenttime = new Date().getTime();
				Thread.sleep(100);
			}
			return false;	
		}catch(Exception e){
			//e.printStackTrace();
			throw new SSLConnectionException();
		}
	}
	
	
	
	
}
