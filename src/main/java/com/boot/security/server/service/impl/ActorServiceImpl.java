package com.boot.security.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ActorDao;
import com.boot.security.server.model.Actor;
import com.boot.security.server.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorDao actordao;
	
	@Override
	public Actor getById(Long id) {
		return actordao.getById(id);
	}

	@Override
	public Actor getByName(String name) {
		return actordao.getByName(name);
	}

	@Override
	public int save(Actor actor) {
		return actordao.save(actor);
	}

}
