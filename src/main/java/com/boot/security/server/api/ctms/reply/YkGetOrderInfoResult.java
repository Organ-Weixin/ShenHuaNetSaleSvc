package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 凤凰佳影--查询订单
 * @author sheng
 *
 */
public class YkGetOrderInfoResult {

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
		private OrderInfo data;
		
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
		public OrderInfo getData() {
			return data;
		}
		public void setData(OrderInfo data) {
			this.data = data;
		}

		public static class OrderInfo {
			private String orderId;
			private String bookingId;
			private String confirmationId;
			private String showDateTime;
			private String hallId;
			private String filmCode;
			private String shortName;
			private String status;
			private List<Tickets> tickets;
			private GoodsOrder goodsOrder;
			
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
			public String getShowDateTime() {
				return showDateTime;
			}
			public void setShowDateTime(String showDateTime) {
				this.showDateTime = showDateTime;
			}
			public String getHallId() {
				return hallId;
			}
			public void setHallId(String hallId) {
				this.hallId = hallId;
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
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			public List<Tickets> getTickets() {
				return tickets;
			}
			public void setTickets(List<Tickets> tickets) {
				this.tickets = tickets;
			}
			public GoodsOrder getGoodsOrder() {
				return goodsOrder;
			}
			public void setGoodsOrder(GoodsOrder goodsOrder) {
				this.goodsOrder = goodsOrder;
			}
			
			public static class Tickets {
				private String ticketNo;
				private String seatCode;
				private String sectionId;
				private String rowId;
				private String columnId;
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
				public String getSeatCode() {
					return seatCode;
				}
				public void setSeatCode(String seatCode) {
					this.seatCode = seatCode;
				}
				public String getSectionId() {
					return sectionId;
				}
				public void setSectionId(String sectionId) {
					this.sectionId = sectionId;
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
			
			public static class GoodsOrder {
				private String holdId;
				private String pickUpCode;
				private String totalGoodsFee;
				private List<Goods> goods;
				
				public String getHoldId() {
					return holdId;
				}
				public void setHoldId(String holdId) {
					this.holdId = holdId;
				}
				public String getPickUpCode() {
					return pickUpCode;
				}
				public void setPickUpCode(String pickUpCode) {
					this.pickUpCode = pickUpCode;
				}
				public String getTotalGoodsFee() {
					return totalGoodsFee;
				}
				public void setTotalGoodsFee(String totalGoodsFee) {
					this.totalGoodsFee = totalGoodsFee;
				}
				public List<Goods> getGoods() {
					return goods;
				}
				public void setGoods(List<Goods> goods) {
					this.goods = goods;
				}

				public static class Goods {
					private String goodsId;
					private String name;
					private String salePrice;
					private Integer count;
					private boolean isPickage;
					public String getGoodsId() {
						return goodsId;
					}
					public void setGoodsId(String goodsId) {
						this.goodsId = goodsId;
					}
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public String getSalePrice() {
						return salePrice;
					}
					public void setSalePrice(String salePrice) {
						this.salePrice = salePrice;
					}
					public Integer getCount() {
						return count;
					}
					public void setCount(Integer count) {
						this.count = count;
					}
					public boolean isPickage() {
						return isPickage;
					}
					public void setPickage(boolean isPickage) {
						this.isPickage = isPickage;
					}
					
				}
			}
		}
	}
}
