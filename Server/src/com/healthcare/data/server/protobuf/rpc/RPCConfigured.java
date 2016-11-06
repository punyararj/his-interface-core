package com.healthcare.data.server.protobuf.rpc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class RPCConfigured {

	private static Properties configured = new Properties();
	
	public static Properties getConfigured() {
		return configured;
	}
	
	public static void LoadFromFile(String f) throws IOException  {
		FileInputStream in = new FileInputStream(f);
		configured.load(in);
	}
	
	public static void LoadFromResourceName(String f) throws IOException{
		java.io.InputStream in = RPCRequestManager.class.getResourceAsStream(f);
		configured.load(in);
	}
	
	public static void setConfigured(Properties configured) {
		RPCConfigured.configured = configured;
	}
	
}
