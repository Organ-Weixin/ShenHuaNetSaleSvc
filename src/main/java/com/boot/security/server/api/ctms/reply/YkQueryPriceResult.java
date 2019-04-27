package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 查询会员卡影票价格
 * @author sheng
 *
 */
public class YkQueryPriceResult {

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
		private CardPrice data;
		
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
		public CardPrice getData() {
			return data;
		}
		public void setData(CardPrice data) {
			this.data = data;
		}

		public static class CardPrice {
			private Integer calculatePerTicketTimes;
			private List<TicketsPrice> tickets;
			
			public Integer getCalculatePerTicketTimes() {
				return calculatePerTicketTimes;
			}
			public void setCalculatePerTicketTimes(Integer calculatePerTicketTimes) {
				this.calculatePerTicketTimes = calculatePerTicketTimes;
			}
			public List<TicketsPrice> getTickets() {
				return tickets;
			}
			public void setTickets(List<TicketsPrice> tickets) {
				this.tickets = tickets;
			}

			public static class TicketsPrice {
				private String ticketType;
				private Boolean isCardDiscount;
				private String price;
				private Integer maxTickets;
				private String tradePoints;
				
				public String getTicketType() {
					return ticketType;
				}
				public void setTicketType(String ticketType) {
					this.ticketType = ticketType;
				}
				public Boolean getIsCardDiscount() {
					return isCardDiscount;
				}
				public void setIsCardDiscount(Boolean isCardDiscount) {
					this.isCardDiscount = isCardDiscount;
				}
				public String getPrice() {
					return price;
				}
				public void setPrice(String price) {
					this.price = price;
				}
				public Integer getMaxTickets() {
					return maxTickets;
				}
				public void setMaxTickets(Integer maxTickets) {
					this.maxTickets = maxTickets;
				}
				public String getTradePoints() {
					return tradePoints;
				}
				public void setTradePoints(String tradePoints) {
					this.tradePoints = tradePoints;
				}
				
			}
		}
	}
}
