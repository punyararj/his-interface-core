package com.healthcare.db.model;

import java.util.ArrayList;
import java.util.List;

public class LotExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public LotExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
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

		public Criteria andLotIdIsNull() {
			addCriterion("lot_id is null");
			return (Criteria) this;
		}

		public Criteria andLotIdIsNotNull() {
			addCriterion("lot_id is not null");
			return (Criteria) this;
		}

		public Criteria andLotIdEqualTo(Integer value) {
			addCriterion("lot_id =", value, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdNotEqualTo(Integer value) {
			addCriterion("lot_id <>", value, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdGreaterThan(Integer value) {
			addCriterion("lot_id >", value, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("lot_id >=", value, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdLessThan(Integer value) {
			addCriterion("lot_id <", value, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdLessThanOrEqualTo(Integer value) {
			addCriterion("lot_id <=", value, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdIn(List<Integer> values) {
			addCriterion("lot_id in", values, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdNotIn(List<Integer> values) {
			addCriterion("lot_id not in", values, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdBetween(Integer value1, Integer value2) {
			addCriterion("lot_id between", value1, value2, "lotId");
			return (Criteria) this;
		}

		public Criteria andLotIdNotBetween(Integer value1, Integer value2) {
			addCriterion("lot_id not between", value1, value2, "lotId");
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

		public Criteria andLotNoIsNull() {
			addCriterion("lot_no is null");
			return (Criteria) this;
		}

		public Criteria andLotNoIsNotNull() {
			addCriterion("lot_no is not null");
			return (Criteria) this;
		}

		public Criteria andLotNoEqualTo(String value) {
			addCriterion("lot_no =", value, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoNotEqualTo(String value) {
			addCriterion("lot_no <>", value, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoGreaterThan(String value) {
			addCriterion("lot_no >", value, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoGreaterThanOrEqualTo(String value) {
			addCriterion("lot_no >=", value, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoLessThan(String value) {
			addCriterion("lot_no <", value, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoLessThanOrEqualTo(String value) {
			addCriterion("lot_no <=", value, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoLike(String value) {
			addCriterion("lot_no like", value, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoNotLike(String value) {
			addCriterion("lot_no not like", value, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoIn(List<String> values) {
			addCriterion("lot_no in", values, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoNotIn(List<String> values) {
			addCriterion("lot_no not in", values, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoBetween(String value1, String value2) {
			addCriterion("lot_no between", value1, value2, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotNoNotBetween(String value1, String value2) {
			addCriterion("lot_no not between", value1, value2, "lotNo");
			return (Criteria) this;
		}

		public Criteria andLotMaterialIsNull() {
			addCriterion("lot_material is null");
			return (Criteria) this;
		}

		public Criteria andLotMaterialIsNotNull() {
			addCriterion("lot_material is not null");
			return (Criteria) this;
		}

		public Criteria andLotMaterialEqualTo(String value) {
			addCriterion("lot_material =", value, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialNotEqualTo(String value) {
			addCriterion("lot_material <>", value, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialGreaterThan(String value) {
			addCriterion("lot_material >", value, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialGreaterThanOrEqualTo(String value) {
			addCriterion("lot_material >=", value, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialLessThan(String value) {
			addCriterion("lot_material <", value, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialLessThanOrEqualTo(String value) {
			addCriterion("lot_material <=", value, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialLike(String value) {
			addCriterion("lot_material like", value, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialNotLike(String value) {
			addCriterion("lot_material not like", value, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialIn(List<String> values) {
			addCriterion("lot_material in", values, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialNotIn(List<String> values) {
			addCriterion("lot_material not in", values, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialBetween(String value1, String value2) {
			addCriterion("lot_material between", value1, value2, "lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotMaterialNotBetween(String value1, String value2) {
			addCriterion("lot_material not between", value1, value2,
					"lotMaterial");
			return (Criteria) this;
		}

		public Criteria andLotLvIsNull() {
			addCriterion("lot_lv is null");
			return (Criteria) this;
		}

		public Criteria andLotLvIsNotNull() {
			addCriterion("lot_lv is not null");
			return (Criteria) this;
		}

		public Criteria andLotLvEqualTo(Integer value) {
			addCriterion("lot_lv =", value, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvNotEqualTo(Integer value) {
			addCriterion("lot_lv <>", value, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvGreaterThan(Integer value) {
			addCriterion("lot_lv >", value, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvGreaterThanOrEqualTo(Integer value) {
			addCriterion("lot_lv >=", value, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvLessThan(Integer value) {
			addCriterion("lot_lv <", value, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvLessThanOrEqualTo(Integer value) {
			addCriterion("lot_lv <=", value, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvIn(List<Integer> values) {
			addCriterion("lot_lv in", values, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvNotIn(List<Integer> values) {
			addCriterion("lot_lv not in", values, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvBetween(Integer value1, Integer value2) {
			addCriterion("lot_lv between", value1, value2, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotLvNotBetween(Integer value1, Integer value2) {
			addCriterion("lot_lv not between", value1, value2, "lotLv");
			return (Criteria) this;
		}

		public Criteria andLotCuvettIsNull() {
			addCriterion("lot_cuvett is null");
			return (Criteria) this;
		}

		public Criteria andLotCuvettIsNotNull() {
			addCriterion("lot_cuvett is not null");
			return (Criteria) this;
		}

		public Criteria andLotCuvettEqualTo(String value) {
			addCriterion("lot_cuvett =", value, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettNotEqualTo(String value) {
			addCriterion("lot_cuvett <>", value, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettGreaterThan(String value) {
			addCriterion("lot_cuvett >", value, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettGreaterThanOrEqualTo(String value) {
			addCriterion("lot_cuvett >=", value, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettLessThan(String value) {
			addCriterion("lot_cuvett <", value, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettLessThanOrEqualTo(String value) {
			addCriterion("lot_cuvett <=", value, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettLike(String value) {
			addCriterion("lot_cuvett like", value, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettNotLike(String value) {
			addCriterion("lot_cuvett not like", value, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettIn(List<String> values) {
			addCriterion("lot_cuvett in", values, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettNotIn(List<String> values) {
			addCriterion("lot_cuvett not in", values, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettBetween(String value1, String value2) {
			addCriterion("lot_cuvett between", value1, value2, "lotCuvett");
			return (Criteria) this;
		}

		public Criteria andLotCuvettNotBetween(String value1, String value2) {
			addCriterion("lot_cuvett not between", value1, value2, "lotCuvett");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table lot
	 * @mbggenerated  Tue Jun 16 03:39:42 ICT 2015
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
     * This class corresponds to the database table lot
     *
     * @mbggenerated do_not_delete_during_merge Tue Apr 01 16:59:43 ICT 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}