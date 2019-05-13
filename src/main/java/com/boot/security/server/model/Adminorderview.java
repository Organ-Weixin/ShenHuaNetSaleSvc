package com.boot.security.server.model;

import java.util.Date;

public class Adminorderview extends BaseEntity<Long> {

	private String cinemacode;
	private String cinemaname;
	private String filmname;
	private String submitordercode;
	private Date sessiontime;
	private String screencode;
	private String seat;
	private Double price;
	private Double saleprice;
	private Double addfee;
	private Double fee;
	private Double cinemaallowance;
	private String paytype;
	private Date created;
	private String filmticketcode;
	private String printno;
	private String mobilephone;
	private Integer orderstatus;

	public String getCinemacode() {
		return cinemacode;
	}
	public void setCinemacode(String cinemacode) {
		this.cinemacode = cinemacode;
	}
	public String getCinemaname() {
		return cinemaname;
	}
	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}
	public String getFilmname() {
		return filmname;
	}
	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}
	public String getSubmitordercode() {
		return submitordercode;
	}
	public void setSubmitordercode(String submitordercode) {
		this.submitordercode = submitordercode;
	}
	public Date getSessiontime() {
		return sessiontime;
	}
	public void setSessiontime(Date sessiontime) {
		this.sessiontime = sessiontime;
	}
	public String getScreencode() {
		return screencode;
	}
	public void setScreencode(String screencode) {
		this.screencode = screencode;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(Double saleprice) {
		this.saleprice = saleprice;
	}
	public Double getAddfee() {
		return addfee;
	}
	public void setAddfee(Double addfee) {
		this.addfee = addfee;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Double getCinemaallowance() {
		return cinemaallowance;
	}
	public void setCinemaallowance(Double cinemaallowance) {
		this.cinemaallowance = cinemaallowance;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getFilmticketcode() {
		return filmticketcode;
	}
	public void setFilmticketcode(String filmticketcode) {
		this.filmticketcode = filmticketcode;
	}
	public String getPrintno() {
		return printno;
	}
	public void setPrintno(String printno) {
		this.printno = printno;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public Integer getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
	
}
