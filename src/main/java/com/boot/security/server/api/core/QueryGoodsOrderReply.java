package com.boot.security.server.api.core;

import java.util.List;

public class QueryGoodsOrderReply extends BaseReply {
	public QueryGoodsOrderReply()
    {
        Id = ID_QueryGoodsOrderReply;
    }
	private String OrderCode;
	private String PickUpCode;
	private String VerifyCode;
	private String OrderStatus;
	private String OrderTime;
	private QueryGoodsOrderReplyGoodsList GoodsList;
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
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
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
			private String Created;
			private String IsPackage;
			private String GoodsDetail;
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
			public String getCreated() {
				return Created;
			}
			public void setCreated(String created) {
				Created = created;
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
			
		}
		
	}
	

}
