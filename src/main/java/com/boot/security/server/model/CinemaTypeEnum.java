package com.boot.security.server.model;

public enum CinemaTypeEnum {
	NationalStandard("13规范",1),
	ChenXing("辰星",2),
	DingXin("鼎新",4),
	ManTianXing("满天星",8),
	HuoLieNiao("火烈鸟",16),
	DianYing1905("电影1905",32),
	YueKe("粤科",64),
	YunZhi("云智",65),
	Vista("VISTA",66);
	
	private String TypeName;
	private int TypeCode;
	CinemaTypeEnum(String TypeName,int TypeCode){
		this.TypeName=TypeName;
		this.TypeCode=TypeCode;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public int getTypeCode() {
		return TypeCode;
	}
	public void setTypeCode(int typeCode) {
		TypeCode = typeCode;
	}
	
	public static String getNameByCode(int TypeCode){
		for(CinemaTypeEnum cinemaType : CinemaTypeEnum.values()){
			if(TypeCode == cinemaType.getTypeCode()){
				return cinemaType.getTypeName();
			}
		}
		return null;
	}
}
