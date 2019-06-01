package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Goods;

@Mapper
public interface GoodsDao {

    @Select("select * from goods t where t.id = #{id}")
    Goods getById(Long id);
    
    @Select("select * from goods t where t.goodscode = #{goodscode}")
    Goods getByGoodsCode(String goodscode);
    
    @Select("select * from goods t where t.cinemacode = #{cinemacode}")
    List<Goods> getByCinemaCode(@Param("userid") Long userid,@Param("cinemacode") String cinemacode);
    
    @Select("select * from goods t where t.cinemacode = #{cinemacode} and goodscode = #{goodscode}")
    Goods getByCinemaCodeAndGoodsCode(@Param("cinemacode") String cinemacode,@Param("goodscode") String goodscode);
    
    @Delete("delete from goods where id = #{id}")
    int delete(Long id);
    
    @Delete("delete from goods where userid = #{userid} and cinemacode=#{cinemacode}")
    int deleteByCinemaCode(@Param("userid") Long userid,@Param("cinemacode") String cinemacode);
    
    @Delete("delete from goods where cinemacode = #{cinemacode} and goodscode = #{goodscode}")
    int deleteByCinemaCodeAndGoodsCode(@Param("cinemacode")String cinemacode,@Param("goodscode")String goodscode);

    int update(Goods goods);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into goods(Id, CinemaCode, UserId, GoodsCode, GoodsName, GoodsType, StandardPrice, SettlePrice, GoodsPic, StockCount, GoodsDesc, UnitName, ShowSeqNo, IsDiscount, GoodsKey, GoodsStatus, IsRecommand, IsPackage, Updated) values(#{Id}, #{CinemaCode}, #{UserId}, #{GoodsCode}, #{GoodsName}, #{GoodsType}, #{StandardPrice}, #{SettlePrice}, #{GoodsPic}, #{StockCount}, #{GoodsDesc}, #{UnitName}, #{ShowSeqNo}, #{IsDiscount}, #{GoodsKey}, #{GoodsStatus}, #{IsRecommand}, #{IsPackage}, #{Updated})")
    int save(Goods goods);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goods> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from goods where find_in_set(CinemaCode,#{cinemacodes}) and stockcount >0")
    List<Goods> getGoodsByCinemaCode(String cinemacodes);
}
