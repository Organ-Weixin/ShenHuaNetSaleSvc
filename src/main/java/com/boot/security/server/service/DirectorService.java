package com.boot.security.server.service;

import com.boot.security.server.model.Director;

public interface DirectorService {

	Director getById(Long id);
	Director getByName(String name);
	
	int save(Director director);
}
