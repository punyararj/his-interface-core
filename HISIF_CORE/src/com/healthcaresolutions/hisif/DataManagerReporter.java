package com.healthcaresolutions.hisif;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.healthcaresolutions.hisif.beans.TestResult;
import com.healthcaresolutions.hisif.constants.ApplicationConfigure;
import com.healthcaresolutions.hisif.constants.SystemVariables;
import com.healthcaresolutions.hisif.exceptions.ReporterException;
import com.healthcaresolutions.hisif.reporter.DataReporter;
import com.healthcaresolutions.hisif.reporter.DataResultReportCallback;
import com.healthcaresolutions.hisif.reporter.ErrorConstrants;

public class DataManagerReporter implements Runnable {

	private DataResultReportCallback callback;
	private TestResult testResult;
	private static final Logger log = LogManager.getLogger(DataManagerReporter.class);
	
	public DataManagerReporter(TestResult testResult,DataResultReportCallback callback) {
		this.callback = callback;
		this.testResult = testResult;
	}
	
	private synchronized void report(TestResult result,int error){
		if(this.callback!=null){
			this.callback.onDataResultReported(this,result,error);
		}
	}
	
	@Override
	public void run() {
		try{
			DataReporter reporter = SystemVariables.APP_CONFIG.getReporterClass().newInstance();
			reporter.sendTestItemResult(testResult);
			report(testResult,0);
		}catch(ReporterException re){
			re.printStackTrace();
			log.debug("Report error occurs", re);
			report(testResult,re.getErrorCodeId());
		}catch(Exception e){
			e.printStackTrace();
			log.debug("Report unknow error occurs", e);
			report(testResult,ErrorConstrants.ERROR_UNKNOWN);
		}
		
	}

}
