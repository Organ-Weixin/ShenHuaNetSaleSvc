package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Screenseatinfo;

public interface ScreenseatinfoService {
	List<Screenseatinfo> getBySeatCodes(String cinemacode,String screencode,String seatcodes);
	List<Screenseatinfo> getByCinemaCodeAndScreenCode(String cinemacode,String screencode);
	int deleteByCinemaCodeAndScreenCode(String cinemacode,String screencode);
	int save(Screenseatinfo seat);

}
