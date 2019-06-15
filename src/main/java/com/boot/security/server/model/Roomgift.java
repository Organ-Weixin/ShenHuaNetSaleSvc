package com.boot.security.server.model;

/**
 * 放映厅礼物
 * @author sheng
 *
 */
public class Roomgift {
	private Long id;
	private String cinemaCode;
	private String giftCode;
	private String giftName;
	private String Image;
	private String giftDesc;
	private Integer groupNumber;
	private Integer sendNumber;
	private String GiftType="1";

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCinemaCode() {
		return cinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		this.cinemaCode = cinemaCode;
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
	public String getImage() {
		return Image;
	}
	public void setImage(String Image) {
		this.Image = Image;
	}
	public String getGiftDesc() {
		return giftDesc;
	}
	public void setGiftDesc(String giftDesc) {
		this.giftDesc = giftDesc;
	}
	public Integer getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(Integer groupNumber) {
		this.groupNumber = groupNumber;
	}
	public Integer getSendNumber() {
		return sendNumber;
	}
	public void setSendNumber(Integer sendNumber) {
		this.sendNumber = sendNumber;
	}
	public String getGiftType() {
		return GiftType;
	} 

}
