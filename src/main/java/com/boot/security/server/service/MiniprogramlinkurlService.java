package com.boot.security.server.service;

import java.util.List;
import java.util.Map;



import com.boot.security.server.model.Miniprogramlinkurl;

public interface MiniprogramlinkurlService {

    Miniprogramlinkurl getById(Long id);

    int delete(Long id);

    int update(Miniprogramlinkurl miniprogramlinkurl);
    
    int save(Miniprogramlinkurl miniprogramlinkurl);
    
    int count(Map<String, Object> params);

    List<Miniprogramlinkurl> list(Map<String, Object> params,Integer offset,Integer limit);

}
