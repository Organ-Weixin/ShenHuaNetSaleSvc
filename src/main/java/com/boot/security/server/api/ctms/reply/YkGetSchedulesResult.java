package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class YkGetSchedulesResult {
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
			private String hallId;
			private String standardPrice;
			private String lowestPrice;
			private String settlePrice;
			private String ticketFee;
			private String feeType;
			private String throughStatus;
			private String stopSellingTime;
			private String saleStatus;
			private String sessionCode;
			private filmBean film;
			
			// private List<benefitCardPriceBean> benefitCardPrices;
			// private List<areaSettlePriceBean> areaSettlePrices;
			// private String areaId;
			
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
			public String getHallId() {
				return hallId;
			}
			public void setHallId(String hallId) {
				this.hallId = hallId;
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
			public String getThroughStatus() {
				return throughStatus;
			}
			public void setThroughStatus(String throughStatus) {
				this.throughStatus = throughStatus;
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
			public filmBean getFilm() {
				return film;
			}
			public void setFilm(filmBean film) {
				this.film = film;
			}

			/*
			 * public List<benefitCardPriceBean> getBenefitCardPrices() { return
			 * benefitCardPrices; } public void
			 * setBenefitCardPrices(List<benefitCardPriceBean>
			 * benefitCardPrices) { this.benefitCardPrices = benefitCardPrices;
			 * } public List<areaSettlePriceBean> getAreaSettlePrices() { return
			 * areaSettlePrices; } public void
			 * setAreaSettlePrices(List<areaSettlePriceBean> areaSettlePrices) {
			 * this.areaSettlePrices = areaSettlePrices; } public String
			 * getAreaId() { return areaId; } public void setAreaId(String
			 * areaId) { this.areaId = areaId; }
			 */
			public static class filmBean {
				private String filmCode;
				private String duration;
				private String dimensional;
				private String size;
				private String name;
				private String language;
				private String shortName;

				public String getFilmCode() {
					return filmCode;
				}

				public void setFilmCode(String filmCode) {
					this.filmCode = filmCode;
				}

				public String getDuration() {
					return duration;
				}

				public void setDuration(String duration) {
					this.duration = duration;
				}

				public String getDimensional() {
					return dimensional;
				}

				public void setDimensional(String dimensional) {
					this.dimensional = dimensional;
				}

				public String getSize() {
					return size;
				}

				public void setSize(String size) {
					this.size = size;
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
				private List<areaBenefitInfoBean> areaBenefitInfos;

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

				public List<areaBenefitInfoBean> getAreaBenefitInfos() {
					return areaBenefitInfos;
				}

				public void setAreaBenefitInfos(List<areaBenefitInfoBean> areaBenefitInfos) {
					this.areaBenefitInfos = areaBenefitInfos;
				}

				public static class areaBenefitInfoBean {
					private String code;
					private String benefitPayPrice;

					public String getCode() {
						return code;
					}

					public void setCode(String code) {
						this.code = code;
					}

					public String getBenefitPayPrice() {
						return benefitPayPrice;
					}

					public void setBenefitPayPrice(String benefitPayPrice) {
						this.benefitPayPrice = benefitPayPrice;
					}

				}

			}

			public static class areaSettlePriceBean {
				private String name;
				private String code;
				private String settlePrice;

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}

				public String getCode() {
					return code;
				}

				public void setCode(String code) {
					this.code = code;
				}

				public String getSettlePrice() {
					return settlePrice;
				}

				public void setSettlePrice(String settlePrice) {
					this.settlePrice = settlePrice;
				}
			}
		}
	}
	
}
