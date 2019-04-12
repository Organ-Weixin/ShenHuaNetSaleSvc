package com.boot.security.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QuerySessionSeatReply;
import com.google.gson.Gson;

@SpringBootTest
@RunWith(SpringRunner.class)
public class YkTest {

	@Test
	public void test() throws Exception{
		NetSaleSvcCore ns = new NetSaleSvcCore();
		
		String Username = "MiniProgram";
		String Password = "6BF477EBCC446F54E6512AFC0E976C41";
		String CinemaCode = "33010301";
//		String SessionCode = "888190416X0ZZ28H";
		
		
//		ns.QueryCinemaList(Username,Password);	//影院列表
		
		System.out.println(new Gson().toJson(ns.QueryCinema(Username, Password, CinemaCode)));	//影院基础信息
		
//		QuerySessionSeatReply seatReply = ns.QuerySessionSeat(Username, Password, CinemaCode, SessionCode, "sold");
//		System.out.println("查询放映计划座位售出状态："+new Gson().toJson(seatReply));
	}
}
