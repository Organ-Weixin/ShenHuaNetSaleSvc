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
    
    @Select("select * from goodsorders t where t.ordercode = #{ordercode}")
    Goodsorders getByOrderCode(@Param("ordercode") String ordercode);
    
    @Select("select * from goodsorders t where t.localordercode = #{localordercode}")
    Goodsorders getByLocalOrderCode(@Param("localordercode") String localordercode);
    
    @Select("select * from goodsorders t where t.cinemacode=#{cinemacode} and t.ordercode = #{ordercode}")
    Goodsorders getByCinemaCodeAndOrderCode(@Param("cinemacode") String cinemacode, @Param("ordercode") String ordercode);

    @Delete("delete from goodsorders where id = #{id}")
    int delete(Long id);

    int update(Goodsorders goodsorders);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goodsorders(Id, CinemaCode, UserId, LocalOrderCode, OrderCode, PickUpCode, VerifyCode, OrderStatus, TotalPrice, TotalSettlePrice, TotalFee, SubmitTime, Created, Updated, MobilePhone, GoodsCount,RefundTradeNo, RefundTime, PickUpTime, DeliveryType, DeliveryAddress, DeliveryTime, DeliveryMark,IsReady, OrderPayFlag, OrderPayType, OrderPayTime, OrderTradeNo, PayType, PaySeqNo, CardNo, CardPassword, ErrorMessage,OpenID,CouponsCode,CouponsPrice) values(#{Id}, #{CinemaCode}, #{UserId}, #{LocalOrderCode}, #{OrderCode}, #{PickUpCode}, #{VerifyCode}, #{OrderStatus}, #{TotalPrice}, #{TotalSettlePrice}, #{TotalFee}, #{SubmitTime}, #{Created}, #{Updated}, #{MobilePhone}, #{GoodsCount},#{RefundTradeNo},#{RefundTime}, #{PickUpTime}, #{DeliveryType}, #{DeliveryAddress}, #{DeliveryTime}, #{DeliveryMark},#{IsReady},#{OrderPayFlag}, #{OrderPayType}, #{OrderPayTime}, #{OrderTradeNo}, #{PayType}, #{PaySeqNo}, #{CardNo}, #{CardPassword}, #{ErrorMessage},#{OpenID},#{CouponsCode},#{CouponsPrice})")
    int save(Goodsorders goodsorders);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goodsorders> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from goodsorders t where t.cinemacode = #{cinemacode}")
    List<Goodsorders> getByCinemaCode(String cinemacode);
    
    @Select("select * from goodsorders t where t.cinemacode = #{cinemacode} and t.openid=#{openid} and(orderstatus = 3 or orderstatus = 7 or orderstatus = 8 or orderstatus = 10)")
    List<Goodsorders> getByCinemaCodeAndOpenID(@Param("cinemacode")String cinemacode,@Param("openid")String openid);
    
    @Select("select * from goodsorders t where t.openid = #{openid} and t.orderstatus in (7,10) and t.submittime #{time} order by t.submittime desc limit 0,1")
    List<Goodsorders> getByOpenID(@Param("openid")String openid,@Param("time")String time);
    
    @Select("select * from goodsorders t where t.cinemacode =#{cinemacode} and t.ordertradeno = #{ordertradeno}")
    Goodsorders getByOrderTradeNo(@Param("cinemacode")String cinemacode,@Param("ordertradeno")String ordertradeno);
    
    @Select("select * from goodsorders t where t.cinemacode = #{cinemacode} and t.openid = #{openid} and t.orderstatus = #{orderstatus}")
    List<Goodsorders> getUserGoodsOrders(@Param("cinemacode")String cinemacode,@Param("openid")String openid,@Param("orderstatus")Integer orderstatus);
}
