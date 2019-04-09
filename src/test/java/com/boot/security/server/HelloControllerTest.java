package com.boot.security.server;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.ctms.reply.Dy1905Interface;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Usercinemaview;

@SpringBootTest
@RunWith(SpringRunner.class)

public class HelloControllerTest {
	////\\3311
	@Test
	public void test() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33014901");
		di.QueryCinema(userCinema);
	}
	@Test
	public void QueryCinemaAndScreenTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		//userCinema.setCinemaId("194");
		userCinema.setCinemaCode("33097601");
		di.QueryCinema(userCinema);
	}
	@Test
	public void QuerySeatTest() throws Exception{
		Dy1905Interface di = new Dy1905Interface();
		Usercinemaview userCinema = new Usercinemaview();
		userCinema.setDefaultUserName("1000000035");
		userCinema.setDefaultPassword("66a16ca61f729e0c846983f8c0f4fd53");
		userCinema.setCinemaId("194");
		Screeninfo screen = new Screeninfo();
		screen.setScreenId("1078");
		userCinema.setCinemaCode("33097601");
		screen.setSCode("0000000000000009");
		di.QuerySeat(userCinema, screen);
	}
	@Test
	public void QueryCinemaListTest(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCinemaList("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41");
	}
	@Test
	public void QueryCinemaTest(){
		NetSaleSvcCore ns = new NetSaleSvcCore();
		ns.QueryCinema("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", "33097601");
	}
	
}
