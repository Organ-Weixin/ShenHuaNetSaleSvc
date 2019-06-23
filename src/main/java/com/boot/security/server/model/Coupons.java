package com.boot.security.server.model;

import java.util.Date;

public class Coupons extends BaseEntity<Long> {

	private Long Id;
	private String CouponsCode;
	private String CouponsName;
	private String GroupCode;
	private Integer Status;
	private String OpenID;
	private String MobilePhone;
	private Date CreateDate;
	private Date UsedDate;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getCouponsCode() {
		return CouponsCode;
	}
	public void setCouponsCode(String CouponsCode) {
		this.CouponsCode = CouponsCode;
	}
	public String getCouponsName() {
		return CouponsName;
	}
	public void setCouponsName(String CouponsName) {
		this.CouponsName = CouponsName;
	}
	public String getGroupCode() {
		return GroupCode;
	}
	public void setGroupCode(String GroupCode) {
		this.GroupCode = GroupCode;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String OpenID) {
		this.OpenID = OpenID;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date CreateDate) {
		this.CreateDate = CreateDate;
	}
	public Date getUsedDate() {
		return UsedDate;
	}
	public void setUsedDate(Date UsedDate) {
		this.UsedDate = UsedDate;
	}

}
