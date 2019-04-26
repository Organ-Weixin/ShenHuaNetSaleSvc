package com.boot.security.server.model;

import java.util.Date;

public class Membercard extends BaseEntity<Long> { 

	//新增OpenId Updated
	private Long Id;
	private String CinemaCode;
	private Long OpenId;
	private String CardNo;
	private String CardPassword;
	private String MobilePhone;
	private String LevelCode;
	private String LevelName;
	private Integer Score;
	private Double Balance;
	private String UserName;
	private String Sex;
	private String CreditNum;
	private Date Birthday;
	private Date ExpireDate;
	private Date CreateTime;
	private Date Updated;
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
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String CardNo) {
		this.CardNo = CardNo;
	}
	public String getCardPassword() {
		return CardPassword;
	}
	public void setCardPassword(String CardPassword) {
		this.CardPassword = CardPassword;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String MobilePhone) {
		this.MobilePhone = MobilePhone;
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
	public Integer getScore() {
		return Score;
	}
	public void setScore(Integer Score) {
		this.Score = Score;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double Balance) {
		this.Balance = Balance;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String Sex) {
		this.Sex = Sex;
	}
	public String getCreditNum() {
		return CreditNum;
	}
	public void setCreditNum(String CreditNum) {
		this.CreditNum = CreditNum;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date Birthday) {
		this.Birthday = Birthday;
	}
	public Date getExpireDate() {
		return ExpireDate;
	}
	public void setExpireDate(Date ExpireDate) {
		this.ExpireDate = ExpireDate;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date CreateTime) {
		this.CreateTime = CreateTime;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}
	public Long getOpenId() {
		return OpenId;
	}
	public void setOpenId(Long openId) {
		OpenId = openId;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date updated) {
		Updated = updated;
	}
	
}
