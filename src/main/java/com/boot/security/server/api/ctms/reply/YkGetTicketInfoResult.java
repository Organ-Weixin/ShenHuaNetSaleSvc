package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 凤凰佳影--查询取票信息
 * @author sheng
 *
 */
public class YkGetTicketInfoResult {

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
		private TicketBean data;
		
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
		public TicketBean getData() {
			return data;
		}
		public void setData(TicketBean data) {
			this.data = data;
		}

		public class TicketBean {
			private String printId;
			private String bookingId;
			private String confirmationId;
			private String showDateTime;
			private String cinemaName;
			private String hallId;
			private String hallName;
			private String filmCode;
			private String shortName;
			private String channelCode;
			private String channelName;
			private String createDateTime;
			private List<Tickets> tickets;
			
			public String getPrintId() {
				return printId;
			}
			public void setPrintId(String printId) {
				this.printId = printId;
			}
			public String getBookingId() {
				return bookingId;
			}
			public void setBookingId(String bookingId) {
				this.bookingId = bookingId;
			}
			public String getConfirmationId() {
				return confirmationId;
			}
			public void setConfirmationId(String confirmationId) {
				this.confirmationId = confirmationId;
			}
			public String getShowDateTime() {
				return showDateTime;
			}
			public void setShowDateTime(String showDateTime) {
				this.showDateTime = showDateTime;
			}
			public String getCinemaName() {
				return cinemaName;
			}
			public void setCinemaName(String cinemaName) {
				this.cinemaName = cinemaName;
			}
			public String getHallId() {
				return hallId;
			}
			public void setHallId(String hallId) {
				this.hallId = hallId;
			}
			public String getHallName() {
				return hallName;
			}
			public void setHallName(String hallName) {
				this.hallName = hallName;
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
			public String getChannelCode() {
				return channelCode;
			}
			public void setChannelCode(String channelCode) {
				this.channelCode = channelCode;
			}
			public String getChannelName() {
				return channelName;
			}
			public void setChannelName(String channelName) {
				this.channelName = channelName;
			}
			public String getCreateDateTime() {
				return createDateTime;
			}
			public void setCreateDateTime(String createDateTime) {
				this.createDateTime = createDateTime;
			}
			public List<Tickets> getTickets() {
				return tickets;
			}
			public void setTickets(List<Tickets> tickets) {
				this.tickets = tickets;
			}

			public class Tickets {
				private String ticketNo;
				private String sectionId;
				private String sectionName;
				private String rowId;
				private String columnId;
				private String infoCode;
				private String ticketPrice;
				private String ticketFee;
				private String serviceFee;
				private String printStatus;
				private String refundStatus;
				
				public String getTicketNo() {
					return ticketNo;
				}
				public void setTicketNo(String ticketNo) {
					this.ticketNo = ticketNo;
				}
				public String getSectionId() {
					return sectionId;
				}
				public void setSectionId(String sectionId) {
					this.sectionId = sectionId;
				}
				public String getSectionName() {
					return sectionName;
				}
				public void setSectionName(String sectionName) {
					this.sectionName = sectionName;
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
				public String getInfoCode() {
					return infoCode;
				}
				public void setInfoCode(String infoCode) {
					this.infoCode = infoCode;
				}
				public String getTicketPrice() {
					return ticketPrice;
				}
				public void setTicketPrice(String ticketPrice) {
					this.ticketPrice = ticketPrice;
				}
				public String getTicketFee() {
					return ticketFee;
				}
				public void setTicketFee(String ticketFee) {
					this.ticketFee = ticketFee;
				}
				public String getServiceFee() {
					return serviceFee;
				}
				public void setServiceFee(String serviceFee) {
					this.serviceFee = serviceFee;
				}
				public String getPrintStatus() {
					return printStatus;
				}
				public void setPrintStatus(String printStatus) {
					this.printStatus = printStatus;
				}
				public String getRefundStatus() {
					return refundStatus;
				}
				public void setRefundStatus(String refundStatus) {
					this.refundStatus = refundStatus;
				}
				
			}
			
		}
	}
}
