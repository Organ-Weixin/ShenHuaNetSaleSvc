package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class MtxGetPlanSiteStateResult {
	//获取对应排期的座位图的状态
	private ResBean GetPlanSiteStateResult;

	public ResBean getGetPlanSiteStateResult() {
		return GetPlanSiteStateResult;
	}

	public void setGetPlanSiteStateResult(ResBean getPlanSiteStateResult) {
		GetPlanSiteStateResult = getPlanSiteStateResult;
	}

	public static class ResBean{
		private String ResultCode;
		private PlanSiteStatesBean PlanSiteStates;
	
		public String getResultCode() {
			return ResultCode;
		}

		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
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
				private String SeatNo;
				private String SeatPieceNo;
				private String GraphRow;
				private String GraphCol;
				private String SeatRow;
				private String SeatCol;
				private String SeatState;
				public String getSeatNo() {
					return SeatNo;
				}
				public void setSeatNo(String seatNo) {
					SeatNo = seatNo;
				}
				public String getSeatPieceNo() {
					return SeatPieceNo;
				}
				public void setSeatPieceNo(String seatPieceNo) {
					SeatPieceNo = seatPieceNo;
				}
				public String getGraphRow() {
					return GraphRow;
				}
				public void setGraphRow(String graphRow) {
					GraphRow = graphRow;
				}
				public String getGraphCol() {
					return GraphCol;
				}
				public void setGraphCol(String graphCol) {
					GraphCol = graphCol;
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
				public String getSeatState() {
					return SeatState;
				}
				public void setSeatState(String seatState) {
					SeatState = seatState;
				}
				
				
			}
		}
		
	}
}
