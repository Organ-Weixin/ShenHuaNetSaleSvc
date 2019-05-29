package com.boot.security.server.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.DatatypeEnum;
import com.boot.security.server.model.Qmmprice;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.QmmpriceServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 查询趣满满的第三方场次价格
 * @author sheng
 *
 */
public class QmmPriceUtil {

	private static final String CHANNEL_ID = "30027";
    private static final String KEY = "3b82e0e1c787f8abf337c2c2c8ce7101";
    private static final String FILM_URL = "http://webapi2.qingbh.com/manman/index.php/open/partner/queryFilms";  //查询影片列表
    private static final String SCREEN_URL="http://webapi2.qingbh.com/manman/index.php/open/partner/getCinemaChannelPlays";	//查询第三方场次价格
    
    QmmpriceServiceImpl qmmpriceService = SpringUtil.getBean(QmmpriceServiceImpl.class);
    CinemaServiceImpl cinemaService = SpringUtil.getBean(CinemaServiceImpl.class);
    
	public String getQmmPrice(String cinemaCode) throws ParseException, IOException{
		Long cinemaId = changeCinemaId(cinemaCode);
		Cinema cinema = cinemaService.getByCinemaCode(cinemaCode);
		
		//查询影院内影片列表
		StringBuffer buf1 = new StringBuffer();
		buf1.append("channelId");
		buf1.append(CHANNEL_ID);
		buf1.append("cinemaId");
		buf1.append(cinemaId);
		buf1.append(KEY);//key值
		String sign1 = MD5Util.MD5Encode(buf1.toString(), "UTF-8");
		Map<String,Object> param1 = new LinkedHashMap<String,Object>();
		param1.put("channelId", CHANNEL_ID);
		param1.put("cinemaId", cinemaId);
		param1.put("sign", sign1);
		
		JSONObject returnFilm = HttpHelper.sendHttp(param1, FILM_URL);
//		System.out.println("接口返回："+returnFilm);
		if(returnFilm.get("code").equals(0)){
			JSONObject resultJson = JSONObject.fromObject(returnFilm.get("result"));
			JSONArray arr = (JSONArray) resultJson.get("filmList");  //拿到的是该影院下所有的排片，需要的是filmId
			JSONObject arrJson = null;
			Object filmId = null;
			
			for(int i = 0; i < arr.size(); i++){	//根据filmId获取场次信息
				arrJson = JSONObject.fromObject(arr.get(i));
				filmId = arrJson.get("filmId");
                StringBuffer buf2 = new StringBuffer();
    			buf2.append("channelId");
    			buf2.append(CHANNEL_ID);
    			buf2.append("cinemaId");
    			buf2.append(cinemaId);
    			buf2.append("filmId");
                buf2.append(filmId);
    			buf2.append(KEY);
    			String screensign = MD5Util.MD5Encode(buf2.toString(), "UTF-8");
    			
    			Map<String,Object> param2 = new HashMap<String,Object>();
    			param2.put("channelId", CHANNEL_ID);
    			param2.put("cinemaId", cinemaId);
    			param2.put("filmId", filmId);
    			param2.put("sign", screensign);
    			JSONObject screenJson = HttpHelper.sendHttp(param2, SCREEN_URL);
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
                    			qmmprice.setCinemaCode(cinemaCode);
                    			qmmprice.setCinemaName(cinema.getName());
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
    				return "Failure";
    			}
			}
		} else {
			return "Failure";
		}
		return "Success";
	}
	
	//本地的影院转换为趣满满的影院编码
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
