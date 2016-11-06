package com.healthcare.data.server.protobuf.rpc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import com.google.protobuf.utils.ByteUtils;
import com.healthcare.data.server.exception.DecodeException;
import com.healthcare.data.server.exception.SSLConnectionException;

public final class RPCRawMessage {
	
	private int type;
	private long length;
	private InputStream dataStream;
	
	private RPCRawMessage() {
		
	}
	
	public int getType() {
		return type;
	}
	
	public long getLength() {
		return length;
	}
	
	public InputStream getDataStream() {
		return dataStream;
	}
	
	public static void encode(OutputStream out) throws DecodeException{
		
	}
	
	public static RPCRawMessage decode(InputStream in) throws DecodeException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		RPCRawMessage result = new RPCRawMessage();
		try{
			int din = in.read();
			if(din==-1){
				throw new DecodeException();
			}
			result.type = din;
			
			byte[] dataArray = new byte[8];
			for(int i=0;i<8;i++){
				din = in.read();
				if(din==-1){
					throw new DecodeException();
				}
				dataArray[i]=(byte)din;
			}
			ByteBuffer bbf = ByteBuffer.wrap(dataArray);
			result.length = bbf.getLong();
			for(int i=0;i<result.length;i++){
				din = in.read();
				if(din==-1){
					throw new DecodeException();
				}
				baos.write(din);
			}
			result.dataStream = new ByteArrayInputStream(baos.toByteArray());
		}catch(IOException e){
			throw new DecodeException();
		}
		return result ;
	}
}
