package com.healthcaresolutions.hisif.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.format.PeriodParser;

public class AutoretryScheme {

	private static final Logger log = LogManager.getLogger(AutoretryScheme.class);
	private List<Period> periods = new ArrayList<Period>(); 
	
	private AutoretryScheme(List<Period> periods) {
		this.periods = periods;
	}
	
	public List<Period> getPeriods() {
		return periods;
	}
	
	public Period get(int count){
		Period period = null;
		if(count >= 0 && count < periods.size()){
			period = periods.get(count);
		}
		return period;
	}
	
	public Date getNextExecutionTime(Date timeBase,int count){
		DateTime dateTime = new DateTime(timeBase.getTime());
		Period p = this.get(count);
		Date result = null;
		if(null != p){
			dateTime = dateTime.plus(p);	
			result = dateTime.toDate();
		}
		
		return result;
	}
		
	public static AutoretryScheme pharse(String scheme){
		
		AutoretryScheme result = null;
		
		log.debug("Pharse Auto retry scheme :"+scheme);
		if(null != scheme){
			scheme = scheme.trim();
			String[] schemepart = scheme.split(",");
			List<Period> pList = new ArrayList<Period>();
			for(String s : schemepart){
				s = s.trim();
				if(!s.isEmpty()){
					try{
						PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
						
						if(s.indexOf("d")>-1){
							builder.appendDays().appendSuffix("d").appendSeparatorIfFieldsAfter(" ");
						}
						if(s.indexOf("h")>-1){
							builder.appendHours().appendSuffix("h").appendSeparatorIfFieldsAfter(" ");
						}
						
						if(s.indexOf("m")>-1){
							builder.appendMinutes().appendSuffix("m").appendSeparatorIfFieldsAfter(" ");
						}
						
						PeriodFormatter parser = builder.toFormatter();
						
						Period p = parser.parsePeriod(s);
						pList.add(p);
					}catch(Exception e){
						e.printStackTrace();
						break;
					}
				}else if(pList.size()>0){
					Period plast = pList.get(pList.size()-1);
					Period pnew = plast.multipliedBy(1);
					pList.add(pnew);
				}else{
					break;
				}
			}
			result = new AutoretryScheme(pList);
			log.debug("Total "+result.getPeriods().size()+" has been added");
		}
		return result;
	}
	
}
