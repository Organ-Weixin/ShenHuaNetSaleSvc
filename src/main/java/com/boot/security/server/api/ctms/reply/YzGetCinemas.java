package com.boot.security.server.api.ctms.reply;

import java.util.List;


public class YzGetCinemas {
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
		private List<YzCinemas> dataList;
		
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
		public List<YzCinemas> getDataList() {
			return dataList;
		}
		public void setDataList(List<YzCinemas> dataList) {
			this.dataList = dataList;
		}

		public static class YzCinemas {
			private String cinemaLinkId ;
			private String cinemaName;
			private String cinemaId;
			private String cityCode;
			private String city;
			private Integer hallCount; 
			private String refundBeforeTime;
			private Integer maxScheduleDay;
			private Integer maxTicketNum;
			private Integer maxGoodsNum;
			private Integer monthlyTicketRefund;
			private List<Halls> hallList;
			
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
			}
			public String getCinemaName() {
				return cinemaName;
			}
			public void setCinemaName(String cinemaName) {
				this.cinemaName = cinemaName;
			}
			public String getCinemaId() {
				return cinemaId;
			}
			public void setCinemaId(String cinemaId) {
				this.cinemaId = cinemaId;
			}
			public String getCityCode() {
				return cityCode;
			}
			public void setCityCode(String cityCode) {
				this.cityCode = cityCode;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public Integer getHallCount() {
				return hallCount;
			}
			public void setHallCount(Integer hallCount) {
				this.hallCount = hallCount;
			}
			public String getRefundBeforeTime() {
				return refundBeforeTime;
			}
			public void setRefundBeforeTime(String refundBeforeTime) {
				this.refundBeforeTime = refundBeforeTime;
			}
			public Integer getMaxScheduleDay() {
				return maxScheduleDay;
			}
			public void setMaxScheduleDay(Integer maxScheduleDay) {
				this.maxScheduleDay = maxScheduleDay;
			}
			public Integer getMaxTicketNum() {
				return maxTicketNum;
			}
			public void setMaxTicketNum(Integer maxTicketNum) {
				this.maxTicketNum = maxTicketNum;
			}
			public Integer getMaxGoodsNum() {
				return maxGoodsNum;
			}
			public void setMaxGoodsNum(Integer maxGoodsNum) {
				this.maxGoodsNum = maxGoodsNum;
			}
			public Integer getMonthlyTicketRefund() {
				return monthlyTicketRefund;
			}
			public void setMonthlyTicketRefund(Integer monthlyTicketRefund) {
				this.monthlyTicketRefund = monthlyTicketRefund;
			}
			public List<Halls> getHallList() {
				return hallList;
			}
			public void setHallList(List<Halls> hallList) {
				this.hallList = hallList;
			}

			public static class Halls {
				private String hallCode;
				private String hallName;
				private Integer seatCount;
				private String hallType;
				
				public String getHallCode() {
					return hallCode;
				}
				public void setHallCode(String hallCode) {
					this.hallCode = hallCode;
				}
				public String getHallName() {
					return hallName;
				}
				public void setHallName(String hallName) {
					this.hallName = hallName;
				}
				public Integer getSeatCount() {
					return seatCount;
				}
				public void setSeatCount(Integer seatCount) {
					this.seatCount = seatCount;
				}
				public String getHallType() {
					return hallType;
				}
				public void setHallType(String hallType) {
					this.hallType = hallType;
				}
				
			}
		}
	}
}
