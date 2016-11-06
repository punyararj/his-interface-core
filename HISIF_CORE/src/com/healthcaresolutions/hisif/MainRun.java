package com.healthcaresolutions.hisif;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.healthcaresolutions.hisif.constants.ApplicationConfigure;
import com.healthcaresolutions.hisif.constants.SystemVariables;

public class MainRun implements Runnable {
	
	private static final Logger log = LogManager.getLogger(MainRun.class);
	
	public MainRun() throws Exception {
		if(SystemVariables.APP_CONFIG == null){
			log.debug("Load default properties");
			InputStream ins = getClass().getClassLoader().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(ins);
			
			ApplicationConfigure conf = ApplicationConfigure.load(prop);
			SystemVariables.APP_CONFIG = conf;
		}
	}
	
	public void start(){
		log.debug("APPLICATON START");
		
		DataManger dm = new DataManger();
		Thread thread = new Thread(dm);
		thread.start();
		log.debug("Start Thread");
	}
	
	public static void main(String[] args) {
		System.out.println("Please start from runner application");
	}

	@Override
	public void run() {
		log.debug("APPLICATON START");
		
		DataManger dm = new DataManger();
		Thread thread = new Thread(dm);
		thread.start();
		log.debug("Start Thread");
	}
	
	

}
