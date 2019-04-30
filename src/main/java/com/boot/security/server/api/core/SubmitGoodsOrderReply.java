package com.boot.security.server.api.core;

public class SubmitGoodsOrderReply extends BaseReply {
	public SubmitGoodsOrderReply()
    {
        Id = ID_SubmitGoodsOrderReply;
    }
	private SubmitGoodsOrderReplyOrder Order;
	public SubmitGoodsOrderReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(SubmitGoodsOrderReplyOrder order) {
		Order = order;
	}
	public static class SubmitGoodsOrderReplyOrder{
		private String OrderCode;//订单号
		private String PickUpCode;//取货号
		private String VerifyCode;//辰星系统取货验证码
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
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		
	}
}
