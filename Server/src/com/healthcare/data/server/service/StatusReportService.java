package com.healthcare.data.server.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.healthcare.data.server.ServiceEndpoint;
import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.AnalyzerMapper;
import com.healthcare.db.client.StationStatMapper;
import com.healthcare.db.model.Analyzer;
import com.healthcare.db.model.AnalyzerExample;
import com.healthcare.db.model.StationStat;
import com.healthcare.db.model.StationStatKey;

public class StatusReportService extends ServiceEndpoint {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(StatusReportService.class);
	
	public void reportStatus(String deviceId,String clientSource, String method, int resultStatus){
		
		try{
			SqlSessionFactory sessionFactory = SessionFactoryHelper.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession(false);
			
			StationStatMapper mapper = session.getMapper(StationStatMapper.class);
			AnalyzerMapper analyzerMapper = session.getMapper(AnalyzerMapper.class);
			
			AnalyzerExample analyzerExample = new AnalyzerExample();
			analyzerExample.createCriteria().andAnalyzerSerialEqualTo(deviceId);
			
			List<Analyzer> analyzers = analyzerMapper.selectByExample(analyzerExample);
			if(analyzers.size()>0){
				Analyzer analyzer = analyzers.get(0);
				
				StationStatKey pk = new StationStatKey();
				pk.setAnalyzerId(analyzer.getAnalyzerId());
				pk.setTrackingMethod(method);
				StationStat stats = mapper.selectByPrimaryKey(pk);
				StationStat data = new StationStat();
				data.setAnalyzerId(analyzer.getAnalyzerId());
				data.setTrackingMethod(method);
				data.setTrackingStatusCode(resultStatus);
				data.setUpdateTime(new Date());
				data.setClientSource(clientSource);
				if(stats!=null){
					//UPDATE
					mapper.updateByPrimaryKeySelective(data);
				}else{
					//INSERT
					mapper.insertSelective(data);
				}
			}
			
		}catch(Exception e){
			logger.debug("Cannot report status",e);
		}
	}
	
}
