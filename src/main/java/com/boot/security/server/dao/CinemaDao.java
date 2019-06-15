package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.security.server.model.Cinema;

@Mapper
public interface CinemaDao {
	//提交测试
	//根据id查询订单数据
    @Select("select * from cinema t where t.Id= #{id}")
    Cinema getById(Long id);
    
    @Select("select * from cinema t where t.Code= #{cinemacode}")
    Cinema getByCinemaCode(String  cinemacode);

    @Delete("delete from cinema where id = #{id}")
    int delete(Long id);
    
    @Update("update  cinema set Name=#{Name},Address=#{Address},ScreenCount=#{ScreenCount},CinemaId=#{CinemaId} where Code=#{Code}")
    int updateByCode(Cinema cinema);
    
    @Insert("insert into cinema(MId, Code, Name, Province, City, Address, ScreenCount, ManualAdd, IsOpen, ContactName, ContactMobile, TheaterChain, Latitude, Longitude, IsOpenSnacks, CinemaPhone, TicketHint, CinemaLabel, IsSnackDistribution, Created, Updated, CinemaId,IsUseLowestPriceReport,OverRefundTime,RefundFee) values(#{MId}, #{Code}, #{Name}, #{Province}, #{City}, #{Address}, #{ScreenCount}, #{ManualAdd}, #{IsOpen}, #{ContactName}, #{ContactMobile}, #{TheaterChain}, #{Latitude}, #{Longitude}, #{IsOpenSnacks}, #{CinemaPhone}, #{TicketHint}, #{CinemaLabel}, #{IsSnackDistribution}, #{Created}, #{Updated}, #{CinemaId},#{IsUseLowestPriceReport},#{OverRefundTime},#{RefundFee})")
    int save(Cinema cinema);
  
    int update(Cinema cinema);
   
    int count(@Param("params") Map<String, Object> params);

    List<Cinema> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    //获取当前登陆用户的影院
    List<Cinema> getCinemasByUser(@Param("roleId") Long roleId, @Param("id") Long id);
    
    //查询卖品管理的影院信息
    int goodscount(@Param("params") Map<String, Object> params);
    List<Cinema> goodslist(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select * from cinema")
    List<Cinema> AllCinema();
    
    @Update("update cinema set isgeneralstore = #{isgeneralstore} where find_in_set(code,#{cinemacodes})")
    int changeGeneralStore(@Param("isgeneralstore")Integer isgeneralstore,@Param("cinemacodes")String cinemacodes);
}
