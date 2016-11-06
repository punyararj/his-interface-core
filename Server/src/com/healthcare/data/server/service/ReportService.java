package com.healthcare.data.server.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.healthcare.data.model.LabDeviceResultMessageProtos;
import com.healthcare.data.model.LabDeviceResultMessageProtos.LabDeviceResultMessage;
import com.healthcare.data.model.LabDeviceResultMessageProtos.LabDeviceResultMessage.ResultItemMessage;
import com.healthcare.data.server.ServiceEndpoint;
import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.ActMapper;
import com.healthcare.db.client.AnalyzerGroupMapper;
import com.healthcare.db.client.AnalyzerMapper;
import com.healthcare.db.client.CalibrationMapper;
import com.healthcare.db.client.CalibrationitemMapper;
import com.healthcare.db.client.IqmDatasetItemMapper;
import com.healthcare.db.client.IqmDatasetMapper;
import com.healthcare.db.client.ItemMapper;
import com.healthcare.db.client.ItemdataMapper;
import com.healthcare.db.client.ItemmappingMapper;
import com.healthcare.db.client.LotMapper;
import com.healthcare.db.client.NewtestMapper;
import com.healthcare.db.client.NewtestitemMapper;
import com.healthcare.db.client.QcDetailsMapper;
import com.healthcare.db.client.QcMapper;
import com.healthcare.db.client.QcitemMapper;
import com.healthcare.db.client.StaffMapper;
import com.healthcare.db.client.TestMapper;
import com.healthcare.db.client.TestitemMapper;
import com.healthcare.db.client.WardMapper;
import com.healthcare.db.model.ActWithBLOBs;
import com.healthcare.db.model.Analyzer;
import com.healthcare.db.model.AnalyzerExample;
import com.healthcare.db.model.AnalyzerGroup;
import com.healthcare.db.model.Calibration;
import com.healthcare.db.model.CalibrationExample;
import com.healthcare.db.model.Calibrationitem;
import com.healthcare.db.model.CalibrationitemExample;
import com.healthcare.db.model.IqmDataset;
import com.healthcare.db.model.IqmDatasetExample;
import com.healthcare.db.model.IqmDatasetItem;
import com.healthcare.db.model.IqmDatasetItemExample;
import com.healthcare.db.model.ItemExample;
import com.healthcare.db.model.Itemdata;
import com.healthcare.db.model.ItemdataExample;
import com.healthcare.db.model.Itemmapping;
import com.healthcare.db.model.ItemmappingExample;
import com.healthcare.db.model.Lot;
import com.healthcare.db.model.LotExample;
import com.healthcare.db.model.Newtest;
import com.healthcare.db.model.NewtestExample;
import com.healthcare.db.model.Newtestitem;
import com.healthcare.db.model.Qc;
import com.healthcare.db.model.QcDetails;
import com.healthcare.db.model.QcExample;
import com.healthcare.db.model.Qcitem;
import com.healthcare.db.model.QcitemExample;
import com.healthcare.db.model.Staff;
import com.healthcare.db.model.StaffExample;
import com.healthcare.db.model.Test;
import com.healthcare.db.model.TestExample;
import com.healthcare.db.model.Testitem;
import com.healthcare.db.model.TestitemExample;
import com.healthcare.db.model.Ward;

