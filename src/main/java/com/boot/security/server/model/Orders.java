package com.boot.security.server.model;

import java.util.Date;

public class Orders  extends BaseEntity<Long>{
	private Cinema Cinema;
	private UserCinema UserCinema;
	private Orderseatdetails Orderseatdetails;
	
	private Long Id;
	private String CinemaCode;
	private Long UserId;
	private String SessionCode;
	private String ScreenCode;
	private Date SessionTime;
	private String FilmCode;
	private String FilmName;
	private Integer TicketCount;
	private Double TotalPrice;
	private Double TotalFee;
	private Double TotalSalePrice;
	private Integer OrderStatus;
	private String MobilePhone;
	private Date LockTime;
	private Date AutoUnlockDatetime;
	private String LockOrderCode;
	private Date SubmitTime;
	private String SubmitOrderCode;
	private String PrintNo;
	private String VerifyCode;
	private Integer PrintStatus;
	private Date PrintTime;
	private Date RefundTime;
	private Date Created;
	private Date Updated;
	private Integer Deleted;
	private String ErrorMessage;
	private String SerialNum;
	private Integer IsMemberPay;
	private String PayType;
	private String Printpassword;
	private String PaySeqNo;
	private Double TotalLoveSeatDifferences;
	private Integer FeePayType;
	private Double TotalGuestPayFee;
	private Double TotalConponPrice;
	private String RefundTradeNo;
	private Integer PayFlag;
	private Integer OrderPayType;
	private Date PayTime;
	private String OrderTradeNo;
	private String CardNo;
	private String IDCardNumber;
	private String MarketingCode;
	private String OpenID;
	
	
	public Orderseatdetails getOrderseatdetails() {
		return Orderseatdetails;
	}
	public void setOrderseatdetails(Orderseatdetails orderseatdetails) {
		Orderseatdetails = orderseatdetails;
	}
	public Cinema getCinema() {
		return Cinema;
	}
	public void setCinema(Cinema cinema) {
		Cinema = cinema;
	}
	
