package com.boot.security.server.model;

import java.util.Date;

public class Ticketusers {

	private Long Id;
	private String CinemaCode;
	private String MobilePhone;
	private String OpenID;
	private String VerifyCode;
	private int IsActive;
	private String IsRegister;
	private String IsMember;
	private Date RegisterTime;
	private Date Created;
	private String NickName;
	private int Sex;
	private Date Birthday;
	private String Country;
	private String Province;
	private String City;
	private String HeadImgUrl;
	private String TotalScore;
	private String Language;
	private String Roll = "1";  //放映厅角色,1普通用户,2管理员

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
	public int getIsActive() {
		return IsActive;
	}
	public void setIsActive(int IsActive) {
		this.IsActive = IsActive;
	}
	public String getIsRegister() {
		return IsRegister;
	}
	public void setIsRegister(String isRegister) {
		IsRegister = isRegister;
	}
	public String getIsMember() {
		return IsMember;
	}
	public void setIsMember(String isMember) {
		IsMember = isMember;
	}
	public Date getRegisterTime() {
		return RegisterTime;
	}
	public void setRegisterTime(Date registerTime) {
		RegisterTime = registerTime;
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
	public int getSex() {
		return Sex;
	}
	public void setSex(int Sex) {
		this.Sex = Sex;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
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
	public String getRoll() {
		return Roll;
	}
	public void setRoll(String roll) {
		this.Roll = roll;
	}
	
}
