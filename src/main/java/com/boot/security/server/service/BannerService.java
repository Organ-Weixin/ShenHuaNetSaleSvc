package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import com.boot.security.server.model.Banner;

public interface BannerService {

	Banner getById(Long id);
	int delete(Long id);
	int update(Banner banner);
	int save(Banner banner);
	int count(Map<String, Object> params);
    List<Banner> list(Map<String, Object> params, Integer offset, Integer limit);
    
    List<Banner> getByCodeAndDate(String cinemacode);

}
