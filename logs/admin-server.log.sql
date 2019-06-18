2019-06-18 00:03:15,362 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from (select t.* from cinema t left join goods g on t.code = g.CinemaCode WHERE t.Code in (select cinemaCode from sys_user) GROUP BY t.code)c 
2019-06-18 00:03:15,370 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:03:15,384 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:03:15,405 [http-nio-8080-exec-7] ==>  Preparing: select c.* from (select t.*,g.updated AS GoodsUpdated from cinema t left join goods g on t.code = g.CinemaCode WHERE t.Code in (select cinemaCode from sys_user) GROUP BY t.code)c limit ?, ? 
2019-06-18 00:03:15,410 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:03:15,426 [http-nio-8080-exec-7] <==      Total: 10
2019-06-18 00:03:21,589 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from (select t.* from cinema t left join goods g on t.code = g.CinemaCode WHERE t.Code in (select cinemaCode from sys_user) GROUP BY t.code)c 
2019-06-18 00:03:21,590 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:03:21,615 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:03:21,637 [http-nio-8080-exec-3] ==>  Preparing: select c.* from (select t.*,g.updated AS GoodsUpdated from cinema t left join goods g on t.code = g.CinemaCode WHERE t.Code in (select cinemaCode from sys_user) GROUP BY t.code)c limit ?, ? 
2019-06-18 00:03:21,638 [http-nio-8080-exec-3] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:03:21,651 [http-nio-8080-exec-3] <==      Total: 10
2019-06-18 00:17:48,599 [http-nio-8080-exec-8] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 00:17:48,601 [http-nio-8080-exec-8] ==> Parameters: operatingResult(String)
2019-06-18 00:17:48,609 [http-nio-8080-exec-8] <==      Total: 2
2019-06-18 00:17:48,643 [http-nio-8080-exec-7] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 00:17:48,644 [http-nio-8080-exec-7] ==> Parameters: ticketUserType(String)
2019-06-18 00:17:48,650 [http-nio-8080-exec-7] <==      Total: 4
2019-06-18 00:17:48,712 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:17:48,715 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:17:48,729 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 00:17:48,759 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:17:48,760 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:17:48,766 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 00:17:48,770 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 00:17:48,771 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 00:17:48,775 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:17:48,795 [http-nio-8080-exec-2] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 00:17:48,798 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:17:48,806 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:48,808 [http-nio-8080-exec-2] <==      Total: 10
2019-06-18 00:17:48,809 [http-nio-8080-exec-3] ==> Parameters: 33097601(String)
2019-06-18 00:17:48,825 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:17:48,843 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:48,844 [http-nio-8080-exec-3] ==> Parameters: 33097601(String)
2019-06-18 00:17:48,852 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:17:48,871 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:48,871 [http-nio-8080-exec-3] ==> Parameters: 33097601(String)
2019-06-18 00:17:48,879 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:17:48,899 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:48,900 [http-nio-8080-exec-3] ==> Parameters: 33097601(String)
2019-06-18 00:17:48,908 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:17:48,927 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:48,927 [http-nio-8080-exec-3] ==> Parameters: 33097601(String)
2019-06-18 00:17:48,934 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:17:48,955 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:48,955 [http-nio-8080-exec-3] ==> Parameters: 22113901(String)
2019-06-18 00:17:48,975 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:48,995 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:48,996 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:17:49,016 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,035 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,036 [http-nio-8080-exec-3] ==> Parameters: 33111001(String)
2019-06-18 00:17:49,056 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,075 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,076 [http-nio-8080-exec-3] ==> Parameters: 18888888(String)
2019-06-18 00:17:49,096 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,115 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,116 [http-nio-8080-exec-3] ==> Parameters: 33074881(String)
2019-06-18 00:17:49,136 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,155 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,156 [http-nio-8080-exec-3] ==> Parameters: 62549174(String)
2019-06-18 00:17:49,176 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,196 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,197 [http-nio-8080-exec-3] ==> Parameters: addsf(String)
2019-06-18 00:17:49,216 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,235 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,236 [http-nio-8080-exec-3] ==> Parameters: gzxxx(String)
2019-06-18 00:17:49,256 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,275 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,276 [http-nio-8080-exec-3] ==> Parameters: 22060081(String)
2019-06-18 00:17:49,296 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,315 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,316 [http-nio-8080-exec-3] ==> Parameters: 31120907(String)
2019-06-18 00:17:49,336 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,355 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,356 [http-nio-8080-exec-3] ==> Parameters: 33013701(String)
2019-06-18 00:17:49,376 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,395 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,397 [http-nio-8080-exec-3] ==> Parameters: 34140901(String)
2019-06-18 00:17:49,412 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,432 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:49,433 [http-nio-8080-exec-3] ==> Parameters: 33112911(String)
2019-06-18 00:17:49,457 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:17:49,475 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:17:49,477 [http-nio-8080-exec-3] ==> Parameters: 1560674924223303(String)
2019-06-18 00:17:49,486 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:17:49,508 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:17:49,508 [http-nio-8080-exec-3] ==> Parameters: 1560691023985310(String)
2019-06-18 00:17:49,516 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:17:49,540 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:17:49,542 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:17:49,564 [http-nio-8080-exec-3] <==      Total: 5
2019-06-18 00:17:49,616 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 00:17:49,617 [http-nio-8080-exec-8] ==> Parameters: 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String)
2019-06-18 00:17:49,623 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:17:49,643 [http-nio-8080-exec-8] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 00:17:49,644 [http-nio-8080-exec-8] ==> Parameters: 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 0(Integer), 10(Integer)
2019-06-18 00:17:49,652 [http-nio-8080-exec-8] <==      Total: 10
2019-06-18 00:17:50,347 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:17:50,348 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:17:50,357 [http-nio-8080-exec-7] <==      Total: 14
2019-06-18 00:17:50,383 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:17:50,383 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:17:50,393 [http-nio-8080-exec-7] <==      Total: 14
2019-06-18 00:17:50,459 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,460 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:17:50,468 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:17:50,487 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,488 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:17:50,510 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:17:50,527 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,528 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:17:50,538 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:17:50,559 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,561 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:17:50,568 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:17:50,587 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,588 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:17:50,596 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:17:50,618 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,619 [http-nio-8080-exec-4] ==> Parameters: 22113901(String)
2019-06-18 00:17:50,642 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,663 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,664 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:17:50,687 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,707 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,708 [http-nio-8080-exec-4] ==> Parameters: 33111001(String)
2019-06-18 00:17:50,727 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,747 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,748 [http-nio-8080-exec-4] ==> Parameters: 18888888(String)
2019-06-18 00:17:50,767 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,787 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,788 [http-nio-8080-exec-4] ==> Parameters: 33074881(String)
2019-06-18 00:17:50,812 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,831 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,832 [http-nio-8080-exec-4] ==> Parameters: 62549174(String)
2019-06-18 00:17:50,855 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,875 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,876 [http-nio-8080-exec-4] ==> Parameters: addsf(String)
2019-06-18 00:17:50,896 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,916 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,916 [http-nio-8080-exec-4] ==> Parameters: gzxxx(String)
2019-06-18 00:17:50,936 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,955 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,956 [http-nio-8080-exec-4] ==> Parameters: 22060081(String)
2019-06-18 00:17:50,976 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:50,996 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:50,997 [http-nio-8080-exec-4] ==> Parameters: 31120907(String)
2019-06-18 00:17:51,024 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:51,045 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:51,046 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 00:17:51,069 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:51,095 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:51,096 [http-nio-8080-exec-4] ==> Parameters: 34140901(String)
2019-06-18 00:17:51,120 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:51,139 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:17:51,140 [http-nio-8080-exec-4] ==> Parameters: 33112911(String)
2019-06-18 00:17:51,162 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:17:51,184 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:17:51,186 [http-nio-8080-exec-4] ==> Parameters: 1560674924223303(String)
2019-06-18 00:17:51,197 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:17:51,219 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:17:51,220 [http-nio-8080-exec-4] ==> Parameters: 1560691023985310(String)
2019-06-18 00:17:51,231 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:17:51,251 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:17:51,252 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:17:51,261 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:17:53,008 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:17:53,010 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:17:53,021 [http-nio-8080-exec-6] <==      Total: 5
2019-06-18 00:17:54,331 [http-nio-8080-exec-10] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:17:54,333 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:17:54,361 [http-nio-8080-exec-10] <==      Total: 5
2019-06-18 00:17:59,935 [http-nio-8080-exec-1] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:17:59,937 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:17:59,946 [http-nio-8080-exec-1] <==      Total: 5
2019-06-18 00:18:09,811 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:18:09,813 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:18:09,823 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:18:09,843 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:18:09,844 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:18:09,850 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 00:18:09,852 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:18:09,853 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:18:09,858 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:18:09,879 [http-nio-8080-exec-6] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 00:18:09,879 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:09,880 [http-nio-8080-exec-2] ==> Parameters: 33097601(String)
2019-06-18 00:18:09,880 [http-nio-8080-exec-6] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:18:09,887 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 00:18:09,887 [http-nio-8080-exec-6] <==      Total: 10
2019-06-18 00:18:09,907 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:09,908 [http-nio-8080-exec-2] ==> Parameters: 33097601(String)
2019-06-18 00:18:09,915 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 00:18:09,939 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:09,940 [http-nio-8080-exec-2] ==> Parameters: 33097601(String)
2019-06-18 00:18:09,947 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 00:18:09,967 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:09,968 [http-nio-8080-exec-2] ==> Parameters: 33097601(String)
2019-06-18 00:18:09,975 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 00:18:09,995 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:09,996 [http-nio-8080-exec-2] ==> Parameters: 33097601(String)
2019-06-18 00:18:10,005 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 00:18:10,023 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,024 [http-nio-8080-exec-2] ==> Parameters: 22113901(String)
2019-06-18 00:18:10,045 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,063 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,064 [http-nio-8080-exec-2] ==> Parameters: 33096401(String)
2019-06-18 00:18:10,084 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,104 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,104 [http-nio-8080-exec-2] ==> Parameters: 33111001(String)
2019-06-18 00:18:10,124 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,143 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,143 [http-nio-8080-exec-2] ==> Parameters: 18888888(String)
2019-06-18 00:18:10,163 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,183 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,183 [http-nio-8080-exec-2] ==> Parameters: 33074881(String)
2019-06-18 00:18:10,205 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,223 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,223 [http-nio-8080-exec-2] ==> Parameters: 62549174(String)
2019-06-18 00:18:10,244 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,271 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,271 [http-nio-8080-exec-2] ==> Parameters: addsf(String)
2019-06-18 00:18:10,292 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,311 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,313 [http-nio-8080-exec-2] ==> Parameters: gzxxx(String)
2019-06-18 00:18:10,332 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,351 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,352 [http-nio-8080-exec-2] ==> Parameters: 22060081(String)
2019-06-18 00:18:10,372 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,391 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,392 [http-nio-8080-exec-2] ==> Parameters: 31120907(String)
2019-06-18 00:18:10,414 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,432 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,432 [http-nio-8080-exec-2] ==> Parameters: 33013701(String)
2019-06-18 00:18:10,452 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,472 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,473 [http-nio-8080-exec-2] ==> Parameters: 34140901(String)
2019-06-18 00:18:10,493 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,512 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:10,513 [http-nio-8080-exec-2] ==> Parameters: 33112911(String)
2019-06-18 00:18:10,536 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:18:10,555 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:18:10,556 [http-nio-8080-exec-2] ==> Parameters: 1560674924223303(String)
2019-06-18 00:18:10,565 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:18:10,587 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:18:10,588 [http-nio-8080-exec-2] ==> Parameters: 1560691023985310(String)
2019-06-18 00:18:10,602 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:18:10,623 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:18:10,625 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 00:18:10,637 [http-nio-8080-exec-2] <==      Total: 5
2019-06-18 00:18:10,700 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 00:18:10,700 [http-nio-8080-exec-7] ==> Parameters: 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String)
2019-06-18 00:18:10,706 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:18:10,723 [http-nio-8080-exec-7] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 00:18:10,725 [http-nio-8080-exec-7] ==> Parameters: 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 0(Integer), 10(Integer)
2019-06-18 00:18:10,734 [http-nio-8080-exec-7] <==      Total: 10
2019-06-18 00:18:11,028 [http-nio-8080-exec-10] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:18:11,029 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:18:11,037 [http-nio-8080-exec-10] <==      Total: 14
2019-06-18 00:18:11,058 [http-nio-8080-exec-10] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:18:11,060 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:18:11,070 [http-nio-8080-exec-10] <==      Total: 14
2019-06-18 00:18:11,099 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,100 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:18:11,107 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:18:11,131 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,132 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:18:11,139 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:18:11,167 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,168 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:18:11,175 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:18:11,196 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,196 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:18:11,203 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:18:11,224 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,224 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:18:11,232 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:18:11,252 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,252 [http-nio-8080-exec-4] ==> Parameters: 22113901(String)
2019-06-18 00:18:11,271 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,291 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,292 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:18:11,312 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,331 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,332 [http-nio-8080-exec-4] ==> Parameters: 33111001(String)
2019-06-18 00:18:11,351 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,371 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,372 [http-nio-8080-exec-4] ==> Parameters: 18888888(String)
2019-06-18 00:18:11,392 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,419 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,420 [http-nio-8080-exec-4] ==> Parameters: 33074881(String)
2019-06-18 00:18:11,440 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,459 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,460 [http-nio-8080-exec-4] ==> Parameters: 62549174(String)
2019-06-18 00:18:11,480 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,499 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,501 [http-nio-8080-exec-4] ==> Parameters: addsf(String)
2019-06-18 00:18:11,520 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,540 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,541 [http-nio-8080-exec-4] ==> Parameters: gzxxx(String)
2019-06-18 00:18:11,560 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,580 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,581 [http-nio-8080-exec-4] ==> Parameters: 22060081(String)
2019-06-18 00:18:11,600 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,620 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,621 [http-nio-8080-exec-4] ==> Parameters: 31120907(String)
2019-06-18 00:18:11,642 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,663 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,670 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 00:18:11,696 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,715 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,716 [http-nio-8080-exec-4] ==> Parameters: 34140901(String)
2019-06-18 00:18:11,736 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,755 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:11,757 [http-nio-8080-exec-4] ==> Parameters: 33112911(String)
2019-06-18 00:18:11,776 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:18:11,799 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:18:11,801 [http-nio-8080-exec-4] ==> Parameters: 1560674924223303(String)
2019-06-18 00:18:11,809 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:18:11,827 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:18:11,829 [http-nio-8080-exec-4] ==> Parameters: 1560691023985310(String)
2019-06-18 00:18:11,839 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:18:11,860 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:18:11,861 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:18:11,871 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:18:14,029 [http-nio-8080-exec-5] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:18:14,030 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:18:14,042 [http-nio-8080-exec-5] <==      Total: 5
2019-06-18 00:18:16,507 [http-nio-8080-exec-3] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:18:16,509 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:18:16,519 [http-nio-8080-exec-3] <==      Total: 5
2019-06-18 00:18:17,688 [http-nio-8080-exec-9] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:18:17,688 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:18:17,689 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 00:18:17,689 [http-nio-8080-exec-6] ==> Parameters: 1560674924223303(String)
2019-06-18 00:18:17,697 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:18:17,697 [http-nio-8080-exec-9] <==      Total: 5
2019-06-18 00:18:17,723 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:18:17,724 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:18:17,730 [http-nio-8080-exec-6] <==      Total: 5
2019-06-18 00:18:17,751 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:18:17,753 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:18:17,761 [http-nio-8080-exec-6] <==      Total: 5
2019-06-18 00:18:17,824 [http-nio-8080-exec-6] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:18:17,828 [http-nio-8080-exec-6] ==> Parameters: 156078829781836673(String), 3元卖品优惠券(String), 2019-06-16 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560674924223303(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:18:17.819(Timestamp), null
2019-06-18 00:18:17,847 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:18:17,848 [http-nio-8080-exec-6] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:18:17,849 [http-nio-8080-exec-6] ==> Parameters: 156078829784839513(String), 3元卖品优惠券(String), 2019-06-16 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560674924223303(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:18:17.848(Timestamp), null
2019-06-18 00:18:17,867 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:18:17,868 [http-nio-8080-exec-6] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:18:17,868 [http-nio-8080-exec-6] ==> Parameters: 156078829786874080(String), 3元卖品优惠券(String), 2019-06-16 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560674924223303(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:18:17.868(Timestamp), null
2019-06-18 00:18:17,890 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:18:17,892 [http-nio-8080-exec-6] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:18:17,895 [http-nio-8080-exec-6] ==> Parameters: 156078829789235392(String), 3元卖品优惠券(String), 2019-06-16 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560674924223303(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:18:17.892(Timestamp), null
2019-06-18 00:18:17,916 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:18:17,918 [http-nio-8080-exec-6] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:18:17,919 [http-nio-8080-exec-6] ==> Parameters: 156078829791757963(String), 3元卖品优惠券(String), 2019-06-16 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560674924223303(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:18:17.917(Timestamp), null
2019-06-18 00:18:17,944 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:18:17,960 [http-nio-8080-exec-6] ==>  Preparing: update couponsgroup t SET Id = ?, GroupCode = ?, CouponsType = ?, CouponsName = ?, ValidityType = ?, EffectiveDate = ?, ExpireDate = ?, CanUsePeriodType = ?, WeekDays = ?, TimePeriod = ?, LimitNum = ?, ReductionType = ?, InitialAmount = ?, ReductionPrice = ?, FilmCodes = ?, GoodsCodes = ?, IsShare = ?, Remark = ?, CanUseCinemaType = ?, CinemaCodes = ?, Status = ?, CouponsNumber = ?, IssuedNumber = ?, FetchNumber = ?, RemainingNumber = ?, UsedNumber = ?, GiftType = ?, UpdateDate = ? where t.id = ? 
2019-06-18 00:18:17,968 [http-nio-8080-exec-6] ==> Parameters: 57(Long), 1560674924223303(String), 1(Integer), 3元卖品优惠券(String), 1(Integer), 2019-06-16 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1(Integer), (String), (String), 1(Integer), 2(Integer), 20.0(Double), 3.0(Double), (String), (String), 0(Integer), (String), 2(Integer), 33097601(String), 1(Integer), 50(Integer), 10(Integer), 10(Integer), 40(Integer), 0(Integer), 2(String), 2019-06-18 00:18:17.945(Timestamp), 57(Long)
2019-06-18 00:18:17,987 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:18:18,055 [http-nio-8080-exec-6] ==>  Preparing: insert into coupondistributionrecord(Id, GroupCode, CustomerType, OpenID, Issuer, IssuedNumber, IssuedTime, Status) values(?, ?, ?, ?, ?, ?, now(), ?) 
2019-06-18 00:18:18,060 [http-nio-8080-exec-6] ==> Parameters: null, 1560674924223303(String), 1(Integer), (String), admin(String), 5(Integer), 1(Integer)
2019-06-18 00:18:18,079 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:18:19,511 [http-nio-8080-exec-10] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:18:19,513 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:18:19,521 [http-nio-8080-exec-10] <==      Total: 14
2019-06-18 00:18:19,562 [http-nio-8080-exec-10] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:18:19,562 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:18:19,569 [http-nio-8080-exec-10] <==      Total: 14
2019-06-18 00:18:19,579 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 00:18:19,580 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:18:19,585 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:18:19,585 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,586 [http-nio-8080-exec-7] ==> Parameters: 33097601(String)
2019-06-18 00:18:19,592 [http-nio-8080-exec-8] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 00:18:19,593 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 00:18:19,593 [http-nio-8080-exec-8] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:18:19,599 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,600 [http-nio-8080-exec-7] ==> Parameters: 33097601(String)
2019-06-18 00:18:19,600 [http-nio-8080-exec-8] <==      Total: 10
2019-06-18 00:18:19,607 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 00:18:19,619 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,620 [http-nio-8080-exec-7] ==> Parameters: 33097601(String)
2019-06-18 00:18:19,631 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 00:18:19,639 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,640 [http-nio-8080-exec-7] ==> Parameters: 33097601(String)
2019-06-18 00:18:19,648 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 00:18:19,667 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,668 [http-nio-8080-exec-7] ==> Parameters: 33097601(String)
2019-06-18 00:18:19,675 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 00:18:19,695 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,696 [http-nio-8080-exec-7] ==> Parameters: 22113901(String)
2019-06-18 00:18:19,717 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:19,736 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,738 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:18:19,760 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:19,784 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,785 [http-nio-8080-exec-7] ==> Parameters: 33111001(String)
2019-06-18 00:18:19,812 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:19,832 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,833 [http-nio-8080-exec-7] ==> Parameters: 18888888(String)
2019-06-18 00:18:19,857 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:19,888 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,889 [http-nio-8080-exec-7] ==> Parameters: 33074881(String)
2019-06-18 00:18:19,907 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:19,927 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,928 [http-nio-8080-exec-7] ==> Parameters: 62549174(String)
2019-06-18 00:18:19,950 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:19,971 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:19,974 [http-nio-8080-exec-7] ==> Parameters: addsf(String)
2019-06-18 00:18:20,004 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:20,010 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:20,010 [http-nio-8080-exec-7] ==> Parameters: gzxxx(String)
2019-06-18 00:18:20,024 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:20,040 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:20,041 [http-nio-8080-exec-7] ==> Parameters: 22060081(String)
2019-06-18 00:18:20,064 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:20,084 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:20,084 [http-nio-8080-exec-7] ==> Parameters: 31120907(String)
2019-06-18 00:18:20,104 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:20,123 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:20,125 [http-nio-8080-exec-7] ==> Parameters: 33013701(String)
2019-06-18 00:18:20,144 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:20,164 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:20,164 [http-nio-8080-exec-7] ==> Parameters: 34140901(String)
2019-06-18 00:18:20,184 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:20,204 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:18:20,205 [http-nio-8080-exec-7] ==> Parameters: 33112911(String)
2019-06-18 00:18:20,225 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:18:20,251 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:18:20,254 [http-nio-8080-exec-7] ==> Parameters: 1560674924223303(String)
2019-06-18 00:18:20,263 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:18:20,283 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:18:20,285 [http-nio-8080-exec-7] ==> Parameters: 1560691023985310(String)
2019-06-18 00:18:20,294 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:18:20,315 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:18:20,316 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:18:20,324 [http-nio-8080-exec-7] <==      Total: 5
2019-06-18 00:18:20,363 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 00:18:20,364 [http-nio-8080-exec-3] ==> Parameters: 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String)
2019-06-18 00:18:20,371 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:18:20,391 [http-nio-8080-exec-3] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 00:18:20,392 [http-nio-8080-exec-3] ==> Parameters: 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 1560674924223303,1560691023985310,1559373351460443,1559373469501562,1560340086642103,1560411273799632,1560434809995527(String), 0(Integer), 10(Integer)
2019-06-18 00:18:20,400 [http-nio-8080-exec-3] <==      Total: 10
2019-06-18 00:18:29,748 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo where IsDel='0' 
2019-06-18 00:18:29,748 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t WHERE t.Code in (select cinemaCode from sys_user) 
2019-06-18 00:18:29,749 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:18:29,750 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:18:29,756 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:18:29,781 [http-nio-8080-exec-3] <==      Total: 12
2019-06-18 00:18:29,803 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() 
2019-06-18 00:18:29,806 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:18:31,242 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:18:31,263 [http-nio-8080-exec-5] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() limit ?, ? 
2019-06-18 00:18:31,266 [http-nio-8080-exec-5] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:18:32,701 [http-nio-8080-exec-5] <==      Total: 10
2019-06-18 00:18:37,303 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:37,305 [http-nio-8080-exec-2] ==> Parameters: 33096401(String)
2019-06-18 00:18:38,528 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:38,529 [http-nio-8080-exec-9] ==> Parameters: 33096401(String)
2019-06-18 00:18:38,863 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:18:38,884 [http-nio-8080-exec-2] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:38,885 [http-nio-8080-exec-2] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:18:39,697 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:39,698 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:18:40,042 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:40,045 [http-nio-8080-exec-10] ==> Parameters: 33096401(String)
2019-06-18 00:18:40,248 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:40,251 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:18:40,428 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:40,432 [http-nio-8080-exec-8] ==> Parameters: 33096401(String)
2019-06-18 00:18:41,122 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:18:41,129 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:41,130 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:18:41,148 [http-nio-8080-exec-9] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:41,150 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:18:42,329 [http-nio-8080-exec-2] <==      Total: 10
2019-06-18 00:18:44,761 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:18:44,784 [http-nio-8080-exec-6] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:44,786 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:18:45,564 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:18:45,587 [http-nio-8080-exec-10] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:45,588 [http-nio-8080-exec-10] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:18:45,901 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:18:45,923 [http-nio-8080-exec-8] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:45,926 [http-nio-8080-exec-8] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:18:45,963 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:18:45,984 [http-nio-8080-exec-4] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:45,986 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:18:46,586 [http-nio-8080-exec-9] <==      Total: 10
2019-06-18 00:18:46,623 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:18:46,643 [http-nio-8080-exec-7] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:46,645 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:18:49,697 [http-nio-8080-exec-6] <==      Total: 10
2019-06-18 00:18:50,262 [http-nio-8080-exec-10] <==      Total: 10
2019-06-18 00:18:50,410 [http-nio-8080-exec-8] <==      Total: 10
2019-06-18 00:18:50,461 [http-nio-8080-exec-4] <==      Total: 10
2019-06-18 00:18:50,597 [http-nio-8080-exec-7] <==      Total: 10
2019-06-18 00:18:50,624 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:50,625 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:18:52,070 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:18:52,092 [http-nio-8080-exec-3] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:52,093 [http-nio-8080-exec-3] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:18:53,574 [http-nio-8080-exec-3] <==      Total: 10
2019-06-18 00:18:55,316 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:55,317 [http-nio-8080-exec-1] ==> Parameters: 33096401(String)
2019-06-18 00:18:56,744 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:18:56,764 [http-nio-8080-exec-1] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:18:56,765 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 10(Integer), 10(Integer)
2019-06-18 00:18:58,227 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 00:18:59,880 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:18:59,881 [http-nio-8080-exec-5] ==> Parameters: 33096401(String)
2019-06-18 00:19:01,351 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:19:01,372 [http-nio-8080-exec-5] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:19:01,374 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 20(Integer), 10(Integer)
2019-06-18 00:19:02,942 [http-nio-8080-exec-5] <==      Total: 10
2019-06-18 00:23:15,979 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo where IsDel='0' 
2019-06-18 00:23:15,979 [http-nio-8080-exec-7] ==>  Preparing: select * from cinema t WHERE t.Code in (select cinemaCode from sys_user) 
2019-06-18 00:23:15,983 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:23:15,984 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:23:15,992 [http-nio-8080-exec-7] <==      Total: 12
2019-06-18 00:23:16,030 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:23:16,093 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() 
2019-06-18 00:23:16,094 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:23:17,582 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:23:17,602 [http-nio-8080-exec-1] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() limit ?, ? 
2019-06-18 00:23:17,605 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:23:19,092 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 00:23:22,965 [http-nio-8080-exec-1] ==>  Preparing: select * from cinema t WHERE t.Code in (select cinemaCode from sys_user) 
2019-06-18 00:23:22,966 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:23:22,975 [http-nio-8080-exec-1] <==      Total: 12
2019-06-18 00:23:32,574 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:23:32,575 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:23:32,581 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:32,602 [http-nio-8080-exec-6] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:23:32,604 [http-nio-8080-exec-6] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:23:32,616 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,382 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:33,383 [http-nio-8080-exec-6] ==> Parameters: 051201522017(String)
2019-06-18 00:23:33,392 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,418 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:33,421 [http-nio-8080-exec-6] ==> Parameters: 051201522017(String), 蜘蛛侠：英雄归来（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:33,442 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:33,462 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:33,464 [http-nio-8080-exec-6] ==> Parameters: 001108542018(String)
2019-06-18 00:23:33,472 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,493 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:33,495 [http-nio-8080-exec-6] ==> Parameters: 001108542018(String), 午夜废墟(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:33,526 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:33,545 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:33,547 [http-nio-8080-exec-6] ==> Parameters: 074100452019(String)
2019-06-18 00:23:33,555 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,578 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:33,579 [http-nio-8080-exec-6] ==> Parameters: 074100452019(String), 波西米亚狂想曲（数字）(String), 2d(String), en(String), 0(Integer), null
2019-06-18 00:23:33,598 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:33,621 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:33,623 [http-nio-8080-exec-6] ==> Parameters: 051200662019(String)
2019-06-18 00:23:33,630 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,650 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:33,651 [http-nio-8080-exec-6] ==> Parameters: 051200662019(String), 神奇乐园历险记（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:33,670 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:33,690 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:33,691 [http-nio-8080-exec-6] ==> Parameters: 051200712019(String)
2019-06-18 00:23:33,703 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,724 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:33,725 [http-nio-8080-exec-6] ==> Parameters: 051200712019(String), 大侦探皮卡丘（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:33,746 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:33,766 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:33,767 [http-nio-8080-exec-6] ==> Parameters: 001107762018(String)
2019-06-18 00:23:33,777 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,797 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:33,799 [http-nio-8080-exec-6] ==> Parameters: 001107762018(String), 过昭关(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:33,817 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:33,845 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:33,847 [http-nio-8080-exec-6] ==> Parameters: 001109642018(String)
2019-06-18 00:23:33,855 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,877 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:33,879 [http-nio-8080-exec-6] ==> Parameters: 001109642018(String), 妈阁是座城(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:33,899 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:33,917 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:33,919 [http-nio-8080-exec-6] ==> Parameters: 012100762019(String)
2019-06-18 00:23:33,930 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:33,950 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:33,952 [http-nio-8080-exec-6] ==> Parameters: 012100762019(String), 龙珠超：布罗利（数字）(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:33,982 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,002 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,003 [http-nio-8080-exec-6] ==> Parameters: 001101582019(String)
2019-06-18 00:23:34,011 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,032 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,033 [http-nio-8080-exec-6] ==> Parameters: 001101582019(String), 周恩来回延安(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,054 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,074 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,075 [http-nio-8080-exec-6] ==> Parameters: 003200812019(String)
2019-06-18 00:23:34,082 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,102 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,104 [http-nio-8080-exec-6] ==> Parameters: 003200812019(String), 五月天人生无限公司（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,118 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,126 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,127 [http-nio-8080-exec-6] ==> Parameters: 051200852019(String)
2019-06-18 00:23:34,139 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,166 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,167 [http-nio-8080-exec-6] ==> Parameters: 051200852019(String), 哥斯拉2：怪兽之王（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,189 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,210 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,211 [http-nio-8080-exec-6] ==> Parameters: 001b02482019(String)
2019-06-18 00:23:34,232 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,254 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,255 [http-nio-8080-exec-6] ==> Parameters: 001b02482019(String), 巧虎大飞船历险记(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,278 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,298 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,300 [http-nio-8080-exec-6] ==> Parameters: 019100752019(String)
2019-06-18 00:23:34,325 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,339 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,340 [http-nio-8080-exec-6] ==> Parameters: 019100752019(String), 无所不能（数字）(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,364 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,386 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,387 [http-nio-8080-exec-6] ==> Parameters: 001102222018(String)
2019-06-18 00:23:34,394 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,414 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,415 [http-nio-8080-exec-6] ==> Parameters: 001102222018(String), 武陵山上的星光(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,442 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,462 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,463 [http-nio-8080-exec-6] ==> Parameters: 001105082018(String)
2019-06-18 00:23:34,476 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,499 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,500 [http-nio-8080-exec-6] ==> Parameters: 001105082018(String), 特别追踪(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,523 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,545 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,547 [http-nio-8080-exec-6] ==> Parameters: 001101222019(String)
2019-06-18 00:23:34,556 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,578 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,579 [http-nio-8080-exec-6] ==> Parameters: 001101222019(String), 昆仑兄弟(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,602 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,622 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,623 [http-nio-8080-exec-6] ==> Parameters: 051200902019(String)
2019-06-18 00:23:34,632 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,666 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,667 [http-nio-8080-exec-6] ==> Parameters: 051200902019(String), 阿拉丁（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,686 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,706 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,707 [http-nio-8080-exec-6] ==> Parameters: 001100072019(String)
2019-06-18 00:23:34,727 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,742 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,743 [http-nio-8080-exec-6] ==> Parameters: 001100072019(String), 最好的我们(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,767 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,786 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,786 [http-nio-8080-exec-6] ==> Parameters: 001c03082019(String)
2019-06-18 00:23:34,793 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,814 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,815 [http-nio-8080-exec-6] ==> Parameters: 001c03082019(String), 潜艇总动员：外星宝贝计划（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,834 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,854 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,855 [http-nio-8080-exec-6] ==> Parameters: 051200922019(String)
2019-06-18 00:23:34,864 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,886 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,888 [http-nio-8080-exec-6] ==> Parameters: 051200922019(String), X战警：黑凤凰（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,905 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,925 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,926 [http-nio-8080-exec-6] ==> Parameters: 001102962019(String)
2019-06-18 00:23:34,934 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:34,953 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:34,955 [http-nio-8080-exec-6] ==> Parameters: 001102962019(String), 追龙II(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:34,973 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:34,993 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:34,995 [http-nio-8080-exec-6] ==> Parameters: 012100952019(String)
2019-06-18 00:23:35,019 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,034 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,035 [http-nio-8080-exec-6] ==> Parameters: 012100952019(String), 哆啦A梦：大雄的月球探险记（数字）(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,054 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,073 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,074 [http-nio-8080-exec-6] ==> Parameters: 074100932019(String)
2019-06-18 00:23:35,082 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,102 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,103 [http-nio-8080-exec-6] ==> Parameters: 074100932019(String), 托马斯大电影之世界探险记（数字）(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,118 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,138 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,139 [http-nio-8080-exec-6] ==> Parameters: 001b03082019(String)
2019-06-18 00:23:35,159 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,182 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,184 [http-nio-8080-exec-6] ==> Parameters: 001b03082019(String), 潜艇总动员：外星宝贝计划(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,206 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,226 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,226 [http-nio-8080-exec-6] ==> Parameters: 001108012018(String)
2019-06-18 00:23:35,234 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,254 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,255 [http-nio-8080-exec-6] ==> Parameters: 001108012018(String), 噬魂剑(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,267 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,287 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,289 [http-nio-8080-exec-6] ==> Parameters: 001102062019(String)
2019-06-18 00:23:35,299 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,321 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,323 [http-nio-8080-exec-6] ==> Parameters: 001102062019(String), 当我们海阔天空(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,338 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,353 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,355 [http-nio-8080-exec-6] ==> Parameters: 001109582018(String)
2019-06-18 00:23:35,374 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,397 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,399 [http-nio-8080-exec-6] ==> Parameters: 001109582018(String), 秦明·生死语者(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,422 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,442 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,443 [http-nio-8080-exec-6] ==> Parameters: 091100652019(String)
2019-06-18 00:23:35,452 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,474 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,475 [http-nio-8080-exec-6] ==> Parameters: 091100652019(String), 绝杀慕尼黑（数字）(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,484 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,498 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,500 [http-nio-8080-exec-6] ==> Parameters: 075100962019(String)
2019-06-18 00:23:35,507 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,526 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,527 [http-nio-8080-exec-6] ==> Parameters: 075100962019(String), 卡拉斯：为爱而声（数字）(String), 2d(String), or(String), 0(Integer), null
2019-06-18 00:23:35,546 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,567 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,568 [http-nio-8080-exec-6] ==> Parameters: 001302962019(String)
2019-06-18 00:23:35,575 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,598 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,600 [http-nio-8080-exec-6] ==> Parameters: 001302962019(String), 追龙II（数字IMAX）(String), imax(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,614 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,634 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,636 [http-nio-8080-exec-6] ==> Parameters: 001103722017(String)
2019-06-18 00:23:35,644 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,669 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,671 [http-nio-8080-exec-6] ==> Parameters: 001103722017(String), 冠军的心(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,690 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,710 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,711 [http-nio-8080-exec-6] ==> Parameters: 012100992019(String)
2019-06-18 00:23:35,719 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,739 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,741 [http-nio-8080-exec-6] ==> Parameters: 012100992019(String), 千与千寻（数字）(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,761 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,781 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,783 [http-nio-8080-exec-6] ==> Parameters: 075100632019(String)
2019-06-18 00:23:35,793 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,814 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,816 [http-nio-8080-exec-6] ==> Parameters: 075100632019(String), 白牙（数字）(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,837 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,858 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,859 [http-nio-8080-exec-6] ==> Parameters: 051201002019(String)
2019-06-18 00:23:35,867 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,886 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,887 [http-nio-8080-exec-6] ==> Parameters: 051201002019(String), 黑衣人：全球追缉（数字3D）(String), 3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:35,906 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:35,926 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:35,927 [http-nio-8080-exec-6] ==> Parameters: 051200982019(String)
2019-06-18 00:23:35,935 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:35,963 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:35,964 [http-nio-8080-exec-6] ==> Parameters: 051200982019(String), 玩具总动员4（数字3D）(String), 3d(String), or(String), 0(Integer), null
2019-06-18 00:23:35,986 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,006 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,007 [http-nio-8080-exec-6] ==> Parameters: 051401002019(String)
2019-06-18 00:23:36,016 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,037 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,039 [http-nio-8080-exec-6] ==> Parameters: 051401002019(String), 黑衣人：全球追缉（数字IMAX3D）(String), imax3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,057 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,081 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,082 [http-nio-8080-exec-6] ==> Parameters: 001107502018(String)
2019-06-18 00:23:36,089 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,109 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,111 [http-nio-8080-exec-6] ==> Parameters: 001107502018(String), 要活着去天堂(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,117 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,129 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,130 [http-nio-8080-exec-6] ==> Parameters: 001100752018(String)
2019-06-18 00:23:36,138 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,158 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,159 [http-nio-8080-exec-6] ==> Parameters: 001100752018(String), 侣行攻略之确认你是我的人(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,181 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,202 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,203 [http-nio-8080-exec-6] ==> Parameters: 001101112019(String)
2019-06-18 00:23:36,210 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,234 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,235 [http-nio-8080-exec-6] ==> Parameters: 001101112019(String), 废柴老爸(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,254 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,274 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,276 [http-nio-8080-exec-6] ==> Parameters: 001103562016(String)
2019-06-18 00:23:36,290 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,310 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,312 [http-nio-8080-exec-6] ==> Parameters: 001103562016(String), 碟仙(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,334 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,354 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,355 [http-nio-8080-exec-6] ==> Parameters: 001106772018(String)
2019-06-18 00:23:36,363 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,383 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,383 [http-nio-8080-exec-6] ==> Parameters: 001106772018(String), 六月夏初(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,399 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,414 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,415 [http-nio-8080-exec-6] ==> Parameters: 001103242019(String)
2019-06-18 00:23:36,421 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,441 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,443 [http-nio-8080-exec-6] ==> Parameters: 001103242019(String), 八子(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,464 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,481 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,483 [http-nio-8080-exec-6] ==> Parameters: 051200972019(String)
2019-06-18 00:23:36,496 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,517 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,520 [http-nio-8080-exec-6] ==> Parameters: 051200972019(String), 爱宠大机密2（数字3D）(String), 3d(String), or(String), 0(Integer), null
2019-06-18 00:23:36,538 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,559 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,561 [http-nio-8080-exec-6] ==> Parameters: 001107832017(String)
2019-06-18 00:23:36,568 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,586 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,588 [http-nio-8080-exec-6] ==> Parameters: 001107832017(String), 我的青春都是你(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,614 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,634 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,635 [http-nio-8080-exec-6] ==> Parameters: 001l00942019(String)
2019-06-18 00:23:36,643 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,662 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,663 [http-nio-8080-exec-6] ==> Parameters: 001l00942019(String), 大河唱(String), 2d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,682 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,702 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,703 [http-nio-8080-exec-6] ==> Parameters: 051901002019(String)
2019-06-18 00:23:36,711 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,730 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,732 [http-nio-8080-exec-6] ==> Parameters: 051901002019(String), 黑衣人：全球追缉（中国巨幕立体）(String), dmax3d(String), cn(String), 0(Integer), null
2019-06-18 00:23:36,755 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,774 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,774 [http-nio-8080-exec-6] ==> Parameters: 051100472019(String)
2019-06-18 00:23:36,782 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,801 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,803 [http-nio-8080-exec-6] ==> Parameters: 051100472019(String), 真相漩涡（数字）(String), 2d(String), en(String), 0(Integer), null
2019-06-18 00:23:36,813 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,825 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,827 [http-nio-8080-exec-6] ==> Parameters: 051201082019(String)
2019-06-18 00:23:36,836 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,858 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,860 [http-nio-8080-exec-6] ==> Parameters: 051201082019(String), 蜘蛛侠：英雄远征（数字3D）(String), 3d(String), or(String), 0(Integer), null
2019-06-18 00:23:36,883 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:36,902 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:23:36,902 [http-nio-8080-exec-6] ==> Parameters: 075101102019(String)
2019-06-18 00:23:36,910 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:36,931 [http-nio-8080-exec-6] ==>  Preparing: update filminfo t SET FilmCode = ?, FilmName = ?, Version = ?, Language = ?, Status = ? where t.Id = ? 
2019-06-18 00:23:36,933 [http-nio-8080-exec-6] ==> Parameters: 075101102019(String), 监护风云（数字）(String), 2d(String), fr(String), 0(Integer), null
2019-06-18 00:23:36,950 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:37,143 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,145 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1068(String)
2019-06-18 00:23:37,153 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,174 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,175 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1072(String)
2019-06-18 00:23:37,181 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,205 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,206 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1069(String)
2019-06-18 00:23:37,214 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,234 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,235 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1071(String)
2019-06-18 00:23:37,244 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,265 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,267 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1070(String)
2019-06-18 00:23:37,275 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,298 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,299 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1068(String)
2019-06-18 00:23:37,308 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,325 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,327 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1069(String)
2019-06-18 00:23:37,334 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,352 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,353 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1072(String)
2019-06-18 00:23:37,361 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,378 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,379 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1071(String)
2019-06-18 00:23:37,386 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,404 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,405 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1070(String)
2019-06-18 00:23:37,415 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,429 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,430 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1068(String)
2019-06-18 00:23:37,437 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,456 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,457 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1069(String)
2019-06-18 00:23:37,465 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,483 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,483 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1072(String)
2019-06-18 00:23:37,501 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,521 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,521 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1071(String)
2019-06-18 00:23:37,529 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,549 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,551 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1070(String)
2019-06-18 00:23:37,559 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,581 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,583 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1068(String)
2019-06-18 00:23:37,597 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,611 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,613 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1072(String)
2019-06-18 00:23:37,623 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,634 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,634 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1069(String)
2019-06-18 00:23:37,641 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,659 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,660 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1071(String)
2019-06-18 00:23:37,667 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,682 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,682 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1070(String)
2019-06-18 00:23:37,696 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,719 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,720 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1068(String)
2019-06-18 00:23:37,727 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,739 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,740 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1069(String)
2019-06-18 00:23:37,747 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,765 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,766 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1072(String)
2019-06-18 00:23:37,773 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,790 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,791 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1071(String)
2019-06-18 00:23:37,801 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,815 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,816 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1070(String)
2019-06-18 00:23:37,827 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,842 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,845 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1068(String)
2019-06-18 00:23:37,852 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,868 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,869 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1069(String)
2019-06-18 00:23:37,877 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,892 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,893 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1072(String)
2019-06-18 00:23:37,899 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,918 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,918 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1071(String)
2019-06-18 00:23:37,925 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,944 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-06-18 00:23:37,945 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 1070(String)
2019-06-18 00:23:37,951 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:23:37,970 [http-nio-8080-exec-6] ==>  Preparing: delete from sessioninfo WHERE CCode = ? and UserId = ? and StartTime >= ? and ? >= StartTime 
2019-06-18 00:23:37,975 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 12(Long), 2019-06-18(String), 2019-06-21(String)
2019-06-18 00:23:38,014 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:23:38,026 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,031 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384428(String), 0000000000000001(String), 2019-06-18 10:00:00.0(Timestamp), 001109642018(String), 妈阁是座城(2D)(String), 127(Integer), cn(String), 2019-06-18 00:23:37.156(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,047 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,058 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,060 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384429(String), 0000000000000005(String), 2019-06-18 10:30:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.182(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,072 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,086 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,089 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384430(String), 0000000000000002(String), 2019-06-18 10:40:00.0(Timestamp), 001109582018(String), 秦明·生死语者(2D)(String), 104(Integer), cn(String), 2019-06-18 00:23:37.216(Timestamp), 35.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,118 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,138 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,140 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384431(String), 0000000000000004(String), 2019-06-18 11:50:00.0(Timestamp), 001100072019(String), 最好的我们(2D)(String), 110(Integer), cn(String), 2019-06-18 00:23:37.247(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,166 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,175 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,177 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384432(String), 0000000000000003(String), 2019-06-18 12:00:00.0(Timestamp), 051200922019(String), X战警：黑凤凰（数字3D）(3D)(String), 114(Integer), en(String), 2019-06-18 00:23:37.277(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,200 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,222 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,224 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384433(String), 0000000000000001(String), 2019-06-18 12:20:00.0(Timestamp), 051200852019(String), 哥斯拉2：怪兽之王（数字3D）(3D)(String), 132(Integer), or(String), 2019-06-18 00:23:37.31(Timestamp), 35.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,252 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,268 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,271 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384434(String), 0000000000000002(String), 2019-06-18 13:00:00.0(Timestamp), 001109582018(String), 秦明·生死语者(2D)(String), 104(Integer), cn(String), 2019-06-18 00:23:37.336(Timestamp), 35.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,294 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,313 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,315 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384435(String), 0000000000000005(String), 2019-06-18 13:10:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.363(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,342 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,357 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,360 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384436(String), 0000000000000004(String), 2019-06-18 13:50:00.0(Timestamp), 001100072019(String), 最好的我们(2D)(String), 110(Integer), cn(String), 2019-06-18 00:23:37.387(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,374 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,394 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,397 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384437(String), 0000000000000003(String), 2019-06-18 14:05:00.0(Timestamp), 051200922019(String), X战警：黑凤凰（数字3D）(3D)(String), 114(Integer), en(String), 2019-06-18 00:23:37.416(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,426 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,446 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,448 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384438(String), 0000000000000001(String), 2019-06-18 14:40:00.0(Timestamp), 001102962019(String), 追龙II(2D)(String), 103(Integer), cn(String), 2019-06-18 00:23:37.438(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,478 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,498 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,500 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384439(String), 0000000000000002(String), 2019-06-18 15:00:00.0(Timestamp), 051200852019(String), 哥斯拉2：怪兽之王（数字3D）(3D)(String), 132(Integer), or(String), 2019-06-18 00:23:37.467(Timestamp), 35.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,526 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,546 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,548 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384440(String), 0000000000000005(String), 2019-06-18 15:15:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.502(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,570 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,590 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,592 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384441(String), 0000000000000004(String), 2019-06-18 15:50:00.0(Timestamp), 001100072019(String), 最好的我们(2D)(String), 110(Integer), cn(String), 2019-06-18 00:23:37.529(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,622 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,645 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,647 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384442(String), 0000000000000003(String), 2019-06-18 16:10:00.0(Timestamp), 051200922019(String), X战警：黑凤凰（数字3D）(3D)(String), 114(Integer), en(String), 2019-06-18 00:23:37.561(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,673 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,693 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,696 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384443(String), 0000000000000001(String), 2019-06-18 16:35:00.0(Timestamp), 001102962019(String), 追龙II(2D)(String), 103(Integer), cn(String), 2019-06-18 00:23:37.599(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,721 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,741 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,743 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384444(String), 0000000000000005(String), 2019-06-18 17:20:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.624(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,769 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,789 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,791 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384445(String), 0000000000000002(String), 2019-06-18 17:25:00.0(Timestamp), 001109582018(String), 秦明·生死语者(2D)(String), 104(Integer), cn(String), 2019-06-18 00:23:37.643(Timestamp), 35.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,814 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,846 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,847 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384446(String), 0000000000000004(String), 2019-06-18 17:50:00.0(Timestamp), 001100072019(String), 最好的我们(2D)(String), 110(Integer), cn(String), 2019-06-18 00:23:37.667(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,874 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,894 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,895 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384447(String), 0000000000000003(String), 2019-06-18 18:15:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.697(Timestamp), 38.0(Double), 25.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,926 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,946 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,948 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384448(String), 0000000000000001(String), 2019-06-18 18:30:00.0(Timestamp), 001102962019(String), 追龙II(2D)(String), 103(Integer), cn(String), 2019-06-18 00:23:37.728(Timestamp), 38.0(Double), 25.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:38,974 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:38,994 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:38,996 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384449(String), 0000000000000002(String), 2019-06-18 19:20:00.0(Timestamp), 001109582018(String), 秦明·生死语者(2D)(String), 104(Integer), cn(String), 2019-06-18 00:23:37.749(Timestamp), 38.0(Double), 20.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,018 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,043 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:39,045 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384450(String), 0000000000000005(String), 2019-06-18 19:25:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.775(Timestamp), 38.0(Double), 25.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,073 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,093 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:39,095 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384451(String), 0000000000000004(String), 2019-06-18 19:50:00.0(Timestamp), 001100072019(String), 最好的我们(2D)(String), 110(Integer), cn(String), 2019-06-18 00:23:37.803(Timestamp), 38.0(Double), 25.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,121 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,141 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:39,143 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384452(String), 0000000000000003(String), 2019-06-18 20:20:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.83(Timestamp), 38.0(Double), 25.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,182 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,202 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:39,202 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384453(String), 0000000000000001(String), 2019-06-18 20:30:00.0(Timestamp), 051200852019(String), 哥斯拉2：怪兽之王（数字3D）(3D)(String), 132(Integer), or(String), 2019-06-18 00:23:37.854(Timestamp), 38.0(Double), 20.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,230 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,258 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:39,260 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384454(String), 0000000000000002(String), 2019-06-18 21:15:00.0(Timestamp), 001109582018(String), 秦明·生死语者(2D)(String), 104(Integer), cn(String), 2019-06-18 00:23:37.878(Timestamp), 38.0(Double), 20.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,282 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,302 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:39,304 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384455(String), 0000000000000005(String), 2019-06-18 21:30:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.899(Timestamp), 38.0(Double), 25.0(Double), 38.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,330 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,357 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:39,359 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384456(String), 0000000000000004(String), 2019-06-18 21:50:00.0(Timestamp), 001100072019(String), 最好的我们(2D)(String), 110(Integer), cn(String), 2019-06-18 00:23:37.926(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,386 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,405 [http-nio-8080-exec-6] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:23:39,407 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 3384457(String), 0000000000000003(String), 2019-06-18 22:25:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 115(Integer), en(String), 2019-06-18 00:23:37.952(Timestamp), 35.0(Double), 25.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-06-18 00:23:39,437 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:23:39,460 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.userid=? and t.ccode = ? and t.starttime>=? and t.starttime<=? 
2019-06-18 00:23:39,464 [http-nio-8080-exec-6] ==> Parameters: 12(Long), 33096401(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-20 00:00:00.0(Timestamp)
2019-06-18 00:23:39,499 [http-nio-8080-exec-6] <==      Total: 30
2019-06-18 00:23:40,910 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t WHERE t.Code in (select cinemaCode from sys_user) 
2019-06-18 00:23:40,910 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo where IsDel='0' 
2019-06-18 00:23:40,912 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:23:40,912 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:23:40,919 [http-nio-8080-exec-6] <==      Total: 12
2019-06-18 00:23:40,946 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() 
2019-06-18 00:23:40,947 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:23:40,948 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:23:42,382 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:23:42,401 [http-nio-8080-exec-7] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() limit ?, ? 
2019-06-18 00:23:42,403 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:23:43,851 [http-nio-8080-exec-7] <==      Total: 10
2019-06-18 00:23:45,473 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from (SELECT * FROM sessioninfoview ) t WHERE StartTime >= now() and CinemaCode = ? 
2019-06-18 00:23:45,474 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:23:46,985 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:23:47,005 [http-nio-8080-exec-3] ==>  Preparing: SELECT * FROM (SELECT * FROM sessioninfoview )t WHERE StartTime >= now() and CinemaCode = ? limit ?, ? 
2019-06-18 00:23:47,007 [http-nio-8080-exec-3] ==> Parameters: 33096401(String), 0(Integer), 10(Integer)
2019-06-18 00:23:48,471 [http-nio-8080-exec-3] <==      Total: 10
2019-06-18 00:25:54,060 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:25:54,061 [http-nio-8080-exec-7] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:25:54,069 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:25:54,086 [http-nio-8080-exec-7] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:25:54,087 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:25:54,095 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:25:54,114 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:25:54,116 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 2019-06-18 00:25:54(String)
2019-06-18 00:25:54,149 [http-nio-8080-exec-7] <==      Total: 7
2019-06-18 00:25:54,170 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:25:54,171 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:25:54,177 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:25:54,194 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:25:54,195 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:25:54,201 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:26:45,041 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:26:45,174 [http-nio-8080-exec-1] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:26:45,200 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,222 [http-nio-8080-exec-1] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:26:45,224 [http-nio-8080-exec-1] ==> Parameters: 33096401(String)
2019-06-18 00:26:45,234 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,251 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:26:45,252 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 2019-06-18 00:26:45(String)
2019-06-18 00:26:45,279 [http-nio-8080-exec-1] <==      Total: 7
2019-06-18 00:26:45,299 [http-nio-8080-exec-1] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:26:45,300 [http-nio-8080-exec-1] ==> Parameters: 33096401(String)
2019-06-18 00:26:45,316 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,335 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:26:45,336 [http-nio-8080-exec-1] ==> Parameters: 001100072019(String)
2019-06-18 00:26:45,357 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,375 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:26:45,378 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:26:45(String)
2019-06-18 00:26:45,406 [http-nio-8080-exec-1] <==      Total: 6
2019-06-18 00:26:45,427 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,428 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:26:45,437 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,455 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,456 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:26:45,462 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,483 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,484 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:26:45,490 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,507 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,508 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:26:45,513 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,540 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,540 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:26:45,547 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,570 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,579 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:26:45,587 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,607 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:26:45,607 [http-nio-8080-exec-1] ==> Parameters: 001102962019(String)
2019-06-18 00:26:45,614 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,639 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:26:45,639 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:26:45(String)
2019-06-18 00:26:45,668 [http-nio-8080-exec-1] <==      Total: 3
2019-06-18 00:26:45,687 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,688 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:26:45,694 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,715 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,716 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:26:45,727 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,747 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,747 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:26:45,753 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,775 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:26:45,775 [http-nio-8080-exec-1] ==> Parameters: 001109582018(String)
2019-06-18 00:26:45,797 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,815 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:26:45,815 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:26:45(String)
2019-06-18 00:26:45,861 [http-nio-8080-exec-1] <==      Total: 5
2019-06-18 00:26:45,885 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,885 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:26:45,893 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,915 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,916 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:26:45,932 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,955 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,957 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:26:45,965 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:45,987 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:45,988 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:26:46,004 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,023 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,024 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:26:46,035 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,055 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:26:46,057 [http-nio-8080-exec-1] ==> Parameters: 001109642018(String)
2019-06-18 00:26:46,067 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,087 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:26:46,088 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:26:45(String)
2019-06-18 00:26:46,117 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,135 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,136 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:26:46,143 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,163 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:26:46,164 [http-nio-8080-exec-1] ==> Parameters: 051200852019(String)
2019-06-18 00:26:46,171 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,191 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:26:46,192 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:26:45(String)
2019-06-18 00:26:46,216 [http-nio-8080-exec-1] <==      Total: 3
2019-06-18 00:26:46,237 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,238 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:26:46,245 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,263 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,263 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:26:46,269 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,286 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,287 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:26:46,293 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,312 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:26:46,313 [http-nio-8080-exec-1] ==> Parameters: 051200922019(String)
2019-06-18 00:26:46,330 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,356 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:26:46,356 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:26:45(String)
2019-06-18 00:26:46,379 [http-nio-8080-exec-1] <==      Total: 3
2019-06-18 00:26:46,399 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,399 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:26:46,405 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,427 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,428 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:26:46,442 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,463 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,464 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:26:46,470 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,491 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:26:46,492 [http-nio-8080-exec-1] ==> Parameters: 051201002019(String)
2019-06-18 00:26:46,500 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,519 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:26:46,519 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:26:45(String)
2019-06-18 00:26:46,548 [http-nio-8080-exec-1] <==      Total: 9
2019-06-18 00:26:46,567 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,568 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:26:46,575 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,595 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,596 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:26:46,603 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,623 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,625 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:26:46,632 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,650 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,652 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:26:46,659 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,679 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,679 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:26:46,686 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,707 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,708 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:26:46,715 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,735 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,735 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:26:46,742 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,767 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,767 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:26:46,775 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:26:46,795 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:26:46,796 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:26:46,803 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,382 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:27:30,525 [http-nio-8080-exec-1] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:27:30,549 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,573 [http-nio-8080-exec-1] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:30,575 [http-nio-8080-exec-1] ==> Parameters: 33096401(String)
2019-06-18 00:27:30,584 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,603 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:27:30,605 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 2019-06-18 00:27:30(String)
2019-06-18 00:27:30,648 [http-nio-8080-exec-1] <==      Total: 7
2019-06-18 00:27:30,676 [http-nio-8080-exec-1] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:30,678 [http-nio-8080-exec-1] ==> Parameters: 33096401(String)
2019-06-18 00:27:30,684 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,702 [http-nio-8080-exec-1] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:27:30,707 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:27:30,714 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:27:30,731 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:27:30,733 [http-nio-8080-exec-1] ==> Parameters: 001100072019(String)
2019-06-18 00:27:30,755 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,781 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:27:30,783 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:27:30(String)
2019-06-18 00:27:30,808 [http-nio-8080-exec-1] <==      Total: 6
2019-06-18 00:27:30,835 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:30,836 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:27:30,846 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,867 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:30,868 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:27:30,875 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,899 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:30,900 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:27:30,906 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,927 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:30,928 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:27:30,934 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,955 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:30,956 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:27:30,962 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:30,986 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:30,987 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:27:30,993 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,012 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:27:31,012 [http-nio-8080-exec-1] ==> Parameters: 001102962019(String)
2019-06-18 00:27:31,019 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,039 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:27:31,040 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:27:30(String)
2019-06-18 00:27:31,069 [http-nio-8080-exec-1] <==      Total: 3
2019-06-18 00:27:31,088 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,089 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:27:31,096 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,120 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,120 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:27:31,125 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,143 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,143 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:27:31,149 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,167 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:27:31,168 [http-nio-8080-exec-1] ==> Parameters: 001109582018(String)
2019-06-18 00:27:31,189 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,211 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:27:31,212 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:27:30(String)
2019-06-18 00:27:31,238 [http-nio-8080-exec-1] <==      Total: 5
2019-06-18 00:27:31,261 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,262 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:27:31,268 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,293 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,295 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:27:31,309 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,332 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,334 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:27:31,341 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,364 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,366 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:27:31,378 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,400 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,401 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:27:31,412 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,431 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:27:31,434 [http-nio-8080-exec-1] ==> Parameters: 001109642018(String)
2019-06-18 00:27:31,443 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,463 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:27:31,463 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:27:30(String)
2019-06-18 00:27:31,487 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,507 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,507 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:27:31,516 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,535 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:27:31,537 [http-nio-8080-exec-1] ==> Parameters: 051200852019(String)
2019-06-18 00:27:31,547 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,568 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:27:31,569 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:27:30(String)
2019-06-18 00:27:31,602 [http-nio-8080-exec-1] <==      Total: 3
2019-06-18 00:27:31,623 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,625 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:27:31,635 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,655 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,657 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:27:31,666 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,687 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,688 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:27:31,705 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,720 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:27:31,720 [http-nio-8080-exec-1] ==> Parameters: 051200922019(String)
2019-06-18 00:27:31,756 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,776 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:27:31,777 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:27:30(String)
2019-06-18 00:27:31,808 [http-nio-8080-exec-1] <==      Total: 3
2019-06-18 00:27:31,843 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,843 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:27:31,849 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,873 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,874 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:27:31,882 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,908 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:31,909 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:27:31,918 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,938 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:27:31,938 [http-nio-8080-exec-1] ==> Parameters: 051201002019(String)
2019-06-18 00:27:31,946 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:31,963 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:27:31,965 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:27:30(String)
2019-06-18 00:27:31,994 [http-nio-8080-exec-1] <==      Total: 9
2019-06-18 00:27:32,015 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,016 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:27:32,021 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:32,039 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,040 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:27:32,046 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:32,059 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,060 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:27:32,066 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:32,084 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,084 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:27:32,091 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:32,100 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,101 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:27:32,118 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:32,139 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,140 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:27:32,149 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:32,171 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,172 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:27:32,177 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:32,198 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,199 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:27:32,205 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:32,223 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:27:32,223 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:27:32,230 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:27:57,899 [http-nio-8080-exec-2] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:27:57,900 [http-nio-8080-exec-2] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:27:57,907 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:57,928 [http-nio-8080-exec-2] ==>  Preparing: select * from CinemaMiniProgramAccounts where AppId=? and IsDel=0 
2019-06-18 00:27:57,930 [http-nio-8080-exec-2] ==> Parameters: wx8079e2f2a9958d05(String)
2019-06-18 00:27:57,941 [http-nio-8080-exec-2] <==      Total: 8
2019-06-18 00:27:57,962 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:57,962 [http-nio-8080-exec-2] ==> Parameters: 33111001(String)
2019-06-18 00:27:57,970 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:57,988 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:57,989 [http-nio-8080-exec-2] ==> Parameters: 33111001(String)
2019-06-18 00:27:57,998 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,019 [http-nio-8080-exec-2] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:27:58,021 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 5(String), 1(String)
2019-06-18 00:27:58,029 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,047 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:27:58,050 [http-nio-8080-exec-2] ==> Parameters: 1560578073jzkeu(String)
2019-06-18 00:27:58,058 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,079 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:27:58,080 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33111001(String)
2019-06-18 00:27:58,086 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,107 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:58,108 [http-nio-8080-exec-2] ==> Parameters: 33096401(String)
2019-06-18 00:27:58,116 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,138 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:58,139 [http-nio-8080-exec-2] ==> Parameters: 33096401(String)
2019-06-18 00:27:58,146 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,167 [http-nio-8080-exec-2] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:27:58,169 [http-nio-8080-exec-2] ==> Parameters: 33096401(String), 2(String), 1(String)
2019-06-18 00:27:58,180 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:27:58,199 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:27:58,201 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:27:58,209 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,232 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:58,232 [http-nio-8080-exec-2] ==> Parameters: 18888888(String)
2019-06-18 00:27:58,240 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,260 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:58,261 [http-nio-8080-exec-2] ==> Parameters: 18888888(String)
2019-06-18 00:27:58,268 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:27:58,284 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:27:58,285 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 18888888(String)
2019-06-18 00:27:58,305 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,327 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:58,329 [http-nio-8080-exec-2] ==> Parameters: 33074881(String)
2019-06-18 00:27:58,338 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,360 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:58,361 [http-nio-8080-exec-2] ==> Parameters: 33074881(String)
2019-06-18 00:27:58,367 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:27:58,387 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:27:58,388 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33074881(String)
2019-06-18 00:27:58,395 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,415 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:58,416 [http-nio-8080-exec-2] ==> Parameters: 22060081(String)
2019-06-18 00:27:58,430 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,451 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:58,452 [http-nio-8080-exec-2] ==> Parameters: 22060081(String)
2019-06-18 00:27:58,458 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:27:58,479 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:27:58,480 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 22060081(String)
2019-06-18 00:27:58,488 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,507 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:58,509 [http-nio-8080-exec-2] ==> Parameters: 33013701(String)
2019-06-18 00:27:58,520 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,539 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:58,540 [http-nio-8080-exec-2] ==> Parameters: 33013701(String)
2019-06-18 00:27:58,547 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:27:58,567 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:27:58,568 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33013701(String)
2019-06-18 00:27:58,575 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,595 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:58,597 [http-nio-8080-exec-2] ==> Parameters: 31120907(String)
2019-06-18 00:27:58,606 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,629 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:58,630 [http-nio-8080-exec-2] ==> Parameters: 31120907(String)
2019-06-18 00:27:58,640 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:27:58,659 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:27:58,660 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 31120907(String)
2019-06-18 00:27:58,667 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,692 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:58,693 [http-nio-8080-exec-2] ==> Parameters: 34140901(String)
2019-06-18 00:27:58,701 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,720 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:58,721 [http-nio-8080-exec-2] ==> Parameters: 34140901(String)
2019-06-18 00:27:58,729 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:58,751 [http-nio-8080-exec-2] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:27:58,753 [http-nio-8080-exec-2] ==> Parameters: 34140901(String), 5(String), 1(String)
2019-06-18 00:27:58,760 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:27:58,791 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:27:58,794 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 34140901(String)
2019-06-18 00:27:58,802 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:27:59,896 [http-nio-8080-exec-3] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:27:59,897 [http-nio-8080-exec-3] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:27:59,904 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:27:59,911 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:59,912 [http-nio-8080-exec-3] ==> Parameters: 33013701(String)
2019-06-18 00:27:59,919 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:27:59,944 [http-nio-8080-exec-3] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:27:59,944 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:27:59,944 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:27:59,945 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:27:59,945 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:27:59,945 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 2019-06-18 00:27:59(String)
2019-06-18 00:27:59,951 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:27:59,956 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:27:59,965 [http-nio-8080-exec-4] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:59,965 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 00:27:59,966 [http-nio-8080-exec-5] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:27:59,967 [http-nio-8080-exec-5] ==> Parameters: 33013701(String)
2019-06-18 00:27:59,968 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:27:59,973 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:27:59,974 [http-nio-8080-exec-3] ==> Parameters: 33013701(String)
2019-06-18 00:27:59,974 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:27:59,974 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:27:59,980 [http-nio-8080-exec-4] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:27:59,980 [http-nio-8080-exec-5] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:27:59,981 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:27:59,982 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:27:59,982 [http-nio-8080-exec-5] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:27:59,988 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:27:59,988 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:27:59,995 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:27:59,995 [http-nio-8080-exec-3] ==> Parameters: 001107832017(String)
2019-06-18 00:28:00,003 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:00,011 [http-nio-8080-exec-3] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:00,012 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 001107832017(String), 2019-06-18 00:27:59(String)
2019-06-18 00:28:00,037 [http-nio-8080-exec-3] <==      Total: 5
2019-06-18 00:28:00,055 [http-nio-8080-exec-3] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:00,056 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:28:00,061 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:00,083 [http-nio-8080-exec-3] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:00,084 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:28:00,089 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:00,112 [http-nio-8080-exec-3] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:00,112 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:28:00,118 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:00,155 [http-nio-8080-exec-3] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:00,156 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:28:00,162 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:00,188 [http-nio-8080-exec-3] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:00,189 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:28:00,195 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:00,218 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:28:00,219 [http-nio-8080-exec-3] ==> Parameters: 012100992019(String)
2019-06-18 00:28:00,225 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:00,247 [http-nio-8080-exec-3] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:00,247 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 012100992019(String), 2019-06-18 00:27:59(String)
2019-06-18 00:28:00,273 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:28:00,291 [http-nio-8080-exec-3] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:00,291 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:28:00,297 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:00,315 [http-nio-8080-exec-3] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:00,315 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:28:00,321 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:28:06,335 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:28:06,335 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:28:06,337 [http-nio-8080-exec-7] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:28:06,337 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:28:06,344 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:28:06,348 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,356 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:28:06,356 [http-nio-8080-exec-7] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:28:06,356 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:28:06,356 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:28:06,362 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:28:06,362 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,384 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:28:06,384 [http-nio-8080-exec-7] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:28:06,384 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 2019-06-18 00:28:06(String)
2019-06-18 00:28:06,384 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:28:06,398 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:28:06,410 [http-nio-8080-exec-6] <==      Total: 7
2019-06-18 00:28:06,431 [http-nio-8080-exec-6] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:28:06,432 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:28:06,439 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,460 [http-nio-8080-exec-6] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:28:06,462 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:28:06,468 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:28:06,487 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:28:06,488 [http-nio-8080-exec-6] ==> Parameters: 001100072019(String)
2019-06-18 00:28:06,508 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,536 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:06,536 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:28:06(String)
2019-06-18 00:28:06,565 [http-nio-8080-exec-6] <==      Total: 6
2019-06-18 00:28:06,584 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,585 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:28:06,591 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,611 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,612 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:28:06,622 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,643 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,644 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:28:06,651 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,671 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,672 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:28:06,679 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,701 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,703 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:28:06,712 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,731 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,733 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:28:06,741 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,763 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:28:06,765 [http-nio-8080-exec-6] ==> Parameters: 001102962019(String)
2019-06-18 00:28:06,772 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,791 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:06,792 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:28:06(String)
2019-06-18 00:28:06,818 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:28:06,840 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,841 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:28:06,848 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,872 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,872 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:28:06,879 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,904 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:06,905 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:28:06,911 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,932 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:28:06,933 [http-nio-8080-exec-6] ==> Parameters: 001109582018(String)
2019-06-18 00:28:06,953 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:06,972 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:06,973 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:28:06(String)
2019-06-18 00:28:06,999 [http-nio-8080-exec-6] <==      Total: 5
2019-06-18 00:28:07,021 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,021 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:28:07,032 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,051 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,051 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:28:07,058 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,079 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,079 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:28:07,087 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,107 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,108 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:28:07,115 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,135 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,137 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:28:07,144 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,164 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:28:07,165 [http-nio-8080-exec-6] ==> Parameters: 001109642018(String)
2019-06-18 00:28:07,174 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,195 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:07,197 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:28:06(String)
2019-06-18 00:28:07,222 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,239 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,240 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:28:07,245 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,263 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:28:07,264 [http-nio-8080-exec-6] ==> Parameters: 051200852019(String)
2019-06-18 00:28:07,271 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,296 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:07,298 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:28:06(String)
2019-06-18 00:28:07,328 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:28:07,347 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,348 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:28:07,354 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,375 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,376 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:28:07,382 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,403 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,403 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:28:07,409 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,431 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:28:07,431 [http-nio-8080-exec-6] ==> Parameters: 051200922019(String)
2019-06-18 00:28:07,452 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,472 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:07,472 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:28:06(String)
2019-06-18 00:28:07,500 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:28:07,519 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,520 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:28:07,526 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,547 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,548 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:28:07,555 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,583 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,584 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:28:07,590 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,608 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:28:07,609 [http-nio-8080-exec-6] ==> Parameters: 051201002019(String)
2019-06-18 00:28:07,619 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,642 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:28:07,643 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:28:06(String)
2019-06-18 00:28:07,672 [http-nio-8080-exec-6] <==      Total: 9
2019-06-18 00:28:07,692 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,694 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:28:07,705 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,725 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,727 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:28:07,735 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,757 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,759 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:28:07,772 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,792 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,793 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:28:07,801 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,823 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,824 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:28:07,841 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,859 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,860 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:28:07,867 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,888 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,889 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:28:07,895 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,907 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,908 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:28:07,917 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:28:07,936 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:28:07,936 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:28:07,960 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:29:42,792 [http-nio-8080-exec-2] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:29:42,795 [http-nio-8080-exec-2] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:29:42,804 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:42,820 [http-nio-8080-exec-2] ==>  Preparing: select * from CinemaMiniProgramAccounts where AppId=? and IsDel=0 
2019-06-18 00:29:42,821 [http-nio-8080-exec-2] ==> Parameters: wx8079e2f2a9958d05(String)
2019-06-18 00:29:42,829 [http-nio-8080-exec-2] <==      Total: 8
2019-06-18 00:29:42,848 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:42,848 [http-nio-8080-exec-2] ==> Parameters: 33111001(String)
2019-06-18 00:29:42,855 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:42,878 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:42,878 [http-nio-8080-exec-2] ==> Parameters: 33111001(String)
2019-06-18 00:29:42,885 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:42,904 [http-nio-8080-exec-2] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:29:42,904 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 5(String), 1(String)
2019-06-18 00:29:42,911 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:42,934 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:29:42,934 [http-nio-8080-exec-2] ==> Parameters: 1560578073jzkeu(String)
2019-06-18 00:29:42,941 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:42,960 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:29:42,961 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33111001(String)
2019-06-18 00:29:42,969 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:42,988 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:42,988 [http-nio-8080-exec-2] ==> Parameters: 33096401(String)
2019-06-18 00:29:43,010 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,032 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:43,033 [http-nio-8080-exec-2] ==> Parameters: 33096401(String)
2019-06-18 00:29:43,039 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,060 [http-nio-8080-exec-2] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:29:43,061 [http-nio-8080-exec-2] ==> Parameters: 33096401(String), 2(String), 1(String)
2019-06-18 00:29:43,066 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:29:43,088 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:29:43,089 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:29:43,096 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,111 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:43,112 [http-nio-8080-exec-2] ==> Parameters: 18888888(String)
2019-06-18 00:29:43,119 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,139 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:43,140 [http-nio-8080-exec-2] ==> Parameters: 18888888(String)
2019-06-18 00:29:43,147 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:29:43,167 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:29:43,168 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 18888888(String)
2019-06-18 00:29:43,192 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,212 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:43,213 [http-nio-8080-exec-2] ==> Parameters: 33074881(String)
2019-06-18 00:29:43,221 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,240 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:43,241 [http-nio-8080-exec-2] ==> Parameters: 33074881(String)
2019-06-18 00:29:43,248 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:29:43,268 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:29:43,270 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33074881(String)
2019-06-18 00:29:43,277 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,300 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:43,301 [http-nio-8080-exec-2] ==> Parameters: 22060081(String)
2019-06-18 00:29:43,309 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,328 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:43,329 [http-nio-8080-exec-2] ==> Parameters: 22060081(String)
2019-06-18 00:29:43,335 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:29:43,357 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:29:43,358 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 22060081(String)
2019-06-18 00:29:43,364 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,384 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:43,385 [http-nio-8080-exec-2] ==> Parameters: 33013701(String)
2019-06-18 00:29:43,392 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,412 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:43,413 [http-nio-8080-exec-2] ==> Parameters: 33013701(String)
2019-06-18 00:29:43,419 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:29:43,440 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:29:43,442 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33013701(String)
2019-06-18 00:29:43,450 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,468 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:43,470 [http-nio-8080-exec-2] ==> Parameters: 31120907(String)
2019-06-18 00:29:43,478 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,496 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:43,497 [http-nio-8080-exec-2] ==> Parameters: 31120907(String)
2019-06-18 00:29:43,504 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:29:43,524 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:29:43,525 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 31120907(String)
2019-06-18 00:29:43,533 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,552 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:43,553 [http-nio-8080-exec-2] ==> Parameters: 34140901(String)
2019-06-18 00:29:43,562 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,584 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:43,585 [http-nio-8080-exec-2] ==> Parameters: 34140901(String)
2019-06-18 00:29:43,597 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:43,616 [http-nio-8080-exec-2] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:29:43,616 [http-nio-8080-exec-2] ==> Parameters: 34140901(String), 5(String), 1(String)
2019-06-18 00:29:43,622 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:29:43,644 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:29:43,646 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 34140901(String)
2019-06-18 00:29:43,657 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:29:44,768 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:29:44,770 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:29:44,778 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:44,806 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:29:44,806 [http-nio-8080-exec-4] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:44,806 [http-nio-8080-exec-3] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:29:44,807 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 00:29:44,807 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:29:44,807 [http-nio-8080-exec-3] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:29:44,849 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:29:44,850 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:29:44,850 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:44,869 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:29:44,869 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:44,869 [http-nio-8080-exec-5] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:44,869 [http-nio-8080-exec-3] ==> Parameters: 33013701(String)
2019-06-18 00:29:44,869 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 2019-06-18 00:29:44(String)
2019-06-18 00:29:44,869 [http-nio-8080-exec-5] ==> Parameters: 33013701(String)
2019-06-18 00:29:44,900 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:29:44,900 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:29:44,908 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:29:44,935 [http-nio-8080-exec-3] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:29:44,935 [http-nio-8080-exec-5] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:29:44,935 [http-nio-8080-exec-4] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:44,935 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 00:29:44,935 [http-nio-8080-exec-3] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:29:44,935 [http-nio-8080-exec-5] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:29:44,960 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:29:44,960 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:29:44,960 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:29:44,977 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:44,977 [http-nio-8080-exec-4] ==> Parameters: 001107832017(String)
2019-06-18 00:29:44,992 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:45,016 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:45,016 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 001107832017(String), 2019-06-18 00:29:44(String)
2019-06-18 00:29:45,045 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:29:45,068 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:45,068 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:29:45,083 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:45,108 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:45,109 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:29:45,125 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:45,148 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:45,149 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:29:45,160 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:45,184 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:45,186 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:29:45,210 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:45,233 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:45,235 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:29:45,242 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:45,269 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:45,270 [http-nio-8080-exec-4] ==> Parameters: 012100992019(String)
2019-06-18 00:29:45,280 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:45,308 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:45,309 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 012100992019(String), 2019-06-18 00:29:44(String)
2019-06-18 00:29:45,340 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:29:45,361 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:45,361 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:29:45,379 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:45,400 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:45,401 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:29:45,421 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:29:57,273 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:29:57,273 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:29:57,274 [http-nio-8080-exec-7] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:29:57,274 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:29:57,284 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:29:57,293 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:57,293 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,293 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:29:57,298 [http-nio-8080-exec-7] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:29:57,299 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:29:57,300 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:29:57,305 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,311 [http-nio-8080-exec-6] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:29:57,312 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:29:57,317 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:29:57,318 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 2019-06-18 00:29:57(String)
2019-06-18 00:29:57,318 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:29:57,343 [http-nio-8080-exec-7] <==      Total: 7
2019-06-18 00:29:57,364 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:29:57,364 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:29:57,371 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,393 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:29:57,393 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:29:57,399 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:29:57,420 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:57,421 [http-nio-8080-exec-7] ==> Parameters: 001100072019(String)
2019-06-18 00:29:57,441 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,460 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:57,461 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:29:57(String)
2019-06-18 00:29:57,491 [http-nio-8080-exec-7] <==      Total: 6
2019-06-18 00:29:57,508 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,509 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:29:57,519 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,540 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,542 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:29:57,550 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,573 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,575 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:29:57,582 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,604 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,605 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:29:57,611 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,632 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,633 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:29:57,639 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,664 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,665 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:29:57,671 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,688 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:57,689 [http-nio-8080-exec-7] ==> Parameters: 001102962019(String)
2019-06-18 00:29:57,697 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,722 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:57,724 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:29:57(String)
2019-06-18 00:29:57,749 [http-nio-8080-exec-7] <==      Total: 3
2019-06-18 00:29:57,768 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,769 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:29:57,775 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,796 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,797 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:29:57,803 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,824 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,824 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:29:57,830 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,852 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:57,854 [http-nio-8080-exec-7] ==> Parameters: 001109582018(String)
2019-06-18 00:29:57,877 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,896 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:57,897 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:29:57(String)
2019-06-18 00:29:57,920 [http-nio-8080-exec-7] <==      Total: 5
2019-06-18 00:29:57,946 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,947 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:29:57,953 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:57,972 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:57,973 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:29:57,981 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,002 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,003 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:29:58,009 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,029 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,029 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:29:58,038 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,056 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,056 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:29:58,061 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,080 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:58,080 [http-nio-8080-exec-7] ==> Parameters: 001109642018(String)
2019-06-18 00:29:58,088 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,108 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:58,108 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:29:57(String)
2019-06-18 00:29:58,137 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,156 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,156 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:29:58,165 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,185 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:58,185 [http-nio-8080-exec-7] ==> Parameters: 051200852019(String)
2019-06-18 00:29:58,192 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,213 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:58,213 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:29:57(String)
2019-06-18 00:29:58,241 [http-nio-8080-exec-7] <==      Total: 3
2019-06-18 00:29:58,260 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,260 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:29:58,266 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,284 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,284 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:29:58,292 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,313 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,313 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:29:58,319 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,341 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:58,341 [http-nio-8080-exec-7] ==> Parameters: 051200922019(String)
2019-06-18 00:29:58,347 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,357 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:58,357 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:29:57(String)
2019-06-18 00:29:58,389 [http-nio-8080-exec-7] <==      Total: 3
2019-06-18 00:29:58,413 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,414 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:29:58,420 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,443 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,443 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:29:58,450 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,468 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,469 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:29:58,476 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,496 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:29:58,496 [http-nio-8080-exec-7] ==> Parameters: 051201002019(String)
2019-06-18 00:29:58,503 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,524 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:29:58,525 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:29:57(String)
2019-06-18 00:29:58,550 [http-nio-8080-exec-7] <==      Total: 9
2019-06-18 00:29:58,568 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,569 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:29:58,576 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,596 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,597 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:29:58,604 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,624 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,625 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:29:58,632 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,653 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,654 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:29:58,660 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,680 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,681 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:29:58,686 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,704 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,705 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:29:58,710 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,728 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,729 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:29:58,734 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,753 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,754 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:29:58,760 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:29:58,781 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:29:58,782 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:29:58,787 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:30:05,076 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from cinemaview t 
2019-06-18 00:30:05,078 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:30:05,084 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:30:05,104 [http-nio-8080-exec-8] ==>  Preparing: select * from cinemaview t limit ?, ? 
2019-06-18 00:30:05,106 [http-nio-8080-exec-8] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:30:05,114 [http-nio-8080-exec-8] <==      Total: 10
2019-06-18 00:30:11,272 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Id= ? 
2019-06-18 00:30:11,274 [http-nio-8080-exec-8] ==> Parameters: 7383(Long)
2019-06-18 00:30:11,282 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:30:11,325 [http-nio-8080-exec-5] ==>  Preparing: select * from middleware 
2019-06-18 00:30:11,326 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:30:11,337 [http-nio-8080-exec-5] <==      Total: 22
2019-06-18 00:30:23,321 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from cinemaview t 
2019-06-18 00:30:23,323 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:30:23,345 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:30:23,351 [http-nio-8080-exec-10] ==>  Preparing: select * from cinemaview t limit ?, ? 
2019-06-18 00:30:23,352 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:30:23,360 [http-nio-8080-exec-10] <==      Total: 10
2019-06-18 00:30:25,897 [http-nio-8080-exec-3] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:30:25,900 [http-nio-8080-exec-3] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:30:25,907 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:25,921 [http-nio-8080-exec-3] ==>  Preparing: select * from CinemaMiniProgramAccounts where AppId=? and IsDel=0 
2019-06-18 00:30:25,922 [http-nio-8080-exec-3] ==> Parameters: wx8079e2f2a9958d05(String)
2019-06-18 00:30:25,930 [http-nio-8080-exec-3] <==      Total: 8
2019-06-18 00:30:25,950 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:25,951 [http-nio-8080-exec-3] ==> Parameters: 33111001(String)
2019-06-18 00:30:25,959 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:25,983 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:25,985 [http-nio-8080-exec-3] ==> Parameters: 33111001(String)
2019-06-18 00:30:25,995 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,017 [http-nio-8080-exec-3] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:30:26,019 [http-nio-8080-exec-3] ==> Parameters: 33111001(String), 5(String), 1(String)
2019-06-18 00:30:26,032 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,045 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:30:26,046 [http-nio-8080-exec-3] ==> Parameters: 1560578073jzkeu(String)
2019-06-18 00:30:26,055 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,072 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:26,073 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33111001(String)
2019-06-18 00:30:26,080 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,108 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:26,109 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:30:26,115 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,132 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:26,133 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:30:26,138 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,156 [http-nio-8080-exec-3] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:30:26,157 [http-nio-8080-exec-3] ==> Parameters: 33096401(String), 2(String), 1(String)
2019-06-18 00:30:26,163 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:30:26,180 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:26,181 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:30:26,189 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,208 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:26,209 [http-nio-8080-exec-3] ==> Parameters: 18888888(String)
2019-06-18 00:30:26,219 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,236 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:26,237 [http-nio-8080-exec-3] ==> Parameters: 18888888(String)
2019-06-18 00:30:26,242 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:30:26,261 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:26,261 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 18888888(String)
2019-06-18 00:30:26,280 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,300 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:26,300 [http-nio-8080-exec-3] ==> Parameters: 33074881(String)
2019-06-18 00:30:26,308 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,328 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:26,328 [http-nio-8080-exec-3] ==> Parameters: 33074881(String)
2019-06-18 00:30:26,334 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:30:26,352 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:26,353 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33074881(String)
2019-06-18 00:30:26,359 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,376 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:26,376 [http-nio-8080-exec-3] ==> Parameters: 22060081(String)
2019-06-18 00:30:26,384 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,404 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:26,405 [http-nio-8080-exec-3] ==> Parameters: 22060081(String)
2019-06-18 00:30:26,411 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:30:26,432 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:26,434 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 22060081(String)
2019-06-18 00:30:26,442 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,464 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:26,465 [http-nio-8080-exec-3] ==> Parameters: 33013701(String)
2019-06-18 00:30:26,472 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,492 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:26,493 [http-nio-8080-exec-3] ==> Parameters: 33013701(String)
2019-06-18 00:30:26,506 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:30:26,525 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:26,525 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33013701(String)
2019-06-18 00:30:26,532 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,548 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:26,549 [http-nio-8080-exec-3] ==> Parameters: 31120907(String)
2019-06-18 00:30:26,557 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,577 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:26,578 [http-nio-8080-exec-3] ==> Parameters: 31120907(String)
2019-06-18 00:30:26,585 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:30:26,605 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:26,606 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 31120907(String)
2019-06-18 00:30:26,614 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,633 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:26,634 [http-nio-8080-exec-3] ==> Parameters: 34140901(String)
2019-06-18 00:30:26,642 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,664 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:26,665 [http-nio-8080-exec-3] ==> Parameters: 34140901(String)
2019-06-18 00:30:26,675 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:26,696 [http-nio-8080-exec-3] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:30:26,697 [http-nio-8080-exec-3] ==> Parameters: 34140901(String), 5(String), 1(String)
2019-06-18 00:30:26,705 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:30:26,728 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:26,729 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 34140901(String)
2019-06-18 00:30:26,737 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:30:27,827 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:30:27,828 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:30:27,839 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:27,857 [http-nio-8080-exec-4] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:27,857 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 00:30:27,864 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:27,886 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:30:27,887 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 2019-06-18 00:30:27(String)
2019-06-18 00:30:27,911 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:30:27,934 [http-nio-8080-exec-4] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:27,935 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 00:30:27,941 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:30:27,960 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:27,961 [http-nio-8080-exec-4] ==> Parameters: 001107832017(String)
2019-06-18 00:30:27,967 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:27,990 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:27,991 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 001107832017(String), 2019-06-18 00:30:27(String)
2019-06-18 00:30:28,020 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:30:28,041 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:28,043 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:30:28,049 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:28,068 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:28,069 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:30:28,075 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:28,095 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:28,095 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:30:28,102 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:28,129 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:28,129 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:30:28,140 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:28,158 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:28,158 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:30:28,166 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:28,185 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:28,185 [http-nio-8080-exec-4] ==> Parameters: 012100992019(String)
2019-06-18 00:30:28,191 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:28,212 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:28,214 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 012100992019(String), 2019-06-18 00:30:27(String)
2019-06-18 00:30:28,243 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:30:28,260 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:28,261 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:30:28,268 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:28,289 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:28,290 [http-nio-8080-exec-4] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:30:28,299 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:30:31,093 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:30:31,094 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:30:31,100 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:30:31,121 [http-nio-8080-exec-5] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:31,122 [http-nio-8080-exec-5] ==> Parameters: 12(Long), 33013701(String)
2019-06-18 00:30:31,129 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:30:31,148 [http-nio-8080-exec-5] ==>  Preparing: select * from CinemaMiniProgramAccounts where CinemaCode=? and IsDel=0 
2019-06-18 00:30:31,149 [http-nio-8080-exec-5] ==> Parameters: 33013701(String)
2019-06-18 00:30:31,156 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:30:31,744 [http-nio-8080-exec-5] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:30:31,746 [http-nio-8080-exec-5] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:30:31,753 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:30:31,772 [http-nio-8080-exec-5] ==>  Preparing: select * from registercollectionrecord t where t.openid = ? 
2019-06-18 00:30:31,774 [http-nio-8080-exec-5] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:30:31,782 [http-nio-8080-exec-5] <==      Total: 2
2019-06-18 00:30:31,882 [http-nio-8080-exec-8] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:30:31,882 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:30:31,883 [http-nio-8080-exec-8] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:30:31,883 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:30:31,889 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:30:31,889 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:31,900 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:31,900 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:30:31,901 [http-nio-8080-exec-6] ==> Parameters: 33013701(String)
2019-06-18 00:30:31,901 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 33013701(String)
2019-06-18 00:30:31,907 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:30:31,907 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:31,928 [http-nio-8080-exec-8] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:30:31,928 [http-nio-8080-exec-6] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:30:31,929 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:30:31,929 [http-nio-8080-exec-8] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:30:31,938 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:30:31,938 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:30:32,117 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:30:32,122 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:30:32,133 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from membercardlevel t WHERE Status = ? 
2019-06-18 00:30:32,136 [http-nio-8080-exec-7] ==> Parameters: 1(String)
2019-06-18 00:30:32,139 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:30:32,142 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:30:32,166 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:30:32,166 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardlevel t WHERE Status = ? limit ?, ? 
2019-06-18 00:30:32,167 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:30:32,168 [http-nio-8080-exec-7] ==> Parameters: 1(String), 0(Integer), 10(Integer)
2019-06-18 00:30:32,175 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:30:32,175 [http-nio-8080-exec-7] <==      Total: 10
2019-06-18 00:30:32,272 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from membercardlevel t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) and Status = ? 
2019-06-18 00:30:32,273 [http-nio-8080-exec-1] ==> Parameters: 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 1(String)
2019-06-18 00:30:32,280 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:30:32,305 [http-nio-8080-exec-1] ==>  Preparing: select * from membercardlevel t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) and Status = ? limit ?, ? 
2019-06-18 00:30:32,307 [http-nio-8080-exec-1] ==> Parameters: 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 1(String), 0(Integer), 10(Integer)
2019-06-18 00:30:32,315 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 00:30:34,908 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:30:34,908 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:30:34,910 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:30:34,910 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:30:34,918 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:30:34,918 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:34,936 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:34,936 [http-nio-8080-exec-5] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:30:34,937 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:30:34,937 [http-nio-8080-exec-5] ==> Parameters: 33096401(String)
2019-06-18 00:30:34,945 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:30:34,945 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:34,964 [http-nio-8080-exec-5] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:30:34,964 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:30:34,965 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 2019-06-18 00:30:34(String)
2019-06-18 00:30:34,965 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:30:34,997 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:30:35,007 [http-nio-8080-exec-6] <==      Total: 7
2019-06-18 00:30:35,029 [http-nio-8080-exec-6] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:30:35,031 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:30:35,039 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,060 [http-nio-8080-exec-6] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:30:35,063 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:30:35,073 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:30:35,102 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:35,102 [http-nio-8080-exec-6] ==> Parameters: 001100072019(String)
2019-06-18 00:30:35,121 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,141 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:35,141 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:30:34(String)
2019-06-18 00:30:35,168 [http-nio-8080-exec-6] <==      Total: 6
2019-06-18 00:30:35,189 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,189 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:30:35,198 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,218 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,218 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:30:35,229 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,249 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,249 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:30:35,254 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,266 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,267 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:30:35,273 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,293 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,293 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:30:35,300 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,322 [http-nio-8080-exec-5] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 00:30:35,322 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,322 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:30:35,323 [http-nio-8080-exec-5] ==> Parameters: ruleType(String)
2019-06-18 00:30:35,329 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,329 [http-nio-8080-exec-5] <==      Total: 2
2019-06-18 00:30:35,349 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:35,350 [http-nio-8080-exec-6] ==> Parameters: 001102962019(String)
2019-06-18 00:30:35,357 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,373 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:35,373 [http-nio-8080-exec-2] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:30:35,375 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:30:34(String)
2019-06-18 00:30:35,375 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 00:30:35,384 [http-nio-8080-exec-2] <==      Total: 14
2019-06-18 00:30:35,399 [http-nio-8080-exec-2] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:30:35,400 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 00:30:35,401 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:30:35,411 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,411 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:30:35,412 [http-nio-8080-exec-2] <==      Total: 14
2019-06-18 00:30:35,418 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from membercardcreditrule t 
2019-06-18 00:30:35,421 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,422 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 00:30:35,434 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,435 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:30:35,435 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:30:35,441 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardcreditrule t limit ?, ? 
2019-06-18 00:30:35,442 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:30:35,442 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,449 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,449 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from membercardcreditrule t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) 
2019-06-18 00:30:35,450 [http-nio-8080-exec-9] <==      Total: 10
2019-06-18 00:30:35,450 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:30:35,451 [http-nio-8080-exec-8] ==> Parameters: 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String)
2019-06-18 00:30:35,456 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,457 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:30:35,477 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:35,477 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardcreditrule t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) limit ?, ? 
2019-06-18 00:30:35,478 [http-nio-8080-exec-6] ==> Parameters: 001109582018(String)
2019-06-18 00:30:35,479 [http-nio-8080-exec-8] ==> Parameters: 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 0(Integer), 10(Integer)
2019-06-18 00:30:35,489 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,491 [http-nio-8080-exec-8] <==      Total: 10
2019-06-18 00:30:35,500 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:35,501 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:30:34(String)
2019-06-18 00:30:35,524 [http-nio-8080-exec-6] <==      Total: 5
2019-06-18 00:30:35,545 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,545 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:30:35,551 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,569 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,569 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:30:35,585 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,614 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,615 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:30:35,621 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,640 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,640 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:30:35,646 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,669 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,669 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:30:35,676 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,696 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:35,697 [http-nio-8080-exec-6] ==> Parameters: 001109642018(String)
2019-06-18 00:30:35,704 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,724 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:35,724 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:30:34(String)
2019-06-18 00:30:35,751 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,772 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,773 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:30:35,779 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,800 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:35,801 [http-nio-8080-exec-6] ==> Parameters: 051200852019(String)
2019-06-18 00:30:35,808 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,832 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:35,833 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:30:34(String)
2019-06-18 00:30:35,855 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:30:35,873 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,873 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:30:35,879 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,897 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,897 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:30:35,903 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,921 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:35,922 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:30:35,927 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,944 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:35,945 [http-nio-8080-exec-6] ==> Parameters: 051200922019(String)
2019-06-18 00:30:35,952 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:35,973 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:35,973 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:30:34(String)
2019-06-18 00:30:35,998 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:30:36,020 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,020 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:30:36,028 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,048 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,049 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:30:36,055 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,076 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,077 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:30:36,082 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,104 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:30:36,105 [http-nio-8080-exec-6] ==> Parameters: 051201002019(String)
2019-06-18 00:30:36,111 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,132 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:30:36,132 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:30:34(String)
2019-06-18 00:30:36,158 [http-nio-8080-exec-6] <==      Total: 9
2019-06-18 00:30:36,176 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,177 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:30:36,182 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,206 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,206 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:30:36,211 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,228 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,229 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:30:36,235 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,252 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,253 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:30:36,298 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,317 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,317 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:30:36,327 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,345 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,345 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:30:36,351 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,369 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,370 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:30:36,375 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,396 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,396 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:30:36,403 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:36,421 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:30:36,421 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:30:36,426 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:30:37,845 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:30:37,846 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:30:37,871 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:30:37,889 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:30:37,889 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:30:37,895 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:30:43,500 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and t.status =1 
2019-06-18 00:30:43,502 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:30:43,509 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:31:26,242 [http-nio-8080-exec-3] ==>  Preparing: insert into membercardcreditrule(Id, CinemaCode, RuleCode, RuleName, RuleType, LevelCode, LevelName, CreateTime, Credit, GivenAmount, OfferDescription, RuleDescription, UpdateTime, Status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:31:26,245 [http-nio-8080-exec-3] ==> Parameters: null, 33096401(String), 1560789086rrmbi(String), 充值200送20(String), 1(Integer), 2(String), 会员卡(String), 2019-06-18 00:31:26.223(Timestamp), 200.0(Double), 20.0(Double), 开卡享受会员超值价格(String), 开卡享受会员超值价格(String), null, 1(Integer)
2019-06-18 00:31:26,269 [http-nio-8080-exec-3] <==    Updates: 1
2019-06-18 00:31:27,680 [http-nio-8080-exec-6] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:31:27,681 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:31:27,693 [http-nio-8080-exec-6] <==      Total: 14
2019-06-18 00:31:27,713 [http-nio-8080-exec-6] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:31:27,713 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from membercardcreditrule t 
2019-06-18 00:31:27,714 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:31:27,714 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:31:27,721 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:31:27,721 [http-nio-8080-exec-6] <==      Total: 14
2019-06-18 00:31:27,741 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from membercardcreditrule t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) 
2019-06-18 00:31:27,741 [http-nio-8080-exec-4] ==>  Preparing: select * from membercardcreditrule t limit ?, ? 
2019-06-18 00:31:27,742 [http-nio-8080-exec-1] ==> Parameters: 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String)
2019-06-18 00:31:27,743 [http-nio-8080-exec-4] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:31:27,749 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:31:27,754 [http-nio-8080-exec-4] <==      Total: 10
2019-06-18 00:31:27,769 [http-nio-8080-exec-1] ==>  Preparing: select * from membercardcreditrule t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) limit ?, ? 
2019-06-18 00:31:27,770 [http-nio-8080-exec-1] ==> Parameters: 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 0(Integer), 10(Integer)
2019-06-18 00:31:27,778 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 00:31:36,045 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from membercardlevel t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) and Status = ? 
2019-06-18 00:31:36,046 [http-nio-8080-exec-10] ==> Parameters: 33096401(String), 33096401(String), 1(String)
2019-06-18 00:31:36,053 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:31:36,073 [http-nio-8080-exec-10] ==>  Preparing: select * from membercardlevel t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) and Status = ? limit ?, ? 
2019-06-18 00:31:36,076 [http-nio-8080-exec-10] ==> Parameters: 33096401(String), 33096401(String), 1(String), 0(Integer), 10(Integer)
2019-06-18 00:31:36,083 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:31:36,128 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from membercardlevel t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) and Status = ? 
2019-06-18 00:31:36,128 [http-nio-8080-exec-3] ==> Parameters: 33096401(String), 33096401(String), 1(String)
2019-06-18 00:31:36,133 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:31:36,145 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) and Status = ? limit ?, ? 
2019-06-18 00:31:36,146 [http-nio-8080-exec-3] ==> Parameters: 33096401(String), 33096401(String), 1(String), 0(Integer), 10(Integer)
2019-06-18 00:31:36,155 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:31:37,881 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =1 and t.status =1 
2019-06-18 00:31:37,881 [http-nio-8080-exec-5] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:31:37,883 [http-nio-8080-exec-3] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:31:37,883 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:31:37,889 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:31:37,902 [http-nio-8080-exec-4] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) 
2019-06-18 00:31:37,903 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:31:37,908 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:31:37,909 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:31:40,545 [http-nio-8080-exec-6] ==>  Preparing: delete from choosemembercardcreditrule where cinemacode = ? and levelcode =? 
2019-06-18 00:31:40,546 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), 2(String)
2019-06-18 00:31:40,581 [http-nio-8080-exec-6] <==    Updates: 0
2019-06-18 00:31:40,609 [http-nio-8080-exec-6] ==>  Preparing: insert into choosemembercardcreditrule(Id, CinemaCode, LevelCode, RuleCode, RuleType) values(?, ?, ?, ?, ?) 
2019-06-18 00:31:40,611 [http-nio-8080-exec-6] ==> Parameters: null, 33096401(String), 2(String), 1560789086rrmbi(String), 1(String)
2019-06-18 00:31:40,645 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:31:42,089 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:31:42,090 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:31:42,097 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from membercardlevel t WHERE Status = ? 
2019-06-18 00:31:42,097 [http-nio-8080-exec-9] ==> Parameters: 1(String)
2019-06-18 00:31:42,098 [http-nio-8080-exec-5] <==      Total: 14
2019-06-18 00:31:42,103 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:31:42,105 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:31:42,105 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:31:42,110 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t WHERE Status = ? limit ?, ? 
2019-06-18 00:31:42,111 [http-nio-8080-exec-9] ==> Parameters: 1(String), 0(Integer), 10(Integer)
2019-06-18 00:31:42,111 [http-nio-8080-exec-5] <==      Total: 14
2019-06-18 00:31:42,117 [http-nio-8080-exec-9] <==      Total: 10
2019-06-18 00:31:42,145 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from membercardlevel t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) and Status = ? 
2019-06-18 00:31:42,145 [http-nio-8080-exec-3] ==> Parameters: 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 1(String)
2019-06-18 00:31:42,151 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:31:42,171 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t WHERE (CinemaCode = ? or find_in_set(CinemaCode,?)) and Status = ? limit ?, ? 
2019-06-18 00:31:42,172 [http-nio-8080-exec-3] ==> Parameters: 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 33097601,22113901,33096401,33111001,18888888,33074881,62549174,addsf,gzxxx,22060081,31120907,33013701,34140901,33112911(String), 1(String), 0(Integer), 10(Integer)
2019-06-18 00:31:42,182 [http-nio-8080-exec-3] <==      Total: 10
2019-06-18 00:32:34,993 [http-nio-8080-exec-10] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:32:34,993 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:32:34,993 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:32:34,996 [http-nio-8080-exec-10] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:32:34,996 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:32:34,996 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:32:35,002 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:35,007 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:32:35,013 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:35,014 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:32:35,014 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:32:35,017 [http-nio-8080-exec-4] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:35,018 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:32:35,024 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:35,026 [http-nio-8080-exec-10] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:35,027 [http-nio-8080-exec-10] ==> Parameters: 33096401(String)
2019-06-18 00:32:35,027 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:32:35,033 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:32:35,034 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:32:35,034 [http-nio-8080-exec-4] ==>  Preparing: select * from activity t where t.cinemacode = ? and t.gradecode = ? 
2019-06-18 00:32:35,034 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:32:35,035 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 06(String)
2019-06-18 00:32:35,040 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:35,041 [http-nio-8080-exec-10] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:32:35,042 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:32:35,042 [http-nio-8080-exec-10] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:32:35,048 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:32:35,069 [http-nio-8080-exec-10] ==>  Preparing: select * from orders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? and (t.printstatus != ? or t.printstatus is null) 
2019-06-18 00:32:35,069 [http-nio-8080-exec-6] ==>  Preparing: select * from orders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? and (t.printstatus != ? or t.printstatus is null) 
2019-06-18 00:32:35,071 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 1(Integer)
2019-06-18 00:32:35,071 [http-nio-8080-exec-10] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 1(Integer)
2019-06-18 00:32:35,086 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:32:35,086 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:35,110 [http-nio-8080-exec-6] ==>  Preparing: select * from goodsorders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? 
2019-06-18 00:32:35,110 [http-nio-8080-exec-10] ==>  Preparing: select * from goodsorders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? 
2019-06-18 00:32:35,111 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer)
2019-06-18 00:32:35,111 [http-nio-8080-exec-10] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer)
2019-06-18 00:32:35,123 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:32:35,124 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:35,141 [http-nio-8080-exec-10] ==>  Preparing: select * from coupons t where t.openid = ? and t.status = ? group by groupcode 
2019-06-18 00:32:35,141 [http-nio-8080-exec-6] ==>  Preparing: select * from coupons t where t.openid = ? and t.status = ? group by groupcode 
2019-06-18 00:32:35,142 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:32:35,142 [http-nio-8080-exec-10] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:32:35,158 [http-nio-8080-exec-10] <==      Total: 3
2019-06-18 00:32:35,158 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:32:35,178 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:35,178 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:35,179 [http-nio-8080-exec-10] ==> Parameters: 1559373351460443(String), 1(Integer), 33096401(String)
2019-06-18 00:32:35,179 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 1(Integer), 33096401(String)
2019-06-18 00:32:35,187 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:35,187 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:32:35,205 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:35,205 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:35,206 [http-nio-8080-exec-6] ==> Parameters: 1560674924223303(String), 1(Integer), 33096401(String)
2019-06-18 00:32:35,206 [http-nio-8080-exec-10] ==> Parameters: 1560674924223303(String), 1(Integer), 33096401(String)
2019-06-18 00:32:35,212 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:35,212 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:32:35,234 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:35,234 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:35,234 [http-nio-8080-exec-6] ==> Parameters: 1560691023985310(String), 1(Integer), 33096401(String)
2019-06-18 00:32:35,234 [http-nio-8080-exec-10] ==> Parameters: 1560691023985310(String), 1(Integer), 33096401(String)
2019-06-18 00:32:35,241 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:35,241 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:32:35,261 [http-nio-8080-exec-6] ==>  Preparing: select * from roomgiftuser where OPenID = ? and CinemaCode=? and giftType = '1' 
2019-06-18 00:32:35,261 [http-nio-8080-exec-10] ==>  Preparing: select * from roomgiftuser where OPenID = ? and CinemaCode=? and giftType = '1' 
2019-06-18 00:32:35,264 [http-nio-8080-exec-10] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 33096401(String)
2019-06-18 00:32:35,264 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 33096401(String)
2019-06-18 00:32:35,273 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:35,273 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:32:35,294 [http-nio-8080-exec-10] ==>  Preparing: select * from ticketuserfilm t where t.openid = ? and t.status = ? 
2019-06-18 00:32:35,294 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketuserfilm t where t.openid = ? and t.status = ? 
2019-06-18 00:32:35,296 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:32:35,296 [http-nio-8080-exec-10] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:32:35,302 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:32:35,302 [http-nio-8080-exec-10] <==      Total: 3
2019-06-18 00:32:35,321 [http-nio-8080-exec-10] ==>  Preparing: select * from orders t where t.openid = ? and t.orderstatus = ? and t.sessiontime < ? group by t.filmcode 
2019-06-18 00:32:35,321 [http-nio-8080-exec-6] ==>  Preparing: select * from orders t where t.openid = ? and t.orderstatus = ? and t.sessiontime < ? group by t.filmcode 
2019-06-18 00:32:35,323 [http-nio-8080-exec-10] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 2019-06-18 02:32:35(String)
2019-06-18 00:32:35,323 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 2019-06-18 02:32:35(String)
2019-06-18 00:32:35,340 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:32:35,342 [http-nio-8080-exec-10] <==      Total: 3
2019-06-18 00:32:43,331 [http-nio-8080-exec-3] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:32:43,333 [http-nio-8080-exec-3] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:32:43,339 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:43,350 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:43,350 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:32:43,356 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:43,373 [http-nio-8080-exec-3] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:32:43,374 [http-nio-8080-exec-3] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:32:43,384 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:43,404 [http-nio-8080-exec-3] ==>  Preparing: select * from coupons t where t.openid = ? ORDER BY status asc,receivedate desc 
2019-06-18 00:32:43,406 [http-nio-8080-exec-3] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:32:43,420 [http-nio-8080-exec-3] <==      Total: 22
2019-06-18 00:32:43,445 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:43,447 [http-nio-8080-exec-3] ==> Parameters: 1560674924223303(String), 33096401(String)
2019-06-18 00:32:43,458 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,477 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:43,477 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:43,487 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:43,510 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:43,510 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,519 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,537 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:43,539 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,545 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,565 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:43,566 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:43,572 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,589 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:43,590 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:43,597 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:43,618 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:43,619 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,627 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,645 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:43,646 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,653 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,677 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:43,678 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:43,683 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,702 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:43,702 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:43,712 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:43,730 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:43,730 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,741 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,762 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:43,763 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,770 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,790 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:43,790 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:43,804 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,821 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:43,821 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:43,829 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:43,854 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:43,854 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,861 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,886 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:43,887 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,893 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,929 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:43,930 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:43,937 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:43,960 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:43,961 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:43,968 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:43,985 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:43,986 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:43,997 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,018 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:44,019 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,034 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,057 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:44,058 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:44,065 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,091 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,092 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:44,102 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:44,124 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:44,125 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,134 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,154 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:44,154 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,160 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,177 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:44,177 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:44,184 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,205 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,206 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:44,213 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:44,234 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:44,234 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,240 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,261 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:44,261 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,267 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,285 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:44,286 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:44,293 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,301 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,303 [http-nio-8080-exec-3] ==> Parameters: 1560691023985310(String), 33096401(String)
2019-06-18 00:32:44,310 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,332 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,332 [http-nio-8080-exec-3] ==> Parameters: 1560691023985310(String), 33096401(String)
2019-06-18 00:32:44,339 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,357 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,358 [http-nio-8080-exec-3] ==> Parameters: 1560674924223303(String), 33096401(String)
2019-06-18 00:32:44,364 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,385 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,386 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:44,393 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:44,413 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:44,415 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,423 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,445 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:44,447 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,454 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,473 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:44,474 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:44,486 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,510 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,510 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:44,518 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:44,538 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:44,539 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,545 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,565 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:44,565 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,574 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,593 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:44,594 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:44,601 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,621 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,622 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:44,633 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:44,654 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:44,654 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,661 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,681 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:44,682 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,688 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,705 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:44,706 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:44,717 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,737 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,738 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:44,748 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:44,769 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:44,770 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,777 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,797 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:44,798 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,807 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,825 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:44,826 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:44,832 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,853 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,854 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:44,860 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:44,878 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:44,879 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,886 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,906 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:44,907 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:44,915 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,939 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:44,940 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:44,948 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:44,969 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:44,970 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:44,980 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:45,001 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:45,002 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,008 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,025 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:45,026 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,032 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,049 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:45,050 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:45,056 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,079 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:45,080 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:45,089 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:45,113 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:45,114 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,128 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,151 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:45,152 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,158 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,186 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:45,188 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:45,195 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,214 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:45,215 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:45,225 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:45,247 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:45,248 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,257 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,278 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:45,279 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,289 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,309 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:45,310 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:45,318 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,337 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:45,339 [http-nio-8080-exec-3] ==> Parameters: 1560434809995527(String), 33096401(String)
2019-06-18 00:32:45,358 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:45,368 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:45,369 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,377 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,397 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:45,398 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,412 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,431 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:45,431 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:45,437 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,458 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:45,459 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:45,468 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:45,489 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:45,490 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,498 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,518 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:45,519 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,526 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,545 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:45,546 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:45,557 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,581 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:45,582 [http-nio-8080-exec-3] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:45,589 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:32:45,628 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:45,629 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,639 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,663 [http-nio-8080-exec-3] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:45,664 [http-nio-8080-exec-3] ==> Parameters: (String)
2019-06-18 00:32:45,669 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:45,698 [http-nio-8080-exec-3] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:45,698 [http-nio-8080-exec-3] ==> Parameters: (String), (String)
2019-06-18 00:32:45,704 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:32:56,529 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:32:56,531 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:32:56,559 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:32:56,581 [http-nio-8080-exec-4] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:56,582 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:32:56,591 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:32:56,613 [http-nio-8080-exec-4] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:32:56,614 [http-nio-8080-exec-4] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:32:56,626 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:32:56,645 [http-nio-8080-exec-4] ==>  Preparing: select * from orders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? and (t.printstatus != ? or t.printstatus is null) 
2019-06-18 00:32:56,647 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 1(Integer)
2019-06-18 00:32:56,654 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:32:56,677 [http-nio-8080-exec-4] ==>  Preparing: select * from goodsorders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? 
2019-06-18 00:32:56,678 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer)
2019-06-18 00:32:56,688 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:32:56,718 [http-nio-8080-exec-4] ==>  Preparing: select * from coupons t where t.openid = ? and t.status = ? group by groupcode 
2019-06-18 00:32:56,718 [http-nio-8080-exec-4] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:32:56,727 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:32:56,745 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:56,747 [http-nio-8080-exec-4] ==> Parameters: 1559373351460443(String), 1(Integer), 33096401(String)
2019-06-18 00:32:56,754 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:32:56,774 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:56,775 [http-nio-8080-exec-4] ==> Parameters: 1560674924223303(String), 1(Integer), 33096401(String)
2019-06-18 00:32:56,784 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:32:56,801 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? and t.status = ? and (t.canusecinematype = 1 or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:56,803 [http-nio-8080-exec-4] ==> Parameters: 1560691023985310(String), 1(Integer), 33096401(String)
2019-06-18 00:32:56,811 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:32:56,830 [http-nio-8080-exec-4] ==>  Preparing: select * from roomgiftuser where OPenID = ? and CinemaCode=? and giftType = '1' 
2019-06-18 00:32:56,830 [http-nio-8080-exec-4] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 33096401(String)
2019-06-18 00:32:56,836 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:32:56,854 [http-nio-8080-exec-4] ==>  Preparing: select * from ticketuserfilm t where t.openid = ? and t.status = ? 
2019-06-18 00:32:56,855 [http-nio-8080-exec-4] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:32:56,861 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:32:56,882 [http-nio-8080-exec-4] ==>  Preparing: select * from orders t where t.openid = ? and t.orderstatus = ? and t.sessiontime < ? group by t.filmcode 
2019-06-18 00:32:56,883 [http-nio-8080-exec-4] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 2019-06-18 02:32:56(String)
2019-06-18 00:32:56,898 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:32:58,482 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:32:58,482 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:32:58,494 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:58,515 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:58,516 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:32:58,525 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:58,545 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:32:58,547 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:32:58,554 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:58,577 [http-nio-8080-exec-6] ==>  Preparing: select * from coupons t where t.openid = ? ORDER BY status asc,receivedate desc 
2019-06-18 00:32:58,578 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:32:58,587 [http-nio-8080-exec-6] <==      Total: 22
2019-06-18 00:32:58,605 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:58,607 [http-nio-8080-exec-6] ==> Parameters: 1560674924223303(String), 33096401(String)
2019-06-18 00:32:58,613 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,633 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:58,634 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:58,644 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:58,661 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:58,662 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:58,669 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,690 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:58,691 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:58,697 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,718 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:58,719 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:58,725 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,746 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:58,747 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:58,755 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:58,773 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:58,774 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:58,785 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,806 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:58,806 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:58,817 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,829 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:58,830 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:58,844 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,866 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:58,866 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:58,874 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:58,893 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:58,893 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:58,900 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,917 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:58,918 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:58,924 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,945 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:58,946 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:58,953 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:58,975 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:58,976 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:58,982 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,005 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,006 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,012 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,030 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:59,030 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,036 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,057 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:59,058 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:59,066 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,090 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,090 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:59,103 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,122 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,122 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,128 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,145 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:59,145 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,151 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,173 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:59,174 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:59,180 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,198 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,198 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:59,204 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,221 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,221 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,228 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,245 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:59,245 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,252 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,269 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:59,270 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:59,276 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,293 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,294 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:59,308 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,325 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,326 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,334 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,357 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:59,358 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,364 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,381 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:59,382 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:59,389 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,409 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,411 [http-nio-8080-exec-6] ==> Parameters: 1560691023985310(String), 33096401(String)
2019-06-18 00:32:59,419 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,438 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,438 [http-nio-8080-exec-6] ==> Parameters: 1560691023985310(String), 33096401(String)
2019-06-18 00:32:59,445 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,458 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,459 [http-nio-8080-exec-6] ==> Parameters: 1560674924223303(String), 33096401(String)
2019-06-18 00:32:59,466 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,487 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,488 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:59,499 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,517 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,519 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,526 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,549 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:59,549 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,557 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,577 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:59,578 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:59,596 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,617 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,619 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:59,627 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,649 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,650 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,658 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,677 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:59,678 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,686 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,708 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:59,708 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:59,714 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,734 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,735 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:59,743 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,762 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,763 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,771 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,782 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:59,783 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,795 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,814 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:59,815 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:59,822 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,842 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,842 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:59,851 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,870 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,871 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,877 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,897 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:32:59,898 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,905 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,925 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:32:59,927 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:32:59,934 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:32:59,953 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:32:59,954 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:32:59,961 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:32:59,981 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:32:59,982 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:32:59,994 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,013 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:33:00,015 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,022 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,041 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:33:00,043 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:33:00,050 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,069 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:33:00,070 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:33:00,078 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:33:00,097 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:33:00,098 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,107 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,125 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:33:00,126 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,133 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,155 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:33:00,155 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:33:00,163 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,182 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:33:00,182 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:33:00,190 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:33:00,206 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:33:00,207 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,214 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,234 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:33:00,235 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,242 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,261 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:33:00,262 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:33:00,269 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,289 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:33:00,290 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:33:00,301 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:33:00,321 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:33:00,322 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,329 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,349 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:33:00,349 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,355 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,373 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:33:00,374 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:33:00,382 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,402 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:33:00,403 [http-nio-8080-exec-6] ==> Parameters: 1560434809995527(String), 33096401(String)
2019-06-18 00:33:00,411 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:33:00,430 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:33:00,432 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,439 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,457 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:33:00,459 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,467 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,486 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:33:00,487 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:33:00,494 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,513 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:33:00,514 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:33:00,522 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:33:00,542 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:33:00,543 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,550 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,570 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:33:00,570 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,576 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,594 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:33:00,594 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:33:00,600 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,618 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t where t.groupcode =? and (cinemacodes='' or find_in_set(?,cinemacodes)) 
2019-06-18 00:33:00,618 [http-nio-8080-exec-6] ==> Parameters: 1559373351460443(String), 33096401(String)
2019-06-18 00:33:00,625 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:33:00,645 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:33:00,646 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,653 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,673 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:33:00,674 [http-nio-8080-exec-6] ==> Parameters: (String)
2019-06-18 00:33:00,680 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:33:00,709 [http-nio-8080-exec-6] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 00:33:00,710 [http-nio-8080-exec-6] ==> Parameters: (String), (String)
2019-06-18 00:33:00,716 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:09,726 [http-nio-8080-exec-8] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:09,730 [http-nio-8080-exec-8] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:09,739 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:09,754 [http-nio-8080-exec-8] ==>  Preparing: select * from CinemaMiniProgramAccounts where AppId=? and IsDel=0 
2019-06-18 00:34:09,756 [http-nio-8080-exec-8] ==> Parameters: wx8079e2f2a9958d05(String)
2019-06-18 00:34:09,762 [http-nio-8080-exec-8] <==      Total: 8
2019-06-18 00:34:09,782 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:09,784 [http-nio-8080-exec-8] ==> Parameters: 33111001(String)
2019-06-18 00:34:09,793 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:09,814 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:09,816 [http-nio-8080-exec-8] ==> Parameters: 33111001(String)
2019-06-18 00:34:09,825 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:09,845 [http-nio-8080-exec-8] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:34:09,847 [http-nio-8080-exec-8] ==> Parameters: 33111001(String), 5(String), 1(String)
2019-06-18 00:34:09,854 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:09,873 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:34:09,874 [http-nio-8080-exec-8] ==> Parameters: 1560578073jzkeu(String)
2019-06-18 00:34:09,880 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:09,898 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:34:09,898 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 33111001(String)
2019-06-18 00:34:09,907 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:09,925 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:09,926 [http-nio-8080-exec-8] ==> Parameters: 33096401(String)
2019-06-18 00:34:09,936 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:09,954 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:09,955 [http-nio-8080-exec-8] ==> Parameters: 33096401(String)
2019-06-18 00:34:09,963 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:09,982 [http-nio-8080-exec-8] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:34:09,982 [http-nio-8080-exec-8] ==> Parameters: 33096401(String), 2(String), 1(String)
2019-06-18 00:34:09,988 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,006 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:34:10,006 [http-nio-8080-exec-8] ==> Parameters: 1560789086rrmbi(String)
2019-06-18 00:34:10,012 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,034 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:34:10,034 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:34:10,043 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,062 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:10,062 [http-nio-8080-exec-8] ==> Parameters: 18888888(String)
2019-06-18 00:34:10,069 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,086 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:10,086 [http-nio-8080-exec-8] ==> Parameters: 18888888(String)
2019-06-18 00:34:10,092 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:34:10,110 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:34:10,110 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 18888888(String)
2019-06-18 00:34:10,131 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,161 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:10,162 [http-nio-8080-exec-8] ==> Parameters: 33074881(String)
2019-06-18 00:34:10,169 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,186 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:10,187 [http-nio-8080-exec-8] ==> Parameters: 33074881(String)
2019-06-18 00:34:10,191 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:34:10,210 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:34:10,210 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 33074881(String)
2019-06-18 00:34:10,218 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,239 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:10,239 [http-nio-8080-exec-8] ==> Parameters: 22060081(String)
2019-06-18 00:34:10,247 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,265 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:10,267 [http-nio-8080-exec-8] ==> Parameters: 22060081(String)
2019-06-18 00:34:10,273 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:34:10,294 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:34:10,295 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 22060081(String)
2019-06-18 00:34:10,302 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,314 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:10,315 [http-nio-8080-exec-8] ==> Parameters: 33013701(String)
2019-06-18 00:34:10,323 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,342 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:10,342 [http-nio-8080-exec-8] ==> Parameters: 33013701(String)
2019-06-18 00:34:10,348 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:34:10,370 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:34:10,371 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 33013701(String)
2019-06-18 00:34:10,378 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,398 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:10,399 [http-nio-8080-exec-8] ==> Parameters: 31120907(String)
2019-06-18 00:34:10,406 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,426 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:10,427 [http-nio-8080-exec-8] ==> Parameters: 31120907(String)
2019-06-18 00:34:10,433 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:34:10,454 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:34:10,455 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 31120907(String)
2019-06-18 00:34:10,464 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,482 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:10,483 [http-nio-8080-exec-8] ==> Parameters: 34140901(String)
2019-06-18 00:34:10,492 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,510 [http-nio-8080-exec-8] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:10,511 [http-nio-8080-exec-8] ==> Parameters: 34140901(String)
2019-06-18 00:34:10,518 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:10,538 [http-nio-8080-exec-8] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:34:10,539 [http-nio-8080-exec-8] ==> Parameters: 34140901(String), 5(String), 1(String)
2019-06-18 00:34:10,545 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:34:10,565 [http-nio-8080-exec-8] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:34:10,566 [http-nio-8080-exec-8] ==> Parameters: 12(Long), 34140901(String)
2019-06-18 00:34:10,575 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:34:11,663 [http-nio-8080-exec-2] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:11,665 [http-nio-8080-exec-2] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:11,673 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:11,683 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:11,684 [http-nio-8080-exec-2] ==> Parameters: 33013701(String)
2019-06-18 00:34:11,691 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:11,710 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:11,710 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:11,710 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:34:11,711 [http-nio-8080-exec-1] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:11,711 [http-nio-8080-exec-7] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:11,712 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 2019-06-18 00:34:11(String)
2019-06-18 00:34:11,719 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:34:11,719 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:34:11,738 [http-nio-8080-exec-1] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:11,738 [http-nio-8080-exec-7] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:11,739 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 00:34:11,740 [http-nio-8080-exec-1] ==> Parameters: 33013701(String)
2019-06-18 00:34:11,740 [http-nio-8080-exec-7] ==> Parameters: 33013701(String)
2019-06-18 00:34:11,748 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:34:11,748 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:34:11,762 [http-nio-8080-exec-2] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:11,762 [http-nio-8080-exec-7] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:34:11,762 [http-nio-8080-exec-1] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:34:11,763 [http-nio-8080-exec-1] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:34:11,763 [http-nio-8080-exec-2] ==> Parameters: 33013701(String)
2019-06-18 00:34:11,764 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:34:11,770 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:34:11,770 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:34:11,777 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:34:11,792 [http-nio-8080-exec-2] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:11,794 [http-nio-8080-exec-2] ==> Parameters: 001107832017(String)
2019-06-18 00:34:11,811 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:11,830 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:11,832 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 001107832017(String), 2019-06-18 00:34:11(String)
2019-06-18 00:34:11,857 [http-nio-8080-exec-2] <==      Total: 5
2019-06-18 00:34:11,878 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:11,879 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:34:11,885 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:11,902 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:11,903 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:34:11,909 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:11,930 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:11,931 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:34:11,937 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:11,959 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:11,960 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:34:11,969 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:11,990 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:11,991 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:34:11,999 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:12,018 [http-nio-8080-exec-2] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:12,019 [http-nio-8080-exec-2] ==> Parameters: 012100992019(String)
2019-06-18 00:34:12,027 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:12,047 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:12,048 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 012100992019(String), 2019-06-18 00:34:11(String)
2019-06-18 00:34:12,071 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 00:34:12,090 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:12,091 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:34:12,097 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:12,117 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:12,119 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:34:12,126 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:34:14,098 [http-nio-8080-exec-3] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:14,098 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:14,100 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:14,100 [http-nio-8080-exec-3] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:14,130 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,130 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:34:14,150 [http-nio-8080-exec-4] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:14,150 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:14,151 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:34:14,151 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:34:14,184 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,184 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:34:14,226 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:34:14,226 [http-nio-8080-exec-3] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:34:14,227 [http-nio-8080-exec-3] ==> Parameters: 33096401(String), 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:34:14,227 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 2019-06-18 00:34:14(String)
2019-06-18 00:34:14,240 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:34:14,268 [http-nio-8080-exec-4] <==      Total: 7
2019-06-18 00:34:14,290 [http-nio-8080-exec-4] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:34:14,291 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:34:14,297 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,329 [http-nio-8080-exec-4] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:34:14,331 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:34:14,356 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:34:14,378 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:14,380 [http-nio-8080-exec-4] ==> Parameters: 001100072019(String)
2019-06-18 00:34:14,403 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,422 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:14,423 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:34:14(String)
2019-06-18 00:34:14,472 [http-nio-8080-exec-4] <==      Total: 6
2019-06-18 00:34:14,494 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,495 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:34:14,506 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,526 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,526 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:34:14,549 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,570 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,571 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:34:14,583 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,602 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,603 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:34:14,623 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,646 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,646 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:34:14,656 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,685 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,686 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:34:14,693 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,721 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:14,722 [http-nio-8080-exec-4] ==> Parameters: 001102962019(String)
2019-06-18 00:34:14,729 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,762 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:14,763 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:34:14(String)
2019-06-18 00:34:14,806 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:34:14,827 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,827 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:34:14,856 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,878 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,879 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:34:14,886 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,906 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:14,907 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:34:14,917 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,934 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:14,935 [http-nio-8080-exec-4] ==> Parameters: 001109582018(String)
2019-06-18 00:34:14,967 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:14,999 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:14,999 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:34:14(String)
2019-06-18 00:34:15,024 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:34:15,046 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,047 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:34:15,062 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,081 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,082 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:34:15,104 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,123 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,124 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:34:15,138 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,166 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,166 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:34:15,172 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,202 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,203 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:34:15,222 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,246 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:15,247 [http-nio-8080-exec-4] ==> Parameters: 001109642018(String)
2019-06-18 00:34:15,265 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,288 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:15,309 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:34:14(String)
2019-06-18 00:34:15,344 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,370 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,371 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:34:15,388 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,419 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:15,420 [http-nio-8080-exec-4] ==> Parameters: 051200852019(String)
2019-06-18 00:34:15,428 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,450 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:15,451 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:34:14(String)
2019-06-18 00:34:15,477 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:34:15,510 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,510 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:34:15,525 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,549 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,550 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:34:15,555 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,582 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,582 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:34:15,588 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,614 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:15,614 [http-nio-8080-exec-4] ==> Parameters: 051200922019(String)
2019-06-18 00:34:15,627 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,650 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:15,651 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:34:14(String)
2019-06-18 00:34:15,674 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:34:15,698 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,699 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:34:15,708 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,734 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,735 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:34:15,755 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,777 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,778 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:34:15,793 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,815 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:34:15,815 [http-nio-8080-exec-4] ==> Parameters: 051201002019(String)
2019-06-18 00:34:15,834 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,857 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:34:15,859 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:34:14(String)
2019-06-18 00:34:15,886 [http-nio-8080-exec-4] <==      Total: 9
2019-06-18 00:34:15,905 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,906 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:34:15,916 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,938 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,938 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:34:15,953 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:15,982 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:15,983 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:34:15,990 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:16,014 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:16,015 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:34:16,020 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:16,058 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:16,059 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:34:16,064 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:16,094 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:16,096 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:34:16,112 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:16,138 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:16,138 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:34:16,160 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:16,178 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:16,179 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:34:16,191 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:16,211 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:34:16,211 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:34:16,226 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:18,462 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:18,462 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:18,462 [http-nio-8080-exec-10] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:18,462 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:18,462 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:18,462 [http-nio-8080-exec-10] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:18,472 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:34:18,472 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:34:18,484 [http-nio-8080-exec-5] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:18,484 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:18,484 [http-nio-8080-exec-5] ==> Parameters: 33096401(String)
2019-06-18 00:34:18,484 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:34:18,490 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:34:18,493 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:34:18,493 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:34:18,510 [http-nio-8080-exec-5] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:34:18,510 [http-nio-8080-exec-10] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:18,510 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:34:18,511 [http-nio-8080-exec-5] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:34:18,511 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:34:18,511 [http-nio-8080-exec-10] ==> Parameters: 33096401(String)
2019-06-18 00:34:18,519 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:34:18,519 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:34:18,519 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:34:18,540 [http-nio-8080-exec-5] ==>  Preparing: select * from orders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? and (t.printstatus != ? or t.printstatus is null) 
2019-06-18 00:34:18,540 [http-nio-8080-exec-6] ==>  Preparing: select * from orders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? and (t.printstatus != ? or t.printstatus is null) 
2019-06-18 00:34:18,540 [http-nio-8080-exec-10] ==>  Preparing: select * from activity t where t.cinemacode = ? and t.gradecode = ? 
2019-06-18 00:34:18,541 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 1(Integer)
2019-06-18 00:34:18,542 [http-nio-8080-exec-10] ==> Parameters: 33096401(String), 06(String)
2019-06-18 00:34:18,542 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 1(Integer)
2019-06-18 00:34:18,548 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:18,549 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:34:18,549 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:34:18,575 [http-nio-8080-exec-6] ==>  Preparing: select * from goodsorders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? 
2019-06-18 00:34:18,575 [http-nio-8080-exec-5] ==>  Preparing: select * from goodsorders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? 
2019-06-18 00:34:18,575 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer)
2019-06-18 00:34:18,576 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer)
2019-06-18 00:34:18,586 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:34:18,586 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:18,606 [http-nio-8080-exec-5] ==>  Preparing: select * from coupons t where t.openid = ? and t.status = ? group by groupcode 
2019-06-18 00:34:18,606 [http-nio-8080-exec-6] ==>  Preparing: select * from coupons t where t.openid = ? and t.status = ? group by groupcode 
2019-06-18 00:34:18,607 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:34:18,607 [http-nio-8080-exec-5] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:34:18,614 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:18,615 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:34:18,635 [http-nio-8080-exec-6] ==>  Preparing: select * from roomgiftuser where OPenID = ? and CinemaCode=? and giftType = '1' 
2019-06-18 00:34:18,635 [http-nio-8080-exec-5] ==>  Preparing: select * from roomgiftuser where OPenID = ? and CinemaCode=? and giftType = '1' 
2019-06-18 00:34:18,636 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 33096401(String)
2019-06-18 00:34:18,637 [http-nio-8080-exec-5] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 33096401(String)
2019-06-18 00:34:18,644 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:34:18,644 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:18,662 [http-nio-8080-exec-5] ==>  Preparing: select * from ticketuserfilm t where t.openid = ? and t.status = ? 
2019-06-18 00:34:18,662 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketuserfilm t where t.openid = ? and t.status = ? 
2019-06-18 00:34:18,663 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:34:18,663 [http-nio-8080-exec-5] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:34:18,669 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:34:18,669 [http-nio-8080-exec-5] <==      Total: 3
2019-06-18 00:34:18,690 [http-nio-8080-exec-6] ==>  Preparing: select * from orders t where t.openid = ? and t.orderstatus = ? and t.sessiontime < ? group by t.filmcode 
2019-06-18 00:34:18,690 [http-nio-8080-exec-5] ==>  Preparing: select * from orders t where t.openid = ? and t.orderstatus = ? and t.sessiontime < ? group by t.filmcode 
2019-06-18 00:34:18,690 [http-nio-8080-exec-5] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 2019-06-18 02:34:18(String)
2019-06-18 00:34:18,691 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 2019-06-18 02:34:18(String)
2019-06-18 00:34:18,705 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:34:18,708 [http-nio-8080-exec-5] <==      Total: 3
2019-06-18 00:34:21,282 [http-nio-8080-exec-9] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:21,283 [http-nio-8080-exec-9] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:21,289 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:34:21,310 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:21,311 [http-nio-8080-exec-9] ==> Parameters: 33096401(String)
2019-06-18 00:34:21,319 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:34:21,338 [http-nio-8080-exec-9] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:34:21,339 [http-nio-8080-exec-9] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:34:21,346 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:34:21,366 [http-nio-8080-exec-9] ==>  Preparing: select * from coupons t where t.openid = ? ORDER BY status asc,receivedate desc 
2019-06-18 00:34:21,367 [http-nio-8080-exec-9] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:34:21,375 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:34:24,245 [http-nio-8080-exec-5] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-06-18 00:34:24,246 [http-nio-8080-exec-5] ==> Parameters: admin(String)
2019-06-18 00:34:24,253 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:34:24,278 [http-nio-8080-exec-5] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-06-18 00:34:24,279 [http-nio-8080-exec-5] ==> Parameters: 1(Long)
2019-06-18 00:34:24,288 [http-nio-8080-exec-5] <==      Total: 46
2019-06-18 00:34:24,352 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:34:24,354 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:34:24,365 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:34:24,386 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:34:24,387 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:34:24,413 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:34:24,466 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 00:34:24,466 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 00:34:24,468 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:34:24,468 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:34:24,476 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:34:24,476 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:34:26,828 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:34:26,830 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:34:26,837 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:34:26,850 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:34:26,851 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:34:26,860 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:34:26,886 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:34:26,887 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:34:26,896 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:34:26,918 [http-nio-8080-exec-6] ==>  Preparing: select * from orders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? and (t.printstatus != ? or t.printstatus is null) 
2019-06-18 00:34:26,920 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 1(Integer)
2019-06-18 00:34:26,931 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:26,950 [http-nio-8080-exec-6] ==>  Preparing: select * from goodsorders t where t.cinemacode = ? and t.openid = ? and t.orderstatus = ? 
2019-06-18 00:34:26,952 [http-nio-8080-exec-6] ==> Parameters: 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer)
2019-06-18 00:34:26,960 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:26,982 [http-nio-8080-exec-6] ==>  Preparing: select * from coupons t where t.openid = ? and t.status = ? group by groupcode 
2019-06-18 00:34:26,984 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:34:26,993 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:27,014 [http-nio-8080-exec-6] ==>  Preparing: select * from roomgiftuser where OPenID = ? and CinemaCode=? and giftType = '1' 
2019-06-18 00:34:27,015 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 33096401(String)
2019-06-18 00:34:27,023 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:34:27,042 [http-nio-8080-exec-6] ==>  Preparing: select * from ticketuserfilm t where t.openid = ? and t.status = ? 
2019-06-18 00:34:27,042 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:34:27,052 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:34:27,073 [http-nio-8080-exec-6] ==>  Preparing: select * from orders t where t.openid = ? and t.orderstatus = ? and t.sessiontime < ? group by t.filmcode 
2019-06-18 00:34:27,074 [http-nio-8080-exec-6] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 8(Integer), 2019-06-18 02:34:27(String)
2019-06-18 00:34:27,090 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 00:34:28,933 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:34:28,935 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:34:28,944 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 00:34:28,965 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:34:28,965 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:34:28,973 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 00:35:03,550 [http-nio-8080-exec-6] ==>  Preparing: insert into couponsgroup(GroupCode, CouponsType, CouponsName, ValidityType, EffectiveDate, ExpireDate, EffectiveDays, ValidityDays, CanUsePeriodType, WeekDays, TimePeriod, LimitNum, ReductionType, initialAmount, ReductionPrice, FilmCodes, GoodsCodes, IsShare, Remark, CanUseCinemaType, CinemaCodes, Status, CouponsNumber, IssuedNumber, FetchNumber, RemainingNumber, UsedNumber, SendGroupNumber, SendNumber, GiftType, CreateDate, UpdateDate,IsUseChatRoom) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?) 
2019-06-18 00:35:03,552 [http-nio-8080-exec-6] ==> Parameters: 1560789303576581(String), 1(Integer), 满20减5元优惠券(String), 1(Integer), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), null, null, 1(Integer), (String), (String), 10(Integer), 2(Integer), 20.0(Double), 5.0(Double), (String), (String), 0(Integer), (String), 1(Integer), (String), 1(Integer), 10000(Integer), 0(Integer), 0(Integer), 10000(Integer), 0(Integer), null, null, 2(String), null, null, null
2019-06-18 00:35:03,574 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:35:04,963 [http-nio-8080-exec-6] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:04,964 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:35:04,972 [http-nio-8080-exec-6] <==      Total: 14
2019-06-18 00:35:04,991 [http-nio-8080-exec-6] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:04,991 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 00:35:04,992 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:35:04,992 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:35:04,997 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:35:04,999 [http-nio-8080-exec-6] <==      Total: 14
2019-06-18 00:35:05,022 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 00:35:05,023 [http-nio-8080-exec-3] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:35:05,030 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 00:35:05,030 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:35:05,031 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:35:05,036 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:35:05,054 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 00:35:05,055 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:35:05,064 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:35:06,382 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:06,383 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:35:06,390 [http-nio-8080-exec-7] <==      Total: 14
2019-06-18 00:35:06,411 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 00:35:06,411 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:06,411 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:35:06,412 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:35:06,418 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:35:06,419 [http-nio-8080-exec-7] <==      Total: 14
2019-06-18 00:35:06,438 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,438 [http-nio-8080-exec-1] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 00:35:06,439 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:35:06,439 [http-nio-8080-exec-9] ==> Parameters: 33097601(String)
2019-06-18 00:35:06,446 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,446 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 00:35:06,458 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,459 [http-nio-8080-exec-9] ==> Parameters: 22113901(String)
2019-06-18 00:35:06,478 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,498 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,499 [http-nio-8080-exec-9] ==> Parameters: 33096401(String)
2019-06-18 00:35:06,519 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,538 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,539 [http-nio-8080-exec-9] ==> Parameters: 33111001(String)
2019-06-18 00:35:06,559 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,578 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,579 [http-nio-8080-exec-9] ==> Parameters: 18888888(String)
2019-06-18 00:35:06,599 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,618 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,619 [http-nio-8080-exec-9] ==> Parameters: 33074881(String)
2019-06-18 00:35:06,639 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,663 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,663 [http-nio-8080-exec-9] ==> Parameters: 62549174(String)
2019-06-18 00:35:06,682 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,702 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,702 [http-nio-8080-exec-9] ==> Parameters: addsf(String)
2019-06-18 00:35:06,722 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,742 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,743 [http-nio-8080-exec-9] ==> Parameters: gzxxx(String)
2019-06-18 00:35:06,767 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,790 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,791 [http-nio-8080-exec-9] ==> Parameters: 22060081(String)
2019-06-18 00:35:06,810 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,830 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,831 [http-nio-8080-exec-9] ==> Parameters: 31120907(String)
2019-06-18 00:35:06,851 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,870 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,870 [http-nio-8080-exec-9] ==> Parameters: 33013701(String)
2019-06-18 00:35:06,895 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,914 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,915 [http-nio-8080-exec-9] ==> Parameters: 34140901(String)
2019-06-18 00:35:06,935 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:06,960 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:06,961 [http-nio-8080-exec-9] ==> Parameters: 33112911(String)
2019-06-18 00:35:06,984 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:35:07,003 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:35:07,004 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 00:35:07,012 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:35:07,062 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 00:35:07,063 [http-nio-8080-exec-4] ==> Parameters: 1560789303576581(String), 1560789303576581(String)
2019-06-18 00:35:07,070 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:35:07,246 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:07,247 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:35:07,254 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:35:07,275 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:07,275 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:35:07,284 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:35:07,315 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,315 [http-nio-8080-exec-6] ==> Parameters: 33097601(String)
2019-06-18 00:35:07,339 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,360 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,360 [http-nio-8080-exec-6] ==> Parameters: 22113901(String)
2019-06-18 00:35:07,378 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,399 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,400 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:35:07,418 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,438 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,439 [http-nio-8080-exec-6] ==> Parameters: 33111001(String)
2019-06-18 00:35:07,458 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,480 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,480 [http-nio-8080-exec-6] ==> Parameters: 18888888(String)
2019-06-18 00:35:07,503 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,522 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,523 [http-nio-8080-exec-6] ==> Parameters: 33074881(String)
2019-06-18 00:35:07,543 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,562 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,563 [http-nio-8080-exec-6] ==> Parameters: 62549174(String)
2019-06-18 00:35:07,582 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,603 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,604 [http-nio-8080-exec-6] ==> Parameters: addsf(String)
2019-06-18 00:35:07,624 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,642 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,643 [http-nio-8080-exec-6] ==> Parameters: gzxxx(String)
2019-06-18 00:35:07,663 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,685 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,686 [http-nio-8080-exec-6] ==> Parameters: 22060081(String)
2019-06-18 00:35:07,707 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,727 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,727 [http-nio-8080-exec-6] ==> Parameters: 31120907(String)
2019-06-18 00:35:07,748 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,767 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,767 [http-nio-8080-exec-6] ==> Parameters: 33013701(String)
2019-06-18 00:35:07,787 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,806 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,807 [http-nio-8080-exec-6] ==> Parameters: 34140901(String)
2019-06-18 00:35:07,827 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,846 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:07,846 [http-nio-8080-exec-6] ==> Parameters: 33112911(String)
2019-06-18 00:35:07,869 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:07,891 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:35:07,892 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:35:07,900 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:35:10,854 [http-nio-8080-exec-1] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:35:10,855 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:35:10,863 [http-nio-8080-exec-1] <==      Total: 5
2019-06-18 00:35:12,078 [http-nio-8080-exec-3] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:35:12,079 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:35:12,088 [http-nio-8080-exec-3] <==      Total: 5
2019-06-18 00:35:12,855 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:35:12,855 [http-nio-8080-exec-7] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:35:12,855 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:35:12,856 [http-nio-8080-exec-4] ==> Parameters: 1560789303576581(String)
2019-06-18 00:35:12,886 [http-nio-8080-exec-7] <==      Total: 5
2019-06-18 00:35:12,895 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:35:12,916 [http-nio-8080-exec-4] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:35:12,917 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:35:12,925 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:35:12,947 [http-nio-8080-exec-4] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:35:12,948 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:35:12,957 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:35:13,015 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,019 [http-nio-8080-exec-4] ==> Parameters: 156078931301197299(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:35:13.011(Timestamp), null
2019-06-18 00:35:13,038 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,039 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,040 [http-nio-8080-exec-4] ==> Parameters: 156078931303943445(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:35:13.039(Timestamp), null
2019-06-18 00:35:13,062 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,063 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,064 [http-nio-8080-exec-4] ==> Parameters: 156078931306391514(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:35:13.063(Timestamp), null
2019-06-18 00:35:13,087 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,088 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,090 [http-nio-8080-exec-4] ==> Parameters: 156078931308898133(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:35:13.088(Timestamp), null
2019-06-18 00:35:13,114 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,116 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,118 [http-nio-8080-exec-4] ==> Parameters: 156078931311582669(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:35:13.115(Timestamp), null
2019-06-18 00:35:13,138 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,139 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,140 [http-nio-8080-exec-4] ==> Parameters: 156078931313926369(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:35:13.139(Timestamp), null
2019-06-18 00:35:13,158 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,159 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,159 [http-nio-8080-exec-4] ==> Parameters: 156078931315964956(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:35:13.159(Timestamp), null
2019-06-18 00:35:13,179 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,179 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,179 [http-nio-8080-exec-4] ==> Parameters: 156078931317996126(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:35:13.179(Timestamp), null
2019-06-18 00:35:13,198 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,199 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,200 [http-nio-8080-exec-4] ==> Parameters: 156078931319964127(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:35:13.199(Timestamp), null
2019-06-18 00:35:13,222 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,223 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,224 [http-nio-8080-exec-4] ==> Parameters: 156078931322330320(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:35:13.223(Timestamp), null
2019-06-18 00:35:13,242 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,243 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,244 [http-nio-8080-exec-4] ==> Parameters: 156078931324365383(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:35:13.243(Timestamp), null
2019-06-18 00:35:13,262 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,264 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,265 [http-nio-8080-exec-4] ==> Parameters: 156078931326360955(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:35:13.264(Timestamp), null
2019-06-18 00:35:13,286 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,287 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,288 [http-nio-8080-exec-4] ==> Parameters: 156078931328773315(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:35:13.287(Timestamp), null
2019-06-18 00:35:13,306 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,307 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,308 [http-nio-8080-exec-4] ==> Parameters: 156078931330760328(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:35:13.307(Timestamp), null
2019-06-18 00:35:13,326 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,327 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,328 [http-nio-8080-exec-4] ==> Parameters: 156078931332751802(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:35:13.327(Timestamp), null
2019-06-18 00:35:13,346 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,347 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,348 [http-nio-8080-exec-4] ==> Parameters: 156078931334743071(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:35:13.347(Timestamp), null
2019-06-18 00:35:13,367 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,368 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,369 [http-nio-8080-exec-4] ==> Parameters: 156078931336843853(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:35:13.368(Timestamp), null
2019-06-18 00:35:13,387 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,387 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,387 [http-nio-8080-exec-4] ==> Parameters: 156078931338743112(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:35:13.387(Timestamp), null
2019-06-18 00:35:13,406 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,406 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,407 [http-nio-8080-exec-4] ==> Parameters: 156078931340682256(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:35:13.406(Timestamp), null
2019-06-18 00:35:13,431 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,431 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,431 [http-nio-8080-exec-4] ==> Parameters: 156078931343113755(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:35:13.431(Timestamp), null
2019-06-18 00:35:13,450 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,451 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,451 [http-nio-8080-exec-4] ==> Parameters: 156078931345146895(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:35:13.451(Timestamp), null
2019-06-18 00:35:13,474 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,475 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,476 [http-nio-8080-exec-4] ==> Parameters: 156078931347543255(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:35:13.475(Timestamp), null
2019-06-18 00:35:13,499 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,499 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,499 [http-nio-8080-exec-4] ==> Parameters: 156078931349983822(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:35:13.499(Timestamp), null
2019-06-18 00:35:13,523 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,523 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,524 [http-nio-8080-exec-4] ==> Parameters: 156078931352324342(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:35:13.523(Timestamp), null
2019-06-18 00:35:13,542 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,543 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:35:13,543 [http-nio-8080-exec-4] ==> Parameters: 156078931354391490(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:35:13.543(Timestamp), null
2019-06-18 00:35:13,562 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,565 [http-nio-8080-exec-4] ==>  Preparing: update couponsgroup t SET Id = ?, GroupCode = ?, CouponsType = ?, CouponsName = ?, ValidityType = ?, EffectiveDate = ?, ExpireDate = ?, CanUsePeriodType = ?, WeekDays = ?, TimePeriod = ?, LimitNum = ?, ReductionType = ?, InitialAmount = ?, ReductionPrice = ?, FilmCodes = ?, GoodsCodes = ?, IsShare = ?, Remark = ?, CanUseCinemaType = ?, CinemaCodes = ?, Status = ?, CouponsNumber = ?, IssuedNumber = ?, FetchNumber = ?, RemainingNumber = ?, UsedNumber = ?, GiftType = ?, UpdateDate = ? where t.id = ? 
2019-06-18 00:35:13,566 [http-nio-8080-exec-4] ==> Parameters: 60(Long), 1560789303576581(String), 1(Integer), 满20减5元优惠券(String), 1(Integer), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1(Integer), (String), (String), 10(Integer), 2(Integer), 20.0(Double), 5.0(Double), (String), (String), 0(Integer), (String), 1(Integer), (String), 1(Integer), 10000(Integer), 25(Integer), 25(Integer), 9975(Integer), 0(Integer), 2(String), 2019-06-18 00:35:13.563(Timestamp), 60(Long)
2019-06-18 00:35:13,573 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:13,634 [http-nio-8080-exec-4] ==>  Preparing: insert into coupondistributionrecord(Id, GroupCode, CustomerType, OpenID, Issuer, IssuedNumber, IssuedTime, Status) values(?, ?, ?, ?, ?, ?, now(), ?) 
2019-06-18 00:35:13,636 [http-nio-8080-exec-4] ==> Parameters: null, 1560789303576581(String), 1(Integer), (String), admin(String), 25(Integer), 1(Integer)
2019-06-18 00:35:13,655 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:35:15,006 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:15,007 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:35:15,014 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:35:15,035 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 00:35:15,035 [http-nio-8080-exec-8] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:15,035 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:35:15,035 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:35:15,040 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:35:15,043 [http-nio-8080-exec-8] <==      Total: 14
2019-06-18 00:35:15,058 [http-nio-8080-exec-10] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 00:35:15,060 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:35:15,070 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,071 [http-nio-8080-exec-6] ==> Parameters: 33097601(String)
2019-06-18 00:35:15,072 [http-nio-8080-exec-10] <==      Total: 10
2019-06-18 00:35:15,083 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,102 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,103 [http-nio-8080-exec-6] ==> Parameters: 22113901(String)
2019-06-18 00:35:15,123 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,142 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,143 [http-nio-8080-exec-6] ==> Parameters: 33096401(String)
2019-06-18 00:35:15,163 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,182 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,183 [http-nio-8080-exec-6] ==> Parameters: 33111001(String)
2019-06-18 00:35:15,205 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,223 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,224 [http-nio-8080-exec-6] ==> Parameters: 18888888(String)
2019-06-18 00:35:15,243 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,263 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,263 [http-nio-8080-exec-6] ==> Parameters: 33074881(String)
2019-06-18 00:35:15,282 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,303 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,303 [http-nio-8080-exec-6] ==> Parameters: 62549174(String)
2019-06-18 00:35:15,325 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,346 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,347 [http-nio-8080-exec-6] ==> Parameters: addsf(String)
2019-06-18 00:35:15,374 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,394 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,396 [http-nio-8080-exec-6] ==> Parameters: gzxxx(String)
2019-06-18 00:35:15,419 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,438 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,439 [http-nio-8080-exec-6] ==> Parameters: 22060081(String)
2019-06-18 00:35:15,460 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,476 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,477 [http-nio-8080-exec-6] ==> Parameters: 31120907(String)
2019-06-18 00:35:15,499 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,518 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,519 [http-nio-8080-exec-6] ==> Parameters: 33013701(String)
2019-06-18 00:35:15,539 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,558 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,560 [http-nio-8080-exec-6] ==> Parameters: 34140901(String)
2019-06-18 00:35:15,579 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,599 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:35:15,600 [http-nio-8080-exec-6] ==> Parameters: 33112911(String)
2019-06-18 00:35:15,619 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:35:15,639 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:35:15,640 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:35:15,646 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:35:15,682 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 00:35:15,683 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581(String), 1560789303576581(String)
2019-06-18 00:35:15,689 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:35:15,710 [http-nio-8080-exec-3] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 00:35:15,711 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581(String), 1560789303576581(String), 0(Integer), 10(Integer)
2019-06-18 00:35:15,720 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:35:24,764 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:24,765 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:35:24,781 [http-nio-8080-exec-7] <==      Total: 14
2019-06-18 00:35:24,814 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:24,814 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:35:24,852 [http-nio-8080-exec-7] <==      Total: 14
2019-06-18 00:35:53,623 [http-nio-8080-exec-6] ==>  Preparing: insert into couponsgroup(GroupCode, CouponsType, CouponsName, ValidityType, EffectiveDate, ExpireDate, EffectiveDays, ValidityDays, CanUsePeriodType, WeekDays, TimePeriod, LimitNum, ReductionType, initialAmount, ReductionPrice, FilmCodes, GoodsCodes, IsShare, Remark, CanUseCinemaType, CinemaCodes, Status, CouponsNumber, IssuedNumber, FetchNumber, RemainingNumber, UsedNumber, SendGroupNumber, SendNumber, GiftType, CreateDate, UpdateDate,IsUseChatRoom) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?) 
2019-06-18 00:35:53,624 [http-nio-8080-exec-6] ==> Parameters: 1560789353743900(String), 1(Integer), 5元影片优惠券(String), 1(Integer), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), null, null, 1(Integer), (String), (String), 10(Integer), 1(Integer), 0.0(Double), 5.0(Double), (String), (String), 0(Integer), (String), 1(Integer), (String), 1(Integer), 1000(Integer), 0(Integer), 0(Integer), 1000(Integer), 0(Integer), null, null, 2(String), null, null, null
2019-06-18 00:35:53,643 [http-nio-8080-exec-6] <==    Updates: 1
2019-06-18 00:35:54,994 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:54,995 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:35:55,004 [http-nio-8080-exec-5] <==      Total: 14
2019-06-18 00:35:55,023 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 00:35:55,023 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:35:55,024 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:35:55,024 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:35:55,029 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:35:55,031 [http-nio-8080-exec-5] <==      Total: 14
2019-06-18 00:35:55,046 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 00:35:55,047 [http-nio-8080-exec-4] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:35:55,053 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 00:35:55,053 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 00:35:55,053 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:35:55,058 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:35:55,078 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 00:35:55,079 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:35:55,085 [http-nio-8080-exec-9] <==      Total: 2
2019-06-18 00:36:28,907 [http-nio-8080-exec-2] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:36:28,908 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 00:36:28,915 [http-nio-8080-exec-2] <==      Total: 14
2019-06-18 00:36:28,935 [http-nio-8080-exec-2] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:36:28,935 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 00:36:28,942 [http-nio-8080-exec-2] <==      Total: 14
2019-06-18 00:36:28,970 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:28,971 [http-nio-8080-exec-8] ==> Parameters: 33097601(String)
2019-06-18 00:36:28,990 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,010 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,011 [http-nio-8080-exec-8] ==> Parameters: 22113901(String)
2019-06-18 00:36:29,031 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,050 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,051 [http-nio-8080-exec-8] ==> Parameters: 33096401(String)
2019-06-18 00:36:29,071 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,092 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,093 [http-nio-8080-exec-8] ==> Parameters: 33111001(String)
2019-06-18 00:36:29,115 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,135 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,136 [http-nio-8080-exec-8] ==> Parameters: 18888888(String)
2019-06-18 00:36:29,157 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,175 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,176 [http-nio-8080-exec-8] ==> Parameters: 33074881(String)
2019-06-18 00:36:29,195 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,215 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,215 [http-nio-8080-exec-8] ==> Parameters: 62549174(String)
2019-06-18 00:36:29,235 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,255 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,256 [http-nio-8080-exec-8] ==> Parameters: addsf(String)
2019-06-18 00:36:29,276 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,297 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,299 [http-nio-8080-exec-8] ==> Parameters: gzxxx(String)
2019-06-18 00:36:29,323 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,342 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,343 [http-nio-8080-exec-8] ==> Parameters: 22060081(String)
2019-06-18 00:36:29,363 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,382 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,383 [http-nio-8080-exec-8] ==> Parameters: 31120907(String)
2019-06-18 00:36:29,403 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,422 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,423 [http-nio-8080-exec-8] ==> Parameters: 33013701(String)
2019-06-18 00:36:29,443 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,463 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,464 [http-nio-8080-exec-8] ==> Parameters: 34140901(String)
2019-06-18 00:36:29,483 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,503 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:29,503 [http-nio-8080-exec-8] ==> Parameters: 33112911(String)
2019-06-18 00:36:29,523 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:36:29,543 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:36:29,544 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 00:36:29,554 [http-nio-8080-exec-8] <==      Total: 2
2019-06-18 00:36:32,471 [http-nio-8080-exec-5] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:36:32,472 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:36:32,482 [http-nio-8080-exec-5] <==      Total: 5
2019-06-18 00:36:34,653 [http-nio-8080-exec-4] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:36:34,656 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:36:34,668 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:36:35,349 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:36:35,349 [http-nio-8080-exec-3] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:36:35,350 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:36:35,350 [http-nio-8080-exec-10] ==> Parameters: 1560789353743900(String)
2019-06-18 00:36:35,357 [http-nio-8080-exec-3] <==      Total: 5
2019-06-18 00:36:35,357 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:36:35,386 [http-nio-8080-exec-10] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:36:35,387 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:36:35,393 [http-nio-8080-exec-10] <==      Total: 5
2019-06-18 00:36:35,410 [http-nio-8080-exec-10] ==>  Preparing: select * from ticketusers t 
2019-06-18 00:36:35,411 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:36:35,417 [http-nio-8080-exec-10] <==      Total: 5
2019-06-18 00:36:35,455 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,456 [http-nio-8080-exec-10] ==> Parameters: 156078939545487637(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:36:35.454(Timestamp), null
2019-06-18 00:36:35,478 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,480 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,480 [http-nio-8080-exec-10] ==> Parameters: 156078939547924307(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:36:35.479(Timestamp), null
2019-06-18 00:36:35,503 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,503 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,504 [http-nio-8080-exec-10] ==> Parameters: 156078939550354569(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:36:35.503(Timestamp), null
2019-06-18 00:36:35,522 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,522 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,523 [http-nio-8080-exec-10] ==> Parameters: 156078939552242948(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:36:35.522(Timestamp), null
2019-06-18 00:36:35,547 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,547 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,548 [http-nio-8080-exec-10] ==> Parameters: 156078939554714286(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:36:35.547(Timestamp), null
2019-06-18 00:36:35,567 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,567 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,568 [http-nio-8080-exec-10] ==> Parameters: 156078939556770088(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:36:35.567(Timestamp), null
2019-06-18 00:36:35,587 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,588 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,588 [http-nio-8080-exec-10] ==> Parameters: 156078939558878016(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:36:35.588(Timestamp), null
2019-06-18 00:36:35,607 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,608 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,609 [http-nio-8080-exec-10] ==> Parameters: 156078939560822943(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:36:35.608(Timestamp), null
2019-06-18 00:36:35,631 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,631 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,632 [http-nio-8080-exec-10] ==> Parameters: 156078939563156997(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:36:35.631(Timestamp), null
2019-06-18 00:36:35,651 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,652 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,652 [http-nio-8080-exec-10] ==> Parameters: 156078939565298135(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:36:35.652(Timestamp), null
2019-06-18 00:36:35,675 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,675 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,675 [http-nio-8080-exec-10] ==> Parameters: 156078939567594450(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:36:35.675(Timestamp), null
2019-06-18 00:36:35,695 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,695 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,695 [http-nio-8080-exec-10] ==> Parameters: 156078939569515067(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:36:35.695(Timestamp), null
2019-06-18 00:36:35,714 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,715 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,715 [http-nio-8080-exec-10] ==> Parameters: 156078939571528861(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:36:35.715(Timestamp), null
2019-06-18 00:36:35,734 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,735 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,736 [http-nio-8080-exec-10] ==> Parameters: 156078939573586357(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:36:35.735(Timestamp), null
2019-06-18 00:36:35,757 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,758 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,760 [http-nio-8080-exec-10] ==> Parameters: 156078939575849108(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:36:35.758(Timestamp), null
2019-06-18 00:36:35,779 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,780 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,780 [http-nio-8080-exec-10] ==> Parameters: 156078939577912404(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:36:35.779(Timestamp), null
2019-06-18 00:36:35,799 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,801 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,802 [http-nio-8080-exec-10] ==> Parameters: 156078939580055541(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:36:35.8(Timestamp), null
2019-06-18 00:36:35,823 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,823 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,824 [http-nio-8080-exec-10] ==> Parameters: 156078939582377857(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:36:35.823(Timestamp), null
2019-06-18 00:36:35,843 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,843 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,844 [http-nio-8080-exec-10] ==> Parameters: 156078939584362544(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:36:35.843(Timestamp), null
2019-06-18 00:36:35,863 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,863 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,863 [http-nio-8080-exec-10] ==> Parameters: 156078939586388039(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:36:35.863(Timestamp), null
2019-06-18 00:36:35,883 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,884 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,884 [http-nio-8080-exec-10] ==> Parameters: 156078939588446788(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 00:36:35.884(Timestamp), null
2019-06-18 00:36:35,903 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,904 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,904 [http-nio-8080-exec-10] ==> Parameters: 156078939590449658(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 00:36:35.904(Timestamp), null
2019-06-18 00:36:35,923 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,924 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,925 [http-nio-8080-exec-10] ==> Parameters: 156078939592457703(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 00:36:35.924(Timestamp), null
2019-06-18 00:36:35,943 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,944 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,945 [http-nio-8080-exec-10] ==> Parameters: 156078939594426935(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 00:36:35.944(Timestamp), null
2019-06-18 00:36:35,963 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,964 [http-nio-8080-exec-10] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 00:36:35,966 [http-nio-8080-exec-10] ==> Parameters: 156078939596498502(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 00:36:35.964(Timestamp), null
2019-06-18 00:36:35,987 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:35,989 [http-nio-8080-exec-10] ==>  Preparing: update couponsgroup t SET Id = ?, GroupCode = ?, CouponsType = ?, CouponsName = ?, ValidityType = ?, EffectiveDate = ?, ExpireDate = ?, CanUsePeriodType = ?, WeekDays = ?, TimePeriod = ?, LimitNum = ?, ReductionType = ?, InitialAmount = ?, ReductionPrice = ?, FilmCodes = ?, GoodsCodes = ?, IsShare = ?, Remark = ?, CanUseCinemaType = ?, CinemaCodes = ?, Status = ?, CouponsNumber = ?, IssuedNumber = ?, FetchNumber = ?, RemainingNumber = ?, UsedNumber = ?, GiftType = ?, UpdateDate = ? where t.id = ? 
2019-06-18 00:36:35,991 [http-nio-8080-exec-10] ==> Parameters: 61(Long), 1560789353743900(String), 1(Integer), 5元影片优惠券(String), 1(Integer), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1(Integer), (String), (String), 10(Integer), 1(Integer), 0.0(Double), 5.0(Double), (String), (String), 0(Integer), (String), 1(Integer), (String), 1(Integer), 10000(Integer), 25(Integer), 25(Integer), 9975(Integer), 0(Integer), 2(String), 2019-06-18 00:36:35.988(Timestamp), 61(Long)
2019-06-18 00:36:36,002 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:36,064 [http-nio-8080-exec-10] ==>  Preparing: insert into coupondistributionrecord(Id, GroupCode, CustomerType, OpenID, Issuer, IssuedNumber, IssuedTime, Status) values(?, ?, ?, ?, ?, ?, now(), ?) 
2019-06-18 00:36:36,064 [http-nio-8080-exec-10] ==> Parameters: null, 1560789353743900(String), 1(Integer), (String), admin(String), 25(Integer), 1(Integer)
2019-06-18 00:36:36,082 [http-nio-8080-exec-10] <==    Updates: 1
2019-06-18 00:36:37,484 [http-nio-8080-exec-9] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:36:37,485 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 00:36:37,499 [http-nio-8080-exec-9] <==      Total: 14
2019-06-18 00:36:37,523 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 00:36:37,523 [http-nio-8080-exec-9] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:36:37,524 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 00:36:37,524 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:36:37,531 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:36:37,532 [http-nio-8080-exec-9] <==      Total: 14
2019-06-18 00:36:37,550 [http-nio-8080-exec-1] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 00:36:37,552 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:36:37,558 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,558 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 00:36:37,558 [http-nio-8080-exec-5] ==> Parameters: 33097601(String)
2019-06-18 00:36:37,567 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,586 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,587 [http-nio-8080-exec-5] ==> Parameters: 22113901(String)
2019-06-18 00:36:37,615 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,634 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,635 [http-nio-8080-exec-5] ==> Parameters: 33096401(String)
2019-06-18 00:36:37,655 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,675 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,675 [http-nio-8080-exec-5] ==> Parameters: 33111001(String)
2019-06-18 00:36:37,695 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,715 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,716 [http-nio-8080-exec-5] ==> Parameters: 18888888(String)
2019-06-18 00:36:37,739 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,759 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,760 [http-nio-8080-exec-5] ==> Parameters: 33074881(String)
2019-06-18 00:36:37,783 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,805 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,806 [http-nio-8080-exec-5] ==> Parameters: 62549174(String)
2019-06-18 00:36:37,827 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,847 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,848 [http-nio-8080-exec-5] ==> Parameters: addsf(String)
2019-06-18 00:36:37,867 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,888 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,889 [http-nio-8080-exec-5] ==> Parameters: gzxxx(String)
2019-06-18 00:36:37,912 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,931 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,931 [http-nio-8080-exec-5] ==> Parameters: 22060081(String)
2019-06-18 00:36:37,952 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:37,971 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:37,972 [http-nio-8080-exec-5] ==> Parameters: 31120907(String)
2019-06-18 00:36:37,991 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:38,011 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:38,012 [http-nio-8080-exec-5] ==> Parameters: 33013701(String)
2019-06-18 00:36:38,031 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:38,051 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:38,053 [http-nio-8080-exec-5] ==> Parameters: 34140901(String)
2019-06-18 00:36:38,071 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:38,091 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:38,092 [http-nio-8080-exec-5] ==> Parameters: 33112911(String)
2019-06-18 00:36:38,113 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:36:38,131 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:36:38,132 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 00:36:38,140 [http-nio-8080-exec-5] <==      Total: 2
2019-06-18 00:36:38,183 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 00:36:38,184 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String)
2019-06-18 00:36:38,190 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:36:38,211 [http-nio-8080-exec-3] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 00:36:38,212 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 00:36:38,221 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:36:46,107 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:36:46,109 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:36:46,116 [http-nio-8080-exec-7] <==      Total: 14
2019-06-18 00:36:46,131 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 00:36:46,131 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:36:46,132 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 00:36:46,132 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 00:36:46,138 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:36:46,147 [http-nio-8080-exec-2] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 00:36:46,147 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:36:46,148 [http-nio-8080-exec-7] <==      Total: 14
2019-06-18 00:36:46,153 [http-nio-8080-exec-2] <==      Total: 10
2019-06-18 00:36:46,170 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,171 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 00:36:46,195 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,214 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,215 [http-nio-8080-exec-4] ==> Parameters: 22113901(String)
2019-06-18 00:36:46,235 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,255 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,255 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:36:46,277 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,299 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,300 [http-nio-8080-exec-4] ==> Parameters: 33111001(String)
2019-06-18 00:36:46,327 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,347 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,348 [http-nio-8080-exec-4] ==> Parameters: 18888888(String)
2019-06-18 00:36:46,367 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,387 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,388 [http-nio-8080-exec-4] ==> Parameters: 33074881(String)
2019-06-18 00:36:46,415 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,435 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,436 [http-nio-8080-exec-4] ==> Parameters: 62549174(String)
2019-06-18 00:36:46,456 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,475 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,476 [http-nio-8080-exec-4] ==> Parameters: addsf(String)
2019-06-18 00:36:46,497 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,520 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,521 [http-nio-8080-exec-4] ==> Parameters: gzxxx(String)
2019-06-18 00:36:46,539 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,571 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,571 [http-nio-8080-exec-4] ==> Parameters: 22060081(String)
2019-06-18 00:36:46,591 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,611 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,612 [http-nio-8080-exec-4] ==> Parameters: 31120907(String)
2019-06-18 00:36:46,631 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,651 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,651 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 00:36:46,671 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,691 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,691 [http-nio-8080-exec-4] ==> Parameters: 34140901(String)
2019-06-18 00:36:46,711 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,731 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:36:46,731 [http-nio-8080-exec-4] ==> Parameters: 33112911(String)
2019-06-18 00:36:46,747 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:36:46,768 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:36:46,768 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:36:46,777 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:36:46,819 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 00:36:46,820 [http-nio-8080-exec-8] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String)
2019-06-18 00:36:46,826 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:36:46,847 [http-nio-8080-exec-8] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 00:36:46,849 [http-nio-8080-exec-8] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 00:36:46,855 [http-nio-8080-exec-8] <==      Total: 2
2019-06-18 00:37:50,255 [http-nio-8080-exec-9] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:37:50,257 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 00:37:50,282 [http-nio-8080-exec-9] <==      Total: 14
2019-06-18 00:37:50,300 [http-nio-8080-exec-9] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:37:50,300 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 00:37:50,300 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 00:37:50,300 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 00:37:50,307 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:37:50,317 [http-nio-8080-exec-9] <==      Total: 14
2019-06-18 00:37:50,327 [http-nio-8080-exec-4] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 00:37:50,328 [http-nio-8080-exec-4] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:37:50,335 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,336 [http-nio-8080-exec-1] ==> Parameters: 33097601(String)
2019-06-18 00:37:50,339 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 00:37:50,344 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,367 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,368 [http-nio-8080-exec-1] ==> Parameters: 22113901(String)
2019-06-18 00:37:50,388 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,408 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,408 [http-nio-8080-exec-1] ==> Parameters: 33096401(String)
2019-06-18 00:37:50,428 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,448 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,448 [http-nio-8080-exec-1] ==> Parameters: 33111001(String)
2019-06-18 00:37:50,480 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,499 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,499 [http-nio-8080-exec-1] ==> Parameters: 18888888(String)
2019-06-18 00:37:50,542 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,573 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,573 [http-nio-8080-exec-1] ==> Parameters: 33074881(String)
2019-06-18 00:37:50,593 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,612 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,612 [http-nio-8080-exec-1] ==> Parameters: 62549174(String)
2019-06-18 00:37:50,632 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,651 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,652 [http-nio-8080-exec-1] ==> Parameters: addsf(String)
2019-06-18 00:37:50,672 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,691 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,692 [http-nio-8080-exec-1] ==> Parameters: gzxxx(String)
2019-06-18 00:37:50,712 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,731 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,732 [http-nio-8080-exec-1] ==> Parameters: 22060081(String)
2019-06-18 00:37:50,752 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,773 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,773 [http-nio-8080-exec-1] ==> Parameters: 31120907(String)
2019-06-18 00:37:50,792 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,813 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,814 [http-nio-8080-exec-1] ==> Parameters: 33013701(String)
2019-06-18 00:37:50,836 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,855 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,855 [http-nio-8080-exec-1] ==> Parameters: 34140901(String)
2019-06-18 00:37:50,883 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,903 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:37:50,904 [http-nio-8080-exec-1] ==> Parameters: 33112911(String)
2019-06-18 00:37:50,928 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:50,947 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:37:50,948 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 00:37:50,955 [http-nio-8080-exec-1] <==      Total: 2
2019-06-18 00:37:50,995 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 00:37:50,996 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String)
2019-06-18 00:37:51,002 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:37:51,023 [http-nio-8080-exec-3] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 00:37:51,024 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 00:37:51,030 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 00:37:54,995 [http-nio-8080-exec-3] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:37:54,996 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:37:55,006 [http-nio-8080-exec-3] <==      Total: 14
2019-06-18 00:37:55,020 [http-nio-8080-exec-3] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 00:37:55,021 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 00:37:55,029 [http-nio-8080-exec-3] <==      Total: 14
2019-06-18 00:37:55,043 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 00:37:55,043 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 00:37:55,048 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 00:37:55,049 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:37:55,049 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 00:37:55,056 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:37:55,065 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 00:37:55,065 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 00:37:55,065 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:37:55,065 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 00:37:55,075 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 00:37:55,075 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 00:37:56,535 [http-nio-8080-exec-9] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:37:56,536 [http-nio-8080-exec-9] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:37:56,555 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,576 [http-nio-8080-exec-9] ==>  Preparing: select * from CinemaMiniProgramAccounts where AppId=? and IsDel=0 
2019-06-18 00:37:56,577 [http-nio-8080-exec-9] ==> Parameters: wx8079e2f2a9958d05(String)
2019-06-18 00:37:56,585 [http-nio-8080-exec-9] <==      Total: 8
2019-06-18 00:37:56,604 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:56,606 [http-nio-8080-exec-9] ==> Parameters: 33111001(String)
2019-06-18 00:37:56,614 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,637 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:56,639 [http-nio-8080-exec-9] ==> Parameters: 33111001(String)
2019-06-18 00:37:56,651 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,672 [http-nio-8080-exec-9] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:37:56,673 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 5(String), 1(String)
2019-06-18 00:37:56,692 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,712 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:37:56,713 [http-nio-8080-exec-9] ==> Parameters: 1560578073jzkeu(String)
2019-06-18 00:37:56,720 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,739 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:37:56,740 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 33111001(String)
2019-06-18 00:37:56,747 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,764 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:56,764 [http-nio-8080-exec-9] ==> Parameters: 33096401(String)
2019-06-18 00:37:56,771 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,788 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:56,789 [http-nio-8080-exec-9] ==> Parameters: 33096401(String)
2019-06-18 00:37:56,804 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,824 [http-nio-8080-exec-9] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:37:56,824 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 2(String), 1(String)
2019-06-18 00:37:56,833 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,851 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:37:56,851 [http-nio-8080-exec-9] ==> Parameters: 1560789086rrmbi(String)
2019-06-18 00:37:56,859 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,879 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:37:56,881 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:37:56,889 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,911 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:56,913 [http-nio-8080-exec-9] ==> Parameters: 18888888(String)
2019-06-18 00:37:56,921 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:56,939 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:56,940 [http-nio-8080-exec-9] ==> Parameters: 18888888(String)
2019-06-18 00:37:56,946 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:37:56,967 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:37:56,968 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 18888888(String)
2019-06-18 00:37:56,988 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,007 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:57,008 [http-nio-8080-exec-9] ==> Parameters: 33074881(String)
2019-06-18 00:37:57,016 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,036 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:57,037 [http-nio-8080-exec-9] ==> Parameters: 33074881(String)
2019-06-18 00:37:57,044 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:37:57,063 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:37:57,065 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 33074881(String)
2019-06-18 00:37:57,072 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,092 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:57,093 [http-nio-8080-exec-9] ==> Parameters: 22060081(String)
2019-06-18 00:37:57,100 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,120 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:57,121 [http-nio-8080-exec-9] ==> Parameters: 22060081(String)
2019-06-18 00:37:57,128 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:37:57,148 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:37:57,149 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 22060081(String)
2019-06-18 00:37:57,157 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,176 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:57,176 [http-nio-8080-exec-9] ==> Parameters: 33013701(String)
2019-06-18 00:37:57,183 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,200 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:57,201 [http-nio-8080-exec-9] ==> Parameters: 33013701(String)
2019-06-18 00:37:57,206 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:37:57,228 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:37:57,229 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 33013701(String)
2019-06-18 00:37:57,236 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,259 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:57,260 [http-nio-8080-exec-9] ==> Parameters: 31120907(String)
2019-06-18 00:37:57,270 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,288 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:57,288 [http-nio-8080-exec-9] ==> Parameters: 31120907(String)
2019-06-18 00:37:57,294 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:37:57,315 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:37:57,316 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 31120907(String)
2019-06-18 00:37:57,323 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,344 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:57,345 [http-nio-8080-exec-9] ==> Parameters: 34140901(String)
2019-06-18 00:37:57,351 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,371 [http-nio-8080-exec-9] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:57,371 [http-nio-8080-exec-9] ==> Parameters: 34140901(String)
2019-06-18 00:37:57,377 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:57,395 [http-nio-8080-exec-9] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:37:57,396 [http-nio-8080-exec-9] ==> Parameters: 34140901(String), 5(String), 1(String)
2019-06-18 00:37:57,402 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:37:57,419 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:37:57,420 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 34140901(String)
2019-06-18 00:37:57,427 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:37:58,519 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:37:58,521 [http-nio-8080-exec-7] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:37:58,527 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,535 [http-nio-8080-exec-7] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:58,536 [http-nio-8080-exec-7] ==> Parameters: 33013701(String)
2019-06-18 00:37:58,544 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:37:58,544 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:37:58,545 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,546 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:37:58,546 [http-nio-8080-exec-1] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:37:58,554 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:37:58,555 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:37:58,555 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:37:58,556 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 2019-06-18 00:37:58(String)
2019-06-18 00:37:58,578 [http-nio-8080-exec-1] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:58,578 [http-nio-8080-exec-5] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:37:58,579 [http-nio-8080-exec-5] ==> Parameters: 33013701(String)
2019-06-18 00:37:58,580 [http-nio-8080-exec-1] ==> Parameters: 33013701(String)
2019-06-18 00:37:58,581 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 00:37:58,592 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:37:58,592 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:37:58,600 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:37:58,600 [http-nio-8080-exec-5] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:37:58,600 [http-nio-8080-exec-1] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:37:58,601 [http-nio-8080-exec-5] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:37:58,601 [http-nio-8080-exec-7] ==> Parameters: 33013701(String)
2019-06-18 00:37:58,603 [http-nio-8080-exec-1] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:37:58,608 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:37:58,608 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:37:58,610 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:37:58,628 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:37:58,629 [http-nio-8080-exec-7] ==> Parameters: 001107832017(String)
2019-06-18 00:37:58,636 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,644 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:37:58,645 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 001107832017(String), 2019-06-18 00:37:58(String)
2019-06-18 00:37:58,668 [http-nio-8080-exec-7] <==      Total: 5
2019-06-18 00:37:58,689 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:37:58,691 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:37:58,698 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,712 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:37:58,713 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:37:58,719 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,736 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:37:58,736 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:37:58,742 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,751 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:37:58,752 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:37:58,758 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,779 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:37:58,780 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:37:58,787 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,807 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:37:58,808 [http-nio-8080-exec-7] ==> Parameters: 012100992019(String)
2019-06-18 00:37:58,814 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,835 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:37:58,836 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 012100992019(String), 2019-06-18 00:37:58(String)
2019-06-18 00:37:58,860 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 00:37:58,879 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:37:58,880 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:37:58,887 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:37:58,907 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:37:58,909 [http-nio-8080-exec-7] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:37:58,915 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:38:05,769 [http-nio-8080-exec-9] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-06-18 00:38:05,770 [http-nio-8080-exec-9] ==> Parameters: 33097601(String)
2019-06-18 00:38:05,775 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:38:05,796 [http-nio-8080-exec-9] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-06-18 00:38:05,797 [http-nio-8080-exec-9] ==> Parameters: 2(Long)
2019-06-18 00:38:05,806 [http-nio-8080-exec-9] <==      Total: 28
2019-06-18 00:38:05,923 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-06-18 00:38:05,924 [taskExecutor-1] ==> Parameters: 2(Long), 登陆(String), true(Boolean), null
2019-06-18 00:38:05,955 [taskExecutor-1] <==    Updates: 1
2019-06-18 00:38:06,152 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-06-18 00:38:06,153 [http-nio-8080-exec-2] ==> Parameters: 2(Long)
2019-06-18 00:38:06,168 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:38:09,703 [http-nio-8080-exec-3] ==>  Preparing: select * from registeractive t where t.cinemacode = ? 
2019-06-18 00:38:09,703 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 00:38:09,704 [http-nio-8080-exec-3] ==> Parameters: 33097601(String)
2019-06-18 00:38:09,704 [http-nio-8080-exec-6] ==> Parameters: 33097601(String)
2019-06-18 00:38:09,713 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:38:09,713 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:38:09,734 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 00:38:09,735 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 00:38:09,753 [http-nio-8080-exec-6] <==      Total: 2
2019-06-18 00:38:10,916 [http-nio-8080-exec-7] ==>  Preparing: select * from registeractivecoupons where registerActiveCode = ? 
2019-06-18 00:38:10,917 [http-nio-8080-exec-7] ==> Parameters: 1558944670818(String)
2019-06-18 00:38:10,933 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:12,678 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:54:12,679 [http-nio-8080-exec-7] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:54:12,694 [http-nio-8080-exec-9] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:54:12,695 [http-nio-8080-exec-9] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:54:12,701 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:12,704 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:54:12,727 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:54:12,727 [http-nio-8080-exec-7] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:54:12,729 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:54:12,729 [http-nio-8080-exec-9] ==> Parameters: 33096401(String)
2019-06-18 00:54:12,739 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:12,739 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:54:12,758 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:54:12,758 [http-nio-8080-exec-9] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:54:12,760 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 2019-06-18 00:54:12(String)
2019-06-18 00:54:12,761 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:54:12,771 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:54:12,777 [http-nio-8080-exec-7] <==      Total: 7
2019-06-18 00:54:12,790 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:54:12,792 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:54:12,801 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:12,824 [http-nio-8080-exec-7] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:54:12,826 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:54:12,832 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 00:54:12,850 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:12,851 [http-nio-8080-exec-7] ==> Parameters: 001100072019(String)
2019-06-18 00:54:12,874 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:12,893 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:12,894 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:54:12(String)
2019-06-18 00:54:12,921 [http-nio-8080-exec-7] <==      Total: 6
2019-06-18 00:54:12,944 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:12,945 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:12,954 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:12,974 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:12,975 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:12,982 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,002 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,003 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:13,010 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,031 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,031 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:13,039 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,060 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,061 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:13,068 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,090 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,092 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:13,098 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,118 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:13,119 [http-nio-8080-exec-7] ==> Parameters: 001102962019(String)
2019-06-18 00:54:13,133 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,154 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:13,155 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:54:12(String)
2019-06-18 00:54:13,168 [http-nio-8080-exec-7] <==      Total: 3
2019-06-18 00:54:13,186 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,187 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:13,193 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,211 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,211 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:13,219 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,245 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,246 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:13,254 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,274 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:13,275 [http-nio-8080-exec-7] ==> Parameters: 001109582018(String)
2019-06-18 00:54:13,294 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,314 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:13,316 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:54:12(String)
2019-06-18 00:54:13,332 [http-nio-8080-exec-7] <==      Total: 5
2019-06-18 00:54:13,352 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,353 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:13,361 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,382 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,383 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:13,391 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,410 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,411 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:13,418 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,445 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,446 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:13,455 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,474 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,483 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:13,492 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,510 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:13,510 [http-nio-8080-exec-7] ==> Parameters: 001109642018(String)
2019-06-18 00:54:13,517 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,535 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:13,536 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:54:12(String)
2019-06-18 00:54:13,552 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,575 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,575 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:13,581 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,597 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:13,598 [http-nio-8080-exec-7] ==> Parameters: 051200852019(String)
2019-06-18 00:54:13,605 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,623 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:13,623 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:54:12(String)
2019-06-18 00:54:13,641 [http-nio-8080-exec-7] <==      Total: 3
2019-06-18 00:54:13,662 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,663 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:13,671 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,690 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,690 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:13,697 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,714 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,714 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:13,720 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,739 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:13,740 [http-nio-8080-exec-7] ==> Parameters: 051200922019(String)
2019-06-18 00:54:13,747 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,766 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:13,766 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:54:12(String)
2019-06-18 00:54:13,780 [http-nio-8080-exec-7] <==      Total: 3
2019-06-18 00:54:13,800 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,800 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:13,806 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,826 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,827 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:13,834 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,854 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,856 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:13,865 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,886 [http-nio-8080-exec-7] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:13,887 [http-nio-8080-exec-7] ==> Parameters: 051201002019(String)
2019-06-18 00:54:13,895 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,914 [http-nio-8080-exec-7] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:13,915 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:54:12(String)
2019-06-18 00:54:13,930 [http-nio-8080-exec-7] <==      Total: 9
2019-06-18 00:54:13,955 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,956 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:13,964 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:13,973 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:13,973 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:13,982 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:14,002 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:14,003 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:14,009 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:14,022 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:14,023 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:14,030 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:14,047 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:14,049 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:14,055 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:14,074 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:14,075 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:14,082 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:14,102 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:14,103 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:14,110 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:14,130 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:14,131 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:14,139 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:14,158 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:14,159 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:14,168 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:54:26,934 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:54:26,934 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:54:26,935 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:54:26,935 [http-nio-8080-exec-1] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:54:26,944 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:54:26,950 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:26,973 [http-nio-8080-exec-1] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:54:26,973 [http-nio-8080-exec-5] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:54:26,974 [http-nio-8080-exec-1] ==> Parameters: 33096401(String)
2019-06-18 00:54:26,974 [http-nio-8080-exec-5] ==> Parameters: 33096401(String)
2019-06-18 00:54:26,981 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:26,983 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:54:26,998 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:54:26,998 [http-nio-8080-exec-1] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:54:26,999 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:54:26,999 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 2019-06-18 00:54:26(String)
2019-06-18 00:54:27,011 [http-nio-8080-exec-5] <==      Total: 7
2019-06-18 00:54:27,014 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 00:54:27,030 [http-nio-8080-exec-5] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:54:27,031 [http-nio-8080-exec-5] ==> Parameters: 33096401(String)
2019-06-18 00:54:27,037 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,046 [http-nio-8080-exec-5] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:54:27,047 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:54:27,052 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 00:54:27,069 [http-nio-8080-exec-5] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:27,070 [http-nio-8080-exec-5] ==> Parameters: 001100072019(String)
2019-06-18 00:54:27,091 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,109 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:27,110 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:54:26(String)
2019-06-18 00:54:27,123 [http-nio-8080-exec-5] <==      Total: 6
2019-06-18 00:54:27,142 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,142 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:27,154 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,175 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,176 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:27,181 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,190 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,190 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:27,196 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,214 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,214 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:27,220 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,230 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,230 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:27,235 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,255 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,256 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:54:27,261 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,282 [http-nio-8080-exec-5] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:27,283 [http-nio-8080-exec-5] ==> Parameters: 001102962019(String)
2019-06-18 00:54:27,289 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,311 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:27,311 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:54:26(String)
2019-06-18 00:54:27,325 [http-nio-8080-exec-5] <==      Total: 3
2019-06-18 00:54:27,342 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,343 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:27,348 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,367 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,367 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:27,373 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,390 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,391 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:27,396 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,414 [http-nio-8080-exec-5] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:27,415 [http-nio-8080-exec-5] ==> Parameters: 001109582018(String)
2019-06-18 00:54:27,438 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,461 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:27,461 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:54:26(String)
2019-06-18 00:54:27,476 [http-nio-8080-exec-5] <==      Total: 5
2019-06-18 00:54:27,494 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,495 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:27,502 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,522 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,523 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:27,530 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,550 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,551 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:27,558 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,586 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,587 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:27,595 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,614 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,615 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:27,621 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,642 [http-nio-8080-exec-5] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:27,643 [http-nio-8080-exec-5] ==> Parameters: 001109642018(String)
2019-06-18 00:54:27,653 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,674 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:27,675 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:54:26(String)
2019-06-18 00:54:27,689 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,706 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,706 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:27,715 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,734 [http-nio-8080-exec-5] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:27,735 [http-nio-8080-exec-5] ==> Parameters: 051200852019(String)
2019-06-18 00:54:27,742 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,758 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:27,759 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:54:26(String)
2019-06-18 00:54:27,776 [http-nio-8080-exec-5] <==      Total: 3
2019-06-18 00:54:27,795 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,795 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:27,801 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,822 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,822 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:54:27,828 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,846 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,847 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:54:27,854 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,860 [http-nio-8080-exec-5] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:27,862 [http-nio-8080-exec-5] ==> Parameters: 051200922019(String)
2019-06-18 00:54:27,872 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,894 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:27,895 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:54:26(String)
2019-06-18 00:54:27,909 [http-nio-8080-exec-5] <==      Total: 3
2019-06-18 00:54:27,930 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,931 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:27,939 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:27,973 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:27,973 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:27,979 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,001 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,001 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:28,007 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,026 [http-nio-8080-exec-5] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:54:28,026 [http-nio-8080-exec-5] ==> Parameters: 051201002019(String)
2019-06-18 00:54:28,033 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,050 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:54:28,051 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:54:26(String)
2019-06-18 00:54:28,066 [http-nio-8080-exec-5] <==      Total: 9
2019-06-18 00:54:28,087 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,088 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:28,094 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,114 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,115 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:28,120 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,139 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,139 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:28,144 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,162 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,163 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:28,169 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,185 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,186 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:28,191 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,210 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,210 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:28,216 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,234 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,235 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:28,242 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,262 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,263 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:54:28,269 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:54:28,290 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:54:28,290 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:54:28,296 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:07,738 [http-nio-8080-exec-3] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:07,741 [http-nio-8080-exec-3] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:07,769 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:07,787 [http-nio-8080-exec-3] ==>  Preparing: select * from CinemaMiniProgramAccounts where AppId=? and IsDel=0 
2019-06-18 00:55:07,788 [http-nio-8080-exec-3] ==> Parameters: wx8079e2f2a9958d05(String)
2019-06-18 00:55:07,794 [http-nio-8080-exec-3] <==      Total: 8
2019-06-18 00:55:07,815 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:07,816 [http-nio-8080-exec-3] ==> Parameters: 33111001(String)
2019-06-18 00:55:07,824 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:07,844 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:07,845 [http-nio-8080-exec-3] ==> Parameters: 33111001(String)
2019-06-18 00:55:07,852 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:07,870 [http-nio-8080-exec-3] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:55:07,871 [http-nio-8080-exec-3] ==> Parameters: 33111001(String), 5(String), 1(String)
2019-06-18 00:55:07,878 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:07,898 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:55:07,899 [http-nio-8080-exec-3] ==> Parameters: 1560578073jzkeu(String)
2019-06-18 00:55:07,910 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:07,935 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:07,935 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33111001(String)
2019-06-18 00:55:07,941 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:07,968 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:07,969 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:55:07,976 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:07,994 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:07,994 [http-nio-8080-exec-3] ==> Parameters: 33096401(String)
2019-06-18 00:55:08,000 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,018 [http-nio-8080-exec-3] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:55:08,019 [http-nio-8080-exec-3] ==> Parameters: 33096401(String), 2(String), 1(String)
2019-06-18 00:55:08,026 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,046 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardcreditrule t where t.rulecode = ? and t.status =1 
2019-06-18 00:55:08,047 [http-nio-8080-exec-3] ==> Parameters: 1560789086rrmbi(String)
2019-06-18 00:55:08,055 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,074 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:08,075 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:55:08,082 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,099 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:08,100 [http-nio-8080-exec-3] ==> Parameters: 18888888(String)
2019-06-18 00:55:08,109 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,118 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:08,119 [http-nio-8080-exec-3] ==> Parameters: 18888888(String)
2019-06-18 00:55:08,125 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:55:08,147 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:08,148 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 18888888(String)
2019-06-18 00:55:08,169 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,190 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:08,191 [http-nio-8080-exec-3] ==> Parameters: 33074881(String)
2019-06-18 00:55:08,199 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,218 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:08,218 [http-nio-8080-exec-3] ==> Parameters: 33074881(String)
2019-06-18 00:55:08,223 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:55:08,238 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:08,239 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33074881(String)
2019-06-18 00:55:08,247 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,266 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:08,267 [http-nio-8080-exec-3] ==> Parameters: 22060081(String)
2019-06-18 00:55:08,278 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,298 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:08,299 [http-nio-8080-exec-3] ==> Parameters: 22060081(String)
2019-06-18 00:55:08,306 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:55:08,326 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:08,328 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 22060081(String)
2019-06-18 00:55:08,336 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,358 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:08,359 [http-nio-8080-exec-3] ==> Parameters: 33013701(String)
2019-06-18 00:55:08,366 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,387 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:08,388 [http-nio-8080-exec-3] ==> Parameters: 33013701(String)
2019-06-18 00:55:08,394 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:55:08,414 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:08,415 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33013701(String)
2019-06-18 00:55:08,429 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,446 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:08,447 [http-nio-8080-exec-3] ==> Parameters: 31120907(String)
2019-06-18 00:55:08,454 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,463 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:08,463 [http-nio-8080-exec-3] ==> Parameters: 31120907(String)
2019-06-18 00:55:08,469 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:55:08,490 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:08,492 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 31120907(String)
2019-06-18 00:55:08,501 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,510 [http-nio-8080-exec-3] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:08,511 [http-nio-8080-exec-3] ==> Parameters: 34140901(String)
2019-06-18 00:55:08,519 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,543 [http-nio-8080-exec-3] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:08,543 [http-nio-8080-exec-3] ==> Parameters: 34140901(String)
2019-06-18 00:55:08,562 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:08,576 [http-nio-8080-exec-3] ==>  Preparing: select * from choosemembercardcreditrule t where t.cinemacode =? and t.levelcode =? and ruletype = ? 
2019-06-18 00:55:08,576 [http-nio-8080-exec-3] ==> Parameters: 34140901(String), 5(String), 1(String)
2019-06-18 00:55:08,584 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 00:55:08,592 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:08,592 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 34140901(String)
2019-06-18 00:55:08,602 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:09,691 [http-nio-8080-exec-2] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:09,691 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:09,693 [http-nio-8080-exec-2] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:09,693 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:09,698 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,700 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:55:09,706 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:09,707 [http-nio-8080-exec-6] ==> Parameters: 33013701(String)
2019-06-18 00:55:09,712 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:09,712 [http-nio-8080-exec-2] ==> Parameters: 33013701(String)
2019-06-18 00:55:09,714 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,722 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:55:09,722 [http-nio-8080-exec-10] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:09,722 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:55:09,722 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 2019-06-18 00:55:09(String)
2019-06-18 00:55:09,722 [http-nio-8080-exec-10] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:09,736 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:55:09,737 [http-nio-8080-exec-6] <==      Total: 2
2019-06-18 00:55:09,738 [http-nio-8080-exec-2] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:55:09,739 [http-nio-8080-exec-2] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:55:09,752 [http-nio-8080-exec-10] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:09,752 [http-nio-8080-exec-6] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:09,752 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 00:55:09,753 [http-nio-8080-exec-6] ==> Parameters: 33013701(String)
2019-06-18 00:55:09,753 [http-nio-8080-exec-10] ==> Parameters: 33013701(String)
2019-06-18 00:55:09,761 [http-nio-8080-exec-6] <==      Total: 0
2019-06-18 00:55:09,761 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:55:09,772 [http-nio-8080-exec-10] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:55:09,772 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:09,773 [http-nio-8080-exec-6] ==> Parameters: 001107832017(String)
2019-06-18 00:55:09,773 [http-nio-8080-exec-10] ==> Parameters: 33013701(String), 33013701(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:55:09,778 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:55:09,778 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,787 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:09,787 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 001107832017(String), 2019-06-18 00:55:09(String)
2019-06-18 00:55:09,802 [http-nio-8080-exec-6] <==      Total: 5
2019-06-18 00:55:09,822 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:09,823 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:55:09,829 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,855 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:09,856 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:55:09,864 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,882 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:09,883 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:55:09,890 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,910 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:09,911 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:55:09,917 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,935 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:09,936 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 0000000000000004(String)
2019-06-18 00:55:09,942 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,962 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:09,964 [http-nio-8080-exec-6] ==> Parameters: 012100992019(String)
2019-06-18 00:55:09,971 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:09,991 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:09,992 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 012100992019(String), 2019-06-18 00:55:09(String)
2019-06-18 00:55:10,009 [http-nio-8080-exec-6] <==      Total: 2
2019-06-18 00:55:10,031 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:10,032 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:55:10,039 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:10,060 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:10,060 [http-nio-8080-exec-6] ==> Parameters: 33013701(String), 0000000000000006(String)
2019-06-18 00:55:10,065 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 00:55:22,295 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:22,295 [http-nio-8080-exec-8] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:22,296 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:22,296 [http-nio-8080-exec-8] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:22,305 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,305 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:55:22,325 [http-nio-8080-exec-4] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:22,325 [http-nio-8080-exec-8] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:22,326 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:55:22,326 [http-nio-8080-exec-8] ==> Parameters: 33096401(String)
2019-06-18 00:55:22,334 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,334 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 00:55:22,343 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.CCode = ? and t.StartTime>=? GROUP BY filmcode 
2019-06-18 00:55:22,343 [http-nio-8080-exec-8] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:55:22,344 [http-nio-8080-exec-8] ==> Parameters: 33096401(String), 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:55:22,345 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 2019-06-18 00:55:22(String)
2019-06-18 00:55:22,352 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 00:55:22,358 [http-nio-8080-exec-4] <==      Total: 7
2019-06-18 00:55:22,371 [http-nio-8080-exec-4] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and isonlineopencard = 1 
2019-06-18 00:55:22,371 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:55:22,377 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,387 [http-nio-8080-exec-4] ==>  Preparing: select * from membercardcreditrule t where t.cinemacode = ? and (t.levelcode = ? or find_in_set(?,t.levelcode)) and t.ruletype =2 and t.status =1 
2019-06-18 00:55:22,388 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 2(String), 2(String)
2019-06-18 00:55:22,394 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:55:22,414 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:22,416 [http-nio-8080-exec-4] ==> Parameters: 001100072019(String)
2019-06-18 00:55:22,435 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,450 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:22,451 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 001100072019(String), 2019-06-18 00:55:22(String)
2019-06-18 00:55:22,465 [http-nio-8080-exec-4] <==      Total: 6
2019-06-18 00:55:22,486 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,487 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:55:22,493 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,514 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,514 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:55:22,519 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,538 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,539 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:55:22,546 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,566 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,566 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:55:22,572 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,590 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,591 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:55:22,596 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,614 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,615 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000004(String)
2019-06-18 00:55:22,621 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,640 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:22,641 [http-nio-8080-exec-4] ==> Parameters: 001102962019(String)
2019-06-18 00:55:22,649 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,670 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:22,672 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 001102962019(String), 2019-06-18 00:55:22(String)
2019-06-18 00:55:22,689 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:55:22,711 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,712 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:55:22,718 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,726 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,727 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:55:22,737 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,759 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,759 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:55:22,765 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,782 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:22,782 [http-nio-8080-exec-4] ==> Parameters: 001109582018(String)
2019-06-18 00:55:22,802 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,825 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:22,825 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 001109582018(String), 2019-06-18 00:55:22(String)
2019-06-18 00:55:22,841 [http-nio-8080-exec-4] <==      Total: 5
2019-06-18 00:55:22,862 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,863 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:55:22,871 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,891 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,892 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:55:22,899 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,918 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,919 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:55:22,924 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,946 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,947 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:55:22,954 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:22,974 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:22,975 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:55:22,988 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,006 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:23,007 [http-nio-8080-exec-4] ==> Parameters: 001109642018(String)
2019-06-18 00:55:23,014 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,034 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:23,035 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 001109642018(String), 2019-06-18 00:55:22(String)
2019-06-18 00:55:23,049 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,071 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,072 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:55:23,081 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,099 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:23,100 [http-nio-8080-exec-4] ==> Parameters: 051200852019(String)
2019-06-18 00:55:23,110 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,131 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:23,132 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 051200852019(String), 2019-06-18 00:55:22(String)
2019-06-18 00:55:23,148 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:55:23,166 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,167 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:55:23,174 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,194 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,194 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000002(String)
2019-06-18 00:55:23,200 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,218 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,218 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000001(String)
2019-06-18 00:55:23,224 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,242 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:23,242 [http-nio-8080-exec-4] ==> Parameters: 051200922019(String)
2019-06-18 00:55:23,248 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,269 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:23,269 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 051200922019(String), 2019-06-18 00:55:22(String)
2019-06-18 00:55:23,283 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 00:55:23,302 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,302 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:23,312 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,330 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,331 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:23,338 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,358 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,359 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:23,366 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,390 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:23,391 [http-nio-8080-exec-4] ==> Parameters: 051201002019(String)
2019-06-18 00:55:23,400 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,415 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? 
2019-06-18 00:55:23,415 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:55:22(String)
2019-06-18 00:55:23,431 [http-nio-8080-exec-4] <==      Total: 9
2019-06-18 00:55:23,451 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,453 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:23,460 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,475 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,475 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:23,480 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,499 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,499 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:23,505 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,523 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,523 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:23,530 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,550 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,551 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:23,558 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,570 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,572 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:23,580 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,602 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,604 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:23,610 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,626 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,627 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:23,636 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:23,658 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:23,660 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:23,667 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:55:26,658 [http-nio-8080-exec-9] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:26,659 [http-nio-8080-exec-9] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:26,664 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:26,682 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:26,683 [http-nio-8080-exec-9] ==> Parameters: 33096401(String)
2019-06-18 00:55:26,690 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:26,710 [http-nio-8080-exec-9] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:55:26,711 [http-nio-8080-exec-9] ==> Parameters: 051201002019(String)
2019-06-18 00:55:26,718 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:26,739 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? group by substr(t.starttime,1,10) 
2019-06-18 00:55:26,739 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18 00:55:26(String)
2019-06-18 00:55:26,756 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:26,775 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode = ? and t.starttime >=now() and substr(t.starttime,1,10) = ? order by t.starttime asc 
2019-06-18 00:55:26,777 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 051201002019(String), 2019-06-18(String)
2019-06-18 00:55:26,792 [http-nio-8080-exec-9] <==      Total: 9
2019-06-18 00:55:26,810 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:26,812 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384429(String)
2019-06-18 00:55:26,834 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:26,855 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:26,855 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:26,860 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:26,879 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:26,879 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 6号厅(String), 2019-06-18 10:30:00(String)
2019-06-18 00:55:26,904 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:26,922 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:26,923 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384435(String)
2019-06-18 00:55:26,939 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:26,958 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:26,959 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:26,966 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:26,986 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:26,987 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 6号厅(String), 2019-06-18 13:10:00(String)
2019-06-18 00:55:27,006 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:27,026 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:27,027 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384440(String)
2019-06-18 00:55:27,043 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,062 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:27,063 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:27,069 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,080 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:27,081 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 6号厅(String), 2019-06-18 15:15:00(String)
2019-06-18 00:55:27,102 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:27,110 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:27,112 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384444(String)
2019-06-18 00:55:27,130 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,162 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:27,163 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:27,169 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,179 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:27,180 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 6号厅(String), 2019-06-18 17:20:00(String)
2019-06-18 00:55:27,205 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:27,227 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:27,228 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384447(String)
2019-06-18 00:55:27,244 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,263 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:27,264 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:27,270 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,300 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:27,301 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3号厅(String), 2019-06-18 18:15:00(String)
2019-06-18 00:55:27,320 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:27,338 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:27,338 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384450(String)
2019-06-18 00:55:27,354 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,374 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:27,376 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:27,382 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,402 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:27,403 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 6号厅(String), 2019-06-18 19:25:00(String)
2019-06-18 00:55:27,426 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:27,449 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:27,449 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384452(String)
2019-06-18 00:55:27,469 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,490 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:27,492 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:27,499 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,519 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:27,520 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3号厅(String), 2019-06-18 20:20:00(String)
2019-06-18 00:55:27,538 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:27,559 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:27,559 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384455(String)
2019-06-18 00:55:27,576 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,595 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:27,596 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000005(String)
2019-06-18 00:55:27,610 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,631 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:27,632 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 6号厅(String), 2019-06-18 21:30:00(String)
2019-06-18 00:55:27,652 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:27,674 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 00:55:27,674 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3384457(String)
2019-06-18 00:55:27,692 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,710 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:27,710 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:27,716 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:55:27,734 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 00:55:27,735 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 3号厅(String), 2019-06-18 22:25:00(String)
2019-06-18 00:55:27,754 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 00:55:31,550 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:31,551 [http-nio-8080-exec-7] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:31,557 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:55:31,571 [http-nio-8080-exec-7] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:31,571 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:31,571 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 00:55:31,571 [http-nio-8080-exec-1] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:31,577 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:55:31,577 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:55:31,587 [http-nio-8080-exec-7] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:55:31,587 [http-nio-8080-exec-1] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:31,587 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:31,587 [http-nio-8080-exec-1] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:55:31,593 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:55:31,593 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:55:31,610 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.userid=? and t.ccode = ? and t.scode=? 
2019-06-18 00:55:31,610 [http-nio-8080-exec-7] ==>  Preparing: select * from screenseatinfo t where t.CinemaCode = ? and t.ScreenCode = ? 
2019-06-18 00:55:31,611 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:55:31,611 [http-nio-8080-exec-1] ==> Parameters: 12(Long), 33096401(String), 3384452(String)
2019-06-18 00:55:31,625 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:55:31,632 [http-nio-8080-exec-7] <==      Total: 133
2019-06-18 00:55:34,442 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:34,445 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:34,471 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:34,663 [http-nio-8080-exec-5] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:34,663 [http-nio-8080-exec-5] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:55:34,671 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:34,687 [http-nio-8080-exec-5] ==>  Preparing: select * from sessioninfo t where t.userid=? and t.ccode = ? and t.scode=? 
2019-06-18 00:55:34,689 [http-nio-8080-exec-5] ==> Parameters: 12(Long), 33096401(String), 3384452(String)
2019-06-18 00:55:34,697 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:34,739 [http-nio-8080-exec-5] ==>  Preparing: select * from screenseatinfo t where t.cinemacode = ? and t.screencode=? and t.seatcode=? 
2019-06-18 00:55:34,741 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000003(String), 118180(String)
2019-06-18 00:55:34,748 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:35,679 [http-nio-8080-exec-5] ==>  Preparing: insert into orders(Id, CinemaCode, UserId, SessionCode, ScreenCode, SessionTime, FilmCode, FilmName, TicketCount, TotalPrice, TotalFee, TotalSalePrice, OrderStatus, MobilePhone, LockTime, AutoUnlockDatetime, LockOrderCode, SubmitTime, SubmitOrderCode, PrintNo, VerifyCode, PrintStatus, PrintTime, RefundTime, Created, Updated, Deleted, ErrorMessage, SerialNum, IsMemberPay, PayType, Printpassword, PaySeqNo, IDCardNumber) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:55:35,684 [http-nio-8080-exec-5] ==> Parameters: null, 33096401(String), 12(Long), 3384452(String), 0000000000000003(String), 2019-06-18 20:20:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 1(Integer), 48.0(Double), 0.0(Double), 48.0(Double), 2(Integer), null, 2019-06-18 00:55:35.0(Timestamp), 2019-06-18 01:15:34.0(Timestamp), 1560790534750wvyxomn(String), null, null, null, null, null, null, null, 2019-06-18 00:55:34.72(Timestamp), null, 0(Integer), null, null, 0(Integer), null, null, null, null
2019-06-18 00:55:35,706 [http-nio-8080-exec-5] <==    Updates: 1
2019-06-18 00:55:35,708 [http-nio-8080-exec-5] ==>  Preparing: select * from orders t where t.cinemacode=? and t.lockordercode = ? 
2019-06-18 00:55:35,711 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:55:35,727 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:35,729 [http-nio-8080-exec-5] ==>  Preparing: insert into orderseatdetails(Id, OrderId, SeatCode, RowNum, ColumnNum, XCoord, YCoord, Price, SalePrice, Fee, AddFee,CinemaAllowance,FilmTicketCode, TicketInfoCode, PrintFlag, SeatId, Created, Updated, Deleted) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?) 
2019-06-18 00:55:35,733 [http-nio-8080-exec-5] ==> Parameters: null, 1721(Long), 118180(String), 1(String), 14(String), 1(Integer), 14(Integer), 58.0(Double), 58.0(Double), 0.0(Double), 10.0(Double), 0.0(Double), null, null, null, null, 2019-06-18 00:55:34.72(Timestamp), null, 0(Integer)
2019-06-18 00:55:35,754 [http-nio-8080-exec-5] <==    Updates: 1
2019-06-18 00:55:35,819 [http-nio-8080-exec-5] ==>  Preparing: select * from orders t where t.lockordercode = ? 
2019-06-18 00:55:35,819 [http-nio-8080-exec-5] ==> Parameters: 1560790534750wvyxomn(String)
2019-06-18 00:55:35,842 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:35,871 [http-nio-8080-exec-5] ==>  Preparing: update orders t SET Id = ?, CinemaCode = ?, UserId = ?, SessionCode = ?, ScreenCode = ?, SessionTime = ?, FilmCode = ?, FilmName = ?, TicketCount = ?, TotalPrice = ?, TotalFee = ?, TotalSalePrice = ?, OrderStatus = ?, LockTime = ?, AutoUnlockDatetime = ?, LockOrderCode = ?, Created = ?, Deleted = ?, IsMemberPay = ?, OpenID = ? where t.id = ? 
2019-06-18 00:55:35,872 [http-nio-8080-exec-5] ==> Parameters: 1721(Long), 33096401(String), 12(Long), 3384452(String), 0000000000000003(String), 2019-06-18 20:20:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 1(Integer), 48.0(Double), 0.0(Double), 48.0(Double), 2(Integer), 2019-06-18 00:55:35.0(Timestamp), 2019-06-18 01:15:34.0(Timestamp), 1560790534750wvyxomn(String), 2019-06-18 00:55:34.0(Timestamp), 0(Integer), 0(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1721(Long)
2019-06-18 00:55:35,883 [http-nio-8080-exec-5] <==    Updates: 1
2019-06-18 00:55:35,903 [http-nio-8080-exec-5] ==>  Preparing: select * from coupons t where t.openid = ? and t.status = ? group by groupcode 
2019-06-18 00:55:35,903 [http-nio-8080-exec-5] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1(Integer)
2019-06-18 00:55:35,912 [http-nio-8080-exec-5] <==      Total: 2
2019-06-18 00:55:35,931 [http-nio-8080-exec-5] ==>  Preparing: select * from coupons t where t.couponscode = ? 
2019-06-18 00:55:35,932 [http-nio-8080-exec-5] ==> Parameters: 156078931301197299(String)
2019-06-18 00:55:35,939 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:35,960 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:55:35,961 [http-nio-8080-exec-5] ==> Parameters: 1560789303576581(String)
2019-06-18 00:55:35,972 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:36,207 [http-nio-8080-exec-5] ==>  Preparing: select * from coupons t where t.couponscode = ? 
2019-06-18 00:55:36,207 [http-nio-8080-exec-5] ==> Parameters: 156078939545487637(String)
2019-06-18 00:55:36,213 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:36,231 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:55:36,232 [http-nio-8080-exec-5] ==> Parameters: 1560789353743900(String)
2019-06-18 00:55:36,239 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:55:37,024 [http-nio-8080-exec-3] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:37,024 [http-nio-8080-exec-10] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:55:37,025 [http-nio-8080-exec-10] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:37,025 [http-nio-8080-exec-3] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:55:37,031 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:55:37,031 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:37,041 [http-nio-8080-exec-10] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:55:37,041 [http-nio-8080-exec-3] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:55:37,041 [http-nio-8080-exec-10] ==> Parameters: 33096401(String)
2019-06-18 00:55:37,041 [http-nio-8080-exec-3] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:55:37,049 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:55:37,049 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 00:55:37,075 [http-nio-8080-exec-10] ==>  Preparing: select * from membercard t where (t.cinemacode = ? or find_in_set(?,t.cinemacodes)) and t.openid = ? and t.status =1 
2019-06-18 00:55:37,075 [http-nio-8080-exec-3] ==>  Preparing: select * from ticketusers t where t.openid = ? 
2019-06-18 00:55:37,075 [http-nio-8080-exec-10] ==> Parameters: 33096401(String), 33096401(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:55:37,075 [http-nio-8080-exec-3] ==> Parameters: o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String)
2019-06-18 00:55:37,082 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 00:55:37,082 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 00:57:07,751 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:57:07,752 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:57:07,758 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:07,780 [http-nio-8080-exec-4] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:57:07,780 [http-nio-8080-exec-4] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:57:07,786 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:07,807 [http-nio-8080-exec-4] ==>  Preparing: select * from cinemapaymentsettings t where t.cinemacode = ? 
2019-06-18 00:57:07,809 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 00:57:07,819 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:07,860 [http-nio-8080-exec-4] ==>  Preparing: select * from orders t where t.cinemacode=? and t.lockordercode = ? 
2019-06-18 00:57:07,861 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:57:07,879 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:07,881 [http-nio-8080-exec-4] ==>  Preparing: select * from orderseatdetails t where t.orderid = ? 
2019-06-18 00:57:07,882 [http-nio-8080-exec-4] ==> Parameters: 1721(Long)
2019-06-18 00:57:07,894 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:07,980 [http-nio-8080-exec-4] ==>  Preparing: select * from orders t where t.cinemacode=? and t.lockordercode = ? 
2019-06-18 00:57:07,980 [http-nio-8080-exec-4] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:57:07,994 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:07,995 [http-nio-8080-exec-4] ==>  Preparing: select * from orderseatdetails t where t.orderid = ? 
2019-06-18 00:57:07,995 [http-nio-8080-exec-4] ==> Parameters: 1721(Long)
2019-06-18 00:57:08,002 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:08,063 [http-nio-8080-exec-4] ==>  Preparing: select * from goodsorders t where t.localordercode = ? 
2019-06-18 00:57:08,064 [http-nio-8080-exec-4] ==> Parameters: (String)
2019-06-18 00:57:08,070 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:57:08,087 [http-nio-8080-exec-4] ==>  Preparing: select * from goodsorders t where t.localordercode = ? 
2019-06-18 00:57:08,087 [http-nio-8080-exec-4] ==> Parameters: (String)
2019-06-18 00:57:08,093 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:57:08,111 [http-nio-8080-exec-4] ==>  Preparing: select * from coupons t where t.couponscode = ? 
2019-06-18 00:57:08,112 [http-nio-8080-exec-4] ==> Parameters: 156078939545487637(String)
2019-06-18 00:57:08,119 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:08,139 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 00:57:08,140 [http-nio-8080-exec-4] ==> Parameters: 1560789353743900(String)
2019-06-18 00:57:08,151 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:08,171 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.userid=? and t.ccode = ? and t.scode=? 
2019-06-18 00:57:08,173 [http-nio-8080-exec-4] ==> Parameters: 12(Long), 33096401(String), 3384452(String)
2019-06-18 00:57:08,184 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:08,204 [http-nio-8080-exec-4] ==>  Preparing: select * from priceplan where userid=? and CinemaCode=? and (code =? or code=?) 
2019-06-18 00:57:08,206 [http-nio-8080-exec-4] ==> Parameters: 12(Long), 33096401(String), 051201002019(String), 3384452(String)
2019-06-18 00:57:08,212 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 00:57:08,232 [http-nio-8080-exec-4] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:57:08,233 [http-nio-8080-exec-4] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:57:08,239 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 00:57:08,279 [http-nio-8080-exec-4] ==>  Preparing: update orders t SET Id = ?, CinemaCode = ?, UserId = ?, SessionCode = ?, ScreenCode = ?, SessionTime = ?, FilmCode = ?, FilmName = ?, TicketCount = ?, TotalPrice = ?, TotalFee = ?, TotalSalePrice = ?, OrderStatus = ?, LockTime = ?, AutoUnlockDatetime = ?, LockOrderCode = ?, Created = ?, Deleted = ?, IsMemberPay = ?, TotalConponPrice = ?, OpenID = ? where t.id = ? 
2019-06-18 00:57:08,281 [http-nio-8080-exec-4] ==> Parameters: 1721(Long), 33096401(String), 12(Long), 3384452(String), 0000000000000003(String), 2019-06-18 20:20:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 1(Integer), 25.0(Double), 0.0(Double), 58.0(Double), 2(Integer), 2019-06-18 00:55:35.0(Timestamp), 2019-06-18 01:15:34.0(Timestamp), 1560790534750wvyxomn(String), 2019-06-18 00:55:34.0(Timestamp), 0(Integer), 0(Integer), 5.0(Double), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1721(Long)
2019-06-18 00:57:08,289 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:57:08,295 [http-nio-8080-exec-4] ==>  Preparing: update orderseatdetails t SET Id = ?, OrderId = ?, SeatCode = ?, RowNum = ?, ColumnNum = ?, XCoord = ?, YCoord = ?, Price = ?, SalePrice = ?, Fee = ?, Created = ?, Deleted = ?, ConponCode = ?, ConponPrice = ?, CinemaAllowance = ?, AddFee = ? where t.id = ? 
2019-06-18 00:57:08,298 [http-nio-8080-exec-4] ==> Parameters: 1801(Long), 1721(Long), 118180(String), 1(String), 14(String), 1(Integer), 14(Integer), 58.0(Double), 58.0(Double), 0.0(Double), 2019-06-18 00:55:34.0(Timestamp), 0(Integer), 156078939545487637(String), 5.0(Double), 0.0(Double), 10.0(Double), 1801(Long)
2019-06-18 00:57:08,305 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 00:57:08,783 [http-nio-8080-exec-9] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:57:08,785 [http-nio-8080-exec-9] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:57:08,792 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:57:08,807 [http-nio-8080-exec-9] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:57:08,808 [http-nio-8080-exec-9] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:57:08,815 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:57:08,855 [http-nio-8080-exec-9] ==>  Preparing: select * from orders t where t.cinemacode=? and t.lockordercode = ? 
2019-06-18 00:57:08,856 [http-nio-8080-exec-9] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:57:08,872 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:57:08,873 [http-nio-8080-exec-9] ==>  Preparing: select * from orderseatdetails t where t.orderid = ? 
2019-06-18 00:57:08,873 [http-nio-8080-exec-9] ==> Parameters: 1721(Long)
2019-06-18 00:57:08,885 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 00:57:19,032 [http-nio-8080-exec-7] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:57:19,034 [http-nio-8080-exec-7] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:57:19,043 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:57:19,121 [http-nio-8080-exec-7] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:57:19,122 [http-nio-8080-exec-7] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:57:19,132 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:57:19,172 [http-nio-8080-exec-7] ==>  Preparing: select * from orders t where t.cinemacode=? and t.lockordercode = ? 
2019-06-18 00:57:19,172 [http-nio-8080-exec-7] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:57:19,186 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:57:19,186 [http-nio-8080-exec-7] ==>  Preparing: select * from orderseatdetails t where t.orderid = ? 
2019-06-18 00:57:19,186 [http-nio-8080-exec-7] ==> Parameters: 1721(Long)
2019-06-18 00:57:19,193 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 00:57:21,248 [http-nio-8080-exec-7] ==>  Preparing: update orders t SET Id = ?, CinemaCode = ?, UserId = ?, SessionCode = ?, ScreenCode = ?, SessionTime = ?, FilmCode = ?, FilmName = ?, TicketCount = ?, TotalPrice = ?, TotalFee = ?, TotalSalePrice = ?, OrderStatus = ?, MobilePhone = ?, LockTime = ?, AutoUnlockDatetime = ?, LockOrderCode = ?, SubmitTime = ?, SubmitOrderCode = ?, PrintNo = ?, VerifyCode = ?, Created = ?, Updated = ?, Deleted = ?, IsMemberPay = ?, TotalConponPrice = ?, PayFlag = ?, OrderPayType = ?, PayTime = ?, OrderTradeNo = ?, OpenID = ? where t.id = ? 
2019-06-18 00:57:21,252 [http-nio-8080-exec-7] ==> Parameters: 1721(Long), 33096401(String), 12(Long), 3384452(String), 0000000000000003(String), 2019-06-18 20:20:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 1(Integer), 25.0(Double), 0.0(Double), 58.0(Double), 8(Integer), 18770818722(String), 2019-06-18 00:55:35.0(Timestamp), 2019-06-18 01:15:34.0(Timestamp), 1560790534750wvyxomn(String), 2019-06-18 00:57:21.0(Timestamp), 1560790534750wvyxomn(String), 1906180055345680(String), 0000000000345680(String), 2019-06-18 00:55:34.0(Timestamp), 2019-06-18 00:57:21.209(Timestamp), 0(Integer), 0(Integer), 5.0(Double), 1(Integer), 1(Integer), 2019-06-18 00:57:16.0(Timestamp), 4200000308201906182716170961(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1721(Long)
2019-06-18 00:57:21,278 [http-nio-8080-exec-7] <==    Updates: 1
2019-06-18 00:57:21,280 [http-nio-8080-exec-7] ==>  Preparing: update orderseatdetails t SET Id = ?, OrderId = ?, SeatCode = ?, RowNum = ?, ColumnNum = ?, XCoord = ?, YCoord = ?, Price = ?, SalePrice = ?, Fee = ?, Created = ?, Deleted = ?, ConponCode = ?, ConponPrice = ?, CinemaAllowance = ?, AddFee = ? where t.id = ? 
2019-06-18 00:57:21,281 [http-nio-8080-exec-7] ==> Parameters: 1801(Long), 1721(Long), 118180(String), 1(String), 14(String), 1(Integer), 14(Integer), 58.0(Double), 58.0(Double), 0.0(Double), 2019-06-18 00:55:34.0(Timestamp), 0(Integer), 156078939545487637(String), 5.0(Double), 0.0(Double), 10.0(Double), 1801(Long)
2019-06-18 00:57:21,289 [http-nio-8080-exec-7] <==    Updates: 1
2019-06-18 00:57:22,500 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:57:22,500 [http-nio-8080-exec-1] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:57:22,506 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:57:22,536 [http-nio-8080-exec-1] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:57:22,536 [http-nio-8080-exec-1] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:57:22,542 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:57:22,598 [http-nio-8080-exec-1] ==>  Preparing: select * from orders t where t.cinemacode=? and t.lockordercode = ? 
2019-06-18 00:57:22,599 [http-nio-8080-exec-1] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:57:22,616 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:57:22,618 [http-nio-8080-exec-1] ==>  Preparing: select * from orderseatdetails t where t.orderid = ? 
2019-06-18 00:57:22,618 [http-nio-8080-exec-1] ==> Parameters: 1721(Long)
2019-06-18 00:57:22,627 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 00:57:25,874 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:57:25,875 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:57:25,881 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:57:25,900 [http-nio-8080-exec-5] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:57:25,900 [http-nio-8080-exec-5] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:57:25,906 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:57:25,927 [http-nio-8080-exec-5] ==>  Preparing: select * from orders t where t.cinemacode=? and t.submitordercode = ? 
2019-06-18 00:57:25,929 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:57:25,948 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:57:25,959 [http-nio-8080-exec-5] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:57:25,960 [http-nio-8080-exec-5] ==> Parameters: 33096401(String)
2019-06-18 00:57:25,969 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:57:25,987 [http-nio-8080-exec-5] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 00:57:25,989 [http-nio-8080-exec-5] ==> Parameters: 051201002019(String)
2019-06-18 00:57:25,998 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:57:26,019 [http-nio-8080-exec-5] ==>  Preparing: select * from adminorderview t where t.cinemacode = ? and submitordercode = ? 
2019-06-18 00:57:26,020 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:57:26,040 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:57:26,064 [http-nio-8080-exec-5] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 00:57:26,065 [http-nio-8080-exec-5] ==> Parameters: 33096401(String), 0000000000000003(String)
2019-06-18 00:57:26,071 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:57:26,095 [http-nio-8080-exec-5] ==>  Preparing: select * from cinemaview t where t.code = ? 
2019-06-18 00:57:26,097 [http-nio-8080-exec-5] ==> Parameters: 33096401(String)
2019-06-18 00:57:26,104 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 00:57:31,115 [http-nio-8080-exec-2] ==>  Preparing: select * from orders t where t.cinemacode=? and t.printno = ? and t.verifycode=? 
2019-06-18 00:57:31,117 [http-nio-8080-exec-2] ==> Parameters: 33096401(String), 1906180055345680(String), 0000000000345680(String)
2019-06-18 00:57:31,133 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:31,143 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 00:57:31,144 [http-nio-8080-exec-2] ==> Parameters: 33096401(String)
2019-06-18 00:57:31,152 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:31,171 [http-nio-8080-exec-2] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:57:31,171 [http-nio-8080-exec-2] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:57:31,177 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:31,195 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:57:31,196 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:57:31,202 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:31,243 [http-nio-8080-exec-2] ==>  Preparing: select * from orders t where t.cinemacode=? and t.printno = ? and t.verifycode=? 
2019-06-18 00:57:31,244 [http-nio-8080-exec-2] ==> Parameters: 33096401(String), 1906180055345680(String), 0000000000345680(String)
2019-06-18 00:57:31,258 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:31,258 [http-nio-8080-exec-2] ==>  Preparing: select * from orderseatdetails t where t.orderid = ? 
2019-06-18 00:57:31,258 [http-nio-8080-exec-2] ==> Parameters: 1721(Long)
2019-06-18 00:57:31,265 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:32,299 [http-nio-8080-exec-2] ==>  Preparing: update orders t SET Id = ?, CinemaCode = ?, UserId = ?, SessionCode = ?, ScreenCode = ?, SessionTime = ?, FilmCode = ?, FilmName = ?, TicketCount = ?, TotalPrice = ?, TotalFee = ?, TotalSalePrice = ?, OrderStatus = ?, MobilePhone = ?, LockTime = ?, AutoUnlockDatetime = ?, LockOrderCode = ?, SubmitTime = ?, SubmitOrderCode = ?, PrintNo = ?, VerifyCode = ?, RefundTime = ?, Created = ?, Updated = ?, Deleted = ?, IsMemberPay = ?, TotalConponPrice = ?, PayFlag = ?, OrderPayType = ?, PayTime = ?, OrderTradeNo = ?, OpenID = ? where t.id = ? 
2019-06-18 00:57:32,304 [http-nio-8080-exec-2] ==> Parameters: 1721(Long), 33096401(String), 12(Long), 3384452(String), 0000000000000003(String), 2019-06-18 20:20:00.0(Timestamp), 051201002019(String), 黑衣人：全球追缉（数字3D）(3D)(String), 1(Integer), 25.0(Double), 0.0(Double), 58.0(Double), 9(Integer), 18770818722(String), 2019-06-18 00:55:35.0(Timestamp), 2019-06-18 01:15:34.0(Timestamp), 1560790534750wvyxomn(String), 2019-06-18 00:57:21.0(Timestamp), 1560790534750wvyxomn(String), 1906180055345680(String), 0000000000345680(String), 2019-06-18 00:57:32.28(Timestamp), 2019-06-18 00:55:34.0(Timestamp), 2019-06-18 00:57:32.28(Timestamp), 0(Integer), 0(Integer), 5.0(Double), 1(Integer), 1(Integer), 2019-06-18 00:57:16.0(Timestamp), 4200000308201906182716170961(String), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 1721(Long)
2019-06-18 00:57:32,332 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 00:57:32,351 [http-nio-8080-exec-2] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 00:57:32,351 [http-nio-8080-exec-2] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 00:57:32,359 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:32,379 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 00:57:32,380 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33096401(String)
2019-06-18 00:57:32,387 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:32,402 [http-nio-8080-exec-2] ==>  Preparing: select * from cinemapaymentsettings t where t.cinemacode = ? 
2019-06-18 00:57:32,402 [http-nio-8080-exec-2] ==> Parameters: 33096401(String)
2019-06-18 00:57:32,409 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:32,447 [http-nio-8080-exec-2] ==>  Preparing: select * from orders t where t.cinemacode=? and t.lockordercode = ? 
2019-06-18 00:57:32,448 [http-nio-8080-exec-2] ==> Parameters: 33096401(String), 1560790534750wvyxomn(String)
2019-06-18 00:57:32,461 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 00:57:32,461 [http-nio-8080-exec-2] ==>  Preparing: select * from orderseatdetails t where t.orderid = ? 
2019-06-18 00:57:32,462 [http-nio-8080-exec-2] ==> Parameters: 1721(Long)
2019-06-18 00:57:32,468 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 11:53:59,907 [http-nio-8080-exec-1] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 11:54:00,058 [http-nio-8080-exec-1] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 11:54:00,093 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 11:54:00,102 [http-nio-8080-exec-1] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 11:54:00,104 [http-nio-8080-exec-1] ==> Parameters: 33111001(String)
2019-06-18 11:54:00,111 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 11:54:00,119 [http-nio-8080-exec-1] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 11:54:00,121 [http-nio-8080-exec-1] ==> Parameters: 051200852019(String)
2019-06-18 11:54:00,130 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 11:54:00,145 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? group by substr(t.starttime,1,10) 
2019-06-18 11:54:00,150 [http-nio-8080-exec-1] ==> Parameters: 33111001(String), 051200852019(String), 2019-06-18 11:54:00(String)
2019-06-18 11:54:00,172 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 11:54:00,180 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode = ? and t.starttime >=now() and substr(t.starttime,1,10) = ? order by t.starttime asc 
2019-06-18 11:54:00,184 [http-nio-8080-exec-1] ==> Parameters: 33111001(String), 051200852019(String), 2019-06-18(String)
2019-06-18 11:54:00,202 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 11:54:00,210 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 11:54:00,212 [http-nio-8080-exec-1] ==> Parameters: 33111001(String), 1683201906180013(String)
2019-06-18 11:54:00,244 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 11:54:00,251 [http-nio-8080-exec-1] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 11:54:00,253 [http-nio-8080-exec-1] ==> Parameters: 33111001(String), 0000000000000005(String)
2019-06-18 11:54:00,260 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 11:54:00,268 [http-nio-8080-exec-1] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 11:54:00,270 [http-nio-8080-exec-1] ==> Parameters: 33111001(String), 5号厅(String), 2019-06-18 13:10:00(String)
2019-06-18 11:54:00,278 [http-nio-8080-exec-1] <==      Total: 3
2019-06-18 11:54:00,286 [http-nio-8080-exec-1] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 11:54:00,287 [http-nio-8080-exec-1] ==> Parameters: 33111001(String), 1683201906180002(String)
2019-06-18 11:54:00,310 [http-nio-8080-exec-1] <==      Total: 2
2019-06-18 12:00:54,222 [http-nio-8080-exec-2] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 12:00:54,224 [http-nio-8080-exec-2] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 12:00:54,230 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,238 [http-nio-8080-exec-2] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 12:00:54,238 [http-nio-8080-exec-2] ==> Parameters: 33111001(String)
2019-06-18 12:00:54,247 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,255 [http-nio-8080-exec-2] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 12:00:54,255 [http-nio-8080-exec-2] ==> Parameters: 051200852019(String)
2019-06-18 12:00:54,262 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,270 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? group by substr(t.starttime,1,10) 
2019-06-18 12:00:54,270 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 051200852019(String), 2019-06-18 12:00:54(String)
2019-06-18 12:00:54,291 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,299 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode = ? and t.starttime >=now() and substr(t.starttime,1,10) = ? order by t.starttime asc 
2019-06-18 12:00:54,300 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 051200852019(String), 2019-06-18(String)
2019-06-18 12:00:54,322 [http-nio-8080-exec-2] <==      Total: 6
2019-06-18 12:00:54,329 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:00:54,330 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 1683201906180013(String)
2019-06-18 12:00:54,354 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,362 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:00:54,363 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 0000000000000005(String)
2019-06-18 12:00:54,368 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,374 [http-nio-8080-exec-2] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:00:54,375 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 5号厅(String), 2019-06-18 13:10:00(String)
2019-06-18 12:00:54,384 [http-nio-8080-exec-2] <==      Total: 3
2019-06-18 12:00:54,392 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:00:54,393 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 1683201906180002(String)
2019-06-18 12:00:54,414 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,421 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:00:54,421 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 0000000000000003(String)
2019-06-18 12:00:54,426 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,434 [http-nio-8080-exec-2] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:00:54,434 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 9号厅(String), 2019-06-18 14:10:00(String)
2019-06-18 12:00:54,443 [http-nio-8080-exec-2] <==      Total: 3
2019-06-18 12:00:54,450 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:00:54,451 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 1683201906180003(String)
2019-06-18 12:00:54,472 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,482 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:00:54,482 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 0000000000000003(String)
2019-06-18 12:00:54,486 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,492 [http-nio-8080-exec-2] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:00:54,493 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 9号厅(String), 2019-06-18 16:40:00(String)
2019-06-18 12:00:54,501 [http-nio-8080-exec-2] <==      Total: 3
2019-06-18 12:00:54,510 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:00:54,510 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 1683201906180004(String)
2019-06-18 12:00:54,533 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,540 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:00:54,540 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 0000000000000003(String)
2019-06-18 12:00:54,544 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,551 [http-nio-8080-exec-2] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:00:54,552 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 9号厅(String), 2019-06-18 19:10:00(String)
2019-06-18 12:00:54,560 [http-nio-8080-exec-2] <==      Total: 3
2019-06-18 12:00:54,567 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:00:54,568 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 1683201906180016(String)
2019-06-18 12:00:54,588 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,595 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:00:54,596 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 0000000000000005(String)
2019-06-18 12:00:54,600 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,607 [http-nio-8080-exec-2] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:00:54,608 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 5号厅(String), 2019-06-18 20:30:00(String)
2019-06-18 12:00:54,619 [http-nio-8080-exec-2] <==      Total: 3
2019-06-18 12:00:54,626 [http-nio-8080-exec-2] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:00:54,626 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 1683201906180005(String)
2019-06-18 12:00:54,648 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,656 [http-nio-8080-exec-2] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:00:54,658 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 0000000000000003(String)
2019-06-18 12:00:54,664 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:00:54,675 [http-nio-8080-exec-2] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:00:54,677 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 9号厅(String), 2019-06-18 21:35:00(String)
2019-06-18 12:00:54,688 [http-nio-8080-exec-2] <==      Total: 3
2019-06-18 12:02:00,914 [http-nio-8080-exec-4] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 12:02:00,915 [http-nio-8080-exec-4] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 12:02:00,920 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:00,928 [http-nio-8080-exec-4] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 12:02:00,929 [http-nio-8080-exec-4] ==> Parameters: 33111001(String)
2019-06-18 12:02:00,938 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:00,945 [http-nio-8080-exec-4] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 12:02:00,945 [http-nio-8080-exec-4] ==> Parameters: 051201002019(String)
2019-06-18 12:02:00,951 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:00,959 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? group by substr(t.starttime,1,10) 
2019-06-18 12:02:00,960 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 051201002019(String), 2019-06-18 12:02:00(String)
2019-06-18 12:02:00,982 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:00,990 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode = ? and t.starttime >=now() and substr(t.starttime,1,10) = ? order by t.starttime asc 
2019-06-18 12:02:00,990 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 051201002019(String), 2019-06-18(String)
2019-06-18 12:02:01,007 [http-nio-8080-exec-4] <==      Total: 12
2019-06-18 12:02:01,014 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,014 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180022(String)
2019-06-18 12:02:01,035 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,041 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,042 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:02:01,046 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,054 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,054 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 13:00:00(String)
2019-06-18 12:02:01,060 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,066 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,067 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180007(String)
2019-06-18 12:02:01,087 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,095 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,096 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:02:01,100 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,108 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,109 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 13:40:00(String)
2019-06-18 12:02:01,118 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,124 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,125 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180029(String)
2019-06-18 12:02:01,146 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,154 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,154 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:02:01,159 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,167 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,167 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 14:20:00(String)
2019-06-18 12:02:01,175 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,183 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,184 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180023(String)
2019-06-18 12:02:01,205 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,213 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,213 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:02:01,218 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,226 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,226 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 15:10:00(String)
2019-06-18 12:02:01,235 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,241 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,242 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180008(String)
2019-06-18 12:02:01,264 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,271 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,272 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:02:01,277 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,284 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,284 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 16:30:00(String)
2019-06-18 12:02:01,292 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,299 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,300 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180024(String)
2019-06-18 12:02:01,322 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,329 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,330 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:02:01,338 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,346 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,346 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 17:20:00(String)
2019-06-18 12:02:01,354 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,361 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,362 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180031(String)
2019-06-18 12:02:01,385 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,393 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,393 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:02:01,398 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,403 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,403 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 18:00:00(String)
2019-06-18 12:02:01,410 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,419 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,419 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180025(String)
2019-06-18 12:02:01,447 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,454 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,455 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:02:01,459 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,469 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,469 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 19:30:00(String)
2019-06-18 12:02:01,477 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,484 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,484 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180010(String)
2019-06-18 12:02:01,505 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,512 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,512 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:02:01,517 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,524 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,525 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 20:10:00(String)
2019-06-18 12:02:01,534 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,540 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,540 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180032(String)
2019-06-18 12:02:01,561 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,568 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,568 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:02:01,573 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,580 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,580 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 20:55:00(String)
2019-06-18 12:02:01,589 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,596 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,596 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180026(String)
2019-06-18 12:02:01,622 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,629 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,630 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:02:01,644 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,651 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,652 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 21:40:00(String)
2019-06-18 12:02:01,661 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:02:01,668 [http-nio-8080-exec-4] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:02:01,668 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 1683201906180011(String)
2019-06-18 12:02:01,690 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,699 [http-nio-8080-exec-4] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:02:01,699 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:02:01,704 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:02:01,711 [http-nio-8080-exec-4] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:02:01,711 [http-nio-8080-exec-4] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 22:20:00(String)
2019-06-18 12:02:01,719 [http-nio-8080-exec-4] <==      Total: 3
2019-06-18 12:14:04,714 [http-nio-8080-exec-8] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-06-18 12:14:04,728 [http-nio-8080-exec-8] ==> Parameters: admin(String)
2019-06-18 12:14:04,748 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 12:14:04,764 [http-nio-8080-exec-8] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-06-18 12:14:04,769 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-06-18 12:14:04,784 [http-nio-8080-exec-8] <==      Total: 46
2019-06-18 12:14:04,921 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-06-18 12:14:04,929 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-06-18 12:14:04,941 [taskExecutor-1] <==    Updates: 1
2019-06-18 12:14:05,438 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-06-18 12:14:05,441 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-06-18 12:14:05,449 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 12:14:12,385 [http-nio-8080-exec-10] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 12:14:12,386 [http-nio-8080-exec-10] ==> Parameters: operatingResult(String)
2019-06-18 12:14:12,399 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 12:14:12,416 [http-nio-8080-exec-8] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 12:14:12,417 [http-nio-8080-exec-8] ==> Parameters: ticketUserType(String)
2019-06-18 12:14:12,422 [http-nio-8080-exec-8] <==      Total: 4
2019-06-18 12:14:12,527 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:14:12,531 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:14:12,544 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 12:14:12,573 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:14:12,573 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:14:12,584 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 12:14:12,599 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 12:14:12,601 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 12:14:12,610 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:14:12,623 [http-nio-8080-exec-6] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 12:14:12,626 [http-nio-8080-exec-6] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:14:12,629 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,632 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 12:14:12,634 [http-nio-8080-exec-6] <==      Total: 2
2019-06-18 12:14:12,643 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,650 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,651 [http-nio-8080-exec-4] ==> Parameters: 22113901(String)
2019-06-18 12:14:12,661 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,670 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,670 [http-nio-8080-exec-4] ==> Parameters: 33096401(String)
2019-06-18 12:14:12,680 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,688 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,688 [http-nio-8080-exec-4] ==> Parameters: 33111001(String)
2019-06-18 12:14:12,699 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,709 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,709 [http-nio-8080-exec-4] ==> Parameters: 18888888(String)
2019-06-18 12:14:12,719 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,727 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,728 [http-nio-8080-exec-4] ==> Parameters: 33074881(String)
2019-06-18 12:14:12,738 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,747 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,748 [http-nio-8080-exec-4] ==> Parameters: 62549174(String)
2019-06-18 12:14:12,758 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,767 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,768 [http-nio-8080-exec-4] ==> Parameters: addsf(String)
2019-06-18 12:14:12,777 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,784 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,784 [http-nio-8080-exec-4] ==> Parameters: gzxxx(String)
2019-06-18 12:14:12,793 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,801 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,802 [http-nio-8080-exec-4] ==> Parameters: 22060081(String)
2019-06-18 12:14:12,810 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,818 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,819 [http-nio-8080-exec-4] ==> Parameters: 31120907(String)
2019-06-18 12:14:12,828 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,836 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,836 [http-nio-8080-exec-4] ==> Parameters: 33013701(String)
2019-06-18 12:14:12,842 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,850 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,850 [http-nio-8080-exec-4] ==> Parameters: 34140901(String)
2019-06-18 12:14:12,859 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,866 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:14:12,867 [http-nio-8080-exec-4] ==> Parameters: 33112911(String)
2019-06-18 12:14:12,876 [http-nio-8080-exec-4] <==      Total: 0
2019-06-18 12:14:12,883 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:14:12,884 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 12:14:12,891 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 12:14:12,914 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 12:14:12,916 [http-nio-8080-exec-10] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String)
2019-06-18 12:14:12,923 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 12:14:12,931 [http-nio-8080-exec-10] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 12:14:12,932 [http-nio-8080-exec-10] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 12:14:12,937 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 12:14:13,833 [http-nio-8080-exec-4] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 12:14:13,834 [http-nio-8080-exec-4] ==> Parameters: couponsType(String)
2019-06-18 12:14:13,838 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 12:14:13,854 [http-nio-8080-exec-10] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 12:14:13,855 [http-nio-8080-exec-10] ==> Parameters: enabled(String)
2019-06-18 12:14:13,859 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 12:14:13,875 [http-nio-8080-exec-8] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 12:14:13,876 [http-nio-8080-exec-8] ==> Parameters: reductionTypes(String)
2019-06-18 12:14:13,881 [http-nio-8080-exec-8] <==      Total: 2
2019-06-18 12:14:13,908 [http-nio-8080-exec-2] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:14:13,909 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 12:14:13,919 [http-nio-8080-exec-2] <==      Total: 14
2019-06-18 12:14:13,927 [http-nio-8080-exec-2] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:14:13,928 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 12:14:13,938 [http-nio-8080-exec-2] <==      Total: 14
2019-06-18 12:14:13,986 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:14:13,986 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:14:13,987 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 12:14:13,987 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 12:14:13,992 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 12:14:13,992 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 12:14:14,001 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:14:14,001 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:14:14,002 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:14:14,002 [http-nio-8080-exec-3] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:14:14,009 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 12:14:14,010 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 12:14:25,695 [http-nio-8080-exec-7] ==>  Preparing: select * from t_dict t where t.type = ? 
2019-06-18 12:14:25,696 [http-nio-8080-exec-7] ==> Parameters: couponStatus(String)
2019-06-18 12:14:25,703 [http-nio-8080-exec-7] <==      Total: 4
2019-06-18 12:14:25,776 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:14:25,777 [http-nio-8080-exec-1] ==> Parameters: 1560789303576581(String)
2019-06-18 12:14:25,784 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 12:14:25,792 [http-nio-8080-exec-1] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:14:25,793 [http-nio-8080-exec-1] ==> Parameters: 1560789303576581(String), 0(Integer), 10(Integer)
2019-06-18 12:14:25,800 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 12:14:27,321 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:14:27,322 [http-nio-8080-exec-5] ==> Parameters: 1560789303576581(String)
2019-06-18 12:14:27,336 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:14:27,349 [http-nio-8080-exec-5] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:14:27,349 [http-nio-8080-exec-5] ==> Parameters: 1560789303576581(String), 10(Integer), 10(Integer)
2019-06-18 12:14:27,358 [http-nio-8080-exec-5] <==      Total: 10
2019-06-18 12:14:28,369 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:14:28,369 [http-nio-8080-exec-6] ==> Parameters: 1560789303576581(String)
2019-06-18 12:14:28,377 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:14:28,384 [http-nio-8080-exec-6] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:14:28,384 [http-nio-8080-exec-6] ==> Parameters: 1560789303576581(String), 20(Integer), 10(Integer)
2019-06-18 12:14:28,391 [http-nio-8080-exec-6] <==      Total: 5
2019-06-18 12:14:29,609 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:14:29,609 [http-nio-8080-exec-9] ==> Parameters: 1560789303576581(String)
2019-06-18 12:14:29,616 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:14:29,623 [http-nio-8080-exec-9] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:14:29,624 [http-nio-8080-exec-9] ==> Parameters: 1560789303576581(String), 0(Integer), 10(Integer)
2019-06-18 12:14:29,630 [http-nio-8080-exec-9] <==      Total: 10
2019-06-18 12:14:41,546 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:14:41,547 [http-nio-8080-exec-10] ==> Parameters: 1560789303576581(String)
2019-06-18 12:14:41,555 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 12:14:41,562 [http-nio-8080-exec-10] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:14:41,563 [http-nio-8080-exec-10] ==> Parameters: 1560789303576581(String), 10(Integer), 10(Integer)
2019-06-18 12:14:41,569 [http-nio-8080-exec-10] <==      Total: 10
2019-06-18 12:14:42,348 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:14:42,349 [http-nio-8080-exec-7] ==> Parameters: 1560789303576581(String)
2019-06-18 12:14:42,362 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 12:14:42,370 [http-nio-8080-exec-7] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:14:42,370 [http-nio-8080-exec-7] ==> Parameters: 1560789303576581(String), 20(Integer), 10(Integer)
2019-06-18 12:14:42,376 [http-nio-8080-exec-7] <==      Total: 5
2019-06-18 12:14:43,355 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:14:43,356 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581(String)
2019-06-18 12:14:43,361 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 12:14:43,376 [http-nio-8080-exec-3] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:14:43,376 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581(String), 0(Integer), 10(Integer)
2019-06-18 12:14:43,383 [http-nio-8080-exec-3] <==      Total: 10
2019-06-18 12:14:56,415 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? and Status = ? 
2019-06-18 12:14:56,416 [http-nio-8080-exec-4] ==> Parameters: 1560789303576581(String), 1(String)
2019-06-18 12:14:56,426 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:14:56,433 [http-nio-8080-exec-4] ==>  Preparing: select * from coupons t WHERE GroupCode = ? and Status = ? limit ?, ? 
2019-06-18 12:14:56,434 [http-nio-8080-exec-4] ==> Parameters: 1560789303576581(String), 1(String), 0(Integer), 10(Integer)
2019-06-18 12:14:56,440 [http-nio-8080-exec-4] <==      Total: 10
2019-06-18 12:14:58,197 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? and Status = ? 
2019-06-18 12:14:58,198 [http-nio-8080-exec-8] ==> Parameters: 1560789303576581(String), 2(String)
2019-06-18 12:14:58,212 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 12:14:58,219 [http-nio-8080-exec-8] ==>  Preparing: select * from coupons t WHERE GroupCode = ? and Status = ? limit ?, ? 
2019-06-18 12:14:58,220 [http-nio-8080-exec-8] ==> Parameters: 1560789303576581(String), 2(String), 0(Integer), 10(Integer)
2019-06-18 12:14:58,225 [http-nio-8080-exec-8] <==      Total: 5
2019-06-18 12:15:00,828 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? and Status = ? 
2019-06-18 12:15:00,829 [http-nio-8080-exec-2] ==> Parameters: 1560789303576581(String), 3(String)
2019-06-18 12:15:00,837 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:15:03,238 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? and Status = ? 
2019-06-18 12:15:03,239 [http-nio-8080-exec-1] ==> Parameters: 1560789303576581(String), 2(String)
2019-06-18 12:15:03,244 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 12:15:03,251 [http-nio-8080-exec-1] ==>  Preparing: select * from coupons t WHERE GroupCode = ? and Status = ? limit ?, ? 
2019-06-18 12:15:03,251 [http-nio-8080-exec-1] ==> Parameters: 1560789303576581(String), 2(String), 0(Integer), 10(Integer)
2019-06-18 12:15:03,257 [http-nio-8080-exec-1] <==      Total: 5
2019-06-18 12:15:04,664 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:15:04,665 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 12:15:04,672 [http-nio-8080-exec-5] <==      Total: 14
2019-06-18 12:15:04,680 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:15:04,681 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 12:15:04,689 [http-nio-8080-exec-5] <==      Total: 14
2019-06-18 12:15:04,711 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:15:04,712 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 12:15:04,720 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:15:04,720 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 12:15:04,720 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 12:15:04,727 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:15:04,727 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:15:04,728 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:15:04,734 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 12:15:04,736 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:15:04,737 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:15:04,743 [http-nio-8080-exec-9] <==      Total: 2
2019-06-18 12:15:36,029 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:15:36,029 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581(String)
2019-06-18 12:15:36,043 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 12:15:36,051 [http-nio-8080-exec-3] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:15:36,052 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581(String), 0(Integer), 10(Integer)
2019-06-18 12:15:36,057 [http-nio-8080-exec-3] <==      Total: 10
2019-06-18 12:15:38,667 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? and Status = ? 
2019-06-18 12:15:38,669 [http-nio-8080-exec-2] ==> Parameters: 1560789303576581(String), 2(String)
2019-06-18 12:15:38,702 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:15:38,709 [http-nio-8080-exec-2] ==>  Preparing: select * from coupons t WHERE GroupCode = ? and Status = ? limit ?, ? 
2019-06-18 12:15:38,709 [http-nio-8080-exec-2] ==> Parameters: 1560789303576581(String), 2(String), 0(Integer), 10(Integer)
2019-06-18 12:15:38,732 [http-nio-8080-exec-2] <==      Total: 5
2019-06-18 12:16:03,609 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:16:03,610 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:16:03,617 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 12:16:03,623 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:16:03,624 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:16:03,631 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 12:16:03,658 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:16:03,659 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 12:16:03,666 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:16:03,673 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:16:03,674 [http-nio-8080-exec-5] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:16:03,678 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:16:03,680 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 12:16:03,681 [http-nio-8080-exec-5] <==      Total: 2
2019-06-18 12:16:03,687 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:16:03,694 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:16:03,695 [http-nio-8080-exec-4] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:16:03,702 [http-nio-8080-exec-4] <==      Total: 2
2019-06-18 12:16:04,600 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:16:04,601 [http-nio-8080-exec-3] ==> Parameters: 1560789353743900(String)
2019-06-18 12:16:04,609 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 12:16:04,617 [http-nio-8080-exec-3] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:16:04,618 [http-nio-8080-exec-3] ==> Parameters: 1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 12:16:04,625 [http-nio-8080-exec-3] <==      Total: 10
2019-06-18 12:16:07,715 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? and Status = ? 
2019-06-18 12:16:07,715 [http-nio-8080-exec-9] ==> Parameters: 1560789353743900(String), 2(String)
2019-06-18 12:16:07,721 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:16:07,729 [http-nio-8080-exec-9] ==>  Preparing: select * from coupons t WHERE GroupCode = ? and Status = ? limit ?, ? 
2019-06-18 12:16:07,729 [http-nio-8080-exec-9] ==> Parameters: 1560789353743900(String), 2(String), 0(Integer), 10(Integer)
2019-06-18 12:16:07,738 [http-nio-8080-exec-9] <==      Total: 4
2019-06-18 12:17:24,038 [http-nio-8080-exec-4] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:17:24,039 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 12:17:24,053 [http-nio-8080-exec-4] <==      Total: 14
2019-06-18 12:17:24,061 [http-nio-8080-exec-4] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:17:24,063 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 12:17:24,070 [http-nio-8080-exec-4] <==      Total: 14
2019-06-18 12:17:24,092 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:24,093 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 12:17:24,100 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:17:24,106 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:24,106 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:24,106 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 12:17:24,106 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:24,112 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 12:17:24,116 [http-nio-8080-exec-9] <==      Total: 2
2019-06-18 12:17:24,121 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:24,122 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:24,129 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 12:17:25,455 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:17:25,455 [http-nio-8080-exec-1] ==> Parameters: 1560789303576581(String)
2019-06-18 12:17:25,463 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 12:17:25,470 [http-nio-8080-exec-1] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:17:25,471 [http-nio-8080-exec-1] ==> Parameters: 1560789303576581(String), 0(Integer), 10(Integer)
2019-06-18 12:17:25,477 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 12:17:27,207 [http-nio-8080-exec-3] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:17:27,208 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 12:17:27,215 [http-nio-8080-exec-3] <==      Total: 14
2019-06-18 12:17:27,222 [http-nio-8080-exec-3] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:17:27,223 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 12:17:27,230 [http-nio-8080-exec-3] <==      Total: 14
2019-06-18 12:17:27,239 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:27,240 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 12:17:27,246 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 12:17:27,254 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:27,255 [http-nio-8080-exec-10] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:27,258 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:27,259 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 12:17:27,262 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 12:17:27,267 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:17:27,275 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:27,276 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:27,282 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 12:17:28,191 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:17:28,192 [http-nio-8080-exec-9] ==> Parameters: 1560789353743900(String)
2019-06-18 12:17:28,197 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:17:28,205 [http-nio-8080-exec-9] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:17:28,205 [http-nio-8080-exec-9] ==> Parameters: 1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 12:17:28,212 [http-nio-8080-exec-9] <==      Total: 10
2019-06-18 12:17:31,664 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? and Status = ? 
2019-06-18 12:17:31,664 [http-nio-8080-exec-8] ==> Parameters: 1560789353743900(String), 2(String)
2019-06-18 12:17:31,671 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 12:17:31,680 [http-nio-8080-exec-8] ==>  Preparing: select * from coupons t WHERE GroupCode = ? and Status = ? limit ?, ? 
2019-06-18 12:17:31,680 [http-nio-8080-exec-8] ==> Parameters: 1560789353743900(String), 2(String), 0(Integer), 10(Integer)
2019-06-18 12:17:31,689 [http-nio-8080-exec-8] <==      Total: 4
2019-06-18 12:17:33,392 [http-nio-8080-exec-4] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:17:33,394 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 12:17:33,401 [http-nio-8080-exec-4] <==      Total: 14
2019-06-18 12:17:33,413 [http-nio-8080-exec-4] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:17:33,413 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 12:17:33,420 [http-nio-8080-exec-4] <==      Total: 14
2019-06-18 12:17:33,441 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:33,441 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:17:33,449 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 12:17:33,454 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:33,454 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 12:17:33,458 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:33,458 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:33,464 [http-nio-8080-exec-1] <==      Total: 2
2019-06-18 12:17:33,468 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:17:33,475 [http-nio-8080-exec-6] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:33,476 [http-nio-8080-exec-6] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:33,483 [http-nio-8080-exec-6] <==      Total: 2
2019-06-18 12:17:34,200 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? 
2019-06-18 12:17:34,201 [http-nio-8080-exec-8] ==> Parameters: 1560789303576581(String)
2019-06-18 12:17:34,208 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 12:17:34,216 [http-nio-8080-exec-8] ==>  Preparing: select * from coupons t WHERE GroupCode = ? limit ?, ? 
2019-06-18 12:17:34,216 [http-nio-8080-exec-8] ==> Parameters: 1560789303576581(String), 0(Integer), 10(Integer)
2019-06-18 12:17:34,222 [http-nio-8080-exec-8] <==      Total: 10
2019-06-18 12:17:36,908 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from coupons t WHERE GroupCode = ? and Status = ? 
2019-06-18 12:17:36,908 [http-nio-8080-exec-2] ==> Parameters: 1560789303576581(String), 2(String)
2019-06-18 12:17:36,917 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:17:36,923 [http-nio-8080-exec-2] ==>  Preparing: select * from coupons t WHERE GroupCode = ? and Status = ? limit ?, ? 
2019-06-18 12:17:36,924 [http-nio-8080-exec-2] ==> Parameters: 1560789303576581(String), 2(String), 0(Integer), 10(Integer)
2019-06-18 12:17:36,930 [http-nio-8080-exec-2] <==      Total: 5
2019-06-18 12:17:44,190 [http-nio-8080-exec-6] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:17:44,191 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 12:17:44,204 [http-nio-8080-exec-6] <==      Total: 14
2019-06-18 12:17:44,212 [http-nio-8080-exec-6] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:17:44,212 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 12:17:44,218 [http-nio-8080-exec-6] <==      Total: 14
2019-06-18 12:17:44,242 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:44,242 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:44,242 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:17:44,243 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 12:17:44,255 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 12:17:44,255 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 12:17:44,263 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:44,263 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:44,263 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:44,263 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:44,270 [http-nio-8080-exec-1] <==      Total: 2
2019-06-18 12:17:44,270 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 12:17:50,006 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from couponsgroup t 
2019-06-18 12:17:50,007 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 12:17:50,016 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:17:50,021 [http-nio-8080-exec-5] ==>  Preparing: select * from couponsgroup t limit ?, ? 
2019-06-18 12:17:50,022 [http-nio-8080-exec-5] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:17:50,027 [http-nio-8080-exec-5] <==      Total: 2
2019-06-18 12:18:45,889 [http-nio-8080-exec-7] ==>  Preparing: select * from registeractive t where t.cinemacode = ? 
2019-06-18 12:18:45,889 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:18:45,893 [http-nio-8080-exec-7] ==> Parameters: 1(String)
2019-06-18 12:18:45,895 [http-nio-8080-exec-3] ==> Parameters: 1(String)
2019-06-18 12:18:45,899 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:18:45,908 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 12:18:45,917 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:18:45,918 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 12:18:45,926 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 12:18:47,130 [http-nio-8080-exec-2] ==>  Preparing: select * from registeractivecoupons where registerActiveCode = ? 
2019-06-18 12:18:47,135 [http-nio-8080-exec-2] ==> Parameters: undefined(String)
2019-06-18 12:18:47,141 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 12:18:52,167 [taskExecutor-2] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-06-18 12:18:52,169 [taskExecutor-2] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-06-18 12:18:52,182 [taskExecutor-2] <==    Updates: 1
2019-06-18 12:19:02,840 [http-nio-8080-exec-8] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-06-18 12:19:02,842 [http-nio-8080-exec-8] ==> Parameters: admin(String)
2019-06-18 12:19:02,857 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 12:19:02,864 [http-nio-8080-exec-8] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-06-18 12:19:02,865 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-06-18 12:19:02,872 [http-nio-8080-exec-8] <==      Total: 47
2019-06-18 12:19:02,963 [taskExecutor-3] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-06-18 12:19:02,964 [taskExecutor-3] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-06-18 12:19:02,981 [taskExecutor-3] <==    Updates: 1
2019-06-18 12:19:03,157 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-06-18 12:19:03,158 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-06-18 12:19:03,166 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 12:19:08,693 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:19:08,694 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 12:19:08,700 [http-nio-8080-exec-5] <==      Total: 14
2019-06-18 12:19:08,709 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:19:08,710 [http-nio-8080-exec-5] ==> Parameters: 
2019-06-18 12:19:08,716 [http-nio-8080-exec-5] <==      Total: 14
2019-06-18 12:19:08,754 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 12:19:08,754 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,755 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 12:19:08,755 [http-nio-8080-exec-7] ==> Parameters: 33097601(String)
2019-06-18 12:19:08,762 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,762 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:19:08,805 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,805 [http-nio-8080-exec-2] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 12:19:08,805 [http-nio-8080-exec-7] ==> Parameters: 22113901(String)
2019-06-18 12:19:08,806 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:19:08,835 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,836 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 12:19:08,846 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,846 [http-nio-8080-exec-7] ==> Parameters: 33096401(String)
2019-06-18 12:19:08,856 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,874 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,875 [http-nio-8080-exec-7] ==> Parameters: 33111001(String)
2019-06-18 12:19:08,885 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,893 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,896 [http-nio-8080-exec-7] ==> Parameters: 18888888(String)
2019-06-18 12:19:08,902 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,910 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,910 [http-nio-8080-exec-7] ==> Parameters: 33074881(String)
2019-06-18 12:19:08,917 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,926 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,927 [http-nio-8080-exec-7] ==> Parameters: 62549174(String)
2019-06-18 12:19:08,934 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,943 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,944 [http-nio-8080-exec-7] ==> Parameters: addsf(String)
2019-06-18 12:19:08,954 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,960 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,961 [http-nio-8080-exec-7] ==> Parameters: gzxxx(String)
2019-06-18 12:19:08,970 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,977 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:08,978 [http-nio-8080-exec-7] ==> Parameters: 22060081(String)
2019-06-18 12:19:08,989 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:08,999 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,000 [http-nio-8080-exec-7] ==> Parameters: 31120907(String)
2019-06-18 12:19:09,006 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:09,013 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,014 [http-nio-8080-exec-7] ==> Parameters: 33013701(String)
2019-06-18 12:19:09,043 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:09,085 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,085 [http-nio-8080-exec-7] ==> Parameters: 34140901(String)
2019-06-18 12:19:09,121 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:09,134 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,134 [http-nio-8080-exec-7] ==> Parameters: 33112911(String)
2019-06-18 12:19:09,155 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:19:09,172 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:19:09,172 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 12:19:09,178 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 12:19:09,197 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 12:19:09,197 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String)
2019-06-18 12:19:09,205 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 12:19:09,211 [http-nio-8080-exec-3] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 12:19:09,212 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 12:19:09,218 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 12:19:09,880 [http-nio-8080-exec-6] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:19:09,881 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 12:19:09,893 [http-nio-8080-exec-6] <==      Total: 14
2019-06-18 12:19:09,900 [http-nio-8080-exec-6] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:19:09,900 [http-nio-8080-exec-6] ==> Parameters: 
2019-06-18 12:19:09,908 [http-nio-8080-exec-6] <==      Total: 14
2019-06-18 12:19:09,922 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,923 [http-nio-8080-exec-9] ==> Parameters: 33097601(String)
2019-06-18 12:19:09,932 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:09,937 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,938 [http-nio-8080-exec-9] ==> Parameters: 22113901(String)
2019-06-18 12:19:09,943 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:09,950 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,951 [http-nio-8080-exec-9] ==> Parameters: 33096401(String)
2019-06-18 12:19:09,959 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:09,965 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,966 [http-nio-8080-exec-9] ==> Parameters: 33111001(String)
2019-06-18 12:19:09,977 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:09,984 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:09,984 [http-nio-8080-exec-9] ==> Parameters: 18888888(String)
2019-06-18 12:19:09,993 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,001 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,002 [http-nio-8080-exec-9] ==> Parameters: 33074881(String)
2019-06-18 12:19:10,009 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,015 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,016 [http-nio-8080-exec-9] ==> Parameters: 62549174(String)
2019-06-18 12:19:10,027 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,035 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,035 [http-nio-8080-exec-9] ==> Parameters: addsf(String)
2019-06-18 12:19:10,041 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,047 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,047 [http-nio-8080-exec-9] ==> Parameters: gzxxx(String)
2019-06-18 12:19:10,054 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,061 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,062 [http-nio-8080-exec-9] ==> Parameters: 22060081(String)
2019-06-18 12:19:10,071 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,078 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,079 [http-nio-8080-exec-9] ==> Parameters: 31120907(String)
2019-06-18 12:19:10,084 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,091 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,092 [http-nio-8080-exec-9] ==> Parameters: 33013701(String)
2019-06-18 12:19:10,100 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,108 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,108 [http-nio-8080-exec-9] ==> Parameters: 34140901(String)
2019-06-18 12:19:10,118 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,128 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:10,129 [http-nio-8080-exec-9] ==> Parameters: 33112911(String)
2019-06-18 12:19:10,137 [http-nio-8080-exec-9] <==      Total: 0
2019-06-18 12:19:10,145 [http-nio-8080-exec-9] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:19:10,145 [http-nio-8080-exec-9] ==> Parameters: 
2019-06-18 12:19:10,153 [http-nio-8080-exec-9] <==      Total: 2
2019-06-18 12:19:13,489 [http-nio-8080-exec-1] ==>  Preparing: select * from ticketusers t 
2019-06-18 12:19:13,490 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:19:13,509 [http-nio-8080-exec-1] <==      Total: 7
2019-06-18 12:19:16,396 [http-nio-8080-exec-8] ==>  Preparing: select * from ticketusers t 
2019-06-18 12:19:16,398 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 12:19:16,407 [http-nio-8080-exec-8] <==      Total: 7
2019-06-18 12:19:17,505 [http-nio-8080-exec-3] ==>  Preparing: select * from ticketusers t 
2019-06-18 12:19:17,506 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 12:19:17,515 [http-nio-8080-exec-4] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 12:19:17,516 [http-nio-8080-exec-4] ==> Parameters: 1560789303576581(String)
2019-06-18 12:19:17,517 [http-nio-8080-exec-3] <==      Total: 7
2019-06-18 12:19:17,522 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:19:17,529 [http-nio-8080-exec-4] ==>  Preparing: select * from ticketusers t 
2019-06-18 12:19:17,530 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 12:19:17,539 [http-nio-8080-exec-4] <==      Total: 7
2019-06-18 12:19:17,546 [http-nio-8080-exec-4] ==>  Preparing: select * from ticketusers t 
2019-06-18 12:19:17,546 [http-nio-8080-exec-4] ==> Parameters: 
2019-06-18 12:19:17,555 [http-nio-8080-exec-4] <==      Total: 7
2019-06-18 12:19:17,574 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,577 [http-nio-8080-exec-4] ==> Parameters: 156083155757359958(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 12:19:17.573(Timestamp), null
2019-06-18 12:19:17,585 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,586 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,586 [http-nio-8080-exec-4] ==> Parameters: 156083155758618652(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 12:19:17.586(Timestamp), null
2019-06-18 12:19:17,594 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,595 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,595 [http-nio-8080-exec-4] ==> Parameters: 156083155759543245(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 12:19:17.595(Timestamp), null
2019-06-18 12:19:17,600 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,601 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,601 [http-nio-8080-exec-4] ==> Parameters: 156083155760132937(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 12:19:17.601(Timestamp), null
2019-06-18 12:19:17,609 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,609 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,610 [http-nio-8080-exec-4] ==> Parameters: 156083155760948138(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 12:19:17.609(Timestamp), null
2019-06-18 12:19:17,617 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,644 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,645 [http-nio-8080-exec-4] ==> Parameters: 156083155764460107(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 12:19:17.644(Timestamp), null
2019-06-18 12:19:17,652 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,653 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,653 [http-nio-8080-exec-4] ==> Parameters: 156083155765296567(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 12:19:17.652(Timestamp), null
2019-06-18 12:19:17,658 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,659 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,659 [http-nio-8080-exec-4] ==> Parameters: 156083155765968012(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 12:19:17.659(Timestamp), null
2019-06-18 12:19:17,664 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,665 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,665 [http-nio-8080-exec-4] ==> Parameters: 156083155766572740(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 12:19:17.665(Timestamp), null
2019-06-18 12:19:17,672 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,673 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,673 [http-nio-8080-exec-4] ==> Parameters: 156083155767361577(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 12:19:17.673(Timestamp), null
2019-06-18 12:19:17,681 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,681 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,682 [http-nio-8080-exec-4] ==> Parameters: 156083155768121907(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 12:19:17.681(Timestamp), null
2019-06-18 12:19:17,690 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,690 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,691 [http-nio-8080-exec-4] ==> Parameters: 156083155769077739(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 12:19:17.69(Timestamp), null
2019-06-18 12:19:17,698 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,698 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,699 [http-nio-8080-exec-4] ==> Parameters: 156083155769845679(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 12:19:17.698(Timestamp), null
2019-06-18 12:19:17,707 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,707 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,708 [http-nio-8080-exec-4] ==> Parameters: 156083155770743446(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 12:19:17.707(Timestamp), null
2019-06-18 12:19:17,717 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,718 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,719 [http-nio-8080-exec-4] ==> Parameters: 156083155771823197(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 12:19:17.718(Timestamp), null
2019-06-18 12:19:17,724 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,725 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,726 [http-nio-8080-exec-4] ==> Parameters: 156083155772589238(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 12:19:17.725(Timestamp), null
2019-06-18 12:19:17,732 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,733 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,733 [http-nio-8080-exec-4] ==> Parameters: 156083155773316809(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 12:19:17.733(Timestamp), null
2019-06-18 12:19:17,738 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,739 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,739 [http-nio-8080-exec-4] ==> Parameters: 156083155773976092(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 12:19:17.739(Timestamp), null
2019-06-18 12:19:17,745 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,746 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,746 [http-nio-8080-exec-4] ==> Parameters: 156083155774657071(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 12:19:17.746(Timestamp), null
2019-06-18 12:19:17,752 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,752 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,753 [http-nio-8080-exec-4] ==> Parameters: 156083155775212277(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 12:19:17.752(Timestamp), null
2019-06-18 12:19:17,766 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,766 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,767 [http-nio-8080-exec-4] ==> Parameters: 156083155776663210(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 12:19:17.766(Timestamp), null
2019-06-18 12:19:17,772 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,773 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,773 [http-nio-8080-exec-4] ==> Parameters: 156083155777349498(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 12:19:17.773(Timestamp), null
2019-06-18 12:19:17,779 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,780 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,780 [http-nio-8080-exec-4] ==> Parameters: 156083155778050759(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 12:19:17.78(Timestamp), null
2019-06-18 12:19:17,786 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,786 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,787 [http-nio-8080-exec-4] ==> Parameters: 156083155778635359(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 12:19:17.786(Timestamp), null
2019-06-18 12:19:17,792 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,793 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,794 [http-nio-8080-exec-4] ==> Parameters: 156083155779340286(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 12:19:17.793(Timestamp), null
2019-06-18 12:19:17,799 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,800 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,800 [http-nio-8080-exec-4] ==> Parameters: 156083155780018359(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 12:19:17.8(Timestamp), null
2019-06-18 12:19:17,810 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,810 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,811 [http-nio-8080-exec-4] ==> Parameters: 156083155781018230(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 12:19:17.81(Timestamp), null
2019-06-18 12:19:17,817 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,817 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,818 [http-nio-8080-exec-4] ==> Parameters: 156083155781765493(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 12:19:17.817(Timestamp), null
2019-06-18 12:19:17,824 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,825 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,825 [http-nio-8080-exec-4] ==> Parameters: 156083155782559157(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 12:19:17.825(Timestamp), null
2019-06-18 12:19:17,830 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,831 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,831 [http-nio-8080-exec-4] ==> Parameters: 156083155783013830(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 12:19:17.83(Timestamp), null
2019-06-18 12:19:17,837 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,837 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,838 [http-nio-8080-exec-4] ==> Parameters: 156083155783785635(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 12:19:17.837(Timestamp), null
2019-06-18 12:19:17,843 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,843 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,843 [http-nio-8080-exec-4] ==> Parameters: 156083155784341025(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 12:19:17.843(Timestamp), null
2019-06-18 12:19:17,851 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,851 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,851 [http-nio-8080-exec-4] ==> Parameters: 156083155785197805(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 12:19:17.851(Timestamp), null
2019-06-18 12:19:17,856 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,857 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,857 [http-nio-8080-exec-4] ==> Parameters: 156083155785614949(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 12:19:17.856(Timestamp), null
2019-06-18 12:19:17,863 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,863 [http-nio-8080-exec-4] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 12:19:17,864 [http-nio-8080-exec-4] ==> Parameters: 156083155786345956(String), 满20减5元优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789303576581(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 12:19:17.863(Timestamp), null
2019-06-18 12:19:17,871 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,875 [http-nio-8080-exec-4] ==>  Preparing: update couponsgroup t SET Id = ?, GroupCode = ?, CouponsType = ?, CouponsName = ?, ValidityType = ?, EffectiveDate = ?, ExpireDate = ?, CanUsePeriodType = ?, WeekDays = ?, TimePeriod = ?, LimitNum = ?, ReductionType = ?, InitialAmount = ?, ReductionPrice = ?, FilmCodes = ?, GoodsCodes = ?, IsShare = ?, Remark = ?, CanUseCinemaType = ?, CinemaCodes = ?, Status = ?, CouponsNumber = ?, IssuedNumber = ?, FetchNumber = ?, RemainingNumber = ?, UsedNumber = ?, GiftType = ?, UpdateDate = ? where t.id = ? 
2019-06-18 12:19:17,876 [http-nio-8080-exec-4] ==> Parameters: 60(Long), 1560789303576581(String), 1(Integer), 满20减5元优惠券(String), 1(Integer), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1(Integer), (String), (String), 10(Integer), 2(Integer), 20.0(Double), 5.0(Double), (String), (String), 0(Integer), (String), 1(Integer), (String), 1(Integer), 10000(Integer), 60(Integer), 60(Integer), 9940(Integer), 5(Integer), 2(String), 2019-06-18 12:19:17.871(Timestamp), 60(Long)
2019-06-18 12:19:17,886 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:17,906 [http-nio-8080-exec-4] ==>  Preparing: insert into coupondistributionrecord(Id, GroupCode, CustomerType, OpenID, Issuer, IssuedNumber, IssuedTime, Status) values(?, ?, ?, ?, ?, ?, now(), ?) 
2019-06-18 12:19:17,907 [http-nio-8080-exec-4] ==> Parameters: null, 1560789303576581(String), 1(Integer), (String), admin(String), 35(Integer), 1(Integer)
2019-06-18 12:19:17,915 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:19:19,294 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:19:19,295 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:19:19,302 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 12:19:19,309 [http-nio-8080-exec-1] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s where ss.id = s.id 
2019-06-18 12:19:19,310 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:19:19,317 [http-nio-8080-exec-1] <==      Total: 14
2019-06-18 12:19:19,335 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 12:19:19,336 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 12:19:19,340 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,342 [http-nio-8080-exec-10] ==> Parameters: 33097601(String)
2019-06-18 12:19:19,343 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 12:19:19,351 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,351 [http-nio-8080-exec-7] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 12:19:19,352 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 12:19:19,356 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,357 [http-nio-8080-exec-7] <==      Total: 3
2019-06-18 12:19:19,357 [http-nio-8080-exec-10] ==> Parameters: 22113901(String)
2019-06-18 12:19:19,366 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,374 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,375 [http-nio-8080-exec-10] ==> Parameters: 33096401(String)
2019-06-18 12:19:19,381 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,387 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,388 [http-nio-8080-exec-10] ==> Parameters: 33111001(String)
2019-06-18 12:19:19,397 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,404 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,406 [http-nio-8080-exec-10] ==> Parameters: 18888888(String)
2019-06-18 12:19:19,416 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,423 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,424 [http-nio-8080-exec-10] ==> Parameters: 33074881(String)
2019-06-18 12:19:19,433 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,441 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,442 [http-nio-8080-exec-10] ==> Parameters: 62549174(String)
2019-06-18 12:19:19,450 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,458 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,458 [http-nio-8080-exec-10] ==> Parameters: addsf(String)
2019-06-18 12:19:19,467 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,482 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,483 [http-nio-8080-exec-10] ==> Parameters: gzxxx(String)
2019-06-18 12:19:19,492 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,499 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,500 [http-nio-8080-exec-10] ==> Parameters: 22060081(String)
2019-06-18 12:19:19,509 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,516 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,517 [http-nio-8080-exec-10] ==> Parameters: 31120907(String)
2019-06-18 12:19:19,523 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,531 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,531 [http-nio-8080-exec-10] ==> Parameters: 33013701(String)
2019-06-18 12:19:19,540 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,553 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,553 [http-nio-8080-exec-10] ==> Parameters: 34140901(String)
2019-06-18 12:19:19,563 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,570 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:19:19,570 [http-nio-8080-exec-10] ==> Parameters: 33112911(String)
2019-06-18 12:19:19,576 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 12:19:19,583 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:19:19,583 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 12:19:19,589 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 12:19:19,606 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 12:19:19,606 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String)
2019-06-18 12:19:19,614 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 12:19:19,622 [http-nio-8080-exec-3] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 12:19:19,622 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 12:19:19,627 [http-nio-8080-exec-3] <==      Total: 3
2019-06-18 12:21:00,950 [taskExecutor-4] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-06-18 12:21:00,953 [taskExecutor-4] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-06-18 12:21:00,974 [taskExecutor-4] <==    Updates: 1
2019-06-18 12:21:07,262 [http-nio-8080-exec-4] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-06-18 12:21:07,263 [http-nio-8080-exec-4] ==> Parameters: 33097601(String)
2019-06-18 12:21:07,268 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 12:21:07,283 [http-nio-8080-exec-4] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-06-18 12:21:07,284 [http-nio-8080-exec-4] ==> Parameters: 2(Long)
2019-06-18 12:21:07,292 [http-nio-8080-exec-4] <==      Total: 28
2019-06-18 12:21:07,368 [taskExecutor-5] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-06-18 12:21:07,368 [taskExecutor-5] ==> Parameters: 2(Long), 登陆(String), true(Boolean), null
2019-06-18 12:21:07,380 [taskExecutor-5] <==    Updates: 1
2019-06-18 12:21:07,532 [http-nio-8080-exec-6] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-06-18 12:21:07,533 [http-nio-8080-exec-6] ==> Parameters: 2(Long)
2019-06-18 12:21:07,540 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:21:10,021 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:21:10,021 [http-nio-8080-exec-10] ==>  Preparing: select * from registeractive t where t.cinemacode = ? 
2019-06-18 12:21:10,027 [http-nio-8080-exec-10] ==> Parameters: 33097601(String)
2019-06-18 12:21:10,028 [http-nio-8080-exec-2] ==> Parameters: 33097601(String)
2019-06-18 12:21:10,034 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 12:21:10,035 [http-nio-8080-exec-10] <==      Total: 1
2019-06-18 12:21:10,041 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:21:10,043 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 12:21:10,049 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 12:21:10,917 [http-nio-8080-exec-8] ==>  Preparing: select * from registeractivecoupons where registerActiveCode = ? 
2019-06-18 12:21:10,919 [http-nio-8080-exec-8] ==> Parameters: 1558944670818(String)
2019-06-18 12:21:10,925 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 12:21:20,781 [http-nio-8080-exec-4] ==>  Preparing: delete from registeractivecoupons where registeractivecode = ? 
2019-06-18 12:21:20,783 [http-nio-8080-exec-4] ==> Parameters: 1558944670818(String)
2019-06-18 12:21:20,797 [http-nio-8080-exec-4] <==    Updates: 0
2019-06-18 12:21:20,804 [http-nio-8080-exec-4] ==>  Preparing: insert into registeractivecoupons(RegisterActiveCode, GroupCode, CouponsName, GiveNumber) values(?, ?, ?, ?) 
2019-06-18 12:21:20,804 [http-nio-8080-exec-4] ==> Parameters: 1558944670818(String), 1560789303576581(String), 满20减5元优惠券(String), 5(Integer)
2019-06-18 12:21:20,815 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:21:20,824 [http-nio-8080-exec-4] ==>  Preparing: update registeractive t SET Id = ?, CinemaCode = ?, RegisterActiveCode = ?, ActivePictureUrl = ?, UpdatedTime = ?, Status = ? where t.id = ? 
2019-06-18 12:21:20,825 [http-nio-8080-exec-4] ==> Parameters: 1(Long), 33097601(String), 1558944670818(String), https://whtxcx.oss-cn-hangzhou.aliyuncs.com/upload/201906/1560788650050.png(String), 2019-06-18 12:21:20.797(Timestamp), 1(Integer), 1(Long)
2019-06-18 12:21:20,837 [http-nio-8080-exec-4] <==    Updates: 1
2019-06-18 12:21:22,132 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:21:22,132 [http-nio-8080-exec-5] ==>  Preparing: select * from registeractive t where t.cinemacode = ? 
2019-06-18 12:21:22,133 [http-nio-8080-exec-7] ==> Parameters: 33097601(String)
2019-06-18 12:21:22,135 [http-nio-8080-exec-5] ==> Parameters: 33097601(String)
2019-06-18 12:21:22,143 [http-nio-8080-exec-7] <==      Total: 0
2019-06-18 12:21:22,144 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:21:22,151 [http-nio-8080-exec-7] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:21:22,152 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 12:21:22,157 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 12:21:23,071 [http-nio-8080-exec-8] ==>  Preparing: select * from registeractivecoupons where registerActiveCode = ? 
2019-06-18 12:21:23,073 [http-nio-8080-exec-8] ==> Parameters: 1558944670818(String)
2019-06-18 12:21:23,078 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 12:21:33,413 [http-nio-8080-exec-9] ==>  Preparing: delete from registeractivecoupons where registeractivecode = ? 
2019-06-18 12:21:33,414 [http-nio-8080-exec-9] ==> Parameters: 1558944670818(String)
2019-06-18 12:21:33,435 [http-nio-8080-exec-9] <==    Updates: 1
2019-06-18 12:21:33,445 [http-nio-8080-exec-9] ==>  Preparing: insert into registeractivecoupons(RegisterActiveCode, GroupCode, CouponsName, GiveNumber) values(?, ?, ?, ?) 
2019-06-18 12:21:33,447 [http-nio-8080-exec-9] ==> Parameters: 1558944670818(String), 1560789303576581(String), 满20减5元优惠券(String), 5(Integer)
2019-06-18 12:21:33,464 [http-nio-8080-exec-9] <==    Updates: 1
2019-06-18 12:21:33,472 [http-nio-8080-exec-9] ==>  Preparing: insert into registeractivecoupons(RegisterActiveCode, GroupCode, CouponsName, GiveNumber) values(?, ?, ?, ?) 
2019-06-18 12:21:33,473 [http-nio-8080-exec-9] ==> Parameters: 1558944670818(String), 1560789353743900(String), 5元影片优惠券(String), 5(Integer)
2019-06-18 12:21:33,492 [http-nio-8080-exec-9] <==    Updates: 1
2019-06-18 12:21:33,500 [http-nio-8080-exec-9] ==>  Preparing: update registeractive t SET Id = ?, CinemaCode = ?, RegisterActiveCode = ?, ActivePictureUrl = ?, UpdatedTime = ?, Status = ? where t.id = ? 
2019-06-18 12:21:33,501 [http-nio-8080-exec-9] ==> Parameters: 1(Long), 33097601(String), 1558944670818(String), https://whtxcx.oss-cn-hangzhou.aliyuncs.com/upload/201906/1560788650050.png(String), 2019-06-18 12:21:33.435(Timestamp), 1(Integer), 1(Long)
2019-06-18 12:21:33,512 [http-nio-8080-exec-9] <==    Updates: 1
2019-06-18 12:21:34,834 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:21:34,837 [http-nio-8080-exec-5] ==>  Preparing: select * from registeractive t where t.cinemacode = ? 
2019-06-18 12:21:34,837 [http-nio-8080-exec-1] ==> Parameters: 33097601(String)
2019-06-18 12:21:34,838 [http-nio-8080-exec-5] ==> Parameters: 33097601(String)
2019-06-18 12:21:34,844 [http-nio-8080-exec-1] <==      Total: 0
2019-06-18 12:21:34,844 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:21:34,852 [http-nio-8080-exec-1] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:21:34,852 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 12:21:34,858 [http-nio-8080-exec-1] <==      Total: 2
2019-06-18 12:21:35,648 [http-nio-8080-exec-3] ==>  Preparing: select * from registeractivecoupons where registerActiveCode = ? 
2019-06-18 12:21:35,653 [http-nio-8080-exec-3] ==> Parameters: 1558944670818(String)
2019-06-18 12:21:35,659 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 12:21:38,315 [http-nio-8080-exec-5] ==>  Preparing: select * from registeractive t where t.cinemacode = ? 
2019-06-18 12:21:38,316 [http-nio-8080-exec-5] ==> Parameters: 33097601(String)
2019-06-18 12:21:38,316 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:21:38,317 [http-nio-8080-exec-8] ==> Parameters: 33097601(String)
2019-06-18 12:21:38,321 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:21:38,325 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 12:21:38,335 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:21:38,336 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 12:21:38,343 [http-nio-8080-exec-8] <==      Total: 2
2019-06-18 12:21:39,699 [http-nio-8080-exec-6] ==>  Preparing: select * from registeractivecoupons where registerActiveCode = ? 
2019-06-18 12:21:39,702 [http-nio-8080-exec-6] ==> Parameters: 1558944670818(String)
2019-06-18 12:21:39,707 [http-nio-8080-exec-6] <==      Total: 2
2019-06-18 12:21:42,075 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 12:21:42,075 [http-nio-8080-exec-9] ==>  Preparing: select * from registeractive t where t.cinemacode = ? 
2019-06-18 12:21:42,080 [http-nio-8080-exec-3] ==> Parameters: 33097601(String)
2019-06-18 12:21:42,080 [http-nio-8080-exec-9] ==> Parameters: 33097601(String)
2019-06-18 12:21:42,087 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:21:42,091 [http-nio-8080-exec-3] <==      Total: 0
2019-06-18 12:21:42,100 [http-nio-8080-exec-3] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 12:21:42,101 [http-nio-8080-exec-3] ==> Parameters: 
2019-06-18 12:21:42,107 [http-nio-8080-exec-3] <==      Total: 2
2019-06-18 12:21:43,044 [http-nio-8080-exec-7] ==>  Preparing: select * from registeractivecoupons where registerActiveCode = ? 
2019-06-18 12:21:43,046 [http-nio-8080-exec-7] ==> Parameters: 1558944670818(String)
2019-06-18 12:21:43,059 [http-nio-8080-exec-7] <==      Total: 2
2019-06-18 12:44:34,278 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-06-18 12:44:34,290 [http-nio-8080-exec-1] ==> Parameters: 2(Long)
2019-06-18 12:44:34,311 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 12:44:35,979 [http-nio-8080-exec-6] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 12:44:35,984 [http-nio-8080-exec-6] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 12:44:35,994 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,004 [http-nio-8080-exec-6] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 12:44:36,006 [http-nio-8080-exec-6] ==> Parameters: 33111001(String)
2019-06-18 12:44:36,015 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,027 [http-nio-8080-exec-6] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 12:44:36,028 [http-nio-8080-exec-6] ==> Parameters: 051201002019(String)
2019-06-18 12:44:36,041 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,051 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? group by substr(t.starttime,1,10) 
2019-06-18 12:44:36,054 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 051201002019(String), 2019-06-18 12:44:36(String)
2019-06-18 12:44:36,083 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,092 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode = ? and t.starttime >=now() and substr(t.starttime,1,10) = ? order by t.starttime asc 
2019-06-18 12:44:36,093 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 051201002019(String), 2019-06-18(String)
2019-06-18 12:44:36,119 [http-nio-8080-exec-6] <==      Total: 12
2019-06-18 12:44:36,129 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,130 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180022(String)
2019-06-18 12:44:36,155 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,165 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,166 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:36,173 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,187 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,188 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 13:00:00(String)
2019-06-18 12:44:36,202 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,214 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,215 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180007(String)
2019-06-18 12:44:36,241 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,251 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,252 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:44:36,260 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,270 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,270 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 13:40:00(String)
2019-06-18 12:44:36,282 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,297 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,298 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180029(String)
2019-06-18 12:44:36,321 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,332 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,333 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:44:36,342 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,354 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,355 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 14:20:00(String)
2019-06-18 12:44:36,367 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,377 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,378 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180023(String)
2019-06-18 12:44:36,403 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,414 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,415 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:36,423 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,434 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,435 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 15:10:00(String)
2019-06-18 12:44:36,463 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,473 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,473 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180008(String)
2019-06-18 12:44:36,495 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,504 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,504 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:44:36,511 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,521 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,521 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 16:30:00(String)
2019-06-18 12:44:36,532 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,542 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,542 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180024(String)
2019-06-18 12:44:36,566 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,576 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,576 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:36,584 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,598 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,598 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 17:20:00(String)
2019-06-18 12:44:36,609 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,616 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,617 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180031(String)
2019-06-18 12:44:36,641 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,649 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,650 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:44:36,658 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,667 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,667 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 18:00:00(String)
2019-06-18 12:44:36,680 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,690 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,691 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180025(String)
2019-06-18 12:44:36,718 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,730 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,732 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:36,742 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,753 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,754 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 19:30:00(String)
2019-06-18 12:44:36,763 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,771 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,772 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180010(String)
2019-06-18 12:44:36,800 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,809 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,810 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:44:36,817 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,826 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,827 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 20:10:00(String)
2019-06-18 12:44:36,838 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,847 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,849 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180032(String)
2019-06-18 12:44:36,874 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,885 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,886 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:44:36,898 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,909 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,910 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 20:55:00(String)
2019-06-18 12:44:36,919 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,929 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,929 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180026(String)
2019-06-18 12:44:36,953 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,962 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:36,963 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:36,970 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:36,979 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:36,980 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 21:40:00(String)
2019-06-18 12:44:36,989 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:36,999 [http-nio-8080-exec-6] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:36,999 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 1683201906180011(String)
2019-06-18 12:44:37,022 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:37,032 [http-nio-8080-exec-6] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:37,033 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:44:37,039 [http-nio-8080-exec-6] <==      Total: 1
2019-06-18 12:44:37,049 [http-nio-8080-exec-6] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:37,050 [http-nio-8080-exec-6] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 22:20:00(String)
2019-06-18 12:44:37,061 [http-nio-8080-exec-6] <==      Total: 3
2019-06-18 12:44:55,289 [http-nio-8080-exec-9] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 12:44:55,290 [http-nio-8080-exec-9] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 12:44:55,308 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,318 [http-nio-8080-exec-9] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-06-18 12:44:55,319 [http-nio-8080-exec-9] ==> Parameters: 33111001(String)
2019-06-18 12:44:55,327 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,335 [http-nio-8080-exec-9] ==>  Preparing: select * from filminfo t where t.filmcode = ? 
2019-06-18 12:44:55,335 [http-nio-8080-exec-9] ==> Parameters: 051201002019(String)
2019-06-18 12:44:55,342 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,352 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode=? and t.starttime >= ? group by substr(t.starttime,1,10) 
2019-06-18 12:44:55,353 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 051201002019(String), 2019-06-18 12:44:55(String)
2019-06-18 12:44:55,378 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,391 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.filmcode = ? and t.starttime >=now() and substr(t.starttime,1,10) = ? order by t.starttime asc 
2019-06-18 12:44:55,392 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 051201002019(String), 2019-06-18(String)
2019-06-18 12:44:55,416 [http-nio-8080-exec-9] <==      Total: 12
2019-06-18 12:44:55,424 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:55,426 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180022(String)
2019-06-18 12:44:55,453 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,462 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:55,463 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:55,471 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,480 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:55,481 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 13:00:00(String)
2019-06-18 12:44:55,490 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:55,500 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:55,500 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180007(String)
2019-06-18 12:44:55,524 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,532 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:55,532 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:44:55,540 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,549 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:55,549 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 13:40:00(String)
2019-06-18 12:44:55,559 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:55,566 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:55,567 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180029(String)
2019-06-18 12:44:55,598 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,607 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:55,608 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:44:55,615 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,624 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:55,625 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 14:20:00(String)
2019-06-18 12:44:55,638 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:55,648 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:55,648 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180023(String)
2019-06-18 12:44:55,675 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,684 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:55,685 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:55,696 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,706 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:55,707 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 15:10:00(String)
2019-06-18 12:44:55,720 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:55,732 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:55,733 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180008(String)
2019-06-18 12:44:55,759 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,769 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:55,769 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:44:55,776 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,786 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:55,787 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 16:30:00(String)
2019-06-18 12:44:55,796 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:55,804 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:55,805 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180024(String)
2019-06-18 12:44:55,832 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,840 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:55,841 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:55,848 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,856 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:55,857 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 17:20:00(String)
2019-06-18 12:44:55,867 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:55,876 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:55,876 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180031(String)
2019-06-18 12:44:55,901 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,912 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:55,913 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:44:55,920 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,931 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:55,931 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 18:00:00(String)
2019-06-18 12:44:55,941 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:55,951 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:55,951 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180025(String)
2019-06-18 12:44:55,975 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:55,988 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:55,989 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:55,997 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,007 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:56,008 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 19:30:00(String)
2019-06-18 12:44:56,019 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:56,031 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:56,031 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180010(String)
2019-06-18 12:44:56,056 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,066 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:56,067 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:44:56,074 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,083 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:56,084 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 20:10:00(String)
2019-06-18 12:44:56,093 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:56,103 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:56,103 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180032(String)
2019-06-18 12:44:56,130 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,140 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:56,141 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000007(String)
2019-06-18 12:44:56,149 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,157 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:56,158 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 4号厅(String), 2019-06-18 20:55:00(String)
2019-06-18 12:44:56,167 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:56,177 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:56,178 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180026(String)
2019-06-18 12:44:56,202 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,212 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:56,212 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000009(String)
2019-06-18 12:44:56,220 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,230 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:56,231 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1号激光巨幕厅(String), 2019-06-18 21:40:00(String)
2019-06-18 12:44:56,239 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:44:56,249 [http-nio-8080-exec-9] ==>  Preparing: select * from sessioninfoview t where t.cinemacode = ? and t.scode = ? 
2019-06-18 12:44:56,250 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 1683201906180011(String)
2019-06-18 12:44:56,277 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,286 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.scode=? 
2019-06-18 12:44:56,287 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 0000000000000006(String)
2019-06-18 12:44:56,294 [http-nio-8080-exec-9] <==      Total: 1
2019-06-18 12:44:56,303 [http-nio-8080-exec-9] ==>  Preparing: select * from qmmprice t where t.cinemacode = ? and t.screenName = ? and t.showtime = ? 
2019-06-18 12:44:56,303 [http-nio-8080-exec-9] ==> Parameters: 33111001(String), 3号厅(String), 2019-06-18 22:20:00(String)
2019-06-18 12:44:56,311 [http-nio-8080-exec-9] <==      Total: 3
2019-06-18 12:51:07,575 [http-nio-8080-exec-2] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 12:51:07,704 [http-nio-8080-exec-2] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 12:51:07,732 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:51:07,807 [http-nio-8080-exec-2] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 12:51:07,810 [http-nio-8080-exec-2] ==> Parameters: 12(Long), 33111001(String)
2019-06-18 12:51:07,821 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 12:51:07,834 [http-nio-8080-exec-2] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 12:51:07,836 [http-nio-8080-exec-2] ==> Parameters: 33111001(String), 6636c761-1f46-4709-bfa6-17cb24056313(String)
2019-06-18 12:51:07,846 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 12:53:41,156 [http-nio-8080-exec-5] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-06-18 12:53:41,158 [http-nio-8080-exec-5] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-06-18 12:53:41,164 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:53:41,200 [http-nio-8080-exec-5] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-06-18 12:53:41,201 [http-nio-8080-exec-5] ==> Parameters: 12(Long), 33111001(String)
2019-06-18 12:53:41,209 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:53:41,232 [http-nio-8080-exec-5] ==>  Preparing: select * from goods t where t.cinemacode = ? and goodscode = ? 
2019-06-18 12:53:41,234 [http-nio-8080-exec-5] ==> Parameters: 33111001(String), 6636c761-1f46-4709-bfa6-17cb24056313(String)
2019-06-18 12:53:41,246 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:53:42,118 [http-nio-8080-exec-5] ==>  Preparing: insert into goodsorders(Id, CinemaCode, UserId, LocalOrderCode, OrderCode, PickUpCode, VerifyCode, OrderStatus, TotalPrice, TotalSettlePrice, TotalFee, SubmitTime, Created, Updated, MobilePhone, GoodsCount,RefundTradeNo, RefundTime, PickUpTime, DeliveryType, DeliveryAddress, DeliveryTime, DeliveryMark,IsReady, OrderPayFlag, OrderPayType, OrderPayTime, OrderTradeNo, PayType, PaySeqNo, CardNo, CardPassword, ErrorMessage,OpenID,CouponsCode,CouponsPrice) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?) 
2019-06-18 12:53:42,124 [http-nio-8080-exec-5] ==> Parameters: null, 33111001(String), 12(Long), 1683190618000173(String), null, null, null, 1(Integer), 15.0(Double), 15.0(Double), 0.0(Double), null, 2019-06-18 12:53:42.068(Timestamp), null, null, 1(Integer), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
2019-06-18 12:53:42,152 [http-nio-8080-exec-5] <==    Updates: 1
2019-06-18 12:53:42,153 [http-nio-8080-exec-5] ==>  Preparing: select * from goodsorders t where t.localordercode = ? 
2019-06-18 12:53:42,154 [http-nio-8080-exec-5] ==> Parameters: 1683190618000173(String)
2019-06-18 12:53:42,167 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:53:42,168 [http-nio-8080-exec-5] ==>  Preparing: insert into goodsorderdetails(Id, OrderId, GoodsCode, GoodsName, StandardPrice, SettlePrice, ChannelFee, GoodsCount, SubTotalAmount,SubTotalSettleAmount, Created, Updated, IsPackage, GoodsDetail,ShowSeqNo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?,?) 
2019-06-18 12:53:42,172 [http-nio-8080-exec-5] ==> Parameters: null, 963(Long), 6636c761-1f46-4709-bfa6-17cb24056313(String), 布朗熊饮料杯（可乐）(String), 15.0(Double), 15.0(Double), 0.0(Double), 1(Integer), 15.0(Double), 15.0(Double), 2019-06-18 12:53:41.247(Timestamp), null, 0(Integer), null, 612(Integer)
2019-06-18 12:53:42,202 [http-nio-8080-exec-5] <==    Updates: 1
2019-06-18 12:53:42,268 [http-nio-8080-exec-5] ==>  Preparing: select * from goodsorders t where t.localordercode = ? 
2019-06-18 12:53:42,268 [http-nio-8080-exec-5] ==> Parameters: 1683190618000173(String)
2019-06-18 12:53:42,282 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:53:42,300 [http-nio-8080-exec-5] ==>  Preparing: select * from goodsorders t where t.localordercode = ? 
2019-06-18 12:53:42,300 [http-nio-8080-exec-5] ==> Parameters: 1683190618000173(String)
2019-06-18 12:53:42,308 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:53:42,329 [http-nio-8080-exec-5] ==>  Preparing: select * from goodsorderdetails t where t.orderid = ? 
2019-06-18 12:53:42,330 [http-nio-8080-exec-5] ==> Parameters: 963(Long)
2019-06-18 12:53:42,344 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 12:53:42,393 [http-nio-8080-exec-5] ==>  Preparing: update goodsorders t SET Id = ?, CinemaCode = ?, UserId = ?, LocalOrderCode = ?, OrderStatus = ?, TotalPrice = ?, TotalSettlePrice = ?, TotalFee = ?, Created = ?, GoodsCount = ?, DeliveryType = ?, DeliveryAddress = ?, DeliveryTime = ?, DeliveryMark = ?, IsReady = ?, OpenID = ? where t.id = ? 
2019-06-18 12:53:42,394 [http-nio-8080-exec-5] ==> Parameters: 963(Long), 33111001(String), 12(Long), 1683190618000173(String), 1(Integer), 15.0(Double), 15.0(Double), 0.0(Double), 2019-06-18 12:53:42.0(Timestamp), 1(Integer), 1(Integer), undefinedundefined[undefined](String), 2019-06-18 12:39:50(String), 哇哈哈哈(String), 1(Integer), 531a8548f9bc49118c4b1f6b41ce0f05(String), 963(Long)
2019-06-18 12:53:42,415 [http-nio-8080-exec-5] <==    Updates: 1
2019-06-18 12:53:42,436 [http-nio-8080-exec-5] ==>  Preparing: select * from coupons t where t.openid = ? and t.status = ? group by groupcode 
2019-06-18 12:53:42,440 [http-nio-8080-exec-5] ==> Parameters: 531a8548f9bc49118c4b1f6b41ce0f05(String), 1(Integer)
2019-06-18 12:53:42,450 [http-nio-8080-exec-5] <==      Total: 0
2019-06-18 13:03:59,853 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s ,(select id from sys_user WHERE id = ? ) sss where ss.id = s.id and (ss.createuserid = sss.id or ss.id = sss.id) 
2019-06-18 13:03:59,858 [http-nio-8080-exec-7] ==> Parameters: 2(Long)
2019-06-18 13:03:59,907 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 13:03:59,909 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 13:03:59,912 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 13:03:59,935 [http-nio-8080-exec-7] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s ,(select id from sys_user WHERE id = ? ) sss where ss.id = s.id and (ss.createuserid = sss.id or ss.id = sss.id) 
2019-06-18 13:03:59,936 [http-nio-8080-exec-7] ==> Parameters: 2(Long)
2019-06-18 13:03:59,949 [http-nio-8080-exec-1] <==      Total: 1
2019-06-18 13:03:59,957 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 13:03:59,968 [http-nio-8080-exec-1] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 13:03:59,971 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 13:03:59,994 [http-nio-8080-exec-1] <==      Total: 3
2019-06-18 13:04:00,009 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 13:04:00,023 [http-nio-8080-exec-2] ==> Parameters: 33097601(String)
2019-06-18 13:04:00,060 [http-nio-8080-exec-2] <==      Total: 0
2019-06-18 13:04:00,089 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 13:04:00,090 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 13:04:00,132 [http-nio-8080-exec-2] <==      Total: 2
2019-06-18 13:04:00,185 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 13:04:00,187 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String)
2019-06-18 13:04:00,198 [http-nio-8080-exec-3] <==      Total: 1
2019-06-18 13:04:00,233 [http-nio-8080-exec-3] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 13:04:00,235 [http-nio-8080-exec-3] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 13:04:00,247 [http-nio-8080-exec-3] <==      Total: 3
2019-06-18 13:04:03,075 [http-nio-8080-exec-4] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s ,(select id from sys_user WHERE id = ? ) sss where ss.id = s.id and (ss.createuserid = sss.id or ss.id = sss.id) 
2019-06-18 13:04:03,076 [http-nio-8080-exec-4] ==> Parameters: 2(Long)
2019-06-18 13:04:03,121 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 13:04:03,150 [http-nio-8080-exec-4] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s ,(select id from sys_user WHERE id = ? ) sss where ss.id = s.id and (ss.createuserid = sss.id or ss.id = sss.id) 
2019-06-18 13:04:03,151 [http-nio-8080-exec-4] ==> Parameters: 2(Long)
2019-06-18 13:04:03,176 [http-nio-8080-exec-4] <==      Total: 1
2019-06-18 13:04:03,242 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 13:04:03,242 [http-nio-8080-exec-8] ==> Parameters: 33097601(String)
2019-06-18 13:04:03,284 [http-nio-8080-exec-8] <==      Total: 0
2019-06-18 13:04:03,370 [http-nio-8080-exec-8] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 13:04:03,371 [http-nio-8080-exec-8] ==> Parameters: 
2019-06-18 13:04:03,408 [http-nio-8080-exec-8] <==      Total: 2
2019-06-18 13:04:06,014 [http-nio-8080-exec-1] ==>  Preparing: select * from ticketusers t 
2019-06-18 13:04:06,016 [http-nio-8080-exec-1] ==> Parameters: 
2019-06-18 13:04:06,131 [http-nio-8080-exec-1] <==      Total: 10
2019-06-18 13:04:08,044 [http-nio-8080-exec-7] ==>  Preparing: select * from ticketusers t 
2019-06-18 13:04:08,045 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 13:04:08,099 [http-nio-8080-exec-7] <==      Total: 10
2019-06-18 13:04:08,885 [http-nio-8080-exec-10] ==>  Preparing: select * from ticketusers t 
2019-06-18 13:04:08,885 [http-nio-8080-exec-2] ==>  Preparing: select * from couponsgroup t where t.groupcode = ? 
2019-06-18 13:04:08,885 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 13:04:08,885 [http-nio-8080-exec-2] ==> Parameters: 1560789353743900(String)
2019-06-18 13:04:08,940 [http-nio-8080-exec-10] <==      Total: 10
2019-06-18 13:04:08,957 [http-nio-8080-exec-2] <==      Total: 1
2019-06-18 13:04:09,011 [http-nio-8080-exec-2] ==>  Preparing: select * from ticketusers t 
2019-06-18 13:04:09,011 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 13:04:09,074 [http-nio-8080-exec-2] <==      Total: 10
2019-06-18 13:04:09,153 [http-nio-8080-exec-2] ==>  Preparing: select * from ticketusers t 
2019-06-18 13:04:09,155 [http-nio-8080-exec-2] ==> Parameters: 
2019-06-18 13:04:09,250 [http-nio-8080-exec-2] <==      Total: 10
2019-06-18 13:04:09,355 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,362 [http-nio-8080-exec-2] ==> Parameters: 156083424935317995(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 13:04:09.354(Timestamp), null
2019-06-18 13:04:09,387 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,389 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,392 [http-nio-8080-exec-2] ==> Parameters: 156083424938951434(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 13:04:09.389(Timestamp), null
2019-06-18 13:04:09,429 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,431 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,433 [http-nio-8080-exec-2] ==> Parameters: 156083424943135709(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 13:04:09.431(Timestamp), null
2019-06-18 13:04:09,471 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,473 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,474 [http-nio-8080-exec-2] ==> Parameters: 156083424947321490(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 13:04:09.473(Timestamp), null
2019-06-18 13:04:09,497 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,498 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,498 [http-nio-8080-exec-2] ==> Parameters: 156083424949889461(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 13:04:09.498(Timestamp), null
2019-06-18 13:04:09,528 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,529 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,530 [http-nio-8080-exec-2] ==> Parameters: 156083424952939970(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 13:04:09.529(Timestamp), null
2019-06-18 13:04:09,583 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,583 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,584 [http-nio-8080-exec-2] ==> Parameters: 156083424958344920(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 13:04:09.583(Timestamp), null
2019-06-18 13:04:09,667 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,669 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,671 [http-nio-8080-exec-2] ==> Parameters: 156083424966934299(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65GgIVRaQcSM75DrVPfgbt9M(String), 2019-06-18 13:04:09.669(Timestamp), null
2019-06-18 13:04:09,731 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,732 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,733 [http-nio-8080-exec-2] ==> Parameters: 156083424973287748(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65D72mq3YFZNGpuRGLUBJSNk(String), 2019-06-18 13:04:09.732(Timestamp), null
2019-06-18 13:04:09,793 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,794 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,796 [http-nio-8080-exec-2] ==> Parameters: 156083424979475378(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65NgA87eXpd18QDCy_Ck844Q(String), 2019-06-18 13:04:09.794(Timestamp), null
2019-06-18 13:04:09,821 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,823 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,824 [http-nio-8080-exec-2] ==> Parameters: 156083424982226276(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 13:04:09.822(Timestamp), null
2019-06-18 13:04:09,864 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,866 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,867 [http-nio-8080-exec-2] ==> Parameters: 156083424986656294(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 13:04:09.866(Timestamp), null
2019-06-18 13:04:09,927 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,929 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,930 [http-nio-8080-exec-2] ==> Parameters: 156083424992847769(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 13:04:09.928(Timestamp), null
2019-06-18 13:04:09,958 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:09,960 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:09,963 [http-nio-8080-exec-2] ==> Parameters: 156083424995934282(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 13:04:09.959(Timestamp), null
2019-06-18 13:04:10,016 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,018 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,018 [http-nio-8080-exec-2] ==> Parameters: 156083425001748929(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 13:04:10.017(Timestamp), null
2019-06-18 13:04:10,045 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,045 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,046 [http-nio-8080-exec-2] ==> Parameters: 156083425004553285(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 13:04:10.045(Timestamp), null
2019-06-18 13:04:10,077 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,078 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,078 [http-nio-8080-exec-2] ==> Parameters: 156083425007881403(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 13:04:10.078(Timestamp), null
2019-06-18 13:04:10,117 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,118 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,118 [http-nio-8080-exec-2] ==> Parameters: 156083425011784197(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65GgIVRaQcSM75DrVPfgbt9M(String), 2019-06-18 13:04:10.117(Timestamp), null
2019-06-18 13:04:10,154 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,156 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,157 [http-nio-8080-exec-2] ==> Parameters: 156083425015696041(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65D72mq3YFZNGpuRGLUBJSNk(String), 2019-06-18 13:04:10.156(Timestamp), null
2019-06-18 13:04:10,193 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,195 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,197 [http-nio-8080-exec-2] ==> Parameters: 156083425019534214(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65NgA87eXpd18QDCy_Ck844Q(String), 2019-06-18 13:04:10.195(Timestamp), null
2019-06-18 13:04:10,222 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,224 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,225 [http-nio-8080-exec-2] ==> Parameters: 156083425022424905(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 13:04:10.224(Timestamp), null
2019-06-18 13:04:10,249 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,250 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,251 [http-nio-8080-exec-2] ==> Parameters: 156083425025042071(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 13:04:10.25(Timestamp), null
2019-06-18 13:04:10,303 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,305 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,306 [http-nio-8080-exec-2] ==> Parameters: 156083425030443895(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 13:04:10.304(Timestamp), null
2019-06-18 13:04:10,330 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,332 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,333 [http-nio-8080-exec-2] ==> Parameters: 156083425033126798(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 13:04:10.331(Timestamp), null
2019-06-18 13:04:10,469 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,471 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,474 [http-nio-8080-exec-2] ==> Parameters: 156083425047137251(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 13:04:10.471(Timestamp), null
2019-06-18 13:04:10,507 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,508 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,508 [http-nio-8080-exec-2] ==> Parameters: 156083425050899405(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 13:04:10.508(Timestamp), null
2019-06-18 13:04:10,527 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:10,528 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:10,528 [http-nio-8080-exec-2] ==> Parameters: 156083425052856047(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 13:04:10.528(Timestamp), null
2019-06-18 13:04:11,255 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:11,257 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:11,259 [http-nio-8080-exec-2] ==> Parameters: 156083425125758223(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65GgIVRaQcSM75DrVPfgbt9M(String), 2019-06-18 13:04:11.257(Timestamp), null
2019-06-18 13:04:14,440 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:14,443 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:14,446 [http-nio-8080-exec-2] ==> Parameters: 156083425444378615(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65D72mq3YFZNGpuRGLUBJSNk(String), 2019-06-18 13:04:14.443(Timestamp), null
2019-06-18 13:04:17,896 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:17,898 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:17,900 [http-nio-8080-exec-2] ==> Parameters: 156083425789863914(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65NgA87eXpd18QDCy_Ck844Q(String), 2019-06-18 13:04:17.898(Timestamp), null
2019-06-18 13:04:22,690 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:22,692 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:22,694 [http-nio-8080-exec-2] ==> Parameters: 156083426269231050(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 13:04:22.692(Timestamp), null
2019-06-18 13:04:23,941 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:23,944 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:23,946 [http-nio-8080-exec-2] ==> Parameters: 156083426394462102(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 13:04:23.944(Timestamp), null
2019-06-18 13:04:24,857 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:24,860 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:24,861 [http-nio-8080-exec-2] ==> Parameters: 156083426485989711(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 13:04:24.859(Timestamp), null
2019-06-18 13:04:25,927 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:25,929 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:25,931 [http-nio-8080-exec-2] ==> Parameters: 156083426592983723(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 13:04:25.929(Timestamp), null
2019-06-18 13:04:27,584 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:27,585 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:27,585 [http-nio-8080-exec-2] ==> Parameters: 156083426758555837(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 13:04:27.585(Timestamp), null
2019-06-18 13:04:28,666 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:28,668 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:28,670 [http-nio-8080-exec-2] ==> Parameters: 156083426866822199(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 13:04:28.668(Timestamp), null
2019-06-18 13:04:28,809 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:28,811 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:28,813 [http-nio-8080-exec-2] ==> Parameters: 156083426881150842(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 13:04:28.811(Timestamp), null
2019-06-18 13:04:29,493 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:29,494 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:29,494 [http-nio-8080-exec-2] ==> Parameters: 156083426949485098(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65GgIVRaQcSM75DrVPfgbt9M(String), 2019-06-18 13:04:29.494(Timestamp), null
2019-06-18 13:04:29,748 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:29,750 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:29,751 [http-nio-8080-exec-2] ==> Parameters: 156083426974911975(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65D72mq3YFZNGpuRGLUBJSNk(String), 2019-06-18 13:04:29.749(Timestamp), null
2019-06-18 13:04:29,895 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:29,896 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:29,897 [http-nio-8080-exec-2] ==> Parameters: 156083426989676723(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65NgA87eXpd18QDCy_Ck844Q(String), 2019-06-18 13:04:29.896(Timestamp), null
2019-06-18 13:04:29,980 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:29,981 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:29,982 [http-nio-8080-exec-2] ==> Parameters: 156083426998194120(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4uAj-qCrFqIPCO3xYAh6Gks(String), 2019-06-18 13:04:29.981(Timestamp), null
2019-06-18 13:04:30,011 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:30,011 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:30,012 [http-nio-8080-exec-2] ==> Parameters: 156083427001198857(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jdhotZGqB-cB1DMVF7f334(String), 2019-06-18 13:04:30.011(Timestamp), null
2019-06-18 13:04:30,167 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:30,168 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:30,169 [http-nio-8080-exec-2] ==> Parameters: 156083427016848692(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4q66ZIKIPegpaDHU7zJ618c(String), 2019-06-18 13:04:30.168(Timestamp), null
2019-06-18 13:04:30,345 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:30,346 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:30,347 [http-nio-8080-exec-2] ==> Parameters: 156083427034694409(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4jbp2TkTNZka6UGoAu7lx-A(String), 2019-06-18 13:04:30.346(Timestamp), null
2019-06-18 13:04:30,576 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:30,577 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:30,577 [http-nio-8080-exec-2] ==> Parameters: 156083427057773596(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), o9gGQ4hXRXfg6ZqCepqFkg2xBWYU(String), 2019-06-18 13:04:30.577(Timestamp), null
2019-06-18 13:04:30,878 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:30,880 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:30,883 [http-nio-8080-exec-2] ==> Parameters: 156083427088013755(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65AHDpaU3mg900att0-szd8w(String), 2019-06-18 13:04:30.88(Timestamp), null
2019-06-18 13:04:30,954 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:30,954 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:30,955 [http-nio-8080-exec-2] ==> Parameters: 156083427095484831(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65I-SfFEh0xuzJnw74yN_5Wc(String), 2019-06-18 13:04:30.954(Timestamp), null
2019-06-18 13:04:31,378 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:31,380 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:31,382 [http-nio-8080-exec-2] ==> Parameters: 156083427138015049(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65GgIVRaQcSM75DrVPfgbt9M(String), 2019-06-18 13:04:31.38(Timestamp), null
2019-06-18 13:04:32,074 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:32,074 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:32,075 [http-nio-8080-exec-2] ==> Parameters: 156083427207455758(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65D72mq3YFZNGpuRGLUBJSNk(String), 2019-06-18 13:04:32.074(Timestamp), null
2019-06-18 13:04:33,037 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:33,037 [http-nio-8080-exec-2] ==>  Preparing: insert into coupons(CouponsCode, CouponsName, EffectiveDate, ExpireDate, GroupCode, Status, OpenID, CreateDate, ReceiveDate, UsedDate) values(?, ?, ?, ?, ?, ?, ?, Now(), ?, ?) 
2019-06-18 13:04:33,038 [http-nio-8080-exec-2] ==> Parameters: 156083427303717395(String), 5元影片优惠券(String), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1560789353743900(String), 1(Integer), oNCc65NgA87eXpd18QDCy_Ck844Q(String), 2019-06-18 13:04:33.037(Timestamp), null
2019-06-18 13:04:33,943 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:33,956 [http-nio-8080-exec-2] ==>  Preparing: update couponsgroup t SET Id = ?, GroupCode = ?, CouponsType = ?, CouponsName = ?, ValidityType = ?, EffectiveDate = ?, ExpireDate = ?, CanUsePeriodType = ?, WeekDays = ?, TimePeriod = ?, LimitNum = ?, ReductionType = ?, InitialAmount = ?, ReductionPrice = ?, FilmCodes = ?, GoodsCodes = ?, IsShare = ?, Remark = ?, CanUseCinemaType = ?, CinemaCodes = ?, Status = ?, CouponsNumber = ?, IssuedNumber = ?, FetchNumber = ?, RemainingNumber = ?, UsedNumber = ?, GiftType = ?, UpdateDate = ? where t.id = ? 
2019-06-18 13:04:33,961 [http-nio-8080-exec-2] ==> Parameters: 61(Long), 1560789353743900(String), 1(Integer), 5元影片优惠券(String), 1(Integer), 2019-06-18 00:00:00.0(Timestamp), 2019-06-30 00:00:00.0(Timestamp), 1(Integer), (String), (String), 10(Integer), 1(Integer), 0.0(Double), 5.0(Double), (String), (String), 0(Integer), (String), 1(Integer), (String), 1(Integer), 10000(Integer), 90(Integer), 90(Integer), 9910(Integer), 25(Integer), 2(String), 2019-06-18 13:04:33.945(Timestamp), 61(Long)
2019-06-18 13:04:34,454 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:35,149 [http-nio-8080-exec-2] ==>  Preparing: insert into coupondistributionrecord(Id, GroupCode, CustomerType, OpenID, Issuer, IssuedNumber, IssuedTime, Status) values(?, ?, ?, ?, ?, ?, now(), ?) 
2019-06-18 13:04:35,151 [http-nio-8080-exec-2] ==> Parameters: null, 1560789353743900(String), 1(Integer), (String), 33097601(String), 50(Integer), 1(Integer)
2019-06-18 13:04:35,494 [http-nio-8080-exec-2] <==    Updates: 1
2019-06-18 13:04:36,882 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s ,(select id from sys_user WHERE id = ? ) sss where ss.id = s.id and (ss.createuserid = sss.id or ss.id = sss.id) 
2019-06-18 13:04:36,884 [http-nio-8080-exec-5] ==> Parameters: 2(Long)
2019-06-18 13:04:36,916 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 13:04:36,933 [http-nio-8080-exec-5] ==>  Preparing: select ss.* from sys_user ss,(select id,cinemacode,cinemaname from sys_user where roleid = 4 and status = 1) s ,(select id from sys_user WHERE id = ? ) sss where ss.id = s.id and (ss.createuserid = sss.id or ss.id = sss.id) 
2019-06-18 13:04:36,933 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from coupondistributionrecord t 
2019-06-18 13:04:36,935 [http-nio-8080-exec-5] ==> Parameters: 2(Long)
2019-06-18 13:04:36,935 [http-nio-8080-exec-7] ==> Parameters: 
2019-06-18 13:04:36,961 [http-nio-8080-exec-7] <==      Total: 1
2019-06-18 13:04:37,026 [http-nio-8080-exec-5] <==      Total: 1
2019-06-18 13:04:37,042 [http-nio-8080-exec-7] ==>  Preparing: select * from coupondistributionrecord t limit ?, ? 
2019-06-18 13:04:37,042 [http-nio-8080-exec-7] ==> Parameters: 0(Integer), 10(Integer)
2019-06-18 13:04:37,080 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where find_in_set(?,cinemacodes) and status = 1 
2019-06-18 13:04:37,081 [http-nio-8080-exec-10] ==> Parameters: 33097601(String)
2019-06-18 13:04:37,094 [http-nio-8080-exec-7] <==      Total: 4
2019-06-18 13:04:37,126 [http-nio-8080-exec-10] <==      Total: 0
2019-06-18 13:04:37,150 [http-nio-8080-exec-10] ==>  Preparing: select * from couponsgroup where canusecinematype =1 
2019-06-18 13:04:37,150 [http-nio-8080-exec-10] ==> Parameters: 
2019-06-18 13:04:37,189 [http-nio-8080-exec-10] <==      Total: 2
2019-06-18 13:04:37,221 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) 
2019-06-18 13:04:37,222 [http-nio-8080-exec-8] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String)
2019-06-18 13:04:37,229 [http-nio-8080-exec-8] <==      Total: 1
2019-06-18 13:04:37,264 [http-nio-8080-exec-8] ==>  Preparing: select * from coupondistributionrecord t WHERE (GroupCode = ? or find_in_set(GroupCode,?)) limit ?, ? 
2019-06-18 13:04:37,264 [http-nio-8080-exec-8] ==> Parameters: 1560789303576581,1560789353743900(String), 1560789303576581,1560789353743900(String), 0(Integer), 10(Integer)
2019-06-18 13:04:37,276 [http-nio-8080-exec-8] <==      Total: 4
