package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 查询卖品列表 
 * @author sheng
 *
 */
public class YkGetGoodsResult {

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
		private GoodsBean data;
		
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
		public GoodsBean getData() {
			return data;
		}
		public void setData(GoodsBean data) {
			this.data = data;
		}

		public static class GoodsBean {
			private Integer maxBuyCount;
			private String cinemaLinkId;
			private List<GoodsResult> goodsList;
			
			public Integer getMaxBuyCount() {
				return maxBuyCount;
			}
			public void setMaxBuyCount(Integer maxBuyCount) {
				this.maxBuyCount = maxBuyCount;
			}
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
			}
			public List<GoodsResult> getGoodsList() {
				return goodsList;
			}
			public void setGoodsList(List<GoodsResult> goodsList) {
				this.goodsList = goodsList;
			}
			
			public static class GoodsResult {
				private String goodsId;
				private String name;
				private Boolean isPackage;
				private String salePrice;
				private String settlePrice;
				private String goodsPicUrl;
				private String desc;
				private String isDiscount;
				private List<BenefitCardPrices> benefitCardPrices;
				
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
				public Boolean getIsPackage() {
					return isPackage;
				}
				public void setIsPackage(Boolean isPackage) {
					this.isPackage = isPackage;
				}
				public String getSalePrice() {
					return salePrice;
				}
				public void setSalePrice(String salePrice) {
					this.salePrice = salePrice;
				}
				public String getSettlePrice() {
					return settlePrice;
				}
				public void setSettlePrice(String settlePrice) {
					this.settlePrice = settlePrice;
				}
				public String getGoodsPicUrl() {
					return goodsPicUrl;
				}
				public void setGoodsPicUrl(String goodsPicUrl) {
					this.goodsPicUrl = goodsPicUrl;
				}
				public String getDesc() {
					return desc;
				}
				public void setDesc(String desc) {
					this.desc = desc;
				}
				public String getIsDiscount() {
					return isDiscount;
				}
				public void setIsDiscount(String isDiscount) {
					this.isDiscount = isDiscount;
				}
				public List<BenefitCardPrices> getBenefitCardPrices() {
					return benefitCardPrices;
				}
				public void setBenefitCardPrices(List<BenefitCardPrices> benefitCardPrices) {
					this.benefitCardPrices = benefitCardPrices;
				}
				
				public static class BenefitCardPrices {
					private String benefitPolicyCode;
					private String benefitPayPrice;
					
					public String getBenefitPolicyCode() {
						return benefitPolicyCode;
					}
					public void setBenefitPolicyCode(String benefitPolicyCode) {
						this.benefitPolicyCode = benefitPolicyCode;
					}
					public String getBenefitPayPrice() {
						return benefitPayPrice;
					}
					public void setBenefitPayPrice(String benefitPayPrice) {
						this.benefitPayPrice = benefitPayPrice;
					}
					
				}
			}
		}
	}
}
