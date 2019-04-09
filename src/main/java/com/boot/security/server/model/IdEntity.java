package com.boot.security.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * 
 * @author 黄灿钦
 * 
 */
@MappedSuperclass
public abstract class IdEntity implements Serializable {
	private static final long serialVersionUID = 4049199324190640999L;
	protected Long id;
	private Integer version = 0;//乐观锁
	private Boolean valid=true;//逻辑删除
	private Date createTime=new Date();
	private Date modifyTime=null;
	private Date deleteTime=null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//如果是mysql或sqlserver，选择identity，如果是oracle，选择sequence。
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Boolean isValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
}

