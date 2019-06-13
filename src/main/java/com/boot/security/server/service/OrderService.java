package com.boot.security.server.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Userinfo;
public interface OrderService {
    Orders getById(Long id);
    
    Orders getOrderBaseByLockOrderCode(String lockordercode);

    Orders getByPrintNo(String cinemacode,String printno,String verifycode);
    
    Orders getByOrderCode(String cinemacode,String ordercode);
    
    Orders getByOrderTradeNo(String cinemacode,String ordertradeno);
    
    int update(Orders orders);
    
    int delete(Long id);

    //int update(Orders orders);
    
    /*@Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into orders(Id, CinemaCode, UserId, SessionCode, ScreenCode, SessionTime, FilmCode, FilmName, TicketCount, TotalPrice, TotalFee, TotalSalePrice, OrderStatus, MobilePhone, LockTime, AutoUnlockDatetime, LockOrderCode, SubmitTime, SubmitOrderCode, PrintNo, VerifyCode, PrintStatus, PrintTime, RefundTime, Created, Updated, Deleted, ErrorMessage, SerialNum, IsMemberPay, PayType, Printpassword, PaySeqNo, IDCardNumber) values(#{Id}, #{CinemaCode}, #{UserId}, #{SessionCode}, #{ScreenCode}, #{SessionTime}, #{FilmCode}, #{FilmName}, #{TicketCount}, #{TotalPrice}, #{TotalFee}, #{TotalSalePrice}, #{OrderStatus}, #{MobilePhone}, #{LockTime}, #{AutoUnlockDatetime}, #{LockOrderCode}, #{SubmitTime}, #{SubmitOrderCode}, #{PrintNo}, #{VerifyCode}, #{PrintStatus}, #{PrintTime}, #{RefundTime}, #{Created}, #{Updated}, #{Deleted}, #{ErrorMessage}, #{SerialNum}, #{IsMemberPay}, #{PayType}, #{Printpassword}, #{PaySeqNo}, #{IDCardNumber})")
    int save(Orders orders);*/
    
    int count(@Param("params") Map<String, Object> params);

    List<Orders> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    List<Userinfo> queryCompany();
    
    List<Orders> queryOrders();
    
    List<Orders> getOrdersByCreated(Long userid,String cinemaCode,Date startDate,Date endDate);
    
    List<Orders> getNonPayOrders(Long userid,String cinemaCode,String openID);
    
    @Transactional(propagation = Propagation.REQUIRED)
	int Insert(OrderView orderview);
	@Transactional(propagation = Propagation.REQUIRED)
	OrderView getOrderWidthLockOrderCode(String cinemacode,String lockordercode);
	@Transactional(propagation = Propagation.REQUIRED)
	OrderView getOrderWidthOrderCode(String cinemacode,String ordercode);
	int UpdateOrderBaseInfo(Orders orderbase);
	@Transactional(propagation = Propagation.REQUIRED)
	int Update(OrderView orderview);
	@Transactional(propagation = Propagation.REQUIRED)
	OrderView getOrderWidthPrintNo(String cinemacode,String printno,String verifycode);
	@Transactional(propagation = Propagation.REQUIRED)
	OrderView getOrderWidthId(Long id);
	@Transactional(propagation = Propagation.REQUIRED)
	OrderView getOrderWidthTradeNo(String cinemacode,String ordertradeno);
	
	List<Orders> getByOpenId(String openid,String time);
	
	Orders getByLockOrderCode(String cinemacode, String lockordercode);
	
	List<Orders> checkUserOrders(String openid,Integer orderstatus,String filmcode,String sessiontime);
	
	List<Orders> getCinemaOrders(String cinemacode);
	
	List<Orders> getUserOrders(String cinemacode,String openid,Integer orderstatus,Integer printstatus);
	
	List<Orders> getByOpenIdAndStatus(String openid,Integer orderstatus,String sessiontime);
}	
