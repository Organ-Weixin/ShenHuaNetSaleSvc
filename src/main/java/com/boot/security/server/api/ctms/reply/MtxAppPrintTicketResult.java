package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class MtxAppPrintTicketResult {
	// 合作商打票
	private ResBean AppPrintTicketResult;

	public ResBean getAppPrintTicketResult() {
		return AppPrintTicketResult;
	}

	public void setAppPrintTicketResult(ResBean appPrintTicketResult) {
		AppPrintTicketResult = appPrintTicketResult;
	}

	public static class ResBean {
		private String ResultCode;
		private String ResultDesc;
		private String OrderNo;
		private String OrderStatus;
		private String OrderDate;
		private String OrderTime;
		private String FeatureDate;
		private String FeatureTime;
		private String FilmName;
		private String HallName;
		private String PrintType;
		private String TicketKindName;
		private String PlaceNo;
		private String PlaceName;
		private SeatInfosBean SeatInfos;

		public String getResultCode() {
			return ResultCode;
		}

		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}

		public String getResultDesc() {
			return ResultDesc;
		}

		public void setResultDesc(String resultDesc) {
			ResultDesc = resultDesc;
		}

		public String getOrderNo() {
			return OrderNo;
		}

		public void setOrderNo(String orderNo) {
			OrderNo = orderNo;
		}

		public String getOrderStatus() {
			return OrderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}

		public String getOrderDate() {
			return OrderDate;
		}

		public void setOrderDate(String orderDate) {
			OrderDate = orderDate;
		}

		public String getOrderTime() {
			return OrderTime;
		}

		public void setOrderTime(String orderTime) {
			OrderTime = orderTime;
		}

		public String getFeatureDate() {
			return FeatureDate;
		}

		public void setFeatureDate(String featureDate) {
			FeatureDate = featureDate;
		}

		public String getFeatureTime() {
			return FeatureTime;
		}

		public void setFeatureTime(String featureTime) {
			FeatureTime = featureTime;
		}

		public String getFilmName() {
			return FilmName;
		}

		public void setFilmName(String filmName) {
			FilmName = filmName;
		}

		public String getHallName() {
			return HallName;
		}

		public void setHallName(String hallName) {
			HallName = hallName;
		}

		public String getPrintType() {
			return PrintType;
		}

		public void setPrintType(String printType) {
			PrintType = printType;
		}

		public String getTicketKindName() {
			return TicketKindName;
		}

		public void setTicketKindName(String ticketKindName) {
			TicketKindName = ticketKindName;
		}

		public String getPlaceNo() {
			return PlaceNo;
		}

		public void setPlaceNo(String placeNo) {
			PlaceNo = placeNo;
		}

		public String getPlaceName() {
			return PlaceName;
		}

		public void setPlaceName(String placeName) {
			PlaceName = placeName;
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
				private String CpnName;
				private String StPrice;
				private String PayPrice;
				private String SeatRow;
				private String SeatCol;
				private String SeatPieceName;
				private String TicketNo;
				private String TicketNo2;

				public String getCpnName() {
					return CpnName;
				}

				public void setCpnName(String cpnName) {
					CpnName = cpnName;
				}

				public String getStPrice() {
					return StPrice;
				}

				public void setStPrice(String stPrice) {
					StPrice = stPrice;
				}

				public String getPayPrice() {
					return PayPrice;
				}

				public void setPayPrice(String payPrice) {
					PayPrice = payPrice;
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

				public String getSeatPieceName() {
					return SeatPieceName;
				}

				public void setSeatPieceName(String seatPieceName) {
					SeatPieceName = seatPieceName;
				}

				public String getTicketNo() {
					return TicketNo;
				}

				public void setTicketNo(String ticketNo) {
					TicketNo = ticketNo;
				}

				public String getTicketNo2() {
					return TicketNo2;
				}

				public void setTicketNo2(String ticketNo2) {
					TicketNo2 = ticketNo2;
				}

			}
		}

	}

}
