package com.boot.security.server.api.core;


public class RefundGoodsReply extends BaseReply {
	public RefundGoodsReply()
    {
        Id = ID_RefundGoodsReply;
    }
	private RefundGoodsReplyOrder Order;
	public RefundGoodsReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(RefundGoodsReplyOrder order) {
		Order = order;
	}
	public static class RefundGoodsReplyOrder{
		private String OrderCode;
		private String RefundStatus;
		private String RefundTime;
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		
		public String getRefundStatus() {
			return RefundStatus;
		}
		public void setRefundStatus(String refundStatus) {
			RefundStatus = refundStatus;
		}
		public String getRefundTime() {
			return RefundTime;
		}
		public void setRefundTime(String refundTime) {
			RefundTime = refundTime;
		}
		
	}
	

}
