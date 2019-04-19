package com.boot.security.server.api.ctms.reply;

import java.util.List; 

public class CxQueryDiscountFacts {
	private String cardLevelCode;
	private List<planInfoBean> planInfos;
	private String consumeWayCode;
	public String getCardLevelCode() {
		return cardLevelCode;
	}
	public void setCardLevelCode(String cardLevelCode) {
		this.cardLevelCode = cardLevelCode;
	}
	public List<planInfoBean> getPlanInfos() {
		return planInfos;
	}
	public void setPlanInfos(List<planInfoBean> planInfos) {
		this.planInfos = planInfos;
	}
	public String getConsumeWayCode() {
		return consumeWayCode;
	}
	public void setConsumeWayCode(String consumeWayCode) {
		this.consumeWayCode = consumeWayCode;
	}
	public static class planInfoBean{
		private String featureAppNo;
		private String startTime;
		private String filmCode;
		private String hallType;
		private Float listingPrice;
		private Float lowestPrice;
		public String getFeatureAppNo() {
			return featureAppNo;
		}
		public void setFeatureAppNo(String featureAppNo) {
			this.featureAppNo = featureAppNo;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getFilmCode() {
			return filmCode;
		}
		public void setFilmCode(String filmCode) {
			this.filmCode = filmCode;
		}
		public String getHallType() {
			return hallType;
		}
		public void setHallType(String hallType) {
			this.hallType = hallType;
		}
		public Float getListingPrice() {
			return listingPrice;
		}
		public void setListingPrice(Float listingPrice) {
			this.listingPrice = listingPrice;
		}
		public Float getLowestPrice() {
			return lowestPrice;
		}
		public void setLowestPrice(Float lowestPrice) {
			this.lowestPrice = lowestPrice;
		}
		
	}
	

}
