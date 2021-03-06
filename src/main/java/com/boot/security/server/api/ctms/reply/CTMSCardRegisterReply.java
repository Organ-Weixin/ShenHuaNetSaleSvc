package com.boot.security.server.api.ctms.reply; 

import java.util.Date;

public class CTMSCardRegisterReply extends CTMSBaseReply {
	private String CardNo;
	private Float Balance;
	private Date ExpireDate;
	private Date CreateTime;
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}
	public Float getBalance() {
		return Balance;
	}
	public void setBalance(Float balance) {
		Balance = balance;
	}
	public Date getExpireDate() {
		return ExpireDate;
	}
	public void setExpireDate(Date expireDate) {
		ExpireDate = expireDate;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
}
