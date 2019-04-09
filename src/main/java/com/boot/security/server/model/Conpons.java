package com.boot.security.server.model;

import java.util.Date;

public class Conpons extends BaseEntity<Long> {

	private Long Id;
	private String TypeCode;
	private String TypeName;
	private String CinemaCode;
	private String GroupCode;
	private String OpenID;
	private Double Price;
	private String ConponCode;
	private String SnackCode;
	private Date ValidityDate;
	private Date ReceivedDate;
	private Integer Status;
	private Date UseDate;
	private Date Created;
	private Date Updated;
	private Integer Deleted;
	private String Title;
	private String Remark;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getTypeCode() {
		return TypeCode;
	}
	public void setTypeCode(String TypeCode) {
		this.TypeCode = TypeCode;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String TypeName) {
		this.TypeName = TypeName;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public String getGroupCode() {
		return GroupCode;
	}
	public void setGroupCode(String GroupCode) {
		this.GroupCode = GroupCode;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String OpenID) {
		this.OpenID = OpenID;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double Price) {
		this.Price = Price;
	}
	public String getConponCode() {
		return ConponCode;
	}
	public void setConponCode(String ConponCode) {
		this.ConponCode = ConponCode;
	}
	public String getSnackCode() {
		return SnackCode;
	}
	public void setSnackCode(String SnackCode) {
		this.SnackCode = SnackCode;
	}
	public Date getValidityDate() {
		return ValidityDate;
	}
	public void setValidityDate(Date ValidityDate) {
		this.ValidityDate = ValidityDate;
	}
	public Date getReceivedDate() {
		return ReceivedDate;
	}
	public void setReceivedDate(Date ReceivedDate) {
		this.ReceivedDate = ReceivedDate;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}
	public Date getUseDate() {
		return UseDate;
	}
	public void setUseDate(Date UseDate) {
		this.UseDate = UseDate;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date Updated) {
		this.Updated = Updated;
	}
	public Integer getDeleted() {
		return Deleted;
	}
	public void setDeleted(Integer Deleted) {
		this.Deleted = Deleted;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String Remark) {
		this.Remark = Remark;
	}

}
