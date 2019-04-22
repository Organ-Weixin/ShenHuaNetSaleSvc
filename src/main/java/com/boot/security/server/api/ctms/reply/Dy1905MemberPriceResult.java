package com.boot.security.server.api.ctms.reply;

public class Dy1905MemberPriceResult {
	private ResBean MemberPriceResult;

	public ResBean getMemberPriceResult() {
		return MemberPriceResult;
	}

	public void setMemberPriceResult(ResBean memberPriceResult) {
		MemberPriceResult = memberPriceResult;
	}
	public class ResBean{
		private String ResultCode;
		private String ResultMsg;
		private SessionInfoBean SessionInfo;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getResultMsg() {
			return ResultMsg;
		}
		public void setResultMsg(String resultMsg) {
			ResultMsg = resultMsg;
		}
		public SessionInfoBean getSessionInfo() {
			return SessionInfo;
		}
		public void setSessionInfo(SessionInfoBean sessionInfo) {
			SessionInfo = sessionInfo;
		}
		public class SessionInfoBean{
			private String MemberPrice;

			public String getMemberPrice() {
				return MemberPrice;
			}

			public void setMemberPrice(String memberPrice) {
				MemberPrice = memberPrice;
			}
		}
	}
}
