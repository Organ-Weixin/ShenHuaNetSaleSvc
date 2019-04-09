package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 放映计划座位状态
 */
public class CxQueryPlanSeatResult {

    private ResBean QueryPlanSeatResult;

    public ResBean getQueryPlanSeatResult() {
        return QueryPlanSeatResult;
    }

    public void setQueryPlanSeatResult(ResBean queryPlanSeatResult) {
        QueryPlanSeatResult = queryPlanSeatResult;
    }

    public static class ResBean {

        private String  ResultCode;//	返回结果号，详细见附录A
        private String  Message;//	返回信息，详细见附录A
        private String  FeatureAppNo;//放映计划编码
        private PlanSiteStatesBean PlanSiteStates;

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

        public String getFeatureAppNo() {
            return FeatureAppNo;
        }

        public void setFeatureAppNo(String featureAppNo) {
            FeatureAppNo = featureAppNo;
        }

        public PlanSiteStatesBean getPlanSiteStates() {
            return PlanSiteStates;
        }

        public void setPlanSiteStates(PlanSiteStatesBean planSiteStates) {
            PlanSiteStates = planSiteStates;
        }

        public static class PlanSiteStatesBean{
            private List<PlanSiteStateBean> PlanSiteState;

            public List<PlanSiteStateBean> getPlanSiteState() {
                return PlanSiteState;
            }

            public void setPlanSiteState(List<PlanSiteStateBean> planSiteState) {
                PlanSiteState = planSiteState;
            }
            public static class PlanSiteStateBean{
            	private String SeatCode;
            	private String RowNum;
            	private String ColumnNum;
            	private String Status;
            	private String MemberLevelCode;
				public String getSeatCode() {
					return SeatCode;
				}
				public void setSeatCode(String seatCode) {
					SeatCode = seatCode;
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
				public String getStatus() {
					return Status;
				}
				public void setStatus(String status) {
					Status = status;
				}
				public String getMemberLevelCode() {
					return MemberLevelCode;
				}
				public void setMemberLevelCode(String memberLevelCode) {
					MemberLevelCode = memberLevelCode;
				}
            	
            }
        }
    }
}
