package com.healthcaresolutions.hisif;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBContext;

import org.apache.ibatis.session.SqlSession;

import com.healthcare.db.SessionFactoryHelper;
import com.healthcare.db.client.WardMapper;
import com.healthcare.db.model.Ward;
import com.healthcare.db.model.WardExample;
import com.healthcaresolutions.hisif.datamanager.WardManager;
import com.healthcaresolutions.test.VFPDataSet;


public class FillLocation {

	public static void main(String[] args) throws Exception {
		FileInputStream fr = new FileInputStream("AllLocations_result.xml");
		Reader reader = new InputStreamReader(fr, "UTF-8");
		JAXBContext context = JAXBContext.newInstance(VFPDataSet.class);
		VFPDataSet vfpResult = (VFPDataSet)context.createUnmarshaller().unmarshal(reader);
		
		SqlSession session = SessionFactoryHelper.getSqlSessionFactory().openSession();
		WardMapper wardMapper = session.getMapper(WardMapper.class);
		
		List<VFPDataSet.Sdlocall> allLoc = vfpResult.getSdlocall();
		for(VFPDataSet.Sdlocall loc: allLoc){
			WardExample wex = new WardExample();
			wex.createCriteria().andWardInEqualTo(loc.getSdlocid());
			List<Ward> wards = wardMapper.selectByExample(wex);
			if(wards.size()==0){
				System.out.println("Insert: "+loc.getSdlocid());
				Ward newWard = new Ward();
				newWard.setWardIn(loc.getSdlocid());
				if(loc.getDesc().length()>248){
					newWard.setWardDesc(loc.getDesc().substring(0, 248));
				}else{
					newWard.setWardDesc(loc.getDesc());
				}
				if(loc.getSdlocname().length()>49){
					newWard.setWardName(loc.getSdlocname().substring(0, 49));
				}else{
					newWard.setWardName(loc.getSdlocname());
				}
				newWard.setTrId(0);
				
				wardMapper.insertSelective(newWard);
			}else{
				System.out.println("Skip "+loc.getSdlocid());
			}
			
		}
		
		session.commit();
		session.close();
	}

}
