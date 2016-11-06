package com.healthcaresolutions.hisif.reporter;

public class ErrorConstrants {
	
	/** Reject code **/
	public static final int REJECT_EMPTY_RESULT_TO_SEND = 799;
	public static final int REJECT_ALLREJECTED_RESULT = 798;
	
	/** STAFF ERRORS **/
	public static final int ERROR_STAFF_IS_EMPTY = 630;
	public static final int ERROR_UNKNOW_STAFF_IN_SYSTEM = 632;
	public static final int ERROR_STAFF_REQUEST_FAIL = 631;
	public static final int ERROR_STAFF_IS_INVALID = 633;

	/** ANALYZER ERRORS **/
	public static final int ERROR_ANALYZER_IS_EMPTY = 641;
	public static final int ERROR_UNKNOWN_ANALYZER = 642;
	public static final int ERROR_SERVICE_CODE_IS_EMPTY = 643;
	public static final int ERROR_SERVICE_CODE_IS_INVALID = 644;
	
	/** WARDS ERRORS **/
	public static final int ERROR_LOC_IS_EMPTY = 651;
	public static final int ERROR_UNKNOW_LOC_IN_SYSTEM = 652;
	public static final int ERROR_LOC_REQUEST_FAIL = 653;
	public static final int ERROR_LOC_TYPE_REQUEST_FAIL = 654;
	
	public static final int ERROR_PLOC_IS_EMPTY = 654;
	public static final int ERROR_UNKNOW_PLOC_IN_SYSTEM = 655;
	public static final int ERROR_LOC_PREQUEST_FAIL = 656;
	
	/** PATIENT ERRORS **/
	public static final int ERROR_HN_IS_EMPTY = 661;
	public static final int ERROR_UNKNOW_HN_IN_SYSTEM = 662;
	public static final int ERROR_HN_REQUEST_FAIL = 663;
	public static final int ERROR_DUMMY_BARCODE_HN = 664;
	
	/** PAYMENT ERRORS **/
	public static final int ERROR_CANNOT_SET_PAYMENT = 671;
	public static final int ERROR_CANNOT_CANCEL_PAYMENT = 672;
	public static final int ERROR_CANNOT_CANCEL_PAYMENT_NO_ORDERID = 673;
	public static final int ERROR_CANNOT_REQUEST_ENCOUNTER_INFO = 674;
	
	/** RESULTS DATA ERRORS **/
	public static final int ERROR_EMPTY_RESULT_ITEMS = 681;
	public static final int ERROR_TRANSF_RESULT_DATA_FAIL = 682;
	
	public static final int ERROR_CREATE_HTML = 683;
	public static final int ERROR_TRANSF_CANCELRESULT_DATA_FAIL = 684;
	//public static final int ERROR_TRANSF_RESULT_DATA_FAIL = 682;
	
	/** UNKNOW ERRORS **/
	public static final int ERROR_UNKNOWN = 690;
	public static final int ERROR_UNKNOWN_CANCEL = 691;
	
	/** ERRORS TOO LONG RETRY **/
	public static final int ERROR_TOO_LONG_RETRY = 700;
	
}
