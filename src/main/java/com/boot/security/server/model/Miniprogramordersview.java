package com.boot.security.server.model;

import java.util.Date;

public class Miniprogramordersview extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String CinemaName;
	private String CinemaPhone;
	private String Address;
	private String SessionCode;
	private String ScreenCode;
	private Date SessionTime;
	private String FilmCode;
	private String FilmName;
	private Integer TicketCount;
	private Double TotalSalePrice;
	private Integer OrderStatus;
	private String MobilePhone;
	private String OrderCode;
	private String PrintNo;
	private String TicketInfoCode;
	private Date Created;
	private String OpenID;
	private String ScreenName;
	private String SeatName;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String CinemaName) {
		this.CinemaName = CinemaName;
	}
	public String getCinemaPhone() {
		return CinemaPhone;
	}
	public void setCinemaPhone(String CinemaPhone) {
		this.CinemaPhone = CinemaPhone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getSessionCode() {
		return SessionCode;
	}
	public void setSessionCode(String SessionCode) {
		this.SessionCode = SessionCode;
	}
	public String getScreenCode() {
		return ScreenCode;
	}
	public void setScreenCode(String ScreenCode) {
		this.ScreenCode = ScreenCode;
	}
	public Date getSessionTime() {
		return SessionTime;
	}
	public void setSessionTime(Date SessionTime) {
		this.SessionTime = SessionTime;
	}
	public String getFilmCode() {
		return FilmCode;
	}
	public void setFilmCode(String FilmCode) {
		this.FilmCode = FilmCode;
	}
	public String getFilmName() {
		return FilmName;
	}
	public void setFilmName(String FilmName) {
		this.FilmName = FilmName;
	}
	public Integer getTicketCount() {
		return TicketCount;
	}
	public void setTicketCount(Integer TicketCount) {
		this.TicketCount = TicketCount;
	}
	public Double getTotalSalePrice() {
		return TotalSalePrice;
	}
	public void setTotalSalePrice(Double TotalSalePrice) {
		this.TotalSalePrice = TotalSalePrice;
	}
	public Integer getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(Integer OrderStatus) {
		this.OrderStatus = OrderStatus;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String MobilePhone) {
		this.MobilePhone = MobilePhone;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String OrderCode) {
		this.OrderCode = OrderCode;
	}
	public String getPrintNo() {
		return PrintNo;
	}
	public void setPrintNo(String PrintNo) {
		this.PrintNo = PrintNo;
	}
	public String getTicketInfoCode() {
		return TicketInfoCode;
	}
	public void setTicketInfoCode(String TicketInfoCode) {
		this.TicketInfoCode = TicketInfoCode;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String OpenID) {
		this.OpenID = OpenID;
	}
	public String getScreenName() {
		return ScreenName;
	}
	public void setScreenName(String ScreenName) {
		this.ScreenName = ScreenName;
	}
	public String getSeatName() {
		return SeatName;
	}
	public void setSeatName(String SeatName) {
		this.SeatName = SeatName;
	}

}
