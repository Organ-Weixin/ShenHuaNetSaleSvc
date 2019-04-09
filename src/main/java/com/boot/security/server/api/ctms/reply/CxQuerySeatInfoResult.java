package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxQuerySeatInfoResult {
		private ResBean QuerySeatInfoResult;
		
		public ResBean getQuerySeatInfoResult() {
			return QuerySeatInfoResult;
		}
		public void setQuerySeatInfoResult(ResBean querySeatInfoResult) {
			QuerySeatInfoResult = querySeatInfoResult;
		}
		
		public static class ResBean{
			private String ResultCode;
			private String Message;
			private ScreenSitesBean ScreenSites;
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
			public ScreenSitesBean getScreenSites() {
				return ScreenSites;
			}
			public void setScreenSites(ScreenSitesBean screenSites) {
				ScreenSites = screenSites;
			}
			
			public static class ScreenSitesBean{
				private List<ScreenSitesBean> ScreenSite;

				public List<ScreenSitesBean> getScreenSite() {
					return ScreenSite;
				}

				public void setScreenSite(List<ScreenSitesBean> screenSite) {
					ScreenSite = screenSite;
				}
				
				public static class ScreenSite{
					private String SeatCode;
					private String GroupCode;
					private String RowNum;
					private String ColumnNum;
					private String XCoord;
					private String YCoord;
					private String Status;
					public String getSeatCode() {
						return SeatCode;
					}
					public void setSeatCode(String seatCode) {
						SeatCode = seatCode;
					}
					public String getGroupCode() {
						return GroupCode;
					}
					public void setGroupCode(String groupCode) {
						GroupCode = groupCode;
					}
					public String getRowNum() {
						return RowNum;
					}
					public void setRowNum(String rowNum) {
						RowNum = rowNum;
					}
					public String getColumnNum() {
						return ColumnNum;
					}
					public void setColumnNum(String columnNum) {
						ColumnNum = columnNum;
					}
					public String getXCoord() {
						return XCoord;
					}
					public void setXCoord(String xCoord) {
						XCoord = xCoord;
					}
					public String getYCoord() {
						return YCoord;
					}
					public void setYCoord(String yCoord) {
						YCoord = yCoord;
					}
					public String getStatus() {
						return Status;
					}
					public void setStatus(String status) {
						Status = status;
					}
					
				}
			}
		}
}
