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
	
	

}
