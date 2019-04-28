package com.boot.security.server.apicontroller.reply;

public class QueryFilmReply extends BaseReply {
	private QueryFilmReplyFilm data;

	public QueryFilmReplyFilm getData() {
		return data;
	}

	public void setData(QueryFilmReplyFilm data) {
		this.data = data;
	}
	public static class QueryFilmReplyFilm{
		private Long FilmId;
		private String FilmCode;
		private String FilmName;
		private String Version;
		private String Duration;
		private String PublishDate;
		private String Publisher;
		private String Producer;
		private String Director;
		private String Cast;
		private String Introduction;
		private Double Score;
		private String Area;
		private String Type;
		private String Language;
		private String Status;
		private String Image;
		private String Trailer;
		public Long getFilmId() {
			return FilmId;
		}
		public void setFilmId(Long filmId) {
			FilmId = filmId;
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
		public String getPublishDate() {
			return PublishDate;
		}
		public void setPublishDate(String publishDate) {
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
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
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

}
