package com.boot.security.server.apicontroller.reply;

import java.util.List;


public class QueryFilmSessionsReply extends BaseReply{
	private QueryFilmSessionsReplyFilmSessions data;

	public QueryFilmSessionsReplyFilmSessions getData() {
		return data;
	}

	public void setData(QueryFilmSessionsReplyFilmSessions data) {
		this.data = data;
	}
	public static class QueryFilmSessionsReplyFilmSessions{
		private String CinemaCode;
		private String OfferDescription;
		private List<QueryFilmSessionsReplyFilm> filmList;
		
		public String getCinemaCode() {
			return CinemaCode;
		}

		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		
		public String getOfferDescription() {
			return OfferDescription;
		}

		public void setOfferDescription(String offerDescription) {
			OfferDescription = offerDescription;
		}

		public List<QueryFilmSessionsReplyFilm> getFilm() {
			return filmList;
		}

		public void setFilmList(List<QueryFilmSessionsReplyFilm> film) {
			this.filmList = film;
		}
		
			public static class QueryFilmSessionsReplyFilm{
				private String Code;
				private String Name;
				private String Dimensional;
				private String Duration;
				private String Language;
				private String Version;
				private String PublishDate;
				private String Publisher;
				private String Producer;
				private String Introduction;
				private String Score;
				private String Area;
				private String Type;
				private String Status;
				private String Image;
				private String Trailer;
				private String StagePhoto1;
				private String StagePhoto2;
				private String StagePhoto3;
				private String StagePhoto4;
				private String StagePhoto5;
				private String StagePhoto6;
				private List<QueryFilmSessionsReplySession> Session;
				private List<QueryFilmSessionsReplyDirector> Director;
				private List<QueryFilmSessionsReplyCast> Cast;

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
				public String getDuration() {
					return Duration;
				}
				public void setDuration(String duration) {
					Duration = duration;
				}
				public String getLanguage() {
					return Language;
				}
				public void setLanguage(String language) {
					Language = language;
				}
				
				public String getVersion() {
					return Version;
				}
				public void setVersion(String version) {
					Version = version;
				}
				public String getPublishDate() {
					return PublishDate;
				}
				public void setPublishDate(String publishDate) {
					PublishDate = publishDate;
				}
				public String getPublisher() {
					return Publisher;
				}
				public void setPublisher(String publisher) {
					Publisher = publisher;
				}
				public String getProducer() {
					return Producer;
				}
				public void setProducer(String producer) {
					Producer = producer;
				}
				public String getIntroduction() {
					return Introduction;
				}
				public void setIntroduction(String introduction) {
					Introduction = introduction;
				}
				public String getScore() {
					return Score;
				}
				public void setScore(String score) {
					Score = score;
				}
				public String getArea() {
					return Area;
				}
				public void setArea(String area) {
					Area = area;
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
				public String getImage() {
					return Image;
				}
				public void setImage(String image) {
					Image = image;
				}
				public String getTrailer() {
					return Trailer;
				}
				public void setTrailer(String trailer) {
					Trailer = trailer;
				}
				public String getStagePhoto1() {
					return StagePhoto1;
				}
				public void setStagePhoto1(String stagePhoto1) {
					StagePhoto1 = stagePhoto1;
				}
				public String getStagePhoto2() {
					return StagePhoto2;
				}
				public void setStagePhoto2(String stagePhoto2) {
					StagePhoto2 = stagePhoto2;
				}
				public String getStagePhoto3() {
					return StagePhoto3;
				}
				public void setStagePhoto3(String stagePhoto3) {
					StagePhoto3 = stagePhoto3;
				}
				public String getStagePhoto4() {
					return StagePhoto4;
				}
				public void setStagePhoto4(String stagePhoto4) {
					StagePhoto4 = stagePhoto4;
				}
				public String getStagePhoto5() {
					return StagePhoto5;
				}
				public void setStagePhoto5(String stagePhoto5) {
					StagePhoto5 = stagePhoto5;
				}
				public String getStagePhoto6() {
					return StagePhoto6;
				}
				public void setStagePhoto6(String stagePhoto6) {
					StagePhoto6 = stagePhoto6;
				}
				public List<QueryFilmSessionsReplySession> getSession() {
					return Session;
				}
				public void setSession(List<QueryFilmSessionsReplySession> session) {
					Session = session;
				}
				public List<QueryFilmSessionsReplyDirector> getDirector() {
					return Director;
				}
				public void setDirector(List<QueryFilmSessionsReplyDirector> director) {
					Director = director;
				}
				public List<QueryFilmSessionsReplyCast> getCast() {
					return Cast;
				}
				public void setCast(List<QueryFilmSessionsReplyCast> cast) {
					Cast = cast;
				}
				public static class QueryFilmSessionsReplySession{
					private String SessionCode;
					private String ScreenCode;
					private String ScreenName;
					private String FeatureNo;
					private String StartTime;
					private String StartDate;
					private String BeginTime;
					private Boolean IsToday;
					private String PlaythroughFlag;
					private Integer Sequence;
					private Double LowestPrice;
					private Double StandardPrice;
					private Double ListingPrice;
					private Double ActivityPrice;
					private Double MemberPrice;
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
					public String getFeatureNo() {
						return FeatureNo;
					}
					public void setFeatureNo(String featureNo) {
						FeatureNo = featureNo;
					}
					public String getStartTime() {
						return StartTime;
					}
					public void setStartTime(String startTime) {
						StartTime = startTime;
					}
					public String getStartDate() {
						return StartDate;
					}
					public void setStartDate(String startDate) {
						StartDate = startDate;
					}
					public String getBeginTime() {
						return BeginTime;
					}
					public void setBeginTime(String beginTime) {
						BeginTime = beginTime;
					}
					public Boolean getIsToday() {
						return IsToday;
					}
					public void setIsToday(Boolean isToday) {
						IsToday = isToday;
					}
					public String getPlaythroughFlag() {
						return PlaythroughFlag;
					}
					public void setPlaythroughFlag(String playthroughFlag) {
						PlaythroughFlag = playthroughFlag;
					}
					public Integer getSequence() {
						return Sequence;
					}
					public void setSequence(Integer sequence) {
						Sequence = sequence;
					}
					public Double getLowestPrice() {
						return LowestPrice;
					}
					public void setLowestPrice(Double lowestPrice) {
						LowestPrice = lowestPrice;
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
					public Double getActivityPrice() {
						return ActivityPrice;
					}
					public void setActivityPrice(Double activityPrice) {
						ActivityPrice = activityPrice;
					}
					public Double getMemberPrice() {
						return MemberPrice;
					}
					public void setMemberPrice(Double memberPrice) {
						MemberPrice = memberPrice;
					}
						
				}

				public static class QueryFilmSessionsReplyDirector{
					private String DirectorName;
					private String DirectorPicture;
					public String getDirectorName() {
						return DirectorName;
					}
					public void setDirectorName(String directorName) {
						DirectorName = directorName;
					}
					public String getDirectorPicture() {
						return DirectorPicture;
					}
					public void setDirectorPicture(String directorPicture) {
						DirectorPicture = directorPicture;
					}
					
				}
				
				public static class QueryFilmSessionsReplyCast{
					private String CastName;
					private String CastPicture;
					public String getCastName() {
						return CastName;
					}
					public void setCastName(String castName) {
						CastName = castName;
					}
					public String getCastPicture() {
						return CastPicture;
					}
					public void setCastPicture(String castPicture) {
						CastPicture = castPicture;
					}
					
				}
			}
		}
	
}
