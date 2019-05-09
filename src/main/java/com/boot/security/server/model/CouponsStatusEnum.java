package com.boot.security.server.model;

public enum CouponsStatusEnum {
	Created("生成",0),
	Fetched("已领取",1),
	Used("已使用",2);
	private String StatusName;
	private int StatusCode;
	CouponsStatusEnum(String StatusName,int StatusCode){
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
