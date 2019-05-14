package com.boot.security.server.model;

public enum GoodsOrderStatusEnum {
	Created("新建",1),
	CreatFail("创建失败",2),
	Payed("已支付",3),
	PayFail("支付失败",4),
	Submited("已提交",5),
	SubmitFail("提交失败",6),
	Complete("已完成",7),
	Refund("已退单",8),
	RefundFail("退单失败",9),
	Fetched("已取货",10);
	
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
	
	public static String getNameByCode(int code){
		for(GoodsOrderStatusEnum order : GoodsOrderStatusEnum.values()){
			if(code == order.getStatusCode()){
				return order.getStatusName();
			}
		}
		return null;
	}

}
