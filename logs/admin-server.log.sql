2019-05-04 09:08:33,778 [http-nio-8080-exec-3] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-05-04 09:08:33,789 [http-nio-8080-exec-3] ==> Parameters: admin(String)
2019-05-04 09:08:33,869 [http-nio-8080-exec-3] <==      Total: 1
2019-05-04 09:08:33,950 [http-nio-8080-exec-3] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-05-04 09:08:33,956 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-05-04 09:08:34,039 [http-nio-8080-exec-3] <==      Total: 43
2019-05-04 09:08:34,202 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-05-04 09:08:34,210 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-05-04 09:08:34,292 [taskExecutor-1] <==    Updates: 1
2019-05-04 09:08:34,827 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 09:08:34,830 [http-nio-8080-exec-1] ==> Parameters: 1(Long)
2019-05-04 09:08:34,848 [http-nio-8080-exec-1] <==      Total: 1
2019-05-04 10:12:42,372 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 10:12:42,376 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-05-04 10:12:42,386 [http-nio-8080-exec-2] <==      Total: 1
2019-05-04 10:12:51,675 [http-nio-8080-exec-10] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-05-04 10:12:51,678 [http-nio-8080-exec-10] ==> Parameters: OrderStatusEnum(String)
2019-05-04 10:12:51,751 [http-nio-8080-exec-10] <==      Total: 11
2019-05-04 10:12:51,772 [http-nio-8080-exec-8] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-05-04 10:12:51,772 [http-nio-8080-exec-8] ==> Parameters: payType(String)
2019-05-04 10:12:51,783 [http-nio-8080-exec-8] <==      Total: 5
2019-05-04 10:12:52,022 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-05-04 10:12:52,024 [http-nio-8080-exec-5] ==> Parameters: 8(String)
2019-05-04 10:12:52,142 [http-nio-8080-exec-5] <==      Total: 1
2019-05-04 10:12:52,153 [http-nio-8080-exec-5] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addfee,0)+os.fee-coalesce(os.CinemaAllowance,0) as totalSale,os.CinemaAllowance,os.created,t.printno, t.mobilePhone,os.addfee,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-05-04 10:12:52,159 [http-nio-8080-exec-5] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-05-04 10:12:52,220 [http-nio-8080-exec-5] <==      Total: 20
2019-05-04 10:12:57,522 [http-nio-8080-exec-10] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-05-04 10:12:57,524 [http-nio-8080-exec-10] ==> Parameters: 
2019-05-04 10:12:57,530 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-05-04 10:12:57,534 [http-nio-8080-exec-9] ==> Parameters: 
2019-05-04 10:12:57,560 [http-nio-8080-exec-10] <==      Total: 7
2019-05-04 10:12:57,588 [http-nio-8080-exec-9] <==      Total: 1
2019-05-04 10:12:57,596 [http-nio-8080-exec-9] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-05-04 10:12:57,599 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-05-04 10:12:57,624 [http-nio-8080-exec-9] <==      Total: 2
2019-05-04 10:13:17,167 [http-nio-8080-exec-8] ==>  Preparing: select * from userinfo where IsDel='0' 
2019-05-04 10:13:17,168 [http-nio-8080-exec-8] ==> Parameters: 
2019-05-04 10:13:17,217 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from sessioninfoview t 
2019-05-04 10:13:17,219 [http-nio-8080-exec-10] ==> Parameters: 
2019-05-04 10:13:17,229 [http-nio-8080-exec-8] <==      Total: 7
2019-05-04 10:13:20,345 [http-nio-8080-exec-10] <==      Total: 1
2019-05-04 10:13:20,356 [http-nio-8080-exec-10] ==>  Preparing: SELECT * FROM sessioninfoview t order by cinemaName asc limit ?, ? 
2019-05-04 10:13:20,359 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-05-04 10:13:26,584 [http-nio-8080-exec-10] <==      Total: 10
2019-05-04 10:13:30,736 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-05-04 10:13:30,739 [http-nio-8080-exec-5] ==> Parameters: 
2019-05-04 10:13:30,755 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-05-04 10:13:30,757 [http-nio-8080-exec-7] ==> Parameters: 
2019-05-04 10:13:30,762 [http-nio-8080-exec-5] <==      Total: 1
2019-05-04 10:13:30,771 [http-nio-8080-exec-5] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-05-04 10:13:30,773 [http-nio-8080-exec-5] ==> Parameters: 0(Integer), 10(Integer)
2019-05-04 10:13:30,783 [http-nio-8080-exec-7] <==      Total: 7
2019-05-04 10:13:30,809 [http-nio-8080-exec-5] <==      Total: 2
2019-05-04 10:13:32,001 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-05-04 10:13:32,002 [http-nio-8080-exec-3] ==> Parameters: 8(String)
2019-05-04 10:13:32,066 [http-nio-8080-exec-3] <==      Total: 1
2019-05-04 10:13:32,076 [http-nio-8080-exec-3] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addfee,0)+os.fee-coalesce(os.CinemaAllowance,0) as totalSale,os.CinemaAllowance,os.created,t.printno, t.mobilePhone,os.addfee,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-05-04 10:13:32,077 [http-nio-8080-exec-3] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-05-04 10:13:32,118 [http-nio-8080-exec-3] <==      Total: 20
2019-05-04 10:19:15,196 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 10:19:15,197 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-05-04 10:19:15,228 [http-nio-8080-exec-2] <==      Total: 1
2019-05-04 10:20:04,919 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo where IsDel='0' 
2019-05-04 10:20:04,920 [http-nio-8080-exec-5] ==> Parameters: 
2019-05-04 10:20:04,931 [http-nio-8080-exec-5] <==      Total: 7
2019-05-04 10:20:04,960 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from sessioninfoview t 
2019-05-04 10:20:04,961 [http-nio-8080-exec-4] ==> Parameters: 
2019-05-04 10:20:08,144 [http-nio-8080-exec-4] <==      Total: 1
2019-05-04 10:20:08,155 [http-nio-8080-exec-4] ==>  Preparing: SELECT * FROM sessioninfoview t order by cinemaName asc limit ?, ? 
2019-05-04 10:20:08,156 [http-nio-8080-exec-4] ==> Parameters: 0(Integer), 10(Integer)
2019-05-04 10:20:12,964 [http-nio-8080-exec-4] <==      Total: 10
2019-05-04 10:20:13,325 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-05-04 10:20:13,326 [http-nio-8080-exec-7] ==> Parameters: 
2019-05-04 10:20:13,344 [http-nio-8080-exec-7] <==      Total: 1
2019-05-04 10:20:13,344 [http-nio-8080-exec-4] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-05-04 10:20:13,345 [http-nio-8080-exec-4] ==> Parameters: 
2019-05-04 10:20:13,352 [http-nio-8080-exec-7] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-05-04 10:20:13,353 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-05-04 10:20:13,360 [http-nio-8080-exec-4] <==      Total: 7
2019-05-04 10:20:13,369 [http-nio-8080-exec-7] <==      Total: 2
2019-05-04 10:20:14,414 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-05-04 10:20:14,415 [http-nio-8080-exec-9] ==> Parameters: 8(String)
2019-05-04 10:20:14,447 [http-nio-8080-exec-9] <==      Total: 1
2019-05-04 10:20:14,455 [http-nio-8080-exec-9] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addfee,0)+os.fee-coalesce(os.CinemaAllowance,0) as totalSale,os.CinemaAllowance,os.created,t.printno, t.mobilePhone,os.addfee,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-05-04 10:20:14,457 [http-nio-8080-exec-9] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-05-04 10:20:14,482 [http-nio-8080-exec-9] <==      Total: 20
2019-05-04 10:28:14,234 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 10:28:14,235 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-05-04 10:28:14,248 [http-nio-8080-exec-3] <==      Total: 1
2019-05-04 10:28:17,229 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from screeninfo t 
2019-05-04 10:28:17,231 [http-nio-8080-exec-6] ==> Parameters: 
2019-05-04 10:28:17,246 [http-nio-8080-exec-6] <==      Total: 1
2019-05-04 10:28:17,255 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t limit ?, ? 
2019-05-04 10:28:17,256 [http-nio-8080-exec-6] ==> Parameters: 0(Integer), 10(Integer)
2019-05-04 10:28:17,279 [http-nio-8080-exec-6] <==      Total: 10
2019-05-04 10:28:29,482 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-05-04 10:28:29,483 [http-nio-8080-exec-7] ==> Parameters: 8(String)
2019-05-04 10:28:29,502 [http-nio-8080-exec-7] <==      Total: 1
2019-05-04 10:28:29,520 [http-nio-8080-exec-7] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addfee,0)+os.fee-coalesce(os.CinemaAllowance,0) as totalSale,os.CinemaAllowance,os.created,t.printno, t.mobilePhone,os.addfee,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-05-04 10:28:29,521 [http-nio-8080-exec-7] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-05-04 10:28:29,546 [http-nio-8080-exec-7] <==      Total: 20
2019-05-04 10:28:40,647 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 10:28:40,648 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-05-04 10:28:40,657 [http-nio-8080-exec-3] <==      Total: 1
2019-05-04 10:30:38,215 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 10:30:38,216 [http-nio-8080-exec-5] ==> Parameters: 1(Long)
2019-05-04 10:30:38,233 [http-nio-8080-exec-5] <==      Total: 1
2019-05-04 10:31:46,868 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 10:31:46,869 [http-nio-8080-exec-5] ==> Parameters: 1(Long)
2019-05-04 10:31:46,879 [http-nio-8080-exec-5] <==      Total: 1
2019-05-04 10:32:53,242 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 10:32:53,243 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-05-04 10:32:53,260 [http-nio-8080-exec-4] <==      Total: 1
2019-05-04 10:33:30,714 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-05-04 10:33:30,715 [http-nio-8080-exec-10] ==> Parameters: 1(Long)
2019-05-04 10:33:30,724 [http-nio-8080-exec-10] <==      Total: 1
