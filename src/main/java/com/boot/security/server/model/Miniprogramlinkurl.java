package com.boot.security.server.model;

public class Miniprogramlinkurl extends BaseEntity<Long> {

	private Long Id;
	private String LinkName;
	private String LinkUrl;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getLinkName() {
		return LinkName;
	}
	public void setLinkName(String LinkName) {
		this.LinkName = LinkName;
	}
	public String getLinkUrl() {
		return LinkUrl;
	}
	public void setLinkUrl(String LinkUrl) {
		this.LinkUrl = LinkUrl;
	}

}
