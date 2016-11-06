package com.healthcare.db.client;

import com.healthcare.db.model.IqmDatasetItem;
import com.healthcare.db.model.IqmDatasetItemExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IqmDatasetItemMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int countByExample(IqmDatasetItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int deleteByExample(IqmDatasetItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int deleteByPrimaryKey(Integer resultItemId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int insert(IqmDatasetItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int insertSelective(IqmDatasetItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	List<IqmDatasetItem> selectByExample(IqmDatasetItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	IqmDatasetItem selectByPrimaryKey(Integer resultItemId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int updateByExampleSelective(@Param("record") IqmDatasetItem record,
			@Param("example") IqmDatasetItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int updateByExample(@Param("record") IqmDatasetItem record,
			@Param("example") IqmDatasetItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int updateByPrimaryKeySelective(IqmDatasetItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	int updateByPrimaryKey(IqmDatasetItem record);
	
	int createTable(IqmDatasetItemExample example);
    
    List<String> showTable(IqmDatasetItemExample example );
}