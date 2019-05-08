package com.boot.security.server.apicontroller.reply;

public class SendVerifyCodeReply extends BaseReply{

	private SendVerifyCodeBean data;
	
	public SendVerifyCodeBean getData() {
		return data;
	}
	public void setData(SendVerifyCodeBean data) {
		this.data = data;
	}

	public static class SendVerifyCodeBean {
		private String MobilePhone;
		private String VerifyCode;
		
		public String getMobilePhone() {
			return MobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			MobilePhone = mobilePhone;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		
	}
}
