package com.boot.security.server.api.core;

import java.util.List;


public class SubmitMixOrderQueryXml {

	private String CinemaCode;
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
	public String getGoodsOrderCode() {
		return GoodsOrderCode;
	}
	public void setGoodsOrderCode(String goodsOrderCode) {
		GoodsOrderCode = goodsOrderCode;
	}
	public String getSessionCode() {
		return SessionCode;
	}
	public void setSessionCode(String sessionCode) {
		SessionCode = sessionCode;
	}
	public int getSeatCount() {
		return SeatCount;
	}
	public void setSeatCount(int seatCount) {
		SeatCount = seatCount;
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
	public List<SubmitMixOrderQueryXmlSeat> getSeat() {
		return Seat;
	}
	public void setSeat(List<SubmitMixOrderQueryXmlSeat> seat) {
		Seat = seat;
	}
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
		
		public String getSeatCode() {
			return SeatCode;
		}
		public void setSeatCode(String seatCode) {
			SeatCode = seatCode;
		}
		public Double getPrice() {
			return Price;
		}
		public void setPrice(Double price) {
			Price = price;
		}
		public Double getRealPrice() {
			return RealPrice;
		}
		public void setRealPrice(Double realPrice) {
			RealPrice = realPrice;
		}
		public Double getFee() {
			return Fee;
		}
		public void setFee(Double fee) {
			Fee = fee;
		}
		public Double getAddFee() {
			return AddFee;
		}
		public void setAddFee(Double addFee) {
			AddFee = addFee;
		}
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
		public Double getSettlePrice() {
			return SettlePrice;
		}
		public void setSettlePrice(Double settlePrice) {
			SettlePrice = settlePrice;
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
