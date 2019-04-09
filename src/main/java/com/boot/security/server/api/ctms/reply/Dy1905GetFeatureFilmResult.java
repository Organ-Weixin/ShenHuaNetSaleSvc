package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class Dy1905GetFeatureFilmResult {
	private ResBean GetFeatureFilmResult;

	public ResBean getGetFeatureFilmResult() {
		return GetFeatureFilmResult;
	}

	public void setGetFeatureFilmResult(ResBean getFeatureFilmResult) {
		GetFeatureFilmResult = getFeatureFilmResult;
	}
	
	public static class ResBean{
		private String ResultCode;
		private FilmsBean Films;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public FilmsBean getFilms() {
			return Films;
		}
		public void setFilms(FilmsBean films) {
			Films = films;
		}
		public static class FilmsBean{
			private List<FilmBean> Film;
			
			public List<FilmBean> getFilm() {
				return Film;
			}
			public void setFilm(List<FilmBean> film) {
				Film = film;
			}

			public static class FilmBean{
				private String FilmNo;
				private String FilmName;
				private String FilmType;
				private String FilmTypeDesc;
				private String FilmCode;
				private String Language;
				private String LanguageDesc;
				public String getFilmNo() {
					return FilmNo;
				}
				public void setFilmNo(String filmNo) {
					FilmNo = filmNo;
				}
				public String getFilmName() {
					return FilmName;
				}
				public void setFilmName(String filmName) {
					FilmName = filmName;
				}
				public String getFilmType() {
					return FilmType;
				}
				public void setFilmType(String filmType) {
					FilmType = filmType;
				}
				public String getFilmTypeDesc() {
					return FilmTypeDesc;
				}
				public void setFilmTypeDesc(String filmTypeDesc) {
					FilmTypeDesc = filmTypeDesc;
				}
				public String getFilmCode() {
					return FilmCode;
				}
				public void setFilmCode(String filmCode) {
					FilmCode = filmCode;
				}
				public String getLanguage() {
					return Language;
				}
				public void setLanguage(String language) {
					Language = language;
				}
				public String getLanguageDesc() {
					return LanguageDesc;
				}
				public void setLanguageDesc(String languageDesc) {
					LanguageDesc = languageDesc;
				}
				
			}
		}
	} 
}
