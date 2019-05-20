package com.boot.security.server.apicontroller.reply;

import java.util.List;
/**
 * 放映厅房间用户领取奖品记录
 * @author sheng
 *
 */
public class QueryRoomGiftRecordReply extends BaseReply {

	private List<QueryRoomGiftRecord> data;
	
	public List<QueryRoomGiftRecord> getData() {
		return data;
	}
	public void setData(List<QueryRoomGiftRecord> data) {
		this.data = data;
	}

	public static class QueryRoomGiftRecord {
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
