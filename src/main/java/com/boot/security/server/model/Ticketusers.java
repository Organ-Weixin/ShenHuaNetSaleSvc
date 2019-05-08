package com.boot.security.server.model;

import java.util.Date;

public class Ticketusers {

	private Long Id;
	private String CinemaCode;
	private String MobilePhone;
	private String OpenID;
	private String VerifyCode;
	private Integer IsActive;
	private Date Created;
	private String NickName;
	private Integer Sex;
	private String Country;
	private String Province;
	private String City;
	private String HeadImgUrl;
	private String TotalScore;
	private String Language;

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
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String MobilePhone) {
		this.MobilePhone = MobilePhone;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String OpenID) {
		this.OpenID = OpenID;
	}
	public String getVerifyCode() {
		return VerifyCode;
	}
	public void setVerifyCode(String VerifyCode) {
		this.VerifyCode = VerifyCode;
	}
	public Integer getIsActive() {
		return IsActive;
	}
	public void setIsActive(Integer IsActive) {
		this.IsActive = IsActive;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String NickName) {
		this.NickName = NickName;
	}
	public Integer getSex() {
		return Sex;
	}
	public void setSex(Integer Sex) {
		this.Sex = Sex;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String Province) {
		this.Province = Province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public String getHeadImgUrl() {
		return HeadImgUrl;
	}
	public void setHeadImgUrl(String HeadImgUrl) {
		this.HeadImgUrl = HeadImgUrl;
	}
	public String getTotalScore() {
		return TotalScore;
	}
	public void setTotalScore(String TotalScore) {
		this.TotalScore = TotalScore;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String Language) {
		this.Language = Language;
	}

}
