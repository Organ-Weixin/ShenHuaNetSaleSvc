package com.boot.security.server.model;

import java.util.Date;

public class Membercardcreditrule extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String RuleCode;
	private String RuleName;
	private Date CreateTime;
	private String RuleType;
	private String LevelCode;
	private String LevelName;
	private String Credit;
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
	public String getRuleType() {
		return RuleType;
	}
	public void setRuleType(String RuleType) {
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
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String Credit) {
		this.Credit = Credit;
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
