package com.healthcare.db.client;

import java.util.List;

import com.healthcare.db.model.TestExample;
import com.healthcaresolutions.hisif.beans.TestResult;

public interface TestResultMapper {

	TestResult selectByPrimaryKey(Integer testId);
	
	List<TestResult> selectByExample(TestExample testExample);
	
}
