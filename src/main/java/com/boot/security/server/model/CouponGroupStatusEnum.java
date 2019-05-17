package com.boot.security.server.model;

public enum CouponGroupStatusEnum {
	UnEnabled("未启用", 0), Enabled("已启用", 1), Expired("已过期", 2);

	private String StatusName;
	private int StatusCode;

	CouponGroupStatusEnum(String StatusName, int StatusCode) {
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
	public static CouponGroupStatusEnum CastToEnum(String StatusName) {
		for (CouponGroupStatusEnum en : CouponGroupStatusEnum.values()) {
			if (en.getStatusName().equals(StatusName)) {
				return en;
			}
		}
		return null;
	}

	// 按编码转枚举
	public static CouponGroupStatusEnum CastToEnum(int statusCode) {
		for (CouponGroupStatusEnum en : CouponGroupStatusEnum.values()) {
			if (en.getStatusCode() == statusCode) {
				return en;
			}
		}
		return null;
	}
}
