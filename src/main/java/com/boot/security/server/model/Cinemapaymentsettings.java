package com.boot.security.server.model;



public class Cinemapaymentsettings extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String CinemaName;
	private Integer IsUseWxpay;
	private String WxpayAppId;
	private String WxpayMchId;
	private String WxpayKey;
	private String WxpayRefundCert;
	private Integer IsUserMemberCard;
	private Integer IsDel;

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
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String CinemaName) {
		this.CinemaName = CinemaName;
	}
	public Integer getIsUseWxpay() {
		return IsUseWxpay;
	}
	public void setIsUseWxpay(Integer IsUseWxpay) {
		this.IsUseWxpay = IsUseWxpay;
	}
	public String getWxpayAppId() {
		return WxpayAppId;
	}
	public void setWxpayAppId(String WxpayAppId) {
		this.WxpayAppId = WxpayAppId;
	}
	public String getWxpayMchId() {
		return WxpayMchId;
	}
	public void setWxpayMchId(String WxpayMchId) {
		this.WxpayMchId = WxpayMchId;
	}
	public String getWxpayKey() {
		return WxpayKey;
	}
	public void setWxpayKey(String WxpayKey) {
		this.WxpayKey = WxpayKey;
	}
	public String getWxpayRefundCert() {
		return WxpayRefundCert;
	}
	public void setWxpayRefundCert(String WxpayRefundCert) {
		this.WxpayRefundCert = WxpayRefundCert;
	}
	public Integer getIsUserMemberCard() {
		return IsUserMemberCard;
	}
	public void setIsUserMemberCard(Integer IsUserMemberCard) {
		this.IsUserMemberCard = IsUserMemberCard;
	}
	public Integer getIsDel() {
		return IsDel;
	}
	public void setIsDel(Integer IsDel) {
		this.IsDel = IsDel;
	}

}
