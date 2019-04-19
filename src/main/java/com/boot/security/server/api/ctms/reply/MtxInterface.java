package com.boot.security.server.api.ctms.reply;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONObject;

import com.boot.security.server.api.ctms.reply.MtxGetCinemaPlanResult.ResBean.CinemaPlansBean.CinemaPlanBean;
import com.boot.security.server.api.ctms.reply.MtxGetHallAllSeatResult.HallAllSeatBean;
import com.boot.security.server.api.ctms.reply.MtxGetHallResult.ResBean.HallsBean.HallBean;

import com.boot.security.server.api.ctms.reply.MtxGetPlanSiteStateResult.ResBean.PlanSiteStatesBean.PlanSiteStateBean;

import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.LoveFlagEnum;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;

import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.SessionSeat;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;

import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.SpringUtil;
import com.google.gson.Gson;

import cn.cmts.main.webservice.WebService;


public class MtxInterface implements ICTMSInterface {
	
	 private WebService mtxService;
	 CinemaServiceImpl _cinemaService=SpringUtil.getBean(CinemaServiceImpl.class);
	 ScreeninfoServiceImpl _screeninfoService=SpringUtil.getBean(ScreeninfoServiceImpl.class);
	 ScreenseatinfoServiceImpl _screenseatinfoService=SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	 SessioninfoServiceImpl  _sessioninfoService=SpringUtil.getBean(SessioninfoServiceImpl.class);
	 FilminfoServiceImpl _filminfoService=SpringUtil.getBean(FilminfoServiceImpl.class);
	 
	// 查询影厅基本信息 
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		MtxGetHallResult mtxReply = mtxService.GetHall(userCinema);
		System.out.println("开始执行操作-------------------"+ new Gson().toJson(mtxReply));
	
		if ("0".equals(mtxReply.getGetHallResult().getResultCode())) {
			// 更新影厅信息
			System.out.println("执行更新操作-----");
			List<Screeninfo> newScreens=new ArrayList<Screeninfo>();
			List<HallBean> hallBeans = mtxReply.getGetHallResult().getHalls().getHall();
			for (HallBean hallBean : hallBeans) {
				Screeninfo screen = new Screeninfo();// 创建实例
				MtxModelMapper.MapToEntity(hallBean, screen);
				screen.setCCode(userCinema.getCinemaCode());
				newScreens.add(screen);
				System.out.println("--------更新影厅--------------");
			}
			// 先删除旧影影厅
			_screeninfoService.deleteByCinemaCode(userCinema.getCinemaCode());
			System.out.println("删除-----------");
			// 插入影厅信息
			for (Screeninfo screen : newScreens) {
				_screeninfoService.save(screen);
				System.out.println("插入影厅信息-------------");
			}
			System.out.println("成功--------------------");
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getGetHallResult().getResultCode();
		return reply;
	}
	//查询影厅座位信息
		public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
			CTMSQuerySeatReply reply=new CTMSQuerySeatReply();
			MtxGetHallAllSeatResult mtxReply=mtxService.GetHallAllSeat(userCinema, screen);
			
