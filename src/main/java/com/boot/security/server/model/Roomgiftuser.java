package com.boot.security.server.model;

import java.util.Date;
/**
 * 用户领取礼物记录
 * @author sheng
 *
 */
public class Roomgiftuser  {

	private Long Id;
	private String OpenID;
	private String RoomCode;
	private String GiftCode;
	private String GiftName;
	private String Image;
	private Date GetDate;
	private Date StartDate;
	private Date ExpireDate;
	private String giftType;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String OpenID) {
		this.OpenID = OpenID;
	}
	public String getRoomCode() {
		return RoomCode;
	}
	public void setRoomCode(String RoomCode) {
		this.RoomCode = RoomCode;
	}
	public String getGiftCode() {
		return GiftCode;
	}
	public void setGiftCode(String GiftCode) {
		this.GiftCode = GiftCode;
	}
	public String getGiftName() {
		return GiftName;
	}
	public void setGiftName(String GiftName) {
		this.GiftName = GiftName;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String Image) {
		this.Image = Image;
	}
	public Date getGetDate() {
		return GetDate;
	}
	public void setGetDate(Date GetDate) {
		this.GetDate = GetDate;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getExpireDate() {
		return ExpireDate;
	}
	public void setExpireDate(Date ExpireDate) {
		this.ExpireDate = ExpireDate;
	}
	public String getGiftType() {
		return giftType;
	}
	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}

}
