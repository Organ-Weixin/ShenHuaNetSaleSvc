package com.boot.security.server.model;

import java.util.Date;

public class Conpongroup extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String TypeCode;
	private String GroupCode;
	private String GroupName;
	private Double Price;
	private Integer ConponNumber;
	private String SnackOrFilmCode;
	private Date ValidityDate;
	private Date Created;
	private Date Updated;
	private String Remark;
	private Conpons Conpons;
	private Conpontype Conpontype;
	private Integer Alls;
	private Integer Used;
	private Integer Unused;
	private Integer Received;

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
	public String getTypeCode() {
		return TypeCode;
	}
	public void setTypeCode(String TypeCode) {
		this.TypeCode = TypeCode;
	}
	public String getGroupCode() {
		return GroupCode;
	}
	public void setGroupCode(String GroupCode) {
		this.GroupCode = GroupCode;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String GroupName) {
		this.GroupName = GroupName;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double Price) {
		this.Price = Price;
	}
	public Integer getConponNumber() {
		return ConponNumber;
	}
	public void setConponNumber(Integer ConponNumber) {
		this.ConponNumber = ConponNumber;
	}
	public String getSnackOrFilmCode() {
		return SnackOrFilmCode;
	}
	public void setSnackOrFilmCode(String SnackOrFilmCode) {
		this.SnackOrFilmCode = SnackOrFilmCode;
	}
	public Date getValidityDate() {
		return ValidityDate;
	}
	public void setValidityDate(Date ValidityDate) {
		this.ValidityDate = ValidityDate;
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
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
	public Conpons getConpons() {
		return Conpons;
	}
	public void setConpons(Conpons conpons) {
		Conpons = conpons;
	}
	public Conpontype getConpontype() {
		return Conpontype;
	}
	public void setConpontype(Conpontype conpontype) {
		Conpontype = conpontype;
	}
	public Integer getAlls() {
		return Alls;
	}
	public void setAlls(Integer alls) {
		Alls = alls;
	}
	public Integer getUsed() {
		return Used;
	}
	public void setUsed(Integer used) {
		Used = used;
	}
	public Integer getUnused() {
		return Unused;
	}
	public void setUnused(Integer unused) {
		Unused = unused;
	}
	public Integer getReceived() {
		return Received;
	}
	public void setReceived(Integer received) {
		Received = received;
	}
	
}
