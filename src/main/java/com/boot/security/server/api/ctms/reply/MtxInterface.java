package com.boot.security.server.api.ctms.reply;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

import com.alibaba.fastjson.JSONObject;
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
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodscomponents;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Goodstype;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.Membercardrecharge;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.SessionSeat;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.GoodsTypeServiceImpl;
import com.boot.security.server.service.impl.GoodscomponentsServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.MembercardrechargeServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.SpringUtil;

import cn.cmts.main.webservice.WebService;
import cn.cmts.pay.webservice.Webservice;

public class MtxInterface implements ICTMSInterface {
	
	CinemaServiceImpl _cinemaService=SpringUtil.getBean(CinemaServiceImpl.class);
	ScreeninfoServiceImpl _screeninfoService=SpringUtil.getBean(ScreeninfoServiceImpl.class);
	ScreenseatinfoServiceImpl _screenseatinfoService=SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	SessioninfoServiceImpl  _sessioninfoService=SpringUtil.getBean(SessioninfoServiceImpl.class);
	FilminfoServiceImpl _filminfoService=SpringUtil.getBean(FilminfoServiceImpl.class);
	GoodsServiceImpl _goodsService=SpringUtil.getBean(GoodsServiceImpl.class);
	GoodsOrderServiceImpl _goodsOrderService=SpringUtil.getBean(GoodsOrderServiceImpl.class);
	GoodscomponentsServiceImpl _goodscomponentsService=SpringUtil.getBean(GoodscomponentsServiceImpl.class);
	GoodsTypeServiceImpl _goodsTypeService = SpringUtil.getBean(GoodsTypeServiceImpl.class);
	CinemaMiniProgramAccountsServiceImpl _cinemaMiniProgramAccountsService = SpringUtil.getBean(CinemaMiniProgramAccountsServiceImpl.class);
	CouponsServiceImpl _couponsService = SpringUtil.getBean(CouponsServiceImpl.class);
	//会员卡
	MemberCardServiceImpl _memberCardService=SpringUtil.getBean(MemberCardServiceImpl.class);
	MemberCardLevelServiceImpl _memberCardLevelService=SpringUtil.getBean(MemberCardLevelServiceImpl.class);
	MembercardrechargeServiceImpl _membercardrechargeService = SpringUtil.getBean(MembercardrechargeServiceImpl.class);
	
	//region 查询影厅基本信息 (完成)
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		MtxGetHallResult mtxReply = WebService.GetHall(userCinema);
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
	//endregion
	
	//region 查询影厅座位信息(完成)
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
		CTMSQuerySeatReply reply = new CTMSQuerySeatReply();
		MtxGetHallAllSeatResult mtxReply = WebService.GetHallAllSeat(userCinema, screen);
		if ("0".equals(mtxReply.getResultCode())) {
			// 更新影厅座位信息
			List<Screenseatinfo> newScreens = new ArrayList<Screenseatinfo>();
			List<HallAllSeatBean> hallAllSeatBeans = mtxReply.getHallSeats();
			for (HallAllSeatBean hallAllSeatBean : hallAllSeatBeans) {
				Screenseatinfo screenseat = new Screenseatinfo();// 创建实例
				MtxModelMapper.MapToEntity(hallAllSeatBean, screenseat);
				screenseat.setCinemaCode(userCinema.getCinemaCode());
				screenseat.setScreenCode(screen.getSCode());
				screenseat.setStatus(SessionSeatStatusEnum.Available.getStatusCode());
				newScreens.add(screenseat);
			}
			// 先删除旧影厅座位
			_screenseatinfoService.deleteByScreenCode(userCinema.getCinemaCode(), screen.getSCode());
			// 插入座位信息
			for (Screenseatinfo screenseat : newScreens) {
				_screenseatinfoService.save(screenseat);
			}
			
			screen.setSeatCount(hallAllSeatBeans.size());
			_screeninfoService.update(screen);	//更新影厅表的座位数
			
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = mtxReply.getResultCode();
		return reply;
	}
	//endregion

