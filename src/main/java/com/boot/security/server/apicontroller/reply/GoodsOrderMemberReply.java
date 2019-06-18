package com.boot.security.server.apicontroller.reply;

public class GoodsOrderMemberReply extends BaseReply {
	private String OrderCode;
	private String PickUpCode;
	private String OrderNo;

	public String getOrderCode() {
		return OrderCode;
	}

	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}

	public String getPickUpCode() {
		return PickUpCode;
	}

	public void setPickUpCode(String pickUpCode) {
		PickUpCode = pickUpCode;
	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	

}
