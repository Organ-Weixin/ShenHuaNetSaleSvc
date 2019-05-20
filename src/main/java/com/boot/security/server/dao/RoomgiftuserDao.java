package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Roomgiftuser;

@Mapper
public interface RoomgiftuserDao {

    @Select("select * from roomgiftuser t where t.id = #{id}")
    Roomgiftuser getById(Long id);

    @Delete("delete from roomgiftuser where id = #{id}")
    int delete(Long id);

    int update(Roomgiftuser roomgiftuser);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into roomgiftuser(OpenID, RoomCode, GiftCode, GiftName, Image, GetDate, StartDate, ExpireDate, giftType) values(#{OpenID}, #{RoomCode}, #{GiftCode}, #{GiftName}, #{Image}, #{GetDate}, #{StartDate}, #{ExpireDate}, #{giftType})")
    int save(Roomgiftuser roomgiftuser);
    
    int count(@Param("params") Map<String, Object> params);

    List<Roomgiftuser> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    //根据用户与放映厅房间号查询
    @Select("select * from roomgiftuser where OPenID = #{openid} and RoomCode = #{roomcode}")
    List<Roomgiftuser> getByOpenidAndRoom(@Param("openid") String openid,@Param("roomcode") String roomcode);
    
    //根据用户查询
    @Select("select * from roomgiftuser where OPenID = #{openid} ")
    List<Roomgiftuser> getByOpenid(String openid);
}
