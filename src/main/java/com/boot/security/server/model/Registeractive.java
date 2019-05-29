package com.boot.security.server.model;

import java.util.Date;

public class Registeractive extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String RegisterActiveCode;
	private Date CreatedTime;
	private String ActivePictureUrl;
	private Date UpdatedTime;
	private Integer Status;
	private String GroupCodes;
	private String CouponsName;
	private String GiveNumber;

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
	public String getRegisterActiveCode() {
		return RegisterActiveCode;
	}
	public void setRegisterActiveCode(String RegisterActiveCode) {
		this.RegisterActiveCode = RegisterActiveCode;
	}
	public Date getCreatedTime() {
		return CreatedTime;
	}
	public void setCreatedTime(Date CreatedTime) {
		this.CreatedTime = CreatedTime;
	}
	public String getActivePictureUrl() {
		return ActivePictureUrl;
	}
	public void setActivePictureUrl(String ActivePictureUrl) {
		this.ActivePictureUrl = ActivePictureUrl;
	}
	public Date getUpdatedTime() {
		return UpdatedTime;
	}
	public void setUpdatedTime(Date UpdatedTime) {
		this.UpdatedTime = UpdatedTime;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}
	public String getGroupCodes() {
		return GroupCodes;
	}
	public void setGroupCodes(String groupCodes) {
		GroupCodes = groupCodes;
	}
	public String getCouponsName() {
		return CouponsName;
	}
	public void setCouponsName(String couponsName) {
		CouponsName = couponsName;
	}
	public String getGiveNumber() {
		return GiveNumber;
	}
	public void setGiveNumber(String giveNumber) {
		GiveNumber = giveNumber;
	}

}
