package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Qmmprice;

public interface QmmpriceService {

	Qmmprice getById(Long id);
	
	int update(Qmmprice qmmprice);
	
	int save(Qmmprice qmmprice);
	
	Qmmprice getByShowId(String showId);
	
    List<Qmmprice> getByCinemaCodeAndScreenName(String cinemacode,String screenname,String showtime);
    
    List<Qmmprice> selectDataType();

}
