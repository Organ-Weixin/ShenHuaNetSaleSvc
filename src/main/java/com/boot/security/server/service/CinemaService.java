package com.boot.security.server.service;

import com.boot.security.server.model.Cinema;

public interface CinemaService {
	
	Cinema getByCinemaCode(String cinemacode);
	
	int save(Cinema cinema);

	int update(Cinema Cinema);

	int delete(Long id);
}
