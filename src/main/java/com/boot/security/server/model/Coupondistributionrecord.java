package com.boot.security.server.model;

import java.util.Date;

public class Coupondistributionrecord extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String GroupCode;
	private Integer CustomerType;
	private String OpenID;
	private String Issuer;
	private Integer IssuedNumber;
	private Date IssuedTime;
	private Integer Status;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getGroupCode() {
		return GroupCode;
	}
	public void setGroupCode(String GroupCode) {
		this.GroupCode = GroupCode;
	}
	public Integer getCustomerType() {
		return CustomerType;
	}
	public void setCustomerType(Integer CustomerType) {
		this.CustomerType = CustomerType;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String openID) {
		OpenID = openID;
	}
	public String getIssuer() {
		return Issuer;
	}
	public void setIssuer(String Issuer) {
		this.Issuer = Issuer;
	}
	public Integer getIssuedNumber() {
		return IssuedNumber;
	}
	public void setIssuedNumber(Integer issuedNumber) {
		IssuedNumber = issuedNumber;
	}
	public Date getIssuedTime() {
		return IssuedTime;
	}
	public void setIssuedTime(Date IssuedTime) {
		this.IssuedTime = IssuedTime;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}

}
