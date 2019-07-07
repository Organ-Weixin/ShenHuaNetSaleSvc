package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Membercardrecharge;

public interface MembercardrechargeService {

	int save(Membercardrecharge membercardrecharge);
	Membercardrecharge getByTradeNo(String tradeNo);
	int update(Membercardrecharge membercardrecharge);
	
	List<Membercardrecharge> getByCinemaAndCard(String cinemaCode, String cardNo);
	Membercardrecharge getByOpenId(String cinemaCode, String openId);
}
