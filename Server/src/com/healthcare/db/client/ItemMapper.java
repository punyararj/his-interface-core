package com.healthcare.db.client;

import com.healthcare.db.model.Item;
import com.healthcare.db.model.ItemExample;
import com.healthcare.db.model.ItemWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int countByExample(ItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int deleteByExample(ItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int deleteByPrimaryKey(Integer itemId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int insert(Item record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int insertSelective(Item record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	List<Item> selectByExample(ItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	Item selectByPrimaryKey(Integer itemId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int updateByExampleSelective(@Param("record") Item record,
			@Param("example") ItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int updateByExample(@Param("record") Item record,
			@Param("example") ItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int updateByPrimaryKeySelective(Item record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Mon Dec 22 13:57:31 ICT 2014
	 */
	int updateByPrimaryKey(Item record);
}