package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryMemberCardByPhoneReply extends BaseReply{
	private QueryMemberCardByPhoneReplyMemberCardByPhone data;

	public QueryMemberCardByPhoneReplyMemberCardByPhone getData() {
		return data;
	}

	public void setData(QueryMemberCardByPhoneReplyMemberCardByPhone data) {
		this.data = data;
	}
	public class QueryMemberCardByPhoneReplyMemberCardByPhone{
		private int MemberPhoneCount;
		private List<QueryMemberCardByPhoneReplyPhone> MemberPhones;
		public int getMemberPhoneCount() {
			return MemberPhoneCount;
		}
		public void setMemberPhoneCount(int memberPhoneCount) {
			MemberPhoneCount = memberPhoneCount;
		}
		public List<QueryMemberCardByPhoneReplyPhone> getMemberPhones() {
			return MemberPhones;
		}
		public void setMemberPhones(List<QueryMemberCardByPhoneReplyPhone> memberPhones) {
			MemberPhones = memberPhones;
		}
		public class QueryMemberCardByPhoneReplyPhone{
			private Long MemberPhoneId;
			private String CinemaCode;
			private String OpenID;
			private String MobilePhone;
			private String CardNo;
			private String CardPassword;
			private Float Balance;
			private int Score;
			private String LevelCode;
			private String LevelName;
			private String UserName;
			private String Sex;
			private String CreditNum;
			private String Birthday;
			private String ExpireDate;
			private String Status;
			public Long getMemberPhoneId() {
				return MemberPhoneId;
			}
			public void setMemberPhoneId(Long memberPhoneId) {
				MemberPhoneId = memberPhoneId;
			}
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}
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
			public String getCardPassword() {
				return CardPassword;
			}
			public void setCardPassword(String cardPassword) {
				CardPassword = cardPassword;
			}
			public Float getBalance() {
				return Balance;
			}
			public void setBalance(Float balance) {
				Balance = balance;
			}
			public int getScore() {
				return Score;
			}
			public void setScore(int score) {
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
