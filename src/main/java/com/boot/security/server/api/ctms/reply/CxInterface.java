package com.boot.security.server.api.ctms.reply;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boot.security.server.api.ctms.reply.CxQueryCinemaInfoResult.ResBean.CinemaBean.ScreensBean.ScreenVOBean;
import com.boot.security.server.api.ctms.reply.CxQueryFilmInfoByDatePeriodResult.ResBean.FilmInfoVOsBean.FilmInfoVOBean;
import com.boot.security.server.api.ctms.reply.CxQueryMemberFlowInfoResult.ResBean.TransFlowVOsBean.TransFlowVOBean;
import com.boot.security.server.api.ctms.reply.CxQueryMemberLevelResult.ResBean.MemberLevelsBean.MemberLevelBean;
import com.boot.security.server.api.ctms.reply.CxQueryMerchandiseResult.ResBean.MersBean.MerBean;
import com.boot.security.server.api.ctms.reply.CxQueryPlanInfoByDatePeriodResult.ResBean.CinemaPlansBean.CinemaPlanBean;
import com.boot.security.server.api.ctms.reply.CxQueryPlanSeatResult.ResBean.PlanSiteStatesBean.PlanSiteStateBean;
import com.boot.security.server.api.ctms.reply.CxQuerySeatInfoResult.ResBean.ScreenSitesBean.ScreenSiteBean;
import com.boot.security.server.api.ctms.reply.CxQueryTicketInfoResult.ResBean.TicketsBean.TicketBean;
import com.boot.security.server.api.ctms.reply.CxSubmitOrderResult.ResBean.SeatInfosBean.SeatInfoBean;
import com.boot.security.server.api.ctms.reply.CxApplyFetchTicketResult.ResBean.TicketsBean;
import com.boot.security.server.model.CardChargeTypeEnum;
import com.boot.security.server.model.CardTradeRecord;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.LoveFlagEnum;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.OrderStatusEnum;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.YesOrNoEnum;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.GoodsServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.SpringUtil;
import com.google.gson.Gson;
import com.oristartech.tsp.ws.soap.WebService;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.SessionSeat;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;

public class CxInterface implements ICTMSInterface { 
	private WebService cxService;
	CinemaServiceImpl _cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
	ScreeninfoServiceImpl _screeninfoService = SpringUtil.getBean(ScreeninfoServiceImpl.class);
	ScreenseatinfoServiceImpl _screenseatinfoService = SpringUtil.getBean(ScreenseatinfoServiceImpl.class);
	FilminfoServiceImpl _filminfoService = SpringUtil.getBean(FilminfoServiceImpl.class);
	SessioninfoServiceImpl _sessioninfoService = SpringUtil.getBean(SessioninfoServiceImpl.class);
	MemberCardServiceImpl _membercardService = SpringUtil.getBean(MemberCardServiceImpl.class);
	MemberCardLevelServiceImpl _membercardlevelService = SpringUtil.getBean(MemberCardLevelServiceImpl.class);
	GoodsServiceImpl _goodsService=SpringUtil.getBean(GoodsServiceImpl.class);
	private static final String pCompress = "0";

	protected static Logger log = LoggerFactory.getLogger(CxInterface.class);

	public CxInterface() {
		cxService = new WebService();
	}

