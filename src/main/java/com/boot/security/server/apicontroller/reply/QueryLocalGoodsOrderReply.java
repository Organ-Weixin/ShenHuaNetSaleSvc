package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryLocalGoodsOrderReply extends BaseReply {
	private QueryLocalGoodsOrderReplyOrder data;

	public QueryLocalGoodsOrderReplyOrder getData() {
		return data;
	}

	public void setData(QueryLocalGoodsOrderReplyOrder data) {
		this.data = data;
	}
	public static class QueryLocalGoodsOrderReplyOrder{
		private String CinemaCode;
		private String LocalOrderCode;
		private String OrderStatus;
		private Double TotalPrice;
		private Double TotalSettlePrice;
		private Double TotalFee;
		private String Created;
		private int GoodsCount;
		private int DeliveryType;
		private String DeliveryAddress;
		private String DeliveryTime;
		private String OpenID;
		private String EwmPicture;
		private QueryLocalGoodsOrderReplyGoodsList GoodsList;
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
		public String getCreated() {
			return Created;
		}
		public void setCreated(String created) {
			Created = created;
		}
		public int getGoodsCount() {
			return GoodsCount;
		}
		public void setGoodsCount(int goodsCount) {
			GoodsCount = goodsCount;
		}
		public int getDeliveryType() {
			return DeliveryType;
		}
		public void setDeliveryType(int deliveryType) {
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
		public String getOpenID() {
			return OpenID;
		}
		public void setOpenID(String openID) {
			OpenID = openID;
		}
		public String getEwmPicture() {
			return EwmPicture;
		}
		public void setEwmPicture(String ewmPicture) {
			EwmPicture = ewmPicture;
		}
		public QueryLocalGoodsOrderReplyGoodsList getGoodsList() {
			return GoodsList;
		}
		public void setGoodsList(QueryLocalGoodsOrderReplyGoodsList goodsList) {
			GoodsList = goodsList;
		}
		public static class QueryLocalGoodsOrderReplyGoodsList{
			private List<QueryLocalGoodsOrderReplyGoods> Goods;

			public List<QueryLocalGoodsOrderReplyGoods> getGoods() {
				return Goods;
			}

			public void setGoods(List<QueryLocalGoodsOrderReplyGoods> goods) {
				Goods = goods;
			}
			public static class QueryLocalGoodsOrderReplyGoods{
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
