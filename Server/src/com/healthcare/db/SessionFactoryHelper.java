package com.healthcare.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryHelper {

	public static SqlSessionFactory sessionFactory;
	
	private SessionFactoryHelper(){
	
	}
	
	public static SqlSessionFactory getSqlSessionFactory() throws IOException{
		if(sessionFactory == null){
			String resource = "com/healthcare/db/mybatis_config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		return sessionFactory;
	}
	
}
