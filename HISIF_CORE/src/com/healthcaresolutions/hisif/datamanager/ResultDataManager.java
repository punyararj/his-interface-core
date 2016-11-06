package com.healthcaresolutions.hisif.datamanager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.ItemConversionMapper;
import com.healthcare.db.client.TestChangeRevisionsMapper;
import com.healthcare.db.model.ItemConversion;
import com.healthcare.db.model.ItemConversionExample;
import com.healthcare.db.model.TestChangeRevisions;
import com.healthcare.db.model.TestChangeRevisionsExample;
import com.healthcaresolutions.hisif.beans.ItemInfo;
import com.healthcaresolutions.hisif.constants.ApplicationConfigure;
import com.healthcaresolutions.hisif.constants.SystemVariables;
import com.healthcaresolutions.hisif.reporter.ErrorConstrants;

public class ResultDataManager {

	public List<ItemConversion> getReportConversion(ItemInfo itemInfo){
		List<ItemConversion> result = new ArrayList<ItemConversion>();
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			ItemConversionMapper itemConversionMapper = session.getMapper(ItemConversionMapper.class);
			
			ItemConversionExample itemConversionExample = new ItemConversionExample();
			itemConversionExample.createCriteria().andItemIdEqualTo(itemInfo.getItemId()).andIncludeInReportEqualTo(1);
			
			result = itemConversionMapper.selectByExample(itemConversionExample);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return result;
	}
	
	public TestChangeRevisions getLastPaymentSuccessItem(int testId){
		TestChangeRevisions revision = null;
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			TestChangeRevisionsMapper changeRevisionsMapper = session.getMapper(TestChangeRevisionsMapper.class);
			
			ApplicationConfigure conf = SystemVariables.APP_CONFIG;
			
			List<Integer> paymentSucessStatus = new ArrayList<>();
			paymentSucessStatus.add(0);
			paymentSucessStatus.add(ErrorConstrants.ERROR_TRANSF_RESULT_DATA_FAIL);
			paymentSucessStatus.add(ErrorConstrants.ERROR_CREATE_HTML);
			paymentSucessStatus.add(ErrorConstrants.ERROR_CANNOT_CANCEL_PAYMENT);
			
			TestChangeRevisionsExample example = new TestChangeRevisionsExample();
			example.createCriteria().andTestIdEqualTo(testId).andStatusBetween(conf.getStatusSuccess(), SystemVariables.APP_CONFIG.getStatusSuccess()+99).andErrorCodeIn(paymentSucessStatus);
			example.setOrderByClause("change_dt desc");
			
			List<TestChangeRevisions> revisions = changeRevisionsMapper.selectByExample(example);
			if(revisions.size()>0){
				revision = revisions.get(0);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return revision;
	}
	
}
