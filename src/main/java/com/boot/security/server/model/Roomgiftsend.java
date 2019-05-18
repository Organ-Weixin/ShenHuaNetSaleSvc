package com.boot.security.server.model;

import java.util.Date;
/**
 * 放映厅礼物发送记录
 * @author sheng
 *
 */
public class Roomgiftsend {
	private Long id;
	private String roomCode;
	private String giftCode;
	private String giftName;
	private String giftType;
	private Integer sendNumber;
	private String sendUserphone;
	private Date sendTime;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getGiftCode() {
		return giftCode;
	}
	public void setGiftCode(String giftCode) {
		this.giftCode = giftCode;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public String getGiftType() {
		return giftType;
	}
	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}
	public Integer getSendNumber() {
		return sendNumber;
	}
	public void setSendNumber(Integer sendNumber) {
		this.sendNumber = sendNumber;
	}
	public String getSendUserphone() {
		return sendUserphone;
	}
	public void setSendUserphone(String sendUserphone) {
		this.sendUserphone = sendUserphone;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

}
