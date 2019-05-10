package com.boot.security.server.model;

public enum CouponStatusEnum {
	UnUsed("未使用",0),
	Received("已领取",1),
	Used("已使用",2);
	
	private String StatusName;
	private int StatusCode;
	CouponStatusEnum(String StatusName,int StatusCode){
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
