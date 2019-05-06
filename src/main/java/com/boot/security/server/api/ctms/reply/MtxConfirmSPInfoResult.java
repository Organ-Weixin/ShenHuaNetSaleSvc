package com.boot.security.server.api.ctms.reply;

public class MtxConfirmSPInfoResult {
	//确认卖品接口
	private String resultCode;
	private String orderNo;
	private String validCode;
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getValidCode() {
		return validCode;
	}
	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}

	
}
