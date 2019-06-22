package com.boot.security.server.model;



public class Actorconfiguration extends BaseEntity<Long> {

	private Long Id;
	private String FilmCode;
	private Integer ActorId;
	private String Type;

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getFilmCode() {
		return FilmCode;
	}
	public void setFilmCode(String FilmCode) {
		this.FilmCode = FilmCode;
	}
	public Integer getActorId() {
		return ActorId;
	}
	public void setActorId(Integer ActorId) {
		this.ActorId = ActorId;
	}
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}

}
