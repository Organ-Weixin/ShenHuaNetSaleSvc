package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.MembercardcreditruleDao;
import com.boot.security.server.model.Membercardcreditrule;
import com.boot.security.server.service.MembercardcreditruleService;
@Service
public class MembercardcreditruleServiceImpl implements MembercardcreditruleService{
	@Autowired
	private MembercardcreditruleDao membercardcreditruleDao;

	@Override
	public List<Membercardcreditrule> getOpenTypeByLevelCode(String cinemacode, String levelcode) {
		// TODO Auto-generated method stub
		return membercardcreditruleDao.getOpenTypeByLevelCode(cinemacode, levelcode);
	}

	@Override
	public List<Membercardcreditrule> getRechargeTypeByLevelCode(String cinemacode, String levelcode) {
		// TODO Auto-generated method stub
		return membercardcreditruleDao.getRechargeTypeByLevelCode(cinemacode, levelcode);
	}

	@Override
	public Membercardcreditrule getByRuleCode(String rulecode) {
		// TODO Auto-generated method stub
		return membercardcreditruleDao.getByRuleCode(rulecode);
	}

}
