package com.boot.security.server.model;



public class Choosemembercardcreditrule extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String LevelCode;
	private String RuleCode;
	private String RuleType;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public String getLevelCode() {
		return LevelCode;
	}
	public void setLevelCode(String LevelCode) {
		this.LevelCode = LevelCode;
	}
	public String getRuleCode() {
		return RuleCode;
	}
	public void setRuleCode(String RuleCode) {
		this.RuleCode = RuleCode;
	}
	public String getRuleType() {
		return RuleType;
	}
	public void setRuleType(String ruleType) {
		RuleType = ruleType;
	}

}
