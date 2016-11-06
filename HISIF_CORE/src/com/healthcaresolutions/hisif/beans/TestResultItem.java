package com.healthcaresolutions.hisif.beans;

import com.healthcare.db.model.Item;

public class TestResultItem {
	
	private TestResult test;
	
	private ItemInfo item;

	private String value;
	
	private String errorcode;
	private String note;
	
	private String comment;
	
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public TestResult getTest() {
		return test;
	}

	public void setTest(TestResult test) {
		this.test = test;
	}

	public ItemInfo getItem() {
		return item;
	}

	public void setItem(ItemInfo item) {
		this.item = item;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
