package com.boot.security.server.model;



public class Cinema extends BaseEntity<Long>{

	private Long Id;
	private Integer MId;
	private String Code;
	private String Name;
	private String Address;
	private Integer ScreenCount;
	private Integer IsDel;
	private Integer ManualAdd;
	private Integer IsOpen;
	private String CinemaId;

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
	public Integer getIsDel() {
		return IsDel;
	}
	public void setIsDel(Integer IsDel) {
		this.IsDel = IsDel;
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
	public String getCinemaId() {
		return CinemaId;
	}
	public void setCinemaId(String CinemaId) {
		this.CinemaId = CinemaId;
	}

}
