package com.healthcare.db.model;

import java.util.Date;

public class Act {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column act.rectime
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	private Date rectime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column act.staff_id
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	private Integer staffId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column act.act_code
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	private Integer actCode;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column act.rectime
	 * @return  the value of act.rectime
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	public Date getRectime() {
		return rectime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column act.rectime
	 * @param rectime  the value for act.rectime
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	public void setRectime(Date rectime) {
		this.rectime = rectime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column act.staff_id
	 * @return  the value of act.staff_id
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	public Integer getStaffId() {
		return staffId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column act.staff_id
	 * @param staffId  the value for act.staff_id
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column act.act_code
	 * @return  the value of act.act_code
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	public Integer getActCode() {
		return actCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column act.act_code
	 * @param actCode  the value for act.act_code
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	public void setActCode(Integer actCode) {
		this.actCode = actCode;
	}
}