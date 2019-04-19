package com.boot.security.server.model;

public enum CardChargeTypeEnum { 
	Cash("现金",0),
	UnionCardPay("银联刷卡支付",1),
	UnionOnlinePay("银联线上支付",2),
	AliPay("支付宝",3),
	WxPay("微信支付",4),
	Illegal("非法类型",-1);
	private String TypeName;
	private int TypeCode;
	CardChargeTypeEnum(String TypeName,int TypeCode){
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
