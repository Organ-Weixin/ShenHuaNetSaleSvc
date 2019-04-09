package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Userinfo;

@Mapper
public interface OrdersDao {

    @Select("select * from orders t where t.id = #{id}")
    Orders getById(Long id);
    
    @Select("select * from orders t where t.cinemacode=#{cinemacode} and t.lockordercode = #{lockordercode}")
    Orders getByLockOrderCode(@Param("cinemacode")String cinemacode,@Param("lockordercode")String lockordercode);
    
    @Select("select * from orders t where t.cinemacode=#{cinemacode} and t.printno = #{printno} and t.verifycode=#{verifycode}")
    Orders getByPrintNo(@Param("cinemacode")String cinemacode,@Param("printno")String printno,@Param("verifycode")String verifycode);
    
    @Select("select * from orders t where t.cinemacode=#{cinemacode} and t.submitordercode = #{ordercode}")
    Orders getByOrderCode(@Param("cinemacode")String cinemacode,@Param("ordercode")String ordercode);
    
    @Delete("delete from orders where id = #{id}")
    int delete(Long id);

    int update(Orders orders);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into orders(Id, CinemaCode, UserId, SessionCode, ScreenCode, SessionTime, FilmCode, FilmName, TicketCount, TotalPrice, TotalFee, TotalSalePrice, OrderStatus, MobilePhone, LockTime, AutoUnlockDatetime, LockOrderCode, SubmitTime, SubmitOrderCode, PrintNo, VerifyCode, PrintStatus, PrintTime, RefundTime, Created, Updated, Deleted, ErrorMessage, SerialNum, IsMemberPay, PayType, Printpassword, PaySeqNo, IDCardNumber) values(#{Id}, #{CinemaCode}, #{UserId}, #{SessionCode}, #{ScreenCode}, #{SessionTime}, #{FilmCode}, #{FilmName}, #{TicketCount}, #{TotalPrice}, #{TotalFee}, #{TotalSalePrice}, #{OrderStatus}, #{MobilePhone}, #{LockTime}, #{AutoUnlockDatetime}, #{LockOrderCode}, #{SubmitTime}, #{SubmitOrderCode}, #{PrintNo}, #{VerifyCode}, #{PrintStatus}, #{PrintTime}, #{RefundTime}, #{Created}, #{Updated}, #{Deleted}, #{ErrorMessage}, #{SerialNum}, #{IsMemberPay}, #{PayType}, #{Printpassword}, #{PaySeqNo}, #{IDCardNumber})")
    int save(Orders orders);
    
    int count(@Param("params") Map<String, Object> params);

    List<Orders> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    //查询渠道
    @Select("select * from userinfo where isDel =0")
    List<Userinfo> queryCompany();
    
    List<Orders> queryOrders();
}
