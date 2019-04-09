package com.boot.security.server.service;

import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Permission;

public interface CinemaService {
	
	Cinema getByCinemaCode(String cinemacode);
	
	int save(Cinema cinema);

	int update(Cinema Cinema);

	int delete(Long id);
}
