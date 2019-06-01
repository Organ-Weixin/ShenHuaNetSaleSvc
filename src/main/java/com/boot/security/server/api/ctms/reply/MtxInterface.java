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
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.collections4.Get;
import org.xmlunit.util.Convert;

import com.boot.security.server.api.core.CreateGoodsOrderQueryXml;
import com.boot.security.server.api.core.ModelMapper;
import com.boot.security.server.api.core.SubmitGoodsOrderReply.SubmitGoodsOrderReplyOrder;
import com.boot.security.server.api.ctms.reply.MtxGetCardTraceRecordResult.ResBean.CardTraceRecordsBean.CardTraceRecordBean;
import com.boot.security.server.api.ctms.reply.MtxGetCardTypeResult.ResBean.MemberTypesBean.MemberTypeBean;
import com.boot.security.server.api.ctms.reply.MtxGetCinemaPlanResult.ResBean.CinemaPlansBean.CinemaPlanBean;
import com.boot.security.server.api.ctms.reply.MtxGetHallAllSeatResult.HallAllSeatBean;
import com.boot.security.server.api.ctms.reply.MtxGetHallResult.ResBean.HallsBean.HallBean;

import com.boot.security.server.api.ctms.reply.MtxGetPlanSiteStateResult.ResBean.PlanSiteStatesBean.PlanSiteStateBean;
import com.boot.security.server.api.ctms.reply.MtxGetSPInfosResult.GetSPInfosBean;
import com.boot.security.server.api.ctms.reply.MtxGetSPInfosResult.GetSPInfosBean.GetSPInfoBean;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.CardTradeRecord;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodscomponents;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.LoveFlagEnum;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;

import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.SessionSeat;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.MemberCardService;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.GoodscomponentsServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.JaxbXmlUtil;
import com.boot.security.server.utils.SpringUtil;
import com.google.gson.Gson;

import cn.cmts.main.webservice.WebService;
import cn.cmts.pay.webservice.Webservice;


public class MtxInterface implements ICTMSInterface {
	
