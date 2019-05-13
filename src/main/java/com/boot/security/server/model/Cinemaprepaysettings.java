package com.boot.security.server.model;



public class Cinemaprepaysettings extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String CinemaName;
	private Integer IsPrePay;
	private Double SurplusPayment;
	private Double LowestPrePayment;
	private Integer IsDel;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
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
	public Integer getIsPrePay() {
		return IsPrePay;
	}
	public void setIsPrePay(Integer IsPrePay) {
		this.IsPrePay = IsPrePay;
	}
	public Double getSurplusPayment() {
		return SurplusPayment;
	}
	public void setSurplusPayment(Double SurplusPayment) {
		this.SurplusPayment = SurplusPayment;
	}
	public Double getLowestPrePayment() {
		return LowestPrePayment;
	}
	public void setLowestPrePayment(Double LowestPrePayment) {
		this.LowestPrePayment = LowestPrePayment;
	}
	public Integer getIsDel() {
		return IsDel;
	}
	public void setIsDel(Integer IsDel) {
		this.IsDel = IsDel;
	}

}
