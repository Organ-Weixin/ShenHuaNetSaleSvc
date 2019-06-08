package com.boot.security.server.api.ctms.reply;

public class Dy1905SellTicketCustomMemberResult {
	private ResBean SellTicketResult;

	public ResBean getSellTicketResult() {
		return SellTicketResult;
	}

	public void setSellTicketResult(ResBean sellTicketResult) {
		SellTicketResult = sellTicketResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String ResultMsg;
		private String OrderNo;
		private String PrintNo;
		private String VerifyCode;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getResultMsg() {
			return ResultMsg;
		}
		public void setResultMsg(String resultMsg) {
			ResultMsg = resultMsg;
		}
		public String getOrderNo() {
			return OrderNo;
		}
		public void setOrderNo(String orderNo) {
			OrderNo = orderNo;
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
		
	}
}
