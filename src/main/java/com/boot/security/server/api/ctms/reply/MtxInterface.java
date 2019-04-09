package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.List;

import com.boot.security.server.api.ctms.reply.CxQueryCinemaInfoResult.ResBean.CinemaBean.ScreensBean.ScreenVOBean;
import com.boot.security.server.api.ctms.reply.MtxGetHallResult.ResBean.HallsBean.HallBean;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;

import cn.cmts.main.webservice.WebService;

public class MtxInterface implements ICTMSInterface {
	private WebService mtxService;
	private CinemaServiceImpl _cinemaService;
	private ScreeninfoServiceImpl _screeninfoService;
	private ScreenseatinfoServiceImpl _screenseatinfoService;
	
	public MtxInterface() {
		mtxService = new WebService();
		_cinemaService = new CinemaServiceImpl();
		_screeninfoService = new ScreeninfoServiceImpl();
		_screenseatinfoService = new ScreenseatinfoServiceImpl();
	}

	// 查询影厅信息
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		MtxGetHallResult mtxReply = mtxService.GetHall(userCinema);
		if (mtxReply.getGetHallResult().getResultCode() == "0") {
			// 更新影厅信息
			// List<Screeninfo> oldScreens= _screeninfoService.getByCinemaCode(userCinema.getCinemaCode());
			List<Screeninfo> newScreens = null;
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

	@Override
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,
			SessionSeatStatusEnum Status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
