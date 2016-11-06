package com.healthcare.db.model;

import java.util.ArrayList;
import java.util.List;

public class ItemExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public ItemExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
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

		public Criteria andItemIdIsNull() {
			addCriterion("item_id is null");
			return (Criteria) this;
		}

		public Criteria andItemIdIsNotNull() {
			addCriterion("item_id is not null");
			return (Criteria) this;
		}

		public Criteria andItemIdEqualTo(Integer value) {
			addCriterion("item_id =", value, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdNotEqualTo(Integer value) {
			addCriterion("item_id <>", value, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdGreaterThan(Integer value) {
			addCriterion("item_id >", value, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("item_id >=", value, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdLessThan(Integer value) {
			addCriterion("item_id <", value, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdLessThanOrEqualTo(Integer value) {
			addCriterion("item_id <=", value, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdIn(List<Integer> values) {
			addCriterion("item_id in", values, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdNotIn(List<Integer> values) {
			addCriterion("item_id not in", values, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdBetween(Integer value1, Integer value2) {
			addCriterion("item_id between", value1, value2, "itemId");
			return (Criteria) this;
		}

		public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
			addCriterion("item_id not between", value1, value2, "itemId");
			return (Criteria) this;
		}

		public Criteria andTrIdIsNull() {
			addCriterion("tr_id is null");
			return (Criteria) this;
		}

		public Criteria andTrIdIsNotNull() {
			addCriterion("tr_id is not null");
			return (Criteria) this;
		}

		public Criteria andTrIdEqualTo(Integer value) {
			addCriterion("tr_id =", value, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdNotEqualTo(Integer value) {
			addCriterion("tr_id <>", value, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdGreaterThan(Integer value) {
			addCriterion("tr_id >", value, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("tr_id >=", value, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdLessThan(Integer value) {
			addCriterion("tr_id <", value, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdLessThanOrEqualTo(Integer value) {
			addCriterion("tr_id <=", value, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdIn(List<Integer> values) {
			addCriterion("tr_id in", values, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdNotIn(List<Integer> values) {
			addCriterion("tr_id not in", values, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdBetween(Integer value1, Integer value2) {
			addCriterion("tr_id between", value1, value2, "trId");
			return (Criteria) this;
		}

		public Criteria andTrIdNotBetween(Integer value1, Integer value2) {
			addCriterion("tr_id not between", value1, value2, "trId");
			return (Criteria) this;
		}

		public Criteria andItemNameIsNull() {
			addCriterion("item_name is null");
			return (Criteria) this;
		}

		public Criteria andItemNameIsNotNull() {
			addCriterion("item_name is not null");
			return (Criteria) this;
		}

		public Criteria andItemNameEqualTo(String value) {
			addCriterion("item_name =", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameNotEqualTo(String value) {
			addCriterion("item_name <>", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameGreaterThan(String value) {
			addCriterion("item_name >", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameGreaterThanOrEqualTo(String value) {
			addCriterion("item_name >=", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameLessThan(String value) {
			addCriterion("item_name <", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameLessThanOrEqualTo(String value) {
			addCriterion("item_name <=", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameLike(String value) {
			addCriterion("item_name like", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameNotLike(String value) {
			addCriterion("item_name not like", value, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameIn(List<String> values) {
			addCriterion("item_name in", values, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameNotIn(List<String> values) {
			addCriterion("item_name not in", values, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameBetween(String value1, String value2) {
			addCriterion("item_name between", value1, value2, "itemName");
			return (Criteria) this;
		}

		public Criteria andItemNameNotBetween(String value1, String value2) {
			addCriterion("item_name not between", value1, value2, "itemName");
			return (Criteria) this;
		}

		public Criteria andUnitIsNull() {
			addCriterion("unit is null");
			return (Criteria) this;
		}

		public Criteria andUnitIsNotNull() {
			addCriterion("unit is not null");
			return (Criteria) this;
		}

		public Criteria andUnitEqualTo(String value) {
			addCriterion("unit =", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotEqualTo(String value) {
			addCriterion("unit <>", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThan(String value) {
			addCriterion("unit >", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThanOrEqualTo(String value) {
			addCriterion("unit >=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThan(String value) {
			addCriterion("unit <", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThanOrEqualTo(String value) {
			addCriterion("unit <=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLike(String value) {
			addCriterion("unit like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotLike(String value) {
			addCriterion("unit not like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitIn(List<String> values) {
			addCriterion("unit in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotIn(List<String> values) {
			addCriterion("unit not in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitBetween(String value1, String value2) {
			addCriterion("unit between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotBetween(String value1, String value2) {
			addCriterion("unit not between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andItemDescIsNull() {
			addCriterion("item_desc is null");
			return (Criteria) this;
		}

		public Criteria andItemDescIsNotNull() {
			addCriterion("item_desc is not null");
			return (Criteria) this;
		}

		public Criteria andItemDescEqualTo(String value) {
			addCriterion("item_desc =", value, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescNotEqualTo(String value) {
			addCriterion("item_desc <>", value, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescGreaterThan(String value) {
			addCriterion("item_desc >", value, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescGreaterThanOrEqualTo(String value) {
			addCriterion("item_desc >=", value, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescLessThan(String value) {
			addCriterion("item_desc <", value, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescLessThanOrEqualTo(String value) {
			addCriterion("item_desc <=", value, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescLike(String value) {
			addCriterion("item_desc like", value, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescNotLike(String value) {
			addCriterion("item_desc not like", value, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescIn(List<String> values) {
			addCriterion("item_desc in", values, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescNotIn(List<String> values) {
			addCriterion("item_desc not in", values, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescBetween(String value1, String value2) {
			addCriterion("item_desc between", value1, value2, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andItemDescNotBetween(String value1, String value2) {
			addCriterion("item_desc not between", value1, value2, "itemDesc");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdIsNull() {
			addCriterion("specimen_id is null");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdIsNotNull() {
			addCriterion("specimen_id is not null");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdEqualTo(Integer value) {
			addCriterion("specimen_id =", value, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdNotEqualTo(Integer value) {
			addCriterion("specimen_id <>", value, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdGreaterThan(Integer value) {
			addCriterion("specimen_id >", value, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("specimen_id >=", value, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdLessThan(Integer value) {
			addCriterion("specimen_id <", value, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdLessThanOrEqualTo(Integer value) {
			addCriterion("specimen_id <=", value, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdIn(List<Integer> values) {
			addCriterion("specimen_id in", values, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdNotIn(List<Integer> values) {
			addCriterion("specimen_id not in", values, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdBetween(Integer value1, Integer value2) {
			addCriterion("specimen_id between", value1, value2, "specimenId");
			return (Criteria) this;
		}

		public Criteria andSpecimenIdNotBetween(Integer value1, Integer value2) {
			addCriterion("specimen_id not between", value1, value2,
					"specimenId");
			return (Criteria) this;
		}

		public Criteria andTgIdIsNull() {
			addCriterion("tg_id is null");
			return (Criteria) this;
		}

		public Criteria andTgIdIsNotNull() {
			addCriterion("tg_id is not null");
			return (Criteria) this;
		}

		public Criteria andTgIdEqualTo(Integer value) {
			addCriterion("tg_id =", value, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdNotEqualTo(Integer value) {
			addCriterion("tg_id <>", value, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdGreaterThan(Integer value) {
			addCriterion("tg_id >", value, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("tg_id >=", value, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdLessThan(Integer value) {
			addCriterion("tg_id <", value, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdLessThanOrEqualTo(Integer value) {
			addCriterion("tg_id <=", value, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdIn(List<Integer> values) {
			addCriterion("tg_id in", values, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdNotIn(List<Integer> values) {
			addCriterion("tg_id not in", values, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdBetween(Integer value1, Integer value2) {
			addCriterion("tg_id between", value1, value2, "tgId");
			return (Criteria) this;
		}

		public Criteria andTgIdNotBetween(Integer value1, Integer value2) {
			addCriterion("tg_id not between", value1, value2, "tgId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table item
	 * @mbggenerated  Wed Nov 19 08:31:17 ICT 2014
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
     * This class corresponds to the database table item
     *
     * @mbggenerated do_not_delete_during_merge Mon Sep 22 15:23:07 ICT 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}