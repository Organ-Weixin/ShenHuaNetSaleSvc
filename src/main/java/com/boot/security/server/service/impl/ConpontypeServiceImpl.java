package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ConpontypeDao;
import com.boot.security.server.model.Conpontype;
import com.boot.security.server.service.ConpontypeService;
@Service
public class ConpontypeServiceImpl implements ConpontypeService{
	@Autowired
	ConpontypeDao ConpontypeD;
	
	@Override
	public List<Conpontype> getConpontype() {
		return ConpontypeD.getConpontype();
	}

	@Override
	public Conpontype getById(Long id) {
		// TODO Auto-generated method stub
		return ConpontypeD.getById(id);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return ConpontypeD.delete(id);
	}

	@Override
	public int update(Conpontype conpontype) {
		// TODO Auto-generated method stub
		return ConpontypeD.update(conpontype);
	}

	@Override
	public int save(Conpontype conpontype) {
		// TODO Auto-generated method stub
		return ConpontypeD.save(conpontype);
	}

	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return ConpontypeD.count(params);
	}

	@Override
	public List<Conpontype> list(Map<String, Object> params, Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return ConpontypeD.list(params, offset, limit);
	}

	@Override
	public List<Conpontype> getCertificatetype() {
		// TODO Auto-generated method stub
		return ConpontypeD.getCertificatetype();
	}
	
}
