package com.boot.security.server.model;

import java.util.Date;

public class Filminfo extends BaseEntity<Long> {

	private Long Id;
	private String FilmCode;
	private String FilmName;
	private String Version;
	private String Duration;
	private Date PublishDate;
	private String Publisher;
	private String Producer;
	private String Director;
	private String Cast;
	private String Introduction;
	private Double Score;
	private String Area;
	private String Type;
	private String Language;
	private int Status;
	private String Image;
	private String Trailer;
	private String StagePhoto1;
	private String StagePhoto2;
	private String StagePhoto3;
	private String StagePhoto4;
	private String StagePhoto5;
	private String StagePhoto6;

	private String DirectorId;
	private String CastId;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFilmCode() {
		return FilmCode;
	}
	public void setFilmCode(String filmCode) {
		FilmCode = filmCode;
	}
	public String getFilmName() {
		return FilmName;
	}
	public void setFilmName(String filmName) {
		FilmName = filmName;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public Date getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getProducer() {
		return Producer;
	}
	public void setProducer(String producer) {
		Producer = producer;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getCast() {
		return Cast;
	}
	public void setCast(String cast) {
		Cast = cast;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public Double getScore() {
		return Score;
	}
	public void setScore(Double score) {
		Score = score;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getTrailer() {
		return Trailer;
	}
	public void setTrailer(String trailer) {
		Trailer = trailer;
	}
	public String getStagePhoto1() {
		return StagePhoto1;
	}
	public void setStagePhoto1(String stagePhoto1) {
		StagePhoto1 = stagePhoto1;
	}
	public String getStagePhoto2() {
		return StagePhoto2;
	}
	public void setStagePhoto2(String stagePhoto2) {
		StagePhoto2 = stagePhoto2;
	}
	public String getStagePhoto3() {
		return StagePhoto3;
	}
	public void setStagePhoto3(String stagePhoto3) {
		StagePhoto3 = stagePhoto3;
	}
	public String getStagePhoto4() {
		return StagePhoto4;
	}
	public void setStagePhoto4(String stagePhoto4) {
		StagePhoto4 = stagePhoto4;
	}
	public String getStagePhoto5() {
		return StagePhoto5;
	}
	public void setStagePhoto5(String stagePhoto5) {
		StagePhoto5 = stagePhoto5;
	}
	public String getStagePhoto6() {
		return StagePhoto6;
	}
	public void setStagePhoto6(String stagePhoto6) {
		StagePhoto6 = stagePhoto6;
	}
	public String getDirectorId() {
		return DirectorId;
	}
	public void setDirectorId(String directorId) {
		DirectorId = directorId;
	}
	public String getCastId() {
		return CastId;
	}
	public void setCastId(String castId) {
		CastId = castId;
	}
	
}
