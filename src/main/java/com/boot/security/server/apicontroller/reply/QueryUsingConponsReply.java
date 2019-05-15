package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryUsingConponsReply extends BaseReply {

	private ConponData data;
	
	public ConponData getData() {
		return data;
	}
	public void setData(ConponData data) {
		this.data = data;
	}

	public static class ConponData {
		private int ConponCount;
		private List<ConponBean> Conpons;
		
		public int getConponCount() {
			return ConponCount;
		}
		public void setConponCount(int conponCount) {
			ConponCount = conponCount;
		}
		public List<ConponBean> getConpons() {
			return Conpons;
		}
		public void setConpons(List<ConponBean> conpons) {
			Conpons = conpons;
		}

		public static class ConponBean {
			private String CinemaCode;
			private String GroupCode;
			private String CouponsType;
			private String CouponsName;
			private Integer ValidityType;
			private String EffectiveDate;
			private String ExpireDate;
			private Integer EffectiveDays;
			private Integer ValidityDays;
			private Integer CanUsePeriodType;
			private String WeekDays;
			private String TimePeriod;
			private Integer LimitNum;
			private Integer ReductionType;
			private Double ReductionPrice;
			private String FilmCodes;
			private String GoodsCodes;
			private int IsShare;
			private String Status;
			private int RemainingNumber;
			private String Remark;
			
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}
			public String getGroupCode() {
				return GroupCode;
			}
			public void setGroupCode(String groupCode) {
				GroupCode = groupCode;
			}
			public String getCouponsType() {
				return CouponsType;
			}
			public void setCouponsType(String couponsType) {
				CouponsType = couponsType;
			}
			public String getCouponsName() {
				return CouponsName;
			}
			public void setCouponsName(String couponsName) {
				CouponsName = couponsName;
			}
			public Integer getValidityType() {
				return ValidityType;
			}
			public void setValidityType(Integer validityType) {
				ValidityType = validityType;
			}
			public String getEffectiveDate() {
				return EffectiveDate;
			}
			public void setEffectiveDate(String effectiveDate) {
				EffectiveDate = effectiveDate;
			}
			public String getExpireDate() {
				return ExpireDate;
			}
			public void setExpireDate(String expireDate) {
				ExpireDate = expireDate;
			}
			public Integer getEffectiveDays() {
				return EffectiveDays;
			}
			public void setEffectiveDays(Integer effectiveDays) {
				EffectiveDays = effectiveDays;
			}
			public Integer getValidityDays() {
				return ValidityDays;
			}
			public void setValidityDays(Integer validityDays) {
				ValidityDays = validityDays;
			}
			public Integer getCanUsePeriodType() {
				return CanUsePeriodType;
			}
			public void setCanUsePeriodType(Integer canUsePeriodType) {
				CanUsePeriodType = canUsePeriodType;
			}
			public String getWeekDays() {
				return WeekDays;
			}
			public void setWeekDays(String weekDays) {
				WeekDays = weekDays;
			}
			public String getTimePeriod() {
				return TimePeriod;
			}
			public void setTimePeriod(String timePeriod) {
				TimePeriod = timePeriod;
			}
			public Integer getLimitNum() {
				return LimitNum;
			}
			public void setLimitNum(Integer limitNum) {
				LimitNum = limitNum;
			}
			public Integer getReductionType() {
				return ReductionType;
			}
			public void setReductionType(Integer reductionType) {
				ReductionType = reductionType;
			}
			public Double getReductionPrice() {
				return ReductionPrice;
			}
			public void setReductionPrice(Double reductionPrice) {
				ReductionPrice = reductionPrice;
			}
			public String getFilmCodes() {
				return FilmCodes;
			}
			public void setFilmCodes(String filmCodes) {
				FilmCodes = filmCodes;
			}
			public String getGoodsCodes() {
				return GoodsCodes;
			}
			public void setGoodsCodes(String goodsCodes) {
				GoodsCodes = goodsCodes;
			}
			public int getIsShare() {
				return IsShare;
			}
			public void setIsShare(int isShare) {
				IsShare = isShare;
			}
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			public int getRemainingNumber() {
				return RemainingNumber;
			}
			public void setRemainingNumber(int remainingNumber) {
				RemainingNumber = remainingNumber;
			}
			public String getRemark() {
				return Remark;
			}
			public void setRemark(String remark) {
				Remark = remark;
			}
			
		}
	}
}
