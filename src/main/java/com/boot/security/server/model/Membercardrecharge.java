package com.boot.security.server.model;

import java.util.Date;

public class Membercardrecharge {

	private Long Id;
	private String CinemaCode;
	private String CardNo;
	private String CardPassword;
	private String UserName;
	private String MobilePhone;
	private Double RechargeAmount;
	private Double Balance;
	private String PayStatus;
	private String ChargeStatus;
	private String ErrorMsg;
	private String TradeNo;
	private String WXtradeNo;
	private Date Updated;
	private String MidUserName;
	private String MidPassword;
	private String RuleCode;
	private String LevelCode;

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
	public String getCardPassword() {
		return CardPassword;
	}
	public void setCardPassword(String cardPassword) {
		CardPassword = cardPassword;
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
	public String getPayStatus() {
		return PayStatus;
	}
	public void setPayStatus(String payStatus) {
		PayStatus = payStatus;
	}
	public String getChargeStatus() {
		return ChargeStatus;
	}
	public void setChargeStatus(String chargeStatus) {
		ChargeStatus = chargeStatus;
	}
	public String getErrorMsg() {
		return ErrorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}
	public String getTradeNo() {
		return TradeNo;
	}
	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}
	public String getWXtradeNo() {
		return WXtradeNo;
	}
	public void setWXtradeNo(String wXtradeNo) {
		WXtradeNo = wXtradeNo;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date updated) {
		Updated = updated;
	}
	public String getMidUserName() {
		return MidUserName;
	}
	public void setMidUserName(String midUserName) {
		MidUserName = midUserName;
	}
	public String getMidPassword() {
		return MidPassword;
	}
	public void setMidPassword(String midPassword) {
		MidPassword = midPassword;
	}
	public String getRuleCode() {
		return RuleCode;
	}
	public void setRuleCode(String ruleCode) {
		RuleCode = ruleCode;
	}
	public String getLevelCode() {
		return LevelCode;
	}
	public void setLevelCode(String levelCode) {
		LevelCode = levelCode;
	}
	
}
