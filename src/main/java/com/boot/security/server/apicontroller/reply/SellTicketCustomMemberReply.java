package com.boot.security.server.apicontroller.reply;

public class SellTicketCustomMemberReply extends BaseReply{
	private String OrderNo;
	private String PrintNo;
	private String VerifyCode;
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
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
}
