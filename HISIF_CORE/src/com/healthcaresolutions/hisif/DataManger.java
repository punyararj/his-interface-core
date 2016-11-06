package com.healthcaresolutions.hisif;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.SystemconfigureMapper;
import com.healthcare.db.client.TestChangeRevisionsMapper;
import com.healthcare.db.client.TestMapper;
import com.healthcare.db.model.ItemmappingExample;
import com.healthcare.db.model.Systemconfigure;
import com.healthcare.db.model.SystemconfigureExample;
import com.healthcare.db.model.Test;
import com.healthcare.db.model.TestChangeRevisions;
import com.healthcare.db.model.TestExample;
import com.healthcare.db.model.TestExample.Criteria;
import com.healthcare.db.model.TestitemExample;
import com.healthcaresolutions.hisif.beans.AutoretryScheme;
import com.healthcaresolutions.hisif.beans.ItemInfo;
import com.healthcaresolutions.hisif.beans.TestResult;
import com.healthcaresolutions.hisif.beans.TestResultItem;
import com.healthcaresolutions.hisif.constants.ApplicationConfigure;
import com.healthcaresolutions.hisif.constants.SystemVariables;
import com.healthcaresolutions.hisif.reporter.DataResultReportCallback;
import com.healthcaresolutions.hisif.reporter.ErrorConstrants;


public class DataManger implements Runnable,DataResultReportCallback {

	private List<DataManagerReporter> reporters;
	private boolean isStart = true;
	public static final Logger log = LogManager.getLogger(DataManger.class);
	private static final String SENDINGSTATUSPREFIX="sending.status.";
	
	public DataManger() {
		System.out.println("Data Manager Intitial");
		log.debug("Data Manager Intitial");
		reporters = new ArrayList<DataManagerReporter>();
	}
	
	private List<TestResultItem> getTestItems(SqlSession session,TestResult test){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",new Locale("en", "US"));
		String tablePostfix = sdf.format(test.getTestDt());

		String targetTableName = "testitem"+tablePostfix;

		TestitemExample testitemexample = new TestitemExample(targetTableName);
		testitemexample.createCriteria().andTestIdEqualTo(test.getTestId());
		
		
		List<TestResultItem> testItems = session.selectList("com.healthcare.db.client.TestResultMapper.selectTestItemByExample", testitemexample);
		
		log.debug("Query test items from '"+targetTableName+"' has "+testItems.size()+" items");
		
		
		
		return testItems;
	}
	
	private void fillRequidedItems(SqlSession session,TestResult test){
		List<Integer> foundItemsIds = new ArrayList<Integer>();
		for(TestResultItem tri:test.getTestItems()){
			foundItemsIds.add(tri.getItem().getItemId());
		}
		
		ItemmappingExample itemmappingExample = new ItemmappingExample();
		ItemmappingExample.Criteria c = itemmappingExample.createCriteria();
		c.andAnalyzerIdEqualTo(test.getAnalyzer().getAnalyzerId());
		c.andItemIdNotIn(foundItemsIds);
		c.andIsRequiredEqualTo(1);
		
		List<TestResultItem> testItemsRequired = session.selectList("com.healthcare.db.client.TestResultMapper.selectReqiuredItem", itemmappingExample);
		for(TestResultItem rq:testItemsRequired){
			rq.setValue("-");
			test.getTestItems().add(rq);
		}
	}
	
