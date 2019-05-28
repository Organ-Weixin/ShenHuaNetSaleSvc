package com.boot.security.server.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.boot.security.server.model.Sessioninfo;

public interface SessioninfoService {
	
	Sessioninfo getBySessionCode(Long userid,String cinemacode,String sessioncode);
	List<Sessioninfo> getByCinemaCodeAndDate(Long userid,String cinemacode,Date StartDate,Date EndDate);
	int deleteByCinemaCodeAndDate(Long userid,String cinemacode,Date StartDate,Date EndDate);
	
	int save(Sessioninfo sessioninfo);
	
	List<Sessioninfo> getByCCode(String ccode,Date StartTime);
	
	Sessioninfo getByCinemaCodeAndSessionCodeAndUserId(String cinemacode,String sessioncode,Long userid);
	
	int delete(Long id);
	
	int deleteByCinemaCode(Map<String, Object> params);
	
	List<Sessioninfo> getFilms(Map<String, Object> params);
	
	List<Sessioninfo> getByCCodeGroupByFilm(Long userid,String cinemacode,Date StartDate,Date EndDate);
	
	List<Sessioninfo> getFilmsByCinemaCode(String cinemacodes);
	
	List<Sessioninfo> getByCinemaStartDateEndDate(String cinemacode,String StartDate,String EndDate);

	Sessioninfo getSessionCode(String cinemacode,String sessioncode);

	List<Sessioninfo> getByCinemafilm(String cinemacode,String filmcode);
	
	List<Sessioninfo> getByFilmName(String cinemacode,String startDate,String endDate);
	
	List<Sessioninfo> getByCinemaCodeAndFilmCode(String cinemacode,String filmcode);
	
	List<Sessioninfo> getByCinemaCodeAndFilmCodeAndTime(String cinemacode,String filmcode,String startdate,String enddate);
	
	List<Sessioninfo> getSessionDate(String cinemacode,String filmcode,String startdate,String enddate);
	
	List<Sessioninfo> getOneDaySession(String cinemacode,String filmcode,String sessiondate);

}
