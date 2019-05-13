package com.boot.security.server.model;

public class Cinemaview extends BaseEntity<Long> {

	private Long Id;
	private Integer MId;
	private String Code;
	private String Name;
	private String Address;
	private Integer ScreenCount;
	private Integer ManualAdd;
	private String CinemaId;
	private Integer CinemaOpen;
	private Integer IsOpenSnacks;
	private Integer CinemaType;


	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getCinemaId() {
		return CinemaId;
	}
	public void setCinemaId(String CinemaId) {
		this.CinemaId = CinemaId;
	}
	public Integer getCinemaOpen() {
		return CinemaOpen;
	}
	public void setCinemaOpen(Integer CinemaOpen) {
		this.CinemaOpen = CinemaOpen;
	}
	public Integer getIsOpenSnacks() {
		return IsOpenSnacks;
	}
	public void setIsOpenSnacks(Integer IsOpenSnacks) {
		this.IsOpenSnacks = IsOpenSnacks;
	}
	public Integer getCinemaType() {
		return CinemaType;
	}
	public void setCinemaType(Integer CinemaType) {
		this.CinemaType = CinemaType;
	}

}
