package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class Dy1905GetScreenResult {
	private ResBean GetScreenResult;

	public ResBean getGetScreenResult() {
		return GetScreenResult;
	}

	public void setGetScreenResult(ResBean getScreenResult) {
		GetScreenResult = getScreenResult;
	}
	public static class ResBean{
		private String ResultCode;
		private ScreensBean Screens;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public ScreensBean getScreens() {
			return Screens;
		}
		public void setScreens(ScreensBean screens) {
			Screens = screens;
		}
		public static class ScreensBean{
			private List<ScreenBean> Screen;

			public List<ScreenBean> getScreen() {
				return Screen;
			}

			public void setScreen(List<ScreenBean> screen) {
				Screen = screen;
			}
			public static class ScreenBean{
				private String ScreenNo;
				private String ScreenCode;
				private String ScreenName;
				private String ScreenType;
				private String ScreenTypeDesc;
				public String getScreenNo() {
					return ScreenNo;
				}
				public void setScreenNo(String screenNo) {
					ScreenNo = screenNo;
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
				public String getScreenTypeDesc() {
					return ScreenTypeDesc;
				}
				public void setScreenTypeDesc(String screenTypeDesc) {
					ScreenTypeDesc = screenTypeDesc;
				}
			}
		}
	}
}
