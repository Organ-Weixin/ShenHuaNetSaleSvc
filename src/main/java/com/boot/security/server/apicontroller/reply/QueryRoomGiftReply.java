package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryRoomGiftReply  extends BaseReply {

	private List<RoomGiftReply> data;
	
	public List<RoomGiftReply> getData() {
		return data;
	}
	public void setData(List<RoomGiftReply> data) {
		this.data = data;
	}

	public static class RoomGiftReply {
		private String GiftCode;
		private String GiftName;
		private String GiftType;
		private String SendNumber;
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
		public String getSendNumber() {
			return SendNumber;
		}
		public void setSendNumber(String sendNumber) {
			SendNumber = sendNumber;
		}
		public String getImage() {
			return Image;
		}
		public void setImage(String image) {
			Image = image;
		}
		
	}
}
