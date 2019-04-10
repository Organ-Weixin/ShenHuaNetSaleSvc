package com.boot.security.server.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.boot.security.server.model.Sessioninfo;

public interface SessioninfoService {
	
	Sessioninfo getBySessionCode(Long userid,String cinemacode,String sessioncode);
	List<Sessioninfo> getByCinemaCodeAndDate(Long userid,String cinemacode,Date StartDate,Date EndDate);
	int deleteByCinemaCodeAndDate(Long userid,String cinemacode,Date StartDate,Date EndDate);
	int save(Sessioninfo sessioninfo);
	
	List<Sessioninfo> getByCCode(String ccode,Date StartTime);
	
	Sessioninfo getByCinemaCodeAndSessionCodeAndUserId(String cinemacode,String sessioncode,Long userid);
	
	int delete(String ccode,Date StartTime);
	
	List<Sessioninfo> getFilms(String CCode,Date StartTime,Date EndTime);
	
	List<Sessioninfo> getByCCodeGroupByFilm(Long userid,String cinemacode,Date StartDate,Date EndDate);
}
