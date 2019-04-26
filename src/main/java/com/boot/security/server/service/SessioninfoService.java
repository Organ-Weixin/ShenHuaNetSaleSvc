package com.boot.security.server.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	
	List<Sessioninfo> getFilmsByCinemaCode(String cinemacode);
	
	   List<Sessioninfo> getByCinemaStartDateEndDate(String cinemacode,String StartDate,String EndDate);

	   Sessioninfo getSessionCode(String cinemacode,String sessioncode);


}
