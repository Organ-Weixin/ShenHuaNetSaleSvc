package com.boot.security.server.api.core;

import java.util.List;

import com.boot.security.server.model.CinemaTypeEnum;

public class SubmitOrderReply extends BaseReply {
	public SubmitOrderReply()
    {
        Id = ID_SubmitOrderReply;
    }
	public SubmitOrderReplyOrder Order;
	public SubmitOrderReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(SubmitOrderReplyOrder order) {
		Order = order;
	}
	public class SubmitOrderReplyOrder{
		public int CinemaType;
		public String OrderCode;
		public String SessionCode;
		public int Count;
		public String PrintNo;
		public String VerifyCode;
		public List<SubmitOrderReplySeat> Seat;
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
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
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
		public List<SubmitOrderReplySeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<SubmitOrderReplySeat> seat) {
			Seat = seat;
		}
		public class SubmitOrderReplySeat{
	        public String SeatCode;
	        public String FilmTicketCode;
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

}
