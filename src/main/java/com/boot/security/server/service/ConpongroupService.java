package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.boot.security.server.model.Conpongroup;
import com.boot.security.server.model.Systemusers;

public interface ConpongroupService {
	Conpongroup getById(Long id);
	
	List<Systemusers> getCinemaName();
	
	int delete(Long id);

    int update(Conpongroup conpongroup);
	
	int save(Conpongroup conpongroup);
    
    int count(@Param("params") Map<String, Object> params);

    List<Conpongroup> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
