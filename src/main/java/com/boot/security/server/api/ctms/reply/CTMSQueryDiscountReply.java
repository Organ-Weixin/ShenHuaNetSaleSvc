package com.boot.security.server.api.ctms.reply;

public class CTMSQueryDiscountReply extends CTMSBaseReply {
	private String CinemaCode; 
	private int DiscountType;
	private Float Price;
	private Float CinemaPayAmount;
	
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public int getDiscountType() {
		return DiscountType;
	}
	public void setDiscountType(int discountType) {
		DiscountType = discountType;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public Float getCinemaPayAmount() {
		return CinemaPayAmount;
	}
	public void setCinemaPayAmount(Float cinemaPayAmount) {
		CinemaPayAmount = cinemaPayAmount;
	}
	
}
