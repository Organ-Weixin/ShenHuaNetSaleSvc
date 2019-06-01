package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 凤凰佳影混合下单接口返回；同时购买卖品和选座票
 * @author sheng
 *
 */
public class YkConfirmMixOrderResult {
	
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
		private ConfirmMixOrderBean data;
		
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
		public ConfirmMixOrderBean getData() {
			return data;
		}
		public void setData(ConfirmMixOrderBean data) {
			this.data = data;
		}

		public static class ConfirmMixOrderBean {
			private String orderId;
			private String bookingId;
			private String confirmationId;
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
			
			public static class GoodsOrder {
				private String holdId;
				private String pickUpCode;
				private String totalGoodsPrice;
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
				public String getTotalGoodsPrice() {
					return totalGoodsPrice;
				}
				public void setTotalGoodsPrice(String totalGoodsPrice) {
					this.totalGoodsPrice = totalGoodsPrice;
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
					private Boolean isPackage;
					
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
					public Boolean getIsPackage() {
						return isPackage;
					}
					public void setIsPackage(Boolean isPackage) {
						this.isPackage = isPackage;
					}
					
				}
			}
		}
	}
}