	 private WebService mtxService;
	 CinemaServiceImpl _cinemaService=SpringUtil.getBean(CinemaServiceImpl.class);
	 ScreeninfoServiceImpl _screeninfoService=SpringUtil.getBean(ScreeninfoServiceImpl.class);
	 ScreenseatinfoServiceImpl _screenseatinfoService=SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	 SessioninfoServiceImpl  _sessioninfoService=SpringUtil.getBean(SessioninfoServiceImpl.class);
	 FilminfoServiceImpl _filminfoService=SpringUtil.getBean(FilminfoServiceImpl.class);
	 GoodsServiceImpl _goodsService=SpringUtil.getBean(GoodsServiceImpl.class);
	 GoodsOrderServiceImpl _goodsOrderService=SpringUtil.getBean(GoodsOrderServiceImpl.class);
	GoodscomponentsServiceImpl _goodscomponentsService=SpringUtil.getBean(GoodscomponentsServiceImpl.class);
	//会员卡
	 private Webservice mtxCardService;
	 MemberCardServiceImpl _memberCardService=SpringUtil.getBean(MemberCardServiceImpl.class);
	 MemberCardLevelServiceImpl _memberCardLevelService=SpringUtil.getBean(MemberCardLevelServiceImpl.class);
	// 查询影厅基本信息 
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		MtxGetHallResult mtxReply = mtxService.GetHall(userCinema);
		// System.out.println("开始执行操作-------------------"+ new
		// Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getGetHallResult().getResultCode())) {
			// 更新影厅信息
			List<Screeninfo> newScreens = new ArrayList<Screeninfo>();
			List<HallBean> hallBeans = mtxReply.getGetHallResult().getHalls().getHall();
			for (HallBean hallBean : hallBeans) {
				Screeninfo screen = new Screeninfo();// 创建实例
				MtxModelMapper.MapToEntity(hallBean, screen);
				screen.setCCode(userCinema.getCinemaCode());
				newScreens.add(screen);
			}
			// 先删除旧影影厅
			_screeninfoService.deleteByCinemaCode(userCinema.getCinemaCode());
			// 插入影厅信息
			for (Screeninfo screen : newScreens) {
				_screeninfoService.save(screen);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getGetHallResult().getResultCode();
		return reply;
	}
	//查询影厅座位信息
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
		CTMSQuerySeatReply reply = new CTMSQuerySeatReply();
		MtxGetHallAllSeatResult mtxReply = mtxService.GetHallAllSeat(userCinema, screen);
		// System.out.println("开始执行操作-------------------" + new
		if ("0".equals(mtxReply.getResultCode())) {
			// 更新影厅座位信息
			if (_screenseatinfoService.getByCinemaCodeAndScreenCode(userCinema.getCinemaCode(),
					screen.getSCode()) != null) {
				List<Screenseatinfo> newScreens = new ArrayList<Screenseatinfo>();
				List<HallAllSeatBean> hallAllSeatBeans = mtxReply.getHallSeats();
				for (HallAllSeatBean hallAllSeatBean : hallAllSeatBeans) {
					Screenseatinfo screenseat = new Screenseatinfo();// 创建实例
					MtxModelMapper.MapToEntity(hallAllSeatBean, screenseat);
					screenseat.setCinemaCode(userCinema.getCinemaCode());
					screenseat.setScreenCode(screen.getSCode());
					screenseat.setLoveFlag(LoveFlagEnum.Normal.getFlagCode());
					screenseat.setStatus(SessionSeatStatusEnum.Available.getStatusCode());
					newScreens.add(screenseat);
				}
				// 先删除旧影厅座位
				_screenseatinfoService.deleteByScreenCode(userCinema.getCinemaCode(), screen.getSCode());
				// 插入座位信息
				for (Screenseatinfo screenseat : newScreens) {
					_screenseatinfoService.save(screenseat);
				}
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getResultCode();
		return reply;
	}

	// 查询放映计划信息////排期
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate)
			throws Exception {
		CTMSQuerySessionReply reply = new CTMSQuerySessionReply();
		MtxGetCinemaPlanResult mtxReply = mtxService.GetCinemaPlan(userCinema, StartDate, EndDate);
		// System.out.println("开始执行查询排期操作-------------------"+ new
		// Gson().toJson(mtxReply));
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
		} else {
			if ("0".equals(mtxReply.getGetCinemaPlanResult().getResultCode())) {
				// 更新排期信息
				List<Sessioninfo> newSessions = new ArrayList<Sessioninfo>();
				List<CinemaPlanBean> cinemaPlanBeans = mtxReply.getGetCinemaPlanResult().getCinemaPlans()
						.getCinemaPlan();
				for (CinemaPlanBean cinemaPlanBean : cinemaPlanBeans) {
					Sessioninfo session = new Sessioninfo();// 创建实例
					MtxModelMapper.MapToEntity(cinemaPlanBean, session);
					session.setUserID(userCinema.getUserId());
					newSessions.add(session);
				}
				// 先删除旧排期信息
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("CCode", userCinema.getCinemaCode());
				params.put("UserId", userCinema.getUserId());
				params.put("StartTime", new SimpleDateFormat("yyyy-MM-dd").format(StartDate));
				_sessioninfoService.deleteByCinemaCode(params);
				// 插入排期信息
				int num = 0;
				for (Sessioninfo sessionInfo : newSessions) {
					_sessioninfoService.save(sessionInfo);
					num++;
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = mtxReply.getGetCinemaPlanResult().getResultCode();
		}
		return reply;
	}

	// 查询影片信息
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQueryFilmReply reply = new CTMSQueryFilmReply();
		// System.out.println("开始执行查询影片信息操作-------------------" + new
		// Gson().toJson(reply));
		// 从排期中获取影片接口
		QuerySession(userCinema, StartDate, EndDate);// 调用查询排期列表
		// 根据影片名称分组，去除影片重复数据
		List<Sessioninfo> sessions = _sessioninfoService.getByCCodeGroupByFilm(userCinema.getUserId(),
				userCinema.getCinemaCode(), StartDate, EndDate);
		List<Filminfo> films = new ArrayList<Filminfo>();
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
			} else if (filmlist.size() > 1) {
				for (Filminfo ffilminfo : filmlist) {
					if (ffilminfo.getPublishDate() != null || ffilminfo.getPublisher() != null
							|| ffilminfo.getProducer() != null || ffilminfo.getDirector() != null
							|| ffilminfo.getCast() != null || ffilminfo.getIntroduction() != null) {
						films.add(ffilminfo);
						break;
					} else {
						films.add(ffilminfo);
						break;
					}
				}
			} else {
				films.add(filmlist.get(0));
			}
		}
		reply.setFilms(films);
		reply.Status = StatusEnum.Success;
		return reply;
	}

	// 查询放映计划座位状态
	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,
			SessionSeatStatusEnum Status) throws Exception {
		CTMSQuerySessionSeatReply reply = new CTMSQuerySessionSeatReply();
		MtxGetPlanSiteStateResult mtxReply = mtxService.GetPlanSiteState(userCinema, SessionCode, Status);
		// System.out.println("开始执行查询排期座位操作-------------------"+ new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getGetPlanSiteStateResult().getResultCode())) {
			List<SessionSeat> newSessionSeat = new ArrayList<SessionSeat>();
			List<PlanSiteStateBean> planSiteStateBeans = mtxReply.getGetPlanSiteStateResult().getPlanSiteStates()
					.getPlanSiteState();
			for (PlanSiteStateBean planSiteStateBean : planSiteStateBeans) {
				SessionSeat sessionseats = new SessionSeat();
				sessionseats.setSeatCode(planSiteStateBean.getSeatNo());
				sessionseats.setRowNum(planSiteStateBean.getSeatRow());
				sessionseats.setColumnNum(planSiteStateBean.getSeatCol());
				String seatStatus = planSiteStateBean.getSeatState();
				if ("-1".equals(seatStatus)) { // 不可售
					sessionseats.setStatus(SessionSeatStatusEnum.Unavailable);
				} else if ("1".equals(seatStatus)) { // 已售
					sessionseats.setStatus(SessionSeatStatusEnum.Sold);
				} else if ("3".equals(seatStatus)) { // 预定
					sessionseats.setStatus(SessionSeatStatusEnum.Booked);
				} else if ("7".equals(seatStatus)) { // 已锁定
					sessionseats.setStatus(SessionSeatStatusEnum.Locked);
				} else { // 未售
					sessionseats.setStatus(SessionSeatStatusEnum.Available);
				}
				newSessionSeat.add(sessionseats);
			}
			List<SessionSeat> newseatlist = newSessionSeat;
			if (Status != SessionSeatStatusEnum.All) {
				newseatlist = newseatlist.stream().filter((SessionSeat ss) -> Status.equals(ss.getStatus()))
						.collect(Collectors.toList());
			}
			reply.setSessionSeats(newseatlist);
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getGetPlanSiteStateResult().getResultCode();
		return reply;
	}

	// 锁定座位
	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSLockSeatReply reply = new CTMSLockSeatReply();
		MtxLiveRealCheckSeatStateResult mtxReply = mtxService.LiveRealCheckSeatState(userCinema, order);
