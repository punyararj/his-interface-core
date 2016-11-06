package com.healthcaresolutions.hisif.datamanager;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.AnalyzerMapper;
import com.healthcare.db.model.Analyzer;

public class AnalyzerManager {
	

	public Analyzer getAnalyzerManagerById(int analyzerId){
		Analyzer result=null;
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			AnalyzerMapper analyzerMapper = session.getMapper(AnalyzerMapper.class);
			result=analyzerMapper.selectByPrimaryKey(analyzerId);
			session.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return result;
	}
	
}
