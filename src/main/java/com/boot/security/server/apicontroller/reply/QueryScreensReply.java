package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryScreensReply extends BaseReply {
	public QueryScreensReplyScreens data;

	public QueryScreensReplyScreens getData() {
		return data;
	}

	public void setData(QueryScreensReplyScreens data) {
		this.data = data;
	}
	public class QueryScreensReplyScreens{
		public int ScreenCount;
		public List<QueryScreensReplyScreen> Screen;
		public int getScreenCount() {
			return ScreenCount;
		}
		public void setScreenCount(int screenCount) {
			ScreenCount = screenCount;
		}
		public List<QueryScreensReplyScreen> getScreen() {
			return Screen;
		}
		public void setScreen(List<QueryScreensReplyScreen> screen) {
			Screen = screen;
		}
		public class QueryScreensReplyScreen{
			public Long ScreenId;
			public String CinemaCode;
			public String ScreenCode;
			public String ScreenName;
			public int SeatCount;
			public String Type;
			public Long getScreenId() {
				return ScreenId;
			}
			public void setScreenId(Long screenId) {
				ScreenId = screenId;
			}
			public String getCinemaCode() {
				return CinemaCode;
			}
			public void setCinemaCode(String cinemaCode) {
				CinemaCode = cinemaCode;
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
