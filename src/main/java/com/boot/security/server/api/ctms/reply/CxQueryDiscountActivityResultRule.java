package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxQueryDiscountActivityResultRule {
	private List<resultBean> results;
	

	public List<resultBean> getResults() {
		return results;
	}

	public void setResults(List<resultBean> results) {
		this.results = results;
	}
	public static class resultBean{
		private String cardLevelCode;
		private String cardLevelName;
		private String featureAppNo;
		private Float price;
		private int ruleId;
		private Float cinemaPayAmount;
		private String ruleGroupName;
		private String ruleName;
		public String getCardLevelCode() {
			return cardLevelCode;
		}
		public void setCardLevelCode(String cardLevelCode) {
			this.cardLevelCode = cardLevelCode;
		}
		public String getCardLevelName() {
			return cardLevelName;
		}
		public void setCardLevelName(String cardLevelName) {
			this.cardLevelName = cardLevelName;
		}
		public String getFeatureAppNo() {
			return featureAppNo;
		}
		public void setFeatureAppNo(String featureAppNo) {
			this.featureAppNo = featureAppNo;
		}
		public Float getPrice() {
			return price;
		}
		public void setPrice(Float price) {
			this.price = price;
		}
		public int getRuleId() {
			return ruleId;
		}
		public void setRuleId(int ruleId) {
			this.ruleId = ruleId;
		}
		public Float getCinemaPayAmount() {
			return cinemaPayAmount;
		}
		public void setCinemaPayAmount(Float cinemaPayAmount) {
			this.cinemaPayAmount = cinemaPayAmount;
		}
		public String getRuleGroupName() {
			return ruleGroupName;
		}
		public void setRuleGroupName(String ruleGroupName) {
			this.ruleGroupName = ruleGroupName;
		}
		public String getRuleName() {
			return ruleName;
		}
		public void setRuleName(String ruleName) {
			this.ruleName = ruleName;
		}
	}
}
