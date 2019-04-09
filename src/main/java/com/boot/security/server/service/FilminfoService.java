package com.boot.security.server.service;

import com.boot.security.server.model.Filminfo;

public interface FilminfoService {

	Filminfo getByFilmCode(String filmcode);
	
	int save(Filminfo filminfo);

	int update(Filminfo filminfo);
}