//		System.out.println("开始锁定座位操作-------------------" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getRealCheckSeatStateResult().getResultCode())) {
			Date newDate = new Date();
			order.getOrderBaseInfo().setLockOrderCode(mtxReply.getRealCheckSeatStateResult().getOrderNo());
			order.getOrderBaseInfo().setAutoUnlockDatetime(new Date(newDate.getTime() + 10 * 60 * 1000));// 满天星没有自动解锁时间返回，此处默认锁定10分钟
			order.getOrderBaseInfo().setLockTime(new Date());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Locked.getStatusCode());
			reply.Status = StatusEnum.Success;
		} else {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.LockFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(mtxReply.getRealCheckSeatStateResult().getResultCode());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getRealCheckSeatStateResult().getResultCode();
		return reply;
	}

	// 解锁座位
	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSReleaseSeatReply reply = new CTMSReleaseSeatReply();
		MtxUnLockOrderCenCinResult mtxUnLockReply = mtxService.UnLockOrderCenCin(userCinema, order);
//		System.out.println("开始解锁座位操作-------------------" + new Gson().toJson(mtxUnLockReply));
		if ("0".equals(mtxUnLockReply.getUnLockOrderCenCinResult().getResultCode())) {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Released.getStatusCode());
			reply.Status = StatusEnum.Success;
		} else {
			order.getOrderBaseInfo().setErrorMessage(mtxUnLockReply.getUnLockOrderCenCinResult().getResultCode());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.ReleaseFail.getStatusCode());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxUnLockReply.getUnLockOrderCenCinResult().getResultCode();
		return reply;
	}

	// 提交订单
	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSSubmitOrderReply reply = new CTMSSubmitOrderReply();
		MtxSellTicketResult mtxReply = mtxService.SellTicket(userCinema, order);
//		System.out.println("提交订单返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getSellTicketResult().getResultCode())) {
			Date newDate = new Date();
			order.getOrderBaseInfo().setSubmitOrderCode(mtxReply.getSellTicketResult().getOrderNo());
			order.getOrderBaseInfo().setPrintNo(mtxReply.getSellTicketResult().getOrderNo());
			order.getOrderBaseInfo().setVerifyCode(mtxReply.getSellTicketResult().getValidCode());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Submited.getStatusCode());
			order.getOrderBaseInfo().setSubmitTime(newDate);
			QueryOrder(userCinema, order);// 调用订单查询
			reply.Status = StatusEnum.Success;
		} else {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.SubmitFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(mtxReply.getSellTicketResult().getResultCode());
			reply.Status = StatusEnum.Failure;

		}
		reply.ErrorCode = mtxReply.getSellTicketResult().getResultCode();
		return reply;
	}

	// 查询出票状态
	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryPrintReply reply = new CTMSQueryPrintReply();
		MtxGetOrderStatusResult mtxReply = mtxService.GetOrderStatus(userCinema, order);
//		System.out.println("查询出票状态返回返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getGetOrderStatusResult().getResultCode())) {
			if ("8".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())) { // 8已打票
				order.getOrderBaseInfo().setPrintStatus(1);
				order.getOrderBaseInfo().setPrintTime(new Date()); // 无返回打印时间，取当前时间
			} else {
				order.getOrderBaseInfo().setPrintStatus(0);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getGetOrderStatusResult().getResultCode();
		return reply;
	}

	// 退票
	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSRefundTicketReply reply = new CTMSRefundTicketReply();
		MtxBackTicketResult mtxBackTicketReply = mtxService.BackTicket(userCinema, order);
