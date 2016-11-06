package com.healthcare.data.server;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import com.healthcare.data.server.listener.ClientListener;


public class ClientRequestListener implements Runnable {

	private List<ClientListener> listeners;
	private int serverPortNumber;
	
	
	
	public ClientRequestListener(int portNumber) {
		serverPortNumber = portNumber;
	}
	
	public void addListener(ClientListener listener){
		getListeners().add(listener);
	}
	
	public void removeListener(ClientListener listener){
		getListeners().remove(listener);
	}
	
	private List<ClientListener> getListeners(){
		if(listeners==null){
			listeners = new ArrayList<ClientListener>();
		}
		return listeners;
	}
	
	private synchronized void notifyClientRequest(SSLSocket socket){
		for(ClientListener c:getListeners()){
			c.onClientRequest(socket);
		}
	}
	
	public int getServerPortNumber() {
		return serverPortNumber;
	}
	
	public void setServerPortNumber(int serverPortNumber) {
		this.serverPortNumber = serverPortNumber;
	}
	
	@Override
	public void run() {
		try{
			System.out.println("Listening on "+serverPortNumber);
			
			
			SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory
	                .getDefault();
			
			SSLServerSocket sslserversocket = (SSLServerSocket) sslserversocketfactory
	                .createServerSocket(serverPortNumber);
			
			sslserversocket.setUseClientMode(false);
			while(true){
				SSLSocket so = (SSLSocket)sslserversocket.accept();
				notifyClientRequest(so);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}

}
