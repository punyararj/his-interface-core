package com.healthcare.db.model;

public class Qcitem extends QcitemKey {
	
	private String tableName;
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qcitem.value
     *
     * @mbggenerated Thu Sep 25 08:43:14 ICT 2014
     */
    private Float value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qcitem.istatus
     *
     * @mbggenerated Thu Sep 25 08:43:14 ICT 2014
     */
    private Integer istatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qcitem.value
     *
     * @return the value of qcitem.value
     *
     * @mbggenerated Thu Sep 25 08:43:14 ICT 2014
     */
    public Float getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qcitem.value
     *
     * @param value the value for qcitem.value
     *
     * @mbggenerated Thu Sep 25 08:43:14 ICT 2014
     */
    public void setValue(Float value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qcitem.istatus
     *
     * @return the value of qcitem.istatus
     *
     * @mbggenerated Thu Sep 25 08:43:14 ICT 2014
     */
    public Integer getIstatus() {
        return istatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qcitem.istatus
     *
     * @param istatus the value for qcitem.istatus
     *
     * @mbggenerated Thu Sep 25 08:43:14 ICT 2014
     */
    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
    }
    
    public String getTableName() {
		return tableName;
	}
    
    public void setTableName(String tableName) {
		this.tableName = tableName;
	}
    
    
}