	// region 查询影厅信息 （完成）
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		CxQueryCinemaInfoResult cxReply = cxService.QueryCinemaInfo(userCinema);
		if ("0".equals(cxReply.getQueryCinemaInfoResult().getResultCode())) {
			// 更新影院信息
			Cinema cinema = _cinemaService.getByCinemaCode(userCinema.getCinemaCode());
			cinema.setName(cxReply.getQueryCinemaInfoResult().getCinema().getCinemaName());
			cinema.setAddress(cxReply.getQueryCinemaInfoResult().getCinema().getAddress());
			cinema.setScreenCount(Integer.parseInt(cxReply.getQueryCinemaInfoResult().getCinema().getScreenCount()));
			_cinemaService.update(cinema);
			// 更新影厅信息
			// List<Screeninfo> oldScreens=
			// _screeninfoService.getByCinemaCode(userCinema.getCinemaCode());
			List<Screeninfo> newScreens = new ArrayList<Screeninfo>();
			List<ScreenVOBean> screenvos = cxReply.getQueryCinemaInfoResult().getCinema().getScreens().getScreenVO();
			for (ScreenVOBean screenvo : screenvos) {
				Screeninfo screen = new Screeninfo();// 先读取本地
				CxModelMapper.MapToEntity(screenvo, screen);
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
		reply.ErrorCode = cxReply.getQueryCinemaInfoResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryCinemaInfoResult().getMessage();
		return reply;
	}
	// endregion

	// region 查询影厅座位（完成）
	@Override
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) {
		CTMSQuerySeatReply reply = new CTMSQuerySeatReply();
		CxQuerySeatInfoResult cxReply = cxService.QuerySeatInfo(userCinema, screen.getSCode());
		if ("0".equals(cxReply.getQuerySeatInfoResult().getResultCode())) {
			// 更新影厅座位
			List<Screenseatinfo> newSeats = new ArrayList<Screenseatinfo>();
			List<ScreenSiteBean> screenSites = cxReply.getQuerySeatInfoResult().getScreenSites().getScreenSite();
			for (ScreenSiteBean screenSite : screenSites) {
				Screenseatinfo seat = new Screenseatinfo();// 创建实例
				CxModelMapper.MapToEntity(screenSite, seat);
				seat.setCinemaCode(userCinema.getCinemaCode());
				seat.setScreenCode(screen.getSCode());
				seat.setLoveFlag(LoveFlagEnum.Normal.getFlagCode());
				newSeats.add(seat);
			}
			// 辰星的GroupCode用于标识情侣座，需要另外处理
			Map<String, List<Screenseatinfo>> groupSeats = newSeats.stream()
					.collect(Collectors.groupingBy(Screenseatinfo::getGroupCode));
			for (Map.Entry<String, List<Screenseatinfo>> entry : groupSeats.entrySet()) {
				if (entry.getValue().size() == 2) {
					Screenseatinfo firstSeat = entry.getValue().get(0);
					Screenseatinfo SecondSeat = entry.getValue().get(1);
					if (firstSeat.getXCoord() < SecondSeat.getXCoord()) {
						firstSeat.setLoveFlag(LoveFlagEnum.LEFT.getFlagCode());
						SecondSeat.setLoveFlag(LoveFlagEnum.RIGHT.getFlagCode());
					} else {
						firstSeat.setLoveFlag(LoveFlagEnum.RIGHT.getFlagCode());
						SecondSeat.setLoveFlag(LoveFlagEnum.LEFT.getFlagCode());
					}
				}
			}
			// 处理完情侣座后将辰星座位的所有GroupCode置为0000000000000001
			newSeats.forEach(seat -> seat.setGroupCode("0000000000000001"));
			// 先删除原当前影院当前影厅座位
			_screenseatinfoService.deleteByScreenCode(userCinema.getCinemaCode(), screen.getSCode());
			// 插入影厅座位信息
			for (Screenseatinfo seat : newSeats) {
				_screenseatinfoService.save(seat);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getQuerySeatInfoResult().getResultCode();
		reply.ErrorMessage = cxReply.getQuerySeatInfoResult().getMessage();
		return reply;
	}
	// endregion

	// region 查询影片（完成）
	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws ParseException {
		CTMSQueryFilmReply reply = new CTMSQueryFilmReply();
		CxQueryFilmInfoByDatePeriodResult cxReply = cxService.QueryFilmInfoByDatePeriod(userCinema,
				new SimpleDateFormat("yyyy-MM-dd").format(StartDate),
				new SimpleDateFormat("yyyy-MM-dd").format(EndDate));
		if (cxReply.getQueryFilmInfoByDatePeriodResult().getResultCode().equals("0")) {
			List<FilmInfoVOBean> FilmList = cxReply.getQueryFilmInfoByDatePeriodResult().getFilmInfoVOs()
					.getFilmInfoVO();
			if (FilmList.size() > 0) {
				// 去除重复
				FilmList = FilmList.stream().distinct().collect(Collectors.toList());
				List<Filminfo> FilmInfos = new ArrayList<Filminfo>();
				for (FilmInfoVOBean filmVo : FilmList) {
					Filminfo filmInfo = _filminfoService.getByFilmCode(filmVo.getFilmCode());
					if (filmInfo == null) {
						filmInfo = new Filminfo();
						CxModelMapper.MapToEntity(filmVo, filmInfo);
						_filminfoService.save(filmInfo);
					} else {
						CxModelMapper.MapToEntity(filmVo, filmInfo);
						_filminfoService.update(filmInfo);
					}
					FilmInfos.add(filmInfo);
				}
				reply.Status = StatusEnum.Success;
				reply.ErrorCode = "0";
				reply.ErrorMessage = "成功";
				reply.setFilms(FilmInfos);
			} else {
				reply.Status = StatusEnum.Failure;
				reply.ErrorCode = "-1";
				reply.ErrorMessage = "在售影片信息查询失败";
			}
		}
		return reply;
	}
	// endregion

	// region 查询排期场次(完成)
	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate)
			throws Exception {
		CTMSQuerySessionReply reply = new CTMSQuerySessionReply();
		CxQueryPlanInfoByDatePeriodResult cxReply = cxService.QueryPlanInfoByDatePeriod(userCinema,
				new SimpleDateFormat("yyyy-MM-dd").format(StartDate),
				new SimpleDateFormat("yyyy-MM-dd").format(EndDate));
		if (cxReply.getQueryPlanInfoByDatePeriodResult().getResultCode().equals("0")) {
			// 更新场次信息
			List<CinemaPlanBean> CinemaPlans = cxReply.getQueryPlanInfoByDatePeriodResult().getCinemaPlans()
					.getCinemaPlan();
			if (CinemaPlans.size() > 0) {
				List<Sessioninfo> newSessions = new ArrayList<Sessioninfo>();
				for (CinemaPlanBean cinemaplan : CinemaPlans) {
					Sessioninfo session = new Sessioninfo();// 先创建实例
					CxModelMapper.MapToEntity(cinemaplan, session);
					session.setCCode(userCinema.getCinemaCode());
					session.setUserID(userCinema.getUserId());
					newSessions.add(session);
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String sd = sdf.format(new Date(Long.parseLong(String.valueOf(EndDate.getTime()+24*60*60*1000))));
				// 先删除旧场次
				_sessioninfoService.deleteByCinemaCodeAndDate(userCinema.getUserId(), userCinema.getCinemaCode(),
						StartDate, new SimpleDateFormat("yyyy-MM-dd").parse(sd));
				// 插入场次信息
				for (Sessioninfo session : newSessions) {
					_sessioninfoService.save(session);
				}
				reply.Status = StatusEnum.Success;
			}
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getQueryPlanInfoByDatePeriodResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryPlanInfoByDatePeriodResult().getMessage();
		return reply;
	}
	// endregion

	// region 查询场次座位（完成）
	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,
			SessionSeatStatusEnum Status) {
		CTMSQuerySessionSeatReply reply = new CTMSQuerySessionSeatReply();
		CxQueryPlanSeatResult cxReply = cxService.QueryPlanSeat(userCinema, SessionCode, Status.getStatusCode());
		if (cxReply.getQueryPlanSeatResult().getResultCode().equals("0")) {
			List<SessionSeat> sessionseats = new ArrayList<SessionSeat>();
			for (PlanSiteStateBean plansite : cxReply.getQueryPlanSeatResult().getPlanSiteStates().getPlanSiteState()) {
				SessionSeat sessionseat = new SessionSeat();
				sessionseat.setSeatCode(plansite.getSeatCode());
				sessionseat.setRowNum(plansite.getRowNum());
				sessionseat.setColumnNum(plansite.getColumnNum());
				sessionseat.setStatus(SessionSeatStatusEnum.valueOf(plansite.getStatus()));
				sessionseats.add(sessionseat);
			}
			reply.setSessionSeats(sessionseats);
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getQueryPlanSeatResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryPlanSeatResult().getMessage();
		return reply;
	}
	// endregion

	// region 锁座（完成）
	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) {
		CTMSLockSeatReply reply = new CTMSLockSeatReply();
		log.info("===========================2=====");
		CxLockSeatResult cxReply = cxService.LockSeat(userCinema, order);
		if (cxReply.getLockSeatResult().getResultCode().equals("0")) {
			order.getOrderBaseInfo().setLockOrderCode(cxReply.getLockSeatResult().getOrderCode());
			order.getOrderBaseInfo().setAutoUnlockDatetime(cxReply.getLockSeatResult().getAutoUnlockDatetime());
			order.getOrderBaseInfo().setLockTime(new Date());
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Locked.getStatusCode());
			reply.Status = StatusEnum.Success;
		} else {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.LockFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(cxReply.getLockSeatResult().getMessage());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getLockSeatResult().getResultCode();
		reply.ErrorMessage = cxReply.getLockSeatResult().getMessage();
		return reply;
	}
	// endregion

	// region 释放座位（完成）
	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) {
		CTMSReleaseSeatReply reply = new CTMSReleaseSeatReply();
		CxReleaseSeatResult cxReply = cxService.ReleaseSeat(userCinema, order);
		if (cxReply.getReleaseSeatResult().getResultCode().equals("0")) {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Released.getStatusCode());
			reply.Status = StatusEnum.Success;
		} else {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.ReleaseFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(cxReply.getReleaseSeatResult().getMessage());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getReleaseSeatResult().getResultCode();
		reply.ErrorMessage = cxReply.getReleaseSeatResult().getMessage();
		return reply;
	}
	// endregion

	// region 提交订单（完成）
	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) {
		CTMSSubmitOrderReply reply = new CTMSSubmitOrderReply();
		CxSubmitOrderResult cxReply = cxService.SubmitOrder(userCinema, order);
		if (cxReply.getSubmitOrderResult().getResultCode().equals("0")) {
			order.getOrderBaseInfo().setSubmitOrderCode(cxReply.getSubmitOrderResult().getOrderCode());
			order.getOrderBaseInfo().setPrintNo(cxReply.getSubmitOrderResult().getPrintNo());
			order.getOrderBaseInfo().setVerifyCode(cxReply.getSubmitOrderResult().getVerifyCode());
			for (Orderseatdetails orderseat : order.getOrderSeatDetails()) {
				log.info("SeatCode：" + orderseat.getSeatCode());
				List<SeatInfoBean> seatinfobeans = cxReply.getSubmitOrderResult().getSeatInfos().getSeatInfo().stream()
						.filter(item -> item.getSeatCode().equals(orderseat.getSeatCode()))
						.collect(Collectors.toList());
				SeatInfoBean seatinfobean = seatinfobeans.get(0);
				log.info("SeatInfoBean：" + seatinfobean.getSeatCode());
				if (seatinfobean != null) {
					orderseat.setFilmTicketCode(seatinfobean.getFilmTicketCode());
				}
			}
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Complete.getStatusCode());
			order.getOrderBaseInfo().setSubmitTime(new Date());
			reply.Status = StatusEnum.Success;
		} else {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.SubmitFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(cxReply.getSubmitOrderResult().getMessage());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getSubmitOrderResult().getResultCode();
		reply.ErrorMessage = cxReply.getSubmitOrderResult().getMessage();
		return reply;
	}
	// endregion

