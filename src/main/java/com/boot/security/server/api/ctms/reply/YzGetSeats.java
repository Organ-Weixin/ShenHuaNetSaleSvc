package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class YzGetSeats {
	private String api;
	private String v;
	private String retCode;
	private String retMsg;
	private DataBean data;
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public DataBean getData() {
		return data;
	}
	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean{
		private String bizCode;
		private String bizMsg;
		private CinemaBean data;
		
		public String getBizCode() {
			return bizCode;
		}
		public void setBizCode(String bizCode) {
			this.bizCode = bizCode;
		}
		public String getBizMsg() {
			return bizMsg;
		}
		public void setBizMsg(String bizMsg) {
			this.bizMsg = bizMsg;
		}
		public CinemaBean getData() {
			return data;
		}
		public void setData(CinemaBean data) {
			this.data = data;
		}

		public class CinemaBean {
			private String hallCode;
			private String cinemaLinkId;
			private List<SeatPlan> seatPlanList;
			
			public String getHallCode() {
				return hallCode;
			}
			public void setHallCode(String hallCode) {
				this.hallCode = hallCode;
			}
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
			}
			public List<SeatPlan> getSeatPlanList() {
				return seatPlanList;
			}
			public void setSeatPlanList(List<SeatPlan> seatPlanList) {
				this.seatPlanList = seatPlanList;
			}

			public class SeatPlan {
				private String effectiveDate;
				private String seatVersion;
				private List<Sections> sectionList;
				
				public String getEffectiveDate() {
					return effectiveDate;
				}
				public void setEffectiveDate(String effectiveDate) {
					this.effectiveDate = effectiveDate;
				}
				public String getSeatVersion() {
					return seatVersion;
				}
				public void setSeatVersion(String seatVersion) {
					this.seatVersion = seatVersion;
				}
				public List<Sections> getSectionList() {
					return sectionList;
				}
				public void setSectionList(List<Sections> sectionList) {
					this.sectionList = sectionList;
				}
				
				public class Sections {
					private String sectionCode;
					private String sectionName;
					private List<Seats> seatList;
					
					public String getSectionCode() {
						return sectionCode;
					}
					public void setSectionCode(String sectionCode) {
						this.sectionCode = sectionCode;
					}
					public String getSectionName() {
						return sectionName;
					}
					public void setSectionName(String sectionName) {
						this.sectionName = sectionName;
					}
					public List<Seats> getSeatList() {
						return seatList;
					}
					public void setSeatList(List<Seats> seatList) {
						this.seatList = seatList;
					}
					
					public class Seats {
						private String seatCode;
						private String rowId;
						private String columnId;
						private Integer x;
						private Integer y; 
						private String type;
						private String damaged;
						
						public String getSeatCode() {
							return seatCode;
						}
						public void setSeatCode(String seatCode) {
							this.seatCode = seatCode;
						}
						public String getRowId() {
							return rowId;
						}
						public void setRowId(String rowId) {
							this.rowId = rowId;
						}
						public String getColumnId() {
							return columnId;
						}
						public void setColumnId(String columnId) {
							this.columnId = columnId;
						}
						public Integer getX() {
							return x;
						}
						public void setX(Integer x) {
							this.x = x;
						}
						public Integer getY() {
							return y;
						}
						public void setY(Integer y) {
							this.y = y;
						}
						public String getType() {
							return type;
						}
						public void setType(String type) {
							this.type = type;
						}
						public String getDamaged() {
							return damaged;
						}
						public void setDamaged(String damaged) {
							this.damaged = damaged;
						}
						
					}
				}
			}
		}
	}
}
