package com.boot.security.server.api.ctms.reply;

public class Dy1905GetGoodsOrderStatusResult {
	private ResBean GetGoodsOrderStatusResult;

	public ResBean getGetGoodsOrderStatusResult() {
		return GetGoodsOrderStatusResult;
	}

	public void setGetGoodsOrderStatusResult(ResBean getGoodsOrderStatusResult) {
		GetGoodsOrderStatusResult = getGoodsOrderStatusResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String NetOrder;
		private String OrderNo;
		private String Status;
		private String RefundStatus;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getNetOrder() {
			return NetOrder;
		}
		public void setNetOrder(String netOrder) {
			NetOrder = netOrder;
		}
		public String getOrderNo() {
			return OrderNo;
		}
		public void setOrderNo(String orderNo) {
			OrderNo = orderNo;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getRefundStatus() {
			return RefundStatus;
		}
		public void setRefundStatus(String refundStatus) {
			RefundStatus = refundStatus;
		}
		
	}
}