//		System.out.println("退票返回：" + new Gson().toJson(mtxBackTicketReply));
		if ("0".equals(mtxBackTicketReply.getBackTicketResult().getResultCode())) {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
			order.getOrderBaseInfo().setRefundTime(new Date());
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxBackTicketReply.getBackTicketResult().getResultCode();
		return reply;
	}

	// 查询订单信息
	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryOrderReply reply = new CTMSQueryOrderReply();
		MtxGetOrderStatusResult mtxReply = mtxService.GetOrderStatus(userCinema, order);
//		System.out.println("查询订单信息返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getGetOrderStatusResult().getResultCode())
				&& ("7".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())
						|| "8".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())
						|| "9".equals(mtxReply.getGetOrderStatusResult().getOrderStatus()))) {
			if ("7".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())) {
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
				order.getOrderBaseInfo().setRefundTime(new Date());
			} else { // 不管是8：已打票还是9：地面售票成功都代表影院已成功确认订单
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
				if ("8".equals(mtxReply.getGetOrderStatusResult().getOrderStatus())) {
					order.getOrderBaseInfo().setPrintStatus(1);
					order.getOrderBaseInfo().setPrintTime(new Date()); // 无法获知取票时间，默认当前时间
				}
			}
			QueryTicket(userCinema, order); // 调一下获取影票信息接口以便获取影票编码等信息
			reply.Status = StatusEnum.Success;
			reply.ErrorCode = mtxReply.getGetOrderStatusResult().getResultCode();
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = "-1";
			reply.ErrorMessage = "影院出票还未成功";
		}
		reply.ErrorCode = mtxReply.getGetOrderStatusResult().getResultCode();
		return reply;
	}

	// 查询影票信息
	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSQueryTicketReply reply = new CTMSQueryTicketReply();
		MtxAppPrintTicketResult mtxReply = mtxService.AppPrintTicket(userCinema, order, "0");
