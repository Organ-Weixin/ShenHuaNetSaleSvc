package com.boot.security.server.model;

import java.util.List;

public class BaiduFilmInfomation {
	private int error;
	private String status;
	private String date;
	private Result result;
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public static class Result{
		private int cityid;
		private String cityname;
		private Location location;
		private List<Movie> movie;
		public int getCityid() {
			return cityid;
		}
		public void setCityid(int cityid) {
			this.cityid = cityid;
		}
		public String getCityname() {
			return cityname;
		}
		public void setCityname(String cityname) {
			this.cityname = cityname;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public List<Movie> getMovie() {
			return movie;
		}
		public void setMovie(List<Movie> movie) {
			this.movie = movie;
		}
		public static class Location{
			private Double lng; 
			private Double lat;
			public Double getLng() {
				return lng;
			}
			public void setLng(Double lng) {
				this.lng = lng;
			}
			public Double getLat() {
				return lat;
			}
			public void setLat(Double lat) {
				this.lat = lat;
			}
			
		}
		public static class Movie{
			private String movie_id;
			private String movie_name;
			private String movie_type;
			private String movie_release_date;
			private String movie_nation;
			private String movie_starring;
			private String movie_length;
			private String movie_picture;
			private String movie_score;
			private String movie_director;
			private String movie_tags;
			private String movie_message;
			private int is_imax;
			private String is_new;
			private String movie_big_picture;
			private String movies_wd;
			public String getMovie_id() {
				return movie_id;
			}
			public void setMovie_id(String movie_id) {
				this.movie_id = movie_id;
			}
			public String getMovie_name() {
				return movie_name;
			}
			public void setMovie_name(String movie_name) {
				this.movie_name = movie_name;
			}
			public String getMovie_type() {
				return movie_type;
			}
			public void setMovie_type(String movie_type) {
				this.movie_type = movie_type;
			}
			public String getMovie_release_date() {
				return movie_release_date;
			}
			public void setMovie_release_date(String movie_release_date) {
				this.movie_release_date = movie_release_date;
			}
			public String getMovie_nation() {
				return movie_nation;
			}
			public void setMovie_nation(String movie_nation) {
				this.movie_nation = movie_nation;
			}
			public String getMovie_starring() {
				return movie_starring;
			}
			public void setMovie_starring(String movie_starring) {
				this.movie_starring = movie_starring;
			}
			public String getMovie_length() {
				return movie_length;
			}
			public void setMovie_length(String movie_length) {
				this.movie_length = movie_length;
			}
			public String getMovie_picture() {
				return movie_picture;
			}
			public void setMovie_picture(String movie_picture) {
				this.movie_picture = movie_picture;
			}
			public String getMovie_score() {
				return movie_score;
			}
			public void setMovie_score(String movie_score) {
				this.movie_score = movie_score;
			}
			public String getMovie_director() {
				return movie_director;
			}
			public void setMovie_director(String movie_director) {
				this.movie_director = movie_director;
			}
			public String getMovie_tags() {
				return movie_tags;
			}
			public void setMovie_tags(String movie_tags) {
				this.movie_tags = movie_tags;
			}
			public String getMovie_message() {
				return movie_message;
			}
			public void setMovie_message(String movie_message) {
				this.movie_message = movie_message;
			}
			public int getIs_imax() {
				return is_imax;
			}
			public void setIs_imax(int is_imax) {
				this.is_imax = is_imax;
			}
			public String getIs_new() {
				return is_new;
			}
			public void setIs_new(String is_new) {
				this.is_new = is_new;
			}
			public String getMovie_big_picture() {
				return movie_big_picture;
			}
			public void setMovie_big_picture(String movie_big_picture) {
				this.movie_big_picture = movie_big_picture;
			}
			public String getMovies_wd() {
				return movies_wd;
			}
			public void setMovies_wd(String movies_wd) {
				this.movies_wd = movies_wd;
			}
			
		}
	}

}
