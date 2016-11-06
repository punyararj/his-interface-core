package com.healthcaresolutions.hisif.reporter;

import com.healthcaresolutions.hisif.beans.QCResult;
import com.healthcaresolutions.hisif.beans.TestResult;
import com.healthcaresolutions.hisif.exceptions.ReporterException;

public interface DataReporter {

	public void sendTestItemResult(TestResult testResult) throws ReporterException;
	
	public void cancelTestItemResult(TestResult testResult) throws ReporterException;
	
	public void sendQCItemResult(QCResult qcResult) throws ReporterException;
	
	public void cancelQCItemResult(QCResult qcResult) throws ReporterException;
}
