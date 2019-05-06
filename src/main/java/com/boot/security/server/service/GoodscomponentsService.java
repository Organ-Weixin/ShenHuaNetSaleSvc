package com.boot.security.server.service;

import java.util.List;
import java.util.Map;



import com.boot.security.server.model.Goodscomponents;

public interface GoodscomponentsService {
	    Goodscomponents getById(Long id);
	    Goodscomponents getByGoodsCode(String goodscode);

	    int delete(Long id);
	    int deleteByGoodsCode(String goodscode);
	    
	    int update(Goodscomponents goodscomponents);
	    
	    int save(Goodscomponents goodscomponents);
	    
	    int count( Map<String, Object> params);

	    List<Goodscomponents> list(Map<String, Object> params, Integer offset,Integer limit);

}