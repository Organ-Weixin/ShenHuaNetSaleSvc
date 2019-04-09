package com.boot.security.server.service;

import com.boot.security.server.model.Filminfo;

public interface FilminfoService {
	int save(Filminfo filminfo);
	
	Filminfo getByFilmCode(String filmcode);

	int update(Filminfo filminfo);
}
