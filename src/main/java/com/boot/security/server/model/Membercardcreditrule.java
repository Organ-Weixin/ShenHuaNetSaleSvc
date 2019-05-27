package com.boot.security.server.model;

import java.util.Date;

public class Membercardcreditrule extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String RuleCode;
	private String RuleName;
	private Date CreateTime;
	private Integer RuleType;
	private String LevelCode;
	private String LevelName;
	private Double Credit;
	private Double GivenAmount;
	private String EffectiveDays;
	private String RuleDescription;
	private Date UpdateTime;
	private Integer Status;

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
	public String getRuleCode() {
		return RuleCode;
	}
	public void setRuleCode(String RuleCode) {
		this.RuleCode = RuleCode;
	}
	public String getRuleName() {
		return RuleName;
	}
	public void setRuleName(String RuleName) {
		this.RuleName = RuleName;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	public Integer getRuleType() {
		return RuleType;
	}
	public void setRuleType(Integer RuleType) {
		this.RuleType = RuleType;
	}
	public String getLevelCode() {
		return LevelCode;
	}
	public void setLevelCode(String LevelCode) {
		this.LevelCode = LevelCode;
	}
	public String getLevelName() {
		return LevelName;
	}
	public void setLevelName(String LevelName) {
		this.LevelName = LevelName;
	}
	public Double getCredit() {
		return Credit;
	}
	public void setCredit(Double Credit) {
		this.Credit = Credit;
	}
	public Double getGivenAmount() {
		return GivenAmount;
	}
	public void setGivenAmount(Double givenAmount) {
		GivenAmount = givenAmount;
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
	public void setRuleDescription(String RuleDescription) {
		this.RuleDescription = RuleDescription;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}

}
