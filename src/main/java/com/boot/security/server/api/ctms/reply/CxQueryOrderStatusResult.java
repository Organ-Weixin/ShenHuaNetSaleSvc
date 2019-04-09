package com.boot.security.server.api.ctms.reply;


public class CxQueryOrderStatusResult {
	private ResBean QueryOrderStatusResult;

	public ResBean getQueryOrderStatusResult() {
		return QueryOrderStatusResult;
	}

	public void setQueryOrderStatusResult(ResBean queryOrderStatusResult) {
		QueryOrderStatusResult = queryOrderStatusResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private String OrderCode;
		private String PrintNo;
		private String VerifyCode;
		private String OrderStatus;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getPrintNo() {
			return PrintNo;
		}
		public void setPrintNo(String printNo) {
			PrintNo = printNo;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		public String getOrderStatus() {
			return OrderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}
		
	}
	

}
