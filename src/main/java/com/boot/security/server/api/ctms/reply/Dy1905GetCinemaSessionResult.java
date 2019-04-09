package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.List;

import com.boot.security.server.model.StatusEnum;

/*
 * 电影1905获取对应影院对应日期的排期
 * */
public class Dy1905GetCinemaSessionResult {
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
				private String SessionDate;
				private Date StartTime;
				private Date TotalTime;
				private String Consecutive;
				private String FilmCount;
				private String ScreenNo;
				private String ScreenNType;
				private String CinemaNo;
				private String AppPrice;
				private String SettlementPrice;
				private String StandardPrice;
				private String LowestPrice;
				private String Fee;
				private String Type;
				private String Status;
				private FilmsBean Films;
				public String getSessionNo() {
					return SessionNo;
				}
				public void setSessionNo(String sessionNo) {
					SessionNo = sessionNo;
				}
				public String getSessionDate() {
					return SessionDate;
				}
				public void setSessionDate(String sessionDate) {
					SessionDate = sessionDate;
				}
				public Date getStartTime() {
					return StartTime;
				}
				public void setStartTime(Date startTime) {
					StartTime = startTime;
				}
				public Date getTotalTime() {
					return TotalTime;
				}
				public void setTotalTime(Date totalTime) {
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
				public String getSettlementPrice() {
					return SettlementPrice;
				}
				public void setSettlementPrice(String settlementPrice) {
					SettlementPrice = settlementPrice;
				}
				public String getStandardPrice() {
					return StandardPrice;
				}
				public void setStandardPrice(String standardPrice) {
					StandardPrice = standardPrice;
				}
				public String getLowestPrice() {
					return LowestPrice;
				}
				public void setLowestPrice(String lowestPrice) {
					LowestPrice = lowestPrice;
				}
				public String getFee() {
					return Fee;
				}
				public void setFee(String fee) {
					Fee = fee;
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
				public FilmsBean getFilms() {
					return Films;
				}
				public void setFilms(FilmsBean films) {
					Films = films;
				}
				
				public static class FilmsBean{
					private List<FilmBean> Film;
					
					public List<FilmBean> getFilm() {
						return Film;
					}

					public void setFilm(List<FilmBean> film) {
						Film = film;
					}

					public static class FilmBean{
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
			}
		}
	}
}
