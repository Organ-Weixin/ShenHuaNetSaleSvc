package com.boot.security.server.model;

public enum GoodsOrderStatusEnum {
	Created("新建", 1), CreatFail("创建失败", 2), Payed("已支付", 3), PayFail("支付失败", 4), Submited("已提交", 5), SubmitFail("提交失败",
			6), Complete("已完成", 7), Refund("已退单", 8), RefundFail("退单失败", 9), Fetched("已取货", 10),PayBack("已退款",11);

	private String StatusName;
	private int StatusCode;

	GoodsOrderStatusEnum(String StatusName, int StatusCode) {
		this.StatusName = StatusName;
		this.StatusCode = StatusCode;
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
	public static GoodsOrderStatusEnum CastToEnum(String StatusName) {
		for (GoodsOrderStatusEnum en : GoodsOrderStatusEnum.values()) {
			if (en.getStatusName().equals(StatusName)) {
				return en;
			}
		}
		return null;
	}

	// 按编码转枚举
	public static GoodsOrderStatusEnum CastToEnum(int statusCode) {
		for (GoodsOrderStatusEnum en : GoodsOrderStatusEnum.values()) {
			if (en.getStatusCode() == statusCode) {
				return en;
			}
		}
		return null;
	}

}
