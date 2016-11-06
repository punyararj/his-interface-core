package com.healthcaresolutions.hisif.reporter;

import com.healthcaresolutions.hisif.DataManagerReporter;
import com.healthcaresolutions.hisif.beans.TestResult;

public interface DataResultReportCallback {

	void onDataResultReported(DataManagerReporter dm,TestResult testResult,int errorStatus);
	
}
