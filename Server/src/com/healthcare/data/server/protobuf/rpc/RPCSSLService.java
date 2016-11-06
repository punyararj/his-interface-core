package com.healthcare.data.server.protobuf.rpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import com.healthcare.data.server.SessionManager;
import com.healthcare.data.server.listener.ClientExitListener;

public class RPCSSLService implements Runnable, ClientExitListener {
	
	private List<RPCClientThread> clientThread;
	
	private boolean isRunning=false;
	
	private int serverPortNumber;
	
	public RPCSSLService(){
		String portNumberConfig = RPCConfigured.getConfigured().getProperty("RPCSSL.Portnumber", "443");
		serverPortNumber = Integer.parseInt(portNumberConfig);
	}
	
	private void onClientRequest(SSLSocket so){
		RPCSSLConnector connector = new RPCSSLConnector(60000*5, so);
		connector.setHandler(RPCRequestManager.getInstance());
		if(clientThread==null){
			clientThread = new ArrayList<RPCClientThread>();
		}
		RPCClientThread t = new RPCClientThread(connector,null);
		clientThread.add(t);
		t.start();
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	
	public void stop(){
		isRunning = false;
	}
	
	@Override
	public void run() {
		try{
			isRunning = true;
			System.out.println("Listening on "+serverPortNumber);
			SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory
	                .getDefault();
			SSLServerSocket sslserversocket = (SSLServerSocket) sslserversocketfactory
	                .createServerSocket(serverPortNumber);
			
			sslserversocket.setUseClientMode(false);
			while(isRunning){
				SSLSocket so = (SSLSocket)sslserversocket.accept();
				onClientRequest(so);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}

	@Override
	public synchronized void onClientExit(RPCClientThread clientThread) {
		this.clientThread.remove(clientThread);
	}
	
}
