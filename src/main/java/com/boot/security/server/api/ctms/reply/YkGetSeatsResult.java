package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 凤凰佳影-查询影厅座位
 * @author sheng
 *
 */
public class YkGetSeatsResult {
	
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
			private String hallId;
			private String cinemaLinkId;
			private List<SeatPlan> seatPlanList;
			
			public String getHallId() {
				return hallId;
			}
			public void setHallId(String hallId) {
				this.hallId = hallId;
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
				private List<Sections> sections;
				
				public String getEffectiveDate() {
					return effectiveDate;
				}
				public void setEffectiveDate(String effectiveDate) {
					this.effectiveDate = effectiveDate;
				}
				public List<Sections> getSections() {
					return sections;
				}
				public void setSections(List<Sections> sections) {
					this.sections = sections;
				}

				public class Sections {
					private String sectionId;
					private String name;
					private List<Seats> seats;
					
					public String getSectionId() {
						return sectionId;
					}
					public void setSectionId(String sectionId) {
						this.sectionId = sectionId;
					}
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public List<Seats> getSeats() {
						return seats;
					}
					public void setSeats(List<Seats> seats) {
						this.seats = seats;
					}
					
					public class Seats {
						private String seatId;
						private String rowId;
						private String columnId;
						private Integer x;
						private Integer y; 
						private String type;
						private String damage;
						
						public String getSeatId() {
							return seatId;
						}
						public void setSeatId(String seatId) {
							this.seatId = seatId;
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
						public String getDamage() {
							return damage;
						}
						public void setDamage(String damage) {
							this.damage = damage;
						}
						
					}
				}
			}
		}
	}
}
