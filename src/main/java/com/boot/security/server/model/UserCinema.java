package com.boot.security.server.model;

import java.util.Date;

public class UserCinema extends BaseEntity<Long> {

	private Long Id;
	private Integer UserId;
	private String CinemaCode;
	private String UserName;
	private String Password;
	private Double Fee;
	private Double CinemaFee;
	private String PayType;
	private Double RealPrice;
	private Date ExpDate;
	private Userinfo Userinfo;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer UserId) {
		this.UserId = UserId;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
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
	public Double getFee() {
		return Fee;
	}
	public void setFee(Double Fee) {
		this.Fee = Fee;
	}
	public Double getCinemaFee() {
		return CinemaFee;
	}
	public void setCinemaFee(Double CinemaFee) {
		this.CinemaFee = CinemaFee;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String PayType) {
		this.PayType = PayType;
	}
	public Double getRealPrice() {
		return RealPrice;
	}
	public void setRealPrice(Double RealPrice) {
		this.RealPrice = RealPrice;
	}
	public Date getExpDate() {
		return ExpDate;
	}
	public void setExpDate(Date ExpDate) {
		this.ExpDate = ExpDate;
	}
	public Userinfo getUserinfo() {
		return Userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		Userinfo = userinfo;
	}
	
}
