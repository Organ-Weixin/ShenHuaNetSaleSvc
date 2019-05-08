package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.TicketusersDao;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.service.TicketusersService;

@Service
public class TicketusersServiceImpl implements TicketusersService{

	@Autowired
	private TicketusersDao ticketusersDao;
	
	@Override
	public int update(Ticketusers ticketusers) {
		return ticketusersDao.update(ticketusers);
	}

	@Override
	public int save(Ticketusers ticketusers) {
		return ticketusersDao.save(ticketusers);
	}

	@Override
	public Ticketusers getByOpenIdAndCode(String openid, String cinemacode) {
		return ticketusersDao.getByOpenId(openid, cinemacode);
	}

}
