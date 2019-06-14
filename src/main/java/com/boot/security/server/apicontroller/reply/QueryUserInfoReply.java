package com.boot.security.server.apicontroller.reply;

public class QueryUserInfoReply extends BaseReply{
	private QueryUserInfoReplyUserInfo data;

	public QueryUserInfoReplyUserInfo getData() {
		return data;
	}

	public void setData(QueryUserInfoReplyUserInfo data) {
		this.data = data;
	}
	public static class QueryUserInfoReplyUserInfo{
		private String HeadUrl;
		private String NickName;
		private Integer Sex;
		private String Birthday;
		private String MobilePhone;
		public String getHeadUrl() {
			return HeadUrl;
		}
		public void setHeadUrl(String headUrl) {
			HeadUrl = headUrl;
		}
		public String getNickName() {
			return NickName;
		}
		public void setNickName(String nickName) {
			NickName = nickName;
		}
		public Integer getSex() {
			return Sex;
		}
		public void setSex(Integer sex) {
			Sex = sex;
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
