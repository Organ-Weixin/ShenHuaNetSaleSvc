package com.boot.security.server.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.boot.security.server.model.Screeninfo;

public interface ScreeninfoService {

	//查询影厅
    Screeninfo getById(Long id);
    
    Screeninfo getByScreenCode(String cinemacode,String screencode);
    
    Screeninfo getByScreenId(String cinemacode,String screenid);
    
    List<Screeninfo> getByCinemaCode(String cinemacode);

    int delete(Long id);
    
    int deleteByCinemaCode(String cinemacode);

    int update(Screeninfo screeninfo);
    
 
    int save(Screeninfo screeninfo);
    
    int count(@Param("params") Map<String, Object> params);

    List<Screeninfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

}
