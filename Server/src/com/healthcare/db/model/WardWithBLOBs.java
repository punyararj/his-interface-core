package com.healthcare.db.model;

public class WardWithBLOBs extends Ward {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.ward_name
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    private String wardName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.ward_building
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    private String wardBuilding;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.ward_desc
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    private String wardDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.ward_name
     *
     * @return the value of ward.ward_name
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public String getWardName() {
        return wardName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.ward_name
     *
     * @param wardName the value for ward.ward_name
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.ward_building
     *
     * @return the value of ward.ward_building
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public String getWardBuilding() {
        return wardBuilding;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.ward_building
     *
     * @param wardBuilding the value for ward.ward_building
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public void setWardBuilding(String wardBuilding) {
        this.wardBuilding = wardBuilding;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.ward_desc
     *
     * @return the value of ward.ward_desc
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public String getWardDesc() {
        return wardDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.ward_desc
     *
     * @param wardDesc the value for ward.ward_desc
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public void setWardDesc(String wardDesc) {
        this.wardDesc = wardDesc;
    }
}