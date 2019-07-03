package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class YzGetSchedules {
	private String api;
	private String v;
	private String retCode;
	private String retMsg;
	private dataBean data;

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
	public dataBean getData() {
		return data;
	}
	public void setData(dataBean data) {
		this.data = data;
	}
	
	public static class dataBean {
		private String bizMsg;
		private String bizCode;
		private List<ScheduleBean> dataList;

		public String getBizMsg() {
			return bizMsg;
		}
		public void setBizMsg(String bizMsg) {
			this.bizMsg = bizMsg;
		}
		public String getBizCode() {
			return bizCode;
		}
		public void setBizCode(String bizCode) {
			this.bizCode = bizCode;
		}
		public List<ScheduleBean> getDataList() {
			return dataList;
		}
		public void setDataList(List<ScheduleBean> dataList) {
			this.dataList = dataList;
		}

		public static class ScheduleBean {
			private String scheduleId;
			private String scheduleKey;
			private String cinemaLinkId;
			private String showDateTime;
			private String hallCode;
			private String standardPrice;
			private String lowestPrice;
			private String settlePrice;
			private String ticketFee;
			private String feeType;
			private String stopSellingTime;
			private String saleStatus;
			private String sessionCode;
			private String seatVersion;
			private filmBean film;
			private List<benefitCardPriceBean> benefitCardPrices;
			private List<areaInfo> areaInfoList;
			
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
			public String getCinemaLinkId() {
				return cinemaLinkId;
			}
			public void setCinemaLinkId(String cinemaLinkId) {
				this.cinemaLinkId = cinemaLinkId;
			}
			public String getShowDateTime() {
				return showDateTime;
			}
			public void setShowDateTime(String showDateTime) {
				this.showDateTime = showDateTime;
			}
			public String getHallCode() {
				return hallCode;
			}
			public void setHallCode(String hallCode) {
				this.hallCode = hallCode;
			}
			public String getStandardPrice() {
				return standardPrice;
			}
			public void setStandardPrice(String standardPrice) {
				this.standardPrice = standardPrice;
			}
			public String getLowestPrice() {
				return lowestPrice;
			}
			public void setLowestPrice(String lowestPrice) {
				this.lowestPrice = lowestPrice;
			}
			public String getSettlePrice() {
				return settlePrice;
			}
			public void setSettlePrice(String settlePrice) {
				this.settlePrice = settlePrice;
			}
			public String getTicketFee() {
				return ticketFee;
			}
			public void setTicketFee(String ticketFee) {
				this.ticketFee = ticketFee;
			}
			public String getFeeType() {
				return feeType;
			}
			public void setFeeType(String feeType) {
				this.feeType = feeType;
			}
			public String getStopSellingTime() {
				return stopSellingTime;
			}
			public void setStopSellingTime(String stopSellingTime) {
				this.stopSellingTime = stopSellingTime;
			}
			public String getSaleStatus() {
				return saleStatus;
			}
			public void setSaleStatus(String saleStatus) {
				this.saleStatus = saleStatus;
			}
			public String getSessionCode() {
				return sessionCode;
			}
			public void setSessionCode(String sessionCode) {
				this.sessionCode = sessionCode;
			}
			public String getSeatVersion() {
				return seatVersion;
			}
			public void setSeatVersion(String seatVersion) {
				this.seatVersion = seatVersion;
			}
			public filmBean getFilm() {
				return film;
			}
			public void setFilm(filmBean film) {
				this.film = film;
			}
			public List<benefitCardPriceBean> getBenefitCardPrices() {
				return benefitCardPrices;
			}
			public void setBenefitCardPrices(List<benefitCardPriceBean> benefitCardPrices) {
				this.benefitCardPrices = benefitCardPrices;
			}
			public List<areaInfo> getAreaInfoList() {
				return areaInfoList;
			}
			public void setAreaInfoList(List<areaInfo> areaInfoList) {
				this.areaInfoList = areaInfoList;
			}

			public static class filmBean {
				private String filmCode;
				private Integer duration;
				private String dimensional;
				private String name;
				private String language;
				private String shortName;

				public String getFilmCode() {
					return filmCode;
				}
				public void setFilmCode(String filmCode) {
					this.filmCode = filmCode;
				}
				public Integer getDuration() {
					return duration;
				}
				public void setDuration(Integer duration) {
					this.duration = duration;
				}
				public String getDimensional() {
					return dimensional;
				}
				public void setDimensional(String dimensional) {
					this.dimensional = dimensional;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public String getLanguage() {
					return language;
				}
				public void setLanguage(String language) {
					this.language = language;
				}
				public String getShortName() {
					return shortName;
				}
				public void setShortName(String shortName) {
					this.shortName = shortName;
				}

			}

			public static class benefitCardPriceBean {
				private String benefitPolicyCode;
				private String benefitPayPrice;
				private String eachShowDiscountTickets;
				private List<areaBenefitInfoBean> areaBenefitInfoList;

				public String getBenefitPolicyCode() {
					return benefitPolicyCode;
				}
				public void setBenefitPolicyCode(String benefitPolicyCode) {
					this.benefitPolicyCode = benefitPolicyCode;
				}
				public String getBenefitPayPrice() {
					return benefitPayPrice;
				}
				public void setBenefitPayPrice(String benefitPayPrice) {
					this.benefitPayPrice = benefitPayPrice;
				}
				public String getEachShowDiscountTickets() {
					return eachShowDiscountTickets;
				}
				public void setEachShowDiscountTickets(String eachShowDiscountTickets) {
					this.eachShowDiscountTickets = eachShowDiscountTickets;
				}
				public List<areaBenefitInfoBean> getAreaBenefitInfoList() {
					return areaBenefitInfoList;
				}
				public void setAreaBenefitInfoList(List<areaBenefitInfoBean> areaBenefitInfoList) {
					this.areaBenefitInfoList = areaBenefitInfoList;
				}


				public static class areaBenefitInfoBean {
					private String areaId;
					private String areaServiceFee;
					private String benefitPayPrice;
					
					public String getAreaId() {
						return areaId;
					}
					public void setAreaId(String areaId) {
						this.areaId = areaId;
					}
					public String getAreaServiceFee() {
						return areaServiceFee;
					}
					public void setAreaServiceFee(String areaServiceFee) {
						this.areaServiceFee = areaServiceFee;
					}
					public String getBenefitPayPrice() {
						return benefitPayPrice;
					}
					public void setBenefitPayPrice(String benefitPayPrice) {
						this.benefitPayPrice = benefitPayPrice;
					}

				}

			}

			public static class areaInfo {
				private String areaId;
				private String areaName;
				private String areaSettlePrice;
				private String areaServiceFee;
				
				public String getAreaId() {
					return areaId;
				}
				public void setAreaId(String areaId) {
					this.areaId = areaId;
				}
				public String getAreaName() {
					return areaName;
				}
				public void setAreaName(String areaName) {
					this.areaName = areaName;
				}
				public String getAreaSettlePrice() {
					return areaSettlePrice;
				}
				public void setAreaSettlePrice(String areaSettlePrice) {
					this.areaSettlePrice = areaSettlePrice;
				}
				public String getAreaServiceFee() {
					return areaServiceFee;
				}
				public void setAreaServiceFee(String areaServiceFee) {
					this.areaServiceFee = areaServiceFee;
				}
				
			}
		}
	}
	


}
