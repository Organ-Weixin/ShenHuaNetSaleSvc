package com.boot.security.server.apicontroller.reply;

import java.util.Date;
import java.util.List;

public class QueryUserConponsReply extends BaseReply{
	private QueryUserConponsBeans data;
	public QueryUserConponsBeans getData() {
		return data;
	}
	public void setData(QueryUserConponsBeans data) {
		this.data = data;
	}
	public static class QueryUserConponsBeans{
		private int ConponCount;//优惠券数量
		private List<QueryUserConponsBean> Conpons;
		public int getConponCount() {
			return ConponCount;
		}
		public void setConponCount(int conponCount) {
			ConponCount = conponCount;
		}
		public List<QueryUserConponsBean> getConpons() {
			return Conpons;
		}
		public void setConpons(List<QueryUserConponsBean> conpons) {
			Conpons = conpons;
		}
		public static class QueryUserConponsBean{
			private Long ConponId;
			private String CinemaCode;
			private String TypeCode;
			private String GroupCode;
			private String OpenID;
			private String Price;
			private String ConponCode;
			private String GoodsCodes;
			private String FilmCodes;
			private String EffectiveDate;
			private String ExpireDate; 
			private String Status;
			private String UseDate;
			private String ReceivedDate;
			private String Title;
			private String Remark;
			private Integer CanUseCinemaType;//可用门店类型
			private String CinemaName;
			private Integer ReductionType;//影片或卖品类型
			private String FilmName;
			private String GoodsName;
			private Integer CanUsePeriodType;//可用时段类型 1：全部时段  2：部分时段
			private String WeekDays;//可用时间 0：周日 1：周一 ...
			private String TimePeriod;//可用时段-具体时间
			private boolean IsAllFilm;//true所有影片false部分影片
			private boolean IsAllGoods;//true所有卖品，false部分卖品
			private Integer IsShare;//是否叠加
			public Long getConponId() {
				return ConponId;
			}
			public void setConponId(Long conponId) {
				ConponId = conponId;
			}
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
			}
			public String getTypeCode() {
				return TypeCode;
			}
			public void setTypeCode(String typeCode) {
				TypeCode = typeCode;
			}
			public String getGroupCode() {
				return GroupCode;
			}
			public void setGroupCode(String groupCode) {
				GroupCode = groupCode;
			}
			public String getOpenID() {
				return OpenID;
			}
			public void setOpenID(String openID) {
				OpenID = openID;
			}
			public String getPrice() {
				return Price;
			}
			public void setPrice(String price) {
				Price = price;
			}
			public String getConponCode() {
				return ConponCode;
			}
			public void setConponCode(String conponCode) {
				ConponCode = conponCode;
			}
			public String getGoodsCodes() {
				return GoodsCodes;
			}
			public void setGoodsCodes(String goodsCodes) {
				GoodsCodes = goodsCodes;
			}
			public String getFilmCodes() {
				return FilmCodes;
			}
			public void setFilmCodes(String filmCodes) {
				FilmCodes = filmCodes;
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
			public String getStatus() {
				return Status;
			}
			public void setStatus(String status) {
				Status = status;
			}
			public String getUseDate() {
				return UseDate;
			}
			public void setUseDate(String useDate) {
				UseDate = useDate;
			}
			public String getReceivedDate() {
				return ReceivedDate;
			}
			public void setReceivedDate(String receivedDate) {
				ReceivedDate = receivedDate;
			}
			public String getTitle() {
				return Title;
			}
			public void setTitle(String title) {
				Title = title;
			}
			public String getRemark() {
				return Remark;
			}
			public void setRemark(String remark) {
				Remark = remark;
			}
			public Integer getCanUseCinemaType() {
				return CanUseCinemaType;
			}
			public void setCanUseCinemaType(Integer canUseCinemaType) {
				CanUseCinemaType = canUseCinemaType;
			}
			public String getCinemaName() {
				return CinemaName;
			}
			public void setCinemaName(String cinemaName) {
				CinemaName = cinemaName;
			}
			public Integer getReductionType() {
				return ReductionType;
			}
			public void setReductionType(Integer reductionType) {
				ReductionType = reductionType;
			}
			public String getFilmName() {
				return FilmName;
			}
			public void setFilmName(String filmName) {
				FilmName = filmName;
			}
			public String getGoodsName() {
				return GoodsName;
			}
			public void setGoodsName(String goodsName) {
				GoodsName = goodsName;
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
			public boolean isIsAllFilm() {
				return IsAllFilm;
			}
			public void setIsAllFilm(boolean isAllFilm) {
				IsAllFilm = isAllFilm;
			}
			public boolean isIsAllGoods() {
				return IsAllGoods;
			}
			public void setIsAllGoods(boolean isAllGoods) {
				IsAllGoods = isAllGoods;
			}
			public Integer getIsShare() {
				return IsShare;
			}
			public void setIsShare(Integer isShare) {
				IsShare = isShare;
			}
		}
	}
}
