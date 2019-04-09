2019-04-09 08:58:29,258 [http-nio-8080-exec-8] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-04-09 08:58:29,267 [http-nio-8080-exec-8] ==> Parameters: admin(String)
2019-04-09 08:58:29,394 [http-nio-8080-exec-8] <==      Total: 1
2019-04-09 08:58:29,411 [http-nio-8080-exec-8] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2019-04-09 08:58:29,418 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-04-09 08:58:29,432 [http-nio-8080-exec-8] <==      Total: 45
2019-04-09 08:58:29,562 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-09 08:58:29,570 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-04-09 08:58:29,603 [taskExecutor-1] <==    Updates: 1
2019-04-09 08:58:29,819 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 08:58:29,821 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-04-09 08:58:29,823 [http-nio-8080-exec-4] <==      Total: 1
2019-04-09 08:58:39,150 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 08:58:39,153 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 08:58:39,156 [http-nio-8080-exec-3] <==      Total: 1
2019-04-09 08:58:39,159 [http-nio-8080-exec-3] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 08:58:39,166 [http-nio-8080-exec-3] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 08:58:39,170 [http-nio-8080-exec-3] <==      Total: 2
2019-04-09 08:59:22,497 [http-nio-8080-exec-10] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 08:59:22,498 [http-nio-8080-exec-1] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 08:59:22,499 [http-nio-8080-exec-10] ==> Parameters: 
2019-04-09 08:59:22,500 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 08:59:22,503 [http-nio-8080-exec-10] <==      Total: 6
2019-04-09 08:59:22,504 [http-nio-8080-exec-1] <==      Total: 3
2019-04-09 09:00:48,054 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:00:48,057 [http-nio-8080-exec-5] ==> Parameters: 1(Long)
2019-04-09 09:00:48,060 [http-nio-8080-exec-5] <==      Total: 1
2019-04-09 09:00:49,396 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:00:49,398 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:00:49,399 [http-nio-8080-exec-8] <==      Total: 1
2019-04-09 09:00:49,402 [http-nio-8080-exec-8] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:00:49,404 [http-nio-8080-exec-8] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:00:49,407 [http-nio-8080-exec-8] <==      Total: 2
2019-04-09 09:00:51,417 [http-nio-8080-exec-5] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:00:51,417 [http-nio-8080-exec-10] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:00:51,419 [http-nio-8080-exec-5] ==> Parameters: 
2019-04-09 09:00:51,419 [http-nio-8080-exec-10] ==> Parameters: 
2019-04-09 09:00:51,421 [http-nio-8080-exec-5] <==      Total: 6
2019-04-09 09:00:51,421 [http-nio-8080-exec-10] <==      Total: 3
2019-04-09 09:01:10,716 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:01:10,717 [http-nio-8080-exec-9] ==> Parameters: 1(Long)
2019-04-09 09:01:10,718 [http-nio-8080-exec-9] <==      Total: 1
2019-04-09 09:01:11,914 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:01:11,915 [http-nio-8080-exec-5] ==> Parameters: 
2019-04-09 09:01:11,917 [http-nio-8080-exec-5] <==      Total: 1
2019-04-09 09:01:11,919 [http-nio-8080-exec-5] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:01:11,920 [http-nio-8080-exec-5] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:01:11,923 [http-nio-8080-exec-5] <==      Total: 2
2019-04-09 09:01:13,564 [http-nio-8080-exec-7] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:01:13,564 [http-nio-8080-exec-8] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:01:13,565 [http-nio-8080-exec-7] ==> Parameters: 
2019-04-09 09:01:13,565 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:01:13,566 [http-nio-8080-exec-7] <==      Total: 3
2019-04-09 09:01:13,566 [http-nio-8080-exec-8] <==      Total: 6
2019-04-09 09:02:38,809 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:02:38,809 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-04-09 09:02:38,811 [http-nio-8080-exec-2] <==      Total: 1
2019-04-09 09:02:40,112 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:02:40,114 [http-nio-8080-exec-5] ==> Parameters: 
2019-04-09 09:02:40,116 [http-nio-8080-exec-5] <==      Total: 1
2019-04-09 09:02:40,117 [http-nio-8080-exec-5] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:02:40,118 [http-nio-8080-exec-5] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:02:40,123 [http-nio-8080-exec-5] <==      Total: 2
2019-04-09 09:02:42,148 [http-nio-8080-exec-8] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:02:42,149 [http-nio-8080-exec-1] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:02:42,149 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:02:42,150 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:02:42,152 [http-nio-8080-exec-1] <==      Total: 3
2019-04-09 09:02:42,152 [http-nio-8080-exec-8] <==      Total: 6
2019-04-09 09:02:49,351 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:02:49,352 [http-nio-8080-exec-1] ==> Parameters: 1(Long)
2019-04-09 09:02:49,354 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 09:02:51,144 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:02:51,145 [http-nio-8080-exec-9] ==> Parameters: 
2019-04-09 09:02:51,147 [http-nio-8080-exec-9] <==      Total: 1
2019-04-09 09:02:51,149 [http-nio-8080-exec-9] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:02:51,150 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:02:51,153 [http-nio-8080-exec-9] <==      Total: 2
2019-04-09 09:02:52,773 [http-nio-8080-exec-7] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:02:52,773 [http-nio-8080-exec-8] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:02:52,774 [http-nio-8080-exec-7] ==> Parameters: 
2019-04-09 09:02:52,774 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:02:52,775 [http-nio-8080-exec-8] <==      Total: 3
2019-04-09 09:02:52,775 [http-nio-8080-exec-7] <==      Total: 6
2019-04-09 09:03:04,725 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:03:04,726 [http-nio-8080-exec-10] ==> Parameters: 1(Long)
2019-04-09 09:03:04,727 [http-nio-8080-exec-10] <==      Total: 1
2019-04-09 09:03:05,979 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:03:05,981 [http-nio-8080-exec-5] ==> Parameters: 
2019-04-09 09:03:05,983 [http-nio-8080-exec-5] <==      Total: 1
2019-04-09 09:03:05,984 [http-nio-8080-exec-5] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:03:05,985 [http-nio-8080-exec-5] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:03:05,987 [http-nio-8080-exec-5] <==      Total: 2
2019-04-09 09:03:07,365 [http-nio-8080-exec-7] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:03:07,365 [http-nio-8080-exec-9] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:03:07,366 [http-nio-8080-exec-9] ==> Parameters: 
2019-04-09 09:03:07,366 [http-nio-8080-exec-7] ==> Parameters: 
2019-04-09 09:03:07,367 [http-nio-8080-exec-9] <==      Total: 6
2019-04-09 09:03:07,367 [http-nio-8080-exec-7] <==      Total: 3
2019-04-09 09:03:24,687 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:03:24,688 [http-nio-8080-exec-6] ==> Parameters: 1(Long)
2019-04-09 09:03:24,689 [http-nio-8080-exec-6] <==      Total: 1
2019-04-09 09:03:25,828 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:03:25,829 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-09 09:03:25,832 [http-nio-8080-exec-2] <==      Total: 1
2019-04-09 09:03:25,833 [http-nio-8080-exec-2] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:03:25,834 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:03:25,838 [http-nio-8080-exec-2] <==      Total: 2
2019-04-09 09:03:27,165 [http-nio-8080-exec-4] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:03:27,165 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:03:27,166 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:03:27,166 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:03:27,168 [http-nio-8080-exec-3] <==      Total: 3
2019-04-09 09:03:27,168 [http-nio-8080-exec-4] <==      Total: 6
2019-04-09 09:04:19,438 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:04:19,439 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-04-09 09:04:19,440 [http-nio-8080-exec-2] <==      Total: 1
2019-04-09 09:04:20,848 [http-nio-8080-exec-7] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-04-09 09:04:20,849 [http-nio-8080-exec-7] ==> Parameters: OrderStatusEnum(String)
2019-04-09 09:04:20,852 [http-nio-8080-exec-7] <==      Total: 11
2019-04-09 09:04:20,861 [http-nio-8080-exec-5] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-04-09 09:04:20,862 [http-nio-8080-exec-5] ==> Parameters: payType(String)
2019-04-09 09:04:20,864 [http-nio-8080-exec-5] <==      Total: 5
2019-04-09 09:04:20,921 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-04-09 09:04:20,924 [http-nio-8080-exec-9] ==> Parameters: 8(String)
2019-04-09 09:04:20,930 [http-nio-8080-exec-9] <==      Total: 1
2019-04-09 09:04:20,932 [http-nio-8080-exec-9] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addedprice,0)+os.fee-coalesce(os.preferentialPrice,0) as totalSale,os.preferentialPrice,os.created,t.printno, t.mobilePhone,os.addedprice,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-04-09 09:04:20,936 [http-nio-8080-exec-9] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-04-09 09:04:20,949 [http-nio-8080-exec-9] <==      Total: 13
2019-04-09 09:04:21,328 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:04:21,330 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:04:21,333 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 09:04:21,335 [http-nio-8080-exec-1] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:04:21,336 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:04:21,338 [http-nio-8080-exec-1] <==      Total: 2
2019-04-09 09:04:23,813 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:04:23,813 [http-nio-8080-exec-4] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:04:23,814 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:04:23,814 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:04:23,814 [http-nio-8080-exec-4] <==      Total: 6
2019-04-09 09:04:23,814 [http-nio-8080-exec-3] <==      Total: 3
2019-04-09 09:04:49,553 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:04:49,555 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-04-09 09:04:49,558 [http-nio-8080-exec-8] <==      Total: 1
2019-04-09 09:04:50,959 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:04:50,959 [http-nio-8080-exec-7] ==> Parameters: 
2019-04-09 09:04:50,961 [http-nio-8080-exec-7] <==      Total: 1
2019-04-09 09:04:50,962 [http-nio-8080-exec-7] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:04:50,963 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:04:50,965 [http-nio-8080-exec-7] <==      Total: 2
2019-04-09 09:04:52,445 [http-nio-8080-exec-4] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:04:52,445 [http-nio-8080-exec-10] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:04:52,445 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:04:52,445 [http-nio-8080-exec-10] ==> Parameters: 
2019-04-09 09:04:52,446 [http-nio-8080-exec-10] <==      Total: 3
2019-04-09 09:04:52,446 [http-nio-8080-exec-4] <==      Total: 6
2019-04-09 09:05:10,909 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:05:10,910 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-04-09 09:05:10,911 [http-nio-8080-exec-2] <==      Total: 1
2019-04-09 09:05:12,415 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:05:12,416 [http-nio-8080-exec-10] ==> Parameters: 
2019-04-09 09:05:12,420 [http-nio-8080-exec-10] <==      Total: 1
2019-04-09 09:05:12,422 [http-nio-8080-exec-10] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:05:12,423 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:05:12,426 [http-nio-8080-exec-10] <==      Total: 2
2019-04-09 09:05:13,755 [http-nio-8080-exec-4] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:05:13,755 [http-nio-8080-exec-7] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:05:13,756 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:05:13,756 [http-nio-8080-exec-7] ==> Parameters: 
2019-04-09 09:05:13,757 [http-nio-8080-exec-7] <==      Total: 6
2019-04-09 09:05:13,757 [http-nio-8080-exec-4] <==      Total: 3
2019-04-09 09:06:00,753 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:06:00,754 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-04-09 09:06:00,756 [http-nio-8080-exec-7] <==      Total: 1
2019-04-09 09:06:02,148 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-04-09 09:06:02,149 [http-nio-8080-exec-1] ==> Parameters: 8(String)
2019-04-09 09:06:02,153 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 09:06:02,156 [http-nio-8080-exec-1] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addedprice,0)+os.fee-coalesce(os.preferentialPrice,0) as totalSale,os.preferentialPrice,os.created,t.printno, t.mobilePhone,os.addedprice,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-04-09 09:06:02,157 [http-nio-8080-exec-1] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-04-09 09:06:02,165 [http-nio-8080-exec-1] <==      Total: 13
2019-04-09 09:06:02,567 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:06:02,568 [http-nio-8080-exec-6] ==> Parameters: 
2019-04-09 09:06:02,570 [http-nio-8080-exec-6] <==      Total: 1
2019-04-09 09:06:02,571 [http-nio-8080-exec-6] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:06:02,571 [http-nio-8080-exec-6] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:06:02,576 [http-nio-8080-exec-6] <==      Total: 2
2019-04-09 09:06:04,353 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:06:04,353 [http-nio-8080-exec-8] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:06:04,354 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:06:04,354 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:06:04,355 [http-nio-8080-exec-8] <==      Total: 6
2019-04-09 09:06:04,355 [http-nio-8080-exec-3] <==      Total: 3
2019-04-09 09:06:19,672 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:06:19,673 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-04-09 09:06:19,674 [http-nio-8080-exec-8] <==      Total: 1
2019-04-09 09:06:20,744 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:06:20,745 [http-nio-8080-exec-6] ==> Parameters: 
2019-04-09 09:06:20,748 [http-nio-8080-exec-6] <==      Total: 1
2019-04-09 09:06:20,751 [http-nio-8080-exec-6] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:06:20,752 [http-nio-8080-exec-6] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:06:20,757 [http-nio-8080-exec-6] <==      Total: 2
2019-04-09 09:06:21,975 [http-nio-8080-exec-1] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:06:21,975 [http-nio-8080-exec-5] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:06:21,976 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:06:21,976 [http-nio-8080-exec-5] ==> Parameters: 
2019-04-09 09:06:21,977 [http-nio-8080-exec-1] <==      Total: 3
2019-04-09 09:06:21,977 [http-nio-8080-exec-5] <==      Total: 6
2019-04-09 09:06:54,143 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:06:54,144 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-04-09 09:06:54,146 [http-nio-8080-exec-7] <==      Total: 1
2019-04-09 09:06:55,428 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:06:55,429 [http-nio-8080-exec-9] ==> Parameters: 
2019-04-09 09:06:55,432 [http-nio-8080-exec-9] <==      Total: 1
2019-04-09 09:06:55,433 [http-nio-8080-exec-9] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:06:55,434 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:06:55,436 [http-nio-8080-exec-9] <==      Total: 2
2019-04-09 09:06:56,852 [http-nio-8080-exec-8] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:06:56,852 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:06:56,853 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:06:56,853 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:06:56,854 [http-nio-8080-exec-3] <==      Total: 3
2019-04-09 09:06:56,854 [http-nio-8080-exec-8] <==      Total: 6
2019-04-09 09:07:11,796 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:07:11,797 [http-nio-8080-exec-9] ==> Parameters: 1(Long)
2019-04-09 09:07:11,799 [http-nio-8080-exec-9] <==      Total: 1
2019-04-09 09:07:13,465 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:07:13,466 [http-nio-8080-exec-10] ==> Parameters: 
2019-04-09 09:07:13,470 [http-nio-8080-exec-10] <==      Total: 1
2019-04-09 09:07:13,471 [http-nio-8080-exec-10] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:07:13,471 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:07:13,474 [http-nio-8080-exec-10] <==      Total: 2
2019-04-09 09:07:14,882 [http-nio-8080-exec-1] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:07:14,882 [http-nio-8080-exec-6] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:07:14,883 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:07:14,883 [http-nio-8080-exec-6] ==> Parameters: 
2019-04-09 09:07:14,884 [http-nio-8080-exec-1] <==      Total: 6
2019-04-09 09:07:14,884 [http-nio-8080-exec-6] <==      Total: 3
2019-04-09 09:07:34,972 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:07:34,974 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-04-09 09:07:34,975 [http-nio-8080-exec-7] <==      Total: 1
2019-04-09 09:07:36,373 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:07:36,374 [http-nio-8080-exec-9] ==> Parameters: 
2019-04-09 09:07:36,376 [http-nio-8080-exec-9] <==      Total: 1
2019-04-09 09:07:36,377 [http-nio-8080-exec-9] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:07:36,377 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:07:36,380 [http-nio-8080-exec-9] <==      Total: 2
2019-04-09 09:07:37,705 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:07:37,705 [http-nio-8080-exec-1] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:07:37,706 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:07:37,706 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:07:37,709 [http-nio-8080-exec-3] <==      Total: 3
2019-04-09 09:07:37,709 [http-nio-8080-exec-1] <==      Total: 6
2019-04-09 09:07:52,221 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:07:52,222 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-04-09 09:07:52,223 [http-nio-8080-exec-3] <==      Total: 1
2019-04-09 09:07:53,303 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:07:53,304 [http-nio-8080-exec-10] ==> Parameters: 
2019-04-09 09:07:53,307 [http-nio-8080-exec-10] <==      Total: 1
2019-04-09 09:07:53,308 [http-nio-8080-exec-10] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:07:53,309 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:07:53,311 [http-nio-8080-exec-10] <==      Total: 2
2019-04-09 09:07:55,237 [http-nio-8080-exec-4] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:07:55,237 [http-nio-8080-exec-6] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:07:55,238 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:07:55,238 [http-nio-8080-exec-6] ==> Parameters: 
2019-04-09 09:07:55,239 [http-nio-8080-exec-6] <==      Total: 3
2019-04-09 09:07:55,239 [http-nio-8080-exec-4] <==      Total: 6
2019-04-09 09:09:01,693 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:09:01,694 [http-nio-8080-exec-9] ==> Parameters: 1(Long)
2019-04-09 09:09:01,696 [http-nio-8080-exec-9] <==      Total: 1
2019-04-09 09:09:03,149 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:09:03,151 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:09:03,155 [http-nio-8080-exec-8] <==      Total: 1
2019-04-09 09:09:03,158 [http-nio-8080-exec-8] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:09:03,159 [http-nio-8080-exec-8] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:09:03,161 [http-nio-8080-exec-8] <==      Total: 2
2019-04-09 09:09:04,994 [http-nio-8080-exec-5] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:09:04,994 [http-nio-8080-exec-9] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:09:04,995 [http-nio-8080-exec-9] ==> Parameters: 
2019-04-09 09:09:04,995 [http-nio-8080-exec-5] ==> Parameters: 
2019-04-09 09:09:04,996 [http-nio-8080-exec-5] <==      Total: 3
2019-04-09 09:09:04,996 [http-nio-8080-exec-9] <==      Total: 6
2019-04-09 09:09:49,721 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:09:49,721 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-04-09 09:09:49,722 [http-nio-8080-exec-4] <==      Total: 1
2019-04-09 09:09:51,231 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:09:51,232 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:09:51,234 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 09:09:51,237 [http-nio-8080-exec-1] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:09:51,237 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:09:51,239 [http-nio-8080-exec-1] <==      Total: 2
2019-04-09 09:09:52,913 [http-nio-8080-exec-8] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:09:52,913 [http-nio-8080-exec-4] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:09:52,913 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:09:52,913 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:09:52,915 [http-nio-8080-exec-4] <==      Total: 6
2019-04-09 09:09:52,915 [http-nio-8080-exec-8] <==      Total: 3
2019-04-09 09:10:21,928 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:10:21,929 [http-nio-8080-exec-6] ==> Parameters: 1(Long)
2019-04-09 09:10:21,930 [http-nio-8080-exec-6] <==      Total: 1
2019-04-09 09:10:23,418 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:10:23,419 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:10:23,422 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 09:10:23,423 [http-nio-8080-exec-1] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:10:23,424 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:10:23,426 [http-nio-8080-exec-1] <==      Total: 2
2019-04-09 09:10:24,813 [http-nio-8080-exec-4] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:10:24,813 [http-nio-8080-exec-8] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:10:24,814 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:10:24,814 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:10:24,815 [http-nio-8080-exec-8] <==      Total: 6
2019-04-09 09:10:24,815 [http-nio-8080-exec-4] <==      Total: 3
2019-04-09 09:11:12,264 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:11:12,264 [http-nio-8080-exec-1] ==> Parameters: 1(Long)
2019-04-09 09:11:12,265 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 09:11:13,605 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:11:13,606 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:11:13,609 [http-nio-8080-exec-3] <==      Total: 1
2019-04-09 09:11:13,611 [http-nio-8080-exec-3] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:11:13,612 [http-nio-8080-exec-3] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:11:13,616 [http-nio-8080-exec-3] <==      Total: 2
2019-04-09 09:11:14,599 [http-nio-8080-exec-10] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:11:14,599 [http-nio-8080-exec-2] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:11:14,600 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-09 09:11:14,600 [http-nio-8080-exec-10] ==> Parameters: 
2019-04-09 09:11:14,602 [http-nio-8080-exec-10] <==      Total: 6
2019-04-09 09:11:14,602 [http-nio-8080-exec-2] <==      Total: 3
2019-04-09 09:11:27,861 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:11:27,862 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-04-09 09:11:27,863 [http-nio-8080-exec-4] <==      Total: 1
2019-04-09 09:11:28,971 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:11:28,972 [http-nio-8080-exec-7] ==> Parameters: 
2019-04-09 09:11:28,975 [http-nio-8080-exec-7] <==      Total: 1
2019-04-09 09:11:28,976 [http-nio-8080-exec-7] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:11:28,977 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:11:28,980 [http-nio-8080-exec-7] <==      Total: 2
2019-04-09 09:11:30,177 [http-nio-8080-exec-10] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:11:30,177 [http-nio-8080-exec-2] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:11:30,178 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-09 09:11:30,178 [http-nio-8080-exec-10] ==> Parameters: 
2019-04-09 09:11:30,179 [http-nio-8080-exec-10] <==      Total: 6
2019-04-09 09:11:30,179 [http-nio-8080-exec-2] <==      Total: 3
2019-04-09 09:11:45,905 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:11:45,906 [http-nio-8080-exec-10] ==> Parameters: 1(Long)
2019-04-09 09:11:45,907 [http-nio-8080-exec-10] <==      Total: 1
2019-04-09 09:11:46,891 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:11:46,892 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:11:46,895 [http-nio-8080-exec-8] <==      Total: 1
2019-04-09 09:11:46,897 [http-nio-8080-exec-8] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:11:46,897 [http-nio-8080-exec-8] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:11:46,899 [http-nio-8080-exec-8] <==      Total: 2
2019-04-09 09:11:48,316 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:11:48,316 [http-nio-8080-exec-4] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:11:48,317 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:11:48,317 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:11:48,317 [http-nio-8080-exec-4] <==      Total: 6
2019-04-09 09:11:48,317 [http-nio-8080-exec-3] <==      Total: 3
2019-04-09 09:12:17,251 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:12:17,253 [http-nio-8080-exec-6] ==> Parameters: 
2019-04-09 09:12:17,255 [http-nio-8080-exec-6] <==      Total: 1
2019-04-09 09:12:17,256 [http-nio-8080-exec-6] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:12:17,257 [http-nio-8080-exec-6] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:12:17,259 [http-nio-8080-exec-6] <==      Total: 2
2019-04-09 09:12:18,953 [http-nio-8080-exec-8] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:12:18,953 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:12:18,953 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:12:18,954 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:12:18,954 [http-nio-8080-exec-8] <==      Total: 6
2019-04-09 09:12:18,954 [http-nio-8080-exec-3] <==      Total: 3
2019-04-09 09:13:39,686 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:13:39,687 [http-nio-8080-exec-5] ==> Parameters: 1(Long)
2019-04-09 09:13:39,688 [http-nio-8080-exec-5] <==      Total: 1
2019-04-09 09:13:41,003 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:13:41,004 [http-nio-8080-exec-6] ==> Parameters: 
2019-04-09 09:13:41,006 [http-nio-8080-exec-6] <==      Total: 1
2019-04-09 09:13:41,008 [http-nio-8080-exec-6] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:13:41,008 [http-nio-8080-exec-6] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:13:41,011 [http-nio-8080-exec-6] <==      Total: 2
2019-04-09 09:13:42,775 [http-nio-8080-exec-1] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:13:42,775 [http-nio-8080-exec-9] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:13:42,775 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:13:42,775 [http-nio-8080-exec-9] ==> Parameters: 
2019-04-09 09:13:42,776 [http-nio-8080-exec-9] <==      Total: 3
2019-04-09 09:13:42,776 [http-nio-8080-exec-1] <==      Total: 6
2019-04-09 09:18:28,796 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:18:28,797 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-04-09 09:18:28,798 [http-nio-8080-exec-3] <==      Total: 1
2019-04-09 09:18:30,217 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:18:30,218 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 09:18:30,221 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 09:18:30,222 [http-nio-8080-exec-1] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:18:30,223 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:18:30,225 [http-nio-8080-exec-1] <==      Total: 2
2019-04-09 09:18:31,789 [http-nio-8080-exec-4] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:18:31,789 [http-nio-8080-exec-8] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:18:31,791 [http-nio-8080-exec-4] ==> Parameters: 
2019-04-09 09:18:31,791 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:18:31,792 [http-nio-8080-exec-4] <==      Total: 3
2019-04-09 09:18:31,792 [http-nio-8080-exec-8] <==      Total: 6
2019-04-09 09:29:03,314 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:29:03,315 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-04-09 09:29:03,316 [http-nio-8080-exec-7] <==      Total: 1
2019-04-09 09:29:04,346 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:29:04,346 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-09 09:29:04,350 [http-nio-8080-exec-2] <==      Total: 1
2019-04-09 09:29:04,353 [http-nio-8080-exec-2] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:29:04,353 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:29:04,356 [http-nio-8080-exec-2] <==      Total: 2
2019-04-09 09:29:06,482 [http-nio-8080-exec-7] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:29:06,482 [http-nio-8080-exec-3] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:29:06,483 [http-nio-8080-exec-7] ==> Parameters: 
2019-04-09 09:29:06,483 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:29:06,485 [http-nio-8080-exec-3] <==      Total: 6
2019-04-09 09:29:06,485 [http-nio-8080-exec-7] <==      Total: 3
2019-04-09 09:29:19,819 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:29:19,821 [http-nio-8080-exec-1] ==> Parameters: 1(Long)
2019-04-09 09:29:19,822 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 09:29:20,994 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:29:20,994 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-09 09:29:20,996 [http-nio-8080-exec-2] <==      Total: 1
2019-04-09 09:29:20,997 [http-nio-8080-exec-2] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:29:20,997 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:29:21,000 [http-nio-8080-exec-2] <==      Total: 2
2019-04-09 09:29:22,596 [http-nio-8080-exec-8] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:29:22,596 [http-nio-8080-exec-3] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:29:22,597 [http-nio-8080-exec-8] ==> Parameters: 
2019-04-09 09:29:22,597 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:29:22,598 [http-nio-8080-exec-8] <==      Total: 3
2019-04-09 09:29:22,598 [http-nio-8080-exec-3] <==      Total: 6
2019-04-09 09:30:24,082 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-09 09:30:24,083 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-04-09 09:30:24,084 [http-nio-8080-exec-7] <==      Total: 1
2019-04-09 09:30:25,258 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 09:30:25,259 [http-nio-8080-exec-2] ==> Parameters: 
2019-04-09 09:30:25,262 [http-nio-8080-exec-2] <==      Total: 1
2019-04-09 09:30:25,263 [http-nio-8080-exec-2] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 09:30:25,263 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 09:30:25,266 [http-nio-8080-exec-2] <==      Total: 2
2019-04-09 09:30:27,252 [http-nio-8080-exec-3] ==>  Preparing: select id,typecode,typename from conpontype where typecode = 01 or typecode = 02 or typecode = 03 
2019-04-09 09:30:27,252 [http-nio-8080-exec-6] ==>  Preparing: select cinemaname from systemusers where roleid = 6 
2019-04-09 09:30:27,252 [http-nio-8080-exec-3] ==> Parameters: 
2019-04-09 09:30:27,252 [http-nio-8080-exec-6] ==> Parameters: 
2019-04-09 09:30:27,253 [http-nio-8080-exec-6] <==      Total: 6
2019-04-09 09:30:27,253 [http-nio-8080-exec-3] <==      Total: 3
2019-04-09 10:12:11,800 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from conpongroup c left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode 
2019-04-09 10:12:11,801 [http-nio-8080-exec-1] ==> Parameters: 
2019-04-09 10:12:11,804 [http-nio-8080-exec-1] <==      Total: 1
2019-04-09 10:12:11,805 [http-nio-8080-exec-1] ==>  Preparing: select c.groupcode,c.id,c.CinemaCode,ct.typename,c.GroupName,c.Price,c.ConponNumber,c.ValidityDate,cp1.alls,cp2.used,cp3.unused,cp4.received,c.Remark from conpongroup c left join conpontype ct on c.TypeCode = ct.TypeCode left join conpons cp on c.GroupCode = cp.GroupCode left join (select GroupCode,count(status) as alls from conpons group by GroupCode) cp1 on c.GroupCode = cp1.GroupCode left join (select GroupCode,count(status) as used from conpons where status = 2 group by GroupCode) cp2 on c.GroupCode = cp2.GroupCode left join (select GroupCode,count(status) as unused from conpons where status = 3 group by GroupCode) cp3 on c.GroupCode = cp3.GroupCode left join (select GroupCode,count(status) as received from conpons where status = 4 group by GroupCode) cp4 on c.GroupCode = cp4.GroupCode group by c.groupcode limit ?, ? 
2019-04-09 10:12:11,805 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-04-09 10:12:11,808 [http-nio-8080-exec-1] <==      Total: 2
2019-04-09 10:12:13,830 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id right join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? 
2019-04-09 10:12:13,832 [http-nio-8080-exec-4] ==> Parameters: 8(String)
2019-04-09 10:12:13,836 [http-nio-8080-exec-4] <==      Total: 1
2019-04-09 10:12:13,837 [http-nio-8080-exec-4] ==>  Preparing: select os.id,c.id,u.id,us.id,c.name,t.filmname,t.sessionTime, concat(replace(ltrim(replace(t.screencode,'0',' ')),' ','0'),'号厅') as screencode, t.submitOrderCode,os.rownum,os.columnnum,os.filmTicketCode, concat(if(left(os.rownum,1)='0',mid(os.rownum,2),os.rownum),'排',if(left(os.columnnum,1)='0',mid(os.columnnum,2),os.columnnum),'座') as seat, os.price,os.salePrice,t.paytype, os.price+coalesce(os.addedprice,0)+os.fee-coalesce(os.preferentialPrice,0) as totalSale,os.preferentialPrice,os.created,t.printno, t.mobilePhone,os.addedprice,os.fee,t.orderStatus from orders t left join cinema c on t.cinemacode = c.code left join user_cinema u on t.cinemacode = u.cinemacode left join userinfo us on u.userid = us.id join orderseatdetails os on t.id = os.orderid where us.isdel =0 and t.OrderStatus = ? limit ?, ? 
2019-04-09 10:12:13,838 [http-nio-8080-exec-4] ==> Parameters: 8(String), 0(Integer), 50(Integer)
2019-04-09 10:12:13,848 [http-nio-8080-exec-4] <==      Total: 13
2019-04-09 11:36:50,386 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-09 11:36:50,553 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-09 11:36:50,569 [main] <==      Total: 1
2019-04-09 11:36:50,570 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? 
2019-04-09 11:36:50,572 [main] ==> Parameters: 12(Long)
2019-04-09 11:36:50,698 [main] <==      Total: 0
2019-04-09 11:42:35,955 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-09 11:42:36,110 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-09 11:42:36,126 [main] <==      Total: 1
2019-04-09 11:44:00,508 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-09 11:44:00,715 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-09 11:44:00,736 [main] <==      Total: 1
2019-04-09 11:44:00,738 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-09 11:44:00,741 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-09 11:44:00,742 [main] <==      Total: 0
2019-04-09 12:03:25,941 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-09 12:03:26,095 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-09 12:03:26,109 [main] <==      Total: 1
2019-04-09 12:03:26,110 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? 
2019-04-09 12:03:26,112 [main] ==> Parameters: 12(Long)
2019-04-09 12:03:26,113 [main] <==      Total: 0
