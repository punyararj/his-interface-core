package com.healthcaresolutions.hisif.datamanager;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.PatientMapper;
import com.healthcare.db.model.Patient;
import com.healthcare.db.model.PatientExample;

public class PatientManager {

	private static final Logger log = LogManager.getLogger(PatientManager.class);
	
	public Patient getPatientByHn(String hn){
		Patient result = null;
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			PatientMapper patientMapper = session.getMapper(PatientMapper.class);
			PatientExample patientExample = new PatientExample();
			patientExample.createCriteria().andPHnEqualTo(hn);
			
			List<Patient> patients = patientMapper.selectByExample(patientExample);
			
			if(patients.size()>0){
				result = patients.get(0);
			}
			session.close();
			
		}catch(IOException ioe){
			ioe.printStackTrace();
			log.debug("Find patient by HN ("+hn+") error",ioe);
		}catch (Exception e) {
			e.printStackTrace();
			log.debug("Find patient by HN ("+hn+") error",e);
		}
		return result;
	}
	
	public Patient insertPatient(Patient patient) {
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession(false);
			PatientMapper patientMapper = session.getMapper(PatientMapper.class);
			
			patientMapper.insertSelective(patient);
			
			session.commit();
			session.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
			log.debug("Insert patient error error",ioe);
		}catch (Exception e) {
			e.printStackTrace();
			log.debug("Insert patient error error",e);
		}
		return patient;
	}
	
	public Patient updatePatient(Patient patient){
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			PatientMapper patientMapper = session.getMapper(PatientMapper.class);
			
			patientMapper.updateByPrimaryKeySelective(patient);
			
			session.commit();
			session.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return patient;
	}
	
}
