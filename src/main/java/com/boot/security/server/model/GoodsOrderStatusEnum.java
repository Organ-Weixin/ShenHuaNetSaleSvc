package com.boot.security.server.model;

public enum GoodsOrderStatusEnum {
	Created("新建",1),
	Payed("已支付",2),
	PayFail("支付失败",3),
	Submited("已提交",4),
	SubmitFail("提交失败",5),
	Complete("已完成",6),
	Refund("已退单",7),
	RefundFail("退单失败",8),
	Fetched("已取货",9);
	
	private String StatusName;
	private int StatusCode;
	GoodsOrderStatusEnum(String StatusName,int StatusCode){
		this.StatusName=StatusName;
		this.StatusCode=StatusCode;
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

}
