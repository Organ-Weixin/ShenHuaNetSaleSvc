package com.boot.security.server.service;

import java.util.List;
import java.util.Map;


import com.boot.security.server.model.Marketingcampaign;

public interface MarketingcampaignService {
	    Marketingcampaign getById(Long id);

	    int delete(Long id);

	    int update(Marketingcampaign marketingcampaign);
	    
	    int changestatus(Integer status,Long id);

	    int save(Marketingcampaign marketingcampaign);
	    
	    int count(Map<String, Object> params);

	    List<Marketingcampaign> list(Map<String, Object> params,Integer offset,Integer limit);
	    

}
