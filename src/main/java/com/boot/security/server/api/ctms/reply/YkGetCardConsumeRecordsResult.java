package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 查询会员卡余额消费记录 
 * @author sheng
 *
 */
public class YkGetCardConsumeRecordsResult {

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

	public static class DataBean {
		private String bizCode;
		private String bizMsg;
		private List<ConsumeRecords> dataList;
		
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
		public List<ConsumeRecords> getDataList() {
			return dataList;
		}
		public void setDataList(List<ConsumeRecords> dataList) {
			this.dataList = dataList;
		}

		public static class ConsumeRecords {
			private String bookingId;
			private String consumeCinemaLinkId;
			private String consumeAmount;
			private String refundAmount;
			private String beforeBalance;
			private String afterBalance;
			private Integer seats;
			private Integer refundSeats;
			private Integer calculatePerTicketTimes;
			private String description;
			private String consumeDateTime;
			private String filmCode;
			private String shortName;
			private String getPoints;
			private String refundPoints;
			
			public String getBookingId() {
				return bookingId;
			}
			public void setBookingId(String bookingId) {
				this.bookingId = bookingId;
			}
			public String getConsumeCinemaLinkId() {
				return consumeCinemaLinkId;
			}
			public void setConsumeCinemaLinkId(String consumeCinemaLinkId) {
				this.consumeCinemaLinkId = consumeCinemaLinkId;
			}
			public String getConsumeAmount() {
				return consumeAmount;
			}
			public void setConsumeAmount(String consumeAmount) {
				this.consumeAmount = consumeAmount;
			}
			public String getRefundAmount() {
				return refundAmount;
			}
			public void setRefundAmount(String refundAmount) {
				this.refundAmount = refundAmount;
			}
			public String getBeforeBalance() {
				return beforeBalance;
			}
			public void setBeforeBalance(String beforeBalance) {
				this.beforeBalance = beforeBalance;
			}
			public String getAfterBalance() {
				return afterBalance;
			}
			public void setAfterBalance(String afterBalance) {
				this.afterBalance = afterBalance;
			}
			public Integer getSeats() {
				return seats;
			}
			public void setSeats(Integer seats) {
				this.seats = seats;
			}
			public Integer getRefundSeats() {
				return refundSeats;
			}
			public void setRefundSeats(Integer refundSeats) {
				this.refundSeats = refundSeats;
			}
			public Integer getCalculatePerTicketTimes() {
				return calculatePerTicketTimes;
			}
			public void setCalculatePerTicketTimes(Integer calculatePerTicketTimes) {
				this.calculatePerTicketTimes = calculatePerTicketTimes;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getConsumeDateTime() {
				return consumeDateTime;
			}
			public void setConsumeDateTime(String consumeDateTime) {
				this.consumeDateTime = consumeDateTime;
			}
			public String getFilmCode() {
				return filmCode;
			}
			public void setFilmCode(String filmCode) {
				this.filmCode = filmCode;
			}
			public String getShortName() {
				return shortName;
			}
			public void setShortName(String shortName) {
				this.shortName = shortName;
			}
			public String getGetPoints() {
				return getPoints;
			}
			public void setGetPoints(String getPoints) {
				this.getPoints = getPoints;
			}
			public String getRefundPoints() {
				return refundPoints;
			}
			public void setRefundPoints(String refundPoints) {
				this.refundPoints = refundPoints;
			}
			
		}
	}
}
