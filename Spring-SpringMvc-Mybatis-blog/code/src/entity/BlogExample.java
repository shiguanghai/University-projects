package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public BlogExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
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

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCategoryidIsNull() {
			addCriterion("categoryId is null");
			return (Criteria) this;
		}

		public Criteria andCategoryidIsNotNull() {
			addCriterion("categoryId is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryidEqualTo(Integer value) {
			addCriterion("categoryId =", value, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidNotEqualTo(Integer value) {
			addCriterion("categoryId <>", value, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidGreaterThan(Integer value) {
			addCriterion("categoryId >", value, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidGreaterThanOrEqualTo(Integer value) {
			addCriterion("categoryId >=", value, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidLessThan(Integer value) {
			addCriterion("categoryId <", value, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidLessThanOrEqualTo(Integer value) {
			addCriterion("categoryId <=", value, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidIn(List<Integer> values) {
			addCriterion("categoryId in", values, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidNotIn(List<Integer> values) {
			addCriterion("categoryId not in", values, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidBetween(Integer value1, Integer value2) {
			addCriterion("categoryId between", value1, value2, "categoryid");
			return (Criteria) this;
		}

		public Criteria andCategoryidNotBetween(Integer value1, Integer value2) {
			addCriterion("categoryId not between", value1, value2, "categoryid");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleintroIsNull() {
			addCriterion("titleIntro is null");
			return (Criteria) this;
		}

		public Criteria andTitleintroIsNotNull() {
			addCriterion("titleIntro is not null");
			return (Criteria) this;
		}

		public Criteria andTitleintroEqualTo(String value) {
			addCriterion("titleIntro =", value, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroNotEqualTo(String value) {
			addCriterion("titleIntro <>", value, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroGreaterThan(String value) {
			addCriterion("titleIntro >", value, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroGreaterThanOrEqualTo(String value) {
			addCriterion("titleIntro >=", value, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroLessThan(String value) {
			addCriterion("titleIntro <", value, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroLessThanOrEqualTo(String value) {
			addCriterion("titleIntro <=", value, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroLike(String value) {
			addCriterion("titleIntro like", value, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroNotLike(String value) {
			addCriterion("titleIntro not like", value, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroIn(List<String> values) {
			addCriterion("titleIntro in", values, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroNotIn(List<String> values) {
			addCriterion("titleIntro not in", values, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroBetween(String value1, String value2) {
			addCriterion("titleIntro between", value1, value2, "titleintro");
			return (Criteria) this;
		}

		public Criteria andTitleintroNotBetween(String value1, String value2) {
			addCriterion("titleIntro not between", value1, value2, "titleintro");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeIsNull() {
			addCriterion("createdtime is null");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeIsNotNull() {
			addCriterion("createdtime is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeEqualTo(Date value) {
			addCriterion("createdtime =", value, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeNotEqualTo(Date value) {
			addCriterion("createdtime <>", value, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeGreaterThan(Date value) {
			addCriterion("createdtime >", value, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeGreaterThanOrEqualTo(Date value) {
			addCriterion("createdtime >=", value, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeLessThan(Date value) {
			addCriterion("createdtime <", value, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeLessThanOrEqualTo(Date value) {
			addCriterion("createdtime <=", value, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeIn(List<Date> values) {
			addCriterion("createdtime in", values, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeNotIn(List<Date> values) {
			addCriterion("createdtime not in", values, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeBetween(Date value1, Date value2) {
			addCriterion("createdtime between", value1, value2, "createdtime");
			return (Criteria) this;
		}

		public Criteria andCreatedtimeNotBetween(Date value1, Date value2) {
			addCriterion("createdtime not between", value1, value2, "createdtime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table blog
	 * @mbg.generated  Fri Dec 29 23:47:01 CST 2017
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 18 10:49:53 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}