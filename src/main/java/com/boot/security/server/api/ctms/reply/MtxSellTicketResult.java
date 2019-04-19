package com.boot.security.server.api.ctms.reply;



public class MtxSellTicketResult {
	// 卖常规票（带座位票）
	private ResBean SellTicketResult;
	public ResBean getSellTicketResult() {
		return SellTicketResult;
	}
	public void setSellTicketResult(ResBean sellTicketResult) {
		SellTicketResult = sellTicketResult;
	}
	public static class ResBean {
		private String ResultCode;
		private String OrderNo;
		private  String ValidCode;
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
		
	}
}
