package com.boot.security.server.api.core;

import java.util.List;

public class QueryFilmReply extends BaseReply {
	public QueryFilmReply()
    {
        Id = ID_QueryFilmReply;
    }
	public QueryFilmReplyFilms Films;
	public QueryFilmReplyFilms getFilms() {
		return Films;
	}
	public void setFilms(QueryFilmReplyFilms films) {
		Films = films;
	}
	public class QueryFilmReplyFilms{
		public int Count;
		public List<QueryFilmReplyFilm> Film;
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		public List<QueryFilmReplyFilm> getFilm() {
			return Film;
		}
		public void setFilm(List<QueryFilmReplyFilm> film) {
			Film = film;
		}
		public class QueryFilmReplyFilm{
			public String Code;
			public String Name;
			public String Version;
			public String Duration;
			public String PublishDate;
			public String Publisher;
			public String Producer;
			public String Director;
			public String Cast;
			public String Introduction;
			public String getCode() {
				return Code;
			}
			public void setCode(String code) {
				Code = code;
			}
			public String getName() {
				return Name;
			}
			public void setName(String name) {
				Name = name;
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
			
		}
		
	}
	

}
