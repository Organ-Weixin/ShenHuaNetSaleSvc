package com.boot.security.server.api.core;

public class QueryCardReply extends BaseReply {
	public QueryCardReply() 
    {
        Id = ID_QueryCardReply;
    }
	public String CinemaCode;
	public QueryCardReplyCard Card;
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public QueryCardReplyCard getCard() {
		return Card;
	}
	public void setCard(QueryCardReplyCard card) {
		Card = card;
	}
	public class QueryCardReplyCard{
		public String CardNo;
		public String CardPassword;
		public String LevelCode;
		public String LevelName;
		public String Score;
		public String Balance;
		public String UserName;
		public String Sex;
		public String CreditNum;
		public String Birthday;
		public String MobilePhone;
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
		public String getScore() {
			return Score;
		}
		public void setScore(String score) {
			Score = score;
		}
		public String getBalance() {
			return Balance;
		}
		public void setBalance(String balance) {
			Balance = balance;
		}
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getSex() {
			return Sex;
		}
		public void setSex(String sex) {
			Sex = sex;
		}
		public String getCreditNum() {
			return CreditNum;
		}
		public void setCreditNum(String creditNum) {
			CreditNum = creditNum;
		}
		public String getBirthday() {
			return Birthday;
		}
		public void setBirthday(String birthday) {
			Birthday = birthday;
		}
		public String getMobilePhone() {
			return MobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			MobilePhone = mobilePhone;
		}
		
	}

}
