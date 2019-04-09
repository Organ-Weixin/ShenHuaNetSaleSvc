package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 影院信息 影院影厅固定座位信息
 */
public class CxQuerySeatInfoResult {

    private ResBean QuerySeatInfoResult;

    public ResBean getQuerySeatInfoResult() {
        return QuerySeatInfoResult;
    }

    public void setQuerySeatInfoResult(ResBean querySeatInfoResult) {
        QuerySeatInfoResult = querySeatInfoResult;
    }

    public static class ResBean {

        private	String  ResultCode;//	返回结果号，详细见附录A
        private	String  Message;//	返回信息，详细见附录A
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
            private List<ScreenSiteBean> ScreenSite;

            public List<ScreenSiteBean> getScreenSite() {
                return ScreenSite;
            }

            public void setScreenSite(List<ScreenSiteBean> screenSite) {
                ScreenSite = screenSite;
            }
            public static class ScreenSiteBean{
            	private String SeatCode;
            	private String GroupCode;
            	private String RowNum;
            	private String ColumnNum;
            	private int XCoord;
            	private int YCoord;
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
				public int getXCoord() {
					return XCoord;
				}
				public void setXCoord(int xCoord) {
					XCoord = xCoord;
				}
				public int getYCoord() {
					return YCoord;
				}
				public void setYCoord(int yCoord) {
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