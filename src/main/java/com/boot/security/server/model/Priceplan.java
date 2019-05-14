package com.boot.security.server.model;



public class Priceplan {

	private Integer Id;
	private String CinemaCode;
	private String Code;
	private Integer UserID;
	private Double Price;
	private Double TicketFee;
	private Double AddFee;
	private Double CinemaAllowance;
	private Integer Type;

	public Integer getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String Code) {
		this.Code = Code;
	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer UserID) {
		this.UserID = UserID;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double Price) {
		this.Price = Price;
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
	public void setType(Integer Type) {
		this.Type = Type;
	}

}
