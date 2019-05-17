package com.boot.security.server.service;

import java.util.List;
import java.util.Map;



import com.boot.security.server.model.Screeninfoview;

public interface ScreeninfoviewService {
    Screeninfoview getById(Long id);

    int delete(Long id);

    int update(Screeninfoview screeninfoview);
    
    int save(Screeninfoview screeninfoview);
    
    int count(Map<String, Object> params);

    List<Screeninfoview> list(Map<String, Object> params,Integer offset,Integer limit);

}
