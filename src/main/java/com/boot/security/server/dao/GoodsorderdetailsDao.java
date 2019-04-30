package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Goodsorderdetails;

@Mapper
public interface GoodsorderdetailsDao {

    @Select("select * from goodsorderdetails t where t.id = #{id}")
    Goodsorderdetails getById(Long id);
    
    @Select("select * from goodsorderdetails t where t.orderid = #{orderid}")
    List<Goodsorderdetails> getByOrderId(Long orderid);

    @Delete("delete from goodsorderdetails where id = #{id}")
    int delete(Long id);

    int update(Goodsorderdetails goodsorderdetails);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goodsorderdetails(Id, OrderId, GoodsCode, GoodsName, StandardPrice, SettlePrice, ChannelFee, GoodsCount, SubTotalAmount,SubTotalSettleAmount, Created, Updated, IsPackage, GoodsDetail) values(#{Id}, #{OrderId}, #{GoodsCode}, #{GoodsName}, #{StandardPrice}, #{SettlePrice}, #{ChannelFee}, #{GoodsCount}, #{SubTotalAmount}, #{SubTotalSettleAmount},#{Created}, #{Updated}, #{IsPackage}, #{GoodsDetail})")
    int save(Goodsorderdetails goodsorderdetails);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goodsorderdetails> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
