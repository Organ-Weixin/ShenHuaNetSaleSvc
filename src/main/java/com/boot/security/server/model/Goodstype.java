package com.boot.security.server.model;



public class Goodstype {

	private Long Id;
	private String CinemaCode;
	private Long UserId;
	private String TypeCode;
	private String TypeName;
	private String TypeDesc;
	private String TypePic;
	
	private String cinemaName; //后台需要

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
	
	public String getTypeCode() {
		return TypeCode;
	}
	public void setTypeCode(String typeCode) {
		TypeCode = typeCode;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String TypeName) {
		this.TypeName = TypeName;
	}
	public String getTypeDesc() {
		return TypeDesc;
	}
	public void setTypeDesc(String TypeDesc) {
		this.TypeDesc = TypeDesc;
	}
	public String getTypePic() {
		return TypePic;
	}
	public void setTypePic(String TypePic) {
		this.TypePic = TypePic;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	
}
