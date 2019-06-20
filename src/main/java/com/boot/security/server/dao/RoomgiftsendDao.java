package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Roomgiftsend;

@Mapper
public interface RoomgiftsendDao {

    @Select("select * from roomgiftsend t where t.id = #{id}")
    Roomgiftsend getById(Long id);

    @Delete("delete from roomgiftsend where id = #{id}")
    int delete(Long id);

    int update(Roomgiftsend roomgiftsend);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into roomgiftsend(cinemaCode, roomCode, giftCode, giftName, giftType, sendNumber, openid, sendTime,timestamp) values(#{cinemaCode}, #{roomCode}, #{giftCode}, #{giftName}, #{giftType}, #{sendNumber}, #{openid}, #{sendTime},#{timestamp})")
    int save(Roomgiftsend roomgiftsend);
    
    int count(@Param("params") Map<String, Object> params);

    List<Roomgiftsend> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from roomgiftsend t where t.gifttype=#{gifttype} and t.roomCode = #{roomcode} and giftCode = #{giftcode}")
    List<Roomgiftsend> getByRoomCode(@Param("gifttype") String gifttype,@Param("roomcode") String roomcode,@Param("giftcode") String giftcode);
    
    @Select("select * from roomgiftsend t where t.gifttype=#{gifttype} and t.roomCode = #{roomcode} and timestamp = #{timestamp}")
    Roomgiftsend getByGiftAndRoomAndTimestamp(@Param("gifttype")String gifttype,@Param("giftcode")String giftcode,@Param("roomcode")String roomcode,@Param("timestamp")String timestamp);
}
