package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class CinemaChannelPlaysReply extends BaseReply{

	private List<FilmInfoBean> data;
	
	public List<FilmInfoBean> getData() {
		return data;
	}
	public void setData(List<FilmInfoBean> data) {
		this.data = data;
	}

	public static class FilmInfoBean {
		private String ScreenCode;
		private String ScreenName;
		private String FilmCode;
		private String FilmName;
		private String SessionTime;
		private List<Plays> Plays;

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
		public String getSessionTime() {
			return SessionTime;
		}
		public void setSessionTime(String sessionTime) {
			SessionTime = sessionTime;
		}
		public List<Plays> getPlays() {
			return Plays;
		}
		public void setPlays(List<Plays> plays) {
			Plays = plays;
		}

		public static class Plays {
			private String ChannelCode;
			private String ChannelName;
			private String SettlePrice;
			private String StandardPrice;
			private String MinPrice;
			
			public String getChannelCode() {
				return ChannelCode;
			}
			public void setChannelCode(String channelCode) {
				ChannelCode = channelCode;
			}
			public String getChannelName() {
				return ChannelName;
			}
			public void setChannelName(String channelName) {
				ChannelName = channelName;
			}
			public String getSettlePrice() {
				return SettlePrice;
			}
			public void setSettlePrice(String settlePrice) {
				SettlePrice = settlePrice;
			}
			public String getStandardPrice() {
				return StandardPrice;
			}
			public void setStandardPrice(String standardPrice) {
				StandardPrice = standardPrice;
			}
			public String getMinPrice() {
				return MinPrice;
			}
			public void setMinPrice(String minPrice) {
				MinPrice = minPrice;
			}
			
		}
		
	}
	
}
