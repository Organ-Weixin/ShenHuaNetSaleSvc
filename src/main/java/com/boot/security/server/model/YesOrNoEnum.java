package com.boot.security.server.model;

public enum YesOrNoEnum {
	Yes("是","Yes","1"),
	No("否","No","0");
	private String StatusName;
	private String StatusFlag;
	private String StatusCode;
	YesOrNoEnum(String StatusName,String StatusFlag,String StatusCode){
		this.StatusName=StatusName;
		this.StatusFlag=StatusFlag;
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
	public String getStatusFlag() {
		return StatusFlag;
	}
	public void setStatusFlag(String statusFlag) {
		StatusFlag = statusFlag;
	}
	
	

}
