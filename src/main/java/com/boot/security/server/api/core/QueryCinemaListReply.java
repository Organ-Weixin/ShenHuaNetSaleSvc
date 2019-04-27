package com.boot.security.server.api.core;

import java.util.List;


public class QueryCinemaListReply extends BaseReply {
	public QueryCinemaListReply()
    {
        Id = ID_QueryCinemaListReply;
    }
	private QueryCinemaListReplyCinemas Cinemas;
	public QueryCinemaListReplyCinemas getCinemas() {
		return Cinemas;
	}
	public void setCinemas(QueryCinemaListReplyCinemas cinemas) {
		Cinemas = cinemas;
	}
	public class QueryCinemaListReplyCinemas{
		private int CinemaCount;
		private List<QueryCinemaListReplyCinema> Cinema;
		public int getCinemaCount() {
			return CinemaCount;
		}
		public void setCinemaCount(int cinemaCount) {
			CinemaCount = cinemaCount;
		}
		public List<QueryCinemaListReplyCinema> getCinema() {
			return Cinema;
		}
		public void setCinema(List<QueryCinemaListReplyCinema> cinema) {
			Cinema = cinema;
		}
		public class QueryCinemaListReplyCinema{
			private String Code;
			private String Name;
			private int Type;
			private String Address;
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
			public int getType() {
				return Type;
			}
			public void setType(int type) {
				Type = type;
			}
			public String getAddress() {
				return Address;
			}
			public void setAddress(String address) {
				Address = address;
			}
			
		}
	}
}
