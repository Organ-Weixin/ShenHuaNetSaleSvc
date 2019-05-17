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
	
	//按名称转枚举
	public static CinemaTypeEnum CastToEnum(String TypeName) {  
        for (CinemaTypeEnum en : CinemaTypeEnum.values()) {  
            if (en.getTypeName().equals(TypeName)) {  
                return en;
            }
        }
        return null;
    }
	//按编码转枚举
	public static CinemaTypeEnum CastToEnum(int TypeCode) {  
        for (CinemaTypeEnum en : CinemaTypeEnum.values()) {  
            if (en.getTypeCode() == TypeCode) {
                return en;
            }
        }
        return null;
    }
}
