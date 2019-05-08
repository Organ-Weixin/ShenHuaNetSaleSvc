package com.boot.security.server.apicontroller.reply;

public class UserLoginReply extends BaseReply {

	private UserLoginResult data;
	
	public UserLoginResult getData() {
		return data;
	}
	public void setData(UserLoginResult data) {
		this.data = data;
	}

	public static class UserLoginResult {
		private Long TicketUserId;
		private String CinemaCode;
		private String MobilePhone;
		private String OpenID;
		private String NickName;
		private String Sex;
		private String Country;
		private String Province;
		private String City;
		private String HeadlmgUrl;
		private String Language;
		private String TotalScore;
		private String IsActive;
		private String Created;
		
		public Long getTicketUserId() {
			return TicketUserId;
		}
		public void setTicketUserId(Long ticketUserId) {
			TicketUserId = ticketUserId;
		}
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getMobilePhone() {
			return MobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			MobilePhone = mobilePhone;
		}
		public String getOpenID() {
			return OpenID;
		}
		public void setOpenID(String openID) {
			OpenID = openID;
		}
		public String getNickName() {
			return NickName;
		}
		public void setNickName(String nickName) {
			NickName = nickName;
		}
		public String getSex() {
			return Sex;
		}
		public void setSex(String sex) {
			Sex = sex;
		}
		public String getCountry() {
			return Country;
		}
		public void setCountry(String country) {
			Country = country;
		}
		public String getProvince() {
			return Province;
		}
		public void setProvince(String province) {
			Province = province;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getHeadlmgUrl() {
			return HeadlmgUrl;
		}
		public void setHeadlmgUrl(String headlmgUrl) {
			HeadlmgUrl = headlmgUrl;
		}
		public String getLanguage() {
			return Language;
		}
		public void setLanguage(String language) {
			Language = language;
		}
		public String getTotalScore() {
			return TotalScore;
		}
		public void setTotalScore(String totalScore) {
			TotalScore = totalScore;
		}
		public String getIsActive() {
			return IsActive;
		}
		public void setIsActive(String isActive) {
			IsActive = isActive;
		}
		public String getCreated() {
			return Created;
		}
		public void setCreated(String created) {
			Created = created;
		}
		
	}
}
