package com.healthcare.db.model;

public class ItemConversionKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_conversion.item_id
     *
     * @mbggenerated Mon Jul 27 08:50:25 ICT 2015
     */
    private Integer itemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_conversion.conversion_unit
     *
     * @mbggenerated Mon Jul 27 08:50:25 ICT 2015
     */
    private String conversionUnit;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_conversion.item_id
     *
     * @return the value of item_conversion.item_id
     *
     * @mbggenerated Mon Jul 27 08:50:25 ICT 2015
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_conversion.item_id
     *
     * @param itemId the value for item_conversion.item_id
     *
     * @mbggenerated Mon Jul 27 08:50:25 ICT 2015
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_conversion.conversion_unit
     *
     * @return the value of item_conversion.conversion_unit
     *
     * @mbggenerated Mon Jul 27 08:50:25 ICT 2015
     */
    public String getConversionUnit() {
        return conversionUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_conversion.conversion_unit
     *
     * @param conversionUnit the value for item_conversion.conversion_unit
     *
     * @mbggenerated Mon Jul 27 08:50:25 ICT 2015
     */
    public void setConversionUnit(String conversionUnit) {
        this.conversionUnit = conversionUnit;
    }
}