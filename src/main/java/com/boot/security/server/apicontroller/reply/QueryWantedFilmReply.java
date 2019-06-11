package com.boot.security.server.apicontroller.reply;

import java.util.List;

public class QueryWantedFilmReply extends BaseReply{
	private QueryWantedFilmReplyWantedFilm data;

	public QueryWantedFilmReplyWantedFilm getData() {
		return data;
	}

	public void setData(QueryWantedFilmReplyWantedFilm data) {
		this.data = data;
	}
	public static class QueryWantedFilmReplyWantedFilm{
		private Integer Count;
		private List<QueryWantedFilmReplyFilm> Film;

		public Integer getCount() {
			return Count;
		}
		public void setCount(Integer count) {
			Count = count;
		}
		
		public List<QueryWantedFilmReplyFilm> getFilm() {
			return Film;
		}

		public void setFilm(List<QueryWantedFilmReplyFilm> film) {
			Film = film;
		}
		public static class QueryWantedFilmReplyFilm{
			private String FilmImage;
			private String FilmName;
			private String Cast;
			private String PublishDate;
			private String Area;
			public String getFilmImage() {
				return FilmImage;
			}
			public void setFilmImage(String filmImage) {
				FilmImage = filmImage;
			}
			public String getFilmName() {
				return FilmName;
			}
			public void setFilmName(String filmName) {
				FilmName = filmName;
			}
			public String getCast() {
				return Cast;
			}
			public void setCast(String cast) {
				Cast = cast;
			}
			public String getPublishDate() {
				return PublishDate;
			}
			public void setPublishDate(String publishDate) {
				PublishDate = publishDate;
			}
			public String getArea() {
				return Area;
			}
			public void setArea(String area) {
				Area = area;
			}
		}
	}
}
