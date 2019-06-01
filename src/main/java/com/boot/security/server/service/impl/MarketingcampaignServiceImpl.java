package com.boot.security.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.MarketingcampaignDao;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Marketingcampaign;
import com.boot.security.server.service.MarketingcampaignService;

@Service
public class MarketingcampaignServiceImpl implements MarketingcampaignService{
	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private MarketingcampaignDao marketingcampaignDao;
	@Override
	public Marketingcampaign getById(Long id) {
		return marketingcampaignDao.getById(id);
	}
	@Override
	public int delete(Long id) {
		return marketingcampaignDao.delete(id);
	}
	@Override
	public int update(Marketingcampaign marketingcampaign) {
		return marketingcampaignDao.update(marketingcampaign);
	}
	@Override
	public int save(Marketingcampaign marketingcampaign) {
		return marketingcampaignDao.save(marketingcampaign);
	}
	@Override
	public int count(Map<String, Object> params) {
		return marketingcampaignDao.count(params);
	}
	@Override
	public List<Marketingcampaign> list(Map<String, Object> params, Integer offset, Integer limit) {
		return marketingcampaignDao.list(params, offset, limit);
	}
	@Override
	public int changestatus(Integer status, Long id) {
		return marketingcampaignDao.changestatus(status, id);
	}

}
