package com.boot.security.server.model;

public enum CardChargeTypeEnum {
	Cash("现金", 0), UnionCardPay("银联刷卡支付", 1), UnionOnlinePay("银联线上支付", 2), AliPay("支付宝", 3), WxPay("微信支付",
			4), Illegal("非法类型", -1);
	private String TypeName;
	private int TypeCode;

	CardChargeTypeEnum(String TypeName, int TypeCode) {
		this.TypeName = TypeName;
		this.TypeCode = TypeCode;
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
	public static CardChargeTypeEnum CastToEnum(String TypeName) {
		for (CardChargeTypeEnum en : CardChargeTypeEnum.values()) {
			if (en.getTypeName().equals(TypeName)) {
				return en;
			}
		}
		return null;
	}

	// 按编码转枚举
	public static CardChargeTypeEnum CastToEnum(int TypeCode) {
		for (CardChargeTypeEnum en : CardChargeTypeEnum.values()) {
			if (en.getTypeCode() == TypeCode) {
				return en;
			}
		}
		return null;
	}

}
