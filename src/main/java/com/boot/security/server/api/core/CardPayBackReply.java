package com.boot.security.server.api.core;

public class CardPayBackReply extends BaseReply {
	public CardPayBackReply()
    {
        Id = ID_CardPayBackReply;
    }
	public String TradeNo;
	public String getTradeNo() {
		return TradeNo;
	}
	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}
}
