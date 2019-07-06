package com.boot.security.server.model;

public enum UserFilmStatusEnum {
	Wanted("想看","1"),
	Looked("已看","2");
	private String StatusName;
	private String StatusCode;
	
	UserFilmStatusEnum(String StatusName,String StatusCode){
		this.StatusName=StatusName;
		this.StatusCode=StatusCode;
	}
	public String getStatusName() {
		return StatusName;
	}
	public void setStatusName(String statusName) {
		StatusName = statusName;
	}
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	
}
