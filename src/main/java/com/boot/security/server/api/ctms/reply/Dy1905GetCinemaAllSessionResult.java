package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.List;



/*
 * 电影1905获取对应影院对应日期的排期
 * */
public class Dy1905GetCinemaAllSessionResult {
	private ResBean GetCinemaSessionResult;
	
	public ResBean getGetCinemaSessionResult() {
		return GetCinemaSessionResult;
	}

	public void setGetCinemaSessionResult(ResBean getCinemaSessionResult) {
		GetCinemaSessionResult = getCinemaSessionResult;
	}

	public static class ResBean{
		private String ResultCode;
		private SessionsBean Sessions;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		
		public SessionsBean getSessions() {
			return Sessions;
		}
		public void setSessions(SessionsBean sessions) {
			Sessions = sessions;
		}

		public static class SessionsBean{
			private List<SessionBean> Session;

			public List<SessionBean> getSession() {
				return Session;
			}

			public void setSession(List<SessionBean> session) {
				Session = session;
			}
			public static class SessionBean{
				private String SessionNo;
				private Date SessionDate;
				private Date StartTime;
				private String TotalTime;
				private String Consecutive;
				private String FilmCount;
				private FilmsBean Films;
				public String getSessionNo() {
					return SessionNo;
				}
				public void setSessionNo(String sessionNo) {
					SessionNo = sessionNo;
				}
				public Date getSessionDate() {
					return SessionDate;
				}
				public void setSessionDate(Date sessionDate) {
					SessionDate = sessionDate;
				}
				public Date getStartTime() {
					return StartTime;
				}
				public void setStartTime(Date startTime) {
					StartTime = startTime;
				}
				public String getTotalTime() {
					return TotalTime;
				}
				public void setTotalTime(String totalTime) {
					TotalTime = totalTime;
				}
				public String getConsecutive() {
					return Consecutive;
				}
				public void setConsecutive(String consecutive) {
					Consecutive = consecutive;
				}
				public String getFilmCount() {
					return FilmCount;
				}
				public void setFilmCount(String filmCount) {
					FilmCount = filmCount;
				}
				public FilmsBean getFilms() {
					return Films;
				}
				public void setFilms(FilmsBean films) {
					Films = films;
				}
				public static class FilmsBean{
					private List<SessionFilmBean> Film;

					public List<SessionFilmBean> getFilm() {
						return Film;
					}

					public void setFilm(List<SessionFilmBean> film) {
						Film = film;
					}
					public static class SessionFilmBean{
						private String FilmNo;
						private String FilmName;
						private String FilmType;
						private String Language;
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
						public String getFilmType() {
							return FilmType;
						}
						public void setFilmType(String filmType) {
							FilmType = filmType;
						}
						public String getLanguage() {
							return Language;
						}
						public void setLanguage(String language) {
							Language = language;
						}
					}
				}
				private String ScreenNo;
				private String ScreenNType;
				private String CinemaNo;
				private String AppPrice;
				private Double SettlementPrice;
				private Double StandartPrice;
				private Double LowestPrice;
				private Double Fee;
				private Double CinemaFee;
				private String Type;
				private String Status;
				public String getScreenNo() {
					return ScreenNo;
				}
				public void setScreenNo(String screenNo) {
					ScreenNo = screenNo;
				}
				public String getScreenNType() {
					return ScreenNType;
				}
				public void setScreenNType(String screenNType) {
					ScreenNType = screenNType;
				}
				public String getCinemaNo() {
					return CinemaNo;
				}
				public void setCinemaNo(String cinemaNo) {
					CinemaNo = cinemaNo;
				}
				public String getAppPrice() {
					return AppPrice;
				}
				public void setAppPrice(String appPrice) {
					AppPrice = appPrice;
				}
				public Double getSettlementPrice() {
					return SettlementPrice;
				}
				public void setSettlementPrice(Double settlementPrice) {
					SettlementPrice = settlementPrice;
				}
				public Double getStandartPrice() {
					return StandartPrice;
				}
				public void setStandartPrice(Double standartPrice) {
					StandartPrice = standartPrice;
				}
				public Double getLowestPrice() {
					return LowestPrice;
				}
				public void setLowestPrice(Double lowestPrice) {
					LowestPrice = lowestPrice;
				}
				public Double getFee() {
					return Fee;
				}
				public void setFee(Double fee) {
					Fee = fee;
				}
				public Double getCinemaFee() {
					return CinemaFee;
				}
				public void setCinemaFee(Double cinemaFee) {
					CinemaFee = cinemaFee;
				}
				public String getType() {
					return Type;
				}
				public void setType(String type) {
					Type = type;
				}
				public String getStatus() {
					return Status;
				}
				public void setStatus(String status) {
					Status = status;
				}
			}
		}
	}
}
