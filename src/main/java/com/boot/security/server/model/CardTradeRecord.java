package com.boot.security.server.model;

import java.util.Date;

public class CardTradeRecord {
	private String TradeNo;
	private String TradeType;
	private Date TradeTime;
	private Float TradePrice;
	private String CinemaName;
	public String getTradeNo() {
		return TradeNo;
	}
	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}
	public String getTradeType() {
		return TradeType;
	}
	public void setTradeType(String tradeType) {
		TradeType = tradeType;
	}
	public Date getTradeTime() {
		return TradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		TradeTime = tradeTime;
	}
	public Float getTradePrice() {
		return TradePrice;
	}
	public void setTradePrice(Float tradePrice) {
		TradePrice = tradePrice;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String cinemaName) {
		CinemaName = cinemaName;
	}
	

}
