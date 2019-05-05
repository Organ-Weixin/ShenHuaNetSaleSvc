package com.boot.security.server.api.ctms.reply;


public class Dy1905RefundGoodsResult {
	private ResBean RefundGoodsResult;

	public ResBean getRefundGoodsResult() {
		return RefundGoodsResult;
	}

	public void setRefundGoodsResult(ResBean refundGoodsResult) {
		RefundGoodsResult = refundGoodsResult;
	}
	public static class ResBean{
		private String ResultCode;

		public String getResultCode() {
			return ResultCode;
		}

		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		
	}
}
