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
import com.boot.security.server.model.Goodsorders;

@Mapper
public interface GoodsordersDao {
    @Select("select * from goodsorders t where t.id = #{id}")
    Goodsorders getById(Long id);
    
    @Select("select * from goodsorders t where t.localordercode = #{localordercode}")
    Goodsorders getByLocalOrderCode(@Param("localordercode") String localordercode);
    
    @Select("select * from goodsorders t where t.cinemacode=#{cinemacode} and t.ordercode = #{ordercode}")
    Goodsorders getByOrderCode(@Param("cinemacode") String cinemacode, @Param("ordercode") String ordercode);

    @Delete("delete from goodsorders where id = #{id}")
    int delete(Long id);

    int update(Goodsorders goodsorders);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goodsorders(Id, CinemaCode, UserId, LocalOrderCode, OrderCode, PickUpCode, VerifyCode, OrderStatus, TotalPrice, TotalSettlePrice, TotalFee, SubmitTime, Created, Updated, MobilePhone, GoodsCount, RefundTime, PickUpTime, DeliveryType, DeliveryAddress, DeliveryTime, DeliveryMark, OrderPayFlag, OrderPayType, OrderPayTime, OrderTradeNo, PayType, PaySeqNo, CardNo, CardPassword, ErrorMessage,OpenID) values(#{Id}, #{CinemaCode}, #{UserId}, #{LocalOrderCode}, #{OrderCode}, #{PickUpCode}, #{VerifyCode}, #{OrderStatus}, #{TotalPrice}, #{TotalSettlePrice}, #{TotalFee}, #{SubmitTime}, #{Created}, #{Updated}, #{MobilePhone}, #{GoodsCount}, #{RefundTime}, #{PickUpTime}, #{DeliveryType}, #{DeliveryAddress}, #{DeliveryTime}, #{DeliveryMark}, #{OrderPayFlag}, #{OrderPayType}, #{OrderPayTime}, #{OrderTradeNo}, #{PayType}, #{PaySeqNo}, #{CardNo}, #{CardPassword}, #{ErrorMessage},#{OpenID})")
    int save(Goodsorders goodsorders);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goodsorders> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from goodsorders t where t.cinemacode = #{cinemacode}")
    List<Goodsorders> getByCinemaCode(String cinemacode);
    
    @Select("select * from goodsorders t where t.cinemacode = #{cinemacode} and t.openid=#{openid}")
    List<Goodsorders> getByCinemaCodeAndOpenID(@Param("cinemacode")String cinemacode,@Param("openid")String openid);
}
