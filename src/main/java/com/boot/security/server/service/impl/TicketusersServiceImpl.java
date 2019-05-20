package com.boot.security.server.service.impl;

import java.util.List;

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
	public Ticketusers getByCinemaCode(String cinemacode) {
		return ticketusersDao.getByCinemaCode(cinemacode);
	}

	@Override
	public Ticketusers getByopenids(String openid) {
		return ticketusersDao.getByopenids(openid);
	}

}
