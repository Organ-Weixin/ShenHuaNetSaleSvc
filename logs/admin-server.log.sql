2019-04-10 09:11:51,686 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-10 09:11:51,854 [main] ==> Parameters: 1000000035(String), 66a16ca61f729e0c846983f8c0f4fd53(String)
2019-04-10 09:11:51,869 [main] <==      Total: 0
2019-04-10 09:29:41,191 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-10 09:29:41,328 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-10 09:29:41,346 [main] <==      Total: 1
2019-04-10 09:29:41,348 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? 
2019-04-10 09:29:41,351 [main] ==> Parameters: 12(Long)
2019-04-10 09:29:41,353 [main] <==      Total: 2
2019-04-10 09:33:43,969 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-10 09:33:44,109 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-10 09:33:44,126 [main] <==      Total: 1
2019-04-10 09:33:44,129 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? 
2019-04-10 09:33:44,131 [main] ==> Parameters: 12(Long)
2019-04-10 09:33:44,133 [main] <==      Total: 2
2019-04-10 09:36:13,702 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-10 09:36:13,881 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-10 09:36:13,899 [main] <==      Total: 1
2019-04-10 09:36:13,901 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? 
2019-04-10 09:36:13,903 [main] ==> Parameters: 12(Long)
2019-04-10 09:36:13,905 [main] <==      Total: 2
2019-04-10 11:32:07,267 [http-nio-8080-exec-7] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-04-10 11:32:07,274 [http-nio-8080-exec-7] ==> Parameters: admin(String)
2019-04-10 11:32:07,324 [http-nio-8080-exec-7] <==      Total: 1
2019-04-10 11:32:07,337 [http-nio-8080-exec-7] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2019-04-10 11:32:07,342 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-04-10 11:32:07,385 [http-nio-8080-exec-7] <==      Total: 45
2019-04-10 11:32:08,078 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-10 11:32:08,084 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-04-10 11:32:08,146 [taskExecutor-1] <==    Updates: 1
2019-04-10 11:32:08,760 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-10 11:32:08,763 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-04-10 11:32:08,875 [http-nio-8080-exec-4] <==      Total: 1
2019-04-10 11:32:16,818 [http-nio-8080-exec-1] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-04-10 11:32:16,819 [http-nio-8080-exec-1] ==> Parameters: OrderStatusEnum(String)
2019-04-10 11:32:16,934 [http-nio-8080-exec-1] <==      Total: 11
2019-04-10 11:32:16,944 [http-nio-8080-exec-2] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-04-10 11:32:16,945 [http-nio-8080-exec-2] ==> Parameters: payType(String)
2019-04-10 11:32:16,947 [http-nio-8080-exec-2] <==      Total: 5
2019-04-10 11:32:17,111 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-04-10 11:32:17,114 [http-nio-8080-exec-5] ==> Parameters: 8(String)
2019-04-10 11:32:17,138 [http-nio-8080-exec-5] <==      Total: 1
2019-04-10 11:32:17,140 [http-nio-8080-exec-5] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addedprice,0)+os.fee-coalesce(os.preferentialPrice,0) as totalSale,os.preferentialPrice,os.created,t.printno, t.mobilePhone,os.addedprice,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-04-10 11:32:17,144 [http-nio-8080-exec-5] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-04-10 11:38:17,667 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-10 11:38:17,867 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-04-10 11:38:17,884 [http-nio-8080-exec-2] <==      Total: 1
2019-04-10 11:38:20,432 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-04-10 11:38:20,435 [http-nio-8080-exec-3] ==> Parameters: 8(String)
2019-04-10 11:38:20,439 [http-nio-8080-exec-3] <==      Total: 1
2019-04-10 11:38:20,445 [http-nio-8080-exec-3] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addFee,0)+os.fee-coalesce(os.cinemaAllowance,0) as totalSale,os.cinemaAllowance,os.created,t.printno, t.mobilePhone,os.addFee,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-04-10 11:38:20,454 [http-nio-8080-exec-3] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-04-10 11:39:52,586 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-10 11:39:52,792 [http-nio-8080-exec-10] ==> Parameters: 1(Long)
2019-04-10 11:39:52,818 [http-nio-8080-exec-10] <==      Total: 1
2019-04-10 11:39:54,780 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-04-10 11:39:54,784 [http-nio-8080-exec-3] ==> Parameters: 8(String)
2019-04-10 11:39:54,788 [http-nio-8080-exec-3] <==      Total: 1
2019-04-10 11:39:54,792 [http-nio-8080-exec-3] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addFee,0)+os.fee-coalesce(os.cinemaAllowance,0) as totalSale,os.cinemaAllowance,os.created,t.printno, t.mobilePhone,os.addFee,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-04-10 11:39:54,802 [http-nio-8080-exec-3] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-04-10 11:39:54,816 [http-nio-8080-exec-3] <==      Total: 13
2019-04-10 11:40:06,917 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-10 11:40:06,920 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-10 11:40:07,037 [http-nio-8080-exec-2] <==      Total: 1
2019-04-10 11:40:07,039 [http-nio-8080-exec-2] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-10 11:40:07,042 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-04-10 11:40:07,045 [http-nio-8080-exec-2] <==      Total: 2
2019-04-10 11:40:09,293 [http-nio-8080-exec-5] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-04-10 11:40:09,294 [http-nio-8080-exec-5] ==> Parameters: middleWareType(String)
2019-04-10 11:40:09,297 [http-nio-8080-exec-5] <==      Total: 9
2019-04-10 11:40:09,376 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from middleware t 
2019-04-10 11:40:09,379 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-10 11:40:09,381 [http-nio-8080-exec-8] <==      Total: 1
2019-04-10 11:40:09,383 [http-nio-8080-exec-8] ==>  Preparing: select * from middleware t limit ?, ? 
2019-04-10 11:40:09,385 [http-nio-8080-exec-8] ==> Parameters: 0(Integer), 50(Integer)
2019-04-10 11:40:09,394 [http-nio-8080-exec-8] <==      Total: 50
2019-04-10 11:40:18,498 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from middleware t 
2019-04-10 11:40:18,499 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-10 11:40:18,501 [http-nio-8080-exec-2] <==      Total: 1
2019-04-10 11:40:18,503 [http-nio-8080-exec-2] ==>  Preparing: select * from middleware t limit ?, ? 
2019-04-10 11:40:18,504 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 50(Integer)
2019-04-10 11:40:18,508 [http-nio-8080-exec-2] <==      Total: 50
2019-04-10 11:40:49,421 [http-nio-8080-exec-2] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-10 11:40:49,421 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-10 11:40:49,422 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-10 11:40:49,422 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-10 11:40:49,424 [http-nio-8080-exec-3] <==      Total: 3
2019-04-10 11:40:49,520 [http-nio-8080-exec-2] <==      Total: 6
