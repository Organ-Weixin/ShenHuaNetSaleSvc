package com.boot.security.server.api.core;

public class CardPayReply extends BaseReply { 
	public CardPayReply()
    {
        Id = ID_CardPayReply;
    }
	public String TradeNo;
	public Float DeductAmount;
	public String getTradeNo() {
		return TradeNo;
	}
	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}
	public Float getDeductAmount() {
		return DeductAmount;
	}
	public void setDeductAmount(Float deductAmount) {
		DeductAmount = deductAmount;
	}
	

}
