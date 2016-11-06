package com.healthcare.data.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.SocketAddress;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Properties;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;

import org.apache.log4j.Logger;

import com.healthcare.data.server.constants.ControlCharacters;
import com.healthcare.data.server.listener.ClientListener;
import com.healthcare.data.server.protobuf.rpc.RPCConfigured;
import com.healthcare.data.server.protobuf.rpc.RPCSSLService;

public class Main implements ClientListener,HandshakeCompletedListener {

	private static RPCSSLService serv;
	private static Thread serverThread;
	
	private static Logger log = Logger.getLogger(Main.class);
	private static File pidFile = null;
	
	public Main() {
		/*ClientRequestListener serv=new ClientRequestListener(5150);
		serv.addListener(this);
		Thread t = new Thread(serv);
		t.start();*/
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
		
		File dir = new File(".");
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		pidFile = new File(dir, "serv.pid");
		File f = pidFile;
		FileWriter fw = new FileWriter(f,false);
		fw.write(pid);
		fw.close();
		f.setLastModified(new Date().getTime());
		f.deleteOnExit();
		File logFolder = new File("log");
		if(!logFolder.exists()){
			logFolder.mkdir();
		}
		
		log.debug("Server start");
		
		if(new File("server.jks").exists()){
			System.setProperty("javax.net.ssl.keyStore", "server.jks");
			System.setProperty("javax.net.ssl.keyStorePassword", "key123456");
		}else{
			log.debug("Server exit no keystore file found");
			System.exit(0);
		}
		
		
		Properties prop = new Properties();
		prop.setProperty("RPCSSL.Portnumber", "5510");
		prop.setProperty("ServiceEndpointResource", "/com/healthcare/data/server/ServiceEndpoint.xml");
		
		RPCConfigured.setConfigured(prop);
		
		serv = new RPCSSLService();
		
		serverThread = new Thread(serv);
		serverThread.setName("Server");
		serverThread.start();
	}
	
	public static boolean K(){
		return false;
	}
	
	@Override
	public void onClientRequest(SSLSocket socket) {
		socket.addHandshakeCompletedListener(this);
		try {			
			socket.startHandshake();
			SocketAddress so=socket.getRemoteSocketAddress();
		
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println("Client Connected.."+ip+" "+so.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void handshakeCompleted(HandshakeCompletedEvent event) {
		try {
			System.out.println("Handshake completed..");
			
			SSLSocket socket = event.getSocket();
			InputStream in = socket.getInputStream();
			while(true){
				
				int din= in.read();
				if(din==ControlCharacters.STX.getCode()){
					
				}
				
				socket.getOutputStream().write("TEST<EOF>".getBytes());
			}
			//socket.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void start(String args[]) throws Exception {
		String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
		
		File currentFile = getCurrentPath().getParentFile();
		
		/*File dir = new File(".");
		if(!dir.isDirectory()){
			dir.mkdirs();
		}*/
		pidFile = new File(currentFile, "serv.pid");
		File f = pidFile;
		FileWriter fw = new FileWriter(f,false);
		fw.write(pid);
		fw.close();
		f.setLastModified(new Date().getTime());
		f.deleteOnExit();
		File logFolder = new File("log");
		if(!logFolder.exists()){
			logFolder.mkdir();
		}
		
		log.debug("Server start");
		File kestorefile = new File(currentFile,"server.jks");
		log.debug("Using keystore file at '"+kestorefile.getAbsolutePath()+"'");
		if(kestorefile.exists()){
			System.setProperty("javax.net.ssl.keyStore", kestorefile.getAbsolutePath());
			System.setProperty("javax.net.ssl.keyStorePassword", "key123456");
		}else{
			log.debug("Server exit no keystore file found");
			System.exit(0);
		}
		
		
		Properties prop = new Properties();
		prop.setProperty("RPCSSL.Portnumber", "5510");
		prop.setProperty("ServiceEndpointResource", "/com/healthcare/data/server/ServiceEndpoint.xml");
		
		RPCConfigured.setConfigured(prop);
		
		serv = new RPCSSLService();
		
		serverThread = new Thread(serv);
		serverThread.setName("Server");
		serverThread.start();
		synchronized (serverThread) {
		      try {
		    	  serverThread.wait();
		      } catch (InterruptedException e) {
		        log.debug("'Wait' interrupted: " + e.getMessage());
		      }
		}
	}
	
	public static void stop(String args[]) throws Exception {
		if(serv!=null && serv.isRunning()){
			serv.stop();
		}
		if (serverThread != null) {
		      log.debug("Stopping the thread");
		      serverThread.interrupt();
		      synchronized (serverThread) {
		    	  serverThread.notify();
		      }
		    } else {
		      log.debug("No thread to interrupt");
		}
		
	}
	
	public static File getCurrentPath() throws URISyntaxException{
		return new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
	}
	
	

}
