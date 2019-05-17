package com.boot.security.server.apicontroller.reply;

public class CinemaChannelPlaysInput {

	private String UserName;
	private String Password;
	private String CinemaCode;
	private String FilmCode;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getFilmCode() {
		return FilmCode;
	}
	public void setFilmCode(String filmCode) {
		FilmCode = filmCode;
	}
	
}
