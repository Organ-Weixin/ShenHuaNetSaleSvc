package com.boot.security.server.api.ctms.reply;

public class MtxGetDiscountResult {
//	getDiscount 会员卡折扣查询
	private ResBean GetDiscountReturn;

	public ResBean getGetDiscountReturn() {
		return GetDiscountReturn;
	}

	public void setGetDiscountReturn(ResBean getDiscountReturn) {
		GetDiscountReturn = getDiscountReturn;
	}
	public static class ResBean{ 
		private String ResultCode;//返回码
		private String ResultMsg;//返回描述
		private String DiscountType;//折扣类型 0 折扣 1固定票价
		private String Price;//票价/折扣
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
		public String getDiscountType() {
			return DiscountType;
		}
		public void setDiscountType(String discountType) {
			DiscountType = discountType;
		}
		public String getPrice() {
			return Price;
		}
		public void setPrice(String price) {
			Price = price;
		}
		
	}
	
}
