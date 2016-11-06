package com.google.protobuf.utils;

import java.util.EnumSet;

import com.healthcare.data.server.constants.ControlCharacters;

public class TextUtils {

	public static ControlCharacters getCharcode(int code){
		ControlCharacters result = null;
		
		for(ControlCharacters cc : EnumSet.allOf(ControlCharacters.class)){
			if(cc.getCode()==code){
				result = cc;
				break;
			}
		}
		
		return result;
	}
	
	public static String getControlName(int code){
		ControlCharacters result = null;
		
		for(ControlCharacters cc : EnumSet.allOf(ControlCharacters.class)){
			if(cc.getCode()==code){
				result = cc;
				break;
			}
		}
		
		return result.toString();
	}
	
}
