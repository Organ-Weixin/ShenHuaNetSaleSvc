package com.boot.security.server.model;



public class Cinemamessage extends BaseEntity<Long> {

	private Long Id;
	private String CinemaCode;
	private String MessageType;
	private String MessageContent;

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
	public String getMessageType() {
		return MessageType;
	}
	public void setMessageType(String MessageType) {
		this.MessageType = MessageType;
	}
	public String getMessageContent() {
		return MessageContent;
	}
	public void setMessageContent(String MessageContent) {
		this.MessageContent = MessageContent;
	}

}
