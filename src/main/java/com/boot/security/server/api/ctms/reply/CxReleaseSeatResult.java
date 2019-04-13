package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxReleaseSeatResult {
	private ResBean ReleaseSeatResult;

	public ResBean getReleaseSeatResult() {
		return ReleaseSeatResult;
	}

	public void setReleaseSeatResult(ResBean releaseSeatResult) {
		ReleaseSeatResult = releaseSeatResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private String OrderCode;
		private String FeatureAppNo;
		private SeatInfosBean SeatInfos;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public String getOrderCode() {
			return OrderCode;
		}
		public void setOrderCode(String orderCode) {
			OrderCode = orderCode;
		}
		public String getFeatureAppNo() {
			return FeatureAppNo;
		}
		public void setFeatureAppNo(String featureAppNo) {
			FeatureAppNo = featureAppNo;
		}
		public SeatInfosBean getSeatInfos() {
			return SeatInfos;
		}
		public void setSeatInfos(SeatInfosBean seatInfos) {
			SeatInfos = seatInfos;
		}
		public static class SeatInfosBean{
			private List<SeatInfoBean> SeatInfo;

			public List<SeatInfoBean> getSeatCode() {
				return SeatInfo;
			}

			public void setSeatCode(List<SeatInfoBean> SeatInfo) {
				SeatInfo = SeatInfo;
			}
			public static class SeatInfoBean{
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

}
