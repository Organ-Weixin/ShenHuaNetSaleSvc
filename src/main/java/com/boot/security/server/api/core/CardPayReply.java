package com.boot.security.server.api.core;

public class CardPayReply extends BaseReply { 
	public CardPayReply()
    {
        Id = ID_CardPayReply;
    }
	private String TradeNo;
	private Float DeductAmount;
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
