package com.boot.security.server.modelView;

import java.util.Date;

public class Sessioninfoview {

	private Long Id;
	private String SCode;
	private String CinemaCode;
	private String CinemaName;
	private String ScreenCode;
	private String ScreenName;
	private Long UserID;
	private String Company;
	private String FilmCode;
	private String FilmName;
	private Date StartTime;
	private Integer Duration;
	private String Language;
	private Double StandardPrice;
	private Double LowestPrice;
	private Double TicketFee;
	private Double AddFee;
	private Double CinemaAllowance;
	private Double Price;
	private Double MemberPrice;
	
	private Date EndTime;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getSCode() {
		return SCode;
	}
	public void setSCode(String sCode) {
		SCode = sCode;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String cinemaName) {
		CinemaName = cinemaName;
	}
	public String getScreenCode() {
		return ScreenCode;
	}
	public void setScreenCode(String screenCode) {
		ScreenCode = screenCode;
	}
	public String getScreenName() {
		return ScreenName;
	}
	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}
	
	public Long getUserID() {
		return UserID;
	}
	public void setUserID(Long userID) {
		UserID = userID;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getFilmCode() {
		return FilmCode;
	}
	public void setFilmCode(String filmCode) {
		FilmCode = filmCode;
	}
	public String getFilmName() {
		return FilmName;
	}
	public void setFilmName(String filmName) {
		FilmName = filmName;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Integer getDuration() {
		return Duration;
	}
	public void setDuration(Integer duration) {
		Duration = duration;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public Double getStandardPrice() {
		return StandardPrice;
	}
	public void setStandardPrice(Double standardPrice) {
		StandardPrice = standardPrice;
	}
	public Double getLowestPrice() {
		return LowestPrice;
	}
	public void setLowestPrice(Double lowestPrice) {
		LowestPrice = lowestPrice;
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
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	public Double getMemberPrice() {
		return MemberPrice;
	}
	public void setMemberPrice(Double memberPrice) {
		MemberPrice = memberPrice;
	}
	
}
