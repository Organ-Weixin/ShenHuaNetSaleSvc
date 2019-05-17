package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.BannerDao;
import com.boot.security.server.model.Banner;
import com.boot.security.server.service.BannerService;

@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	private BannerDao bannerDao;
	
	@Override
	public Banner getById(Long id) {
		return bannerDao.getById(id);
	}

	@Override
	public int delete(Long id) {
		return bannerDao.delete(id);
	}

	@Override
	public int update(Banner banner) {
		return bannerDao.update(banner);
	}

	@Override
	public int save(Banner banner) {
		return bannerDao.save(banner);
	}

	@Override
	public int count(Map<String, Object> params) {
		return bannerDao.count(params);
	}

	@Override
	public List<Banner> list(Map<String, Object> params, Integer offset, Integer limit) {
		return bannerDao.list(params, offset, limit);
	}

	@Override
	public List<Banner> getByCodeAndDate(String cinemacode) {
		return bannerDao.getByCodeAndDate(cinemacode);
	}

}
