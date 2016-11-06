package com.healthcare.db.client;

import com.healthcare.db.model.Itemmapping;
import com.healthcare.db.model.ItemmappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemmappingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table itemmapping
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    int countByExample(ItemmappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table itemmapping
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    int deleteByExample(ItemmappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table itemmapping
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    int insert(Itemmapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table itemmapping
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    int insertSelective(Itemmapping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table itemmapping
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    List<Itemmapping> selectByExample(ItemmappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table itemmapping
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    int updateByExampleSelective(@Param("record") Itemmapping record, @Param("example") ItemmappingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table itemmapping
     *
     * @mbggenerated Mon Sep 22 09:48:39 ICT 2014
     */
    int updateByExample(@Param("record") Itemmapping record, @Param("example") ItemmappingExample example);
}