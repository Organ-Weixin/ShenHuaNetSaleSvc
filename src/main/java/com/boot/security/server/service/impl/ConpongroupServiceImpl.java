package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ConpongroupDao;
import com.boot.security.server.model.Conpongroup;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.ConpongroupService;
@Service
public class ConpongroupServiceImpl implements ConpongroupService{
	@Autowired
	ConpongroupDao ConpongroupD;
	@Override
	public List<SysUser> getCinemaName() {
		// TODO Auto-generated method stub
		return ConpongroupD.getCinemaName();
	}
	@Override
	public int save(Conpongroup conpongroup) {
		// TODO Auto-generated method stub
		return ConpongroupD.save(conpongroup);
	}
	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return ConpongroupD.count(params);
	}
	@Override
	public List<Conpongroup> list(Map<String, Object> params, Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return ConpongroupD.list(params, offset, limit);
	}
	@Override
	public Conpongroup getById(Long id) {
		// TODO Auto-generated method stub
		return ConpongroupD.getById(id);
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return ConpongroupD.delete(id);
	}
	@Override
	public int update(Conpongroup conpongroup) {
		// TODO Auto-generated method stub
		return ConpongroupD.update(conpongroup);
	}
	
}
