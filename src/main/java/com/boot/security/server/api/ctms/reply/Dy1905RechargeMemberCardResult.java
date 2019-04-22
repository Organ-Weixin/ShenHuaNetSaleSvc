package com.boot.security.server.api.ctms.reply;

public class Dy1905RechargeMemberCardResult {
	private ResBean RechargeMemberCardResult;

	public ResBean getRechargeMemberCardResult() {
		return RechargeMemberCardResult;
	}

	public void setRechargeMemberCardResult(ResBean rechargeMemberCardResult) {
		RechargeMemberCardResult = rechargeMemberCardResult;
	}
	public class ResBean{
		private String ResultCode;
		private String ResultMsg;
		private RechargeInfoBean RechargeInfo;
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
		public RechargeInfoBean getRechargeInfo() {
			return RechargeInfo;
		}
		public void setRechargeInfo(RechargeInfoBean rechargeInfo) {
			RechargeInfo = rechargeInfo;
		}
		public class RechargeInfoBean{
			private String CardNo;
			private String RechargeBalance;
			private String TotalBalance;
			public String getCardNo() {
				return CardNo;
			}
			public void setCardNo(String cardNo) {
				CardNo = cardNo;
			}
			public String getRechargeBalance() {
				return RechargeBalance;
			}
			public void setRechargeBalance(String rechargeBalance) {
				RechargeBalance = rechargeBalance;
			}
			public String getTotalBalance() {
				return TotalBalance;
			}
			public void setTotalBalance(String totalBalance) {
				TotalBalance = totalBalance;
			}
		}
	}
}
