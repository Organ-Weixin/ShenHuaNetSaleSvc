package com.boot.security.server.apicontroller.reply;

public class RefundPaymentReply extends BaseReply {
	private RefundPaymentReplyOrder data;

	public RefundPaymentReplyOrder getData() {
		return data;
	}

	public void setData(RefundPaymentReplyOrder data) {
		this.data = data;
	}
	public static class RefundPaymentReplyOrder{
		private String OrderCode;
		private String OrderStatus;
		private String RefundTime;
		private String RefundTradeNo;
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getOrderStatus() {
			return OrderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}
		public String getRefundTime() {
			return RefundTime;
		}
		public void setRefundTime(String refundTime) {
			RefundTime = refundTime;
		}
		public String getRefundTradeNo() {
			return RefundTradeNo;
		}
		public void setRefundTradeNo(String refundTradeNo) {
			RefundTradeNo = refundTradeNo;
		}
		
	}
	

}
