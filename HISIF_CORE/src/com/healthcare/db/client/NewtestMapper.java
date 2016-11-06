package com.healthcare.db.client;

import com.healthcare.db.model.Newtest;
import com.healthcare.db.model.NewtestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

public interface NewtestMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int countByExample(NewtestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int deleteByExample(NewtestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int deleteByPrimaryKey(Integer testId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int insert(Newtest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	@SelectKey(statement="call next value for TestSequence", keyProperty="testId", before=true, resultType=int.class)
	int insertSelective(Newtest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	List<Newtest> selectByExampleWithBLOBs(NewtestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	List<Newtest> selectByExample(NewtestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	Newtest selectByPrimaryKey(Integer testId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int updateByExampleSelective(@Param("record") Newtest record,
			@Param("example") NewtestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int updateByExampleWithBLOBs(@Param("record") Newtest record,
			@Param("example") NewtestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int updateByExample(@Param("record") Newtest record,
			@Param("example") NewtestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int updateByPrimaryKeySelective(Newtest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int updateByPrimaryKeyWithBLOBs(Newtest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table newtest
	 * @mbggenerated  Tue Apr 01 20:15:29 ICT 2014
	 */
	int updateByPrimaryKey(Newtest record);
}