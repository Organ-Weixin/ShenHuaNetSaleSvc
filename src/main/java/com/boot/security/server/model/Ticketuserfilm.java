package com.boot.security.server.model;



public class Ticketuserfilm extends BaseEntity<Long> {

	private Long Id;
	private String OpenId;
	private String FilmCode;
	private String Status;
	private String LookStatus;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getOpenId() {
		return OpenId;
	}
	public void setOpenId(String OpenId) {
		this.OpenId = OpenId;
	}
	public String getFilmCode() {
		return FilmCode;
	}
	public void setFilmCode(String FilmCode) {
		this.FilmCode = FilmCode;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getLookStatus() {
		return LookStatus;
	}
	public void setLookStatus(String lookStatus) {
		LookStatus = lookStatus;
	}
	
}
