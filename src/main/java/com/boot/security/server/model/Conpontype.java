package com.boot.security.server.model;

import java.util.Date;

public class Conpontype extends BaseEntity<Long> {

	private Long Id;
	private String TypeCode;
	private String TypeName;
	private Integer TypeParentId;
	private String Remark;
	private Integer IsDel;
	private Date Created;
	private Date Updated;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getTypeCode() {
		return TypeCode;
	}
	public void setTypeCode(String TypeCode) {
		this.TypeCode = TypeCode;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String TypeName) {
		this.TypeName = TypeName;
	}
	public Integer getTypeParentId() {
		return TypeParentId;
	}
	public void setTypeParentId(Integer TypeParentId) {
		this.TypeParentId = TypeParentId;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
	public Integer getIsDel() {
		return IsDel;
	}
	public void setIsDel(Integer IsDel) {
		this.IsDel = IsDel;
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

}
