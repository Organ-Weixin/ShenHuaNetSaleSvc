package com.boot.security.server.model;



public class Middleware extends BaseEntity<Long>{

	/**
	 * 
	 */
	private Long Id;
	private String Title;
	private String Url;
	private String MemberUrl;
	private String UserName;
	private String Password;
	private String CinemaCode;
	private Integer Type;
	private Integer CinemaCount;
	private Integer IsDel;

	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String Url) {
		this.Url = Url;
	}
	public String getMemberUrl() {
		return MemberUrl;
	}
	public void setMemberUrl(String MemberUrl) {
		this.MemberUrl = MemberUrl;
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
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public Integer getType() {
		return Type;
	}
	public void setType(Integer Type) {
		this.Type = Type;
	}
	public Integer getCinemaCount() {
		return CinemaCount;
	}
	public void setCinemaCount(Integer CinemaCount) {
		this.CinemaCount = CinemaCount;
	}
	public Integer getIsDel() {
		return IsDel;
	}
	public void setIsDel(Integer IsDel) {
		this.IsDel = IsDel;
	}

}
