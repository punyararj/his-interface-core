package com.healthcaresolutions.test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.tempuri.patientservice.wsdl.PatientserviceSoapPortProxy;

public class Test {
	
	private String endPoint;
	private String wardName;
	private String hnNo;
	
	public Test(String endPoint, String wardName, String hnNo) {
		this.endPoint = endPoint;
		this.wardName = wardName;
		this.hnNo = hnNo;
	}
	
	public void testMethod() throws RemoteException{
		//String endPoint = "http://10.6.86.141/webservice/patientservice.wsdl";
		
		PatientserviceSoapPortProxy patientService = new PatientserviceSoapPortProxy(endPoint);
		System.out.println("Using "+patientService.getEndpoint());
		//String currWard = "";
		System.out.println("Call patientService.checkPlacePremium('"+wardName+"');");
		boolean ispremium = patientService.checkPlacePremium(wardName);
		
		System.out.println("Ward "+wardName+" is "+(ispremium?"premium":"not premium"));
		
		//String hn ="";
		System.out.println("Call patientService.get_ipd_detail('"+hnNo+"');");
		String ipdDetail = patientService.get_ipd_detail(hnNo);
		
		
		
		System.out.println(ipdDetail);
		
		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date testDate = new Date();
		String dateString  =  simpleDateFormat.format(testDate);
		String encounterDetail = patientService.getEncounterDetailByMRNDATE(hn, dateString);
		System.out.println(encounterDetail);*/
	}

	public static void printUsage(String cmd){
		System.out.println("Usage: "+cmd+" endpoint hn ward");
	}
	
	public static void main(String[] args) throws RemoteException {
		System.out.println(450%100);
		
		String dateString = "2014-10-02";
		if(args.length>0){
			String ep = args[0];
			String hn = args[1];
			String ward = args[2];
			Test test=new Test(ep, ward, hn);
			test.testMethod();
		}else{
			//List<String> bean = ManagementFactory.getRuntimeMXBean().
			printUsage("");
		}
		
		
	}
	
	

}
