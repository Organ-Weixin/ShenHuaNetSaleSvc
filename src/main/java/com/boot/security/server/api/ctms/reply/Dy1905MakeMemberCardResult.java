package com.boot.security.server.api.ctms.reply;

import java.util.Date;

public class Dy1905MakeMemberCardResult {
	private ResBean MakeMemberCardResult;

	public ResBean getMakeMemberCardResult() {
		return MakeMemberCardResult;
	}

	public void setMakeMemberCardResult(ResBean makeMemberCardResult) {
		MakeMemberCardResult = makeMemberCardResult;
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
			private Double Balance;
			private Long ExpireDate;
			private Long CreateTime;

			public String getCardNo() {
				return CardNo;
			}

			public void setCardNo(String cardNo) {
				CardNo = cardNo;
			}

			public Double getBalance() {
				return Balance;
			}

			public void setBalance(Double balance) {
				Balance = balance;
			}

			public Long getExpireDate() {
				return ExpireDate;
			}

			public void setExpireDate(Long expireDate) {
				ExpireDate = expireDate;
			}

			public Long getCreateTime() {
				return CreateTime;
			}

			public void setCreateTime(Long createTime) {
				CreateTime = createTime;
			}
			
		}
	}
}
