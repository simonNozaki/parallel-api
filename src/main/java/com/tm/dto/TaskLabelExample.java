package com.tm.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskLabelExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public TaskLabelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
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
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
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

        public Criteria andLabelIdIsNull() {
            addCriterion("label_id is null");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNotNull() {
            addCriterion("label_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabelIdEqualTo(String value) {
            addCriterion("label_id =", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotEqualTo(String value) {
            addCriterion("label_id <>", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThan(String value) {
            addCriterion("label_id >", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThanOrEqualTo(String value) {
            addCriterion("label_id >=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThan(String value) {
            addCriterion("label_id <", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThanOrEqualTo(String value) {
            addCriterion("label_id <=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLike(String value) {
            addCriterion("label_id like", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotLike(String value) {
            addCriterion("label_id not like", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdIn(List<String> values) {
            addCriterion("label_id in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotIn(List<String> values) {
            addCriterion("label_id not in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdBetween(String value1, String value2) {
            addCriterion("label_id between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotBetween(String value1, String value2) {
            addCriterion("label_id not between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andTaskLabelIsNull() {
            addCriterion("task_label is null");
            return (Criteria) this;
        }

        public Criteria andTaskLabelIsNotNull() {
            addCriterion("task_label is not null");
            return (Criteria) this;
        }

        public Criteria andTaskLabelEqualTo(String value) {
            addCriterion("task_label =", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelNotEqualTo(String value) {
            addCriterion("task_label <>", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelGreaterThan(String value) {
            addCriterion("task_label >", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelGreaterThanOrEqualTo(String value) {
            addCriterion("task_label >=", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelLessThan(String value) {
            addCriterion("task_label <", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelLessThanOrEqualTo(String value) {
            addCriterion("task_label <=", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelLike(String value) {
            addCriterion("task_label like", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelNotLike(String value) {
            addCriterion("task_label not like", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelIn(List<String> values) {
            addCriterion("task_label in", values, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelNotIn(List<String> values) {
            addCriterion("task_label not in", values, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelBetween(String value1, String value2) {
            addCriterion("task_label between", value1, value2, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelNotBetween(String value1, String value2) {
            addCriterion("task_label not between", value1, value2, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andUsedFlagIsNull() {
            addCriterion("used_flag is null");
            return (Criteria) this;
        }

        public Criteria andUsedFlagIsNotNull() {
            addCriterion("used_flag is not null");
            return (Criteria) this;
        }

        public Criteria andUsedFlagEqualTo(String value) {
            addCriterion("used_flag =", value, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagNotEqualTo(String value) {
            addCriterion("used_flag <>", value, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagGreaterThan(String value) {
            addCriterion("used_flag >", value, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagGreaterThanOrEqualTo(String value) {
            addCriterion("used_flag >=", value, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagLessThan(String value) {
            addCriterion("used_flag <", value, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagLessThanOrEqualTo(String value) {
            addCriterion("used_flag <=", value, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagLike(String value) {
            addCriterion("used_flag like", value, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagNotLike(String value) {
            addCriterion("used_flag not like", value, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagIn(List<String> values) {
            addCriterion("used_flag in", values, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagNotIn(List<String> values) {
            addCriterion("used_flag not in", values, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagBetween(String value1, String value2) {
            addCriterion("used_flag between", value1, value2, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUsedFlagNotBetween(String value1, String value2) {
            addCriterion("used_flag not between", value1, value2, "usedFlag");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_label
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 24 09:20:46 JST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_label
     *
     * @mbg.generated Mon Dec 24 09:20:46 JST 2018
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