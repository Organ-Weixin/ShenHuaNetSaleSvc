package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class MtxGetHallResult {
	private ResBean GetHallResult;

	public ResBean getGetHallResult() {
		return GetHallResult;
	}

	public void setGetHallResult(ResBean getHallResult) {
		GetHallResult = getHallResult;
	}
	public static class ResBean {
		private String ResultCode;
		private HallsBean Halls;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public HallsBean getHalls() {
			return Halls;
		}
		public void setHalls(HallsBean halls) {
			Halls = halls;
		}
		public static class HallsBean{
			private List<HallBean> Hall;

			public List<HallBean> getHall() {
				return Hall;
			}

			public void setHall(List<HallBean> hall) {
				Hall = hall;
			}
			public static class HallBean{
				private String HallNo;
				private String HallName;
				private String HallType;
				public String getHallNo() {
					return HallNo;
				}
				public void setHallNo(String hallNo) {
					HallNo = hallNo;
				}
				public String getHallName() {
					return HallName;
				}
				public void setHallName(String hallName) {
					HallName = hallName;
				}
				public String getHallType() {
					return HallType;
				}
				public void setHallType(String hallType) {
					HallType = hallType;
				}
				
			}
			
		}
		
	}

}
