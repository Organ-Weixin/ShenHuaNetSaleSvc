package com.boot.security.server.apicontroller.reply;

public class SendGiftReply extends BaseReply {

	private SendGiftBean data;
	
	public SendGiftBean getData() {
		return data;
	}
	public void setData(SendGiftBean data) {
		this.data = data;
	}

	public static class SendGiftBean {
		private String GiftCode;
		private String GiftName;
		private String GiftType;
		private String Image;
		
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
		
	}
}
