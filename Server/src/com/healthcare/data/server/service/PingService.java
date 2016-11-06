package com.healthcare.data.server.service;

import com.healthcare.data.server.ServiceEndpoint;

public class PingService extends ServiceEndpoint {

	public String echo(String message){
		return message;
	}
	
}