	public UserCinema getUserCinema() {
		return UserCinema;
	}
	public void setUserCinema(UserCinema userCinema) {
		UserCinema = userCinema;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long UserId) {
		this.UserId = UserId;
	}
	public String getSessionCode() {
		return SessionCode;
	}
	public void setSessionCode(String SessionCode) {
		this.SessionCode = SessionCode;
	}
	public String getScreenCode() {
		return ScreenCode;
	}
	public void setScreenCode(String ScreenCode) {
		this.ScreenCode = ScreenCode;
	}
	public Date getSessionTime() {
		return SessionTime;
	}
	public void setSessionTime(Date SessionTime) {
		this.SessionTime = SessionTime;
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
	public Integer getTicketCount() {
		return TicketCount;
	}
	public void setTicketCount(Integer TicketCount) {
		this.TicketCount = TicketCount;
	}
	public Double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(Double TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
	public Double getTotalFee() {
		return TotalFee;
	}
	public void setTotalFee(Double TotalFee) {
		this.TotalFee = TotalFee;
	}
	public Double getTotalSalePrice() {
		return TotalSalePrice;
	}
	public void setTotalSalePrice(Double TotalSalePrice) {
		this.TotalSalePrice = TotalSalePrice;
	}
	public Integer getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(Integer OrderStatus) {
		this.OrderStatus = OrderStatus;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String MobilePhone) {
		this.MobilePhone = MobilePhone;
	}
	public Date getLockTime() {
		return LockTime;
	}
	public void setLockTime(Date LockTime) {
		this.LockTime = LockTime;
	}
	public Date getAutoUnlockDatetime() {
		return AutoUnlockDatetime;
	}
	public void setAutoUnlockDatetime(Date AutoUnlockDatetime) {
		this.AutoUnlockDatetime = AutoUnlockDatetime;
	}
	public String getLockOrderCode() {
		return LockOrderCode;
	}
	public void setLockOrderCode(String LockOrderCode) {
		this.LockOrderCode = LockOrderCode;
	}
	public Date getSubmitTime() {
		return SubmitTime;
	}
	public void setSubmitTime(Date SubmitTime) {
		this.SubmitTime = SubmitTime;
	}
	public String getSubmitOrderCode() {
		return SubmitOrderCode;
	}
	public void setSubmitOrderCode(String SubmitOrderCode) {
		this.SubmitOrderCode = SubmitOrderCode;
	}
	public String getPrintNo() {
		return PrintNo;
	}
	public void setPrintNo(String PrintNo) {
		this.PrintNo = PrintNo;
	}
	public String getVerifyCode() {
		return VerifyCode;
	}
	public void setVerifyCode(String VerifyCode) {
		this.VerifyCode = VerifyCode;
	}
	public Integer getPrintStatus() {
		return PrintStatus;
	}
	public void setPrintStatus(Integer PrintStatus) {
		this.PrintStatus = PrintStatus;
	}
	public Date getPrintTime() {
		return PrintTime;
	}
	public void setPrintTime(Date PrintTime) {
		this.PrintTime = PrintTime;
	}
	public Date getRefundTime() {
		return RefundTime;
	}
	public void setRefundTime(Date RefundTime) {
		this.RefundTime = RefundTime;
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
	public Integer getDeleted() {
		return Deleted;
	}
	public void setDeleted(Integer Deleted) {
		this.Deleted = Deleted;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String ErrorMessage) {
		this.ErrorMessage = ErrorMessage;
	}
	public String getSerialNum() {
		return SerialNum;
	}
	public void setSerialNum(String SerialNum) {
		this.SerialNum = SerialNum;
	}
	public Integer getIsMemberPay() {
		return IsMemberPay;
	}
	public void setIsMemberPay(Integer IsMemberPay) {
		this.IsMemberPay = IsMemberPay;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String PayType) {
		this.PayType = PayType;
	}
	public String getPrintpassword() {
		return Printpassword;
	}
	public void setPrintpassword(String Printpassword) {
		this.Printpassword = Printpassword;
	}
	public String getPaySeqNo() {
		return PaySeqNo;
	}
	public void setPaySeqNo(String PaySeqNo) {
		this.PaySeqNo = PaySeqNo;
	}
	public Double getTotalLoveSeatDifferences() {
		return TotalLoveSeatDifferences;
	}
	public void setTotalLoveSeatDifferences(Double totalLoveSeatDifferences) {
		TotalLoveSeatDifferences = totalLoveSeatDifferences;
	}
	public Integer getFeePayType() {
		return FeePayType;
	}
	public void setFeePayType(Integer feePayType) {
		FeePayType = feePayType;
	}
	public Double getTotalGuestPayFee() {
		return TotalGuestPayFee;
	}
	public void setTotalGuestPayFee(Double totalGuestPayFee) {
		TotalGuestPayFee = totalGuestPayFee;
	}
	public Double getTotalConponPrice() {
		return TotalConponPrice;
	}
	public void setTotalConponPrice(Double totalConponPrice) {
		TotalConponPrice = totalConponPrice;
	}
	public String getRefundTradeNo() {
		return RefundTradeNo;
	}
	public void setRefundTradeNo(String refundTradeNo) {
		RefundTradeNo = refundTradeNo;
	}
	public Integer getPayFlag() {
		return PayFlag;
	}
	public void setPayFlag(Integer payFlag) {
		PayFlag = payFlag;
	}
	public Integer getOrderPayType() {
		return OrderPayType;
	}
	public void setOrderPayType(Integer orderPayType) {
		OrderPayType = orderPayType;
	}
	public Date getPayTime() {
		return PayTime;
	}
	public void setPayTime(Date payTime) {
		PayTime = payTime;
	}
	public String getOrderTradeNo() {
		return OrderTradeNo;
	}
	public void setOrderTradeNo(String orderTradeNo) {
		OrderTradeNo = orderTradeNo;
	}
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}
	public String getIDCardNumber() {
		return IDCardNumber;
	}
	public void setIDCardNumber(String IDCardNumber) {
		this.IDCardNumber = IDCardNumber;
	}
	public String getMarketingCode() {
		return MarketingCode;
	}
	public void setMarketingCode(String marketingCode) {
		MarketingCode = marketingCode;
	}
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String openID) {
		OpenID = openID;
	}
	

}
