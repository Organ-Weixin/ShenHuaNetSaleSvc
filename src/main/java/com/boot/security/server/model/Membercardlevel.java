package com.boot.security.server.model;



public class Membercardlevel extends BaseEntity<Long> { 

	private Long Id;
	private String CinemaCode;
	private String LevelCode;
	private String LevelName;

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
	public String getLevelCode() {
		return LevelCode;
	}
	public void setLevelCode(String LevelCode) {
		this.LevelCode = LevelCode;
	}
	public String getLevelName() {
		return LevelName;
	}
	public void setLevelName(String LevelName) {
		this.LevelName = LevelName;
	}

}
