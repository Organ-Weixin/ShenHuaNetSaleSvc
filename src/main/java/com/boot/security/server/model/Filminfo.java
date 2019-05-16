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
	public Double Score;
	public String Area;
	public String Type;
	public String Language;
	public int Status;
	public String Image;
	public String Trailer;

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
	public String getFilmName() {
		return FilmName;
	}
	public void setFilmName(String FilmName) {
		this.FilmName = FilmName;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String Version) {
		this.Version = Version;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String Duration) {
		this.Duration = Duration;
	}
	public Date getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(Date PublishDate) {
		this.PublishDate = PublishDate;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}
	public String getProducer() {
		return Producer;
	}
	public void setProducer(String Producer) {
		this.Producer = Producer;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String Director) {
		this.Director = Director;
	}
	public String getCast() {
		return Cast;
	}
	public void setCast(String Cast) {
		this.Cast = Cast;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String Introduction) {
		this.Introduction = Introduction;
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
	

}
