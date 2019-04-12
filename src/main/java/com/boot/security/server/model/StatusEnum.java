package com.boot.security.server.model;

public enum StatusEnum {
	Failure("失败","Failure"),
	Success("成功","Success");
	private String StatusName;
	private String StatusCode;
	StatusEnum(String StatusName,String StatusCode){
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
