package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryMemberCardLevelReply extends BaseReply{
	private QueryMemberCardLevelReplyMemberCard data;

	public QueryMemberCardLevelReplyMemberCard getData() {
		return data;
	}

	public void setData(QueryMemberCardLevelReplyMemberCard data) {
		this.data = data;
	}
	public static class QueryMemberCardLevelReplyMemberCard{
		private String CinemaCode;
		private List<QueryMemberCardLevelReplyMemberCardLevel> level;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public List<QueryMemberCardLevelReplyMemberCardLevel> getLevel() {
			return level;
		}
		public void setLevel(List<QueryMemberCardLevelReplyMemberCardLevel> level) {
			this.level = level;
		}
		public static class QueryMemberCardLevelReplyMemberCardLevel{
			private String levelCode;
			private String levelName;
			private String CardCostFee;
			private String MemberFee;
			private String RuleCode;
			private String RuleName;
			private String RuleType;
			private String Credit;
			private String EffectiveDays;
			private String RuleDescription;
			private String Status;
			public String getLevelCode() {
				return levelCode;
			}
			public void setLevelCode(String levelCode) {
				this.levelCode = levelCode;
			}
			public String getLevelName() {
				return levelName;
			}
			public void setLevelName(String levelName) {
				this.levelName = levelName;
			}
			public String getCardCostFee() {
				return CardCostFee;
			}
			public void setCardCostFee(String cardCostFee) {
				CardCostFee = cardCostFee;
			}
			public String getMemberFee() {
				return MemberFee;
			}
			public void setMemberFee(String memberFee) {
				MemberFee = memberFee;
			}
			public String getRuleCode() {
				return RuleCode;
			}
			public void setRuleCode(String ruleCode) {
				RuleCode = ruleCode;
			}
			public String getRuleName() {
				return RuleName;
			}
			public void setRuleName(String ruleName) {
				RuleName = ruleName;
			}
			public String getRuleType() {
				return RuleType;
			}
			public void setRuleType(String ruleType) {
				RuleType = ruleType;
			}
			public String getCredit() {
				return Credit;
			}
			public void setCredit(String credit) {
				Credit = credit;
			}
			public String getEffectiveDays() {
				return EffectiveDays;
			}
			public void setEffectiveDays(String effectiveDays) {
				EffectiveDays = effectiveDays;
			}
			public String getRuleDescription() {
				return RuleDescription;
			}
			public void setRuleDescription(String ruleDescription) {
				RuleDescription = ruleDescription;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			
		}
	}
}
