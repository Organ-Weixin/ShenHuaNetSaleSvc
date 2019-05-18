package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Roomgift;

@Mapper
public interface RoomgiftDao {

    @Select("select * from roomgift t where t.id = #{id}")
    Roomgift getById(Long id);

    @Delete("delete from roomgift where id = #{id}")
    int delete(Long id);

    int update(Roomgift roomgift);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into roomgift(cinemaCode, giftCode, giftName, Image, giftDesc, groupNumber, sendNumber, giftType) values(#{cinemaCode}, #{giftCode}, #{giftName}, #{Image}, #{giftDesc}, #{groupNumber}, #{sendNumber}, #{giftType})")
    int save(Roomgift roomgift);
    
    int count(@Param("params") Map<String, Object> params);

    List<Roomgift> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    //查询可发送实物列表
    @Select("select * from roomgift where CinemaCode = #{cinemacode} ")
    List<Roomgift> getByCinema(String cinemacode);
    
    @Select("select * from roomgift where giftCode = #{giftcode} ")
    Roomgift getByGiftCode(String giftcode);
}
