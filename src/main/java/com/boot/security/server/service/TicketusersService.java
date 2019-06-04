package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Ticketusers;

public interface TicketusersService {

	int update(Ticketusers ticketusers);
	
	int save(Ticketusers ticketusers);
	
	
    Ticketusers getByCinemaCode(String cinemacode);
    
    Ticketusers getByopenids(String openid);
    
    List<Ticketusers> getAllList();
    
    int updateIsActive(Integer isactive, String openid);
}
