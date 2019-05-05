package com.boot.security.server.api.ctms.reply; 

public class Dy1905GoodsOrderResult {
	private ResBean GoodsOrderResult;

	public ResBean getGoodsOrderResult() {
		return GoodsOrderResult;
	}

	public void setGoodsOrderResult(ResBean goodsOrderResult) {
		GoodsOrderResult = goodsOrderResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String OrderNo;
		private String ResultMsg;
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
		public String getResultMsg() {
			return ResultMsg;
		}
		public void setResultMsg(String resultMsg) {
			ResultMsg = resultMsg;
		}
		
	}
}
