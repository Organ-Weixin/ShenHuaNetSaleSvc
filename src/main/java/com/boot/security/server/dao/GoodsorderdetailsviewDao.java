package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boot.security.server.modelView.Goodsorderdetailsview;


@Mapper
public interface GoodsorderdetailsviewDao {
    
    int count(@Param("params") Map<String, Object> params);

    List<Goodsorderdetailsview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
