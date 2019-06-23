package com.boot.security.server.service;

import java.util.List;

import com.boot.security.server.model.Goodstype;

public interface GoodsTypeService {
	List<Goodstype> getByCinemaCode(String cimemacode);
	Goodstype getByTypeCode(String cinemacode,String typecode);
	
	int save(Goodstype goodstype);
}
