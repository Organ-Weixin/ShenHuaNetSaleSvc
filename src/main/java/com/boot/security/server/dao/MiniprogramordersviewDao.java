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
import com.boot.security.server.model.Miniprogramordersview;

@Mapper
public interface MiniprogramordersviewDao {

    @Select("select * from miniprogramordersview t where t.id = #{id}")
    Miniprogramordersview getById(Long id);

    @Delete("delete from miniprogramordersview where id = #{id}")
    int delete(Long id);

    int update(Miniprogramordersview miniprogramordersview);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into miniprogramordersview(Id, CinemaCode, CinemaName, CinemaPhone, Address, SessionCode, ScreenCode, SessionTime, FilmCode, FilmName, TicketCount, TotalSalePrice, OrderStatus, MobilePhone, OrderCode, PrintNo, TicketInfoCode, Created, OpenID, ScreenName, SeatName) values(#{Id}, #{CinemaCode}, #{CinemaName}, #{CinemaPhone}, #{Address}, #{SessionCode}, #{ScreenCode}, #{SessionTime}, #{FilmCode}, #{FilmName}, #{TicketCount}, #{TotalSalePrice}, #{OrderStatus}, #{MobilePhone}, #{OrderCode}, #{PrintNo}, #{TicketInfoCode}, #{Created}, #{OpenID}, #{ScreenName}, #{SeatName})")
    int save(Miniprogramordersview miniprogramordersview);
    
    int count(@Param("params") Map<String, Object> params);

    List<Miniprogramordersview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from miniprogramordersview t where t.cinemacode = #{cinemacode} and t.openid=#{openid} and orderstatus=8")
    List<Miniprogramordersview> getByCinemaCodeAndOpenID(@Param("cinemacode")String cinemacode,@Param("openid")String openid);
}
