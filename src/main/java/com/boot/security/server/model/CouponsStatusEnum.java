package com.boot.security.server.model;

public enum CouponsStatusEnum {
	Created("生成", 0), Fetched("已领取", 1), Used("已使用", 2), Expire("已过期", 3);
	private String StatusName;
	private int StatusCode;

	CouponsStatusEnum(String StatusName, int StatusCode) {
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
	public static CouponsStatusEnum CastToEnum(String StatusName) {
		for (CouponsStatusEnum en : CouponsStatusEnum.values()) {
			if (en.getStatusName().equals(StatusName)) {
				return en;
			}
		}
		return null;
	}

	// 按编码转枚举
	public static CouponsStatusEnum CastToEnum(int statusCode) {
		for (CouponsStatusEnum en : CouponsStatusEnum.values()) {
			if (en.getStatusCode() == statusCode) {
				return en;
			}
		}
		return null;
	}

}
