package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class MtxGetCinemaPlanResult {
	// GetCinemaPlan获取对应影院对应日期的排期
	private ResBean GetCinemaPlanResult;

	public ResBean getGetCinemaPlanResult() {
		return GetCinemaPlanResult;
	}

	public void setGetCinemaPlanResult(ResBean getCinemaPlanResult) {
		GetCinemaPlanResult = getCinemaPlanResult;
	}

	public static class ResBean {
		private String ResultCode;
		private CinemaPlansBean CinemaPlans;

		public String getResultCode() {
			return ResultCode;
		}

		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}

		public CinemaPlansBean getCinemaPlans() {
			return CinemaPlans;
		}

		public void setCinemaPlans(CinemaPlansBean cinemaPlans) {
			CinemaPlans = cinemaPlans;
		}

		public static class CinemaPlansBean {
			private List<CinemaPlanBean> CinemaPlan;

			public List<CinemaPlanBean> getCinemaPlan() {
				return CinemaPlan;
			}

			public void setCinemaPlan(List<CinemaPlanBean> cinemaPlan) {
				CinemaPlan = cinemaPlan;
			}

			public static class CinemaPlanBean {
				private String FeatureAppNo;// 排期应用号
				private String FeatureNo;// 排期号，应用于会员卡接口
				private String FeatureDate;// 排期日期(yyyy-MM-dd)
				private String FeatureTime;// 排期时间hh:mm
				private String TotalTime;// 结束时间hh:mm
				private String FilmNo;// 影片编号
				private String FilmName;// 影片名称
				private String HallNo;// 影厅编号
				private String PlaceNo;// 应用编号
				private String AppPric;// 票价
				private double StandPric;//标准价格
				private double ProtectPrice;// 保护价
				private String SetClose;// 计划状态0未售，1开售，2截止，3停售，5统计，9注销
				private String UseSign;// 可用性0可用，1不可用，3待审核
				private String CopyType;// 拷贝类型
				private String CopyLanguage;// 拷贝语言
				private int AvailableSeats;// 剩余座位数
				private int HallSeats;// 影厅座位数
				public String getFeatureAppNo() {
					return FeatureAppNo;
				}
				public void setFeatureAppNo(String featureAppNo) {
					FeatureAppNo = featureAppNo;
				}
				public String getFeatureNo() {
					return FeatureNo;
				}
				public void setFeatureNo(String featureNo) {
					FeatureNo = featureNo;
				}
				public String getFeatureDate() {
					return FeatureDate;
				}
				public void setFeatureDate(String featureDate) {
					FeatureDate = featureDate;
				}
				public String getFeatureTime() {
					return FeatureTime;
				}
				public void setFeatureTime(String featureTime) {
					FeatureTime = featureTime;
				}
				public String getTotalTime() {
					return TotalTime;
				}
				public void setTotalTime(String totalTime) {
					TotalTime = totalTime;
				}
				public String getFilmNo() {
					return FilmNo;
				}
				public void setFilmNo(String filmNo) {
					FilmNo = filmNo;
				}
				public String getFilmName() {
					return FilmName;
				}
				public void setFilmName(String filmName) {
					FilmName = filmName;
				}
				public String getHallNo() {
					return HallNo;
				}
				public void setHallNo(String hallNo) {
					HallNo = hallNo;
				}
				public String getPlaceNo() {
					return PlaceNo;
				}
				public void setPlaceNo(String placeNo) {
					PlaceNo = placeNo;
				}
				public String getAppPric() {
					return AppPric;
				}
				public void setAppPric(String appPric) {
					AppPric = appPric;
				}
				public double getStandPric() {
					return StandPric;
				}
				public void setStandPric(double standPric) {
					StandPric = standPric;
				}
				public double getProtectPrice() {
					return ProtectPrice;
				}
				public void setProtectPrice(double protectPrice) {
					ProtectPrice = protectPrice;
				}
				public String getSetClose() {
					return SetClose;
				}
				public void setSetClose(String setClose) {
					SetClose = setClose;
				}
				public String getUseSign() {
					return UseSign;
				}
				public void setUseSign(String useSign) {
					UseSign = useSign;
				}
				public String getCopyType() {
					return CopyType;
				}
				public void setCopyType(String copyType) {
					CopyType = copyType;
				}
				public String getCopyLanguage() {
					return CopyLanguage;
				}
				public void setCopyLanguage(String copyLanguage) {
					CopyLanguage = copyLanguage;
				}
				public int getAvailableSeats() {
					return AvailableSeats;
				}
				public void setAvailableSeats(int availableSeats) {
					AvailableSeats = availableSeats;
				}
				public int getHallSeats() {
					return HallSeats;
				}
				public void setHallSeats(int hallSeats) {
					HallSeats = hallSeats;
				}

			}
		}
	}

}