public class ReportService extends ServiceEndpoint {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ReportService.class);

	public String test(String client){
		return "TEST "+client;
	}

	public void pushData(LabDeviceResultMessageProtos.LabDeviceResultMessage result){
		try{

			logger.debug("Push data called");

			SqlSessionFactory sessionFactory = SessionFactoryHelper.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession(false);
			
			try{
				if(result == null ){
					logger.debug("Result is null");
				}
				logger.debug("Result Type: "+result.getResultType());
				boolean isQC = result.getResultType().equals(LabDeviceResultMessageProtos.LabDeviceResultMessage.ResultType.QULITY_CONTROL);

				logger.debug("Request from "+result.getDeviceId());
				AnalyzerExample analyzerExample = new AnalyzerExample();
				analyzerExample.createCriteria().andAnalyzerSerialEqualTo(result.getDeviceId());

				AnalyzerMapper analyzerMapper = session.getMapper(AnalyzerMapper.class);
				List<Analyzer>  analyzers = analyzerMapper.selectByExample(analyzerExample);

				if(analyzers.size()==1){
					Analyzer analyzer = analyzers.get(0);
					if(isQC){
						insertQCData(session,result,analyzer);
						logger.debug("QC Data Inserted");
					}else if("iQM-MDC".equals(result.getSampleId())){
						insertiQM_MDC(session, result, analyzer);
						logger.debug("iQM Data Inserted");
					}else if(result.getResultType().equals(LabDeviceResultMessageProtos.LabDeviceResultMessage.ResultType.CALIBRATE)){
						insertCalibrationData(session, result, analyzer);
						logger.debug("Calibration Data Inserted");
					}else{
						insertResultData(session, result, analyzer);
						logger.debug("Result Data Inserted");
					}
					session.commit();
				}else{
					logger.debug("Cannot found Analyzer with serial "+result.getDeviceId());
				}


			}catch(Exception e){
				e.printStackTrace();
				session.rollback();

				logger.debug("Error in operation db session rollback ",e);
			}finally{
				session.commit();
				session.close();
			}
		}catch(Exception e){

		}


	}

	private Date utcTolocalDate(long dateLong){
		int tmzOffset = TimeZone.getDefault().getRawOffset();

		Date date = new Date(dateLong);
		date.setTime(date.getTime()-tmzOffset);

		return date;
	}

	private void insertResultData(SqlSession session,
			LabDeviceResultMessage result, Analyzer analyzer) {
		try{
			ItemmappingMapper itemMapping 	= session.getMapper(ItemmappingMapper.class);
			TestitemMapper testitemMapper 	= session.getMapper(TestitemMapper.class);
			WardMapper wardMapper 			= session.getMapper(WardMapper.class);
			TestMapper testMapper			= session.getMapper(TestMapper.class);
			StaffMapper staffMapper			= session.getMapper(StaffMapper.class);
			//ItemMapper itemMapper			= session.getMapper(ItemMapper.class);
			//AnalyzerGroupMapper analyzerGroupMapper = session.getMapper(AnalyzerGroupMapper.class);

			StaffExample staffExample		= new StaffExample();
			staffExample.createCriteria().andStaffCodeEqualTo(result.getOperatorId());

			List<Staff> staff = staffMapper.selectByExample(staffExample);

			Staff staffObj = staff.size()>0?staff.get(0):null;

			Ward ward = wardMapper.selectByPrimaryKey(analyzer.getWardId());
			
			/*AnalyzerGroup analyzerGroup = null;
			if(analyzer.getAnalyzerGroupId()!=null){
				analyzerGroup=analyzerGroupMapper.selectByPrimaryKey(analyzer.getAnalyzerGroupId());
			}*/

			if(result.getResultItemsList().isEmpty()){
				logger.debug("Empty result items skipped");
				return;
			}

			if(ward==null){
				logger.debug("No ward data skipped (pid:"+result.getPHn()+",TestTime:"+utcTolocalDate(result.getResultItemsList().get(0).getDataTime())+",WardId:"+analyzer.getWardId()+")");
				return;
			}

			List<ResultItemMessage> resultItems= result.getResultItemsList();

			TestExample testExample = new TestExample();
			testExample.createCriteria().andAnalyzerIdEqualTo(analyzer.getAnalyzerId()).andTestDtEqualTo(utcTolocalDate(result.getResultItemsList().get(0).getDataTime())).andPHnEqualTo(result.getPHn()).andStaffCodeEqualTo(result.getOperatorId());

			int count = testMapper.countByExample(testExample);
			if(count>0){
				/*List<Test> tests= testMapper.selectByExample(testExample);
				for(Test t:tests){
					t.setComment(t.getComment());
					t.setUpdateDt(new Date());
					boolean isAllCancel = false;
					result.
					for()
				}*/
				//TODO: Update if exists!!!
				logger.debug("Found duplicated data item skipped (pid:"+result.getPHn()+",TestTime:"+utcTolocalDate(result.getResultItemsList().get(0).getDataTime())+", Specimen: "+result.getSpecimenType()+", Comment: "+result.getComment());
				return;
			}

			Test testData = new Test();
			testData.setTrId(0);
			testData.setAnalyzerId(analyzer.getAnalyzerId());
			testData.setComment(result.getComment());
			testData.setDockDt(utcTolocalDate(result.getReportTime()));
			testData.setTestDt(utcTolocalDate(result.getResultItemsList().get(0).getDataTime()));
			testData.setpHn(result.getPHn());
			testData.setSpecimenType(result.getSpecimenType());
			boolean isRejected = result.getResultType().equals(LabDeviceResultMessageProtos.LabDeviceResultMessage.ResultType.REJECT);
			testData.setStatus(0);
			int finalStatus = 0;
			
			if(isRejected){
				finalStatus = 700;
				//testData.setStatus(700);
			}else if(analyzer!=null && analyzer.getAnalyzerGroupId()!=null && analyzer.getAnalyzerGroupId()<0){
				logger.debug("Unused Ward Group found reject (pid:"+result.getPHn()+", ANID:"+analyzer.getAnalyzerId()+" ,TestTime:"+utcTolocalDate(result.getResultItemsList().get(0).getDataTime()));
				finalStatus = 700;
			}else{
				finalStatus = 100;
				//testData.setStatus(100);
			}
			testData.setErrorCode(0);
			testData.setStaffCode(result.getOperatorId());
			testData.setWardId(ward.getWardId());
			testData.setLabid(result.getTestOrderNumber());
			testData.setBillId("");
			testData.setTestId(0);
			testData.setRecByCommand("INSERT");
			testData.setUpdateBy(-1);
			testData.setUpdateDt(new Date());
			testData.setExecTime(new Date());
			if(staffObj!=null){
				testData.setStaffId(staffObj.getStaffId());
			}else{
				testData.setStaffId(0);
			}

			//Insert Test Subject
			testMapper.insertSelective(testData);
			logger.debug("Insert result for PHN: "+result.getPHn()+", Dock DT:"+testData.getDockDt().toString()+", Test DT:"+testData.getTestDt().toString()+", Specimen Type:"+testData.getSpecimenType()+", Comment: "+result.getComment());

			for (ResultItemMessage resultItemMessage : resultItems) {

				Date date = utcTolocalDate(resultItemMessage.getDataTime());

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",new Locale("en", "US"));
				String tablePostfix = sdf.format(date);

				String targetTableName = "testitem"+tablePostfix;


				TestitemExample testitemexample = new TestitemExample("testitem"+tablePostfix);

				ItemmappingExample itemmappingExample = new ItemmappingExample();
				itemmappingExample.createCriteria().andAnalyzerIdEqualTo(analyzer.getAnalyzerId()).andItemInEqualTo(resultItemMessage.getName());

				List<Itemmapping> itemMapList=itemMapping.selectByExample(itemmappingExample);


				if(!itemMapList.isEmpty()){

					Itemmapping currentItem = itemMapList.get(0);

					List<String> foundedTables = testitemMapper.showTable(testitemexample);

					if(foundedTables.isEmpty()){
						testitemMapper.createTable(testitemexample);
						logger.debug("Create Table "+testitemexample.getTableName());
					}

					Testitem testItem = new Testitem();
					testItem.setTableName(targetTableName);
					testItem.setTestId(testData.getTestId());
					String resultString = resultItemMessage.getValue();
					if(resultString.matches("[0-9]+(\\.[0-9]+)?")){
						DecimalFormat decimalFormat = new DecimalFormat("0.0#");
						double resultD = Double.parseDouble(resultString);
						resultString = decimalFormat.format(resultD);
					}
					
					testItem.setValue(resultString);
					testItem.setComment(resultItemMessage.getComment());
					testItem.setItemId(currentItem.getItemId());
					if(resultItemMessage.hasStatus() && resultItemMessage.getStatus().equals("REJECTED")){
						testItem.setErrorcode("REJ");
					}else if(resultItemMessage.hasAbnormalflag()){
						testItem.setErrorcode(resultItemMessage.getAbnormalflag());
					}
					testitemMapper.insertSelective(testItem);
				}


			}
			
			//Collect for async process 
			Test testDataUpdate = new Test();
			testDataUpdate.setStatus(finalStatus);
			testDataUpdate.setTestId(testData.getTestId());
			testMapper.updateByPrimaryKeySelective(testDataUpdate);
		}
		catch(Exception e){
			logger.debug("Error found during insert result data",e);
		}

	}

	private void insertQCData(SqlSession session,LabDeviceResultMessageProtos.LabDeviceResultMessage result, Analyzer analyzer){
		logger.debug("QC insertion called");

		try{

			ItemmappingMapper itemMapping 	= session.getMapper(ItemmappingMapper.class);
			//TestitemMapper testitemMapper 	= session.getMapper(TestitemMapper.class);
			WardMapper wardMapper 			= session.getMapper(WardMapper.class);
			QcMapper qcMapper				= session.getMapper(QcMapper.class);
			StaffMapper staffMapper			= session.getMapper(StaffMapper.class);
			QcitemMapper qcitemMapper			= session.getMapper(QcitemMapper.class);
			LotMapper lotMapper				= session.getMapper(LotMapper.class);


			LotExample lotExample = new LotExample();
			lotExample.createCriteria().andLotNoEqualTo(result.getQcInfo().getLotNumber());

			List<Lot> lots = lotMapper.selectByExample(lotExample);
			Lot lot = null;

			if(lots.size()>0){
				lot = lots.get(0);

			}else{
				logger.debug("Cannot find lot data in db insert a new one");
				lot = new Lot();
				lot.setLotNo(result.getQcInfo().getLotNumber());
				String lotLvl =result.getQcInfo().getLevel();

				if(lotLvl.matches("\\d")){
					int lotLvlInt = Integer.parseInt(lotLvl,10);
					lot.setLotLv(lotLvlInt);

				}else{
					logger.debug("Lot data is missing skip data insertion");
					return;
				}
				lot.setLotCuvett(result.getQcInfo().getCuvetteBatches());
				lot.setLotMaterial(result.getQcInfo().getLotMaterial());
				lot.setTrId(0);
				lotMapper.insertSelective(lot);

			}


			StaffExample staffExample		= new StaffExample();
			staffExample.createCriteria().andStaffCodeEqualTo(result.getOperatorId());

			List<Staff> staff = staffMapper.selectByExample(staffExample);

			Staff staffObj = staff.size()>0?staff.get(0):null;

			Ward ward = wardMapper.selectByPrimaryKey(analyzer.getWardId());


			if(result.getResultItemsList().isEmpty()){
				logger.debug("Empty result items skipped");
				return;
			}

			if(ward==null){
				logger.debug("No ward data skipped (pid:"+result.getPHn()+",TestTime:"+utcTolocalDate(result.getResultItemsList().get(0).getDataTime())+",WardId:"+analyzer.getWardId()+")");
				return;
			}

			List<ResultItemMessage> resultItems= result.getResultItemsList();

			QcExample qcExample = new QcExample();
			qcExample.createCriteria().andAnalyzerIdEqualTo(analyzer.getAnalyzerId()).andQcDtEqualTo(utcTolocalDate(result.getResultItemsList().get(0).getDataTime())).andLotIdEqualTo(lot.getLotId()).andStaffCodeEqualTo(result.getOperatorId());

			int count = qcMapper.countByExample(qcExample);
			if(count>0){
				logger.debug("Found duplicated data item skipped (Lot Number:"+result.getQcInfo().getLotNumber()+",TestTime:"+utcTolocalDate(result.getResultItemsList().get(0).getDataTime()));
				return;
			}

			Qc qcData = new Qc();
			qcData.setTrId(0);;
			qcData.setAnalyzerId(analyzer.getAnalyzerId());
			qcData.setComment(result.getComment());
			qcData.setLotId(lot.getLotId());
			qcData.setQcDt(utcTolocalDate(result.getResultItemsList().get(0).getDataTime()));
			qcData.setQcStatus(0);
			qcData.setStaffCode(result.getOperatorId());
			qcData.setWardId(ward.getWardId());

			qcMapper.insertSelective(qcData);


			logger.debug("Insert result for Lot Number: "+result.getQcInfo().getLotNumber()+", Dock DT:"+utcTolocalDate(result.getReportTime())+", Test DT:"+qcData.getQcDt().toString());

			int successCount = 0;

			for (ResultItemMessage resultItemMessage : resultItems) {
				String rsVal = resultItemMessage.getValue();
				float floatVal = 0;
				if(rsVal.matches("-?[0-9]+\\.?[0-9]*")){
					try{
						floatVal = Float.parseFloat(rsVal);
					}catch(Exception e){
						logger.debug("Invalid result value "+rsVal);
						continue;
					}
				}else{
					logger.debug("Invalid result value "+rsVal);
					continue;
				}

				Date date = utcTolocalDate(resultItemMessage.getDataTime());

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",new Locale("en", "US"));
				String tablePostfix = sdf.format(date);

				String targetTableName = "qcitem"+tablePostfix;


				QcitemExample qcitemexample = new QcitemExample("qcitem"+tablePostfix);

				ItemmappingExample itemmappingExample = new ItemmappingExample();
				itemmappingExample.createCriteria().andAnalyzerIdEqualTo(analyzer.getAnalyzerId()).andItemInEqualTo(resultItemMessage.getName());

				List<Itemmapping> itemMapList=itemMapping.selectByExample(itemmappingExample);


				if(!itemMapList.isEmpty()){

					Itemmapping currentItem = itemMapList.get(0);

					List<String> foundedTables = qcitemMapper.showTable(qcitemexample);

					if(foundedTables.isEmpty()){
						qcitemMapper.createTable(qcitemexample);
						logger.debug("Create Table "+qcitemexample.getTableName());
					}
					Qcitem qcItem = new Qcitem();
					qcItem.setIstatus(0);
					qcItem.setItemId(currentItem.getItemId());
					qcItem.setQcId(qcData.getQcId());
					qcItem.setTableName(targetTableName);
					qcItem.setValue(floatVal);

					qcitemMapper.insertSelective(qcItem);
					successCount++;
				}


			}
			logger.debug(successCount+" QC items insert");
		}
		catch(Exception e){
			logger.debug("Error found during insert result data",e);
		}
	}
	
	private void insertCalibrationData(SqlSession session,LabDeviceResultMessageProtos.LabDeviceResultMessage result, Analyzer analyzer){
		logger.debug("Calibration insertion called");

		try{

			ItemmappingMapper itemMapping 	= session.getMapper(ItemmappingMapper.class);
			//TestitemMapper testitemMapper 	= session.getMapper(TestitemMapper.class);
			WardMapper wardMapper 			= session.getMapper(WardMapper.class);
			CalibrationMapper calibrationMapper				= session.getMapper(CalibrationMapper.class);
			StaffMapper staffMapper			= session.getMapper(StaffMapper.class);
			CalibrationitemMapper calibrationitemMapper			= session.getMapper(CalibrationitemMapper.class);
			LotMapper lotMapper				= session.getMapper(LotMapper.class);


			LotExample lotExample = new LotExample();
			lotExample.createCriteria().andLotNoEqualTo(result.getQcInfo().getLotNumber());

			List<Lot> lots = lotMapper.selectByExample(lotExample);
			Lot lot = null;

			if(lots.size()>0){
				lot = lots.get(0);

			}else{
				logger.debug("Cannot find lot data in db insert a new one");
				lot = new Lot();
				lot.setLotNo(result.getQcInfo().getLotNumber());
				String lotLvl =result.getQcInfo().getLevel();

				if(lotLvl.matches("-?[0-9]+")){
					int lotLvlInt = Integer.parseInt(lotLvl,10);
					lot.setLotLv(lotLvlInt);

				}else{
					logger.debug("Lot data is missing skip data insertion");
					return;
				}
				lot.setTrId(0);
				lotMapper.insertSelective(lot);

			}


			StaffExample staffExample		= new StaffExample();
			staffExample.createCriteria().andStaffCodeEqualTo(result.getOperatorId());

			List<Staff> staff = staffMapper.selectByExample(staffExample);

			Staff staffObj = staff.size()>0?staff.get(0):null;

			Ward ward = wardMapper.selectByPrimaryKey(analyzer.getWardId());


			if(result.getResultItemsList().isEmpty()){
				logger.debug("Empty result items skipped");
				return;
			}

			if(ward==null){
				logger.debug("No ward data skipped (pid:"+result.getPHn()+",TestTime:"+utcTolocalDate(result.getResultItemsList().get(0).getDataTime())+",WardId:"+analyzer.getWardId()+")");
				return;
			}

			List<ResultItemMessage> resultItems= result.getResultItemsList();

			CalibrationExample calibrationExample = new CalibrationExample();
			calibrationExample.createCriteria().andAnalyzerIdEqualTo(analyzer.getAnalyzerId()).andCalibrationDtEqualTo(utcTolocalDate(result.getResultItemsList().get(0).getDataTime())).andLotIdEqualTo(lot.getLotId()).andStaffCodeEqualTo(result.getOperatorId());

			int count = calibrationMapper.countByExample(calibrationExample);
			if(count>0){
				logger.debug("Found duplicated data item skipped (Lot Number:"+result.getQcInfo().getLotNumber()+",TestTime:"+utcTolocalDate(result.getResultItemsList().get(0).getDataTime()));
				return;
			}

			Calibration calibrationData = new Calibration();
			calibrationData.setTrId(0);;
			calibrationData.setAnalyzerId(analyzer.getAnalyzerId());
			calibrationData.setComment(result.getComment());
			calibrationData.setLotId(lot.getLotId());
			calibrationData.setCalibrationDt(utcTolocalDate(result.getResultItemsList().get(0).getDataTime()));
			calibrationData.setCalibrationStatus(1);
			calibrationData.setStaffCode(result.getOperatorId());
			calibrationData.setWardId(ward.getWardId());
			calibrationData.setCalibrationType(result.getSpecimenType());

			calibrationMapper.insertSelective(calibrationData);


			logger.debug("Insert result for Lot Number: "+result.getQcInfo().getLotNumber()+", Dock DT:"+utcTolocalDate(result.getReportTime())+", Test DT:"+calibrationData.getCalibrationDt().toString());

			int successCount = 0;

			for (ResultItemMessage resultItemMessage : resultItems) {
				String rsVal = resultItemMessage.getValue();
				float floatVal = 0;
				if(rsVal.matches("-?[0-9]+\\.?[0-9]*")){
					try{
						floatVal = Float.parseFloat(rsVal);
					}catch(Exception e){
						logger.debug("Invalid result value "+rsVal);
						continue;
					}
				}else{
					logger.debug("Invalid result value "+rsVal);
					continue;
				}

				Date date = utcTolocalDate(resultItemMessage.getDataTime());

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",new Locale("en", "US"));
				String tablePostfix = sdf.format(date);

				String targetTableName = "calibrationitem"+tablePostfix;


				CalibrationitemExample calibrationitemexample = new CalibrationitemExample("calibrationitem"+tablePostfix);

				ItemmappingExample itemmappingExample = new ItemmappingExample();
				itemmappingExample.createCriteria().andAnalyzerIdEqualTo(analyzer.getAnalyzerId()).andItemInEqualTo(resultItemMessage.getName());

				List<Itemmapping> itemMapList=itemMapping.selectByExample(itemmappingExample);


				if(!itemMapList.isEmpty()){

					Itemmapping currentItem = itemMapList.get(0);

					List<String> foundedTables = calibrationitemMapper.showTable(calibrationitemexample);

					if(foundedTables.isEmpty()){
						calibrationitemMapper.createTable(calibrationitemexample);
						logger.debug("Create Table "+calibrationitemexample.getTableName());
					}
					Calibrationitem calibrationItem = new Calibrationitem();
					calibrationItem.setIstatus(0);
					calibrationItem.setItemId(currentItem.getItemId());
					calibrationItem.setCalibrationId(calibrationData.getCalibrationId());
					calibrationItem.setTableName(targetTableName);
					calibrationItem.setValue(floatVal);

					calibrationitemMapper.insertSelective(calibrationItem);
					successCount++;
				}


			}
			logger.debug(successCount+" Calibrationitem items insert");
		}
		catch(Exception e){
			logger.debug("Error found during insert result data",e);
		}
	}

	private void  insertiQM_MDC(SqlSession session,LabDeviceResultMessageProtos.LabDeviceResultMessage result, Analyzer analyzer){

		logger.debug("Insert iqm-MDC data");
		
		IqmDatasetMapper iqmDatasetMapper = session.getMapper(IqmDatasetMapper.class);

		if(result.getResultItemsCount()>0){

			ResultItemMessage iQMdata = result.getResultItems(0);

			String val = iQMdata.getValue();

			IqmDataset dataSetHeader = new IqmDataset();;

			dataSetHeader.setRecTime(new Date());
			dataSetHeader.setAnalyzerId(analyzer.getAnalyzerId());

			String[] lines = val.split("\n");

			boolean isHead = false;
			boolean isBody = false;

			int existSetId = -1;

			for(int i=0;i<lines.length;i++){
				String line = lines[i].trim();
				if(line.equals("Header:")){
					isHead = true;
					isBody = false;
				}else if(line.equals("Data:")){
					isHead = false;
					isBody = true;

					IqmDatasetExample existSetExample = new IqmDatasetExample();
					IqmDatasetExample.Criteria existSetExampleC = existSetExample.createCriteria().
							andAnalyzerIdEqualTo(analyzer.getAnalyzerId()).
							andDataMonthEqualTo(dataSetHeader.getDataMonth()).
							andDataMaterialEqualTo(dataSetHeader.getDataMaterial()).
							andDataParameterEqualTo(dataSetHeader.getDataParameter());

					List<IqmDataset> dataSets = iqmDatasetMapper.selectByExample(existSetExample);

					if(dataSets!=null && dataSets.size()>0){
						existSetId = dataSets.get(0).getIqmDataSetId();
					}

					if(existSetId!=-1){
						dataSetHeader.setIqmDataSetId(existSetId);
						iqmDatasetMapper.updateByPrimaryKey(dataSetHeader);
					}else{
						iqmDatasetMapper.insert(dataSetHeader);
					}
				}

				if(isHead){
					dataSetHeader = setiqmHeader(dataSetHeader,line);
				}else if(isBody){
					processIqmDataParts(session, dataSetHeader, line);
				}

			}


		}

	}

	private void processIqmDataParts(SqlSession session, IqmDataset dataHeader,String line){

		IqmDatasetItemMapper dataItemMapper = session.getMapper(IqmDatasetItemMapper.class);
		Pattern dataPath = Pattern.compile("^([^,]+), ([0-9]+), (-?[0-9.]+), (-?[0-9.]+), (-?[0-9.]+), (-?[0-9.]+)");

		Matcher m = dataPath.matcher(line);


		if(m.find()){
			try{
				String dataDateString = m.group(1);
				String dataTestCount = m.group(2);

				String dataVal1 = m.group(3);
				String dataVal2 = m.group(4);
				String dataVal3 = m.group(5);
				String dataVal4 = m.group(6);
				
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy",new Locale("en", "US"));
				Date dataDate = sdf.parse(dataDateString);

				SimpleDateFormat sdfTableName = new SimpleDateFormat("yyyyMM",new Locale("en", "US"));
				String tablePostfix = sdfTableName.format(dataDate);

				String targetTableName = "iqm_dataset_item"+tablePostfix;

				IqmDatasetItemExample example = new IqmDatasetItemExample(targetTableName);
				
				List<String> foundedTables = dataItemMapper.showTable(example);

				if(foundedTables.isEmpty()){
					dataItemMapper.createTable(example);
					logger.debug("Create Table "+example.getTableName());
				}
				
				example.createCriteria().
				andIqmDataSetIdEqualTo(dataHeader.getIqmDataSetId()).
				andTestDateEqualTo(dataDate);

				List<IqmDatasetItem> items = dataItemMapper.selectByExample(example);

				int existingItemId = -1;
				if(items!=null && items.size()>0){
					existingItemId = items.get(0).getResultItemId();
				}

				IqmDatasetItem newItem = new IqmDatasetItem();
				newItem.setTableName(targetTableName);
				newItem.setIqmDataSetId(dataHeader.getIqmDataSetId());
				newItem.setTestDate(dataDate);
				newItem.setTestCount(Integer.parseInt(dataTestCount));
				newItem.setResultA(Double.parseDouble(dataVal1));
				newItem.setResultB(Double.parseDouble(dataVal2));
				newItem.setResultC(Double.parseDouble(dataVal3));
				newItem.setResultD(Double.parseDouble(dataVal4));

				if(existingItemId!=-1){
					newItem.setResultItemId(existingItemId);
					dataItemMapper.updateByPrimaryKey(newItem);
				}else{
					dataItemMapper.insert(newItem);
				}
				

			}catch(Exception e){
				logger.debug("IQM Item insertion error ",e);
			}
		}
	}

	private IqmDataset setiqmHeader(IqmDataset dataIn,String line){
		Pattern dataPath = Pattern.compile("^([^,]+), (.*)");
		Matcher m = dataPath.matcher(line);
		if(m.find()){
			try{
				String dataName = m.group(1).trim();
				String dataVal = m.group(2).trim();
				

				if(dataName.equals("Cartridge lot")){
					if(dataVal==null){
						dataVal="";
					}
					dataIn.setCatridgeLots(dataVal);
				}else if(dataName.equals("Parameter")){
					
					dataIn.setDataParameter(dataVal);
				}else if(dataName.equals("Nominal target value")){
					dataIn.setNominalTargetValue(Double.parseDouble(dataVal));
				}else if(dataName.equals("Material")){
					dataIn.setDataMaterial(dataVal);
				}else if(dataName.equals("Mean")){
					dataIn.setDataMean(Double.parseDouble(dataVal));
				}else if(dataName.equals("Low")){
					dataIn.setDataLow(Double.parseDouble(dataVal));
				}else if(dataName.equals("High")){
					dataIn.setDataHigh(Double.parseDouble(dataVal));
				}else if(dataName.equals("Precision")){
					dataIn.setDataPrecision(Double.parseDouble(dataVal));
				}else if(dataName.equals("Interval")){
					if(dataVal==null){
						dataVal="";
					}
					dataIn.setDataInterval(dataVal);
				}else if(dataName.equals("Cartridge insertion days")){
					if(dataVal==null){
						dataVal="";
					}
					dataIn.setCatridgeInsertionDays(dataVal);
				}else if(dataName.equals("Month")){
					dataVal = dataVal.replace(" ", "");
					SimpleDateFormat sdf = new SimpleDateFormat("dd MMM,yyyy",new Locale("en", "US"));
					Date reportMonth = sdf.parse("01 "+dataVal);
					dataIn.setDataMonth(reportMonth);
				}


			}catch(Exception e){
				e.printStackTrace();
				logger.debug("IQM insertion error ",e);
			}
		}
		return dataIn;
	}

}
