package com.boot.security.server.model;

import java.util.Date;

public class Filmcomments extends BaseEntity<Long> {
	//影片评论表
	private Long Id;
	private String FilmCode;
	private String FilmName;
	private Double Score;
	private String CommentContent;
	private String OpenID;
	private Date Created;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date created) {
		Created = created;
	}
	
}
