package com.boot.security.server.service;

import java.util.Date;
import java.util.List;

import com.boot.security.server.model.Sessioninfo;

public interface SessioninfoService {
	Sessioninfo getBySessionCode(Long userid,String cinemacode,String sessioncode);
	List<Sessioninfo> getByCinemaCodeAndDate(Long userid,String cinemacode,Date StartDate,Date EndDate);
	int deleteByCinemaCodeAndDate(Long userid,String cinemacode,Date StartDate,Date EndDate);
	int save(Sessioninfo session);

}
