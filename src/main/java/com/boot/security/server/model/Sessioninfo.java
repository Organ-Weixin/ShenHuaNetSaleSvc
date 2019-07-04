package com.boot.security.server.model;

import java.util.Date;
import java.util.List;

public class Sessioninfo {

	private Long Id;

	public Sessioninfo() {}

	private String CCode;	//影院编码
	private String SCode;	//场次编码
	private String ScreenCode;	//影厅编码
	private Date StartTime;
	private String FilmCode;
	private String FilmName;
	private Integer Duration;
	private String Language;
	private Date UpdateTime;
	private Double StandardPrice;
	private Double LowestPrice;
	private Double SettlePrice;
	private Double TicketFee;
	private Double AddFee;//增值服务费
	private Double CinemaAllowance;//影院补贴
	private Integer IsAvalible;
	private String PlaythroughFlag;
	private String Dimensional;
	private Integer Sequence;
	private Long UserID;
	private Double ListingPrice;
	private String FeatureNo;
	private String SessionId;
	private String SessionKey;
	private String InternalUpdateTime;
	private String MarketingCode;
	private String MarketingName;
	private String SeatVersion;	//对应的座位图版本编码,云智专用
	
	private Cinema cinema;
	private Screeninfo screeninfo;
	private Userinfo userinfo;
	private Priceplan priceplan;
	private Filminfo Filminfo;
	private List<Qmmprice> qmmprices;
	
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public Screeninfo getScreeninfo() {
		return screeninfo;
	}
	public void setScreeninfo(Screeninfo screeninfo) {
		this.screeninfo = screeninfo;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public Priceplan getPriceplan() {
		return priceplan;
	}
	public void setPriceplan(Priceplan priceplan) {
		this.priceplan = priceplan;
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getCCode() {
		return CCode;
	}
	public void setCCode(String CCode) {
		this.CCode = CCode;
	}
	public String getSCode() {
		return SCode;
	}
	public void setSCode(String SCode) {
		this.SCode = SCode;
	}
	public String getScreenCode() {
		return ScreenCode;
	}
	public void setScreenCode(String ScreenCode) {
		this.ScreenCode = ScreenCode;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date StartTime) {
		this.StartTime = StartTime;
	}
	public String getFilmCode() {
		return FilmCode;
	}
	public void setFilmCode(String FilmCode) {
		this.FilmCode = FilmCode;
	}
	public String getFilmName() {
		return FilmName;
	}
	public void setFilmName(String FilmName) {
		this.FilmName = FilmName;
	}
	public Integer getDuration() {
		return Duration;
	}
	public void setDuration(Integer Duration) {
		this.Duration = Duration;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String Language) {
		this.Language = Language;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date UpdateTime) {
		this.UpdateTime = UpdateTime;
	}
	public Double getStandardPrice() {
		return StandardPrice;
	}
	public void setStandardPrice(Double StandardPrice) {
		this.StandardPrice = StandardPrice;
	}
	public Double getLowestPrice() {
		return LowestPrice;
	}
	public void setLowestPrice(Double LowestPrice) {
		this.LowestPrice = LowestPrice;
	}
	public Double getSettlePrice() {
		return SettlePrice;
	}
	public void setSettlePrice(Double SettlePrice) {
		this.SettlePrice = SettlePrice;
	}
	public Double getTicketFee() {
		return TicketFee;
	}
	public void setTicketFee(Double TicketFee) {
		this.TicketFee = TicketFee;
	}
	public Double getAddFee() {
		return AddFee;
	}
	public void setAddFee(Double addFee) {
		AddFee = addFee;
	}
	public Double getCinemaAllowance() {
		return CinemaAllowance;
	}
	public void setCinemaAllowance(Double cinemaAllowance) {
		CinemaAllowance = cinemaAllowance;
	}
	public Integer getIsAvalible() {
		return IsAvalible;
	}
	public void setIsAvalible(Integer IsAvalible) {
		this.IsAvalible = IsAvalible;
	}
	public String getPlaythroughFlag() {
		return PlaythroughFlag;
	}
	public void setPlaythroughFlag(String PlaythroughFlag) {
		this.PlaythroughFlag = PlaythroughFlag;
	}
	public String getDimensional() {
		return Dimensional;
	}
	public void setDimensional(String Dimensional) {
		this.Dimensional = Dimensional;
	}
	public Integer getSequence() {
		return Sequence;
	}
	public void setSequence(Integer Sequence) {
		this.Sequence = Sequence;
	}
	public Long getUserID() {
		return UserID;
	}
	public void setUserID(Long UserID) {
		this.UserID = UserID;
	}
	public Double getListingPrice() {
		return ListingPrice;
	}
	public void setListingPrice(Double ListingPrice) {
		this.ListingPrice = ListingPrice;
	}
	public String getFeatureNo() {
		return FeatureNo;
	}
	public void setFeatureNo(String FeatureNo) {
		this.FeatureNo = FeatureNo;
	}
	public String getSessionId() {
		return SessionId;
	}
	public void setSessionId(String SessionId) {
		this.SessionId = SessionId;
	}
	public String getSessionKey() {
		return SessionKey;
	}
	public void setSessionKey(String SessionKey) {
		this.SessionKey = SessionKey;
	}
	public String getInternalUpdateTime() {
		return InternalUpdateTime;
	}
	public void setInternalUpdateTime(String InternalUpdateTime) {
		this.InternalUpdateTime = InternalUpdateTime;
	}
	public String getMarketingCode() {
		return MarketingCode;
	}
	public void setMarketingCode(String marketingCode) {
		MarketingCode = marketingCode;
	}
	public String getMarketingName() {
		return MarketingName;
	}
	public void setMarketingName(String marketingName) {
		MarketingName = marketingName;
	}
	public String getSeatVersion() {
		return SeatVersion;
	}
	public void setSeatVersion(String seatVersion) {
		SeatVersion = seatVersion;
	}
	public Filminfo getFilminfo() {
		return Filminfo;
	}
	public void setFilminfo(Filminfo filminfo) {
		Filminfo = filminfo;
	}
	public List<Qmmprice> getQmmprices() {
		return qmmprices;
	}
	public void setQmmprices(List<Qmmprice> qmmprices) {
		this.qmmprices = qmmprices;
	}
	
}