	//region 查询放映计划信息(完成)
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate)
			throws Exception {
		CTMSQuerySessionReply reply = new CTMSQuerySessionReply();
		MtxGetCinemaPlanResult mtxReply = WebService.GetCinemaPlan(userCinema);
		Date newDate = new Date();
		String s = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
		s += " 01:00:00";
		Date d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
		
		String t = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
		t += " 06:00:00";
		Date d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t);
		
		if (newDate.getTime() > d1.getTime() && newDate.getTime() < d2.getTime()) {
			reply.Status = StatusEnum.Success;
			reply.ErrorCode = "0";
		} else {
			if ("0".equals(mtxReply.getGetCinemaPlanResult().getResultCode())) {
				// 更新排期信息
				List<Sessioninfo> newSessions = new ArrayList<Sessioninfo>();
				List<CinemaPlanBean> cinemaPlanBeans = mtxReply.getGetCinemaPlanResult().getCinemaPlans().getCinemaPlan();
				for (CinemaPlanBean cinemaPlanBean : cinemaPlanBeans) {
					Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cinemaPlanBean.getFeatureDate() + " " + cinemaPlanBean.getFeatureTime());
					Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(cinemaPlanBean.getFeatureDate() + " " + cinemaPlanBean.getTotalTime());
					if(startTime.getTime() > StartDate.getTime() && startTime.getTime() < EndDate.getTime() 
							&& ("0".equals(cinemaPlanBean.getUseSign()) || "1".equals(cinemaPlanBean.getUseSign()))
							&& ("1".equals(cinemaPlanBean.getSetClose()) || "2".equals(cinemaPlanBean.getSetClose()))){
						Sessioninfo session = new Sessioninfo();// 创建实例
						MtxModelMapper.MapToEntity(cinemaPlanBean, session);
						session.setStartTime(startTime);
						long num = endTime.getTime()-startTime.getTime();
						if(num > 0){
							session.setDuration((int)num/1000/60);
						} else {
							session.setDuration((int)num/1000/60+60*24);
						}
						session.setUserID(userCinema.getUserId());
						newSessions.add(session);
					}
				}
				// 先删除旧排期信息
				_sessioninfoService.deleteByCinemaCodeAndDate(userCinema.getUserId(), userCinema.getCinemaCode(), StartDate, EndDate);
				// 插入排期信息
				for (Sessioninfo sessionInfo : newSessions) {
					_sessioninfoService.save(sessionInfo);
				}
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = mtxReply.getGetCinemaPlanResult().getResultCode();
		}
		return reply;
	}
	//endregion

	//region 查询影片信息(完成)
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		CTMSQueryFilmReply reply = new CTMSQueryFilmReply();
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
	//endregion

	//region 查询放映计划座位状态(完成)
	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,
			SessionSeatStatusEnum Status) throws Exception {
		CTMSQuerySessionSeatReply reply = new CTMSQuerySessionSeatReply();
		MtxGetPlanSiteStateResult mtxReply = WebService.GetPlanSiteState(userCinema, SessionCode, Status);
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
	//endregion

	//region 锁定座位(完成)
	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSLockSeatReply reply = new CTMSLockSeatReply();
		MtxLiveRealCheckSeatStateResult mtxReply = WebService.LiveRealCheckSeatState(userCinema, order);
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
	//endregion

	//region 解锁座位(完成)
	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSReleaseSeatReply reply = new CTMSReleaseSeatReply();
		MtxUnLockOrderCenCinResult mtxUnLockReply = WebService.UnLockOrderCenCin(userCinema, order);
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
	//endregion

	// 提交订单
	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		CTMSSubmitOrderReply reply = new CTMSSubmitOrderReply();
		MtxSellTicketResult mtxReply = WebService.SellTicket(userCinema, order);
		if ("0".equals(mtxReply.getSellTicketResult().getResultCode())) {
			Date newDate = new Date();
			order.getOrderBaseInfo().setSubmitOrderCode(mtxReply.getSellTicketResult().getOrderNo());
			order.getOrderBaseInfo().setVerifyCode(mtxReply.getSellTicketResult().getValidCode());
			//PrintNo(满天星订单号，长度不定，目前为9位) + VerifyCode（验证码，6位）
			order.getOrderBaseInfo().setPrintNo(mtxReply.getSellTicketResult().getOrderNo() + mtxReply.getSellTicketResult().getValidCode());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Submited.getStatusCode());
			order.getOrderBaseInfo().setSubmitTime(newDate);
			order.getOrderBaseInfo().setPayTime(newDate);
			
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
		MtxGetOrderStatusResult mtxReply = WebService.GetOrderStatus(userCinema, order);
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
		MtxBackTicketResult mtxBackTicketReply = WebService.BackTicket(userCinema, order);
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
		MtxGetOrderStatusResult mtxReply = WebService.GetOrderStatus(userCinema, order);
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
		MtxAppPrintTicketResult mtxReply = WebService.AppPrintTicket(userCinema, order, "0");
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
		MtxAppPrintTicketResult mtxReply = WebService.AppPrintTicket(userCinema, order, "1");
		Date newDate = new Date();
		if (newDate.getTime() > (order.getOrderBaseInfo().getSessionTime().getTime() + 1000 * 60 * 60 * 2)) {
			reply.Status = StatusEnum.Success;
			reply.ErrorCode = "0";
		} else {
			if ("0".equals(mtxReply.getAppPrintTicketResult().getResultCode())) {
				order.getOrderBaseInfo().setPrintStatus(1);
				order.getOrderBaseInfo().setPrintTime(newDate);
				reply.Status = StatusEnum.Success;
			} else {
				reply.Status = StatusEnum.Failure;
			}
			reply.ErrorCode = mtxReply.getAppPrintTicketResult().getResultCode();
			reply.ErrorMessage = mtxReply.getAppPrintTicketResult().getResultDesc();
		}
		
		return reply;
	}

	// registerCard 带卡号的会员卡开户接口
	@Override
	public CTMSCardRegisterReply CardRegister(Usercinemaview userCinema, String CardPassword, String LevelCode,
			String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)
			throws Exception {
		CTMSCardRegisterReply reply = new CTMSCardRegisterReply();
		String num = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String cardNo = num + RandomStringUtils.randomNumeric(8);// 卡号(最大长度16位)
		int amount = (int) Math.round(Double.valueOf(InitialAmount));
		MtxRegisterCardResult mtxReply = Webservice.RegisterCard(userCinema, cardNo, CardPassword, LevelCode, String.valueOf(amount),
				CardUserName, MobilePhone, IDNumber, Sex);
		if ("0".equals(mtxReply.getRegisterMemberReturn().getResultCode())) {
			Cinema cinema = _cinemaService.getByCinemaCode(userCinema.getCinemaCode());
			String cinemacodes = "";
			if(cinema!=null&&cinema.getIsGeneralStore()==1){
				CinemaMiniProgramAccounts cinemaMiniProgramAccounts = _cinemaMiniProgramAccountsService.getByCinemaCode(userCinema.getCinemaCode());
		    	if(cinemaMiniProgramAccounts!=null){
		    		List<CinemaMiniProgramAccounts> cinemaMiniProgramAccountsList = _cinemaMiniProgramAccountsService.getByAppId(cinemaMiniProgramAccounts.getAppId());
		    		if(cinemaMiniProgramAccountsList.size()>0){
		    			for(int i=0; i<cinemaMiniProgramAccountsList.size(); i++){
		    				cinemacodes +=cinemaMiniProgramAccountsList.get(i).getCinemaCode()+",";
		    			}
		    		}
		    	}
			}
			Membercard mem=new Membercard();
			mem.setCinemaCode(userCinema.getCinemaCode());
			mem.setCinemaCodes(cinemacodes);
			mem.setCardNo(cardNo);
			mem.setCardPassword(CardPassword);
			mem.setMobilePhone(MobilePhone);
			mem.setLevelCode(LevelCode);
			mem.setUserName(CardUserName);
			mem.setSex(Sex);
			mem.setCreditNum(IDNumber);
			mem.setCreateTime(new Date());
			mem.setStatus(0);
			_memberCardService.Save(mem);
			
			reply.setCardNo(mem.getCardNo());
			reply.setBalance(Float.valueOf(InitialAmount));
			reply.setCreateTime(mem.getCreateTime());
			reply.setExpireDate(mem.getExpireDate());
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
		MtxLoginCardResult mtxReply = Webservice.LoginCard(userCinema, CardNo, CardPassword);
//		System.out.println("会员卡登录接口返回：" + new Gson().toJson(mtxReply));
		if ("0".equals(mtxReply.getLoginCardReturn().getResultCode())) {
			Cinema cinema = _cinemaService.getByCinemaCode(userCinema.getCinemaCode());
			String cinemacodes = "";
			if(cinema!=null&&cinema.getIsGeneralStore()==1){
				CinemaMiniProgramAccounts cinemaMiniProgramAccounts = _cinemaMiniProgramAccountsService.getByCinemaCode(userCinema.getCinemaCode());
		    	if(cinemaMiniProgramAccounts!=null){
		    		List<CinemaMiniProgramAccounts> cinemaMiniProgramAccountsList = _cinemaMiniProgramAccountsService.getByAppId(cinemaMiniProgramAccounts.getAppId());
		    		if(cinemaMiniProgramAccountsList.size()>0){
		    			for(int i=0; i<cinemaMiniProgramAccountsList.size(); i++){
		    				cinemacodes +=cinemaMiniProgramAccountsList.get(i).getCinemaCode()+",";
		    			}
		    		}
		    	}
			}
			// 添加会员卡信息
			Membercard memcard = _memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
			if (memcard == null) {
				memcard = new Membercard();
				memcard.setCinemaCode(userCinema.getCinemaCode());
				memcard.setCinemaCodes(cinemacodes);
				memcard.setCardNo(mtxReply.getLoginCardReturn().getCardId());
				memcard.setCardPassword(CardPassword);
				memcard.setMobilePhone(mtxReply.getLoginCardReturn().getPhoneNumber());
				memcard.setLevelCode(mtxReply.getLoginCardReturn().getAccLevelCode());
				memcard.setLevelName(mtxReply.getLoginCardReturn().getAccLevelName());
				memcard.setScore(Integer.valueOf(mtxReply.getLoginCardReturn().getAccIntegral()));
				memcard.setBalance(Double.valueOf(mtxReply.getLoginCardReturn().getAccBalance()));
				memcard.setUserName(mtxReply.getLoginCardReturn().getMemberName());
				memcard.setSex(mtxReply.getLoginCardReturn().getSex());
				memcard.setCreditNum(mtxReply.getLoginCardReturn().getIdNnumber());
				if(mtxReply.getLoginCardReturn().getBirthday() != null){
					memcard.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getLoginCardReturn().getBirthday()));
				}
				if(mtxReply.getLoginCardReturn().getExpirationTime() != null){
					memcard.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getLoginCardReturn().getExpirationTime()));
				}
				memcard.setCreateTime(new Date());
				memcard.setStatus(0);
				memcard.setAccStatus(Integer.valueOf(mtxReply.getLoginCardReturn().getAccStatus()));
				// 插入保存
				_memberCardService.Save(memcard);
			}else{
				memcard.setMobilePhone(mtxReply.getLoginCardReturn().getPhoneNumber());
				memcard.setLevelCode(mtxReply.getLoginCardReturn().getAccLevelCode());
				memcard.setLevelName(mtxReply.getLoginCardReturn().getAccLevelName());
				memcard.setScore(Integer.valueOf(mtxReply.getLoginCardReturn().getAccIntegral()));
				memcard.setBalance(Double.valueOf(mtxReply.getLoginCardReturn().getAccBalance()));
				memcard.setCreditNum(mtxReply.getLoginCardReturn().getIdNnumber());
				if(mtxReply.getLoginCardReturn().getBirthday() != null){
					memcard.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getLoginCardReturn().getBirthday()));
				}
				if(mtxReply.getLoginCardReturn().getExpirationTime() != null){
					memcard.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getLoginCardReturn().getExpirationTime()));
				}
				memcard.setAccStatus(Integer.valueOf(mtxReply.getLoginCardReturn().getAccStatus()));
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
		MtxQueryCardResult mtxReply = Webservice.QueryCard(userCinema, CardNo, CardPassword);
		if ("0".equals(mtxReply.getQueryCardReturn().getResultCode())) {
			// 修改会员卡信息
			Membercard memcard = _memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
			if (memcard != null) {
				memcard.setScore(Integer.valueOf((int) Math.round(Double.valueOf(mtxReply.getQueryCardReturn().getScore()))));
				memcard.setBalance(Double.valueOf(mtxReply.getQueryCardReturn().getAccBalance()));
				memcard.setMobilePhone(mtxReply.getQueryCardReturn().getMobilePhone());
				memcard.setLevelCode(mtxReply.getQueryCardReturn().getAccLevelCode());
				memcard.setLevelName(mtxReply.getQueryCardReturn().getAccLevelName());
				memcard.setUserName(mtxReply.getQueryCardReturn().getConnectName());
				memcard.setSex(mtxReply.getQueryCardReturn().getSex());
				memcard.setCreditNum(mtxReply.getQueryCardReturn().getIdNum());
				if (mtxReply.getQueryCardReturn().getBirthDay() != null) {
					memcard.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getQueryCardReturn().getBirthDay()));
				}
				if(mtxReply.getQueryCardReturn().getExpirationTime() != null){
					memcard.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getQueryCardReturn().getExpirationTime()));
				}
				memcard.setAccStatus(Integer.valueOf(mtxReply.getQueryCardReturn().getAccStatus()));
				memcard.setUpdated(new Date());
				// 更新
				_memberCardService.Update(memcard);
			} else {
				Cinema cinema = _cinemaService.getByCinemaCode(userCinema.getCinemaCode());
				String cinemacodes = "";
				if(cinema!=null&&cinema.getIsGeneralStore()==1){
					CinemaMiniProgramAccounts cinemaMiniProgramAccounts = _cinemaMiniProgramAccountsService.getByCinemaCode(userCinema.getCinemaCode());
			    	if(cinemaMiniProgramAccounts!=null){
			    		List<CinemaMiniProgramAccounts> cinemaMiniProgramAccountsList = _cinemaMiniProgramAccountsService.getByAppId(cinemaMiniProgramAccounts.getAppId());
			    		if(cinemaMiniProgramAccountsList.size()>0){
			    			for(int i=0; i<cinemaMiniProgramAccountsList.size(); i++){
			    				cinemacodes +=cinemaMiniProgramAccountsList.get(i).getCinemaCode()+",";
			    			}
			    		}
			    	}
				}
				memcard = new Membercard();
				memcard.setCinemaCode(userCinema.getCinemaCode());
				memcard.setCinemaCodes(cinemacodes);
				memcard.setCardNo(CardNo);
				memcard.setCardPassword(CardPassword);
				memcard.setMobilePhone(mtxReply.getQueryCardReturn().getMobilePhone());
				memcard.setLevelCode(mtxReply.getQueryCardReturn().getAccLevelCode());
				memcard.setLevelName(mtxReply.getQueryCardReturn().getAccLevelName());
				memcard.setScore(Integer.valueOf((int) Math.round(Double.valueOf(mtxReply.getQueryCardReturn().getScore()))));
				memcard.setBalance(Double.valueOf(mtxReply.getQueryCardReturn().getAccBalance()));
				memcard.setUserName(mtxReply.getQueryCardReturn().getConnectName());
				memcard.setSex(mtxReply.getQueryCardReturn().getSex());
				memcard.setCreditNum(mtxReply.getQueryCardReturn().getIdNum());
				memcard.setCreateTime(new Date());
				if (mtxReply.getQueryCardReturn().getBirthDay() != null) {
					memcard.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getQueryCardReturn().getBirthDay()));
				}
				if(mtxReply.getQueryCardReturn().getExpirationTime() != null){
					memcard.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse(mtxReply.getQueryCardReturn().getExpirationTime()));
				}
				memcard.setStatus(0);
				memcard.setAccStatus(Integer.valueOf(mtxReply.getQueryCardReturn().getAccStatus()));
				// 添加
				_memberCardService.Save(memcard);
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
		Sessioninfo sess = _sessioninfoService.getSessionCode(userCinema.getCinemaCode(), SessionCode);
		MtxGetDiscountResult mtxReply = Webservice.GetDiscount(userCinema, CardNo, sess.getFeatureNo(), SessionTime);
		if ("0".equals(mtxReply.getGetDiscountReturn().getResultCode())) {
			Float price = Float.valueOf(String.valueOf(sess.getStandardPrice()));
			if("0".equals(mtxReply.getGetDiscountReturn().getDiscountType())){
				price = Float.valueOf(mtxReply.getGetDiscountReturn().getPrice())*price/10f;
			} else {
				price = Float.valueOf(mtxReply.getGetDiscountReturn().getPrice());
			}
			reply.setCinemaCode(userCinema.getCinemaCode());
			reply.setCinemaPayAmount(0f);
			reply.setDiscountType(1);
			reply.setPrice(price);
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
	public CTMSCardPayReply CardPay(Usercinemaview userCinema, String CardNo, String CardPassword, float PayAmount,float GoodsPayAmount,
			String SessionCode, String FilmCode, String TicketNum) throws Exception {
		CTMSCardPayReply reply = new CTMSCardPayReply();
		Sessioninfo sess = _sessioninfoService.getSessionCode(userCinema.getCinemaCode(), SessionCode);
		MtxSerialCardPayResult mtxReply = Webservice.SerialCardPay(userCinema, CardNo, CardPassword, PayAmount,	sess.getFeatureNo(), FilmCode, TicketNum);
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
		MtxSerialCardPayBackResult mtxReply = Webservice.SerialCardPayBack(userCinema, CardNo, CardPassword, TradeNo, PayBackAmount);
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
		MtxGetCardTraceRecordResult mtxReply = Webservice.GetCardTraceRecord(userCinema, CardNo, CardPassword, StartDate, EndDate);
		if ("0".equals(mtxReply.getGetCardTraceRecordReturn().getResultCode())) {
			List<CardTradeRecord> cardTR = new ArrayList<CardTradeRecord>();
			List<CardTraceRecordBean> cardTraceRecords = mtxReply.getGetCardTraceRecordReturn().getCardTraceRecords().getCardTraceRecord();	
			for (CardTraceRecordBean cardTraceRecord : cardTraceRecords) {
				CardTradeRecord ctr = new CardTradeRecord();
				ctr.setTradeNo(cardTraceRecord.getTraceNo());
				ctr.setTradeType(cardTraceRecord.getTraceTypeName());
				ctr.setTradeTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(cardTraceRecord.getTraceDate() + " " + cardTraceRecord.getTraceTime())));
				ctr.setTradePrice(Float.valueOf(cardTraceRecord.getPrice()));
				ctr.setCinemaName(cardTraceRecord.getCinemaName());
				cardTR.add(ctr);
			}
			reply.setCardTradeRecords(cardTR);
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
		MtxSerialCardRechargeResult mtxReply = Webservice.SerialCardRecharge(userCinema, CardNo, CardPassword, ChargeAmount);
		if ("0".equals(mtxReply.getResultCode())) {
			Membercard memercard = _memberCardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
			memercard.setBalance(Double.valueOf(mtxReply.getBalance()));
			memercard.setScore(Integer.valueOf(mtxReply.getScore()));
			memercard.setUpdated(new Date());
			_memberCardService.Update(memercard);
			
			Membercardrecharge membercardrecharge = new Membercardrecharge();
			membercardrecharge.setCinemaCode(memercard.getCinemaCode());
			membercardrecharge.setCardNo(memercard.getCardNo());
			membercardrecharge.setUserName(memercard.getUserName());
			membercardrecharge.setMobilePhone(memercard.getMobilePhone());
			membercardrecharge.setRechargeAmount(Double.valueOf(ChargeAmount));
			membercardrecharge.setBalance(memercard.getBalance());
			membercardrecharge.setUpdated(new Date());
			_membercardrechargeService.save(membercardrecharge);		//更新会员卡充值记录表
			
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
		MtxGetCardTypeResult mtxReply = Webservice.GetCardType(userCinema);
		if ("0".equals(mtxReply.getGetCardTypeReturn().getResultCode())) {
			List<MemberTypeBean> memberTypeBeans = mtxReply.getGetCardTypeReturn().getMemberTypes().getMemberType();
			for (MemberTypeBean memberTypeBean : memberTypeBeans) {
				Membercardlevel cardlevel = _memberCardLevelService.getByCinemaCodeAndLevelCode(userCinema.getCinemaCode(),memberTypeBean.getMemberType());
				if(cardlevel == null){
					cardlevel = new Membercardlevel();
					cardlevel.setCinemaCode(userCinema.getCinemaCode());
					cardlevel.setLevelCode(memberTypeBean.getMemberType());
					cardlevel.setLevelName(memberTypeBean.getMemberTypeName());
					cardlevel.setStatus(0);
					_memberCardLevelService.Save(cardlevel);
				}else{
					cardlevel.setLevelName(memberTypeBean.getMemberTypeName());
					_memberCardLevelService.update(cardlevel);
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
		MtxGetSPInfosResult mtxReply = WebService.GetSPInfos(userCinema);
		if ("0".equals(mtxReply.getResultCode())) {
			List<GetSPInfosBean> getSPInfosBeans = mtxReply.getSpinfos();
			List<Goods> goodslist = _goodsService.getByCinemaCode(userCinema.getUserId(), userCinema.getCinemaCode());
			for(Goods goo : goodslist){
				boolean flag = true;
				for(GetSPInfosBean getSPI : getSPInfosBeans){
					if(goo.getGoodsCode().equals(getSPI.getSpno())){
						flag = false;
						break;
					}
				}
				if(flag){
					//删除本地有的而查出来没有的
					_goodsService.deleteByCinemaCodeAndGoodsCode(userCinema.getCinemaCode(), goo.getGoodsCode());
				}
			}
			for (GetSPInfosBean getSPInfosBean : getSPInfosBeans) {
				Goods goo = _goodsService.getByCinemaCodeAndGoodsCode(userCinema.getCinemaCode(),getSPInfosBean.getSpno());
				if(goo == null){
					goo = new Goods();
					goo.setGoodsCode(getSPInfosBean.getSpno());
					goo.setGoodsName(getSPInfosBean.getSpname());
					goo.setGoodsType(getSPInfosBean.getSptype());
					if (getSPInfosBean.getSellprice() != null) {
						goo.setStandardPrice(Double.valueOf(getSPInfosBean.getSellprice()));
						goo.setSettlePrice(Double.valueOf(getSPInfosBean.getSellprice()));
					}
					goo.setGoodsDesc(getSPInfosBean.getInfo());//卖品描述	
					goo.setUnitName(getSPInfosBean.getUnitname());//卖品单位
					goo.setUpdated(new Date());//更新时间
					if (getSPInfosBean.getComponents() != null && getSPInfosBean.getComponents().size() > 0) {
						goo.setIsPackage(1);//是否套餐，1套餐
						for(GetSPInfoBean getSPInfoBean : getSPInfosBean.getComponents()){
							Goodscomponents gcs = _goodscomponentsService.getByPackageAndGoodsCode(userCinema.getCinemaCode(), 
									getSPInfosBean.getSpno(), getSPInfoBean.getSpno());
							if(gcs == null){
								gcs = new Goodscomponents();
								gcs.setPackageCode(getSPInfosBean.getSpno());
								gcs.setPackageName(getSPInfosBean.getSpname());
								gcs.setGoodsCode(getSPInfoBean.getSpno());
								gcs.setGoodsName(getSPInfoBean.getSpname());
								gcs.setGoodsCount(getSPInfoBean.getCount());
								gcs.setUnitName(getSPInfoBean.getUnitname());
								if(getSPInfosBean.getSellprice()!=null){
									gcs.setPackageStandardPrice(Double.valueOf(getSPInfosBean.getSellprice()));
									gcs.setPackageSettlePrice(Double.valueOf(getSPInfosBean.getSellprice()));
								}
								gcs.setCinemaCode(userCinema.getCinemaCode());
								gcs.setStatus(1);
								_goodscomponentsService.save(gcs);	//插入卖品套餐表
							} else{
								gcs.setPackageName(getSPInfosBean.getSpname());
								gcs.setGoodsCode(getSPInfoBean.getSpno());
								gcs.setGoodsName(getSPInfoBean.getSpname());
								gcs.setGoodsCount(getSPInfoBean.getCount());
								gcs.setUnitName(getSPInfoBean.getUnitname());
								if(getSPInfosBean.getSellprice()!=null){
									gcs.setPackageStandardPrice(Double.valueOf(getSPInfosBean.getSellprice()));
									gcs.setPackageSettlePrice(Double.valueOf(getSPInfosBean.getSellprice()));
								}
								_goodscomponentsService.update(gcs);
							}
						}

					} else {
						goo.setIsPackage(0);//是否套餐，0非套餐
					}
					goo.setCinemaCode(userCinema.getCinemaCode());
					goo.setUserId(userCinema.getUserId());
					//goo.setGoodsPic();//没有卖品图片
					goo.setStockCount(999);//库存给定100
					goo.setShowSeqNo(1);//展示顺序 默认1
					goo.setIsDiscount(0);//是否享受会员卡优惠，1是；0 否 默认0
					goo.setGoodsStatus(1);//卖品状态 
					goo.setIsRecommand(0);//是否推荐  默认0
					goo.setUpdated(new Date());//更新时间
					_goodsService.save(goo);				//插入卖品表
					
				} else {
					goo.setGoodsCode(getSPInfosBean.getSpno());
					goo.setGoodsName(getSPInfosBean.getSpname());
					goo.setGoodsType(getSPInfosBean.getSptype());
					if (getSPInfosBean.getSellprice() != null) {
						goo.setStandardPrice(Double.valueOf(getSPInfosBean.getSellprice()));
						goo.setSettlePrice(Double.valueOf(getSPInfosBean.getSellprice()));
					}
					goo.setGoodsDesc(getSPInfosBean.getInfo());//卖品描述	
					goo.setUnitName(getSPInfosBean.getUnitname());//卖品单位
					if (getSPInfosBean.getComponents() != null && getSPInfosBean.getComponents().size() > 0) {
						goo.setIsPackage(1);//是否套餐，1套餐
					} else {
						goo.setIsPackage(0);//是否套餐，0非套餐
					}
					goo.setUpdated(new Date());//更新时间
					_goodsService.update(goo);
				}
				Goodstype  goodstype = _goodsTypeService.getByTypeCode(userCinema.getCinemaCode(), getSPInfosBean.getSptype());
				if(goodstype == null){
					goodstype = new Goodstype();
					goodstype.setCinemaCode(userCinema.getCinemaCode());
					goodstype.setTypeCode(getSPInfosBean.getSptype());
					_goodsTypeService.save(goodstype);		//插入卖品分类表
				}
			}
			reply.Status = StatusEnum.Success;
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
		MtxConfirmSPInfoResult mtxReply = WebService.ConfirmSPInfo(userCinema, order);
		if("0".equals(mtxReply.getResultCode())){
			String orderNo = mtxReply.getOrderNo();
			order.getOrderBaseInfo().setOrderCode(orderNo);
			order.getOrderBaseInfo().setVerifyCode(mtxReply.getValidCode());
			//取货码 用验证码+订单号后两位
			order.getOrderBaseInfo().setPickUpCode(mtxReply.getValidCode() + orderNo.substring(orderNo.length()-2, orderNo.length()));	
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Complete.getStatusCode());
			order.getOrderBaseInfo().setSubmitTime(new Date());
			order.getOrderBaseInfo().setOrderPayTime(new Date());
			reply.Status = StatusEnum.Success;
		}else{
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.SubmitFail.getStatusCode());
			reply.Status=StatusEnum.Failure;
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
		MtxBackSellGoodsResult mtxReply = WebService.BackSellGoods(userCinema, order);
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
	
	//混合下单  电影票+卖品(未完成)
	@Override
	public CTMSSubmitMixOrderReply SubmitMixOrder(Usercinemaview userCinema, OrderView order, GoodsOrderView goodsorder)
			throws Exception {
		CTMSSubmitMixOrderReply reply=new CTMSSubmitMixOrderReply();
		boolean flag=order.getOrderBaseInfo().getCardNo() == null?false:true;//是否使用会员卡
		Sessioninfo sessioninfo=_sessioninfoService.getSessionCode(userCinema.getCinemaCode(), order.getOrderBaseInfo().getSessionCode());
		///
		List<Map<String, Object>> ticketList=new ArrayList<Map<String,Object>>();
		Orders orders=order.getOrderBaseInfo();
			Map<String,Object> orderMap = new LinkedHashMap<String,Object>();
			orderMap.put("OrderNo",orders.getSubmitOrderCode());
			orderMap.put("ValidCode",orders.getVerifyCode());
			if(flag){
				orderMap.put("isDiscount", true);
			}
			ticketList.add(orderMap);
		////
		List<Map<String,Object>> goodsList = new ArrayList<Map<String,Object>>();
		Goodsorders goodsorders=goodsorder.getOrderBaseInfo();
			Map<String,Object> goodsOrderMap=new LinkedHashMap<String,Object>();
			goodsOrderMap.put("orderNo",goodsorders.getOrderCode());
			goodsOrderMap.put("validCode", goodsorders.getVerifyCode());
		if(flag){
			goodsOrderMap.put("isDiscount", true);
		}
		goodsList.add(goodsOrderMap);
		////
		JSONObject input =new JSONObject();
		input.put("partnerCode", order.getOrderBaseInfo().getUserId());
		input.put("placeNo", userCinema.getCinemaCode());
		input.put("partnerId", order.getOrderBaseInfo().getSerialNum());//SerialNum满天星存储订单流水号；PaySeqNo 会员卡交易流水号 
		input.put("cardId", order.getOrderBaseInfo().getCardNo());
		input.put("mobilePhone", order.getOrderBaseInfo().getMobilePhone());
		input.put("traceTypeNo", 01);
		input.put("oldPrice", order.getOrderBaseInfo().getTotalPrice());
		input.put("tracePrice", order.getOrderBaseInfo().getTotalFee());
		input.put("discount", 0);
		input.put("featureNo", sessioninfo.getFeatureNo());
		input.put("filmNo",sessioninfo.getFilmCode());
		input.put("ticketNum",order.getOrderBaseInfo().getTicketCount());
		input.put("passWord", goodsorder.getOrderBaseInfo().getCardPassword());
		input.put("price", goodsorder.getOrderBaseInfo().getTotalPrice());
		input.put("tracePrice", goodsorder.getOrderBaseInfo().getTotalFee());
//		String data=input.toJSONString();
   
		
		return reply;
	}
	
}
