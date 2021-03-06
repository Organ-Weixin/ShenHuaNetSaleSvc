package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryFilmSessionPriceReply extends BaseReply{
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
				private String SessionTime;
				private String ScreenCode;
				private String ScreenName;
				private String ScreenType;
				private String Language;
				private Double SalePrice;
				private Double StandardPrice;
				private Double ListingPrice;
				private Double LowestPrice;
				private Double TicketFee;
				private Double AddFee;
				private Double CinemaAllowance;
				private Double Price;
				private String BeginTime;
				private String EndTime;
				private List<QueryFimlSessionPriceReplyMemberPrice> MemberPirce;
				private List<QueryFimlSessionPriceReplySessionPrice> SessionPrice;
				public String getSessionCode() {
					return SessionCode;
				}
				public void setSessionCode(String sessionCode) {
					SessionCode = sessionCode;
				}
				public String getSessionTime() {
					return SessionTime;
				}
				public void setSessionTime(String sessionTime) {
					SessionTime = sessionTime;
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
				public String getScreenType() {
					return ScreenType;
				}
				public void setScreenType(String screenType) {
					ScreenType = screenType;
				}
				public String getLanguage() {
					return Language;
				}
				public void setLanguage(String language) {
					Language = language;
				}
				public Double getSalePrice() {
					return SalePrice;
				}
				public void setSalePrice(Double salePrice) {
					SalePrice = salePrice;
				}
				public Double getStandardPrice() {
					return StandardPrice;
				}
				public void setStandardPrice(Double standardPrice) {
					StandardPrice = standardPrice;
				}
				public Double getListingPrice() {
					return ListingPrice;
				}
				public void setListingPrice(Double listingPrice) {
					ListingPrice = listingPrice;
				}
				public Double getLowestPrice() {
					return LowestPrice;
				}
				public void setLowestPrice(Double lowestPrice) {
					LowestPrice = lowestPrice;
				}
				public Double getTicketFee() {
					return TicketFee;
				}
				public void setTicketFee(Double ticketFee) {
					TicketFee = ticketFee;
				}
				public Double getAddFee() {
					return AddFee;
				}
				public void setAddFee(Double addFee) {
					AddFee = addFee;
				}
				public Double getCinemaAllowance() {
					return CinemaAllowance;
				}
				public void setCinemaAllowance(Double cinemaAllowance) {
					CinemaAllowance = cinemaAllowance;
				}
				public Double getPrice() {
					return Price;
				}
				public void setPrice(Double price) {
					Price = price;
				}
				public String getBeginTime() {
					return BeginTime;
				}
				public void setBeginTime(String beginTime) {
					BeginTime = beginTime;
				}
				public String getEndTime() {
					return EndTime;
				}
				public void setEndTime(String endTime) {
					EndTime = endTime;
				}
				public List<QueryFimlSessionPriceReplyMemberPrice> getMemberPirce() {
					return MemberPirce;
				}
				public void setMemberPirce(List<QueryFimlSessionPriceReplyMemberPrice> memberPirce) {
					MemberPirce = memberPirce;
				}
				public List<QueryFimlSessionPriceReplySessionPrice> getSessionPrice() {
					return SessionPrice;
				}
				public void setSessionPrice(List<QueryFimlSessionPriceReplySessionPrice> sessionPrice) {
					SessionPrice = sessionPrice;
				}
				public static class QueryFimlSessionPriceReplyMemberPrice{
					private Double MemberPrice;

					public Double getMemberPrice() {
						return MemberPrice;
					}

					public void setMemberPrice(Double memberPrice) {
						MemberPrice = memberPrice;
					}
					
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
