package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryScreenInfoReply;
import com.boot.security.server.apicontroller.reply.QueryScreenInfoReply.QueryScreensReplyScreenInfo;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsArrangementReply;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsArrangementReply.DataBean;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsArrangementReply.DataBean.RowBean;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsArrangementReply.DataBean.RowBean.SeatBean;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsReply;
import com.boot.security.server.apicontroller.reply.QueryScreenSeatsReply.QueryScreenSeatsReplyScreenSeats.QueryScreenSeatsReplyScreenSeat;
import com.boot.security.server.apicontroller.reply.QueryScreensReply;
import com.boot.security.server.apicontroller.reply.QueryScreensReply.QueryScreensReplyScreens.QueryScreensReplyScreen;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.dao.ScreeninfoDao;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Screeninfo;
import com.boot.security.server.model.Screenseatinfo;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.ScreeninfoServiceImpl;
import com.boot.security.server.service.impl.ScreenseatinfoServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Screen")
public class ScreenController {
	
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
    private ScreeninfoDao screeninfoDao;
	@Autowired 
	private ScreeninfoServiceImpl _screeninfoService;
	@Autowired
	private ScreenseatinfoServiceImpl _screenseatinfoService;
	@Autowired
	private RedisTemplate redisTemplate;

	private static final Logger log = LoggerFactory.getLogger(SessionController.class);


