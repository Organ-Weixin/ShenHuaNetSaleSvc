package com.boot.security.server.api.core;

import com.boot.security.server.model.YesOrNoEnum;

public class RefundTicketReply extends BaseReply {
	public RefundTicketReply()
    {
        Id = ID_RefundTicketReply;
    }
	public RefundTicketReplyOrder Order;
	public RefundTicketReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(RefundTicketReplyOrder order) {
		Order = order;
	}
	public class RefundTicketReplyOrder{
		public String OrderCode;
		public String PrintNo;
		public String VerifyCode;
		public String Status;
		public String RefundTime;
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
		public String getRefundTime() {
			return RefundTime;
		}
		public void setRefundTime(String refundTime) {
			RefundTime = refundTime;
		}
		
	}

}
