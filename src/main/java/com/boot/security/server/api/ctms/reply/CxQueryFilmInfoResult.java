package com.boot.security.server.api.ctms.reply;

import java.util.List;

import com.boot.security.server.api.ctms.reply.CxQuerySeatInfoResult.ResBean;

/**
 * 影片信息
 */
public class CxQueryFilmInfoResult {
	private ResBean QueryFilmInfoResult;

	public ResBean getQueryFilmInfoResult() {
		return QueryFilmInfoResult;
	}

	public void setQueryFilmInfoResult(ResBean queryFilmInfoResult) {
		QueryFilmInfoResult = queryFilmInfoResult;
	}
	public static class ResBean {
		private	String  ResultCode;//	返回结果号，详细见附录A
        private	String  Message;//	返回信息，详细见附录A
        private FilmInfoVOsBean FilmInfoVOs;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public FilmInfoVOsBean getFilmInfoVOs() {
			return FilmInfoVOs;
		}
		public void setFilmInfoVOs(FilmInfoVOsBean filmInfoVOs) {
			FilmInfoVOs = filmInfoVOs;
		}
        public static class FilmInfoVOsBean{
        	private List<FilmInfoVOBean> FilmInfoVO;

			public List<FilmInfoVOBean> getFilmInfoVO() {
				return FilmInfoVO;
			}

			public void setFilmInfoVO(List<FilmInfoVOBean> filmInfoVO) {
				FilmInfoVO = filmInfoVO;
			}
        	public static class FilmInfoVOBean{
        		private String FilmCode;
        		private String FilmName;
        		private String Version;
        		private Integer Duration;
        		private String PublishDate;
        		private String Publisher;
        		private String Producer;
        		private String Director;
        		private String Cast;
        		private String Introduction;
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
				public Integer getDuration() {
					return Duration;
				}
				public void setDuration(Integer duration) {
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

}
