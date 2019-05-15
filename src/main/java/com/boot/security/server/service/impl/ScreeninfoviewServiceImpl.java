package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ScreeninfoviewDao;
import com.boot.security.server.model.Screeninfoview;
import com.boot.security.server.service.ScreeninfoviewService;

@Service
public class ScreeninfoviewServiceImpl  implements ScreeninfoviewService{
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private ScreeninfoviewDao screeninfoviewDao;
	@Override
	public Screeninfoview getById(Long id) {
		return screeninfoviewDao.getById(id);
	}
	@Override
	public int delete(Long id) {
		return screeninfoviewDao.delete(id);
	}
	@Override
	public int update(Screeninfoview screeninfoview) {
		return screeninfoviewDao.update(screeninfoview);
	}
	@Override
	public int save(Screeninfoview screeninfoview) {
		return screeninfoviewDao.save(screeninfoview);
	}
	@Override
	public int count(Map<String, Object> params) {
		return screeninfoviewDao.count(params);
	}
	@Override
	public List<Screeninfoview> list(Map<String, Object> params, Integer offset, Integer limit) {
		return screeninfoviewDao.list(params, offset, limit);
	}
	
}
