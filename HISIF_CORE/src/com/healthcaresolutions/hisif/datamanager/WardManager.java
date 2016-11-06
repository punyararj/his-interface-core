package com.healthcaresolutions.hisif.datamanager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.WardMapper;
import com.healthcare.db.model.Ward;
import com.healthcare.db.model.WardExample;

public class WardManager {

	public Ward addWard(Ward ward){
		Ward result = null;
		if(ward!=null && ward.getWardId()!=null){
			return null;
		}
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			WardMapper wardMapper = session.getMapper(WardMapper.class);
			wardMapper.insert(ward);
			result = ward;
			session.close();
		}catch(Exception e){}
		return result;
	}
	
	public Ward getWardById(int wardId){
		Ward result = null;
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			WardMapper wardMapper = session.getMapper(WardMapper.class);
			result=wardMapper.selectByPrimaryKey(wardId);
			session.close();
		}catch(Exception e){}
		return result;
	}
	
	public Ward getWardBySDLocId(String sdlocId){
		Ward result = null;
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			
			WardMapper wardMapper = session.getMapper(WardMapper.class);
			WardExample wex = new WardExample();
			wex.createCriteria().andWardInEqualTo(sdlocId);
			List<Ward> wrds = wardMapper.selectByExample(wex);
			if(wrds.size()>0){
				result = wrds.get(0);
			}
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
}
