package com.boot.security.server.apicontroller.reply;

public class MobilePhoneRegisterReply extends BaseReply{

	private MobilePhoneRegisterBean data;
	
	public MobilePhoneRegisterBean getData() {
		return data;
	}
	public void setData(MobilePhoneRegisterBean data) {
		this.data = data;
	}

	public static class MobilePhoneRegisterBean {
		private String CinemaCode;
		private String OpenID;
		private String MobilePhone;
		private String VerifyCode;
		
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getOpenID() {
			return OpenID;
		}
		public void setOpenID(String openID) {
			OpenID = openID;
		}
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
