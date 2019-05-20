package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import com.boot.security.server.model.Activityview;

public interface ActivityviewService {
	    Activityview getById(Long id);

	    int delete(Long id);

	    int update(Activityview activityview);
	    
	    int save(Activityview activityview);
	    
	    int count(Map<String, Object> params);

	    List<Activityview> list(Map<String, Object> params,Integer offset,Integer limit);

}
