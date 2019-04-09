package com.boot.security.server.api.core;

import java.util.List;

import com.boot.security.server.model.StatusEnum;

public class QuerySessionReply extends BaseReply {
	public QuerySessionReply()
    {
        Id = ID_QuerySessionReply;
    }
	public QuerySessionReplySessions Sessions;
	public QuerySessionReplySessions getSessions() {
		return Sessions;
	}
	public void setSessions(QuerySessionReplySessions sessions) {
		Sessions = sessions;
	}
	public class QuerySessionReplySessions{
		public String CinemaCode;
		public List<QuerySessionReplySession> Session;
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public List<QuerySessionReplySession> getSession() {
			return Session;
		}
		public void setSession(List<QuerySessionReplySession> session) {
			Session = session;
		}
		public class QuerySessionReplySession{
			public String ScreenCode;
			public String Code;
			public String FeatureNo;
			public String StartTime;
			public StatusEnum PlaythroughFlag;
			public QuerySessionReplyFilms Films;
			public QuerySessionReplyPrice Price;
			public String getScreenCode() {
				return ScreenCode;
			}
			public void setScreenCode(String screenCode) {
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
			public String getStartTime() {
				return StartTime;
			}
			public void setStartTime(String startTime) {
				StartTime = startTime;
			}
			public StatusEnum getPlaythroughFlag() {
				return PlaythroughFlag;
			}
			public void setPlaythroughFlag(StatusEnum playthroughFlag) {
				PlaythroughFlag = playthroughFlag;
			}
			public QuerySessionReplyFilms getFilms() {
				return Films;
			}
			public void setFilms(QuerySessionReplyFilms films) {
				Films = films;
			}
			public QuerySessionReplyPrice getPrice() {
				return Price;
			}
			public void setPrice(QuerySessionReplyPrice price) {
				Price = price;
			}
			public class QuerySessionReplyFilms{
				private List<QuerySessionReplyFilm> Film;

				public List<QuerySessionReplyFilm> getFilm() {
					return Film;
				}

				public void setFilm(List<QuerySessionReplyFilm> film) {
					Film = film;
				}
				public class QuerySessionReplyFilm{
					public String Code;
					public String Name;
					public String Dimensional;
					public String Duration;
					public String Sequence;
					public String Language;
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
					public String getSequence() {
						return Sequence;
					}
					public void setSequence(String sequence) {
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
			public class QuerySessionReplyPrice{
				public String LowestPrice;
				public String StandardPrice;
				public String ListingPrice;
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
				
			}
		}
		
	}
	

}
