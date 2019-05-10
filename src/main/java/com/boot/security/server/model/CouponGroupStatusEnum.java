package com.boot.security.server.model;

public enum CouponGroupStatusEnum {
	UnEnabled("未启用",0),
	Enabled("已启用",1),
	Expired("已过期",2);
	
	private String StatusName;
	private int StatusCode;
	CouponGroupStatusEnum(String StatusName,int StatusCode){
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
