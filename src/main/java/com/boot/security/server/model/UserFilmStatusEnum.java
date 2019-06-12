package com.boot.security.server.model;

public enum UserFilmStatusEnum {
	Wanted("想看",1),
	Looked("已看",2);
	private String StatusName;
	private int StatusCode;
	
	UserFilmStatusEnum(String StatusName,int StatusCode){
		this.StatusName=StatusName;
		this.StatusCode=StatusCode;
	}
	public String getStatusName() {
		return StatusName;
	}
	public void setStatusName(String statusName) {
		StatusName = statusName;
	}
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	
}
