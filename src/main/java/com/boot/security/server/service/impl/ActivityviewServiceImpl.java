package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ActivityviewDao;
import com.boot.security.server.model.Activityview;
import com.boot.security.server.service.ActivityviewService;

@Service
public class ActivityviewServiceImpl implements ActivityviewService{
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private ActivityviewDao activityviewDao;
	@Override
	public Activityview getById(Long id) {
		return activityviewDao.getById(id);
	}
	@Override
	public int delete(Long id) {
		return activityviewDao.delete(id);
	}
	@Override
	public int update(Activityview activityview) {
		return activityviewDao.update(activityview);
	}
	@Override
	public int save(Activityview activityview) {
		return activityviewDao.save(activityview);
	}
	@Override
	public int count(Map<String, Object> params) {
		return activityviewDao.count(params);
	}
	@Override
	public List<Activityview> list(Map<String, Object> params, Integer offset, Integer limit) {
		return activityviewDao.list(params, offset, limit);
	}
	
}
