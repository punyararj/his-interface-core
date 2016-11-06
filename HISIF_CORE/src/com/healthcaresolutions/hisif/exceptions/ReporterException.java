package com.healthcaresolutions.hisif.exceptions;

public class ReporterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 777311254434860072L;
	
	private int errorCodeId=0;
	
	
	public ReporterException(String message,int errCode) {
		super(message);
		this.errorCodeId=errCode;
	}
	
	public ReporterException(String message,int errCode,Throwable e) {
		super(message,e);
		this.errorCodeId=errCode;
	}
	
	public int getErrorCodeId() {
		return errorCodeId;
	}

}
