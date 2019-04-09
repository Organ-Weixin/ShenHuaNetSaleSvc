package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.MiddlewareDao;
import com.boot.security.server.model.Middleware;
import com.boot.security.server.service.MiddlewareService;
@Service
public class MiddlewareServiceImpl implements MiddlewareService{
	@Autowired
	MiddlewareDao middleW;
	@Override
	public Middleware getById(Long id) {
		// TODO Auto-generated method stub
		return middleW.getById(id);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return middleW.delete(id);
	}

	@Override
	public int update(Middleware middleware) {
		// TODO Auto-generated method stub
		return middleW.update(middleware);
	}

	@Override
	public int save(Middleware middleware) {
		// TODO Auto-generated method stub
		return middleW.save(middleware);
	}

	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return middleW.count(params);
	}

	@Override
	public List<Middleware> list(Map<String, Object> params, Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return middleW.list(params, offset, limit);
	}
}
