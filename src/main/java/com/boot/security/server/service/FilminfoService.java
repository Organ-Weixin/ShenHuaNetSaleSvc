package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Filminfo;

public interface FilminfoService {

	Filminfo getByFilmCode(String filmcode);
	
	List<Filminfo> getFilmByFilmName(String filmName);
	
	int save(Filminfo filminfo);

	int update(Filminfo filminfo);
}
