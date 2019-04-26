package com.boot.security.server.apicontroller.reply;

public class QueryOrderSessionReply  extends BaseReply{
	//获取订单场次信息
	private QueryOrderSessionReplyOrderSession data;
	public QueryOrderSessionReplyOrderSession getData() {
		return data;
	}
	public void setData(QueryOrderSessionReplyOrderSession data) {
		this.data = data;
	}
	public class QueryOrderSessionReplyOrderSession{
		private Long SessionId;//场次ID
		private String CCode;//影院编码
		private String SCode;//
		private String ScreenCode;//影厅编码
		private String StartTime;//开始时间
		private String FilmCode;//影片编码
		private String FilmName;//影片名称
		private String Duration;//影片时长
		private String Language;//语言版本
		private String StandardPrice;//
		private String LowestPrice;
		private String SettlePrice;
		private String ListingPrice;
		private String ScreenType;//影片类型
	
		public Long getSessionId() {
			return SessionId;
		}
		public void setSessionId(Long sessionId) {
			SessionId = sessionId;
		}
		public String getCCode() {
			return CCode;
		}
		public void setCCode(String cCode) {
			CCode = cCode;
		}
		public String getSCode() {
			return SCode;
		}
		public void setSCode(String sCode) {
			SCode = sCode;
		}
		public String getScreenCode() {
			return ScreenCode;
		}
		public void setScreenCode(String screenCode) {
			ScreenCode = screenCode;
		}
		public String getStartTime() {
			return StartTime;
		}
		public void setStartTime(String startTime) {
			StartTime = startTime;
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
		public String getStandardPrice() {
			return StandardPrice;
		}
		public void setStandardPrice(String standardPrice) {
			StandardPrice = standardPrice;
		}
		public String getLowestPrice() {
			return LowestPrice;
		}
		public void setLowestPrice(String lowestPrice) {
			LowestPrice = lowestPrice;
		}
		public String getSettlePrice() {
			return SettlePrice;
		}
		public void setSettlePrice(String settlePrice) {
			SettlePrice = settlePrice;
		}
		public String getListingPrice() {
			return ListingPrice;
		}
		public void setListingPrice(String listingPrice) {
			ListingPrice = listingPrice;
		}
		public String getScreenType() {
			return ScreenType;
		}
		public void setScreenType(String screenType) {
			ScreenType = screenType;
		}
		
	}
}
