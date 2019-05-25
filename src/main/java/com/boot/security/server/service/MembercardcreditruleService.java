package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Membercardcreditrule;

public interface MembercardcreditruleService {
	
	List<Membercardcreditrule> getOpenTypeByLevelCode(String cinemacode,String levelcode);
	
	List<Membercardcreditrule> getRechargeTypeByLevelCode(String cinemacode,String levelcode);
	
	Membercardcreditrule getByRuleCode(String rulecode);
}
