package com.boot.security.server.model;

public enum SessionSeatStatusEnum {
	Illegal("非法座位状态","Illegal"),
	All("所有","All"),
	Available("可售出","Available"),
	Locked("已锁定","Locked"),
	Sold("已售出","Sold"),
	Booked("已预订","Booked"),
	Unavailable("不可用","Unavailable");
	private String StatusName;
	private String StatusCode;
	SessionSeatStatusEnum(String StatusName,String StatusCode){
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
