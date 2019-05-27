package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Choosemembercardcreditrule;

public interface ChoosemembercardcreditruleService {

	List<Choosemembercardcreditrule> getByLevelCode(String cinemacode,String levelcode);
	
	int deleteByLevelCode(String cinemacode,String levelcode);
	
	Choosemembercardcreditrule getOpenTypeByLevelCode(String cinemacode,String levelcode);
	
	List<Choosemembercardcreditrule> getRechargeTypeListByLevelCode(String cinemacode,String levelcode);
	
	Choosemembercardcreditrule getByRuleCode(String cinemacode,String rulecode);
}
