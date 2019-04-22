package com.boot.security.server.api.ctms.reply;

public class Dy1905MemberCardDeductResult {
	private ResBean MemberCardDeductResult;
	
	public ResBean getMemberCardDeductResult() {
		return MemberCardDeductResult;
	}

	public void setMemberCardDeductResult(ResBean memberCardDeductResult) {
		MemberCardDeductResult = memberCardDeductResult;
	}

	public class ResBean{
		private String ResultCode;
		private String ResultMsg;
		private CardInfoBean CardInfo;
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
		public CardInfoBean getCardInfo() {
			return CardInfo;
		}
		public void setCardInfo(CardInfoBean cardInfo) {
			CardInfo = cardInfo;
		}
		public class CardInfoBean{
			private String CardNo;
			private String Balance;
			private String AcBalance;
			private String CreateTime;
			public String getCardNo() {
				return CardNo;
			}
			public void setCardNo(String cardNo) {
				CardNo = cardNo;
			}
			public String getBalance() {
				return Balance;
			}
			public void setBalance(String balance) {
				Balance = balance;
			}
			public String getAcBalance() {
				return AcBalance;
			}
			public void setAcBalance(String acBalance) {
				AcBalance = acBalance;
			}
			public String getCreateTime() {
				return CreateTime;
			}
			public void setCreateTime(String createTime) {
				CreateTime = createTime;
			}
				
		}
	}
}
