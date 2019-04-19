package com.boot.security.server.api.ctms.reply;

public class CTMSCardPayReply extends CTMSBaseReply { 
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
