package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryMemberCardByOpenIDReply extends BaseReply{
	private QueryMemberCardByOpenIDReplyOpenIDCard data;

	public QueryMemberCardByOpenIDReplyOpenIDCard getData() {
		return data;
	}

	public void setData(QueryMemberCardByOpenIDReplyOpenIDCard data) {
		this.data = data;
	}
	public static class QueryMemberCardByOpenIDReplyOpenIDCard{
		private String CinemaCode;
		private String MemberPhoneCount;
		private List<QueryMemberCardByOpenIDReplyOpenIDMemberCard> MemberCard;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getMemberPhoneCount() {
			return MemberPhoneCount;
		}
		public void setMemberPhoneCount(String memberPhoneCount) {
			MemberPhoneCount = memberPhoneCount;
		}
		public List<QueryMemberCardByOpenIDReplyOpenIDMemberCard> getMemberCard() {
			return MemberCard;
		}
		public void setMemberCard(List<QueryMemberCardByOpenIDReplyOpenIDMemberCard> memberCard) {
			MemberCard = memberCard;
		}
		public static class QueryMemberCardByOpenIDReplyOpenIDMemberCard{
			private String OpenID;
			private String MobilePhone;
			private String CardNo;
			private String Balance;
			private String Score;
			private String LevelCode;
			private String LevelName;
			private String UserName;
			private String Sex;
			private String CreditNum;
			private String Birthday;
			private String ExpireDate;
			private String Status;
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
			public String getScore() {
				return Score;
			}
			public void setScore(String score) {
				Score = score;
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
			public String getExpireDate() {
				return ExpireDate;
			}
			public void setExpireDate(String expireDate) {
				ExpireDate = expireDate;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			
		}
	}
}
