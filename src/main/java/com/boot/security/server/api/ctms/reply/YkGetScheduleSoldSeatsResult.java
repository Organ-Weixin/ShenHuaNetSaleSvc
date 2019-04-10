package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 凤凰佳影--查询场次已售座位
 * @author sheng
 *
 */
public class YkGetScheduleSoldSeatsResult {
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
		private SoldSeats data;
		
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
		public SoldSeats getData() {
			return data;
		}
		public void setData(SoldSeats data) {
			this.data = data;
		}
		
		public static class SoldSeats {
			private String cinemaLinkId;
			private String scheduleId;
			private String scheduleKey;
			private List<SectionList> sectionList;
			
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
			}
			public String getScheduleId() {
				return scheduleId;
			}
			public void setScheduleId(String scheduleId) {
				this.scheduleId = scheduleId;
			}
			public String getScheduleKey() {
				return scheduleKey;
			}
			public void setScheduleKey(String scheduleKey) {
				this.scheduleKey = scheduleKey;
			}
			public List<SectionList> getSectionList() {
				return sectionList;
			}
			public void setSectionList(List<SectionList> sectionList) {
				this.sectionList = sectionList;
			}

			public static class SectionList {
				private String sectionId;
				private List<SeatsBean> seats;
				
				public String getSectionId() {
					return sectionId;
				}
				public void setSectionId(String sectionId) {
					this.sectionId = sectionId;
				}
				public List<SeatsBean> getSeats() {
					return seats;
				}
				public void setSeats(List<SeatsBean> seats) {
					this.seats = seats;
				}

				public static class SeatsBean {
					private String seatId;
					
					public String getSeatId(){
						return seatId;
					}
					public void setSeatId(String seatId){
						this.seatId=seatId;
					}
				}
			}
		}
	}
}
