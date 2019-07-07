package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Membercardrecharge;

@Mapper
public interface MembercardrechargeDao {

    @Select("select * from membercardrecharge t where t.id = #{id}")
    Membercardrecharge getById(Long id);
    
    @Select("select * from membercardrecharge t where t.TradeNo = #{tradeNo}")
    Membercardrecharge getByTradeNo(String tradeNo);
    
    @Select("select * from membercardrecharge t where t.CinemaCode = #{cinemaCode} and t.OpenId = #{openId}")
    Membercardrecharge getByOpenId(@Param("cinemaCode") String cinemaCode, @Param("openId") String openId);
    
    @Select("select * from membercardrecharge t where t.CinemaCode = #{cinemaCode} and t.CardNo = #{cardNo} order by Updated desc")
    List<Membercardrecharge> getByCinemaAndCard(@Param("cinemaCode") String cinemaCode, @Param("cardNo") String cardNo);

    @Delete("delete from membercardrecharge where id = #{id}")
    int delete(Long id);

    int update(Membercardrecharge membercardrecharge);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into membercardrecharge(CinemaCode, CardNo, CardPassword, UserName, MobilePhone, RechargeAmount, Balance, PayStatus, ChargeStatus, ErrorMsg, TradeNo, WXtradeNo, Updated, MidUserName, MidPassword, RuleCode, LevelCode,OpenId) values(#{CinemaCode}, #{CardNo}, #{CardPassword}, #{UserName}, #{MobilePhone}, #{RechargeAmount}, #{Balance}, #{PayStatus}, #{ChargeStatus},#{ErrorMsg}, #{TradeNo}, #{WXtradeNo}, #{Updated}, #{MidUserName}, #{MidPassword}, #{RuleCode}, #{LevelCode},#{OpenId})")
    int save(Membercardrecharge membercardrecharge);
    
    int count(@Param("params") Map<String, Object> params);

    List<Membercardrecharge> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
