package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Actorconfiguration;

public interface ActorconfigurationService {
	List<Actorconfiguration> getByFilmCodeAndType(String filmcode,String type);
}
