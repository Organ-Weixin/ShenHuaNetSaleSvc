package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.boot.security.server.model.Conpontype;

public interface ConpontypeService {
	Conpontype getById(Long id);
	
	List<Conpontype> getCertificatetype();

	List<Conpontype> getConpontype();
	
	int delete(Long id);

    int update(Conpontype conpontype);
    
    int save(Conpontype conpontype);
    
    int count(@Param("params") Map<String, Object> params);

    List<Conpontype> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
