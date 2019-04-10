package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 凤凰佳影--确认订单
 * @author sheng
 *
 */
public class YkConfirmOrderResult {

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
		private OrderBean data;
		
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
		public OrderBean getData() {
			return data;
		}
		public void setData(OrderBean data) {
			this.data = data;
		}

		public class OrderBean {
			private String orderId;
			private String bookingId;
			private String confirmationId;
			private List<Tickets> tickets;
			
			public String getOrderId() {
				return orderId;
			}
			public void setOrderId(String orderId) {
				this.orderId = orderId;
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
			public List<Tickets> getTickets() {
				return tickets;
			}
			public void setTickets(List<Tickets> tickets) {
				this.tickets = tickets;
			}

			public class Tickets {
				private String ticketNo;
				private String seatId;
				private String seatCode;
				private String seationId;
				private String rowId;
				private String columnId;
				private String serviceFee;
				
				public String getTicketNo() {
					return ticketNo;
				}
				public void setTicketNo(String ticketNo) {
					this.ticketNo = ticketNo;
				}
				public String getSeatId() {
					return seatId;
				}
				public void setSeatId(String seatId) {
					this.seatId = seatId;
				}
				public String getSeatCode() {
					return seatCode;
				}
				public void setSeatCode(String seatCode) {
					this.seatCode = seatCode;
				}
				public String getSeationId() {
					return seationId;
				}
				public void setSeationId(String seationId) {
					this.seationId = seationId;
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
				public String getServiceFee() {
					return serviceFee;
				}
				public void setServiceFee(String serviceFee) {
					this.serviceFee = serviceFee;
				}
				
			}
		}
	}
}
