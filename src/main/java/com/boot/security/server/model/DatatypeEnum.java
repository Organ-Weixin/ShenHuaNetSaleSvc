package com.boot.security.server.model;

public enum DatatypeEnum {

	Tao("淘票票","49"),
	Bai("百度糯米","46"),
	Mao("猫眼","36");
	
	private String code;
	private String name;
	private DatatypeEnum(String name,String code) {
		this.name = name;
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static String getNameByCode(String code){
		for(DatatypeEnum type : DatatypeEnum.values()){
			if(code.equals(type.getCode())){
				return type.getName();
			}
		}
		return null;
	}
}
