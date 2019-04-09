package com.boot.security.server.api.ctms.reply;

public class Dy1905RefundTicketResult {
	private ResBean RealCheckSeatStateResult;

	public ResBean getRealCheckSeatStateResult() {
		return RealCheckSeatStateResult;
	}

	public void setRealCheckSeatStateResult(ResBean realCheckSeatStateResult) {
		RealCheckSeatStateResult = realCheckSeatStateResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String OrderNo;
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
		
	}
}
