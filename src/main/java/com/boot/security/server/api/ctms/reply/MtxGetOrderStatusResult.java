package com.boot.security.server.api.ctms.reply;


public class MtxGetOrderStatusResult {
	//查询订单的售票结果
	private ResBean GetOrderStatusResult ;
	public ResBean getGetOrderStatusResult() {
		return GetOrderStatusResult;
	}
	public void setGetOrderStatusResult(ResBean getOrderStatusResult) {
		GetOrderStatusResult = getOrderStatusResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String OrderNo;
		private String ValidCode;
		private String OrderStatus;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getOrderNo() {
			return OrderNo;
		}
		public void setOrderNo(String orderNo) {
			OrderNo = orderNo;
		}
		public String getValidCode() {
			return ValidCode;
		}
		public void setValidCode(String validCode) {
			ValidCode = validCode;
		}
		public String getOrderStatus() {
			return OrderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}
		
		
	}
}
