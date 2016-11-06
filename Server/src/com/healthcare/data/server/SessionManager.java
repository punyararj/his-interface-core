package com.healthcare.data.server;

import java.util.Date;
import java.util.Hashtable;
import java.util.UUID;

import com.healthcare.data.server.protobuf.rpc.RPCClientThread;
import com.healthcare.data.server.protobuf.rpc.RPCSession;
import com.healthcare.data.server.protobuf.rpc.ServiceSession;

public class SessionManager {

	private static Hashtable<String, ServiceSession> seviceSession=new Hashtable<String, ServiceSession>();
	
	protected static ServiceSession getSession(String sessionId){
		if(seviceSession.containsKey(sessionId)){
			ServiceSession sess = seviceSession.get(sessionId);
			long currentTime = new Date().getTime();
			if(sess.getMaxInactiveInterval()>0 &&
					sess.getMaxInactiveInterval()+sess.getLastAccessedTime()<currentTime){
				return sess;
			}else{
				return null;
			}
		}
		return null;
	}
	
	protected static synchronized ServiceSession getSession(){
		Thread t = Thread.currentThread();
		if(t instanceof RPCClientThread){
			return getSession(((RPCClientThread)t).getSessionId());
		}
		return null;
	}
	
	protected static ServiceSession createSession(int inactiveTime, String addr){
		RPCSession session = new RPCSession(UUID.randomUUID().toString(), inactiveTime, addr);
		seviceSession.put(session.getId(), session); 
		return session;
	}
	
}
