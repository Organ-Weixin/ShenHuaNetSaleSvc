package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.ChoosemembercardcreditruleDao;
import com.boot.security.server.model.Choosemembercardcreditrule;
import com.boot.security.server.service.ChoosemembercardcreditruleService;
@Service
public class ChoosemembercardcreditruleServiceImpl implements ChoosemembercardcreditruleService{
	@Autowired
	private ChoosemembercardcreditruleDao choosemembercardcreditruleDao;

	@Override
	public List<Choosemembercardcreditrule> getByLevelCode(String cinemacode, String levelcode) {
		// TODO Auto-generated method stub
		return choosemembercardcreditruleDao.getByLevelCode(cinemacode, levelcode);
	}

	@Override
	public int deleteByLevelCode(String cinemacode, String levelcode) {
		// TODO Auto-generated method stub
		return choosemembercardcreditruleDao.deleteByLevelCode(cinemacode, levelcode);
	}

	@Override
	public Choosemembercardcreditrule getOpenTypeByLevelCode(String cinemacode, String levelcode) {
		// TODO Auto-generated method stub
		return choosemembercardcreditruleDao.getOpenTypeByLevelCode(cinemacode, levelcode);
	}

	@Override
	public List<Choosemembercardcreditrule> getRechargeTypeListByLevelCode(String cinemacode, String levelcode) {
		// TODO Auto-generated method stub
		return choosemembercardcreditruleDao.getRechargeTypeListByLevelCode(cinemacode, levelcode);
	}

	@Override
	public Choosemembercardcreditrule getByRuleCode(String cinemacode,String levelcode, String rulecode) {
		// TODO Auto-generated method stub
		return choosemembercardcreditruleDao.getByRuleCode(cinemacode, levelcode, rulecode);
	}

	@Override
	public Choosemembercardcreditrule getByLevelCodeAndRuleType(String cinemacode, String levelcode, String ruletype) {
		// TODO Auto-generated method stub
		return choosemembercardcreditruleDao.getByLevelCodeAndRuleType(cinemacode, levelcode, ruletype);
	}

}
