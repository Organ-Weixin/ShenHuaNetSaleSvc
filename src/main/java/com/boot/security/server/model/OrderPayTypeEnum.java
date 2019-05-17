package com.boot.security.server.model;

public enum OrderPayTypeEnum {
	WxPay("微信支付",1),
	MemberCardPay("会员卡支付",2);

	private String TypeName;
	private int TypeCode;
	OrderPayTypeEnum(String TypeName,int TypeCode){
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
	
	// 按名称转枚举
	public static OrderPayTypeEnum CastToEnum(String TypeName) {
		for (OrderPayTypeEnum en : OrderPayTypeEnum.values()) {
			if (en.getTypeName().equals(TypeName)) {
				return en;
			}
		}
		return null;
	}

	// 按编码转枚举
	public static OrderPayTypeEnum CastToEnum(int TypeCode) {
		for (OrderPayTypeEnum en : OrderPayTypeEnum.values()) {
			if (en.getTypeCode() == TypeCode) {
				return en;
			}
		}
		return null;
	}
}
