package com.boot.security.server.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryCardLevelReply;
import com.boot.security.server.api.core.QueryCinemaReply;
import com.boot.security.server.api.core.QueryFilmReply;
import com.boot.security.server.api.core.QueryGoodsReply;
import com.boot.security.server.api.core.QuerySeatReply;
import com.boot.security.server.api.core.QuerySessionReply;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CouponGroupStatusEnum;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;

@Component
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class MultithreadScheduleTask {
	@Autowired
	private CinemaServiceImpl cinemaService;
	@Autowired
	private ScreeninfoServiceImpl screeninfoService;
	@Autowired
	private CouponsgroupServiceImpl couponsgroupService;
	@Autowired
	private CouponsServiceImpl couponsService;
	@Autowired
	private TicketusersServiceImpl ticketusersService;
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private GoodsOrderServiceImpl goodsOrderService;
	
	//更新影院、影厅信息
	@Async
    @Scheduled(cron="0 0 3 * * ? ")  //每天03点开始执行
	//@Scheduled(fixedRate = 100000)  //项目启动开始执行，每100000毫秒执行一次
    public void QueryCinema() throws InterruptedException {
		List<Cinema> cinemaList = cinemaService.AllCinema();
		for(int i=0; i<cinemaList.size(); i++){
			QueryCinemaReply cinemaReply = new NetSaleSvcCore().QueryCinema("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", cinemaList.get(i).getCode());
			if(!cinemaReply.Status.equals("Success")){
				continue;
			}
			Thread.sleep(1000 * 10);
		}
    }
	//更新座位信息
	@Async
    @Scheduled(cron="0 0 3 * * ? ")  //每天03点开始执行
    public void QuerySeat() throws InterruptedException {
		List<Cinema> cinemaList = cinemaService.AllCinema();
		for(int i=0; i<cinemaList.size(); i++){
			List<Screeninfo> screeninfoList = screeninfoService.getByCinemaCode(cinemaList.get(i).getCode());
			for(int j=0; j<screeninfoList.size(); j++){
				QuerySeatReply seatReply = new NetSaleSvcCore().QuerySeat("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", cinemaList.get(i).getCode(), screeninfoList.get(j).getSCode());
				if(!seatReply.Status.equals("Success")){
					continue;
				}
				Thread.sleep(1000 * 10);
			}
		}
    }
	//更新影片信息
	@Async
    @Scheduled(cron="0 0 3 * * ?")  //每天03点开始执行
    public void QueryFilm() throws InterruptedException, ParseException {
		List<Cinema> cinemaList = cinemaService.AllCinema();
		String StartDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String EndDate = String.valueOf(new Date().getTime()+24L*60L*60L*1000L*30L);
		for(int i=0; i<cinemaList.size(); i++){
				QueryFilmReply filmReply = new NetSaleSvcCore().QueryFilm("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", cinemaList.get(i).getCode(), StartDate, new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(EndDate))));
				if(!filmReply.Status.equals("Success")){
					continue;
				}
			Thread.sleep(1000 * 10);
		}
    }
	//更新排期
	@Async
	//@Scheduled(fixedRate = 7200000)
    @Scheduled(cron="0 0 3 * * ?")  //每天03点开始执行
    public void QuerySession() throws InterruptedException, ParseException {
		List<Cinema> cinemaList = cinemaService.AllCinema();
		String StartDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String EndDate = String.valueOf(new Date().getTime()+24L*60L*60L*1000L*30L);
		for(int i=0; i<cinemaList.size(); i++){
			QuerySessionReply sessionReply = new NetSaleSvcCore().QuerySession("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", cinemaList.get(i).getCode(), StartDate, new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(EndDate))));
				if(!sessionReply.Status.equals("Success")){
					continue;
				}
			Thread.sleep(1000 * 10);
		}
    }
	//更新会员卡等级
	@Async
    @Scheduled(cron="0 0 3 * * ?")  //每天03点开始执行
    public void QueryCardLevel() throws InterruptedException, ParseException {
		List<Cinema> cinemaList = cinemaService.AllCinema();
		for(int i=0; i<cinemaList.size(); i++){
			QueryCardLevelReply cardLevelReply = new NetSaleSvcCore().QueryCardLevel("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", cinemaList.get(i).getCode());
				if(!cardLevelReply.Status.equals("Success")){
					continue;
				}
			Thread.sleep(1000 * 10);
		}
    }
	//更新影院卖品列表
	@Async
    @Scheduled(cron="0 0 3 * * ?")  //每天03点开始执行
    public void QueryGoods() throws InterruptedException, ParseException {
		List<Cinema> cinemaList = cinemaService.AllCinema();
		for(int i=0; i<cinemaList.size(); i++){
			QueryGoodsReply goodsReply = new NetSaleSvcCore().QueryGoods("MiniProgram", "6BF477EBCC446F54E6512AFC0E976C41", cinemaList.get(i).getCode());
				if(!goodsReply.Status.equals("Success")){
					continue;
				}
			Thread.sleep(1000 * 10);
		}
    }
	//更新第三方价格
	@Async
	//@Scheduled(fixedRate = 7200000)
    @Scheduled(cron="0 0 3 * * ?")  //每天03点开始执行 
    public void getQmmPrice() throws InterruptedException, ParseException, IOException {
		List<Cinema> cinemaList = cinemaService.AllCinema();
		for(int i=0; i<cinemaList.size(); i++){
			String result = new QmmPriceUtil().getQmmPrice(cinemaList.get(i).getCode());
				if(!result.equals("Success")){
					continue;
				}
			Thread.sleep(1000 * 10);
		}
    }
	//更新优惠券组状态
	@Async
	@Scheduled(cron="0 0 3 * * ?")
	public void checkExripeOfCouponsGroup(){
		couponsgroupService.changePast(CouponGroupStatusEnum.Expired.getStatusCode());
	}
	//更新优惠券状态
	@Async
	@Scheduled(cron="0 0 3 * * ?")
	public void checkExripeOfCoupons(){
		couponsService.changePast(CouponsStatusEnum.Expire.getStatusCode());
	}
	//更新购票用户是否活跃状态
	@Async
	@Scheduled(cron="0 0 3 * * ?")
	public void checkTicketUsers(){
		List<Ticketusers> ticketusersList = ticketusersService.getAllList();
		if(ticketusersList.size()>0){
			for(int i=0; i<ticketusersList.size(); i++){
				List<Orders> orderList = orderService.getByOpenId(ticketusersList.get(i).getOpenID(), new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(String.valueOf(new Date().getTime()-3l*30l*24l*60l*60l*1000l)))));
				List<Goodsorders> goodsOrderList = goodsOrderService.getByOpenID(ticketusersList.get(i).getOpenID(), new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(String.valueOf(new Date().getTime()-3l*30l*24l*60l*60l*1000l)))));
				if(orderList.size()>0||goodsOrderList.size()>0){
					ticketusersService.updateIsActive(1, ticketusersList.get(i).getOpenID());
				}else{
					ticketusersService.updateIsActive(0, ticketusersList.get(i).getOpenID());
				}
			}
		}
	}
	//更新订单取票状态
	@Async
	@Scheduled(cron="0 0 3 * * ?")
	public void updateOrderPrintStatus(){
		List<Cinema> cinemaList = cinemaService.AllCinema();
		for(int i=0; i<cinemaList.size(); i++){
			//List<Orders> orderList = orderService.getByOrderCode(cinemacode, ordercode);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(String.valueOf(new Date().getTime()-3l*30l*24l*60l*60l*1000l)))));
	}
}
