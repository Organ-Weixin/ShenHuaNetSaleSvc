package com.boot.security.server.apicontroller.reply;

public class RoomGiftReply extends BaseReply {

	private RoomGiftResult data;
	
	public RoomGiftResult getData() {
		return data;
	}
	public void setData(RoomGiftResult data) {
		this.data = data;
	}

	public static class RoomGiftResult {
		private String OpenID;
		private String GiftCode;
		private String GiftName;
		private String GiftType;
		private String Image;
		private String GetDate;
		private String StartDate;
		private String ExpireDate;
		
		public String getOpenID() {
			return OpenID;
		}
		public void setOpenID(String openID) {
			OpenID = openID;
		}
		public String getGiftCode() {
			return GiftCode;
		}
		public void setGiftCode(String giftCode) {
			GiftCode = giftCode;
		}
		public String getGiftName() {
			return GiftName;
		}
		public void setGiftName(String giftName) {
			GiftName = giftName;
		}
		public String getGiftType() {
			return GiftType;
		}
		public void setGiftType(String giftType) {
			GiftType = giftType;
		}
		public String getImage() {
			return Image;
		}
		public void setImage(String image) {
			Image = image;
		}
		public String getGetDate() {
			return GetDate;
		}
		public void setGetDate(String getDate) {
			GetDate = getDate;
		}
		public String getStartDate() {
			return StartDate;
		}
		public void setStartDate(String startDate) {
			StartDate = startDate;
		}
		public String getExpireDate() {
			return ExpireDate;
		}
		public void setExpireDate(String expireDate) {
			ExpireDate = expireDate;
		}
		
	}
}
