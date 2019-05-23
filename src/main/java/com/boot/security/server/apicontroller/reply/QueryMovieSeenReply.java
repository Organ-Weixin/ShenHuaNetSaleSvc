package com.boot.security.server.apicontroller.reply;

import java.util.Date;
import java.util.List;

public class QueryMovieSeenReply extends BaseReply{
	//用户看过的电影
	private QueryMovieSeenReplySeen data;
	public QueryMovieSeenReplySeen getData() {
		return data;
	}
	public void setData(QueryMovieSeenReplySeen data) {
		this.data = data;
	}
	public class QueryMovieSeenReplySeen{
		private int Count;
		private List<QueryMovieSeen> Seen;
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		public List<QueryMovieSeen> getSeen() {
			return Seen;
		}
		public void setSeen(List<QueryMovieSeen> seen) {
			Seen = seen;
		}
		public class QueryMovieSeen{
			private String FilmName;//影片名称
			private String  Cast;//主演
			private String Image;//电影海报
			private Date  PublishDate;//上映时间
			private String Area;//上映区域
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
			public String getImage() {
				return Image;
			}
			public void setImage(String image) {
				Image = image;
			}
			public Date getPublishDate() {
				return PublishDate;
			}
			public void setPublishDate(Date publishDate) {
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
