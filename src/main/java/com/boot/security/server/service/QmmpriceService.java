package com.boot.security.server.service;

import com.boot.security.server.model.Qmmprice;

public interface QmmpriceService {

	Qmmprice getById(Long id);
	int update(Qmmprice qmmprice);
	int save(Qmmprice qmmprice);
	
	Qmmprice getByShowId(String showId);
}