	//region 获取影厅列表
	@GetMapping("/QueryScreens/{Username}/{Password}/{CinemaCode}")
	@ApiOperation(value = "获取影厅列表")
    public QueryScreensReply QueryScreens(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode){

		log.info("/Api/Screen/QueryScreens :"+Username+"|"+Password+"|"+CinemaCode);

		QueryScreensReply queryScreensReply=new QueryScreensReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryScreensReply,Username, Password, CinemaCode))
        {
            return queryScreensReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryScreensReply.SetUserCredentialInvalidReply();
            return queryScreensReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryScreensReply.SetCinemaInvalidReply();
            return queryScreensReply;
        }
		List<Screeninfo> screeninfos=screeninfoDao.getByCinemaCode(CinemaCode);
		queryScreensReply.setData(queryScreensReply.new QueryScreensReplyScreens());
		if(screeninfos==null||screeninfos.size()==0){
			queryScreensReply.getData().setScreenCount(0);
		}else{
			queryScreensReply.getData().setScreenCount(screeninfos.size());
			queryScreensReply.getData().setScreen(new ArrayList<QueryScreensReplyScreen>());
			for(Screeninfo screeninfo:screeninfos){
				QueryScreensReplyScreen replyscreen=queryScreensReply.getData().new QueryScreensReplyScreen();
				ModelMapper.MapFrom(replyscreen, screeninfo);
				queryScreensReply.getData().getScreen().add(replyscreen);
			}
		}
		queryScreensReply.SetSuccessReply();
		return queryScreensReply;
    }
	//endregion
	
	//region 根据影厅编码获取影厅信息
	@GetMapping("/QueryScreenInfo/{Username}/{Password}/{CinemaCode}/{ScreenCode}")
	@ApiOperation(value = "根据影厅编码获取影厅信息")
	public QueryScreenInfoReply QueryScreenInfo(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode, @PathVariable String ScreenCode){

		log.info("/Api/Screen/QueryScreenInfo :"+Username+"|"+Password+"|"+CinemaCode+"|"+ScreenCode);

		QueryScreenInfoReply queryScreenInfoReply = new QueryScreenInfoReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryScreenInfoReply, Username, Password, CinemaCode, ScreenCode))
        {
            return queryScreenInfoReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryScreenInfoReply.SetUserCredentialInvalidReply();
            return queryScreenInfoReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryScreenInfoReply.SetCinemaInvalidReply();
            return queryScreenInfoReply;
        }
        queryScreenInfoReply.setData(queryScreenInfoReply.new QueryScreensReplyScreenInfo());
        //验证影厅编码是否正确
        Screeninfo screeninfo = _screeninfoService.getByScreenCode(CinemaCode, ScreenCode);
        if(screeninfo == null){
        	queryScreenInfoReply.SetScreenInvalidReply();
        	return queryScreenInfoReply;
        }else{
        	QueryScreensReplyScreenInfo replyscreeninfo = queryScreenInfoReply.getData();
        	ModelMapper.MapFrom(replyscreeninfo, screeninfo);
        }
        queryScreenInfoReply.SetSuccessReply();
		return queryScreenInfoReply;
	}
	//endregion
	
	//region 根据影厅编码获取影厅座位信息
	@GetMapping("/QueryScreenSeats/{Username}/{Password}/{CinemaCode}/{ScreenCode}")
	@ApiOperation(value = "根据影厅编码获取影厅座位信息")
	public QueryScreenSeatsReply QueryScreenSeats(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode, @PathVariable String ScreenCode){

		log.info("/Api/Screen/QueryScreenSeats :"+Username+"|"+Password+"|"+CinemaCode+"|"+ScreenCode);

		QueryScreenSeatsReply queryScreenSeatsReply = new QueryScreenSeatsReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryScreenSeatsReply, Username, Password, CinemaCode, ScreenCode))
        {
            return queryScreenSeatsReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryScreenSeatsReply.SetUserCredentialInvalidReply();
            return queryScreenSeatsReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryScreenSeatsReply.SetCinemaInvalidReply();
            return queryScreenSeatsReply;
        }
        //验证影厅是否存在且可访问
        Screeninfo screeninfo = _screeninfoService.getByScreenCode(CinemaCode, ScreenCode);
        if(screeninfo == null){
        	queryScreenSeatsReply.SetScreenInvalidReply();
        	return queryScreenSeatsReply;
        }
        List<Screenseatinfo> screenseatinfos = _screenseatinfoService.getByCinemaCodeAndScreenCode(CinemaCode, ScreenCode);
        queryScreenSeatsReply.setData(queryScreenSeatsReply.new QueryScreenSeatsReplyScreenSeats());
        if(screenseatinfos==null||screenseatinfos.size()==0){
        	queryScreenSeatsReply.getData().setSeatCount(screenseatinfos.size());
        }else{
        	queryScreenSeatsReply.getData().setSeatCount(screenseatinfos.size());
        	queryScreenSeatsReply.getData().setSeats(new ArrayList<QueryScreenSeatsReplyScreenSeat>());
        	for(Screenseatinfo screenseatinfo :screenseatinfos){
        		QueryScreenSeatsReplyScreenSeat replyscreenseat = queryScreenSeatsReply.getData().new QueryScreenSeatsReplyScreenSeat();
        		ModelMapper.MapFrom(replyscreenseat, screenseatinfo);
        		queryScreenSeatsReply.getData().getSeats().add(replyscreenseat);
        	}
        }
        queryScreenSeatsReply.SetSuccessReply();
		return queryScreenSeatsReply;
	}
	//endregion
	
	//region 根据影厅编码获取影厅座位信息(按坐标重新排列整合)
	@GetMapping("/QueryScreenSeatsArrangement/{Username}/{Password}/{CinemaCode}/{ScreenCode}")
	@ApiOperation(value = "根据影厅编码获取影厅座位信息(按坐标重新排列整合)")
	public QueryScreenSeatsArrangementReply QueryScreenSeatsArrangement(@PathVariable String Username,@PathVariable String Password,@PathVariable String CinemaCode, @PathVariable String ScreenCode){

		log.info("/Api/Screen/QueryScreenSeatsArrangement :"+Username+"|"+Password+"|"+CinemaCode+"|"+ScreenCode);

		QueryScreenSeatsArrangementReply queryScreenSeatsArrangementReply = new QueryScreenSeatsArrangementReply();
		//校验参数
        if (!ReplyExtension.RequestInfoGuard(queryScreenSeatsArrangementReply, Username, Password, CinemaCode, ScreenCode))
        {
            return queryScreenSeatsArrangementReply;
        }
        //获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(Username, Password);
        if (UserInfo == null)
        {
        	queryScreenSeatsArrangementReply.SetUserCredentialInvalidReply();
            return queryScreenSeatsArrangementReply;
        }
        //验证影院是否存在且可访问
        Cinema cinema = _cinemaService.getByCinemaCode(CinemaCode);
        if (cinema == null)
        {
        	queryScreenSeatsArrangementReply.SetCinemaInvalidReply();
            return queryScreenSeatsArrangementReply;
        }
        //验证影厅是否存在且可访问
        Screeninfo screeninfo = _screeninfoService.getByScreenCode(CinemaCode, ScreenCode);
        if(screeninfo == null){
        	queryScreenSeatsArrangementReply.SetScreenInvalidReply();
        	return queryScreenSeatsArrangementReply;
        }
        //读取影厅座位
		List<Screenseatinfo> screenseatinfos = null;
		if (redisTemplate.boundHashOps("seats:"+CinemaCode).hasKey(ScreenCode)){
			screenseatinfos = JSON.parseArray((String)redisTemplate.boundHashOps("seats:"+CinemaCode).get(ScreenCode),Screenseatinfo.class);
		}else {
			screenseatinfos = _screenseatinfoService.getByCinemaCodeAndScreenCode(CinemaCode, ScreenCode);
			redisTemplate.boundHashOps("seats:"+CinemaCode).put(ScreenCode,JSON.toJSONString(screenseatinfos));
			redisTemplate.expire("seats:"+CinemaCode,24l, TimeUnit.HOURS);
		}


        if(screenseatinfos!=null){
        	//region 座位排列组合
            int MaxColumn=0;//最大纵坐标
            int MinColumn=9999;//最小纵坐标
            int MaxRow=0;//最大横坐标
            int MinRow=9999;//最小横坐标
            for(Screenseatinfo seat:screenseatinfos){
            	//得到最大纵坐标
            	if(seat.getXCoord()>MaxColumn){
            		MaxColumn=seat.getXCoord();
            	}
            	//得到最小纵坐标
            	if(seat.getXCoord()<MinColumn){
            		MinColumn=seat.getXCoord();
            	}
            	//得到最大横坐标
            	if(seat.getYCoord()>MaxRow){
            		MaxRow=seat.getYCoord();
            	}
            	//得到最小横坐标
            	if(seat.getYCoord()<MinRow){
            		MinRow=seat.getYCoord();
            	}
            }
            queryScreenSeatsArrangementReply.getData().setRows(new ArrayList<RowBean>());
            //循环行
            for(int currentRow=MinRow;currentRow<=MaxRow;currentRow++){
            	int currentRow1=currentRow;
            	//System.out.println(currentRow1);
            	//得到当前行的座位列表
            	List<Screenseatinfo> currentRowSeats = screenseatinfos.stream().filter(st->st.getYCoord()==currentRow1).collect(Collectors.toList());
//            	System.out.println("-----"+new Gson().toJson(currentRowSeats));
            	if(currentRowSeats!=null && currentRowSeats.size()>0){
            		RowBean rowBean=new RowBean();
            		rowBean.setRowNum(currentRowSeats.get(0).getRowNum());
            		rowBean.setSeats(new ArrayList<SeatBean>());
            		for(int currentColumn=MinColumn;currentColumn<=MaxColumn;currentColumn++){
            			int currentColumn1=currentColumn;
            			//System.out.println(currentColumn1);
            			List<Screenseatinfo> seat=currentRowSeats.stream().filter(s->s.getXCoord()==currentColumn1).collect(Collectors.toList());
            			//System.out.println("===seat===="+new Gson().toJson(seat));
            			if(seat!=null&&seat.size()>0){
            				SeatBean seatBean=new SeatBean();
            				seatBean.setSeatCode(seat.get(0).getSeatCode());
            				seatBean.setGroupCode(seat.get(0).getGroupCode());
            				seatBean.setRowNum(seat.get(0).getRowNum());
            				seatBean.setColumnNum(seat.get(0).getColumnNum());
            				seatBean.setStatus(seat.get(0).getStatus());
            				seatBean.setLoveFlag(seat.get(0).getLoveFlag());
            				seatBean.setType(seat.get(0).getType());
            				rowBean.getSeats().add(seatBean);
            			}else
            			{
            				rowBean.getSeats().add(null);
            			}
            		}
            		queryScreenSeatsArrangementReply.getData().getRows().add(rowBean);//添加行
            	}else{
            		queryScreenSeatsArrangementReply.getData().getRows().add(null);
            	}
            }
            //endregion
        }
        queryScreenSeatsArrangementReply.SetSuccessReply();
		return queryScreenSeatsArrangementReply;
	}
	//endregion
	
}
