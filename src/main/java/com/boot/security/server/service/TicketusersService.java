package com.boot.security.server.service;

import com.boot.security.server.model.Ticketusers;

public interface TicketusersService {

	int update(Ticketusers ticketusers);
	
	int save(Ticketusers ticketusers);
	
	Ticketusers getByOpenIdAndCode(String openid,String cinemacode);
	
    Ticketusers getByCinemaCode(String cinemacode);
    
    Ticketusers getByopenids(String openid);



}
