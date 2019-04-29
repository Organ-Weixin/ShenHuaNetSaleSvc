package com.boot.security.server.apicontroller.reply;

import java.util.Date;
import java.util.List;


public class QuerySessionsReply extends BaseReply {
	// 获取影片场次信息

	private  QuerySessionsReplySessions Sessions;
	public QuerySessionsReplySessions getSessions() {
		return Sessions;
	}
	public void setSessions(QuerySessionsReplySessions sessions) {
		Sessions = sessions;
	}
	public class QuerySessionsReplySessions {
		private String CinemaCode;// 影院编码
		private List<QuerySessionsReplySession> Session;
	
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public List<QuerySessionsReplySession> getSession() {
			return Session;
		}
		public void setSession(List<QuerySessionsReplySession> session) {
			Session = session;
		}
		public class QuerySessionsReplySession {
			private int ScreenCode;// 影厅编码
			private String Code;// 场次编码
			private String FeatureNo;// 满天星排期号
			private Date StartTime;// 场次时间
			private String PlaythroughFlag;// 连场标志
			private QuerySessionsReplyFilms Films;
			private QuerySessionsReplyPrices Price;
					
			public int getScreenCode() {
				return ScreenCode;
			}

			public void setScreenCode(int screenCode) {
				ScreenCode = screenCode;
			}

			public String getCode() {
				return Code;
			}

			public void setCode(String code) {
				Code = code;
			}

			public String getFeatureNo() {
				return FeatureNo;
			}

			public void setFeatureNo(String featureNo) {
				FeatureNo = featureNo;
			}

			public Date getStartTime() {
				return StartTime;
			}

			public void setStartTime(Date startTime) {
				StartTime = startTime;
			}

			public String getPlaythroughFlag() {
				return PlaythroughFlag;
			}

			public void setPlaythroughFlag(String playthroughFlag) {
				PlaythroughFlag = playthroughFlag;
			}

			public QuerySessionsReplyFilms getFilms() {
				return Films;
			}

			public void setFilms(QuerySessionsReplyFilms films) {
				Films = films;
			}

			public QuerySessionsReplyPrices getPrice() {
				return Price;
			}

			public void setPrice(QuerySessionsReplyPrices price) {
				Price = price;
			}

			public class QuerySessionsReplyFilms {
				private List<QuerySessionsReplyFilm> Film;
			
				public List<QuerySessionsReplyFilm> getFilm() {
					return Film;
				}

				public void setFilm(List<QuerySessionsReplyFilm> film) {
					Film = film;
				}

				public class QuerySessionsReplyFilm {
					private String Code;// 影片编码
					private String Name;// 影片名称
					private String Dimensional;// 影片维度(2D/3D)
					private int Duration;// 影片时长影片
					private int Sequence;// 在连场中的序号
					private String Language;// 影片语言 国语 英语
					public String getCode() {
						return Code;
					}
					public void setCode(String code) {
						Code = code;
					}
					public String getName() {
						return Name;
					}
					public void setName(String name) {
						Name = name;
					}
					public String getDimensional() {
						return Dimensional;
					}
					public void setDimensional(String dimensional) {
						Dimensional = dimensional;
					}
					public int getDuration() {
						return Duration;
					}
					public void setDuration(int duration) {
						Duration = duration;
					}
					public int getSequence() {
						return Sequence;
					}
					public void setSequence(int sequence) {
						Sequence = sequence;
					}
					public String getLanguage() {
						return Language;
					}
					public void setLanguage(String language) {
						Language = language;
					}
				}
			}
			public class QuerySessionsReplyPrices {
				private String LowestPrice;
				private String StandardPrice;
				private String ListingPrice;
				private String ActivityPrice;
				private String MemberPrice;
				public String getLowestPrice() {
					return LowestPrice;
				}
				public void setLowestPrice(String lowestPrice) {
					LowestPrice = lowestPrice;
				}
				public String getStandardPrice() {
					return StandardPrice;
				}
				public void setStandardPrice(String standardPrice) {
					StandardPrice = standardPrice;
				}
				public String getListingPrice() {
					return ListingPrice;
				}
				public void setListingPrice(String listingPrice) {
					ListingPrice = listingPrice;
				}
				public String getActivityPrice() {
					return ActivityPrice;
				}
				public void setActivityPrice(String activityPrice) {
					ActivityPrice = activityPrice;
				}
				public String getMemberPrice() {
					return MemberPrice;
				}
				public void setMemberPrice(String memberPrice) {
					MemberPrice = memberPrice;
				}
			}

		}
	}

}
