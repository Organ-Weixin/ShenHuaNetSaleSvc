package com.boot.security.server.api.core;

import java.util.List;

public class ReleaseSeatReply extends BaseReply {
	public ReleaseSeatReply()
    {
        Id = ID_ReleaseSeatReply;
    }
	private ReleaseSeatReplyOrder Order;
	public ReleaseSeatReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(ReleaseSeatReplyOrder order) {
		Order = order;
	}
	public class ReleaseSeatReplyOrder{
		private String OrderCode;
		private String SessionCode;
		private int Count;
		private List<ReleaseSeatReplySeat> Seat;
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
		public List<ReleaseSeatReplySeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<ReleaseSeatReplySeat> seat) {
			Seat = seat;
		}
		public class ReleaseSeatReplySeat{
			private String SeatCode;

			public String getSeatCode() {
				return SeatCode;
			}

			public void setSeatCode(String seatCode) {
				SeatCode = seatCode;
			}
			
		}
	}
	

}
