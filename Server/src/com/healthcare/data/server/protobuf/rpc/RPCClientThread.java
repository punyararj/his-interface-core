package com.healthcare.data.server.protobuf.rpc;

public class RPCClientThread extends Thread {

	private String sessionId;
	
	public RPCClientThread(Runnable r,String sessionId) {
		super(r);
		this.sessionId=sessionId;
	}
	
	@Override
	public void run() {
		super.run();
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
