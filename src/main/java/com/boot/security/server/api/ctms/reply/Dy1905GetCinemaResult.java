package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class Dy1905GetCinemaResult {
	private ResBean GetCinemaResult;

	public ResBean getGetCinemaResult() {
		return GetCinemaResult;
	}

	public void setGetCinemaResult(ResBean getCinemaResult) {
		GetCinemaResult = getCinemaResult;
	}
	public static class ResBean {
		private String ResultCode;
		private CinemasBean Cinemas;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public CinemasBean getCinemas() {
			return Cinemas;
		}
		public void setCinemas(CinemasBean cinemas) {
			Cinemas = cinemas;
		}
		public static class CinemasBean{
			private List<CinemaBean> Cinema;

			public List<CinemaBean> getCinema() {
				return Cinema;
			}

			public void setCinema(List<CinemaBean> cinema) {
				Cinema = cinema;
			}
			public static class CinemaBean{
				private String CinemaNo;
				private String CinemaName;
				private String CinemaCode;
				private String CityNo;
				private String CreateDate;
				private String SellStopTime;
				public String getCinemaNo() {
					return CinemaNo;
				}
				public void setCinemaNo(String cinemaNo) {
					CinemaNo = cinemaNo;
				}
				public String getCinemaName() {
					return CinemaName;
				}
				public void setCinemaName(String cinemaName) {
					CinemaName = cinemaName;
				}
				public String getCinemaCode() {
					return CinemaCode;
				}
				public void setCinemaCode(String cinemaCode) {
					CinemaCode = cinemaCode;
				}
				public String getCityNo() {
					return CityNo;
				}
				public void setCityNo(String cityNo) {
					CityNo = cityNo;
				}
				public String getCreateDate() {
					return CreateDate;
				}
				public void setCreateDate(String createDate) {
					CreateDate = createDate;
				}
				public String getSellStopTime() {
					return SellStopTime;
				}
				public void setSellStopTime(String sellStopTime) {
					SellStopTime = sellStopTime;
				}
				
			}
		}
	}

}
