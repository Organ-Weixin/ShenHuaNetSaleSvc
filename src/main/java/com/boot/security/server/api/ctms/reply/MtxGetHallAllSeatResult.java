package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class MtxGetHallAllSeatResult {
	// 获取影厅座位信息（包含情侣座）


	private List<HallAllSeatBean> hallSeats;

	public List<HallAllSeatBean> getHallSeats() {
		return hallSeats;
	}

	public void setHallSeats(List<HallAllSeatBean> hallSeats) {
		this.hallSeats = hallSeats;
	}

	public static class HallAllSeatBean {
		private String seatNo;
		private String seatRow;
		private String seatCol;
		private String graphRow;
		private String graphCol;
		private String leftCount;
		private String rightCount;
		private String seatPieceNo;
		private String seatPieceName;

		public String getSeatNo() {
			return seatNo;
		}

		public void setSeatNo(String seatNo) {
			this.seatNo = seatNo;
		}

		public String getSeatRow() {
			return seatRow;
		}

		public void setSeatRow(String seatRow) {
			this.seatRow = seatRow;
		}

		public String getSeatCol() {
			return seatCol;
		}

		public void setSeatCol(String seatCol) {
			this.seatCol = seatCol;
		}

		public String getGraphRow() {
			return graphRow;
		}

		public void setGraphRow(String graphRow) {
			this.graphRow = graphRow;
		}

		public String getGraphCol() {
			return graphCol;
		}

		public void setGraphCol(String graphCol) {
			this.graphCol = graphCol;
		}

		public String getLeftCount() {
			return leftCount;
		}

		public void setLeftCount(String leftCount) {
			this.leftCount = leftCount;
		}

		public String getRightCount() {
			return rightCount;
		}

		public void setRightCount(String rightCount) {
			this.rightCount = rightCount;
		}

		public String getSeatPieceNo() {
			return seatPieceNo;
		}

		public void setSeatPieceNo(String seatPieceNo) {
			this.seatPieceNo = seatPieceNo;
		}

		public String getSeatPieceName() {
			return seatPieceName;
		}

		public void setSeatPieceName(String seatPieceName) {
			this.seatPieceName = seatPieceName;
		}

	}

	private String resultCode;
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

}
