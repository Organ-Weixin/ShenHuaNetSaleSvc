package com.boot.security.server.api.ctms.reply;


public class Dy1905MemberInfoResult {
	private ResBean MemberInfoResult;

	public ResBean getMemberInfoResult() {
		return MemberInfoResult;
	}

	public void setMemberInfoResult(ResBean memberInfoResult) {
		MemberInfoResult = memberInfoResult;
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
			private String CardTypeNo;
			private String CardType;
			private String CardLevelNo;
			private String CardLevel;
			private String CardNo;
			private Double Balance;
			private String Username;
			private String Mobile;
			private String ExpireDate;
			private String CardLocation;
			private String CardChannel;
			
			public String getCardTypeNo() {
				return CardTypeNo;
			}
			public void setCardTypeNo(String cardTypeNo) {
				CardTypeNo = cardTypeNo;
			}
			public String getCardType() {
				return CardType;
			}
			public void setCardType(String cardType) {
				CardType = cardType;
			}
			public String getCardLevelNo() {
				return CardLevelNo;
			}
			public void setCardLevelNo(String cardLevelNo) {
				CardLevelNo = cardLevelNo;
			}
			public String getCardLevel() {
				return CardLevel;
			}
			public void setCardLevel(String cardLevel) {
				CardLevel = cardLevel;
			}
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
			public String getUsername() {
				return Username;
			}
			public void setUsername(String username) {
				Username = username;
			}
			public String getMobile() {
				return Mobile;
			}
			public void setMobile(String mobile) {
				Mobile = mobile;
			}
			public String getExpireDate() {
				return ExpireDate;
			}
			public void setExpireDate(String expireDate) {
				ExpireDate = expireDate;
			}
			public String getCardLocation() {
				return CardLocation;
			}
			public void setCardLocation(String cardLocation) {
				CardLocation = cardLocation;
			}
			public String getCardChannel() {
				return CardChannel;
			}
			public void setCardChannel(String cardChannel) {
				CardChannel = cardChannel;
			}
			
		}
	}
}
