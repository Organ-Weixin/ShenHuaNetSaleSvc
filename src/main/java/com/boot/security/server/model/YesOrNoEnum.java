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
	
	// 按名称转枚举
	public static YesOrNoEnum CastToEnum(String StatusName) {
		for (YesOrNoEnum en : YesOrNoEnum.values()) {
			if (en.getStatusName().equals(StatusName)) {
				return en;
			}
		}
		return null;
	}

	// 按编码转枚举
	public static YesOrNoEnum CastToEnum(int statusCode) {
		for (YesOrNoEnum en : YesOrNoEnum.values()) {
			if (en.getStatusCode() == statusCode) {
				return en;
			}
		}
		return null;
	}
}