	// region 查询出票状态（完成）
	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws ParseException {
		CTMSQueryPrintReply reply = new CTMSQueryPrintReply();
		CxQueryDeliveryStatusResult cxReply = cxService.QueryDeliveryStatus(userCinema,
				order.getOrderBaseInfo().getPrintNo(), order.getOrderBaseInfo().getVerifyCode());
		if (cxReply.getQueryDeliveryStatusResult().getResultCode().equals("0")) {
			order.getOrderBaseInfo().setPrintStatus(Integer.valueOf(
					YesOrNoEnum.valueOf(cxReply.getQueryDeliveryStatusResult().getPrintStatus()).getStatusCode()));
			if (order.getOrderBaseInfo().getPrintStatus() == 1) {
				order.getOrderBaseInfo().setPrintTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(cxReply.getQueryDeliveryStatusResult().getPrintTime()));
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}

		reply.ErrorCode = cxReply.getQueryDeliveryStatusResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryDeliveryStatusResult().getMessage();
		return reply;
	}
	// endregion

	// region 退票（完成）
	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) {
		CTMSRefundTicketReply reply = new CTMSRefundTicketReply();
		CxCancelOrderResult cxReply = cxService.CancelOrder(userCinema, order.getOrderBaseInfo().getPrintNo(),
				order.getOrderBaseInfo().getVerifyCode());
		if (cxReply.getCancelOrderResult().getResultCode().equals("0")) {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
			order.getOrderBaseInfo().setRefundTime(new Date());
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}

		reply.ErrorCode = cxReply.getCancelOrderResult().getResultCode();
		reply.ErrorMessage = cxReply.getCancelOrderResult().getMessage();
		return reply;
	}
	// endregion

	// region 查询订单（完成）
	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws ParseException {
		CTMSQueryOrderReply reply = new CTMSQueryOrderReply();
		CxQueryOrderStatusResult cxReply = cxService.QueryOrderStatus(userCinema,
				order.getOrderBaseInfo().getSubmitOrderCode());
		log.info(cxReply.getQueryOrderStatusResult().getResultCode());
		if (cxReply.getQueryOrderStatusResult().getResultCode().equals("0")
				&& cxReply.getQueryOrderStatusResult().getOrderStatus() != "1") {
			if (cxReply.getQueryOrderStatusResult().getOrderStatus() == "2") {
				order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.Refund.getStatusCode());
				order.getOrderBaseInfo().setRefundTime(order.getOrderBaseInfo().getRefundTime() == null ? new Date()
						: order.getOrderBaseInfo().getRefundTime());
			}

			// 查询打印状态
			QueryPrint(userCinema, order);

			reply.Status = StatusEnum.Success;
			log.info(reply.Status.getStatusCode());
		} else if (cxReply.getQueryOrderStatusResult().getOrderStatus() == "1") {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = "-1";
			reply.ErrorMessage = "订单交易状态：提交失败！";
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = cxReply.getQueryOrderStatusResult().getResultCode();
			reply.ErrorMessage = cxReply.getQueryOrderStatusResult().getMessage();
		}
		return reply;
	}
	// endregion

	// region 查询影票（完成）
	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) {
		CTMSQueryTicketReply reply = new CTMSQueryTicketReply();
		CxQueryTicketInfoResult cxReply = cxService.QueryTicketInfo(userCinema, order.getOrderBaseInfo().getPrintNo());
		if (cxReply.getQueryTicketInfoResult().getResultCode().equals("0")) {
			if (cxReply.getQueryTicketInfoResult().getTickets() != null
					&& cxReply.getQueryTicketInfoResult().getTickets().getTicket() != null
					&& cxReply.getQueryTicketInfoResult().getTickets().getTicket().size() > 0) {
				for (Orderseatdetails orderseat : order.getOrderSeatDetails()) {
					List<TicketBean> ticketbeans = cxReply.getQueryTicketInfoResult().getTickets().getTicket().stream()
							.filter(item -> item.getSeatCode().equals(orderseat.getSeatCode()))
							.collect(Collectors.toList());
					TicketBean ticketbean = ticketbeans.get(0);
					if (ticketbean != null) {
						orderseat.setTicketInfoCode(ticketbean.getTicketInfoCode());
						orderseat.setFilmTicketCode(ticketbean.getTicketCode());
						orderseat.setPrintFlag(ticketbean.getPrintFlag());
					}
				}
			}

			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}

		reply.ErrorCode = cxReply.getQueryTicketInfoResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryTicketInfoResult().getMessage();
		return reply;
	}
	// endregion

	// region 确认出票(完成)
	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) {
		CTMSFetchTicketReply reply = new CTMSFetchTicketReply();
		CxApplyFetchTicketResult cxApplyReply = cxService.ApplyFetchTicket(userCinema,
				order.getOrderBaseInfo().getPrintNo(), order.getOrderBaseInfo().getVerifyCode());
		if (cxApplyReply.getApplyFetchTicketResult().getResultCode().equals("0")) {
			if (cxApplyReply.getApplyFetchTicketResult().getTickets() != null
					&& cxApplyReply.getApplyFetchTicketResult().getTickets().getTicket() != null
					&& cxApplyReply.getApplyFetchTicketResult().getTickets().getTicket().size() > 0) {
				CxApplyFetchTicketResult.ResBean.TicketsBean.TicketBean Ticket = cxApplyReply
						.getApplyFetchTicketResult().getTickets().getTicket().get(0);
				if (Ticket.getReturnValue().equals("0")) {
					// 请求成功，然后确认出票
					CxFetchTicketResult cxfetchReply = cxService.FetchTicket(userCinema,
							order.getOrderBaseInfo().getPrintNo());
					if (cxfetchReply.getFetchTicketResult().getResultCode().equals("0")) {
						order.getOrderBaseInfo().setPrintStatus(1);
						order.getOrderBaseInfo().setPrintTime(new Date());
						reply.Status = StatusEnum.Success;
					} else {
						reply.Status = StatusEnum.Failure;
						reply.ErrorCode = cxfetchReply.getFetchTicketResult().getResultCode();
						reply.ErrorMessage = cxfetchReply.getFetchTicketResult().getMessage();
					}
				} else if (Ticket.getReturnValue().equals("1")) {
					reply.Status = StatusEnum.Failure;
					reply.ErrorCode = "-1";
					reply.ErrorMessage = "电影票已打印";
				} else {
					reply.Status = StatusEnum.Failure;
					reply.ErrorCode = "-1";
					reply.ErrorMessage = "未知错误";
				}
			}
		} else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = cxApplyReply.getApplyFetchTicketResult().getResultCode();
			reply.ErrorMessage = cxApplyReply.getApplyFetchTicketResult().getMessage();
		}
		return reply;
	}
	// endregion

	// region 登录会员卡(完成)
	public CTMSLoginCardReply LoginCard(Usercinemaview userCinema, String CardNo, String CardPassword) {
		CTMSLoginCardReply reply = new CTMSLoginCardReply();
		String realPassword = MD5Util.MD5Encode(CardPassword, "UTF-8");

		CxVerifyMemberLoginResult cxReply = cxService.VerifyMemberLogin(userCinema, CardNo, realPassword);
		if (cxReply.getVerifyMemberLoginResult().getResultCode().equals("0")) {
			// 添加会员卡信息
			Membercard membercard = _membercardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
			if (membercard == null) {
				membercard = new Membercard();
				membercard.setCinemaCode(userCinema.getCinemaCode());
				membercard.setCardNo(CardNo);
				membercard.setCardPassword(CardPassword);
				membercard.setMobilePhone(cxReply.getVerifyMemberLoginResult().getPhoneNum());
				membercard.setLevelCode(cxReply.getVerifyMemberLoginResult().getLevelCode());
				membercard.setLevelName(cxReply.getVerifyMemberLoginResult().getLevelName());
				// 插入
				_membercardService.Save(membercard);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getVerifyMemberLoginResult().getResultCode();
		reply.ErrorMessage = cxReply.getVerifyMemberLoginResult().getMessage();
		return reply;
	}
	// endregion

	// region 查询会员卡(完成)
	public CTMSQueryCardReply QueryCard(Usercinemaview userCinema, String CardNo, String CardPassword)
			throws ParseException {
		CTMSQueryCardReply reply = new CTMSQueryCardReply();
		String realPassword = MD5Util.MD5Encode(CardPassword, "UTF-8");
		CxQueryMemberInfoResult cxReply = cxService.QueryMemberInfo(userCinema, CardNo, CardPassword);
		if (cxReply.getQueryMemberInfoResult().getResultCode().equals("0")) {
			// 修改会员卡信息
			Membercard membercard = _membercardService.getByCardNo(userCinema.getCinemaCode(), CardNo);
			if (membercard != null) {
				if(cxReply.getQueryMemberInfoResult().getIntegralBalance()!=null){
					membercard.setScore(Integer.parseInt(cxReply.getQueryMemberInfoResult().getIntegralBalance()));
				}
				if(cxReply.getQueryMemberInfoResult().getBasicBalance()!=null){
					membercard.setBalance(Double.parseDouble(cxReply.getQueryMemberInfoResult().getBasicBalance()));
				}
				membercard.setUserName(cxReply.getQueryMemberInfoResult().getUserName());
				membercard.setSex(cxReply.getQueryMemberInfoResult().getSex());
				membercard.setCreditNum(cxReply.getQueryMemberInfoResult().getCreditNum());
				if(cxReply.getQueryMemberInfoResult().getBirthday()!=null){
					membercard.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(cxReply.getQueryMemberInfoResult().getBirthday()));
				}
				// 更新
				_membercardService.Update(membercard);
			} else {
				membercard = new Membercard();
				membercard.setCinemaCode(userCinema.getCinemaCode());
				membercard.setCardNo(CardNo);
				membercard.setCardPassword(CardPassword);
				membercard.setMobilePhone(cxReply.getQueryMemberInfoResult().getMobileNum());
				membercard.setLevelCode(cxReply.getQueryMemberInfoResult().getLevelCode());
				membercard.setLevelName(cxReply.getQueryMemberInfoResult().getLevelName());

				membercard.setScore(Integer.parseInt(cxReply.getQueryMemberInfoResult().getIntegralBalance()));
				membercard.setBalance(Double.parseDouble(cxReply.getQueryMemberInfoResult().getBasicBalance()));
				membercard.setUserName(cxReply.getQueryMemberInfoResult().getUserName());
				membercard.setSex(cxReply.getQueryMemberInfoResult().getSex());
				membercard.setCreditNum(cxReply.getQueryMemberInfoResult().getCreditNum());
				membercard.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(cxReply.getQueryMemberInfoResult().getBirthday()));
				// 添加
				_membercardService.Save(membercard);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getQueryMemberInfoResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryMemberInfoResult().getMessage();

		return reply;
	}
	// endregion

	// region 查询会员卡折扣（完成）
	public CTMSQueryDiscountReply QueryDiscount(Usercinemaview userCinema, String TicketCount, String CardNo,
			String CardPassword, String LevelCode, String SessionCode, String SessionTime, String FilmCode,
			String ScreenType, String ListingPrice, String LowestPrice) {
		CTMSQueryDiscountReply reply = new CTMSQueryDiscountReply();
		CxQueryDiscountActivityResult cxReply = cxService.QueryDiscountActivity(userCinema, TicketCount, CardNo,
				CardPassword, LevelCode, SessionCode, SessionTime, FilmCode, ScreenType, ListingPrice, LowestPrice);
		if (cxReply.getQueryDiscountActivityResult().getResultCode().equals("0")) {
			reply.setCinemaCode(userCinema.getCinemaCode());
			reply.setDiscountType(1);// 辰星默认固定票价
			if (cxReply.getQueryDiscountActivityResult().getRule() != null) {
				log.info("======"+cxReply.getQueryDiscountActivityResult().getRule()+"====");
				//处理rule
				CxQueryDiscountActivityResultRule rule=new Gson().fromJson(cxReply.getQueryDiscountActivityResult().getRule(),CxQueryDiscountActivityResultRule.class);
				if(rule!=null&&rule.getResults().size()>0){
					reply.setPrice(rule.getResults().get(0).getPrice());
					reply.setCinemaPayAmount(rule.getResults().get(0).getCinemaPayAmount());
				}else
				{
					reply.setPrice(0F);
					reply.setCinemaPayAmount(0F);
				}
			} else {
				reply.setPrice(0F);
				reply.setCinemaPayAmount(0F);
			}
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}

		reply.ErrorCode = cxReply.getQueryDiscountActivityResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryDiscountActivityResult().getMessage();

		return reply;
	}
	// endregion

	// region 会员卡支付（完成）
	public CTMSCardPayReply CardPay(Usercinemaview userCinema, String CardNo, String CardPassword, float PayAmount,
			String SessionCode, String FilmCode, String TicketNum) {
		CTMSCardPayReply reply = new CTMSCardPayReply();
		String pTransactionNo = UUID.randomUUID().toString();
		CxMemberConsumeResult cxReply = cxService.MemberConsume(userCinema, CardNo, CardPassword, PayAmount,
				SessionCode, FilmCode, TicketNum, pTransactionNo);
		if (cxReply.getMemberConsumeResult().getResultCode().equals("0")) {
			reply.setTradeNo(pTransactionNo);// 直接用本地交易生成的流水号退款
												// //cxReply.TransactionNo
			reply.setDeductAmount(cxReply.getMemberConsumeResult().getGiveAmount());
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}

		reply.ErrorCode = cxReply.getMemberConsumeResult().getResultCode();
		reply.ErrorMessage = cxReply.getMemberConsumeResult().getMessage();

		return reply;
	}
	// endregion

	// region 会员卡支付撤销（完成）
	public CTMSCardPayBackReply CardPayBack(Usercinemaview userCinema, String CardNo, String CardPassword,
			String TradeNo, float PayBackAmount) {
		CTMSCardPayBackReply reply = new CTMSCardPayBackReply();
		String pTransactionNo = UUID.randomUUID().toString();
		CxMemberTransactionCancelResult cxReply = cxService.MemberTransactionCancel(userCinema, CardNo, CardPassword,
				TradeNo, PayBackAmount, pTransactionNo);
		if (cxReply.getMemberTransactionCancelResult().getResultCode().equals("0")) {
			reply.setTradeNo(pTransactionNo);// 直接返回本地撤销交易的流水号
												// //cxReply.TransactionNo
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}

		reply.ErrorCode = cxReply.getMemberTransactionCancelResult().getResultCode();
		reply.ErrorMessage = cxReply.getMemberTransactionCancelResult().getMessage();
		return reply;
	}
	// endregion

	// region 查询会员卡交易记录（完成）
	public CTMSQueryCardTradeRecordReply QueryCardTradeRecord(Usercinemaview userCinema, String CardNo,
			String CardPassword, String StartDate, String EndDate, String PageSize, String PageNum)
			throws ParseException {
		CTMSQueryCardTradeRecordReply reply = new CTMSQueryCardTradeRecordReply();
		CxQueryMemberFlowInfoResult cxReply = cxService.QueryMemberFlowInfo(userCinema, CardNo, CardPassword, StartDate,
				EndDate, PageSize, PageNum);
		if (cxReply.getQueryMemberFlowInfoResult().getResultCode().equals("0")) {
			List<CardTradeRecord> CardTradeRecords = new ArrayList<CardTradeRecord>();
			if(cxReply.getQueryMemberFlowInfoResult().getTransFlowVOs()
					.getTransFlowVO().size()>0){
				for (TransFlowVOBean transflow : cxReply.getQueryMemberFlowInfoResult().getTransFlowVOs()
						.getTransFlowVO()) {
					CardTradeRecord record = new CardTradeRecord();
					record.setTradeNo(transflow.getFlowNum());
					record.setTradeType(transflow.getFlowType());
					record.setTradeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(transflow.getTransactionTime()));
					record.setTradePrice(transflow.getTransactionAmount());
					record.setCinemaName(transflow.getMerchantName());
					CardTradeRecords.add(record);
				}
			}
			reply.setCardTradeRecords(CardTradeRecords);
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}

		reply.ErrorCode = cxReply.getQueryMemberFlowInfoResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryMemberFlowInfoResult().getMessage();
		return reply;
	}
	// endregion

	// region 会员卡充值（完成）
	public CTMSCardChargeReply CardCharge(Usercinemaview userCinema, String CardNo, String CardPassword,
			CardChargeTypeEnum ChargeType, float ChargeAmount) {
		CTMSCardChargeReply reply = new CTMSCardChargeReply();
		CxMemberChargeResult cxReply = cxService.MemberCharge(userCinema, CardNo, CardPassword, ChargeType,
				ChargeAmount);
		if (cxReply.getMemberChargeResult().getResultCode().equals("0")) {
			reply.Status = StatusEnum.Success;
		} else {
			reply.Status = StatusEnum.Failure;
		}

		reply.ErrorCode = cxReply.getMemberChargeResult().getResultCode();
		reply.ErrorMessage = cxReply.getMemberChargeResult().getMessage();

		return reply;
	}
	// endregion

	// region 查询会员卡等级(完成)
	public CTMSQueryCardLevelReply QueryCardLevel(Usercinemaview userCinema){
        CTMSQueryCardLevelReply reply = new CTMSQueryCardLevelReply();
        CxQueryMemberLevelResult cxReply=cxService.QueryMemberLevel(userCinema);
        if (cxReply.getQueryMemberLevelResult().getResultCode().equals("0"))
        {
            //var oldCardLevels = _membercardService.GetMemberCardLevels(userCinema.CinemaCode);
        	List<Membercardlevel> memercardlevels=new ArrayList<Membercardlevel>();
        	for(MemberLevelBean levelbean:cxReply.getQueryMemberLevelResult().getMemberLevels().getMemberLevel()){
        		Membercardlevel memercardlevel=new Membercardlevel();
        		memercardlevel.setCinemaCode(userCinema.getCinemaCode());
        		memercardlevel.setLevelCode(levelbean.getLevelCode());
        		memercardlevel.setLevelName(levelbean.getLevelName());
        		memercardlevels.add(memercardlevel);
        	}
        	//先删除原会员卡等级
        	_membercardlevelService.deleteByCinemaCode(userCinema.getCinemaCode());
            //插入最新会员卡等级
            for(Membercardlevel cardlevel:memercardlevels){
            	_membercardlevelService.Save(cardlevel);
            }
            reply.Status = StatusEnum.Success;
        }
        else
        {
            reply.Status = StatusEnum.Failure;
        }

        reply.ErrorCode = cxReply.getQueryMemberLevelResult().getResultCode();
        reply.ErrorMessage = cxReply.getQueryMemberLevelResult().getMessage();

        return reply;
	}
	// endregion
	
	//region 注册会员卡（完成）
	public CTMSCardRegisterReply CardRegister(Usercinemaview userCinema, String CardPassword, String LevelCode, String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex){
		CTMSCardRegisterReply reply = new CTMSCardRegisterReply();
		CxPhoneNumRegResult cxReply=cxService.PhoneNumReg(userCinema, CardPassword, LevelCode, InitialAmount, CardUserName, MobilePhone, IDNumber, Sex);
		if (cxReply.getPhoneNumRegResult().getResultCode().equals("0"))
        {
			Membercard membercard = new Membercard();
			membercard.setCinemaCode(userCinema.getCinemaCode());
			membercard.setCardNo(MobilePhone);//辰星系统卡号就是手机号
			membercard.setCardPassword(CardPassword);
			membercard.setMobilePhone(MobilePhone);
			membercard.setLevelCode(LevelCode);
			Membercardlevel membercardlevel = _membercardlevelService.getByCinemaCodeAndLevelCode(userCinema.getCinemaCode(), LevelCode);
			membercard.setLevelName(membercardlevel.getLevelName());
			membercard.setUserName(CardUserName);
			membercard.setSex(Sex);
			membercard.setCreditNum(IDNumber);
			membercard.setCreateTime(new Date());
			membercard.setStatus(0);
			_membercardService.Save(membercard);
			
            reply.Status = StatusEnum.Success;
        }
        else
        {
            reply.Status = StatusEnum.Failure;
        }

        reply.ErrorCode = cxReply.getPhoneNumRegResult().getResultCode();
        reply.ErrorMessage = cxReply.getPhoneNumRegResult().getMessage();

        return reply;
	}
	//endregion

	//region 查询影院卖品（完成）
	@Override
	public CTMSQueryGoodsReply QueryGoods(Usercinemaview userCinema) throws Exception {
		CTMSQueryGoodsReply reply=new CTMSQueryGoodsReply();
		CxQueryMerchandiseResult cxReply=cxService.QueryMerchandise(userCinema);
		if("0".equals(cxReply.getQueryMerchandiseResult().getResultCode())){
			List<MerBean> Mers=cxReply.getQueryMerchandiseResult().getMers().getMer();
			if(Mers.size()>0){
				List<Goods> goodsList=new ArrayList<Goods>();
				for(MerBean Mer:Mers){
					Goods goods=new Goods();
					CxModelMapper.MapToEntity(Mer, goods);
					goods.setCinemaCode(userCinema.getCinemaCode());
					goods.setUserId(userCinema.getUserId());
					goodsList.add(goods);
				}
				//先删除旧的卖品
				_goodsService.deleteByCinemaCode(userCinema.getUserId(),userCinema.getCinemaCode());
				// 插入卖品信息
				for (Goods goods : goodsList) {
					_goodsService.save(goods);
				}
				reply.Status = StatusEnum.Success;
			}
		}else {
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getQueryMerchandiseResult().getResultCode();
		reply.ErrorMessage = cxReply.getQueryMerchandiseResult().getMessage();
		return reply;
	}
	//endregion
	
	//region 创建卖品订单（完成）
	@Override
	public CTMSCreateGoodsOrderReply CreateGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
			throws Exception {
		CTMSCreateGoodsOrderReply reply=new CTMSCreateGoodsOrderReply();
		CxCreateMerOrderResult cxReply=cxService.CreateMerOrder(userCinema, order);
		if(cxReply.getCreateMerOrderResult().getResultCode().equals("0")){
			order.getOrderBaseInfo().setLocalOrderCode(cxReply.getCreateMerOrderResult().getOrderCode());
			order.getOrderBaseInfo().setCreated(new Date());
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Created.getStatusCode());
			reply.setOrderCode(cxReply.getCreateMerOrderResult().getOrderCode());
			reply.Status = StatusEnum.Success;
		}else {
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.CreatFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(cxReply.getCreateMerOrderResult().getMessage());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getCreateMerOrderResult().getResultCode();
		reply.ErrorMessage = cxReply.getCreateMerOrderResult().getMessage();
		return reply;
	}
	//endregion

	//region 确认卖品订单（完成）
	@Override
	public CTMSSubmitGoodsOrderReply SubmitGoodsOrder(Usercinemaview userCinema, GoodsOrderView order)
			throws Exception {
		CTMSSubmitGoodsOrderReply reply=new CTMSSubmitGoodsOrderReply();
		CxSubmitMerOrderResult cxReply=cxService.SubmitMerOrder(userCinema, order);
		if(cxReply.getSubmitMerOrderResult().getResultCode().equals("0")){
			order.getOrderBaseInfo().setOrderCode(cxReply.getSubmitMerOrderResult().getOrderCode());
			order.getOrderBaseInfo().setPickUpCode(cxReply.getSubmitMerOrderResult().getPrintNo());
			order.getOrderBaseInfo().setVerifyCode(cxReply.getSubmitMerOrderResult().getVerifyCode());
			order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Complete.getStatusCode());
			order.getOrderBaseInfo().setSubmitTime(new Date());
			reply.Status = StatusEnum.Success;
		}else {
			order.getOrderBaseInfo().setOrderStatus(OrderStatusEnum.SubmitFail.getStatusCode());
			order.getOrderBaseInfo().setErrorMessage(cxReply.getSubmitMerOrderResult().getMessage());
			reply.Status = StatusEnum.Failure;
		}
		reply.ErrorCode = cxReply.getSubmitMerOrderResult().getResultCode();
		reply.ErrorMessage = cxReply.getSubmitMerOrderResult().getMessage();
		return reply;
	}
    //endregion
	
	//region 查询卖品订单（完成）
	@Override
	public CTMSQueryGoodsOrderReply QueryGoodsOrder(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
		CTMSQueryGoodsOrderReply reply=new CTMSQueryGoodsOrderReply();
		CxQueryOrderDetailResult cxReply=cxService.QueryOrderDetail(userCinema, order);
		if(cxReply.getQueryOrderDetailResult().getResultCode().equals("0") && !cxReply.getQueryOrderDetailResult().getOrderStatus().equals("1")){
			if (cxReply.getQueryOrderDetailResult().getOrderStatus().equals("2")) {
				order.getOrderBaseInfo().setOrderStatus(GoodsOrderStatusEnum.Refund.getStatusCode());
				order.getOrderBaseInfo().setRefundTime(order.getOrderBaseInfo().getRefundTime() == null ? new Date()
						: order.getOrderBaseInfo().getRefundTime());
			}
			reply.Status = StatusEnum.Success;
		}else if (cxReply.getQueryOrderDetailResult().getOrderStatus().equals("1")) {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = "-1";
			reply.ErrorMessage = "订单交易状态：提交失败！";
		}else {
			reply.Status = StatusEnum.Failure;
			reply.ErrorCode = cxReply.getQueryOrderDetailResult().getResultCode();
			reply.ErrorMessage = cxReply.getQueryOrderDetailResult().getMessage();
		}
		return reply;
	}
	//endregion

	//region 退订卖品（完成）
	@Override
	public CTMSRefundGoodsReply RefundGoods(Usercinemaview userCinema, GoodsOrderView order) throws Exception {
		CTMSRefundGoodsReply reply=new CTMSRefundGoodsReply();
		reply.Status=StatusEnum.Success;
		return reply;
	}
	//endregion
}
