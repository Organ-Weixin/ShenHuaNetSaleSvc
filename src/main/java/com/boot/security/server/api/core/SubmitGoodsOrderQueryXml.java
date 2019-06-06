package com.boot.security.server.api.core;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SubmitGoodsOrder")
public class SubmitGoodsOrderQueryXml {
	private String CinemaCode;
	private String OrderCode;
	private String PaySeqNo;//满天星会员卡支付交易号
	private String MobilePhone;
	private SubmitGoodsOrderQueryXmlGoodsList GoodsList;
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getPaySeqNo() {
		return PaySeqNo;
	}
	public void setPaySeqNo(String paySeqNo) {
		PaySeqNo = paySeqNo;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	public SubmitGoodsOrderQueryXmlGoodsList getGoodsList() {
		return GoodsList;
	}
	public void setGoodsList(SubmitGoodsOrderQueryXmlGoodsList goodsList) {
		GoodsList = goodsList;
	}
	public static class SubmitGoodsOrderQueryXmlGoodsList{
		private List<SubmitGoodsOrderQueryXmlGoods> Goods;

		public List<SubmitGoodsOrderQueryXmlGoods> getGoods() {
			return Goods;
		}

		public void setGoods(List<SubmitGoodsOrderQueryXmlGoods> goods) {
			Goods = goods;
		}
		public static class SubmitGoodsOrderQueryXmlGoods{
			private String GoodsCode;
			private Double StandardPrice;
			private Double SettlePrice;
			private Double GoodsChannelFee;
			private int GoodsCount;
			
			public String getGoodsCode() {
				return GoodsCode;
			}
			public void setGoodsCode(String goodsCode) {
				GoodsCode = goodsCode;
			}
			
			public int getGoodsCount() {
				return GoodsCount;
			}
			public void setGoodsCount(int goodsCount) {
				GoodsCount = goodsCount;
			}
			
			public Double getGoodsChannelFee() {
				return GoodsChannelFee;
			}
			public void setGoodsChannelFee(Double goodsChannelFee) {
				GoodsChannelFee = goodsChannelFee;
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
			
		}
	}
	

}
