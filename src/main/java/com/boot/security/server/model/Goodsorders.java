package com.boot.security.server.model;

import java.util.Date;

public class Goodsorders extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private Long UserId;
	private String LocalOrderCode;
	private String OrderCode;
	private String PickUpCode;
	private String VerifyCode;
	private Integer OrderStatus;
	private Double TotalPrice;
	private Double TotalSettlePrice;
	private Double TotalFee;
	private Date SubmitTime;
	private Date Created;
	private Date Updated;
	private String MobilePhone;
	private Integer GoodsCount;
	private String RefundTradeNo;
	private Date RefundTime;
	private Date PickUpTime;
	private Integer DeliveryType;
	private String DeliveryAddress;
	private String DeliveryTime;
	private String DeliveryMark;
	private Integer IsReady;
	private Integer OrderPayFlag;
	private Integer OrderPayType;
	private Date OrderPayTime;
	private String OrderTradeNo;
	private String PayType;
	private String PaySeqNo;
	private String CardNo;
	private String CardPassword;
	private String ErrorMessage;
	private String OpenID;
	private String CouponsCode;
	private Double CouponsPrice;

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
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long UserId) {
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
	public Double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(Double TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
	public Double getTotalSettlePrice() {
		return TotalSettlePrice;
	}
	public void setTotalSettlePrice(Double TotalSettlePrice) {
		this.TotalSettlePrice = TotalSettlePrice;
	}
	public Double getTotalFee() {
		return TotalFee;
	}
	public void setTotalFee(Double TotalFee) {
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
	
	public String getRefundTradeNo() {
		return RefundTradeNo;
	}
	public void setRefundTradeNo(String refundTradeNo) {
		RefundTradeNo = refundTradeNo;
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
	public Integer getDeliveryType() {
		return DeliveryType;
	}
	public void setDeliveryType(Integer DeliveryType) {
		this.DeliveryType = DeliveryType;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress;
	}
	public void setDeliveryAddress(String DeliveryAddress) {
		this.DeliveryAddress = DeliveryAddress;
	}
	public String getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(String DeliveryTime) {
		this.DeliveryTime = DeliveryTime;
	}
	public String getDeliveryMark() {
		return DeliveryMark;
	}
	public void setDeliveryMark(String DeliveryMark) {
		this.DeliveryMark = DeliveryMark;
	}
	
	public Integer getIsReady() {
		return IsReady;
	}
	public void setIsReady(Integer isReady) {
		IsReady = isReady;
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
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String PayType) {
		this.PayType = PayType;
	}
	public String getPaySeqNo() {
		return PaySeqNo;
	}
	public void setPaySeqNo(String PaySeqNo) {
		this.PaySeqNo = PaySeqNo;
	}
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String CardNo) {
		this.CardNo = CardNo;
	}
	public String getCardPassword() {
		return CardPassword;
	}
	public void setCardPassword(String CardPassword) {
		this.CardPassword = CardPassword;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String ErrorMessage) {
		this.ErrorMessage = ErrorMessage;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String openID) {
		OpenID = openID;
	}
	public String getCouponsCode() {
		return CouponsCode;
	}
	public void setCouponsCode(String couponsCode) {
		CouponsCode = couponsCode;
	}
	public Double getCouponsPrice() {
		return CouponsPrice;
	}
	public void setCouponsPrice(Double couponsPrice) {
		CouponsPrice = couponsPrice;
	}
	

}
