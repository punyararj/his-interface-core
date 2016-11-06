package com.healthcare.db.model;

public class StationStatKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column station_stat.analyzer_id
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    private Integer analyzerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column station_stat.tracking_method
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    private String trackingMethod;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column station_stat.analyzer_id
     *
     * @return the value of station_stat.analyzer_id
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public Integer getAnalyzerId() {
        return analyzerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column station_stat.analyzer_id
     *
     * @param analyzerId the value for station_stat.analyzer_id
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public void setAnalyzerId(Integer analyzerId) {
        this.analyzerId = analyzerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column station_stat.tracking_method
     *
     * @return the value of station_stat.tracking_method
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public String getTrackingMethod() {
        return trackingMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column station_stat.tracking_method
     *
     * @param trackingMethod the value for station_stat.tracking_method
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public void setTrackingMethod(String trackingMethod) {
        this.trackingMethod = trackingMethod;
    }
}