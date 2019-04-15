package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class MtxLiveRealCheckSeatStateResult {
	// 检查需要订票的座位状态情况，并订票锁定实时座位
	private ResBean RealCheckSeatStateResult;
	public ResBean getRealCheckSeatStateResult() {
		return RealCheckSeatStateResult;
	}
	public void setRealCheckSeatStateResult(ResBean realCheckSeatStateResult) {
		RealCheckSeatStateResult = realCheckSeatStateResult;
	}
	public static class ResBean {
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

		public static class SeatInfosBean {
			private List<SeatInfoBean> SeatInfo;

			public List<SeatInfoBean> getSeatInfo() {
				return SeatInfo;
			}

			public void setSeatInfo(List<SeatInfoBean> seatInfo) {
				SeatInfo = seatInfo;
			}

			public static class SeatInfoBean {
				private String SeatNo;
				private Double TicketPrice;
				private String SeatRow;
				private String SeatCol;
				private String SeatPieceNo;
				
				public String getSeatPieceNo() {
					return SeatPieceNo;
				}

				public void setSeatPieceNo(String seatPieceNo) {
					SeatPieceNo = seatPieceNo;
				}

				public String getSeatNo() {
					return SeatNo;
				}

				public void setSeatNo(String seatNo) {
					SeatNo = seatNo;
				}

				public Double getTicketPrice() {
					return TicketPrice;
				}

				public void setTicketPrice(Double ticketPrice) {
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
			

			}
		}

	}

}
