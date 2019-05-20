package com.boot.security.server.apicontroller.reply;

public class RoomGiftInput {

	private String UserName;
	private String Password;
	private String CinemaCode;
	private String RoomCode;
	private String GiftCode;
	private String GiftType;
	private int SendNumber;
	private String OpenID;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getRoomCode() {
		return RoomCode;
	}
	public void setRoomCode(String roomCode) {
		RoomCode = roomCode;
	}
	public String getGiftType() {
		return GiftType;
	}
	public void setGiftType(String giftType) {
		GiftType = giftType;
	}
	public String getGiftCode() {
		return GiftCode;
	}
	public void setGiftCode(String giftCode) {
		GiftCode = giftCode;
	}
	public int getSendNumber() {
		return SendNumber;
	}
	public void setSendNumber(int sendNumber) {
		SendNumber = sendNumber;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String openID) {
		OpenID = openID;
	}
	
}
