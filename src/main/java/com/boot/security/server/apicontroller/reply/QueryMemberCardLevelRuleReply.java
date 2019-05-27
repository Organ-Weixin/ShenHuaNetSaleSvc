package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryMemberCardLevelRuleReply extends BaseReply{
	private QueryMemberCardLevelRuleReplyMemberCard data;

	public QueryMemberCardLevelRuleReplyMemberCard getData() {
		return data;
	}

	public void setData(QueryMemberCardLevelRuleReplyMemberCard data) {
		this.data = data;
	}
	public static class QueryMemberCardLevelRuleReplyMemberCard{
		private String CinemaCode;
		private String LevelCode;
		private String LevelName;
		private List<QueryMemberCardLevelRuleReplyMemberCardRule> Rule;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getLevelCode() {
			return LevelCode;
		}
		public void setLevelCode(String levelCode) {
			LevelCode = levelCode;
		}
		public String getLevelName() {
			return LevelName;
		}
		public void setLevelName(String levelName) {
			LevelName = levelName;
		}
		public List<QueryMemberCardLevelRuleReplyMemberCardRule> getRule() {
			return Rule;
		}
		public void setRule(List<QueryMemberCardLevelRuleReplyMemberCardRule> rule) {
			Rule = rule;
		}
		public static class QueryMemberCardLevelRuleReplyMemberCardRule{
			private String RuleCode;
			private Integer RuleType;
			private Double Credit;
			private Double GivenAmount;
			public String getRuleCode() {
				return RuleCode;
			}
			public void setRuleCode(String ruleCode) {
				RuleCode = ruleCode;
			}
			public Integer getRuleType() {
				return RuleType;
			}
			public void setRuleType(Integer ruleType) {
				RuleType = ruleType;
			}
			public Double getCredit() {
				return Credit;
			}
			public void setCredit(Double credit) {
				Credit = credit;
			}
			public Double getGivenAmount() {
				return GivenAmount;
			}
			public void setGivenAmount(Double givenAmount) {
				GivenAmount = givenAmount;
			}
			
		}
	}
}
