package com.boot.security.server.api.core;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CreateGoodsOrder")
public class CreateGoodsOrderQueryXml {
	private String CinemaCode;
	private String PayType;//满天星接口需要（先选择支付方式后把该值传入）
	private CreateGoodsOrderQueryXmlGoodsList GoodsList;
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	public CreateGoodsOrderQueryXmlGoodsList getGoodsList() {
		return GoodsList;
	}
	public void setGoodsList(CreateGoodsOrderQueryXmlGoodsList goodsList) {
		GoodsList = goodsList;
	}
	public static class CreateGoodsOrderQueryXmlGoodsList{
		private List<CreateGoodsOrderQueryXmlGoods> Goods;

		public List<CreateGoodsOrderQueryXmlGoods> getGoods() {
			return Goods;
		}

		public void setGoods(List<CreateGoodsOrderQueryXmlGoods> goods) {
			Goods = goods;
		}
		public static class CreateGoodsOrderQueryXmlGoods{
			private String GoodsCode;
			private Double StandardPrice;
			private Double GoodsChannelFee;
			private int GoodsCount;
			
			public String getGoodsCode() {
				return GoodsCode;
			}
			public void setGoodsCode(String goodsCode) {
				GoodsCode = goodsCode;
			}
			public Double getStandardPrice() {
				return StandardPrice;
			}
			public void setStandardPrice(Double standardPrice) {
				StandardPrice = standardPrice;
			}
			public Double getGoodsChannelFee() {
				return GoodsChannelFee;
			}
			public void setGoodsChannelFee(Double goodsChannelFee) {
				GoodsChannelFee = goodsChannelFee;
			}
			public int getGoodsCount() {
				return GoodsCount;
			}
			public void setGoodsCount(int goodsCount) {
				GoodsCount = goodsCount;
			}
			
		}
		
	}
	

}
