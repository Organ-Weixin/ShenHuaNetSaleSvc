package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.List;

public class Dy1905LockSeatCustomResult {
	private ResBean RealCheckSeatStateResult;

	public ResBean getRealCheckSeatStateResult() {
		return RealCheckSeatStateResult;
	}

	public void setRealCheckSeatStateResult(ResBean realCheckSeatStateResult) {
		RealCheckSeatStateResult = realCheckSeatStateResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String OrderNo;
		private SeatInfosBean SeatInfos;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getOrderNo() {
			return OrderNo;
		}
		public void setOrderNo(String orderNo) {
			OrderNo = orderNo;
		}
		public SeatInfosBean getSeatInfos() {
			return SeatInfos;
		}
		public void setSeatInfos(SeatInfosBean seatInfos) {
			SeatInfos = seatInfos;
		}
		
		public static class SeatInfosBean{
			private List<SeatInfoBean> SeatInfo;

			public List<SeatInfoBean> getSeatInfo() {
				return SeatInfo;
			}

			public void setSeatInfo(List<SeatInfoBean> seatInfo) {
				SeatInfo = seatInfo;
			}
			public static class SeatInfoBean{
				private String SeatNo;
				private String TicketPrice;
				private String SeatRow;
				private String SeatCol;
				private Date AutoUnlockDatetime;
				public String getSeatNo() {
					return SeatNo;
				}
				public void setSeatNo(String seatNo) {
					SeatNo = seatNo;
				}
				public String getTicketPrice() {
					return TicketPrice;
				}
				public void setTicketPrice(String ticketPrice) {
					TicketPrice = ticketPrice;
				}
				public String getSeatRow() {
					return SeatRow;
				}
				public void setSeatRow(String seatRow) {
					SeatRow = seatRow;
				}
				public String getSeatCol() {
					return SeatCol;
				}
				public void setSeatCol(String seatCol) {
					SeatCol = seatCol;
				}
				public Date getAutoUnlockDatetime() {
					return AutoUnlockDatetime;
				}
				public void setAutoUnlockDatetime(Date autoUnlockDatetime) {
					AutoUnlockDatetime = autoUnlockDatetime;
				}
			}
		}
	}
}
