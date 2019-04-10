package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 凤凰佳影-- 锁定座位
 * @author sheng
 *
 */
public class YkLockSeatsResult {

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
		private SeatBean data;
		
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
		public SeatBean getData() {
			return data;
		}
		public void setData(SeatBean data) {
			this.data = data;
		}

		public class SeatBean {
			private String lockOrderId;
			private String outLockId;
			private List<Seats> seats;
			
			public String getLockOrderId() {
				return lockOrderId;
			}
			public void setLockOrderId(String lockOrderId) {
				this.lockOrderId = lockOrderId;
			}
			public String getOutLockId() {
				return outLockId;
			}
			public void setOutLockId(String outLockId) {
				this.outLockId = outLockId;
			}
			public List<Seats> getSeats() {
				return seats;
			}
			public void setSeats(List<Seats> seats) {
				this.seats = seats;
			}
			
			public class Seats {
				private String seatId;

				public String getSeatId() {
					return seatId;
				}

				public void setSeatId(String seatId) {
					this.seatId = seatId;
				}
				
			}
			
		}
		
	}
}
