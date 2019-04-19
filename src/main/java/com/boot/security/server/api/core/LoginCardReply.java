package com.boot.security.server.api.core;

public class LoginCardReply extends BaseReply {
	public LoginCardReply() 
    {
        Id = ID_LoginCardReply;
    }
	public String CinemaCode;
	public LoginCardReplyCard Card;
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
		public String CardNo;
		public String CardPassword;
		public String MobilePhone;
		public String LevelCode;
		public String LevelName;
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
