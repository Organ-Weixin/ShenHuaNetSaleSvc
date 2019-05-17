package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryGoodsOrderReply extends BaseReply {
	private QueryGoodsOrderReplyOrder data;

	public QueryGoodsOrderReplyOrder getData() {
		return data;
	}

	public void setData(QueryGoodsOrderReplyOrder data) {
		this.data = data;
	}
	public static class QueryGoodsOrderReplyOrder{
		private String CinemaCode;
		private String LocalOrderCode;
		private String OrderCode;
		private String PickUpCode;
		private String VerifyCode;
		private String OrderStatus;
		private Double TotalPrice;
		private Double TotalSettlePrice;
		private Double TotalFee;
		private String SubmitTime;
		private String Created;
		private String MobilePhone;
		private int GoodsCount;
		private String RefundTime;
		private String PickUpTime;
		private String DeliveryType;
		private String DeliveryAddress;
		private String DeliveryTime;
		private String OrderPayFlag;
		private String OrderPayType;
		private String OrderPayTime;
		private String OrderTradeNo;
		private String CardNo;
		private String CardPassword;
		private String OpenID;
		private QueryGoodsOrderReplyGoodsList GoodsList;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getLocalOrderCode() {
			return LocalOrderCode;
		}
		public void setLocalOrderCode(String localOrderCode) {
			LocalOrderCode = localOrderCode;
		}
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getPickUpCode() {
			return PickUpCode;
		}
		public void setPickUpCode(String pickUpCode) {
			PickUpCode = pickUpCode;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		public String getOrderStatus() {
			return OrderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}
		public Double getTotalPrice() {
			return TotalPrice;
		}
		public void setTotalPrice(Double totalPrice) {
			TotalPrice = totalPrice;
		}
		public Double getTotalSettlePrice() {
			return TotalSettlePrice;
		}
		public void setTotalSettlePrice(Double totalSettlePrice) {
			TotalSettlePrice = totalSettlePrice;
		}
		public Double getTotalFee() {
			return TotalFee;
		}
		public void setTotalFee(Double totalFee) {
			TotalFee = totalFee;
		}
		public String getSubmitTime() {
			return SubmitTime;
		}
		public void setSubmitTime(String submitTime) {
			SubmitTime = submitTime;
		}
		public String getCreated() {
			return Created;
		}
		public void setCreated(String created) {
			Created = created;
		}
		public String getMobilePhone() {
			return MobilePhone;
		}
		public void setMobilePhone(String mobilePhone) {
			MobilePhone = mobilePhone;
		}
		public int getGoodsCount() {
			return GoodsCount;
		}
		public void setGoodsCount(int goodsCount) {
			GoodsCount = goodsCount;
		}
		public String getRefundTime() {
			return RefundTime;
		}
		public void setRefundTime(String refundTime) {
			RefundTime = refundTime;
		}
		public String getPickUpTime() {
			return PickUpTime;
		}
		public void setPickUpTime(String pickUpTime) {
			PickUpTime = pickUpTime;
		}
		public String getDeliveryType() {
			return DeliveryType;
		}
		public void setDeliveryType(String deliveryType) {
			DeliveryType = deliveryType;
		}
		public String getDeliveryAddress() {
			return DeliveryAddress;
		}
		public void setDeliveryAddress(String deliveryAddress) {
			DeliveryAddress = deliveryAddress;
		}
		public String getDeliveryTime() {
			return DeliveryTime;
		}
		public void setDeliveryTime(String deliveryTime) {
			DeliveryTime = deliveryTime;
		}
		public String getOrderPayFlag() {
			return OrderPayFlag;
		}
		public void setOrderPayFlag(String orderPayFlag) {
			OrderPayFlag = orderPayFlag;
		}
		public String getOrderPayType() {
			return OrderPayType;
		}
		public void setOrderPayType(String orderPayType) {
			OrderPayType = orderPayType;
		}
		public String getOrderPayTime() {
			return OrderPayTime;
		}
		public void setOrderPayTime(String orderPayTime) {
			OrderPayTime = orderPayTime;
		}
		public String getOrderTradeNo() {
			return OrderTradeNo;
		}
		public void setOrderTradeNo(String orderTradeNo) {
			OrderTradeNo = orderTradeNo;
		}
		public String getCardNo() {
			return CardNo;
		}
		public void setCardNo(String cardNo) {
			CardNo = cardNo;
		}
		public String getCardPassword() {
			return CardPassword;
		}
		public void setCardPassword(String cardPassword) {
			CardPassword = cardPassword;
		}
		public String getOpenID() {
			return OpenID;
		}
		public void setOpenID(String openID) {
			OpenID = openID;
		}
		public QueryGoodsOrderReplyGoodsList getGoodsList() {
			return GoodsList;
		}
		public void setGoodsList(QueryGoodsOrderReplyGoodsList goodsList) {
			GoodsList = goodsList;
		}
		public static class QueryGoodsOrderReplyGoodsList{
			private List<QueryGoodsOrderReplyGoods> Goods;

			public List<QueryGoodsOrderReplyGoods> getGoods() {
				return Goods;
			}

			public void setGoods(List<QueryGoodsOrderReplyGoods> goods) {
				Goods = goods;
			}
			public static class QueryGoodsOrderReplyGoods{
				private String GoodsCode;
				private String GoodsName;
				private Double StandardPrice;
				private Double SettlePrice;
				private Double ChannelFee;
				private int GoodsCount;
				private String IsPackage;
				private String GoodsDetail;
				private int ShowSeqNo;
				public String getGoodsCode() {
					return GoodsCode;
				}
				public void setGoodsCode(String goodsCode) {
					GoodsCode = goodsCode;
				}
				public String getGoodsName() {
					return GoodsName;
				}
				public void setGoodsName(String goodsName) {
					GoodsName = goodsName;
				}
				public Double getStandardPrice() {
					return StandardPrice;
				}
				public void setStandardPrice(Double standardPrice) {
					StandardPrice = standardPrice;
				}
				public Double getSettlePrice() {
					return SettlePrice;
				}
				public void setSettlePrice(Double settlePrice) {
					SettlePrice = settlePrice;
				}
				public Double getChannelFee() {
					return ChannelFee;
				}
				public void setChannelFee(Double channelFee) {
					ChannelFee = channelFee;
				}
				public int getGoodsCount() {
					return GoodsCount;
				}
				public void setGoodsCount(int goodsCount) {
					GoodsCount = goodsCount;
				}
				public String getIsPackage() {
					return IsPackage;
				}
				public void setIsPackage(String isPackage) {
					IsPackage = isPackage;
				}
				public String getGoodsDetail() {
					return GoodsDetail;
				}
				public void setGoodsDetail(String goodsDetail) {
					GoodsDetail = goodsDetail;
				}
				public int getShowSeqNo() {
					return ShowSeqNo;
				}
				public void setShowSeqNo(int showSeqNo) {
					ShowSeqNo = showSeqNo;
				}
				
			}
		}
	}
	

}
