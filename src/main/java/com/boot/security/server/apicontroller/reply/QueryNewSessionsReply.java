package com.boot.security.server.apicontroller.reply;

import java.util.Date;
import java.util.List;

public class QueryNewSessionsReply extends BaseReply {
	// 获取影片场次信息-新
	private QueryNewSessionsReplyNewSessions Films;
	public QueryNewSessionsReplyNewSessions getFilms() {
		return Films;
	}
	public void setFilms(QueryNewSessionsReplyNewSessions films) {
		Films = films;
	}
	public class QueryNewSessionsReplyNewSessions {
		private String CinemaCode;// 影院编码
		private List<QueryNewSessionsReplyFilm> Film;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public List<QueryNewSessionsReplyFilm> getFilm() {
			return Film;
		}
		public void setFilm(List<QueryNewSessionsReplyFilm> film) {
			Film = film;
		}
		public class QueryNewSessionsReplyFilm {
			private String Code;// 影片编码
			private String Name;// 影片名称
			private String Dimensional;// 影片维度(2D/3D)
			private int Duration;// 影片时长
			private int Sequence;// 影片在连场中的序号
			private String Language;// 影片语言
			private QueryNewSessionsReplySessions Sessionns;
			//private QueryNewSessionsReplyPrices Price;

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
			public QueryNewSessionsReplySessions getSessionns() {
				return Sessionns;
			}
			public void setSessionns(QueryNewSessionsReplySessions sessionns) {
				Sessionns = sessionns;
			}
		/*	public QueryNewSessionsReplyPrices getPrice() {
				return Price;
			}
			public void setPrice(QueryNewSessionsReplyPrices price) {
				Price = price;
			}*/
			public class QueryNewSessionsReplySessions {
				private List<QueryNewSessionsReplySession> Sessionn;
				public List<QueryNewSessionsReplySession> getSessionn() {
					return Sessionn;
				}
				public void setSessionn(List<QueryNewSessionsReplySession> sessionn) {
					Sessionn = sessionn;
				}
				public class QueryNewSessionsReplySession {
					private int ScreenCode;// 影厅编码
					private String Code;// 场次编码
					private String FeatureNo;// 满天星排期号
					private Date StartTime;// 场次时间
					private String PlaythroughFlag;// 连场标志
					private String LowestPrice;// 最低票价
					private String StandardPrice;// 标准票价
					private String ListingPrice;// 挂牌票价
					private String ActivityPrice;// 活动价
					private String MemberPrice;// 会员价
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
/*
			public class QueryNewSessionsReplyPrices {
				private String LowestPrice;// 最低票价
				private String StandardPrice;// 标准票价
				private String ListingPrice;// 挂牌票价
				private String ActivityPrice;// 活动价
				private String MemberPrice;// 会员价

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

			}*/
		}

	}

}
