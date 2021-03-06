package com.healthcare.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IqmDatasetItemExample {
	
	protected String tableName;

	
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public IqmDatasetItemExample(String tableName) {
		this.tableName = tableName;
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()),
					property);
		}

		protected void addCriterionForJDBCDate(String condition,
				List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1,
				Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()),
					new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andResultItemIdIsNull() {
			addCriterion("result_item_id is null");
			return (Criteria) this;
		}

		public Criteria andResultItemIdIsNotNull() {
			addCriterion("result_item_id is not null");
			return (Criteria) this;
		}

		public Criteria andResultItemIdEqualTo(Integer value) {
			addCriterion("result_item_id =", value, "resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdNotEqualTo(Integer value) {
			addCriterion("result_item_id <>", value, "resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdGreaterThan(Integer value) {
			addCriterion("result_item_id >", value, "resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("result_item_id >=", value, "resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdLessThan(Integer value) {
			addCriterion("result_item_id <", value, "resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdLessThanOrEqualTo(Integer value) {
			addCriterion("result_item_id <=", value, "resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdIn(List<Integer> values) {
			addCriterion("result_item_id in", values, "resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdNotIn(List<Integer> values) {
			addCriterion("result_item_id not in", values, "resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdBetween(Integer value1, Integer value2) {
			addCriterion("result_item_id between", value1, value2,
					"resultItemId");
			return (Criteria) this;
		}

		public Criteria andResultItemIdNotBetween(Integer value1, Integer value2) {
			addCriterion("result_item_id not between", value1, value2,
					"resultItemId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdIsNull() {
			addCriterion("iqm_data_set_id is null");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdIsNotNull() {
			addCriterion("iqm_data_set_id is not null");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdEqualTo(Integer value) {
			addCriterion("iqm_data_set_id =", value, "iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdNotEqualTo(Integer value) {
			addCriterion("iqm_data_set_id <>", value, "iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdGreaterThan(Integer value) {
			addCriterion("iqm_data_set_id >", value, "iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("iqm_data_set_id >=", value, "iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdLessThan(Integer value) {
			addCriterion("iqm_data_set_id <", value, "iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdLessThanOrEqualTo(Integer value) {
			addCriterion("iqm_data_set_id <=", value, "iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdIn(List<Integer> values) {
			addCriterion("iqm_data_set_id in", values, "iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdNotIn(List<Integer> values) {
			addCriterion("iqm_data_set_id not in", values, "iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdBetween(Integer value1, Integer value2) {
			addCriterion("iqm_data_set_id between", value1, value2,
					"iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andIqmDataSetIdNotBetween(Integer value1, Integer value2) {
			addCriterion("iqm_data_set_id not between", value1, value2,
					"iqmDataSetId");
			return (Criteria) this;
		}

		public Criteria andTestDateIsNull() {
			addCriterion("test_date is null");
			return (Criteria) this;
		}

		public Criteria andTestDateIsNotNull() {
			addCriterion("test_date is not null");
			return (Criteria) this;
		}

		public Criteria andTestDateEqualTo(Date value) {
			addCriterionForJDBCDate("test_date =", value, "testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("test_date <>", value, "testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateGreaterThan(Date value) {
			addCriterionForJDBCDate("test_date >", value, "testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("test_date >=", value, "testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateLessThan(Date value) {
			addCriterionForJDBCDate("test_date <", value, "testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("test_date <=", value, "testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateIn(List<Date> values) {
			addCriterionForJDBCDate("test_date in", values, "testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("test_date not in", values, "testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("test_date between", value1, value2,
					"testDate");
			return (Criteria) this;
		}

		public Criteria andTestDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("test_date not between", value1, value2,
					"testDate");
			return (Criteria) this;
		}

		public Criteria andTestCountIsNull() {
			addCriterion("test_count is null");
			return (Criteria) this;
		}

		public Criteria andTestCountIsNotNull() {
			addCriterion("test_count is not null");
			return (Criteria) this;
		}

		public Criteria andTestCountEqualTo(Integer value) {
			addCriterion("test_count =", value, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountNotEqualTo(Integer value) {
			addCriterion("test_count <>", value, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountGreaterThan(Integer value) {
			addCriterion("test_count >", value, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("test_count >=", value, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountLessThan(Integer value) {
			addCriterion("test_count <", value, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountLessThanOrEqualTo(Integer value) {
			addCriterion("test_count <=", value, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountIn(List<Integer> values) {
			addCriterion("test_count in", values, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountNotIn(List<Integer> values) {
			addCriterion("test_count not in", values, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountBetween(Integer value1, Integer value2) {
			addCriterion("test_count between", value1, value2, "testCount");
			return (Criteria) this;
		}

		public Criteria andTestCountNotBetween(Integer value1, Integer value2) {
			addCriterion("test_count not between", value1, value2, "testCount");
			return (Criteria) this;
		}

		public Criteria andResultAIsNull() {
			addCriterion("result_a is null");
			return (Criteria) this;
		}

		public Criteria andResultAIsNotNull() {
			addCriterion("result_a is not null");
			return (Criteria) this;
		}

		public Criteria andResultAEqualTo(Double value) {
			addCriterion("result_a =", value, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultANotEqualTo(Double value) {
			addCriterion("result_a <>", value, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultAGreaterThan(Double value) {
			addCriterion("result_a >", value, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultAGreaterThanOrEqualTo(Double value) {
			addCriterion("result_a >=", value, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultALessThan(Double value) {
			addCriterion("result_a <", value, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultALessThanOrEqualTo(Double value) {
			addCriterion("result_a <=", value, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultAIn(List<Double> values) {
			addCriterion("result_a in", values, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultANotIn(List<Double> values) {
			addCriterion("result_a not in", values, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultABetween(Double value1, Double value2) {
			addCriterion("result_a between", value1, value2, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultANotBetween(Double value1, Double value2) {
			addCriterion("result_a not between", value1, value2, "resultA");
			return (Criteria) this;
		}

		public Criteria andResultBIsNull() {
			addCriterion("result_b is null");
			return (Criteria) this;
		}

		public Criteria andResultBIsNotNull() {
			addCriterion("result_b is not null");
			return (Criteria) this;
		}

		public Criteria andResultBEqualTo(Double value) {
			addCriterion("result_b =", value, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBNotEqualTo(Double value) {
			addCriterion("result_b <>", value, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBGreaterThan(Double value) {
			addCriterion("result_b >", value, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBGreaterThanOrEqualTo(Double value) {
			addCriterion("result_b >=", value, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBLessThan(Double value) {
			addCriterion("result_b <", value, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBLessThanOrEqualTo(Double value) {
			addCriterion("result_b <=", value, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBIn(List<Double> values) {
			addCriterion("result_b in", values, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBNotIn(List<Double> values) {
			addCriterion("result_b not in", values, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBBetween(Double value1, Double value2) {
			addCriterion("result_b between", value1, value2, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultBNotBetween(Double value1, Double value2) {
			addCriterion("result_b not between", value1, value2, "resultB");
			return (Criteria) this;
		}

		public Criteria andResultCIsNull() {
			addCriterion("result_c is null");
			return (Criteria) this;
		}

		public Criteria andResultCIsNotNull() {
			addCriterion("result_c is not null");
			return (Criteria) this;
		}

		public Criteria andResultCEqualTo(Double value) {
			addCriterion("result_c =", value, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCNotEqualTo(Double value) {
			addCriterion("result_c <>", value, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCGreaterThan(Double value) {
			addCriterion("result_c >", value, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCGreaterThanOrEqualTo(Double value) {
			addCriterion("result_c >=", value, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCLessThan(Double value) {
			addCriterion("result_c <", value, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCLessThanOrEqualTo(Double value) {
			addCriterion("result_c <=", value, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCIn(List<Double> values) {
			addCriterion("result_c in", values, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCNotIn(List<Double> values) {
			addCriterion("result_c not in", values, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCBetween(Double value1, Double value2) {
			addCriterion("result_c between", value1, value2, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultCNotBetween(Double value1, Double value2) {
			addCriterion("result_c not between", value1, value2, "resultC");
			return (Criteria) this;
		}

		public Criteria andResultDIsNull() {
			addCriterion("result_d is null");
			return (Criteria) this;
		}

		public Criteria andResultDIsNotNull() {
			addCriterion("result_d is not null");
			return (Criteria) this;
		}

		public Criteria andResultDEqualTo(Double value) {
			addCriterion("result_d =", value, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDNotEqualTo(Double value) {
			addCriterion("result_d <>", value, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDGreaterThan(Double value) {
			addCriterion("result_d >", value, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDGreaterThanOrEqualTo(Double value) {
			addCriterion("result_d >=", value, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDLessThan(Double value) {
			addCriterion("result_d <", value, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDLessThanOrEqualTo(Double value) {
			addCriterion("result_d <=", value, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDIn(List<Double> values) {
			addCriterion("result_d in", values, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDNotIn(List<Double> values) {
			addCriterion("result_d not in", values, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDBetween(Double value1, Double value2) {
			addCriterion("result_d between", value1, value2, "resultD");
			return (Criteria) this;
		}

		public Criteria andResultDNotBetween(Double value1, Double value2) {
			addCriterion("result_d not between", value1, value2, "resultD");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table iqm_dataset_item
	 * @mbggenerated  Wed Oct 15 12:30:42 ICT 2014
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table iqm_dataset_item
     *
     * @mbggenerated do_not_delete_during_merge Thu May 22 14:49:56 ICT 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}