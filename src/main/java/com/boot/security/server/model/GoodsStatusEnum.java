package com.boot.security.server.model;

public enum GoodsStatusEnum {
	Up("上架",1),
	Down("下架",0);
	private String StatusName;
	private int StatusCode;
	GoodsStatusEnum(String StatusName,int StatusCode){
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
