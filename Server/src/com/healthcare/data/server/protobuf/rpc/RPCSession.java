package com.healthcare.data.server.protobuf.rpc;

import java.net.InetAddress;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class RPCSession implements ServiceSession {

	public Date creationTime;
	public String id;
	public Date lastAccessedTime;
	public int maxInactiveInterval;
	public Hashtable<String, Object> attributes;
	public String clientAddress;
	
	public RPCSession(String id, int inactiveInterval,String clientAddress) {
		this.lastAccessedTime = new Date();
		this.creationTime = new Date();
		this.id = id;
		this.maxInactiveInterval = inactiveInterval;
		this.attributes = new Hashtable<String, Object>();
		this.clientAddress = clientAddress;
	}
	
	@Override
	public long getCreationTime() {	
		return creationTime.getTime();
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public long getLastAccessedTime() {
		return lastAccessedTime.getTime();
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		maxInactiveInterval=interval;
	}

	@Override
	public int getMaxInactiveInterval() {
		return maxInactiveInterval;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return attributes.keys();
	}

	@Override
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	@Override
	public void removeAttribute(String name) {
		if(attributes.containsKey(name)){
			attributes.remove(name);
		}
	}
	
	@Override
	public String clientAddress() {
		return clientAddress;
	}
	
}