//		System.out.println("查询影票信息返回：" + new Gson().toJson(mtxReply));
		Date newDate = new Date();
		String st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderBaseInfo().getSessionTime());
		Date dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(st);
		if (newDate.getTime() > (dd.getTime() + 1000 * 60 * 60 * 2)) {
			reply.Status = StatusEnum.Success;
			reply.ErrorCode = "0";
		} else {
			if ("0".equals(mtxReply.getAppPrintTicketResult().getResultCode())) {
				if ("1".equals(mtxReply.getAppPrintTicketResult().getPrintType())) { // 打印类型0：未打印
																						// 1：已打印
					order.getOrderBaseInfo().setPrintStatus(1);
					order.getOrderBaseInfo().setPrintTime(new Date());
				} else {
					order.getOrderBaseInfo().setPrintStatus(0);
				}
				if (mtxReply.getAppPrintTicketResult().getSeatInfos() != null
						&& mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo() != null
						&& mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().size() > 0) {

					for (int i = 0; i < mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().size(); i++) {
						if (order.getOrderSeatDetails().get(i).getColumnNum().equals(
								mtxReply.getAppPrintTicketResult().getSeatInfos().getSeatInfo().get(i).getSeatCol())
								&& order.getOrderSeatDetails().get(i).getRowNum().equals(mtxReply
										.getAppPrintTicketResult().getSeatInfos().getSeatInfo().get(i).getSeatRow())) {

							order.getOrderSeatDetails().get(i).setTicketInfoCode(mtxReply.getAppPrintTicketResult()
									.getSeatInfos().getSeatInfo().get(i).getTicketNo());
							order.getOrderSeatDetails().get(i).setFilmTicketCode(mtxReply.getAppPrintTicketResult()
									.getSeatInfos().getSeatInfo().get(i).getTicketNo2());
							order.getOrderSeatDetails().get(i)
									.setPrintFlag(Integer.valueOf((mtxReply.getAppPrintTicketResult().getPrintType())));
						}
					}
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}

		}
		reply.ErrorCode = mtxReply.getAppPrintTicketResult().getResultCode();
		return reply;
	}

	// 确认出票
	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSFetchTicketReply reply = new CTMSFetchTicketReply();
		MtxAppPrintTicketResult mtxReply = mtxService.AppPrintTicket(userCinema, order, "1");
		// System.out.println("确认出票返回：" + new Gson().toJson(mtxReply));
		Date newDate = new Date();
		String st = new SimpleDateFormat().format(order.getOrderBaseInfo().getSessionTime());
		Date dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(st);
		if (newDate.getTime() > (dd.getTime() + 1000 * 60 * 60 * 2)) {
			reply.Status = StatusEnum.Success;
			reply.ErrorCode = "0";
		} else {
			if ("0".equals(mtxReply.getAppPrintTicketResult().getResultCode())) {
				order.getOrderBaseInfo().setPrintStatus(1);
				order.getOrderBaseInfo().setPrintTime(new Date());
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
		}
		reply.ErrorCode = mtxReply.getAppPrintTicketResult().getResultCode();
		reply.ErrorMessage = mtxReply.getAppPrintTicketResult().getResultDesc();
		return reply;
	}

	// registerCard 带卡号的会员卡开户接口
	@Override
	public CTMSCardRegisterReply CardRegister(Usercinemaview userCinema, String CardPassword, String LevelCode,
			String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)
			throws Exception {
		CTMSCardRegisterReply reply = new CTMSCardRegisterReply();
		MtxRegisterCardResult mtxReply = mtxCardService.RegisterCard(userCinema, CardPassword, LevelCode, InitialAmount,
				CardUserName, MobilePhone, IDNumber, Sex);
		System.out.println("带卡号的会员卡开户接口返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getRegisterMemberReturn().getResultCode())) {
			Membercard mem=new Membercard();
			mem.setCinemaCode(userCinema.getCinemaCode());
			mem.setCardPassword(CardPassword);
			mem.setMobilePhone(MobilePhone);
			mem.setLevelCode(LevelCode);
			//mem.setBalance(Double.valueOf(InitialAmount));
			mem.setUserName(CardUserName);
			mem.setSex(Sex);
			mem.setCreditNum(IDNumber);
			mem.setCreateTime(new Date());
			_memberCardService.Save(mem);
			reply.setCardNo(mtxReply.getRegisterMemberReturn().getAccountNo());
			reply.setBalance(Float.valueOf(InitialAmount));
			reply.setCreateTime(new Date());
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getRegisterMemberReturn().getResultCode();
		reply.ErrorMessage = mtxReply.getRegisterMemberReturn().getResultMsg();
		return reply;
	}

	// loginCard会员卡登录接口
	@Override
	public CTMSLoginCardReply LoginCard(Usercinemaview userCinema, String CardNo, String CardPassword)
			throws Exception {
		CTMSLoginCardReply reply = new CTMSLoginCardReply();
		MtxLoginCardResult mtxReply = mtxCardService.LoginCard(userCinema, CardNo, CardPassword);
		System.out.println("会员卡登录接口返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getLoginCardReturn().getResultCode())) {
			// 添加会员卡信息
			Membercard memcard = _memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
			if (memcard == null) {
				Membercard mem = new Membercard();
				mem.setCinemaCode(userCinema.getCinemaCode());
				mem.setCardNo(mtxReply.getLoginCardReturn().getCardId());
				mem.setCardPassword(CardPassword);
				mem.setMobilePhone(mtxReply.getLoginCardReturn().getPhoneNumber());
				mem.setLevelCode(mtxReply.getLoginCardReturn().getAccLevelCode());
				mem.setLevelName(mtxReply.getLoginCardReturn().getAccLevelName());
				mem.setScore(Integer.valueOf(mtxReply.getLoginCardReturn().getAccIntegral()));
				mem.setBalance(Double.valueOf(mtxReply.getLoginCardReturn().getAccBalance()));
				mem.setUserName(mtxReply.getLoginCardReturn().getMemberName());
				mem.setSex(mtxReply.getLoginCardReturn().getSex());
				mem.setCreditNum(mtxReply.getLoginCardReturn().getIdNnumber());
				mem.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getLoginCardReturn().getBirthday()));
				mem.setExpireDate(
						new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getLoginCardReturn().getExpirationTime()));
				mem.setCreateTime(new Date());
				mem.setStatus(Integer.valueOf(mtxReply.getLoginCardReturn().getAccStatus()));
				// 插入保存
				_memberCardService.Save(mem);
			}else{
				memcard.setUpdated(new Date());
				_memberCardService.Update(memcard);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getLoginCardReturn().getResultCode();
		reply.ErrorMessage = mtxReply.getLoginCardReturn().getResultCode();
		return reply;
	}

	// queryCard 查询会员卡账户信息
	@Override
	public CTMSQueryCardReply QueryCard(Usercinemaview userCinema, String CardNo, String CardPassword)
			throws Exception {
		CTMSQueryCardReply reply = new CTMSQueryCardReply();
		MtxQueryCardResult mtxReply = mtxCardService.QueryCard(userCinema, CardNo, CardPassword);
//		System.out.println("查询会员卡账户信息返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getQueryCardReturn().getResultCode())) {
			// 修改会员卡信息
			Membercard memcard = _memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
			if (memcard != null) {// Score string 账户积分
				memcard.setScore(
						Integer.valueOf((int) Math.round(Double.valueOf(mtxReply.getQueryCardReturn().getScore()))));
				memcard.setBalance(Double.valueOf(mtxReply.getQueryCardReturn().getAccBalance()));
				memcard.setUserName(mtxReply.getQueryCardReturn().getConnectName());
				memcard.setSex(mtxReply.getQueryCardReturn().getSex());
				memcard.setCreditNum(mtxReply.getQueryCardReturn().getIdNum());
				if (mtxReply.getQueryCardReturn().getBirthDay() != null) {
					memcard.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(mtxReply.getQueryCardReturn().getBirthDay()));
				}
				// 更新
				_memberCardService.Update(memcard);
			} else {
				Membercard memcard1 = new Membercard();
				memcard1.setCinemaCode(userCinema.getCinemaCode());
				memcard1.setCardNo(CardNo);
				memcard1.setCardPassword(CardPassword);
				memcard1.setMobilePhone(mtxReply.getQueryCardReturn().getMobilePhone());
				memcard1.setLevelCode(mtxReply.getQueryCardReturn().getAccLevelCode());
				memcard1.setLevelName(mtxReply.getQueryCardReturn().getAccLevelName());
				memcard1.setScore(
						Integer.valueOf((int) Math.round(Double.valueOf(mtxReply.getQueryCardReturn().getScore()))));
				memcard1.setBalance(Double.valueOf(mtxReply.getQueryCardReturn().getAccBalance()));
				memcard1.setUserName(mtxReply.getQueryCardReturn().getConnectName());
				memcard1.setSex(mtxReply.getQueryCardReturn().getSex());
				memcard1.setCreditNum(mtxReply.getQueryCardReturn().getIdNum());
				memcard1.setStatus(0);
				if (mtxReply.getQueryCardReturn().getBirthDay() != null) {
					memcard1.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(mtxReply.getQueryCardReturn().getBirthDay()));
				}
				// 添加
				_memberCardService.Save(memcard1);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getQueryCardReturn().getResultCode();
		reply.ErrorMessage = mtxReply.getQueryCardReturn().getResultMsg();
		return reply;
	}

	/// getDiscount 折扣查询
	@Override
	public CTMSQueryDiscountReply QueryDiscount(Usercinemaview userCinema, String TicketCount, String CardNo,
			String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
			String ScreenType, String ListingPrice, String LowestPrice) throws Exception {
		CTMSQueryDiscountReply reply = new CTMSQueryDiscountReply();
		MtxGetDiscountResult mtxReply = mtxCardService.GetDiscount(userCinema, TicketCount, CardNo, CardPassword,
				LevelCode, SessionCode, SessionTime, FilmCode, ScreenType, ListingPrice, LowestPrice);
		// System.out.println("折扣查询返回："+new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getGetDiscountReturn().getResultCode())) {
			reply.setCinemaCode(userCinema.getCinemaCode());
			reply.setDiscountType(Integer.valueOf(mtxReply.getGetDiscountReturn().getDiscountType()));
			reply.setPrice(Float.valueOf(mtxReply.getGetDiscountReturn().getPrice()));
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getGetDiscountReturn().getResultCode();
		reply.ErrorMessage = mtxReply.getGetDiscountReturn().getResultMsg();
		return reply;
	}

	// serialCardPay会员卡支付（流水号必传）、预算接口
	@Override
	public CTMSCardPayReply CardPay(Usercinemaview userCinema, String CardNo, String CardPassword, float PayAmount,
			String SessionCode, String FilmCode, String TicketNum) throws Exception {
		CTMSCardPayReply reply = new CTMSCardPayReply();
		MtxSerialCardPayResult mtxReply = mtxCardService.SerialCardPay(userCinema, CardNo, CardPassword, PayAmount,
				SessionCode, FilmCode, TicketNum);
		// System.out.println("会员卡支付（流水号必传）、预算接口返回2222222："+new
		// Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getResultCode())) {
			reply.setTradeNo(mtxReply.getGroundTradeNo());
			reply.setDeductAmount(Float.valueOf(mtxReply.getDeductMoney()));

			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getResultCode();
		reply.ErrorMessage = mtxReply.getResultMsg();
		return reply;
	}

	// serialCardPayBack会员卡冲费（撤销）接口（流水号必传）
	@Override
	public CTMSCardPayBackReply CardPayBack(Usercinemaview userCinema, String CardNo, String CardPassword,
			String TradeNo, float PayBackAmount) throws Exception {
		CTMSCardPayBackReply reply = new CTMSCardPayBackReply();
		MtxSerialCardPayBackResult mtxReply = mtxCardService.SerialCardPayBack(userCinema, CardNo, CardPassword,
				TradeNo, PayBackAmount);
//		System.out.println("会员卡冲费（撤销）接口（流水号必传）返回222：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getResultCode())) {
			reply.setTradeNo(mtxReply.getTraceNoCenter());

			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getResultCode();
		reply.ErrorMessage = mtxReply.getResultMsg();
		return reply;
	}

	// getCardTraceRecord查询会员卡交易记录接口
	@Override
	public CTMSQueryCardTradeRecordReply QueryCardTradeRecord(Usercinemaview userCinema, String CardNo,
			String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum) throws Exception {
		CTMSQueryCardTradeRecordReply reply = new CTMSQueryCardTradeRecordReply();
		MtxGetCardTraceRecordResult mtxReply = mtxCardService.GetCardTraceRecord(userCinema, CardNo, CardPassword,
				StartDate, EndDate, PageSize, PageNum);
//		System.out.println("查询会员卡交易记录接口返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getGetCardTraceRecordReturn().getResultCode())) {
			List<CardTradeRecord> cardTR = new ArrayList<CardTradeRecord>();
			List<CardTraceRecordBean> cardTraceRecords = mtxReply.getGetCardTraceRecordReturn().getCardTraceRecords()
					.getCardTraceRecord();
			reply.setCardTradeRecords(cardTR);
			for (CardTraceRecordBean cardTraceRecord : cardTraceRecords) {
				CardTradeRecord ctr = new CardTradeRecord();
				ctr.setTradeNo(cardTraceRecord.getTraceNo());
				ctr.setTradeType(cardTraceRecord.getTraceTypeNo());
				ctr.setTradeTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(cardTraceRecord.getTraceDate() + " " + cardTraceRecord.getTraceTime())));
