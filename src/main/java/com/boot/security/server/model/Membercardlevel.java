package com.boot.security.server.model;



public class Membercardlevel extends BaseEntity<Long> { 

	private Long Id;
	private String CinemaCode;
	private String LevelCode;
	private String LevelName;
	private Double CardCostFee;
	private Double MemberFee;
	private String PictureUrl;
	private Integer IsOnlineOpenCard;
	private Integer Status;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public String getLevelCode() {
		return LevelCode;
	}
	public void setLevelCode(String LevelCode) {
		this.LevelCode = LevelCode;
	}
	public String getLevelName() {
		return LevelName;
	}
	public void setLevelName(String LevelName) {
		this.LevelName = LevelName;
	}
	public Double getCardCostFee() {
		return CardCostFee;
	}
	public void setCardCostFee(Double cardCostFee) {
		CardCostFee = cardCostFee;
	}
	public Double getMemberFee() {
		return MemberFee;
	}
	public void setMemberFee(Double memberFee) {
		MemberFee = memberFee;
	}
	public String getPictureUrl() {
		return PictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		PictureUrl = pictureUrl;
	}
	public Integer getIsOnlineOpenCard() {
		return IsOnlineOpenCard;
	}
	public void setIsOnlineOpenCard(Integer isOnlineOpenCard) {
		IsOnlineOpenCard = isOnlineOpenCard;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	
}
