package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.boot.security.server.api.ctms.reply.CxQueryCinemaInfoResult.ResBean.CinemaBean.ScreensBean.ScreenVOBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetCinemaResult.ResBean.CinemasBean.CinemaBean;
import com.boot.security.server.api.ctms.reply.Dy1905GetScreenResult.ResBean.ScreensBean.ScreenBean;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.SessionSeatStatusEnum;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.gson.Gson;

public class Dy1905Interface implements ICTMSInterface {
	private CinemaServiceImpl _cinemaService;
	private ScreeninfoServiceImpl _screeninfoService;
	public Dy1905Interface(){
		_cinemaService = new CinemaServiceImpl();
		_screeninfoService=new ScreeninfoServiceImpl();
	}

	@Override
	public CTMSQueryCinemaReply QueryCinema(Usercinemaview userCinema) throws Exception {
		CTMSQueryCinemaReply reply = new CTMSQueryCinemaReply();
		if (userCinema.getCinemaId().isEmpty())
        {
            if (!QueryCinemaId(userCinema))
            {
                reply.GetDy1905CinemaNotValidReply();
                return reply;
            }
        }
		String pVerifyInfo = MD5Util.MD5Encode(userCinema.getDefaultUserName() + userCinema.getCinemaId() + userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pCinemaID",userCinema.getCinemaId());
		param.put("pVerifyInfo",pVerifyInfo);
		String getScreenResult = HttpHelper.httpClientPost(userCinema.getUrl() + "/GetScreen",param,"UTF-8");
		Gson gson = new Gson();
		Dy1905GetScreenResult Dy1905Reply=gson.fromJson(XmlToJsonUtil.xmltoJson(getScreenResult,"GetScreenResult"), Dy1905GetScreenResult.class);
		if (Dy1905Reply.getGetScreenResult().getResultCode() == "0")
        {
			//更新影院信息
			Cinema cinema=_cinemaService.getByCinemaCode(userCinema.getCinemaCode());
			cinema.setScreenCount(Dy1905Reply.getGetScreenResult().getScreens().getScreen().size());
			_cinemaService.update(cinema);
			//更新影厅信息
			//List<Screeninfo> oldScreens= _screeninfoService.getByCinemaCode(userCinema.getCinemaCode());
			List<Screeninfo> newScreens = null;
			List<ScreenBean> dyscreens=Dy1905Reply.getGetScreenResult().getScreens().getScreen();
			for(ScreenBean dyscreen:dyscreens)
			{
				Screeninfo screen=new Screeninfo();//先读取本地
				Dy1905ModelMapper.MapToEntity(dyscreen,screen);
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
		reply.ErrorCode = Dy1905Reply.getGetScreenResult().getResultCode();
		return reply;
	}
	//Usercinemaview userCinema
	private static boolean QueryCinemaId(Usercinemaview userCinema) throws Exception
    {
		String pVerifyInfo=MD5Util.MD5Encode(userCinema.getDefaultUserName()+userCinema.getDefaultPassword(),"UTF-8").toLowerCase();
		Map<String,String> param = new LinkedHashMap();
		param.put("pAppCode",userCinema.getDefaultUserName());
		param.put("pVerifyInfo",pVerifyInfo);
		String getCinemaResult = HttpHelper.httpClientPost(userCinema.getUrl() + "/GetCinema", param,"UTF-8");
		Gson gson = new Gson();
		Dy1905GetCinemaResult Dy1905Reply = gson.fromJson(XmlToJsonUtil.xmltoJson(getCinemaResult,"GetCinemaResult"), Dy1905GetCinemaResult.class);
		if (Dy1905Reply.getGetCinemaResult().getResultCode()=="0")
        {
			CinemaBean dy1905Cinema=(CinemaBean) Dy1905Reply.getGetCinemaResult().getCinemas().getCinema()
					.stream().filter((CinemaBean cinema)->cinema.getCinemaCode()==userCinema.getCinemaCode())
					.collect(Collectors.toList());
			if (dy1905Cinema != null)
            {
				CinemaServiceImpl _cinemaService=new CinemaServiceImpl();//静态方法内不能直接调用再实例化一次
                Cinema cinema = _cinemaService.getByCinemaCode(userCinema.getCinemaCode());
                cinema.setName(dy1905Cinema.getCinemaName());
                cinema.setCinemaId(dy1905Cinema.getCinemaNo());
                _cinemaService.update(cinema);
                userCinema.setCinemaId(dy1905Cinema.getCinemaNo());
                return true;
            }
            else
            {
                return false;
            }
        }
		else{
			return false;
		}
    }
	public static void main(String[] args) throws Exception {
		//Dy1905GetCinemaResult result=QueryCinemaId();
		//System.out.println(result.getGetCinemaResult().getCinemas().getCinema().get(0).getCinemaName());
	}

	@Override
	public CTMSQuerySeatReply QuerySeat(Usercinemaview userCinema, Screeninfo screen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryFilmReply QueryFilm(Usercinemaview userCinema, Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQuerySessionReply QuerySession(Usercinemaview userCinema, Date StartDate, Date EndDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQuerySessionSeatReply QuerySessionSeat(Usercinemaview userCinema, String SessionCode,
			SessionSeatStatusEnum Status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSLockSeatReply LockSeat(Usercinemaview userCinema, OrderView order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSReleaseSeatReply ReleaseSeat(Usercinemaview userCinema, OrderView order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSSubmitOrderReply SubmitOrder(Usercinemaview userCinema, OrderView order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryPrintReply QueryPrint(Usercinemaview userCinema, OrderView order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSRefundTicketReply RefundTicket(Usercinemaview userCinema, OrderView order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryOrderReply QueryOrder(Usercinemaview userCinema, OrderView order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSQueryTicketReply QueryTicket(Usercinemaview userCinema, OrderView order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTMSFetchTicketReply FetchTicket(Usercinemaview userCinema, OrderView order) {
		// TODO Auto-generated method stub
		return null;
	}

}
