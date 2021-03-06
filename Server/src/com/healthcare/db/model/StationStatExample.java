package com.healthcare.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StationStatExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public StationStatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAnalyzerIdIsNull() {
            addCriterion("analyzer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdIsNotNull() {
            addCriterion("analyzer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdEqualTo(Integer value) {
            addCriterion("analyzer_id =", value, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdNotEqualTo(Integer value) {
            addCriterion("analyzer_id <>", value, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdGreaterThan(Integer value) {
            addCriterion("analyzer_id >", value, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("analyzer_id >=", value, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdLessThan(Integer value) {
            addCriterion("analyzer_id <", value, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdLessThanOrEqualTo(Integer value) {
            addCriterion("analyzer_id <=", value, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdIn(List<Integer> values) {
            addCriterion("analyzer_id in", values, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdNotIn(List<Integer> values) {
            addCriterion("analyzer_id not in", values, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdBetween(Integer value1, Integer value2) {
            addCriterion("analyzer_id between", value1, value2, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andAnalyzerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("analyzer_id not between", value1, value2, "analyzerId");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodIsNull() {
            addCriterion("tracking_method is null");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodIsNotNull() {
            addCriterion("tracking_method is not null");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodEqualTo(String value) {
            addCriterion("tracking_method =", value, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodNotEqualTo(String value) {
            addCriterion("tracking_method <>", value, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodGreaterThan(String value) {
            addCriterion("tracking_method >", value, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodGreaterThanOrEqualTo(String value) {
            addCriterion("tracking_method >=", value, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodLessThan(String value) {
            addCriterion("tracking_method <", value, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodLessThanOrEqualTo(String value) {
            addCriterion("tracking_method <=", value, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodLike(String value) {
            addCriterion("tracking_method like", value, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodNotLike(String value) {
            addCriterion("tracking_method not like", value, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodIn(List<String> values) {
            addCriterion("tracking_method in", values, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodNotIn(List<String> values) {
            addCriterion("tracking_method not in", values, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodBetween(String value1, String value2) {
            addCriterion("tracking_method between", value1, value2, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingMethodNotBetween(String value1, String value2) {
            addCriterion("tracking_method not between", value1, value2, "trackingMethod");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeIsNull() {
            addCriterion("tracking_status_code is null");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeIsNotNull() {
            addCriterion("tracking_status_code is not null");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeEqualTo(Integer value) {
            addCriterion("tracking_status_code =", value, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeNotEqualTo(Integer value) {
            addCriterion("tracking_status_code <>", value, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeGreaterThan(Integer value) {
            addCriterion("tracking_status_code >", value, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tracking_status_code >=", value, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeLessThan(Integer value) {
            addCriterion("tracking_status_code <", value, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeLessThanOrEqualTo(Integer value) {
            addCriterion("tracking_status_code <=", value, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeIn(List<Integer> values) {
            addCriterion("tracking_status_code in", values, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeNotIn(List<Integer> values) {
            addCriterion("tracking_status_code not in", values, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeBetween(Integer value1, Integer value2) {
            addCriterion("tracking_status_code between", value1, value2, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrackingStatusCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("tracking_status_code not between", value1, value2, "trackingStatusCode");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andClientSourceIsNull() {
            addCriterion("client_source is null");
            return (Criteria) this;
        }

        public Criteria andClientSourceIsNotNull() {
            addCriterion("client_source is not null");
            return (Criteria) this;
        }

        public Criteria andClientSourceEqualTo(String value) {
            addCriterion("client_source =", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceNotEqualTo(String value) {
            addCriterion("client_source <>", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceGreaterThan(String value) {
            addCriterion("client_source >", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceGreaterThanOrEqualTo(String value) {
            addCriterion("client_source >=", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceLessThan(String value) {
            addCriterion("client_source <", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceLessThanOrEqualTo(String value) {
            addCriterion("client_source <=", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceLike(String value) {
            addCriterion("client_source like", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceNotLike(String value) {
            addCriterion("client_source not like", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceIn(List<String> values) {
            addCriterion("client_source in", values, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceNotIn(List<String> values) {
            addCriterion("client_source not in", values, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceBetween(String value1, String value2) {
            addCriterion("client_source between", value1, value2, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceNotBetween(String value1, String value2) {
            addCriterion("client_source not between", value1, value2, "clientSource");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table station_stat
     *
     * @mbggenerated do_not_delete_during_merge Sun Dec 21 23:30:03 ICT 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table station_stat
     *
     * @mbggenerated Sun Dec 21 23:30:03 ICT 2014
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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
}