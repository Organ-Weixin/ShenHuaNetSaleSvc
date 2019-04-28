package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class Goodsorders extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private Integer UserId;
	private String LocalOrderCode;
	private String OrderCode;
	private String PickUpCode;
	private String VerifyCode;
	private Integer OrderStatus;
	private BigDecimal TotalPrice;
	private BigDecimal TotalFee;
	private Date SubmitTime;
	private Date Created;
	private Date Updated;
	private String MobilePhone;
	private Integer GoodsCount;
	private Date RefundTime;
	private Date PickUpTime;
	private String DeliveryAddress;
	private Date SendTime;
	private Integer OrderPayFlag;
	private Integer OrderPayType;
	private Date OrderPayTime;
	private String OrderTradeNo;

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
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer UserId) {
		this.UserId = UserId;
	}
	public String getLocalOrderCode() {
		return LocalOrderCode;
	}
	public void setLocalOrderCode(String LocalOrderCode) {
		this.LocalOrderCode = LocalOrderCode;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String OrderCode) {
		this.OrderCode = OrderCode;
	}
	public String getPickUpCode() {
		return PickUpCode;
	}
	public void setPickUpCode(String PickUpCode) {
		this.PickUpCode = PickUpCode;
	}
	public String getVerifyCode() {
		return VerifyCode;
	}
	public void setVerifyCode(String VerifyCode) {
		this.VerifyCode = VerifyCode;
	}
	public Integer getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(Integer OrderStatus) {
		this.OrderStatus = OrderStatus;
	}
	public BigDecimal getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(BigDecimal TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
	public BigDecimal getTotalFee() {
		return TotalFee;
	}
	public void setTotalFee(BigDecimal TotalFee) {
		this.TotalFee = TotalFee;
	}
	public Date getSubmitTime() {
		return SubmitTime;
	}
	public void setSubmitTime(Date SubmitTime) {
		this.SubmitTime = SubmitTime;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date Updated) {
		this.Updated = Updated;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String MobilePhone) {
		this.MobilePhone = MobilePhone;
	}
	public Integer getGoodsCount() {
		return GoodsCount;
	}
	public void setGoodsCount(Integer GoodsCount) {
		this.GoodsCount = GoodsCount;
	}
	public Date getRefundTime() {
		return RefundTime;
	}
	public void setRefundTime(Date RefundTime) {
		this.RefundTime = RefundTime;
	}
	public Date getPickUpTime() {
		return PickUpTime;
	}
	public void setPickUpTime(Date PickUpTime) {
		this.PickUpTime = PickUpTime;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress;
	}
	public void setDeliveryAddress(String DeliveryAddress) {
		this.DeliveryAddress = DeliveryAddress;
	}
	public Date getSendTime() {
		return SendTime;
	}
	public void setSendTime(Date SendTime) {
		this.SendTime = SendTime;
	}
	public Integer getOrderPayFlag() {
		return OrderPayFlag;
	}
	public void setOrderPayFlag(Integer OrderPayFlag) {
		this.OrderPayFlag = OrderPayFlag;
	}
	public Integer getOrderPayType() {
		return OrderPayType;
	}
	public void setOrderPayType(Integer OrderPayType) {
		this.OrderPayType = OrderPayType;
	}
	public Date getOrderPayTime() {
		return OrderPayTime;
	}
	public void setOrderPayTime(Date OrderPayTime) {
		this.OrderPayTime = OrderPayTime;
	}
	public String getOrderTradeNo() {
		return OrderTradeNo;
	}
	public void setOrderTradeNo(String OrderTradeNo) {
		this.OrderTradeNo = OrderTradeNo;
	}

}
