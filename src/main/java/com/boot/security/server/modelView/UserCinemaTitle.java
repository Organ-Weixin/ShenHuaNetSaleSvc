package com.boot.security.server.modelView;

import java.util.Date;

/**
 * 接入商可访问影院
 * @author sheng
 *
 */
public class UserCinemaTitle {
	private Long id;
	private Long UserId;
	private String CinemaCode;
	private String CinemaName;
	private String Title;
	private String PayType;
	private Date ExpDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String cinemaName) {
		CinemaName = cinemaName;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	public Date getExpDate() {
		return ExpDate;
	}
	public void setExpDate(Date expDate) {
		ExpDate = expDate;
	}
	
}
