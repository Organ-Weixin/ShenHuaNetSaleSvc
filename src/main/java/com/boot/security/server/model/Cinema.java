package com.boot.security.server.model;

import java.util.Date;

public class Cinema extends BaseEntity<Long> {

	private Long Id;
	private Integer MId;
	private String Code;	//影院编码
	private String Name;	//影院名称
	private String Province;
	private String City;
	private String Address;
	private Integer ScreenCount;
	private Integer ManualAdd;
	private Integer IsOpen;
	private String ContactName;
	private String ContactMobile;
	private Integer TheaterChain;
	private Double Latitude;
	private Double Longitude;
	private Integer IsOpenSnacks;
	private String CinemaPhone;
	private String TicketHint;
	private String CinemaLabel;
	private Integer IsSnackDistribution;
	private Date Created;
	private Date Updated;
	private String CinemaId;
	private String QmmCinemaId;
	private Integer IsUseLowestPriceReport;
	private Integer IsGeneralStore;
	private Integer OverRefundTime;//开场前几分钟不可以退票
	private Double RefundFee;//退票手续费
	private String SmsAccount;
	private String SmsPwd;
	private String SmsSignId;
	private String BusinessPic;
	private String BusinessName;
	private String BusinessDesc;
	private int BeforeStartTime;
	private String CinemaAgreement;
	
	private Date GoodsUpdated; //影院卖品更新时间

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public Integer getMId() {
		return MId;
	}
	public void setMId(Integer MId) {
		this.MId = MId;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String Code) {
		this.Code = Code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String Province) {
		this.Province = Province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public Integer getScreenCount() {
		return ScreenCount;
	}
	public void setScreenCount(Integer ScreenCount) {
		this.ScreenCount = ScreenCount;
	}
	public Integer getManualAdd() {
		return ManualAdd;
	}
	public void setManualAdd(Integer ManualAdd) {
		this.ManualAdd = ManualAdd;
	}
	public Integer getIsOpen() {
		return IsOpen;
	}
	public void setIsOpen(Integer IsOpen) {
		this.IsOpen = IsOpen;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String ContactName) {
		this.ContactName = ContactName;
	}
	public String getContactMobile() {
		return ContactMobile;
	}
	public void setContactMobile(String ContactMobile) {
		this.ContactMobile = ContactMobile;
	}
	public Integer getTheaterChain() {
		return TheaterChain;
	}
	public void setTheaterChain(Integer TheaterChain) {
		this.TheaterChain = TheaterChain;
	}
	public Double getLatitude() {
		return Latitude;
	}
	public void setLatitude(Double Latitude) {
		this.Latitude = Latitude;
	}
	public Double getLongitude() {
		return Longitude;
	}
	public void setLongitude(Double Longitude) {
		this.Longitude = Longitude;
	}
	public Integer getIsOpenSnacks() {
		return IsOpenSnacks;
	}
	public void setIsOpenSnacks(Integer IsOpenSnacks) {
		this.IsOpenSnacks = IsOpenSnacks;
	}
	public String getCinemaPhone() {
		return CinemaPhone;
	}
	public void setCinemaPhone(String CinemaPhone) {
		this.CinemaPhone = CinemaPhone;
	}
	public String getTicketHint() {
		return TicketHint;
	}
	public void setTicketHint(String TicketHint) {
		this.TicketHint = TicketHint;
	}
	public String getCinemaLabel() {
		return CinemaLabel;
	}
	public void setCinemaLabel(String CinemaLabel) {
		this.CinemaLabel = CinemaLabel;
	}
	public Integer getIsSnackDistribution() {
		return IsSnackDistribution;
	}
	public void setIsSnackDistribution(Integer IsSnackDistribution) {
		this.IsSnackDistribution = IsSnackDistribution;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public Date getUpdated() {
		return Updated;
	}
	public void setUpdated(Date Updated) {
		this.Updated = Updated;
	}
	public String getCinemaId() {
		return CinemaId;
	}
	public void setCinemaId(String CinemaId) {
		this.CinemaId = CinemaId;
	}
	public String getQmmCinemaId() {
		return QmmCinemaId;
	}
	public void setQmmCinemaId(String qmmCinemaId) {
		QmmCinemaId = qmmCinemaId;
	}
	public Integer getIsUseLowestPriceReport() {
		return IsUseLowestPriceReport;
	}
	public void setIsUseLowestPriceReport(Integer isUseLowestPriceReport) {
		IsUseLowestPriceReport = isUseLowestPriceReport;
	}
	public Date getGoodsUpdated() {
		return GoodsUpdated;
	}
	public void setGoodsUpdated(Date goodsUpdated) {
		GoodsUpdated = goodsUpdated;
	}
	public Integer getIsGeneralStore() {
		return IsGeneralStore;
	}
	public void setIsGeneralStore(Integer isGeneralStore) {
		IsGeneralStore = isGeneralStore;
	}
	public Integer getOverRefundTime() {
		return OverRefundTime;
	}
	public void setOverRefundTime(Integer overRefundTime) {
		OverRefundTime = overRefundTime;
	}
	public Double getRefundFee() {
		return RefundFee;
	}
	public void setRefundFee(Double refundFee) {
		RefundFee = refundFee;
	}
	public String getSmsAccount() {
		return SmsAccount;
	}
	public void setSmsAccount(String smsAccount) {
		SmsAccount = smsAccount;
	}
	public String getSmsPwd() {
		return SmsPwd;
	}
	public void setSmsPwd(String smsPwd) {
		SmsPwd = smsPwd;
	}
	public String getSmsSignId() {
		return SmsSignId;
	}
	public void setSmsSignId(String smsSignId) {
		SmsSignId = smsSignId;
	}
	public String getBusinessPic() {
		return BusinessPic;
	}
	public void setBusinessPic(String businessPic) {
		BusinessPic = businessPic;
	}
	public String getBusinessName() {
		return BusinessName;
	}
	public void setBusinessName(String businessName) {
		BusinessName = businessName;
	}
	public String getBusinessDesc() {
		return BusinessDesc;
	}
	public void setBusinessDesc(String businessDesc) {
		BusinessDesc = businessDesc;
	}
	public int getBeforeStartTime() {
		return BeforeStartTime;
	}
	public void setBeforeStartTime(int beforeStartTime) {
		BeforeStartTime = beforeStartTime;
	}
	public String getCinemaAgreement() {
		return CinemaAgreement;
	}
	public void setCinemaAgreement(String cinemaAgreement) {
		CinemaAgreement = cinemaAgreement;
	}
}
