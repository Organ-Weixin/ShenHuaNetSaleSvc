package com.boot.security.server.model;



public class Registeractivecoupons extends BaseEntity<Long> {

	private Long Id;
	private String RegisterActiveCode;
	private String GroupCode;
	private String CouponsName;
	private Integer GiveNumber;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getRegisterActiveCode() {
		return RegisterActiveCode;
	}
	public void setRegisterActiveCode(String RegisterActiveCode) {
		this.RegisterActiveCode = RegisterActiveCode;
	}
	public String getGroupCode() {
		return GroupCode;
	}
	public void setGroupCode(String GroupCode) {
		this.GroupCode = GroupCode;
	}
	public String getCouponsName() {
		return CouponsName;
	}
	public void setCouponsName(String CouponsName) {
		this.CouponsName = CouponsName;
	}
	public Integer getGiveNumber() {
		return GiveNumber;
	}
	public void setGiveNumber(Integer GiveNumber) {
		this.GiveNumber = GiveNumber;
	}

}
