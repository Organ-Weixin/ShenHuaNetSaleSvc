package com.boot.security.server.model;



public class Priceplan {

	private Integer Id;
	private String CinemaCode;
	private String Code;
	private Integer UserID;
	private Double Price;
	private Double MemberPrice;
	private Double TicketFee;
	private Double AddFee;
	private Double CinemaAllowance;
	private Integer Type;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public Double getMemberPrice() {
		return MemberPrice;
	}
	public void setMemberPrice(Double memberPrice) {
		MemberPrice = memberPrice;
	}
	public Double getTicketFee() {
		return TicketFee;
	}
	public void setTicketFee(Double ticketFee) {
		TicketFee = ticketFee;
	}
	public Double getAddFee() {
		return AddFee;
	}
	public void setAddFee(Double addFee) {
		AddFee = addFee;
	}
	public Double getCinemaAllowance() {
		return CinemaAllowance;
	}
	public void setCinemaAllowance(Double cinemaAllowance) {
		CinemaAllowance = cinemaAllowance;
	}
	public Integer getType() {
		return Type;
	}
	public void setType(Integer type) {
		Type = type;
	}
	
}
