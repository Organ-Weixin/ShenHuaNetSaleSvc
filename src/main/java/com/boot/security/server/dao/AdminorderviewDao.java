package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Adminorderview;

@Mapper
public interface AdminorderviewDao {

    @Select("select * from adminorderview t where t.id = #{id}")
    Adminorderview getById(Long id);

    @Delete("delete from adminorderview where id = #{id}")
    int delete(Long id);

    int update(Adminorderview adminorderview);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into adminorderview(cinemacode, cinemaname, filmname, submitordercode, sessiontime, screencode, seat, price, saleprice, addfee, fee, cinemaallowance, paytype, created, filmticketcode,ticketinfocode,printno, mobilePhone, orderStatus) values(#{cinemacode}, #{cinemaname}, #{filmname}, #{submitordercode}, #{sessiontime}, #{screencode}, #{seat}, #{price}, #{saleprice}, #{addfee}, #{fee}, #{cinemaallowance}, #{paytype}, #{created}, #{filmticketcode}, #{printno}, #{mobilePhone}, #{orderStatus})")
    int save(Adminorderview adminorderview);
    
    int count(@Param("params") Map<String, Object> params);

    List<Adminorderview> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from adminorderview t where t.cinemacode = #{cinemacode}")
    List<Adminorderview> getByCinemaCode(String cinemacode);
    
    @Select("select * from adminorderview t where t.cinemacode = #{cinemacode} and submitordercode = #{ordercode}")
    Adminorderview getByOrderCode(@Param("cinemacode")String cinemacode,@Param("ordercode")String ordercode);
}
