package com.boot.security.server.model;

import java.util.Date;

public class Membercardrecharge {

	private Long Id;
	private String CinemaCode;
	private String UserName;
	private String MobilePhone;
	private String CardNo;
	private Double RechargeAmount;
	private Double Balance;
	private Date Updated;

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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String CardNo) {
		this.CardNo = CardNo;
	}
	public Double getRechargeAmount() {
		return RechargeAmount;
	}
	public void setRechargeAmount(Double RechargeAmount) {
		this.RechargeAmount = RechargeAmount;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double Balance) {
		this.Balance = Balance;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date Updated) {
		this.Updated = Updated;
	}

}
