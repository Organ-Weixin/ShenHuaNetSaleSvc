package com.boot.security.server.model;

import java.util.Date;

public class Systemusers extends BaseEntity<Long> {

	private Long Id;
	private String UserName;
	private String Password;
	private String CinemaCode;
	private String CinemaName;
	private String RealName;
	private Integer RoleId;
	private String RoleName;
	private Integer CreateUserId;
	private Date Created;
	private Integer UpdateUserId;
	private Date Updated;
	private Integer Deleted;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getCinemaCode() {
		return CinemaCode;
	}
	public void setCinemaCode(String CinemaCode) {
		this.CinemaCode = CinemaCode;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String CinemaName) {
		this.CinemaName = CinemaName;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String RealName) {
		this.RealName = RealName;
	}
	public Integer getRoleId() {
		return RoleId;
	}
	public void setRoleId(Integer RoleId) {
		this.RoleId = RoleId;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String RoleName) {
		this.RoleName = RoleName;
	}
	public Integer getCreateUserId() {
		return CreateUserId;
	}
	public void setCreateUserId(Integer CreateUserId) {
		this.CreateUserId = CreateUserId;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date Created) {
		this.Created = Created;
	}
	public Integer getUpdateUserId() {
		return UpdateUserId;
	}
	public void setUpdateUserId(Integer UpdateUserId) {
		this.UpdateUserId = UpdateUserId;
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

}
