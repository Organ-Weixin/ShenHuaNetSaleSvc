package com.boot.security.server.model;



public class Ticketuserfilm extends BaseEntity<Long> {

	private Long Id;
	private String OpenId;
	private String FilmCode;
	private Integer Status;

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
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer Status) {
		this.Status = Status;
	}

}
