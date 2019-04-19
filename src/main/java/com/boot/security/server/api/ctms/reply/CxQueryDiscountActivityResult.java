package com.boot.security.server.api.ctms.reply;

import java.util.List; 

public class CxQueryDiscountActivityResult {
	private ResBean QueryDiscountActivityResult;

	public ResBean getQueryDiscountActivityResult() {
		return QueryDiscountActivityResult;
	}

	public void setQueryDiscountActivityResult(ResBean queryDiscountActivityResult) {
		QueryDiscountActivityResult = queryDiscountActivityResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private RuleBean Rule;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public RuleBean getRule() {
			return Rule;
		}
		public void setRule(RuleBean rule) {
			Rule = rule;
		}
		public static class RuleBean{
			private resultsBean results;

			public resultsBean getResults() {
				return results;
			}

			public void setResults(resultsBean results) {
				this.results = results;
			}
			public static class resultsBean{
				private List<resultBean> result;

				public List<resultBean> getResult() {
					return result;
				}

				public void setResult(List<resultBean> result) {
					this.result = result;
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
			
		}
		
	}

}
