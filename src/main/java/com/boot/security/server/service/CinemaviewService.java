package com.boot.security.server.service;

import java.util.List;
import java.util.Map;



import com.boot.security.server.model.Cinemaview;

public interface CinemaviewService {
    Cinemaview getById(Long id);

    int delete(Long id);

    int update(Cinemaview cinemaview);
    
    int save(Cinemaview cinemaview);
    
    int count( Map<String, Object> params);

    List<Cinemaview> list(Map<String, Object> params,Integer offset,Integer limit);

}
