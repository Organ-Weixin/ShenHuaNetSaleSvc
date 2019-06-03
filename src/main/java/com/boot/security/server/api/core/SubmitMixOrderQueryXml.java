package com.boot.security.server.api.core;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SubmitMixOrder")
public class SubmitMixOrderQueryXml {

	private String CinemaCode;
	private String PayType;//满天星接口需要（先选择支付方式后把该值传入）
	private String OrderCode;	//购票订单
	private String GoodsOrderCode;	//卖品订单
	private String SessionCode;
	private int SeatCount;
	private String PaySeqNo;//满天星会员卡支付交易号
	private String MobilePhone;
	private String CardNo;//1905会员卡支付需要
	private String CardPassword;//1905会员卡支付需要
	private List<SubmitMixOrderQueryXmlSeat> Seat;
	private List<SubmitMixOrderQueryXmlGoods> Goods;
	@XmlElement(name="CinemaCode")
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		CinemaCode = cinemaCode;
	}
	@XmlElement(name="PayType")
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}
	@XmlElement(name="OrderCode")
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	@XmlElement(name="GoodsOrderCode")
	public String getGoodsOrderCode() {
		return GoodsOrderCode;
	}
	public void setGoodsOrderCode(String goodsOrderCode) {
		GoodsOrderCode = goodsOrderCode;
	}
	@XmlElement(name="SessionCode")
	public String getSessionCode() {
		return SessionCode;
	}
	public void setSessionCode(String sessionCode) {
		SessionCode = sessionCode;
	}
	@XmlElement(name="SeatCount")
	public int getSeatCount() {
		return SeatCount;
	}
	public void setSeatCount(int seatCount) {
		SeatCount = seatCount;
	}
	@XmlElement(name="PaySeqNo")
	public String getPaySeqNo() {
		return PaySeqNo;
	}
	public void setPaySeqNo(String paySeqNo) {
		PaySeqNo = paySeqNo;
	}
	@XmlElement(name="MobilePhone")
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	@XmlElement(name="CardNo")
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}
	@XmlElement(name="CardPassword")
	public String getCardPassword() {
		return CardPassword;
	}
	public void setCardPassword(String cardPassword) {
		CardPassword = cardPassword;
	}
	@XmlElement(name="Seat")
	public List<SubmitMixOrderQueryXmlSeat> getSeat() {
		return Seat;
	}
	public void setSeat(List<SubmitMixOrderQueryXmlSeat> seat) {
		Seat = seat;
	}
	@XmlElement(name="Goods")
	public List<SubmitMixOrderQueryXmlGoods> getGoods() {
		return Goods;
	}
	public void setGoods(List<SubmitMixOrderQueryXmlGoods> goods) {
		Goods = goods;
	}
	
	public static class SubmitMixOrderQueryXmlSeat {
		private String SeatCode;
		private Double Price;
		private Double RealPrice;
		private Double Fee;
		private Double AddFee;
		private Double CinemaAllowance;
		
		@XmlElement(name="SeatCode")
		public String getSeatCode() {
			return SeatCode;
		}
		public void setSeatCode(String seatCode) {
			SeatCode = seatCode;
		}
		@XmlElement(name="Price")
		public Double getPrice() {
			return Price;
		}
		public void setPrice(Double price) {
			Price = price;
		}
		@XmlElement(name="RealPrice")
		public Double getRealPrice() {
			return RealPrice;
		}
		public void setRealPrice(Double realPrice) {
			RealPrice = realPrice;
		}
		@XmlElement(name="Fee")
		public Double getFee() {
			return Fee;
		}
		public void setFee(Double fee) {
			Fee = fee;
		}
		@XmlElement(name="AddFee")
		public Double getAddFee() {
			return AddFee;
		}
		public void setAddFee(Double addFee) {
			AddFee = addFee;
		}
		@XmlElement(name="CinemaAllowance")
		public Double getCinemaAllowance() {
			return CinemaAllowance;
		}
		public void setCinemaAllowance(Double cinemaAllowance) {
			CinemaAllowance = cinemaAllowance;
		}
	}
	
	public static class SubmitMixOrderQueryXmlGoods {
		private String GoodsCode;
		private Double StandardPrice;
		private Double SettlePrice;
		private Double GoodsChannelFee;
		private int GoodsCount;
		
		@XmlElement(name="GoodsCode")
		public String getGoodsCode() {
			return GoodsCode;
		}
		public void setGoodsCode(String goodsCode) {
			GoodsCode = goodsCode;
		}
		@XmlElement(name="StandardPrice")
		public Double getStandardPrice() {
			return StandardPrice;
		}
		public void setStandardPrice(Double standardPrice) {
			StandardPrice = standardPrice;
		}
		@XmlElement(name="SettlePrice")
		public Double getSettlePrice() {
			return SettlePrice;
		}
		public void setSettlePrice(Double settlePrice) {
			SettlePrice = settlePrice;
		}
		@XmlElement(name="GoodsChannelFee")
		public Double getGoodsChannelFee() {
			return GoodsChannelFee;
		}
		public void setGoodsChannelFee(Double goodsChannelFee) {
			GoodsChannelFee = goodsChannelFee;
		}
		@XmlElement(name="GoodsCount")
		public int getGoodsCount() {
			return GoodsCount;
		}
		public void setGoodsCount(int goodsCount) {
			GoodsCount = goodsCount;
		}
	}
}
