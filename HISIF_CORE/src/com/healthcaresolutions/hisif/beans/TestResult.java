package com.healthcaresolutions.hisif.beans;

import java.util.Date;
import java.util.List;

import com.healthcare.db.model.Analyzer;
import com.healthcare.db.model.Patient;
import com.healthcare.db.model.Staff;
import com.healthcare.db.model.Test;
import com.healthcare.db.model.Testitem;
import com.healthcare.db.model.Ward;

public class TestResult {

	private Integer testId;
	
	private Date testDt;
	
	private Date dockDt;
	
	private Analyzer analyzer;
	
	private Ward ward;
	
	private Staff staff;
	
	private Patient patient;
	
	private Integer status;
	
	private Integer isAck;
	
	private Date execTime;

	private String labid;
	
	private String billId;
	
	private String orderId;
	
	private Date updateDt;
	
	private String comment;
	
	private Integer updateBy;
	
	private String recByCommand;
	
	private String encType;
	
	private String encId;
	
	private String isPrm;
	
	private Ward pLoc;
	
	private Integer isEdited;
	
	private Integer errorCode;
	
	private Integer retryCount;
	private String specimenType;
	
	
	
	public String getIsPrm() {
		return isPrm;
	}

	public void setIsPrm(String isPrm) {
		this.isPrm = isPrm;
	}

	public Ward getpLoc() {
		return pLoc;
	}

	public void setpLoc(Ward pLoc) {
		this.pLoc = pLoc;
	}

	public Integer getIsEdited() {
		return isEdited;
	}

	public void setIsEdited(Integer isEdited) {
		this.isEdited = isEdited;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	private List<TestResultItem> testItems;
	
	public List<TestResultItem> getTestItems() {
		return testItems;
	}
	
	public void setTestItems(List<TestResultItem> testItems) {
		this.testItems = testItems;
	}
	
	public Analyzer getAnalyzer() {
		return analyzer;
	}
	
	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

	public String getBillId() {
		return billId;
	}
	
	public void setBillId(String billId) {
		this.billId = billId;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Date getTestDt() {
		return testDt;
	}

	public void setTestDt(Date testDt) {
		this.testDt = testDt;
	}

	public Date getDockDt() {
		return dockDt;
	}

	public void setDockDt(Date dockDt) {
		this.dockDt = dockDt;
	}

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLabid() {
		return labid;
	}

	public void setLabid(String labid) {
		this.labid = labid;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String oderId) {
		this.orderId = oderId;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public String getRecByCommand() {
		return recByCommand;
	}

	public void setRecByCommand(String recByCommand) {
		this.recByCommand = recByCommand;
	}

	public String getEncType() {
		return encType;
	}

	public void setEncType(String encType) {
		this.encType = encType;
	}

	public String getEncId() {
		return encId;
	}

	public void setEncId(String encId) {
		this.encId = encId;
	}
	
	public Integer getIsAck() {
		return isAck;
	}

	public void setIsAck(Integer isAck) {
		this.isAck = isAck;
	}

	public Date getExecTime() {
		return execTime;
	}

	public void setExecTime(Date execTime) {
		this.execTime = execTime;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	public String getSpecimenType() {
		return specimenType;
	}

	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}
	
	
	
}
