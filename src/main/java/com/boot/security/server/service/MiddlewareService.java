package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.boot.security.server.model.Middleware;

public interface MiddlewareService {
	    Middleware getById(Long id);
	    
	    int delete(Long id);
	    List<Middleware> getTitle();

	    int update(Middleware middleware);
	    
	    int save(Middleware middleware);
	    
	    int count(@Param("params") Map<String, Object> params);

	    List<Middleware> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
