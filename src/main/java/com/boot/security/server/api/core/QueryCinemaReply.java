package com.boot.security.server.api.core;

import java.util.List;

public class QueryCinemaReply extends BaseReply{
	public QueryCinemaReply()
    {
        Id = ID_QueryCinemaReply;
    }
	public QueryCinemaReplyCinema Cinema;
	public QueryCinemaReplyCinema getCinema() {
		return Cinema;
	}
	public void setCinema(QueryCinemaReplyCinema cinema) {
		Cinema = cinema;
	}
	public class QueryCinemaReplyCinema{
		public String Code;
		public String Name;
		public String Address;
		public int ScreenCount;
		public List<QueryCinemaReplyScreen> Screen;
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
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public int getScreenCount() {
			return ScreenCount;
		}
		public void setScreenCount(int screenCount) {
			ScreenCount = screenCount;
		}
		public List<QueryCinemaReplyScreen> getScreen() {
			return Screen;
		}
		public void setScreen(List<QueryCinemaReplyScreen> screen) {
			Screen = screen;
		}
		public class QueryCinemaReplyScreen{
			public String Code;
			public String Name;
			public int SeatCount;
			public String Type;
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
			public int getSeatCount() {
				return SeatCount;
			}
			public void setSeatCount(int seatCount) {
				SeatCount = seatCount;
			}
			public String getType() {
				return Type;
			}
			public void setType(String type) {
				Type = type;
			}
		}
	}
}
