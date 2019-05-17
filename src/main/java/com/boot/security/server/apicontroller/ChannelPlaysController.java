package com.boot.security.server.apicontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.CinemaChannelPlaysInput;
import com.boot.security.server.apicontroller.reply.CinemaChannelPlaysReply;
import com.boot.security.server.apicontroller.reply.CinemaChannelPlaysReply.FilmInfoBean;
import com.boot.security.server.apicontroller.reply.CinemaChannelPlaysReply.FilmInfoBean.Plays;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.DatatypeEnum;
import com.boot.security.server.model.Filminfo;
import com.boot.security.server.model.Qmmprice;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.StatusEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.service.impl.QmmpriceServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.MD5Util;

import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/Api/Price")
public class ChannelPlaysController {

	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private UserCinemaViewServiceImpl _userCinemaViewService;
	@Autowired
	private FilminfoServiceImpl _filmInfoService;
	@Autowired
	private QmmpriceServiceImpl qmmpriceService;
	@Autowired
	private SessioninfoServiceImpl sessioninfoService;
	
	@PostMapping("/getCinemaChannelPlays")
	@ApiOperation(value = "查询第三方场次价格")
	public CinemaChannelPlaysReply getCinemaChannelPlays(@RequestBody CinemaChannelPlaysInput input) throws Exception{
		CinemaChannelPlaysReply reply = new CinemaChannelPlaysReply();
		// 校验参数
		if (!ReplyExtension.RequestInfoGuard(reply, input.getUserName(), input.getPassword(), input.getCinemaCode(), input.getFilmCode())) {
			return reply;
		}
		// 获取用户信息
		Userinfo UserInfo = _userInfoService.getByUserCredential(input.getUserName(), input.getPassword());
		if (UserInfo == null) {
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		// 验证影院是否存在且可访问
		Usercinemaview userCinema = _userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(),input.getCinemaCode());
		if (userCinema == null) {
			reply.SetCinemaInvalidReply();
			return reply;
		}
		//验证影片是否存在且可访问
		Filminfo filminfo=_filmInfoService.getByFilmCode(input.getFilmCode());
        if(filminfo == null){
        	reply.SetFilmCodeNotExistReply();
            return reply;
        }
        
		//调用趣满满的第三方场次价格接口
        String channelId = "30027";
        String key = "3b82e0e1c787f8abf337c2c2c8ce7101";
        Long cinemaId = changeCinemaId(input.getCinemaCode());
        
        StringBuffer buf1 = new StringBuffer();
		buf1.append("channelId");
		buf1.append(channelId);
		buf1.append("cinemaId");
		buf1.append(cinemaId);
		buf1.append(key);//key值
		String sign1 = MD5Util.MD5Encode(buf1.toString(), "UTF-8");
		Map<String,Object> param1 = new LinkedHashMap<String,Object>();
		param1.put("channelId", channelId);
		param1.put("cinemaId", cinemaId);
		param1.put("sign", sign1);
		
		String Film_URL = "http://webapi2.qingbh.com/manman/index.php/open/partner/queryFilms";  //查询影片列表
		JSONObject returnFilm = HttpHelper.sendHttp(param1, Film_URL);
//		System.out.println("接口返回："+returnFilm);
		if(returnFilm.get("code").equals(0)){
			JSONObject resultJson = JSONObject.fromObject(returnFilm.get("result"));
			JSONArray arr = (JSONArray) resultJson.get("filmList");  //拿到的是该影院下所有的排片，需要的是filmId
			JSONObject arrJson = null;
			Object filmId = null;
			System.out.println(111);
			String screen_url="http://webapi2.qingbh.com/manman/index.php/open/partner/getCinemaChannelPlays";	//查询第三方场次价格
			for(int i = 0; i < arr.size(); i++){	//根据filmId获取场次信息
				arrJson = JSONObject.fromObject(arr.get(i));
				filmId = arrJson.get("filmId");
                StringBuffer buf2 = new StringBuffer();
    			buf2.append("channelId");
    			buf2.append(channelId);
    			buf2.append("cinemaId");
    			buf2.append(cinemaId);
    			buf2.append("filmId");
                buf2.append(filmId);
    			buf2.append(key);
    			String screensign = MD5Util.MD5Encode(buf2.toString(), "UTF-8");
    			
    			Map<String,Object> param2 = new HashMap<String,Object>();
    			param2.put("channelId", channelId);
    			param2.put("cinemaId", cinemaId);
    			param2.put("filmId", filmId);
    			param2.put("sign", screensign);
    			JSONObject screenJson = HttpHelper.sendHttp(param2, screen_url);
//    			System.out.println("接口返回："+screenJson);
    			if(screenJson.get("code").equals(0)){
    				JSONObject screenResultJson = JSONObject.fromObject(screenJson.get("result"));
                    JSONArray screenArr = (JSONArray) screenResultJson.get("data");
                    for(int j = 0; j < screenArr.size(); j++){
                    	JSONObject screenPlaysJson = JSONObject.fromObject(screenArr.get(j));
                    	JSONArray screenPlaysArr = (JSONArray) screenPlaysJson.get("plays");
                    	for(int k = 0; k < screenPlaysArr.size(); k++){
                    		JSONObject lastJson = JSONObject.fromObject(screenPlaysArr.get(k));
                    		String dataType = String.valueOf(lastJson.get("datatype"));
                    		String showId = String.valueOf(lastJson.get("showId"));
                    		String showTime = String.valueOf(lastJson.get("showTime"));
                    		Qmmprice qmmprice = qmmpriceService.getByShowId(showId);
                    		if(qmmprice == null){
                    			qmmprice = new Qmmprice();
                    			qmmprice.setCinemaCode(userCinema.getCinemaCode());
                    			qmmprice.setCinemaName(userCinema.getCinemaName());
                    			qmmprice.setCinemaId(String.valueOf(cinemaId));
                    			qmmprice.setScreenName(String.valueOf(lastJson.get("hallName")));
                    			qmmprice.setFilmId(String.valueOf(filmId));
                    			qmmprice.setFilmName(String.valueOf(lastJson.get("filmName")));
                    			qmmprice.setDataType(dataType);
                    			qmmprice.setDataName(DatatypeEnum.getNameByCode(dataType));
                    			qmmprice.setShowId(String.valueOf(lastJson.get("showId")));
                    			qmmprice.setShowTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(showTime));
                    			qmmprice.setPrice(Double.parseDouble(String.valueOf(lastJson.get("price"))));
                    			qmmprice.setSettlePrice(Double.parseDouble(String.valueOf(lastJson.get("settlePrice"))));
                    			qmmprice.setMinPrice(Double.parseDouble(String.valueOf(lastJson.get("minPrice"))));
                    			qmmprice.setUpdated(new Date());
                    			qmmpriceService.save(qmmprice);	//新增
                    		} else {
                    			qmmprice.setScreenName(String.valueOf(lastJson.get("hallName")));
                    			qmmprice.setFilmId(String.valueOf(filmId));
                    			qmmprice.setFilmName(String.valueOf(lastJson.get("filmName")));
                    			qmmprice.setDataType(dataType);
                    			qmmprice.setDataName(DatatypeEnum.getNameByCode(dataType));
                    			qmmprice.setShowTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(showTime));
                    			qmmprice.setPrice(Double.parseDouble(String.valueOf(lastJson.get("price"))));
                    			qmmprice.setSettlePrice(Double.parseDouble(String.valueOf(lastJson.get("settlePrice"))));
                    			qmmprice.setMinPrice(Double.parseDouble(String.valueOf(lastJson.get("minPrice"))));
                    			qmmprice.setUpdated(new Date());
                    			qmmpriceService.update(qmmprice);	//更新
                    		}
                    	}
                    }
    				
    			} else {
    				reply.Status = StatusEnum.Failure.getStatusCode();
    				reply.ErrorCode = screenJson.get("code").toString();
    				reply.ErrorMessage = screenJson.get("errorMsg").toString();
    				return reply;
    			}
                
			}
			
		} else {
			reply.Status = StatusEnum.Failure.getStatusCode();
			reply.ErrorCode = returnFilm.get("code").toString();
			reply.ErrorMessage = returnFilm.get("errorMsg").toString();
			return reply;
		}
		//返回
		List<Sessioninfo> sessioninfos = sessioninfoService.getByCinemafilm(input.getCinemaCode(), input.getFilmCode());
		List<FilmInfoBean> data = new ArrayList<FilmInfoBean>();
		for(Sessioninfo session : sessioninfos){
			FilmInfoBean film = new FilmInfoBean();
			film.setScreenCode(session.getScreenCode());
			film.setFilmCode(session.getFilmCode());
			film.setFilmName(session.getFilmName());
			film.setSessionTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getStartTime()));
			
			List<Plays> plays = new ArrayList<Plays>();
			if(session.getQmmprices() != null){
				for(Qmmprice qmmprice : session.getQmmprices()){
					Plays play = new Plays();
					play.setChannelCode(qmmprice.getDataType());
					play.setChannelName(qmmprice.getDataName());
					play.setStandardPrice(String.valueOf(qmmprice.getPrice()));
					play.setSettlePrice(String.valueOf(qmmprice.getSettlePrice()));
					play.setMinPrice(String.valueOf(qmmprice.getMinPrice()));
					plays.add(play);
					film.setScreenName(qmmprice.getScreenName());
				}
			}
			film.setPlays(plays);
			data.add(film);
		}
		reply.setData(data);
		reply.SetSuccessReply();
		return reply;
	}
	
	public Long changeCinemaId(String cinemaCode){
        Long cinemaId = null;
        if(cinemaCode.equals("33022401")){
            cinemaId=6892L;
        }else if(cinemaCode.equals("33018361")){
            cinemaId=20518L;
        }else if(cinemaCode.equals("33019471")){
            cinemaId=18623L;
        }else if(cinemaCode.equals("33111001")){
            cinemaId=1894L;
        }else if(cinemaCode.equals("33118361")){
            cinemaId=20194L;
        }else if(cinemaCode.equals("33093701")){
            cinemaId=1929L;
        }else if(cinemaCode.equals("33063201")){
            cinemaId=6751L;
        }else if(cinemaCode.equals("34160701")){
            cinemaId=17824L;
        }else if(cinemaCode.equals("33079701")){
            cinemaId=25230L;
        }else if(cinemaCode.equals("33112801")){
            cinemaId=26166L;
        }else if(cinemaCode.equals("33112911")){
            cinemaId=26165L;
        }else if(cinemaCode.equals("33097601")){
            cinemaId=25420L;
        }else if(cinemaCode.equals("33096401")){
            cinemaId=24629L;
        }
        return cinemaId;
    }
}