	public List<TestResult> getTestResults(int limit,List<Integer> sendingStatus){
		List<TestResult> tests = new ArrayList<TestResult>();
		try{
			SqlSessionFactory sqlSession = SessionFactoryHelper.getSqlSessionFactory();
			SqlSession session = sqlSession.openSession(false);
			
			TestMapper testMapper = session.getMapper(TestMapper.class);
			
			TestExample testExample = new TestExample();
			//TestExample.Criteria criteria = testExample.createCriteria();
			
			boolean isAbleToSendErrors = sendingStatus.contains(SystemVariables.APP_CONFIG.getStatusError());
			//int indexOfError = sendingStatus.indexOf(SystemVariables.APP_CONFIG.getStatusError());
			
			
			boolean isHasStatusToSend = sendingStatus.size()>0;
			
			for(int stat : sendingStatus){
				
				Criteria crit = testExample.or().andStatusBetween(stat, stat+99);
				crit.andErrorCodeEqualTo(0);
				//criteria.StatusBetween(stat, stat+99);
			}
			
			//And also get Test with error that occurrence in 30 mins ago, with not older than 3 days of test time
			//Calendar errorAge = Calendar.getInstance();
			//errorAge.add(Calendar.MINUTE, -30);
			
			//Calendar limitErrorTime = Calendar.getInstance();
			//limitErrorTime.add(Calendar.DAY_OF_MONTH, -3);
			
			if(isAbleToSendErrors){
				TestExample.Criteria criteriaError = testExample.or().andErrorCodeGreaterThan(0);
				criteriaError.andStatusBetween(100, 599);
				//log.debug("is error added :"+(errorStatus!=null && !errorStatus.isEmpty()));
				//errorStatus = getRealSendingStatus(errorStatus);
				//log.debug("Has enable errors :"+(errorStatus!=null && !errorStatus.isEmpty()));
				//if(errorStatus!=null && !errorStatus.isEmpty()){
				//	log.debug("With Error Status :"+ArrayUtils.toString(sendingStatus));
				//	TestExample.Criteria criteriaError = testExample.or().andStatusBetween(SystemVariables.APP_CONFIG.getStatusError(), SystemVariables.APP_CONFIG.getStatusError()+99);
				criteriaError.andExecTimeLessThanOrEqualTo(new Date());
				criteriaError.andRetryCountLessThan(SystemVariables.APP_CONFIG.getAutoretryScheme().getPeriods().size());
				
				List<Integer> emptyErrors = new ArrayList<Integer>();
				emptyErrors.add(ErrorConstrants.ERROR_ANALYZER_IS_EMPTY);
				emptyErrors.add(ErrorConstrants.ERROR_EMPTY_RESULT_ITEMS);
				emptyErrors.add(ErrorConstrants.ERROR_HN_IS_EMPTY);
				emptyErrors.add(ErrorConstrants.ERROR_STAFF_IS_EMPTY);
				//criteriaError.andStatusNotIn(emptyErrors);
				criteriaError.andErrorCodeNotIn(emptyErrors);
				log.debug("Enable try to send `Error` Status" );

				isHasStatusToSend = true;

			}
			
			if(!isHasStatusToSend){
				log.debug("Noting to send");
				try{
					Thread.sleep(1000*5);
				}catch(Exception er){}
				return tests;
			}
			
			//emptyErrors.add(ErrorConstrants.ERROR_LOC_IS_EMPTY);
			
			RowBounds rowBounds = new RowBounds(0, limit);
			
			List<TestResult> testItems = session.selectList("com.healthcare.db.client.TestResultMapper.selectByExample", testExample, rowBounds);
			
			
			for(TestResult t:testItems){
				List<TestResultItem> testItemsList = new ArrayList<TestResultItem>();
			
				try{
					testItemsList = getTestItems(session, t);
				}catch(Exception e){
					log.error("Unable to retrive Test Items of "+t.getTestId(),e);
				}
				boolean isRejected = false;
				
				for(int ix = testItemsList.size()-1;ix>=0;ix--){
					if("REJ".equals(testItemsList.get(ix).getErrorcode())){
						log.debug(testItemsList.get(ix).getItem().getItemName()+" Rejected ");
						testItemsList.remove(ix);
					}
				}
				if(t.getPatient()!=null && "DUMMY".equals(t.getPatient().getpType())){
					Test test = new Test();
					log.debug("TEST "+t.getTestId()+" is dummy barcode");
					test.setStatus(700); //Auto cancel
					test.setIsAck(0);
					test.setErrorCode(ErrorConstrants.ERROR_DUMMY_BARCODE_HN);
					test.setUpdateDt(new Date());
					test.setRecByCommand("ERROR");
					test.setUpdateBy(-1);
					saveRevisions(t);
					TestExample testExampleRec = new TestExample();
					testExampleRec.createCriteria().andTestIdEqualTo(t.getTestId());
					testMapper.updateByExampleSelective(test, testExampleRec);
				}else
				/*if(t.getTestDt().before(limitErrorTime.getTime()) && 
						(t.getErrorCode()>0)){
					Test test = new Test();
					log.debug("TEST "+t.getTestId()+" has been treats as too old item");
					test.setStatus(700); //Auto cancel
					test.setIsAck(0);
					test.setErrorCode(ErrorConstrants.ERROR_TOO_LONG_RETRY);
					test.setUpdateDt(new Date());
					test.setRecByCommand("ERROR");
					test.setUpdateBy(-1);
					saveRevisions(t);
					TestExample testExampleRec = new TestExample();
					testExampleRec.createCriteria().andTestIdEqualTo(t.getTestId());
					testMapper.updateByExampleSelective(test, testExampleRec);
					
					
				}else */
				if(testItemsList.size()>0){
					t.setTestItems(testItemsList);
					//Fill with required parameters
					fillRequidedItems(session,t);
					if(t.getErrorCode()>0){
						t.setRetryCount(t.getRetryCount()+1);
					}
					tests.add(t);
				}else{
					Test test = new Test();
					if(isRejected){
						log.debug("TEST "+t.getTestId()+" has been treats as rejected item");
						//test.setStatus(ErrorConstrants.REJECT_ALLREJECTED_RESULT);
						test.setErrorCode(ErrorConstrants.REJECT_ALLREJECTED_RESULT);
					}else{
						log.debug("TEST " + t.getTestId()+ " has no test item to send (item count = "+ testItems.size() +") " );
						//test.setStatus(ErrorConstrants.REJECT_EMPTY_RESULT_TO_SEND);
						test.setErrorCode(ErrorConstrants.REJECT_EMPTY_RESULT_TO_SEND);
					}
					test.setStatus(700);
					test.setIsAck(0);
					test.setUpdateDt(new Date());
					test.setRecByCommand("REJECT");
					test.setUpdateBy(-1);
					saveRevisions(t);
					TestExample testExampleRec = new TestExample();
					testExampleRec.createCriteria().andTestIdEqualTo(t.getTestId());
					testMapper.updateByExampleSelective(test, testExampleRec);
				}
				
			}
			session.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return tests;
	}
	
	@Override
	public void run() {
		//System.out.println("Enter 'q' to quit...\n");
		log.debug("DataManager load");
		while(isStart){
			
			if(reporters.isEmpty()){
				loadQueue();
				for (DataManagerReporter dataManagerReporter : reporters) {
					Thread t = new Thread(dataManagerReporter);
					t.start();
				}
			}
			try {
				Thread.sleep(10*1000);
			} catch (Exception e) {
				String msg = e.getMessage();
				System.out.println("Cannot sleep thread :"+msg);
			}
			
		}
	}
	
	public synchronized Test saveRevisions(TestResult item){
		Test test = null;
		try{
			try{
				Thread.sleep(1000);
			}catch(Exception er){
				
			}
			SqlSessionFactory sqlSessionFactory = SessionFactoryHelper.getSqlSessionFactory();
			SqlSession sqlSession = sqlSessionFactory.openSession(false);
			TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
			TestChangeRevisionsMapper tcrm = sqlSession.getMapper(TestChangeRevisionsMapper.class);
			
			test = testMapper.selectByPrimaryKey(item.getTestId());
			Date currentTime = new Date();
			log.debug("Test ID: "+test.getTestId()+" call for saveRevisions");
			if(test!=null){
				TestChangeRevisions revisions = new TestChangeRevisions();
				revisions.setSpecimenType(test.getSpecimenType());
				revisions.setRetryCount(test.getRetryCount());
				revisions.setAnalyzerId(test.getAnalyzerId());
				revisions.setBillId(test.getBillId());
				revisions.setChangeDt(currentTime);
				revisions.setComment(test.getComment());
				revisions.setDockDt(test.getDockDt());
				revisions.setLabid(test.getLabid());
				revisions.setpHn(test.getpHn());
				revisions.setRecByCommand(test.getRecByCommand());
				revisions.setStaffCode(test.getStaffCode());
				revisions.setStaffId(test.getStaffId());
				revisions.setStatus(test.getStatus());
				revisions.setErrorCode(test.getErrorCode());
				revisions.setIsAck(test.getIsAck());
				revisions.setTestDt(test.getTestDt());
				revisions.setTestId(test.getTestId());
				revisions.setTrId(test.getTrId());
				revisions.setUpdateBy(test.getUpdateBy());
				revisions.setUpdateDt(test.getUpdateDt());
				revisions.setWardId(test.getWardId());
				revisions.setOrderId(test.getOrderId());
				revisions.setEncId(test.getEncId());
				revisions.setEncType(test.getEncType());
				revisions.setIsprm(test.getIsprm());
				revisions.setIsEdited(test.getIsEdited());
				revisions.setpLocId(test.getpLocId());
				revisions.setExecTime(test.getExecTime());
				revisions.setRetryCount(test.getRetryCount());
				revisions.setSpecimenType(test.getSpecimenType());
				revisions.setIfcomment(test.getIfcomment());
				tcrm.insertSelective(revisions);
				log.debug("Test ID: "+test.getTestId()+" change revisions saved");
			}
			sqlSession.commit();
			sqlSession.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			log.debug("Save Revision Error",e);
		}
		return test;
	}
	
	public List<Integer> getRealSendingStatus(List<Integer> sendingStatus){
		List<Integer> result= new ArrayList<Integer>();
		try{

			SqlSessionFactory sqlSession = SessionFactoryHelper.getSqlSessionFactory();
			SqlSession session = sqlSession.openSession(false);

			SystemconfigureMapper sysConf = session.getMapper(SystemconfigureMapper.class);
			SystemconfigureExample example = new SystemconfigureExample();
			for(Integer stat:sendingStatus){
				example.clear();
				if(stat == SystemVariables.APP_CONFIG.getStatusNew()){
					//log.debug("Status "+SENDINGSTATUSPREFIX+"NEW");
					example.createCriteria().andPrarameterNameEqualTo(SENDINGSTATUSPREFIX+"NEW");
				}else if(stat == SystemVariables.APP_CONFIG.getStatusApprove()){
					//log.debug("Status "+SENDINGSTATUSPREFIX+"APPROVE");
					example.createCriteria().andPrarameterNameEqualTo(SENDINGSTATUSPREFIX+"APPROVE");
				}else if(stat == SystemVariables.APP_CONFIG.getStatusWaitcancel()){
					//log.debug("Status "+SENDINGSTATUSPREFIX+"WAITCANCEL");
					example.createCriteria().andPrarameterNameEqualTo(SENDINGSTATUSPREFIX+"WAITCANCEL");
				}else if(stat == SystemVariables.APP_CONFIG.getStatusWaitupdate()){
					//log.debug("Status "+SENDINGSTATUSPREFIX+"WAITEDIT");
					example.createCriteria().andPrarameterNameEqualTo(SENDINGSTATUSPREFIX+"WAITEDIT");
				}else if(stat == SystemVariables.APP_CONFIG.getStatusError()){
					//log.debug("Status "+SENDINGSTATUSPREFIX+"ERROR");
					example.createCriteria().andPrarameterNameEqualTo(SENDINGSTATUSPREFIX+"ERROR");
				}else{
					continue;
				}
				List<Systemconfigure> confs = sysConf.selectByExample(example);
				if(!confs.isEmpty()){
					Systemconfigure conf = confs.get(0);
					if(conf.getParameterValue()!=null && 
							"TRUE".equals(conf.getParameterValue().toUpperCase())){
						result.add(stat);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			log.debug("Eror while verify data from db",e);
		}
		return result;
	}
	
	public synchronized void loadQueue() {
		log.debug("Loading Queue...");
		System.out.println("Loading Queue...");
		System.out.flush();
		List<Integer> sendingStatus = SystemVariables.APP_CONFIG.getSendingStatus();
		if(SystemVariables.APP_CONFIG.isOverrideSendingByDbConfig()){
			sendingStatus = getRealSendingStatus(sendingStatus);
		}
		System.out.println("With Status:"+ArrayUtils.toString(sendingStatus));
		System.out.flush();
		List<TestResult> tests = getTestResults(5, sendingStatus);
		for (TestResult testResult : tests) {
			
			DataManagerReporter rm = new DataManagerReporter(testResult, this);
			reporters.add(rm);
		}
	}
	
	@Override
	public synchronized void onDataResultReported(DataManagerReporter dm, TestResult testResult, int errorstatus) {
		try{
			
			Test oldTest = null;
			try{
				oldTest = saveRevisions(testResult);
			}catch(Exception e){
				 e.printStackTrace();
			}
			SqlSessionFactory sqlSession = SessionFactoryHelper.getSqlSessionFactory();
			SqlSession session = sqlSession.openSession(false);
			
			TestMapper testMapper = session.getMapper(TestMapper.class);
			
			Test test = new Test();
			test.setTestId(testResult.getTestId());
			test.setBillId(testResult.getBillId());
			test.setStatus(testResult.getStatus());
			test.setSpecimenType(testResult.getSpecimenType());
			test.setRetryCount(testResult.getRetryCount());
			if(testResult.getpLoc()!=null){
				test.setpLocId(testResult.getpLoc().getWardId());
			}else{
				test.setpLocId(0);
			}
			test.setIsprm(testResult.getIsPrm());
			test.setIsEdited(testResult.getIsEdited());
			test.setErrorCode(errorstatus);
			if(testResult.getStaff()!=null){
				test.setStaffId(testResult.getStaff().getStaffId());
			}else{
				test.setStaffId(0);
			}
			
			test.setOrderId(testResult.getOrderId());
			if(oldTest.getStatus()==100 && testResult.getStatus()==200){
				test.setUpdateBy(testResult.getUpdateBy());
				test.setRecByCommand("APPROVE");
			}else{
				test.setUpdateBy(-1);
				test.setRecByCommand("REPORT");
			}
			test.setEncId(testResult.getEncId());
			test.setEncType(testResult.getEncType());
			test.setUpdateDt(new Date());
			if(errorstatus>0){
				AutoretryScheme athRetry = SystemVariables.APP_CONFIG.getAutoretryScheme();
				Date nextExec = athRetry.getNextExecutionTime(new Date(), testResult.getRetryCount());
				log.debug("Count ="+testResult.getRetryCount()+" ,"+nextExec);
				//Calendar errorAge = Calendar.getInstance();
				//errorAge.add(Calendar.HOUR, 1);
				if(nextExec!=null){
					test.setExecTime(nextExec);
				}
			}
			testMapper.updateByPrimaryKeySelective(test);
			
			log.debug("Test ID "+testResult.getTestId()+" has been reported with "+testResult.getStatus()+", error code "+errorstatus);
			session.commit();
			session.close();
			reporters.remove(dm);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void stop(){
		isStart=false;
	}
	
	public static void main(String[] args) {
		
	}

	
	
	
}

