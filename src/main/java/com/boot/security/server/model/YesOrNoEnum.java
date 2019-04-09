package com.boot.security.server.model;

public enum YesOrNoEnum {
	Yes("是",1),
	No("否",0);
	private String StatusName;
	private int StatusCode;
	YesOrNoEnum(String StatusName,int StatusCode){
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
