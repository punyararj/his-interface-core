package com.healthcaresolutions.hisif.datamanager;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.healthcare.db.SessionFactoryHelper;

final class SessionManager {
	
	private static SqlSession currentSession;

	protected static SqlSession getSqlSession() throws IOException{
		if(currentSession==null){
			org.apache.ibatis.session.SqlSessionFactory sessionFactory = SessionFactoryHelper.getSqlSessionFactory();
			currentSession = sessionFactory.openSession(false);
		}
		return currentSession;
	}
	
	
	
	
}
