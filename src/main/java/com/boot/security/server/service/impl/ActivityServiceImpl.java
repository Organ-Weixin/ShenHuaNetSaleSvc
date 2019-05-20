package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ActivityDao;
import com.boot.security.server.model.Activity;
import com.boot.security.server.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private ActivityDao activityDao;
	@Override
	public Activity getById(Long id) {
		return activityDao.getById(id);
	}
	@Override
	public int delete(Long id) {
		return activityDao.delete(id);
	}
	@Override
	public int update(Activity activity) {
		return activityDao.update(activity);
	}
	@Override
	public int save(Activity activity) {
		return activityDao.save(activity);
	}
	@Override
	public int count(Map<String, Object> params) {
		return activityDao.count(params);
	}
	@Override
	public List<Activity> list(Map<String, Object> params, Integer offset, Integer limit) {
		return activityDao.list(params, offset, limit);
	}

}
