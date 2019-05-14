package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryScreenRoomReply extends BaseReply {

	private List<ScreenRoom> data;
	
	public List<ScreenRoom> getData() {
		return data;
	}
	public void setData(List<ScreenRoom> data) {
		this.data = data;
	}

	public static class ScreenRoom {
		private String CinemaCode;
		private String CinemaName;
		private String ScreenName;
		private String FilmName;
		private String StartTime;
		private String EndTime;
		private String Image;
		
		public String getCinemaCode() {
			return CinemaCode;
		}
		public void setCinemaCode(String cinemaCode) {
			CinemaCode = cinemaCode;
		}
		public String getCinemaName() {
			return CinemaName;
		}
		public void setCinemaName(String cinemaName) {
			CinemaName = cinemaName;
		}
		public String getScreenName() {
			return ScreenName;
		}
		public void setScreenName(String screenName) {
			ScreenName = screenName;
		}
		public String getFilmName() {
			return FilmName;
		}
		public void setFilmName(String filmName) {
			FilmName = filmName;
		}
		public String getStartTime() {
			return StartTime;
		}
		public void setStartTime(String startTime) {
			StartTime = startTime;
		}
		public String getEndTime() {
			return EndTime;
		}
		public void setEndTime(String endTime) {
			EndTime = endTime;
		}
		public String getImage() {
			return Image;
		}
		public void setImage(String image) {
			Image = image;
		}
		
	}
}
