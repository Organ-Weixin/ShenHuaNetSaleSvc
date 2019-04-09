package com.boot.security.server.model;

import java.util.Date;

public class Userinfo extends BaseEntity<Long>{

	private Long Id;
	private String UserName;
	private String Password;
	private String Company;
	private String Address;
	private String Tel;
	private Integer Advance;
	private Integer IsDel;
	private Date BeginDate;
	private Date EndDate;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String Company) {
		this.Company = Company;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String Tel) {
		this.Tel = Tel;
	}
	public Integer getAdvance() {
		return Advance;
	}
	public void setAdvance(Integer Advance) {
		this.Advance = Advance;
	}
	public Integer getIsDel() {
		return IsDel;
	}
	public void setIsDel(Integer IsDel) {
		this.IsDel = IsDel;
	}
	public Date getBeginDate() {
		return BeginDate;
	}
	public void setBeginDate(Date BeginDate) {
		this.BeginDate = BeginDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date EndDate) {
		this.EndDate = EndDate;
	}

}
