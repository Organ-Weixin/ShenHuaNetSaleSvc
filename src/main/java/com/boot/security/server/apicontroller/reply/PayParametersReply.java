package com.boot.security.server.apicontroller.reply;

public class PayParametersReply extends BaseReply {
	private PayParametersReplyParameter data;

	public PayParametersReplyParameter getData() {
		return data;
	}

	public void setData(PayParametersReplyParameter data) {
		this.data = data;
	}
	public static class PayParametersReplyParameter{
		private String timeStamp;
		private String nonceStr;
		private String packages;
		private String signType;
		private String paySign;
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		public String getNonceStr() {
			return nonceStr;
		}
		public void setNonceStr(String nonceStr) {
			this.nonceStr = nonceStr;
		}
		public String getPackages() {
			return packages;
		}
		public void setPackages(String packages) {
			this.packages = packages;
		}
		public String getSignType() {
			return signType;
		}
		public void setSignType(String signType) {
			this.signType = signType;
		}
		public String getPaySign() {
			return paySign;
		}
		public void setPaySign(String paySign) {
			this.paySign = paySign;
		}
		
	}
}
