package com.boot.security.server.api.ctms.reply;

import java.util.List;


public class MtxGetCinemaResult {

	//获取电影院信息
	private ResBean GetCinemaResult;

	public ResBean getGetCinemaResult() {
		return GetCinemaResult;
	}

	public void setGetCinemaResult(ResBean getCinemaResult) {
		GetCinemaResult = getCinemaResult;
	}


	public static class ResBean{
		private String ResultCode;
		private CinemasBean Cinemas;
		
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		
	
		
	}
	public static class CinemasBean{
		private  List<CinemaBean> Cinema;

		public List<CinemaBean> getCinema() {
			return Cinema;
		}

		public void setCinema(List<CinemaBean> cinema) {
			Cinema = cinema;
		}
		
	}
	public static class CinemaBean{
		private String PlaceNo;
		private String PlaceName;
		private String CityNo;
		private String CreateDate;
		private String CutTime;
		private String State;
		private String SysCode;
		private String haverule;
		private String Version;
		private String CityName;
	}
	
}
