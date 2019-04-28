package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Goodsorders;

@Mapper
public interface GoodsordersDao {

    @Select("select * from goodsorders t where t.id = #{id}")
    Goodsorders getById(Long id);

    @Delete("delete from goodsorders where id = #{id}")
    int delete(Long id);

    int update(Goodsorders goodsorders);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goodsorders(Id, CinemaCode, UserId, LocalOrderCode, OrderCode, PickUpCode, VerifyCode, OrderStatus, TotalPrice, TotalFee, SubmitTime, Created, Updated, MobilePhone, GoodsCount, RefundTime, PickUpTime, DeliveryAddress, SendTime, OrderPayFlag, OrderPayType, OrderPayTime, OrderTradeNo) values(#{Id}, #{CinemaCode}, #{UserId}, #{LocalOrderCode}, #{OrderCode}, #{PickUpCode}, #{VerifyCode}, #{OrderStatus}, #{TotalPrice}, #{TotalFee}, #{SubmitTime}, #{Created}, #{Updated}, #{MobilePhone}, #{GoodsCount}, #{RefundTime}, #{PickUpTime}, #{DeliveryAddress}, #{SendTime}, #{OrderPayFlag}, #{OrderPayType}, #{OrderPayTime}, #{OrderTradeNo})")
    int save(Goodsorders goodsorders);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goodsorders> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
