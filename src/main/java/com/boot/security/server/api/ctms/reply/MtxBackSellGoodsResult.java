package com.boot.security.server.api.ctms.reply;


public class MtxBackSellGoodsResult {
	//退卖品
	private ResBean BackSellGoodsResult;

	public ResBean getBackSellGoodsResult() {
		return BackSellGoodsResult;
	}

	public void setBackSellGoodsResult(ResBean backSellGoodsResult) {
		BackSellGoodsResult = backSellGoodsResult;
	}
	public static class ResBean {
		private String ResultCode;

		public String getResultCode() {
			return ResultCode;
		}

		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		
	}
}
