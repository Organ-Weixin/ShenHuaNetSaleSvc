package com.boot.security.server.model;

public enum OrderStatusEnum {
	Created("新建",1),
	Locked("已锁座",2),
	LockFail("锁座失败",3),
	Released("已解锁",4),
	ReleaseFail("解锁失败",5),
	Submited("已提交",6),//满天星调用SellTicket接口成功后进入此状态，待轮询确认成功后进入Complete
	SubmitFail("提交失败",7),
	Complete("完成",8),
	Refund("已退票",9),
	Payed("已支付",10),
	PayFail("支付失败",11);
	private String StatusName;
	private int StatusCode;
	OrderStatusEnum(String StatusName,int StatusCode){
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
