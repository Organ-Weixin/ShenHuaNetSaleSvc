package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.boot.security.server.model.Filminfo;

public interface FilminfoService {
	
	Filminfo getById(Long id);

	Filminfo getByFilmCode(String filmcode);
	
	List<Filminfo> getFilmByFilmName(String filmName);
	
	int save(Filminfo filminfo);

	int update(Filminfo filminfo);
	
	int delete(Long id);
	
	int count(@Param("params") Map<String, Object> params);
	
	List<Filminfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
