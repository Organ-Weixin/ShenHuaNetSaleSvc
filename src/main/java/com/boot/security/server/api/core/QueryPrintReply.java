package com.boot.security.server.api.core;


public class QueryPrintReply extends BaseReply {
	public QueryPrintReply()
    {
        Id = ID_QueryPrintReply;
    }
	private QueryPrintReplyOrder Order;
	public QueryPrintReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(QueryPrintReplyOrder order) {
		Order = order;
	}
	public class QueryPrintReplyOrder{
		private String OrderCode;
		private String PrintNo;
		private String VerifyCode;
		private String Status;
		private String PrintTime;
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getPrintNo() {
			return PrintNo;
		}
		public void setPrintNo(String printNo) {
			PrintNo = printNo;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		public String getPrintTime() {
			return PrintTime;
		}
		public void setPrintTime(String printTime) {
			PrintTime = printTime;
		}
		
	}

}
