package com.boot.security.server.apicontroller.reply;

public class SubmitFilmCommentReplyJson {
	private String UserName;
	private String Password;
	private String FilmCode;
	private String FilmName;
	private Double Score;
	private String CommentContent;
	private String OpenID;

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
	public String getFilmCode() {
		return FilmCode;
	}
	public void setFilmCode(String filmCode) {
		FilmCode = filmCode;
	}
	public String getFilmName() {
		return FilmName;
	}
	public void setFilmName(String filmName) {
		FilmName = filmName;
	}
	public Double getScore() {
		return Score;
	}
	public void setScore(Double score) {
		Score = score;
	}
	public String getCommentContent() {
		return CommentContent;
	}
	public void setCommentContent(String commentContent) {
		CommentContent = commentContent;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String openID) {
		OpenID = openID;
	}
	
}