			System.out.println("开始执行操作-------------------"+ new Gson().toJson(mtxReply));
			if("0".equals(mtxReply.getResultCode())){
				//更新影厅座位信息
				if(_screenseatinfoService.getByCinemaCodeAndScreenCode(userCinema.getCinemaCode(), screen.getSCode()) != null){
					System.out.println("开始更新影厅座位操作----------");
					List<Screenseatinfo> newScreens=new ArrayList<Screenseatinfo>();
					List<HallAllSeatBean> hallAllSeatBeans=mtxReply.getHallSeats();
				
					for(HallAllSeatBean hallAllSeatBean : hallAllSeatBeans){
						Screenseatinfo screenseat=new Screenseatinfo();//创建实例
						MtxModelMapper.MapToEntity(hallAllSeatBean, screenseat);
						screenseat.setCinemaCode(userCinema.getCinemaCode());
						screenseat.setScreenCode(screen.getSCode());
						screenseat.setLoveFlag(LoveFlagEnum.Normal.getFlagCode());
						screenseat.setStatus(SessionSeatStatusEnum.Available.getStatusCode());
						newScreens.add(screenseat);
						System.out.println("更新影厅座位成功------------");
					}
					//先删除旧影厅座位
					_screenseatinfoService.deleteByScreenCode(userCinema.getCinemaCode(), screen.getSCode());
					System.out.println("---删除影厅座位---------------");
							//插入座位信息
							/*for(Screenseatinfo screenSeat : newScreens){
								_screenseatinfoService.save(screenSeat);
								System.out.println("插入影厅座位成功----------");
							}*/
					for (Screenseatinfo screenseat : newScreens) {
						_screenseatinfoService.save(screenseat);
						System.out.println("插入影厅信息-------------");
					}
				}
				reply.Status=StatusEnum.Success;
				System.out.println("操作影厅成功----------------------");
			}
			else{
				reply.Status=StatusEnum.Failure;
			}
			reply.ErrorCode=mtxReply.getResultCode();
			return reply;
		}
	//查询放映计划信息////排期
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate)throws Exception {
		CTMSQuerySessionReply reply=new CTMSQuerySessionReply();
		MtxGetCinemaPlanResult mtxReply=mtxService.GetCinemaPlan(userCinema, StartDate, EndDate);
		System.out.println("开始执行查询排期操作-------------------"+ new Gson().toJson(mtxReply));
		Date newDate = new Date();
		String s = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
		s += " 01:00:00";
		Date d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
		System.out.println("d1=" + d1);
		String t = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
		t += " 06:00:00";
		Date d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t);
		System.out.println("d2=" + d2);
		System.out.println(newDate);
		if (newDate.getTime() > d1.getTime() && newDate.getTime() < d2.getTime()) {
			reply.Status = StatusEnum.Success;
            reply.ErrorCode = "0";
		}
        else{
		if("0".equals(mtxReply.getGetCinemaPlanResult().getResultCode())){
			//更新排期信息
			List<Sessioninfo> newSessions=new ArrayList<Sessioninfo>();
			List<CinemaPlanBean> cinemaPlanBeans=mtxReply.getGetCinemaPlanResult().getCinemaPlans().getCinemaPlan();
			System.out.println("开始更新排期操作----------");
			for(CinemaPlanBean cinemaPlanBean:cinemaPlanBeans){
				Sessioninfo session=new Sessioninfo();//创建实例
				MtxModelMapper.MapToEntity(cinemaPlanBean, session);
				session.setUserID(userCinema.getUserId());
				newSessions.add(session);
				System.out.println("更新排期成功------------");
			}
			//先删除旧排期信息
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("CCode", userCinema.getCinemaCode());
			params.put("UserId", userCinema.getUserId());
			params.put("StartTime", new SimpleDateFormat("yyyy-MM-dd").format(StartDate));
			_sessioninfoService.deleteByCinemaCode(params);
			System.out.println("删除旧排期------------");
			//插入排期信息
				int num = 0;
				for (Sessioninfo sessionInfo : newSessions) {
					_sessioninfoService.save(sessionInfo);
					num++;
				}
				reply.Status = StatusEnum.Success;
System.out.println("更新排期成功-------------+++++++++++++=");
		} else {
				reply.Status = StatusEnum.Failure;
				System.out.println("更新排期失败-------------+++++++++++++=");
			}

			reply.ErrorCode = mtxReply.getGetCinemaPlanResult().getResultCode();

		}
		System.out.println("不更新==========");
		return reply;
	}
	//查询影片信息
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQueryFilmReply reply = new CTMSQueryFilmReply();
		System.out.println("开始执行查询影片信息操作-------------------" + new Gson().toJson(reply));
		// 从排期中获取影片接口
		QuerySession(userCinema, StartDate, EndDate);// 调用查询排期列表
		System.out.println("调用排期-------------");
		// 根据影片名称分组，去除影片重复数据
		List<Sessioninfo> sessions = _sessioninfoService.getByCCodeGroupByFilm(userCinema.getUserId(),
				userCinema.getCinemaCode(), StartDate, EndDate);
		List<Filminfo> films = new ArrayList<Filminfo>();
		System.out.println("去除重复影片-------");
		for (Sessioninfo sessioninfo : sessions) {
			String filmName = sessioninfo.getFilmName();
			List<Filminfo> filmlist = _filminfoService.getFilmByFilmName(filmName);
			if (filmlist == null || filmlist.size() == 0) {
				Filminfo film = new Filminfo();
				film.setFilmCode(sessioninfo.getFilmCode());
				film.setFilmName(sessioninfo.getFilmName());
				film.setDuration(sessioninfo.getDuration().toString());
				_filminfoService.save(film);
				films.add(film);
				System.out.println("保存添加=====================");
			} else if (filmlist.size() > 1) {
				for (Filminfo ffilminfo : filmlist) {
					if (ffilminfo.getPublishDate() != null || ffilminfo.getPublisher() != null
							|| ffilminfo.getProducer() != null || ffilminfo.getDirector() != null
							|| ffilminfo.getCast() != null || ffilminfo.getIntroduction() != null) {
						films.add(ffilminfo);
						System.out.println("优先选择信息比较全的--------");
						break;
					} else {
						films.add(ffilminfo);
						System.out.println("优-------");
						break;
					}
				}
			} else {
				films.add(filmlist.get(0));
			}
		}
		reply.setFilms(films);
		reply.Status = StatusEnum.Success;
		System.out.println("查询影片成功-----------------");
		return reply;
	}
	//查询放映计划座位状态
	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,SessionSeatStatusEnum Status) throws Exception {
		CTMSQuerySessionSeatReply reply=new CTMSQuerySessionSeatReply();
		MtxGetPlanSiteStateResult mtxReply=mtxService.GetPlanSiteState(userCinema, SessionCode, Status);
	//	QuerySession(userCinema, null, null);// 调用查询排期列表
		System.out.println("开始执行查询排期座位操作-------------------"+ new Gson().toJson(mtxReply));
	
			if ("0".equals(mtxReply.getGetPlanSiteStateResult().getResultCode()))
			{
				System.out.println("开始更新查询放映计划座位状态操作----------");
				List<SessionSeat> newSessionSeat=new ArrayList<SessionSeat>();
				List<PlanSiteStateBean> planSiteStateBeans=mtxReply.getGetPlanSiteStateResult().getPlanSiteStates().getPlanSiteState();
				for(PlanSiteStateBean planSiteStateBean:planSiteStateBeans){
					SessionSeat sessionseats=new SessionSeat();
					sessionseats.setSeatCode(planSiteStateBean.getSeatNo());
					sessionseats.setRowNum(planSiteStateBean.getSeatRow());
					sessionseats.setColumnNum(planSiteStateBean.getSeatCol());
					String seatStatus = planSiteStateBean.getSeatState();
					if("-1".equals(seatStatus)){	//不可售
						sessionseats.setStatus(SessionSeatStatusEnum.Unavailable);
					} else if("1".equals(seatStatus)){	//已售
						sessionseats.setStatus(SessionSeatStatusEnum.Sold);
					} else if("3".equals(seatStatus)){	//预定
						sessionseats.setStatus(SessionSeatStatusEnum.Booked);
					} else if("7".equals(seatStatus)){	//已锁定
						sessionseats.setStatus(SessionSeatStatusEnum.Locked);
					}else {	//未售
						sessionseats.setStatus(SessionSeatStatusEnum.Available);
					}
					newSessionSeat.add(sessionseats);
					
				}
				List<SessionSeat>  newseatlist=  newSessionSeat;
				if(Status!=SessionSeatStatusEnum.All){
					newseatlist = newseatlist.stream().filter((SessionSeat ss)->Status.equals(ss.getStatus())).collect(Collectors.toList());
				}
				reply.setSessionSeats(newseatlist);
				reply.Status=StatusEnum.Success;
				System.out.println("查询放映计划座位状态成功-----------------");
			}else{
				reply.Status=StatusEnum.Failure;
			}
		reply.ErrorCode=mtxReply.getGetPlanSiteStateResult().getResultCode();
		return reply;
	}
	//锁定座位
	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSLockSeatReply reply=new CTMSLockSeatReply();
		MtxLiveRealCheckSeatStateResult mtxReply=mtxService.LiveRealCheckSeatState(userCinema,order);
		System.out.println("开始锁定座位操作-------------------"+ new Gson().toJson(mtxReply));
		if("0".equals(mtxReply.getRealCheckSeatStateResult().getResultCode())){
			System.out.println("开始锁定座位----------");
			Date newDate=new Date();
			order.getOrderBaseInfo().setLockOrderCode(mtxReply.getRealCheckSeatStateResult().getOrderNo());
			order.getOrderBaseInfo().setAutoUnlockDatetime(new Date(newDate.getTime()+10*60*1000));//满天星没有自动解锁时间返回，此处默认锁定10分钟
			order.getOrderBaseInfo().setLockTime(new Date());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Locked.getStatusCode());
			reply.Status=StatusEnum.Success;
			System.out.println("锁定座位成功-----------------");
		}else{
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.LockFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(mtxReply.getRealCheckSeatStateResult().getResultCode());
			reply.Status=StatusEnum.Failure;
			System.out.println("锁定座位失败-----------------");
		}
		System.out.println("返回错误编码--------------------");
		reply.ErrorCode=mtxReply.getRealCheckSeatStateResult().getResultCode();
		return reply;
	}
	//解锁座位
	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSReleaseSeatReply reply=new CTMSReleaseSeatReply();
		MtxUnLockOrderCenCinResult mtxUnLockReply=mtxService.UnLockOrderCenCin(userCinema, order);
		System.out.println("开始解锁座位操作-------------------"+ new Gson().toJson(mtxUnLockReply));
		if("0".equals(mtxUnLockReply.getUnLockOrderCenCinResult().getResultCode())){
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Released.getStatusCode());
			reply.Status=StatusEnum.Success;
			System.out.println("解锁成功--------------------");
		}else{
			order.getOrderBaseInfo().setErrorMessage(mtxUnLockReply.getUnLockOrderCenCinResult().getResultCode());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.ReleaseFail.getStatusCode());
			System.out.println("解锁失败-------------------");
			reply.Status=StatusEnum.Failure;
		}
		System.out.println("返回错误编码--------------------");
		reply.ErrorCode=mtxUnLockReply.getUnLockOrderCenCinResult().getResultCode();
		return reply;
	}
	
	//提交订单
	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSSubmitOrderReply reply=new CTMSSubmitOrderReply();
		MtxSellTicketResult mtxReply=mtxService.SellTicket(userCinema, order);
		System.out.println("提交订单返回："+new Gson().toJson(mtxReply));
		if("0".equals(mtxReply.getSellTicketResult().getResultCode())){
			Date newDate=new Date();
			order.getOrderBaseInfo().setSubmitOrderCode(mtxReply.getSellTicketResult().getOrderNo());
			order.getOrderBaseInfo().setPrintNo(mtxReply.getSellTicketResult().getOrderNo());
			order.getOrderBaseInfo().setVerifyCode(mtxReply.getSellTicketResult().getValidCode());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Submited.getStatusCode());
			order.getOrderBaseInfo().setSubmitTime(newDate);
			QueryOrder(userCinema, order);//调用订单查询
			reply.Status=StatusEnum.Success;
			System.out.println("提交订单成功======================"+OrderStatusEnum.Submited.getStatusCode());
		}else{
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.SubmitFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(mtxReply.getSellTicketResult().getResultCode());
			reply.Status=StatusEnum.Failure;
			System.out.println("提交订单失败======================"+OrderStatusEnum.SubmitFail.getStatusCode());
			System.out.println("提交订单失败======================"+mtxReply.getSellTicketResult().getResultCode());

		}
		reply.ErrorCode=mtxReply.getSellTicketResult().getResultCode();
		return reply;
	}
	//查询出票状态
	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryPrintReply reply=new CTMSQueryPrintReply();
		MtxGetOrderStatusResult mtxReply=mtxService.GetOrderStatus(userCinema, order);
		System.out.println("查询出票状态返回返回："+new Gson().toJson(mtxReply));
		if("0".equals(mtxReply.getGetOrderStatusResult().getResultCode())){
			if("8".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())){	//8已打票
				order.getOrderBaseInfo().setPrintStatus(1);
				order.getOrderBaseInfo().setPrintTime(new Date());	//无返回打印时间，取当前时间
			} else {
				order.getOrderBaseInfo().setPrintStatus(0);
			}
			System.out.println("查询出票状态成功=====");
			reply.Status=StatusEnum.Success;
		}else{
			reply.Status=StatusEnum.Failure;
		}
		reply.ErrorCode=mtxReply.getGetOrderStatusResult().getResultCode();
		return reply;
	}
	//退票
	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSRefundTicketReply reply=new CTMSRefundTicketReply();
		MtxBackTicketResult mtxBackTicketReply=mtxService.BackTicket(userCinema, order);
		System.out.println("退票返回："+new Gson().toJson(mtxBackTicketReply));
		if("0".equals(mtxBackTicketReply.getBackTicketResult().getResultCode())){
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
			order.getOrderBaseInfo().setRefundTime(new Date());
			reply.Status=StatusEnum.Success;
			System.out.println("退票成功=====");
		}else{
			System.out.println("退票失败==============");
			reply.Status=StatusEnum.Failure;
		}
		reply.ErrorCode=mtxBackTicketReply.getBackTicketResult().getResultCode();
		return reply;
	}
	//查询订单信息
	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryOrderReply reply=new CTMSQueryOrderReply();
		MtxGetOrderStatusResult mtxReply=mtxService.GetOrderStatus(userCinema, order);
		System.out.println("查询订单信息返回："+new Gson().toJson(mtxReply));
		if("0".equals(mtxReply.getGetOrderStatusResult().getResultCode()) 
	&& ("7".equals(mtxReply.getGetOrderStatusResult().getOrderStatus()) ||
	"8".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())|| "9".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())))
		{
			if("7".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())){
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
				order.getOrderBaseInfo().setRefundTime(new Date());
			}else{ //不管是8：已打票还是9：地面售票成功都代表影院已成功确认订单
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
				if( "8".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())){
					order.getOrderBaseInfo().setPrintStatus(1);
					order.getOrderBaseInfo().setPrintTime(new Date());   //无法获知取票时间，默认当前时间
				}
			}
			QueryTicket(userCinema,order);  //调一下获取影票信息接口以便获取影票编码等信息
			reply.Status=StatusEnum.Success;
			reply.ErrorCode=mtxReply.getGetOrderStatusResult().getResultCode();
			System.out.println("查询订单信息成功======================================");
		}else{
			reply.Status=StatusEnum.Failure;
			reply.ErrorCode="-1";
			reply.ErrorMessage="影院出票还未成功";
			System.out.println("查询订单信息失败=========================================");
		}
		reply.ErrorCode=mtxReply.getGetOrderStatusResult().getResultCode();
		return reply;
	}
	//查询影票信息
	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryTicketReply reply=new CTMSQueryTicketReply();
		MtxAppPrintTicketResult mtxReply=mtxService.AppPrintTicket(userCinema, order, "0");
		System.out.println("查询影票信息返回："+new Gson().toJson(mtxReply));
		Date newDate=new Date();
		String st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getSessionTime());
		Date dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(st);
		if(newDate.getTime() > (dd.getTime()+1000*60*60*2)){
			 reply.Status = StatusEnum.Success;
             reply.ErrorCode = "0";
			System.out.println("2222222222222");
		}
        else{
		if("0".equals(mtxReply.getAppPrintTicketResult().getResultCode())){
			if("1".equals(mtxReply.getAppPrintTicketResult().getPrintType())){	//打印类型0：未打印 1：已打印
				order.getOrderBaseInfo().setPrintStatus(1);
				order.getOrderBaseInfo().setPrintTime(new Date());
			} else {
				order.getOrderBaseInfo().setPrintStatus(0);
			}
			if(mtxReply.getAppPrintTicketResult().getSeatInfos()!=null && mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo()!=null
					&& mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().size()>0){
				
				for(int i=0;i<mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().size();i++){
					if(order.getOrderSeatDetails().get(i).getColumnNum().equals(mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().get(i).getSeatCol())
							&&order.getOrderSeatDetails().get(i).getRowNum().equals(mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().get(i).getSeatRow())) {
						
							order.getOrderSeatDetails().get(i).setTicketInfoCode(mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().get(i).getTicketNo());
							order.getOrderSeatDetails().get(i).setFilmTicketCode(mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().get(i).getTicketNo2());
							order.getOrderSeatDetails().get(i).setPrintFlag(Integer.valueOf((mtxReply.getAppPrintTicketResult().getPrintType())));
					}
				}
			}
			System.out.println("当前时间="+newDate);
			System.out.println("开始时间往前推两个小时时间="+dd);
			System.out.println("查询影票信息成功=====");
			reply.Status=StatusEnum.Success;
		}else{
			System.out.println("查询影票信息失败=====");
			reply.Status=StatusEnum.Failure;
		}
        
        }
        System.out.println("111111111");
		reply.ErrorCode=mtxReply.getAppPrintTicketResult().getResultCode();
		return reply;
	}
	//确认出票
	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSFetchTicketReply reply=new CTMSFetchTicketReply();
		MtxAppPrintTicketResult mtxReply=mtxService.AppPrintTicket(userCinema, order,"1");
		System.out.println("确认出票返回："+new Gson().toJson(mtxReply));
		Date newDate=new Date();
		String st = new SimpleDateFormat().format(order.getOrderBaseInfo().getSessionTime());
		Date dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(st);
		if(newDate.getTime() > (dd.getTime()+1000*60*60*2)){
			 reply.Status = StatusEnum.Success;
             reply.ErrorCode = "0";
			System.out.println("2222222222222");
		}
	        else{
		if("0".equals(mtxReply.getAppPrintTicketResult().getResultCode())){
			order.getOrderBaseInfo().setPrintStatus(1);
			order.getOrderBaseInfo().setPrintTime(new Date());
			System.out.println("确认出票当前时间="+newDate);
			System.out.println("确认出票开始时间往前推两个小时时间="+dd);
				System.out.println("确认出票成功===：");
			reply.Status=StatusEnum.Success;		
	}else{
		System.out.println("确认出票失败======：");
		reply.Status=StatusEnum.Failure;
	}
	        }
		 System.out.println("111111111");
		reply.ErrorCode=mtxReply.getAppPrintTicketResult().getResultCode();
		reply.ErrorMessage=mtxReply.getAppPrintTicketResult().getResultDesc();
		return reply;
	}
	public static void main(String[] args) {
		try {
			Date newDate = new Date();

			String s = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
			s += " 01:00:00";
			Date d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
			System.out.println("d1=" + d1);

			String t = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
			t += " 06:00:00";
			Date d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t);
			System.out.println("d2=" + d2);
			System.out.println(newDate);

			if (newDate.getTime() > d1.getTime() && newDate.getTime() < d2.getTime()) {

			}
			
			Date dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-04-18 19:05:00");
			if(newDate.getTime() > (dd.getTime()+1000*60*60*2)){
				System.out.println(2222);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
