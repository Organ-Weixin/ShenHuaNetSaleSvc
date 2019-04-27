package com.boot.security.server.api.core;

import java.util.List;

public class LockSeatReply extends BaseReply {
	public LockSeatReply()
    {
        Id = ID_LockSeatReply;
    }
	private LockSeatReplyOrder Order;
	public LockSeatReplyOrder getOrder() {
		return Order;
	}
	public void setOrder(LockSeatReplyOrder order) {
		Order = order;
	}
	public class LockSeatReplyOrder{
		private String OrderCode;
		private String AutoUnlockDatetime;
		private String SessionCode;
		private int Count;
		private List<LockSeatReplySeat> Seat;
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getAutoUnlockDatetime() {
			return AutoUnlockDatetime;
		}
		public void setAutoUnlockDatetime(String autoUnlockDatetime) {
			AutoUnlockDatetime = autoUnlockDatetime;
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
		public List<LockSeatReplySeat> getSeat() {
			return Seat;
		}
		public void setSeat(List<LockSeatReplySeat> seat) {
			Seat = seat;
		}
		public class LockSeatReplySeat{
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
