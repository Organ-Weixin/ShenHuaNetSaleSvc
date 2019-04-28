package com.boot.security.server.model;



public class Goodstype extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private Integer UserId;
	private String TypeName;
	private String TypeDesc;
	private String TypePic;

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
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer UserId) {
		this.UserId = UserId;
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

}
