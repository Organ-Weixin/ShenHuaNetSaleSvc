package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.MiniprogramlinkurlDao;
import com.boot.security.server.model.Miniprogramlinkurl;
import com.boot.security.server.service.MiniprogramlinkurlService;
@Service
public class MiniprogramlinkurlServiceImpl implements MiniprogramlinkurlService{

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private MiniprogramlinkurlDao miniprogramlinkurlDao;
	@Override
	public Miniprogramlinkurl getById(Long id) {
		return miniprogramlinkurlDao.getById(id);
	}
	@Override
	public int delete(Long id) {
		return miniprogramlinkurlDao.delete(id);
	}
	@Override
	public int update(Miniprogramlinkurl miniprogramlinkurl) {
		return miniprogramlinkurlDao.update(miniprogramlinkurl);
	}
	@Override
	public int save(Miniprogramlinkurl miniprogramlinkurl) {
		return miniprogramlinkurlDao.save(miniprogramlinkurl);
	}
	@Override
	public int count(Map<String, Object> params) {
		return miniprogramlinkurlDao.count(params);
	}
	@Override
	public List<Miniprogramlinkurl> list(Map<String, Object> params, Integer offset, Integer limit) {
		return miniprogramlinkurlDao.list(params, offset, limit);
	}
	
	
}
