package com.boot.security.server.apicontroller.reply;


public class LoginCardReply extends BaseReply{
	private LoginCardReplyLogin data;

	public LoginCardReplyLogin getData() {
		return data;
	}

	public void setData(LoginCardReplyLogin data) {
		this.data = data;
	}
	public class LoginCardReplyLogin{
		private String CinemaCode;
		private LoginCardReplyCard Card;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public LoginCardReplyCard getCard() {
			return Card;
		}
		public void setCard(LoginCardReplyCard card) {
			Card = card;
		}
		public class LoginCardReplyCard{
			private String CardNo;
			private String CardPassword;
			private String MobilePhone;
			private String LevelCode;
			private String LevelName;
			public String getCardNo() {
				return CardNo;
			}
			public void setCardNo(String cardNo) {
				CardNo = cardNo;
			}
			public String getCardPassword() {
				return CardPassword;
			}
			public void setCardPassword(String cardPassword) {
				CardPassword = cardPassword;
			}
			public String getMobilePhone() {
				return MobilePhone;
			}
			public void setMobilePhone(String mobilePhone) {
				MobilePhone = mobilePhone;
			}
			public String getLevelCode() {
				return LevelCode;
			}
			public void setLevelCode(String levelCode) {
				LevelCode = levelCode;
			}
			public String getLevelName() {
				return LevelName;
			}
			public void setLevelName(String levelName) {
				LevelName = levelName;
			}
			
		}
	}
}
