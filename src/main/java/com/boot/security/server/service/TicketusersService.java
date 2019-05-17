package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.boot.security.server.model.Ticketusers;

public interface TicketusersService {

	int update(Ticketusers ticketusers);
	
	int save(Ticketusers ticketusers);
	
	Ticketusers getByOpenIdAndCode(String openid,String cinemacode);
	
    Ticketusers getByCinemaCode(String cinemacode);
    
    Ticketusers getByopenids(String openid);

}
