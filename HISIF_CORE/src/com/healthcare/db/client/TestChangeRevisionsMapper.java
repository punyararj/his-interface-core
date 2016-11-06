package com.healthcare.db.client;

import com.healthcare.db.model.TestChangeRevisions;
import com.healthcare.db.model.TestChangeRevisionsExample;
import com.healthcare.db.model.TestChangeRevisionsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestChangeRevisionsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int countByExample(TestChangeRevisionsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int deleteByExample(TestChangeRevisionsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int deleteByPrimaryKey(TestChangeRevisionsKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int insert(TestChangeRevisions record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int insertSelective(TestChangeRevisions record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	List<TestChangeRevisions> selectByExampleWithBLOBs(
			TestChangeRevisionsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	List<TestChangeRevisions> selectByExample(TestChangeRevisionsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	TestChangeRevisions selectByPrimaryKey(TestChangeRevisionsKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int updateByExampleSelective(@Param("record") TestChangeRevisions record,
			@Param("example") TestChangeRevisionsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int updateByExampleWithBLOBs(@Param("record") TestChangeRevisions record,
			@Param("example") TestChangeRevisionsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int updateByExample(@Param("record") TestChangeRevisions record,
			@Param("example") TestChangeRevisionsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int updateByPrimaryKeySelective(TestChangeRevisions record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int updateByPrimaryKeyWithBLOBs(TestChangeRevisions record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_change_revisions
	 * @mbggenerated  Tue Dec 15 00:20:16 ICT 2015
	 */
	int updateByPrimaryKey(TestChangeRevisions record);
}