package com.healthcare.db.model;

public class Itemmapping {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column itemmapping.analyzer_id
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    private Integer analyzerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column itemmapping.item_id
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    private Integer itemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column itemmapping.item_in
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    private String itemIn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column itemmapping.item_out
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    private String itemOut;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column itemmapping.analyzer_id
     *
     * @return the value of itemmapping.analyzer_id
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public Integer getAnalyzerId() {
        return analyzerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column itemmapping.analyzer_id
     *
     * @param analyzerId the value for itemmapping.analyzer_id
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public void setAnalyzerId(Integer analyzerId) {
        this.analyzerId = analyzerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column itemmapping.item_id
     *
     * @return the value of itemmapping.item_id
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column itemmapping.item_id
     *
     * @param itemId the value for itemmapping.item_id
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column itemmapping.item_in
     *
     * @return the value of itemmapping.item_in
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public String getItemIn() {
        return itemIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column itemmapping.item_in
     *
     * @param itemIn the value for itemmapping.item_in
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public void setItemIn(String itemIn) {
        this.itemIn = itemIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column itemmapping.item_out
     *
     * @return the value of itemmapping.item_out
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public String getItemOut() {
        return itemOut;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column itemmapping.item_out
     *
     * @param itemOut the value for itemmapping.item_out
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    public void setItemOut(String itemOut) {
        this.itemOut = itemOut;
    }
}