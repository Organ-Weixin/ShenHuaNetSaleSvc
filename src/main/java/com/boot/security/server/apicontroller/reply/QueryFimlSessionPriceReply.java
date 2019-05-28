package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryFimlSessionPriceReply extends BaseReply{
	private QueryFimlSessionPriceReplyFilm data;

	public QueryFimlSessionPriceReplyFilm getData() {
		return data;
	}

	public void setData(QueryFimlSessionPriceReplyFilm data) {
		this.data = data;
	}
	public static class QueryFimlSessionPriceReplyFilm{
		private String CinemaCode;
		private String FilmCode;
		private String FilmName;
		private String Duration;
		private String FilmType;
		private String Cast;
		private List<QueryFimlSessionPriceReplySessionDate> SessionDate;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getFilmCode() {
			return FilmCode;
		}
		public void setFilmCode(String filmCode) {
			FilmCode = filmCode;
		}
		public String getFilmName() {
			return FilmName;
		}
		public void setFilmName(String filmName) {
			FilmName = filmName;
		}
		public String getDuration() {
			return Duration;
		}
		public void setDuration(String duration) {
			Duration = duration;
		}
		public String getFilmType() {
			return FilmType;
		}
		public void setFilmType(String filmType) {
			FilmType = filmType;
		}
		public String getCast() {
			return Cast;
		}
		public void setCast(String cast) {
			Cast = cast;
		}
		public List<QueryFimlSessionPriceReplySessionDate> getSessionDate() {
			return SessionDate;
		}
		public void setSessionDate(List<QueryFimlSessionPriceReplySessionDate> sessionDate) {
			SessionDate = sessionDate;
		}
		public static class QueryFimlSessionPriceReplySessionDate{
			private String SessionDate;
			private List<QueryFimlSessionPriceReplySession> Session;
			
			public String getSessionDate() {
				return SessionDate;
			}

			public void setSessionDate(String sessionDate) {
				SessionDate = sessionDate;
			}
			
			public List<QueryFimlSessionPriceReplySession> getSession() {
				return Session;
			}

			public void setSession(List<QueryFimlSessionPriceReplySession> session) {
				Session = session;
			}
			public static class QueryFimlSessionPriceReplySession{
				private String SessionCode;
				private String ScreenCode;
				private String ScreenName;
				private String Language;
				private Double SettlePrice;
				private Double StandardPrice;
				private String SessionTime;
				private String EndTime;
				private List<QueryFimlSessionPriceReplySessionPrice> SessionPrice;
				public String getSessionCode() {
					return SessionCode;
				}
				public void setSessionCode(String sessionCode) {
					SessionCode = sessionCode;
				}
				public String getScreenCode() {
					return ScreenCode;
				}
				public void setScreenCode(String screenCode) {
					ScreenCode = screenCode;
				}
				public String getScreenName() {
					return ScreenName;
				}
				public void setScreenName(String screenName) {
					ScreenName = screenName;
				}
				public String getLanguage() {
					return Language;
				}
				public void setLanguage(String language) {
					Language = language;
				}
				public Double getSettlePrice() {
					return SettlePrice;
				}
				public void setSettlePrice(Double settlePrice) {
					SettlePrice = settlePrice;
				}
				public Double getStandardPrice() {
					return StandardPrice;
				}
				public void setStandardPrice(Double standardPrice) {
					StandardPrice = standardPrice;
				}
				public String getSessionTime() {
					return SessionTime;
				}
				public void setSessionTime(String sessionTime) {
					SessionTime = sessionTime;
				}
				public String getEndTime() {
					return EndTime;
				}
				public void setEndTime(String endTime) {
					EndTime = endTime;
				}
				public List<QueryFimlSessionPriceReplySessionPrice> getSessionPrice() {
					return SessionPrice;
				}
				public void setSessionPrice(List<QueryFimlSessionPriceReplySessionPrice> sessionPrice) {
					SessionPrice = sessionPrice;
				}
				public static class QueryFimlSessionPriceReplySessionPrice{
					private String TypeCode;
					private String TypeName;
					private Double SettlePrice;
					private Double StandardPrice;
					public String getTypeCode() {
						return TypeCode;
					}
					public void setTypeCode(String typeCode) {
						TypeCode = typeCode;
					}
					public String getTypeName() {
						return TypeName;
					}
					public void setTypeName(String typeName) {
						TypeName = typeName;
					}
					public Double getSettlePrice() {
						return SettlePrice;
					}
					public void setSettlePrice(Double settlePrice) {
						SettlePrice = settlePrice;
					}
					public Double getStandardPrice() {
						return StandardPrice;
					}
					public void setStandardPrice(Double standardPrice) {
						StandardPrice = standardPrice;
					}
					
				}
			}
		}
	}
}
