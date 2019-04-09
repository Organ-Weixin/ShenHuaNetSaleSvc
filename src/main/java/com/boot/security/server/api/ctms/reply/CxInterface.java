package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.boot.security.server.api.ctms.reply.CxQueryCinemaInfoResult.ResBean.CinemaBean.ScreensBean.ScreenVOBean;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.oristartech.tsp.ws.soap.WebService;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.StatusEnum;

public class CxInterface implements ICTMSInterface {
	private WebService cxService;
	private CinemaServiceImpl _cinemaService;
	private ScreeninfoServiceImpl _screeninfoService;
	
	private static final String pCompress = "0";
	public CxInterface(){
		cxService=new WebService();
		_cinemaService = new CinemaServiceImpl();
		_screeninfoService=new ScreeninfoServiceImpl();
	}
	
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema)
    {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		CxQueryCinemaInfoResult cxReply=cxService.QueryCinemaInfo(userCinema);
		if(cxReply.getQueryCinemaInfoResult().getResultCode()=="0"){
			//更新影院信息
			Cinema cinema=_cinemaService.getByCinemaCode(userCinema.getCinemaCode());
			cinema.setName(cxReply.getQueryCinemaInfoResult().getCinema().getCinemaName());
			cinema.setAddress(cxReply.getQueryCinemaInfoResult().getCinema().getAddress());
			cinema.setScreenCount(Integer.parseInt(cxReply.getQueryCinemaInfoResult().getCinema().getScreenCount()));
			_cinemaService.update(cinema);
			//更新影厅信息
			//List<Screeninfo> oldScreens= _screeninfoService.getByCinemaCode(userCinema.getCinemaCode());
			List<Screeninfo> newScreens = null;
			List<ScreenVOBean> screenvos=cxReply.getQueryCinemaInfoResult().getCinema().getScreens().getScreenVO();
			for(ScreenVOBean screenvo:screenvos)
			{
				Screeninfo screen=new Screeninfo();//先读取本地
				CxModelMapper.MapToEntity(screenvo,screen);
				screen.setCCode(userCinema.getCinemaCode());
				newScreens.add(screen);
			}
			//先删除旧影影厅
			_screeninfoService.deleteByCinemaCode(userCinema.getCinemaCode());
			//插入影厅信息
			for(Screeninfo screen:newScreens){
				_screeninfoService.save(screen);
			}
			reply.Status = StatusEnum.Success;
		}
		else
        {
            reply.Status = StatusEnum.Failure;
        }
		reply.ErrorCode = cxReply.getQueryCinemaInfoResult().getResultCode();
        reply.ErrorMessage = cxReply.getQueryCinemaInfoResult().getMessage();
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
