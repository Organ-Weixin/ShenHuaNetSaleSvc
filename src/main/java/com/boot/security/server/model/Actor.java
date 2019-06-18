package com.boot.security.server.model;

import java.util.Date;

public class Actor {

	private Long Id;
	private Date CreateTime;
	private Date DeleteTime;
	private Date ModifyTime;
	private Integer Valid;
	private Integer Version;
	private String Country;
	private String CountryIndex;
	private String Introduction;
	private String Name;
	private String Picture;
	private Integer Businessid;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date CreateTime) {
		this.CreateTime = CreateTime;
	}
	public Date getDeleteTime() {
		return DeleteTime;
	}
	public void setDeleteTime(Date DeleteTime) {
		this.DeleteTime = DeleteTime;
	}
	public Date getModifyTime() {
		return ModifyTime;
	}
	public void setModifyTime(Date ModifyTime) {
		this.ModifyTime = ModifyTime;
	}
	public Integer getValid() {
		return Valid;
	}
	public void setValid(Integer Valid) {
		this.Valid = Valid;
	}
	public Integer getVersion() {
		return Version;
	}
	public void setVersion(Integer Version) {
		this.Version = Version;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	}
	public String getCountryIndex() {
		return CountryIndex;
	}
	public void setCountryIndex(String CountryIndex) {
		this.CountryIndex = CountryIndex;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String Introduction) {
		this.Introduction = Introduction;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String Picture) {
		this.Picture = Picture;
	}
	public Integer getBusinessid() {
		return Businessid;
	}
	public void setBusinessid(Integer Businessid) {
		this.Businessid = Businessid;
	}

}
