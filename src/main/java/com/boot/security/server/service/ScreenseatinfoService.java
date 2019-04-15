package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Screenseatinfo;

public interface ScreenseatinfoService {
	
	List<Screenseatinfo> queryLoveSeats(String cinemaCode,String screenCode);
	
	int deleteByScreenCode(String cinemaCode,String screenCode);
	Screenseatinfo getBySeatCode(String cinemacode,String screencode,String seatcode);
	List<Screenseatinfo> getBySeatCodes(String cinemacode,String screencode,String seatcodes);
	List<Screenseatinfo> getGroupByGroupCode(String cinemacode,String screencode);
	List<Screenseatinfo> getByCinemaCodeAndScreenCode(String cinemacode,String screencode);
	int deleteByCinemaCodeAndScreenCode(String cinemacode,String screencode);
	int save(Screenseatinfo screenseatinfo);
}
