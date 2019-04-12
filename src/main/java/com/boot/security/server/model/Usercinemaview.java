package com.boot.security.server.model;

import java.util.Date;

public class Usercinemaview extends BaseEntity<Long> {

	private Long Id;
	private Long UserId;
	private Date ExpDate;
	private String UserName;
	private String Password;
	private String PayType;
	private Double Fee;
	private String CinemaCode;
	private String CinemaName;
	private String CinemaAddress;
	private String CinemaId;
	private Integer CinemaOpen;
	private Integer CinemaType;
	private String Url;
	private String MemberUrl;
	private String DefaultUserName;
	private String DefaultPassword;
	private String RealUserName;
	private String RealPassword;

	public String getRealUserName() {
		return UserName==null||UserName.isEmpty() ? DefaultUserName : UserName;
	}

	public void setRealUserName(String realUserName) {
		// RealUserName = realUserName;
	}

	public String getRealPassword() {
		return Password==null || Password.isEmpty() ? DefaultPassword : Password;
	}

	public void setRealPassword(String realPassword) {
		// RealPassword = realPassword;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long UserId) {
		this.UserId = UserId;
	}

	public Date getExpDate() {
		return ExpDate;
	}

	public void setExpDate(Date ExpDate) {
		this.ExpDate = ExpDate;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getPayType() {
		return PayType;
	}

	public void setPayType(String PayType) {
		this.PayType = PayType;
	}

	public Double getFee() {
		return Fee;
	}

	public void setFee(Double Fee) {
		this.Fee = Fee;
	}

	public String getCinemaCode() {
		return CinemaCode;
	}

	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}

	public String getCinemaName() {
		return CinemaName;
	}

	public void setCinemaName(String CinemaName) {
		this.CinemaName = CinemaName;
	}

	public String getCinemaAddress() {
		return CinemaAddress;
	}

	public void setCinemaAddress(String CinemaAddress) {
		this.CinemaAddress = CinemaAddress;
	}

	public String getCinemaId() {
		return CinemaId;
	}

	public void setCinemaId(String CinemaId) {
		this.CinemaId = CinemaId;
	}

	public Integer getCinemaOpen() {
		return CinemaOpen;
	}

	public void setCinemaOpen(Integer CinemaOpen) {
		this.CinemaOpen = CinemaOpen;
	}

	public Integer getCinemaType() {
		return CinemaType;
	}

	public void setCinemaType(Integer CinemaType) {
		this.CinemaType = CinemaType;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String Url) {
		this.Url = Url;
	}

	public String getMemberUrl() {
		return MemberUrl;
	}

	public void setMemberUrl(String MemberUrl) {
		this.MemberUrl = MemberUrl;
	}

	public String getDefaultUserName() {
		return DefaultUserName;
	}

	public void setDefaultUserName(String DefaultUserName) {
		this.DefaultUserName = DefaultUserName;
	}

	public String getDefaultPassword() {
		return DefaultPassword;
	}

	public void setDefaultPassword(String DefaultPassword) {
		this.DefaultPassword = DefaultPassword;
	}

}
