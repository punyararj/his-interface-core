package com.healthcaresolutions.hisif.constants;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.healthcaresolutions.hisif.beans.AutoretryScheme;
import com.healthcaresolutions.hisif.reporter.DataReporter;

public class ApplicationConfigure {

	private Class<DataReporter> reporterClass;
	private List<Integer> sendingStatus;
	private int statusNew;
	private int statusApprove;
	private int	statusSuccess;
	private int	statusWaitcancel;
	private int	statusWaitupdate;
	private int	statusError;
	private String pidFilePath;
	private boolean overrideSendingByDbConfig;
	private AutoretryScheme autoretryScheme;
	
	
	
	public List<Integer> getSendingStatus() {
		return sendingStatus;
	}
	
	public int getStatusApprove() {
		return statusApprove;
	}
	
	public int getStatusNew() {
		return statusNew;
	}
	
	public int getStatusError() {
		return statusError;
	}
	
	public int getStatusSuccess() {
		return statusSuccess;
	}
	
	public int getStatusWaitcancel() {
		return statusWaitcancel;
	}
	
	public int getStatusWaitupdate() {
		return statusWaitupdate;
	}
	
	public String getPidFilePath() {
		return pidFilePath;
	}
	
	public Class<DataReporter> getReporterClass() {
		return reporterClass;
	}
	
	public AutoretryScheme getAutoretryScheme() {
		return autoretryScheme;
	}
	
	public boolean isOverrideSendingByDbConfig() {
		return overrideSendingByDbConfig;
	}

	public static ApplicationConfigure load(Properties prop) throws Exception{
		ApplicationConfigure result = new ApplicationConfigure();
		result.reporterClass = (Class<DataReporter>) Class.forName(prop.getProperty("reporter_class_name"));
		String statusList = prop.getProperty("sending_status","");
		String[] statuses = statusList.split(",");
		List<Integer> statusNumbers = new ArrayList<Integer>();
		for(String s : statuses){
			try{
				if(!s.trim().equals("")){
					int i = Integer.parseInt(s,10);
					statusNumbers.add(i);
				}
			}catch(Exception e){
				
			}
		}
		result.sendingStatus=statusNumbers;
		result.autoretryScheme = AutoretryScheme.pharse(prop.getProperty("autoretry.configure",""));
		result.statusNew = Integer.parseInt(prop.getProperty("status_new","100"),10);
		result.statusApprove = Integer.parseInt(prop.getProperty("status_approve","200"),10);
		result.statusSuccess = Integer.parseInt(prop.getProperty("status_success","300"),10);
		result.statusWaitcancel = Integer.parseInt(prop.getProperty("status_waitcancel","400"),10);
		result.statusWaitupdate = Integer.parseInt(prop.getProperty("status_waitupdate","500"),10);
		result.statusError = Integer.parseInt(prop.getProperty("status_error","600"),10);
		result.pidFilePath = prop.getProperty("pidFilePath","."+File.separator);
		result.overrideSendingByDbConfig = prop.getProperty("sending.status.from.db","FALSE").toUpperCase().equals("TRUE");
		return result;
	}
}
