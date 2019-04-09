package com.boot.security.server.api.core;

import com.boot.security.server.model.YesOrNoEnum;

public class QueryPrintReply extends BaseReply {
	public QueryPrintReply()
    {
        Id = ID_QueryPrintReply;
    }
	public QueryPrintReplyOrder Order;
	public QueryPrintReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(QueryPrintReplyOrder order) {
		Order = order;
	}
	public class QueryPrintReplyOrder{
		public String OrderCode;
		public String PrintNo;
		public String VerifyCode;
		public String Status;
		public String PrintTime;
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
