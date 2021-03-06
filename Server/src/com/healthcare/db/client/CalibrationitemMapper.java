package com.healthcare.db.client;

import com.healthcare.db.model.Qcitem;
import com.healthcare.db.model.QcitemExample;
import com.healthcare.db.model.QcitemKey;
import com.healthcare.db.model.TestitemExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.healthcare.db.model.Calibrationitem;
import com.healthcare.db.model.CalibrationitemExample;
import com.healthcare.db.model.CalibrationitemKey;

public interface CalibrationitemMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int countByExample(CalibrationitemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int deleteByExample(CalibrationitemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int deleteByPrimaryKey(CalibrationitemKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int insert(Calibrationitem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int insertSelective(Calibrationitem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	List<Calibrationitem> selectByExample(CalibrationitemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	Calibrationitem selectByPrimaryKey(CalibrationitemKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int updateByExampleSelective(@Param("record") Calibrationitem record,
			@Param("example") CalibrationitemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int updateByExample(@Param("record") Calibrationitem record,
			@Param("example") CalibrationitemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int updateByPrimaryKeySelective(Calibrationitem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table calibrationitem
	 * @mbggenerated  Mon Jul 27 06:12:59 ICT 2015
	 */
	int updateByPrimaryKey(Calibrationitem record);

	int createTable(CalibrationitemExample example);
    
    List<String> showTable(CalibrationitemExample example );
    
}