package com.boot.security.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.MembercardrechargeDao;
import com.boot.security.server.model.Membercardrecharge;
import com.boot.security.server.service.MembercardrechargeService;

@Service
public class MembercardrechargeServiceImpl implements MembercardrechargeService{

	@Autowired
	private MembercardrechargeDao membercardrechargeDao;
	
	@Override
	public int save(Membercardrecharge membercardrecharge) {
		return membercardrechargeDao.save(membercardrecharge);
	}

	@Override
	public Membercardrecharge getByTradeNo(String tradeNo) {
		return membercardrechargeDao.getByTradeNo(tradeNo);
	}

	@Override
	public int update(Membercardrecharge membercardrecharge) {
		return membercardrechargeDao.update(membercardrecharge);
	}

	@Override
	public List<Membercardrecharge> getByCinemaAndCard(String cinemaCode, String cardNo) {
		return membercardrechargeDao.getByCinemaAndCard(cinemaCode, cardNo);
	}

}
