package com.boot.security.server.model;

import java.util.Date;

public class Sessioninfoview extends BaseEntity<Long> {

	private Long Id;
	private String SCode;
	private String CCode;
	private String ScreenCode;
	private String Name;
	private String Company;
	private String FilmCode;
	private String FilmName;
	private String SName;
	private Date StartTime;
	private Integer Duration;
	private String Language;
	private Double StandardPrice;
	private Double LowestPrice;
	private Double Price;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getSCode() {
		return SCode;
	}
	public void setSCode(String SCode) {
		this.SCode = SCode;
	}
	public String getCCode() {
		return CCode;
	}
	public void setCCode(String CCode) {
		this.CCode = CCode;
	}
	public String getScreenCode() {
		return ScreenCode;
	}
	public void setScreenCode(String ScreenCode) {
		this.ScreenCode = ScreenCode;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String Company) {
		this.Company = Company;
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
	public String getSName() {
		return SName;
	}
	public void setSName(String SName) {
		this.SName = SName;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date StartTime) {
		this.StartTime = StartTime;
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
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double Price) {
		this.Price = Price;
	}

}
