package com.boot.security.server.model;

import java.util.Date;

public class Orderseatdetails extends BaseEntity<Long>{

	private Long Id;
	private Long OrderId;
	private String SeatCode;
	private String RowNum;
	private String ColumnNum;
	private Integer XCoord;
	private Integer YCoord;
	private Double Price;
	private Double SalePrice;
	private Double Fee;
	private String FilmTicketCode;
	private String TicketInfoCode;
	private Integer PrintFlag;
	private String SeatId;
	private Date Created;
	private Date Updated;
	private Integer Deleted;
	//后台管理添加一下四个字段，数据库添加PreferentialPrice、AddedPrice两个字段
	private Double CinemaAllowance;//影院补贴
	private Double AddFee;//增值服务费
	private String Seat;
	private Double TotalSale;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public Long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long OrderId) {
		this.OrderId = OrderId;
	}
	public String getSeatCode() {
		return SeatCode;
	}
	public void setSeatCode(String SeatCode) {
		this.SeatCode = SeatCode;
	}
	public String getRowNum() {
		return RowNum;
	}
	public void setRowNum(String RowNum) {
		this.RowNum = RowNum;
	}
	public String getColumnNum() {
		return ColumnNum;
	}
	public void setColumnNum(String ColumnNum) {
		this.ColumnNum = ColumnNum;
	}
	public Integer getXCoord() {
		return XCoord;
	}
	public void setXCoord(Integer XCoord) {
		this.XCoord = XCoord;
	}
	public Integer getYCoord() {
		return YCoord;
	}
	public void setYCoord(Integer YCoord) {
		this.YCoord = YCoord;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double Price) {
		this.Price = Price;
	}
	public Double getSalePrice() {
		return SalePrice;
	}
	public void setSalePrice(Double SalePrice) {
		this.SalePrice = SalePrice;
	}
	public Double getFee() {
		return Fee;
	}
	public void setFee(Double Fee) {
		this.Fee = Fee;
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
	public String getFilmTicketCode() {
		return FilmTicketCode;
	}
	public void setFilmTicketCode(String FilmTicketCode) {
		this.FilmTicketCode = FilmTicketCode;
	}
	public String getTicketInfoCode() {
		return TicketInfoCode;
	}
	public void setTicketInfoCode(String TicketInfoCode) {
		this.TicketInfoCode = TicketInfoCode;
	}
	public Integer getPrintFlag() {
		return PrintFlag;
	}
	public void setPrintFlag(Integer PrintFlag) {
		this.PrintFlag = PrintFlag;
	}
	public String getSeatId() {
		return SeatId;
	}
	public void setSeatId(String SeatId) {
		this.SeatId = SeatId;
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
	public String getSeat() {
		return Seat;
	}
	public void setSeat(String seat) {
		Seat = seat;
	}
	public Double getTotalSale() {
		return TotalSale;
	}
	public void setTotalSale(Double totalSale) {
		TotalSale = totalSale;
	}
	
}
