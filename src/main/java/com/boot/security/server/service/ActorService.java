package com.boot.security.server.service;

import com.boot.security.server.model.Actor;

public interface ActorService {

	Actor getById(Long id);
	Actor getByName(String name);
	
	int save(Actor actor);
}
