package com.boot.security.server.model;

public enum LoveFlagEnum {
	Normal("普通座","N"),
	LEFT("情侣座左边座位","L"),
	RIGHT("情侣座右边座位","R");
	private String FlagName;
	private String FlagCode;
	LoveFlagEnum(String FlagName,String FlagCode){
		this.FlagName=FlagName;
		this.FlagCode=FlagCode;
	}
	public String getFlagName() {
		return FlagName;
	}
	public void setFlagName(String flagName) {
		FlagName = flagName;
	}
	public String getFlagCode() {
		return FlagCode;
	}
	public void setFlagCode(String flagCode) {
		FlagCode = flagCode;
	}
	

}
