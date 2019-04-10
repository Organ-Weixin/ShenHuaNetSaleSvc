package com.boot.security.server.api.ctms.reply;

import java.util.List;

/**
 * 凤凰佳影--查询影院列表 
 * res : {"status":1,"errorMessage":null,"errorCode":null,"data":[{"cinemaId":"11","cinemaName":"测试-81","validPeriod":"2022-04-18","cinemaNumber":"10088888"},{"cinemaId":"31","cinemaName":"电商平台测试影院电商平台测试影院电商平台测试影院172.16.9.87","validPeriod":"2022-04-18","cinemaNumber":"11088777"}]}
 * RES:{"api": "ykse.partner.cinema.getCinemas", "v": "1.0","retCode": "0", "retMsg": "success", 
 	"data": {"bizMsg": "操作成功","bizCode": "SUCCESS", 
 				"dataList": [
  					{"cinemaLinkId": "56", "city": "广州","cinemaId": "56565656","cityCode": "440100", "name": "56 影院",
  					 "hallCount": 1,"halls": [{"hallId": "8","name": "10","type": "N","seatCount": 24}]}] } } 
 * @author sheng
 *
 */
public class YkGetCinemasResult {
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
		private List<YkCinema> dataList;
		
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
		public List<YkCinema> getDataList() {
			return dataList;
		}
		public void setDataList(List<YkCinema> dataList) {
			this.dataList = dataList;
		}

		public static class YkCinema {
			private String cinemaLinkId ;
			private String name;
			private String cinemaId;
			private String cityCode;
			private String city;
			private Integer hallCount; 
			private String refundBeforeTime;
			private List<Halls> halls;
			
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
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
			public List<Halls> getHalls() {
				return halls;
			}
			public void setHalls(List<Halls> halls) {
				this.halls = halls;
			}

			public static class Halls{
				private String hallId;
				private String name;
				private Integer seatCount;
				private String type;
				
				public String getHallId() {
					return hallId;
				}
				public void setHallId(String hallId) {
					this.hallId = hallId;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public Integer getSeatCount() {
					return seatCount;
				}
				public void setSeatCount(Integer seatCount) {
					this.seatCount = seatCount;
				}
				public String getType() {
					return type;
				}
				public void setType(String type) {
					this.type = type;
				}
				
			}
		}
	}
}