System.out.println("测试"+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(cardTraceRecord.getTraceDate() + " " + cardTraceRecord.getTraceTime())));
				ctr.setTradePrice(Float.valueOf(cardTraceRecord.getPrice()));
				ctr.setCinemaName(cardTraceRecord.getCinemaName());
				cardTR.add(ctr);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getGetCardTraceRecordReturn().getResultCode();
		reply.ErrorMessage = mtxReply.getGetCardTraceRecordReturn().getResultMsg();
		return reply;
	}

	// serialCardRecharge会员卡充值接口（流水号必传）
	@Override
	public CTMSCardChargeReply CardCharge(Usercinemaview userCinema, String CardNo, String CardPassword,
			CardChargeTypeEnum ChargeType, float ChargeAmount) throws Exception {
		CTMSCardChargeReply reply = new CTMSCardChargeReply();
		MtxSerialCardRechargeResult mtxReply = mtxCardService.SerialCardRecharge(userCinema, CardNo, CardPassword,
				ChargeType, ChargeAmount);
//		System.out.println("会员卡充值接口返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getResultCode())) {
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getResultCode();
		reply.ErrorMessage = mtxReply.getResultMsg();
		return reply;
	}

	// getCardType获取影院会员卡级别接口
	@Override
	public CTMSQueryCardLevelReply QueryCardLevel(Usercinemaview userCinema) throws Exception {
		CTMSQueryCardLevelReply reply = new CTMSQueryCardLevelReply();
		MtxGetCardTypeResult mtxReply = mtxCardService.GetCardType(userCinema);
		// System.out.println("获取影院会员卡级别接口返回："+new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getGetCardTypeReturn().getResultCode())) {
			List<Membercardlevel> membercardlevel = new ArrayList<Membercardlevel>();
			List<MemberTypeBean> memberTypeBeans = mtxReply.getGetCardTypeReturn().getMemberTypes().getMemberType();
			for (MemberTypeBean memberTypeBean : memberTypeBeans) {
				Membercardlevel mem = new Membercardlevel();
				MtxModelMapper.MapToEntity(memberTypeBean, mem);
				mem.setLevelCode(memberTypeBean.getMemberType());
				mem.setCinemaCode(userCinema.getCinemaCode());
				membercardlevel.add(mem);
				if(membercardlevel==null){
					mem.setStatus(0);
					_memberCardLevelService.Save(mem);
				}else{
					_memberCardLevelService.update(mem);
				}
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getGetCardTypeReturn().getResultCode();
		reply.ErrorMessage = mtxReply.getGetCardTypeReturn().getResultMsg();
		return reply;
	}
	//卖品------获取卖品
		@Override
		public CTMSQueryGoodsReply QueryGoods(Usercinemaview userCinema) throws Exception {
			CTMSQueryGoodsReply reply = new CTMSQueryGoodsReply();
			MtxGetSPInfosResult mtxReply = mtxService.GetSPInfos(userCinema);
//			System.out.println("获取影院卖品信息返回：" + new Gson().toJson(mtxReply));
			if ("0".equals(mtxReply.getResultCode())) {
				List<Goods> goods = new ArrayList<Goods>();
				List<GetSPInfosBean> getSPInfosBeans = mtxReply.getSpinfos();
				for (GetSPInfosBean getSPInfosBean : getSPInfosBeans) {
					Goods goo = new Goods();
					goo.setCinemaCode(userCinema.getCinemaCode());
					goo.setUserId(userCinema.getUserId());
					goo.setGoodsCode(getSPInfosBean.getSpno());
					goo.setGoodsName(getSPInfosBean.getSpname());
					if (getSPInfosBean.getSptype() != null) {
						goo.setGoodsType(getSPInfosBean.getSptype());
					}
					if (getSPInfosBean.getSellprice() != null) {
						goo.setStandardPrice(Double.valueOf(getSPInfosBean.getSellprice()));
					}
					if (getSPInfosBean.getSellprice() != null) {
						goo.setSettlePrice(Double.valueOf(getSPInfosBean.getSellprice()));
					}
					//goo.setGoodsPic();//没有卖品图片
					goo.setStockCount(999);//库存给定100
					goo.setGoodsDesc(getSPInfosBean.getInfo());//卖品描述
					goo.setShowSeqNo(0);//展示顺序 默认0
					goo.setUnitName(getSPInfosBean.getUnitname());//卖品单位
					goo.setIsDiscount(0);//是否享受会员卡优惠，1是；0 否 默认0
					goo.setGoodsStatus(0);//卖品状态 
					goo.setIsRecommand(0);//是否推荐  默认0
					goo.setUpdated(new Date());//更新时间
					if (getSPInfosBean.getComponents() != null && getSPInfosBean.getComponents().size() > 0) {
//						System.err.println("获取到套餐，套餐:"+getSPInfosBean.getComponents());
						goo.setIsPackage(1);//是否套餐，1套餐
							List<GetSPInfosBean.GetSPInfoBean> getSPInfoBeans=getSPInfosBean.getComponents();
							for(GetSPInfoBean getSPInfoBean:getSPInfoBeans){
								Goodscomponents gcs=new Goodscomponents();
								gcs.setCinemaCode(userCinema.getCinemaCode());
								gcs.setPackageCode(getSPInfosBean.getSpno());
								gcs.setPackageName(getSPInfosBean.getSpname());
								gcs.setGoodsCode(getSPInfoBean.getSpno());
								gcs.setGoodsName(getSPInfoBean.getSpname());
								gcs.setGoodsCount(getSPInfoBean.getCount());
								if(getSPInfosBean.getSellprice()!=null){
								gcs.setGoodsStandardPrice(Double.valueOf(getSPInfosBean.getSellprice()));
								}
								if(getSPInfosBean.getSellprice()!=null){
								gcs.setPackageSettlePrice(Double.valueOf(getSPInfosBean.getSellprice())*Double.valueOf(getSPInfoBean.getCount()));
								}
								gcs.setStatus(1);
								gcs.setUnitName(getSPInfoBean.getUnitname());
								if(_goodscomponentsService.getByGoodsCode(getSPInfoBean.getSpno())==null){
									_goodscomponentsService.save(gcs);
								}else{
									_goodscomponentsService.update(gcs);
								}
							}

					} else {
						goo.setIsPackage(0);//是否套餐，0非套餐
					}
					if (_goodsService.getByCinemaCodeAndGoodsCode(userCinema.getCinemaCode(),
							getSPInfosBean.getSpno()) == null) {
						_goodsService.save(goo);
//						System.out.println("插入卖品信息");
					} else {
						_goodsService.update(goo);
//						System.out.println("更新卖品信息");
					}
				}
				
				reply.Status = StatusEnum.Success;
//				System.out.println("更新成功");
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = mtxReply.getResultCode();
			reply.ErrorMessage = mtxReply.getResultmsg();
			return reply;
		}
		
		
		//创建卖品订单
	@Override
	public CTMSCreateGoodsOrderReply CreateGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
			throws Exception {
		CTMSCreateGoodsOrderReply reply = new CTMSCreateGoodsOrderReply();
		reply.setOrderCode(order.getOrderBaseInfo().getLocalOrderCode());
		reply.Status = StatusEnum.Success;
		return reply;
	}
	//提交卖品订单
	@Override
	public CTMSSubmitGoodsOrderReply SubmitGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
			throws Exception {
		CTMSSubmitGoodsOrderReply reply=new CTMSSubmitGoodsOrderReply();
		MtxConfirmSPInfoResult mtxReply=mtxService.ConfirmSPInfo(userCinema, order);
//		System.out.println("提交卖品接口返回：" + new Gson().toJson(mtxReply));
		if("0".equals(mtxReply.getResultCode())){
			order.getOrderBaseInfo().setOrderCode(mtxReply.getOrderNo());
			order.getOrderBaseInfo().setPickUpCode(mtxReply.getValidCode());
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Complete.getStatusCode());
			reply.Status = StatusEnum.Success;
//			System.out.println("提交卖品接口成功");
		}else{
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.SubmitFail.getStatusCode());
			reply.Status=StatusEnum.Failure;
//			System.out.println("提交卖品接口失败");
		}
		reply.ErrorCode=mtxReply.getResultCode();
		return reply;
	}
	//查询卖品订单
	@Override
	public CTMSQueryGoodsOrderReply QueryGoodsOrder(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
		CTMSQueryGoodsOrderReply reply=new CTMSQueryGoodsOrderReply();
		reply.Status=StatusEnum.Success;
		return reply;
	}
	//BackSellGoods退卖品
	@Override
	public CTMSRefundGoodsReply RefundGoods(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
		CTMSRefundGoodsReply reply=new CTMSRefundGoodsReply();
		MtxBackSellGoodsResult mtxReply=mtxService.BackSellGoods(userCinema, order);
		System.out.println("退卖品接口返回：" + new Gson().toJson(mtxReply));
		if("0".equals(mtxReply.getBackSellGoodsResult().getResultCode())){
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Refund.getStatusCode());
			order.getOrderBaseInfo().setRefundTime(new Date());
			reply.Status=StatusEnum.Success;
		}else{
			reply.Status=StatusEnum.Failure;
		}
		reply.ErrorCode=mtxReply.getBackSellGoodsResult().getResultCode();
		return reply;
	}
	@Override
	public CTMSSubmitMixOrderReply SubmitMixOrder(Usercinemaview userCinema, OrderView order, GoodsOrderView goodsorder)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
