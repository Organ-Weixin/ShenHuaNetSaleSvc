package com.boot.security.server.api.core;

import java.util.Date;

public class CardRegisterReply extends BaseReply {
	public CardRegisterReply()
    {
        Id = ID_CardRegisterReply;
    }
	public String CardNo;
	public Float Balance;
	public Date ExpireDate;
	public Date CreateTime;
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
