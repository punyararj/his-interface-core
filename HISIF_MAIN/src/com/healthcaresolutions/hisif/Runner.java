package com.healthcaresolutions.hisif;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Properties;

import com.healthcaresolutions.hisif.constants.SystemVariables;
import com.healthcaresolutions.hisif.rama.ApplicationConfigure;

public class Runner {

	public static File pidFile = null;
	public static Thread serverThread=null;
	public static DataManger serv = null;
	
	public static void main(String[] args) throws Exception{
		
		File configFile = new File("config.properties");
		if(configFile.exists()){
			FileInputStream ins = new FileInputStream(configFile);
			Properties prop = new Properties();
			prop.load(ins);
			ApplicationConfigure.load(prop);
			
			com.healthcaresolutions.hisif.constants.ApplicationConfigure conf = 
					com.healthcaresolutions.hisif.constants.ApplicationConfigure.load(prop);
			SystemVariables.APP_CONFIG = conf;
		}else{
			
		}
		
		MainRun mr = new MainRun();
		
		String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
		
		File dir = new File(SystemVariables.APP_CONFIG.getPidFilePath());
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		File f = new File(dir, "hsif.pid");
		FileWriter fw = new FileWriter(f,false);
		fw.write(pid);
		fw.close();
		f.setLastModified(new Date().getTime());
		f.deleteOnExit();
		mr.start();
		
	}
	
	public static void start(String args[]) throws Exception {
		//String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
		
		File currentFile = getCurrentPath().getParentFile();
		

		/*pidFile = new File(currentFile, "serv.pid");
		File f = pidFile;
		FileWriter fw = new FileWriter(f,false);
		fw.write(pid);
		fw.close();
		f.setLastModified(new Date().getTime());
		f.deleteOnExit();
		File logFolder = new File("log");
		if(!logFolder.exists()){
			logFolder.mkdir();
		}*/
		
		System.out.println("Server start");
		
		
		File configFile = new File(currentFile,"config.properties");
		if(configFile.exists()){
			FileInputStream ins = new FileInputStream(configFile);
			Properties prop = new Properties();
			prop.load(ins);
			ApplicationConfigure.load(prop);
			
			com.healthcaresolutions.hisif.constants.ApplicationConfigure conf = 
					com.healthcaresolutions.hisif.constants.ApplicationConfigure.load(prop);
			SystemVariables.APP_CONFIG = conf;
		}else{
			
		}
		
		//serv = new DataManger();
		
		String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
		
		//File dir = new File(SystemVariables.APP_CONFIG.getPidFilePath());
		if(!currentFile.isDirectory()){
			currentFile.mkdirs();
		}
		File f = new File(currentFile, "hsif.pid");
		FileWriter fw = new FileWriter(f,false);
		fw.write(pid);
		fw.close();
		f.setLastModified(new Date().getTime());
		f.deleteOnExit();
		//mr.start();
		
		//Properties prop = new Properties();
		//prop.setProperty("RPCSSL.Portnumber", "5510");
		//prop.setProperty("ServiceEndpointResource", "/com/healthcare/data/server/ServiceEndpoint.xml");
		

		serv = new DataManger();
		
		
		serverThread = new Thread(serv);
		serverThread.setName("Server");
		serverThread.start();
		synchronized (serverThread) {
		      try {
		    	  serverThread.wait();
		      } catch (InterruptedException e) {
		        System.out.println("'Wait' interrupted: " + e.getMessage());
		      }
		}
	}
	
	public static void stop(String args[]) throws Exception {
		if(serv!=null){
			serv.stop();
		}
		if (serverThread != null) {
		      System.out.println("Stopping the thread");
		      serverThread.interrupt();
		      synchronized (serverThread) {
		    	  serverThread.notify();
		      }
		    } else {
		    	System.out.println("No thread to interrupt");
		}
		
	}
	
	public static File getCurrentPath() throws URISyntaxException{
		return new File(Runner.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
	}

}
