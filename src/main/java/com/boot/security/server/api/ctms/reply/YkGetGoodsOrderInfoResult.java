package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 查询卖品订单
 * @author sheng
 *
 */
public class YkGetGoodsOrderInfoResult {

	private String api;
	private String v;
	private String retCode;
	private String retMsg;
	private DataBean data;
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public DataBean getData() {
		return data;
	}
	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean{
		private String bizCode;
		private String bizMsg;
		private OrderBean data;
		
		public String getBizCode() {
			return bizCode;
		}
		public void setBizCode(String bizCode) {
			this.bizCode = bizCode;
		}
		public String getBizMsg() {
			return bizMsg;
		}
		public void setBizMsg(String bizMsg) {
			this.bizMsg = bizMsg;
		}
		public OrderBean getData() {
			return data;
		}
		public void setData(OrderBean data) {
			this.data = data;
		}

		public static class OrderBean {
			private String goodsOrderId;
			private String holdId;
			private String pickUpCode;
			private String totalGoodsPrice;
			private String totalGoodsFee;
			private String orderStatus;
			private String pickupStatus;
			private List<GoodsList> goodsList;
			
			public String getGoodsOrderId() {
				return goodsOrderId;
			}
			public void setGoodsOrderId(String goodsOrderId) {
				this.goodsOrderId = goodsOrderId;
			}
			public String getHoldId() {
				return holdId;
			}
			public void setHoldId(String holdId) {
				this.holdId = holdId;
			}
			public String getPickUpCode() {
				return pickUpCode;
			}
			public void setPickUpCode(String pickUpCode) {
				this.pickUpCode = pickUpCode;
			}
			public String getTotalGoodsPrice() {
				return totalGoodsPrice;
			}
			public void setTotalGoodsPrice(String totalGoodsPrice) {
				this.totalGoodsPrice = totalGoodsPrice;
			}
			public String getTotalGoodsFee() {
				return totalGoodsFee;
			}
			public void setTotalGoodsFee(String totalGoodsFee) {
				this.totalGoodsFee = totalGoodsFee;
			}
			public String getOrderStatus() {
				return orderStatus;
			}
			public void setOrderStatus(String orderStatus) {
				this.orderStatus = orderStatus;
			}
			public String getPickupStatus() {
				return pickupStatus;
			}
			public void setPickupStatus(String pickupStatus) {
				this.pickupStatus = pickupStatus;
			}
			public List<GoodsList> getGoodsList() {
				return goodsList;
			}
			public void setGoodsList(List<GoodsList> goodsList) {
				this.goodsList = goodsList;
			}

			public static class GoodsList {
				private String goodsId;
				private String name;
				private String salePrice;
				private Integer count;
				private Boolean isPackage;
				
				public String getGoodsId() {
					return goodsId;
				}
				public void setGoodsId(String goodsId) {
					this.goodsId = goodsId;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public String getSalePrice() {
					return salePrice;
				}
				public void setSalePrice(String salePrice) {
					this.salePrice = salePrice;
				}
				public Integer getCount() {
					return count;
				}
				public void setCount(Integer count) {
					this.count = count;
				}
				public Boolean getIsPackage() {
					return isPackage;
				}
				public void setIsPackage(Boolean isPackage) {
					this.isPackage = isPackage;
				}
				
			}
		}
	}
}
