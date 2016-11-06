package com.healthcare.db;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryHelper {

	private static SqlSessionFactory sessionFactory;
	
	static{
		try{
			String resource = "com/healthcare/db/mybatis_config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static SqlSessionFactory getSqlSessionFactory() throws IOException{
		return sessionFactory;
	}
	
}
