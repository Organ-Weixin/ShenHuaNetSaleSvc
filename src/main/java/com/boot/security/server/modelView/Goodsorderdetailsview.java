package com.boot.security.server.modelView;

import java.util.Date;

public class Goodsorderdetailsview  {

	private Long Id;
	private Long OrderId;
	private String GoodsCode;
	private String GoodsName;
	private String CinemaCode;
	private String CinemaName;
	private String PickUpCode;
	private String OrderCode;
	private Double SettlePrice;
	private Integer GoodsCount;
	private Double SubTotalSettleAmount;
	private Date Created;
	private String MobilePhone;
	private Integer OrderStatus;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public Long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long OrderId) {
		this.OrderId = OrderId;
	}
	public String getGoodsCode() {
		return GoodsCode;
	}
	public void setGoodsCode(String GoodsCode) {
		this.GoodsCode = GoodsCode;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String GoodsName) {
		this.GoodsName = GoodsName;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String CinemaName) {
		this.CinemaName = CinemaName;
	}
	public String getPickUpCode() {
		return PickUpCode;
	}
	public void setPickUpCode(String pickUpCode) {
		PickUpCode = pickUpCode;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public Double getSettlePrice() {
		return SettlePrice;
	}
	public void setSettlePrice(Double SettlePrice) {
		this.SettlePrice = SettlePrice;
	}
	public Integer getGoodsCount() {
		return GoodsCount;
	}
	public void setGoodsCount(Integer GoodsCount) {
		this.GoodsCount = GoodsCount;
	}
	public Double getSubTotalSettleAmount() {
		return SubTotalSettleAmount;
	}
	public void setSubTotalSettleAmount(Double SubTotalSettleAmount) {
		this.SubTotalSettleAmount = SubTotalSettleAmount;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String MobilePhone) {
		this.MobilePhone = MobilePhone;
	}
	public Integer getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(Integer OrderStatus) {
		this.OrderStatus = OrderStatus;
	}

}
