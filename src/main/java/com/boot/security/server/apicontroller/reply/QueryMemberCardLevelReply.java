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
			private Double CardCostFee;
			private Double MemberFee;
			private String MemberCardImage;
			private String RuleCode;
			private String RuleName;
			private Integer RuleType;
			private Double Credit;
			private Double GivenAmount;
			private String OfferDescription;
			private String RuleDescription;
			private Integer IsOnlineOpenCard;
			private Integer Status;
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
			public String getRuleCode() {
				return RuleCode;
			}
			public String getMemberCardImage() {
				return MemberCardImage;
			}
			public void setMemberCardImage(String memberCardImage) {
				MemberCardImage = memberCardImage;
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
			public Double getCardCostFee() {
				return CardCostFee;
			}
			public void setCardCostFee(Double cardCostFee) {
				CardCostFee = cardCostFee;
			}
			public Double getMemberFee() {
				return MemberFee;
			}
			public void setMemberFee(Double memberFee) {
				MemberFee = memberFee;
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
			public String getOfferDescription() {
				return OfferDescription;
			}
			public void setOfferDescription(String offerDescription) {
				OfferDescription = offerDescription;
			}
			public String getRuleDescription() {
				return RuleDescription;
			}
			public void setRuleDescription(String ruleDescription) {
				RuleDescription = ruleDescription;
			}
			public Integer getIsOnlineOpenCard() {
				return IsOnlineOpenCard;
			}
			public void setIsOnlineOpenCard(Integer isOnlineOpenCard) {
				IsOnlineOpenCard = isOnlineOpenCard;
			}
			public Integer getStatus() {
				return Status;
			}
			public void setStatus(Integer status) {
				Status = status;
			}
			
		}
	}
}
