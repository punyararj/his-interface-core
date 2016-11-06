package com.healthcaresolutions.hisif.datamanager;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.AnalyzerMapper;
import com.healthcare.db.client.StaffMapper;
import com.healthcare.db.model.Analyzer;
import com.healthcare.db.model.Staff;
import com.healthcare.db.model.StaffExample;

public class StaffManager {

	public Staff getStaffInfo(String code){
		Staff staff=null;
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			StaffMapper staffMapper = session.getMapper(StaffMapper.class);
			StaffExample example = new StaffExample();
			example.createCriteria().andStaffCodeEqualTo(code);
			List<Staff> staffs = staffMapper.selectByExample(example);
			if(staffs.size()>0){
				staff = staffs.get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return staff;
	}
	
	public Staff setStaffInfo(String code,String name,String lastName,String license){
		Staff result=null;
		try{
			SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
			StaffMapper staffMapper = session.getMapper(StaffMapper.class);
			StaffExample example = new StaffExample();
			example.createCriteria().andStaffCodeEqualTo(code);
			
			List<Staff> staffs = staffMapper.selectByExample(example);
			if(staffs.size()>0){
				result = staffs.get(0);
				result.setStaffFname(name);
				result.setStaffLname(lastName);
				result.setStaffLicense(license);
				staffMapper.updateByPrimaryKeySelective(result);
				session.commit();
			}else{
				result = new Staff();
				result.setRoleId(0);
				result.setStaffCode(code);
				result.setStaffFname(name);
				result.setStaffLname(lastName);
				result.setStaffLicense(license);
				result.setStaffMail("");
				result.setStaffMobile("");
				result.setStaffPwd("");
				result.setStaffUsr(code);
				result.setStaffTel("");
				result.setStaffTitle("");
				result.setTrId(0);
				staffMapper.insertSelective(result);
				session.commit();
			}
			session.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return result;
	}
	
}
