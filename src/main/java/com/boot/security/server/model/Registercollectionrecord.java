package com.boot.security.server.model;

import java.util.Date;

public class Registercollectionrecord extends BaseEntity<Long> {

	private Long Id;
	private String OpenID;
	private String RegisterActiveCode;
	private Date CreateTime;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String OpenID) {
		this.OpenID = OpenID;
	}
	public String getRegisterActiveCode() {
		return RegisterActiveCode;
	}
	public void setRegisterActiveCode(String RegisterActiveCode) {
		this.RegisterActiveCode = RegisterActiveCode;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date CreateTime) {
		this.CreateTime = CreateTime;
	}

}
