package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Screenseatinfo;

@Mapper
public interface ScreenseatinfoDao {

    @Select("select * from screenseatinfo t where t.id = #{id}")
    Screenseatinfo getById(Long id);
    
    @Select("select * from screenseatinfo t where t.cinemacode = #{cinemacode} and t.screencode=#{screencode}")
    List<Screenseatinfo> getByCinemaCodeAndScreenCode(String cinemacode,String screencode);
    
    @Select("select * from screenseatinfo t where t.cinemacode = #{cinemacode} and t.screencode=#{screencode} and t.seatcode in(#{seatcodes})")
    List<Screenseatinfo> getBySeatCodes(String cinemacode,String screencode,String seatcodes);

    @Delete("delete from screenseatinfo where id = #{id}")
    int delete(Long id);
    
    @Delete("delete from screenseatinfo where cinemacode = #{cinemacode} and screencode=#{screencode}")
    int delete(String cinemacode,String screencode);

    int update(Screenseatinfo screenseatinfo);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into screenseatinfo(Id, CinemaCode, ScreenCode, SeatCode, GroupCode, RowNum, ColumnNum, XCoord, YCoord, Status, LoveFlag, Type, UpdateTime, SeatId) values(#{Id}, #{CinemaCode}, #{ScreenCode}, #{SeatCode}, #{GroupCode}, #{RowNum}, #{ColumnNum}, #{XCoord}, #{YCoord}, #{Status}, #{LoveFlag}, #{Type}, #{UpdateTime}, #{SeatId})")
    int save(Screenseatinfo screenseatinfo);
    
    int count(@Param("params") Map<String, Object> params);

    List<Screenseatinfo> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
