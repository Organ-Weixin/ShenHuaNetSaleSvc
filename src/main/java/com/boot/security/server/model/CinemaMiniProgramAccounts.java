package com.boot.security.server.model;

public class CinemaMiniProgramAccounts extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String CinemaName;
	private String AppId;
	private String AppSecret;
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
	public String getAppId() {
		return AppId;
	}
	public void setAppId(String AppId) {
		this.AppId = AppId;
	}
	public String getAppSecret() {
		return AppSecret;
	}
	public void setAppSecret(String AppSecret) {
		this.AppSecret = AppSecret;
	}
	public Integer getIsDel() {
		return IsDel;
	}
	public void setIsDel(Integer IsDel) {
		this.IsDel = IsDel;
	}

}
