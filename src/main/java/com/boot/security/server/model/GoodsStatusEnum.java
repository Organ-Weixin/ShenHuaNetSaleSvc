package com.boot.security.server.model;

public enum GoodsStatusEnum {
	Up("上架", 1), Down("下架", 0);
	private String StatusName;
	private int StatusCode;

	GoodsStatusEnum(String StatusName, int StatusCode) {
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
	public static GoodsStatusEnum CastToEnum(String StatusName) {
		for (GoodsStatusEnum en : GoodsStatusEnum.values()) {
			if (en.getStatusName().equals(StatusName)) {
				return en;
			}
		}
		return null;
	}

	// 按编码转枚举
	public static GoodsStatusEnum CastToEnum(int statusCode) {
		for (GoodsStatusEnum en : GoodsStatusEnum.values()) {
			if (en.getStatusCode() == statusCode) {
				return en;
			}
		}
		return null;
	}

}
