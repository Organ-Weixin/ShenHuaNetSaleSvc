package com.boot.security.server.api.core;

import java.util.List;


public class SubmitMixOrderReply extends BaseReply {

	public SubmitMixOrderReply(){
		Id = ID_SubmitMixOrderReply;
	}
	
	private SubmitTicketsOrder ticketsOrder;
	private SubmitGoodsOrder goodsOrder;
	
	public SubmitTicketsOrder getTicketsOrder() {
		return ticketsOrder;
	}
	public void setTicketsOrder(SubmitTicketsOrder ticketsOrder) {
		this.ticketsOrder = ticketsOrder;
	}
	public SubmitGoodsOrder getGoodsOrder() {
		return goodsOrder;
	}
	public void setGoodsOrder(SubmitGoodsOrder goodsOrder) {
		this.goodsOrder = goodsOrder;
	}
	
	public static class SubmitTicketsOrder {
		private int CinemaType;
		private String OrderCode;
		private String SessionCode;
		private int TicketCount;
		private String PrintNo;
		private String VerifyCode;
		private List<SubmitOrderSeat> Seat;
		
		public int getCinemaType() {
			return CinemaType;
		}
		public void setCinemaType(int cinemaType) {
			CinemaType = cinemaType;
		}
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getSessionCode() {
			return SessionCode;
		}
		public void setSessionCode(String sessionCode) {
			SessionCode = sessionCode;
		}
		public int getTicketCount() {
			return TicketCount;
		}
		public void setTicketCount(int ticketCount) {
			TicketCount = ticketCount;
		}
		public String getPrintNo() {
			return PrintNo;
		}
		public void setPrintNo(String printNo) {
			PrintNo = printNo;
		}
		public String getVerifyCode() {
			return VerifyCode;
		}
		public void setVerifyCode(String verifyCode) {
			VerifyCode = verifyCode;
		}
		public List<SubmitOrderSeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<SubmitOrderSeat> seat) {
			Seat = seat;
		}
		
		public static class SubmitOrderSeat {
			private String SeatCode;
			private String FilmTicketCode;
			
			public String getSeatCode() {
				return SeatCode;
			}
			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			public String getFilmTicketCode() {
				return FilmTicketCode;
			}
			public void setFilmTicketCode(String filmTicketCode) {
				FilmTicketCode = filmTicketCode;
			}
			
		}
	}
	public static class SubmitGoodsOrder {
		private String GoodsOrderCode;//订单号
		private String PickUpCode;//取货号
		private String VerifyCode;//辰星系统取货验证码
		
		public String getGoodsOrderCode() {
			return GoodsOrderCode;
		}
		public void setGoodsOrderCode(String goodsOrderCode) {
			GoodsOrderCode = goodsOrderCode;
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
		
	}
}
