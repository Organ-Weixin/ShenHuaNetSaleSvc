2019-03-28 21:47:17,236 [http-nio-8080-exec-3] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-03-28 21:47:17,272 [http-nio-8080-exec-3] ==> Parameters: admin(String)
2019-03-28 21:47:17,310 [http-nio-8080-exec-3] <==      Total: 1
2019-03-28 21:47:17,339 [http-nio-8080-exec-3] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2019-03-28 21:47:17,345 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-03-28 21:47:17,381 [http-nio-8080-exec-3] <==      Total: 39
2019-03-28 21:47:21,835 [http-nio-8080-exec-6] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-03-28 21:47:21,836 [http-nio-8080-exec-6] ==> Parameters: admin(String)
2019-03-28 21:47:21,839 [http-nio-8080-exec-6] <==      Total: 1
2019-03-28 21:47:21,841 [http-nio-8080-exec-6] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2019-03-28 21:47:21,842 [http-nio-8080-exec-6] ==> Parameters: 1(Long)
2019-03-28 21:47:21,851 [http-nio-8080-exec-6] <==      Total: 39
2019-03-28 21:47:22,082 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:47:22,100 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-03-28 21:47:22,115 [taskExecutor-1] <==    Updates: 1
2019-03-28 21:47:23,374 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-03-28 21:47:23,378 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-03-28 21:47:23,389 [http-nio-8080-exec-2] <==      Total: 1
2019-03-28 21:47:41,079 [http-nio-8080-exec-5] ==>  Preparing: select * from sys_permission t order by t.sort 
2019-03-28 21:47:41,081 [http-nio-8080-exec-5] ==> Parameters: 
2019-03-28 21:47:41,090 [http-nio-8080-exec-5] <==      Total: 39
2019-03-28 21:47:43,747 [http-nio-8080-exec-8] ==>  Preparing: select * from sys_permission t where t.type = 1 order by t.sort 
2019-03-28 21:47:43,750 [http-nio-8080-exec-8] ==> Parameters: 
2019-03-28 21:47:43,757 [http-nio-8080-exec-8] <==      Total: 16
2019-03-28 21:49:23,329 [http-nio-8080-exec-8] ==>  Preparing: insert into sys_permission(parentId, name, css, href, type, permission, sort) values(?, ?, ?, ?, ?, ?, ?) 
2019-03-28 21:49:23,337 [http-nio-8080-exec-8] ==> Parameters: 0(Long), 影院管理(String), fa-behance-square(String), pages/screeninfo/screeninfoList.html(String), 1(Integer), (String), 100(Integer)
2019-03-28 21:49:23,341 [http-nio-8080-exec-8] <==    Updates: 1
2019-03-28 21:49:23,353 [taskExecutor-2] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:49:23,356 [taskExecutor-2] ==> Parameters: 1(Long), 保存菜单(String), true(Boolean), null
2019-03-28 21:49:23,364 [taskExecutor-2] <==    Updates: 1
2019-03-28 21:49:24,774 [http-nio-8080-exec-5] ==>  Preparing: select * from sys_permission t order by t.sort 
2019-03-28 21:49:24,776 [http-nio-8080-exec-5] ==> Parameters: 
2019-03-28 21:49:24,786 [http-nio-8080-exec-5] <==      Total: 40
2019-03-28 21:49:28,995 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-03-28 21:49:28,999 [http-nio-8080-exec-9] ==> Parameters: 1(Long)
2019-03-28 21:49:29,002 [http-nio-8080-exec-9] <==      Total: 1
2019-03-28 21:49:38,058 [http-nio-8080-exec-1] ==>  Preparing: select count(1) from sys_role t 
2019-03-28 21:49:38,061 [http-nio-8080-exec-1] ==> Parameters: 
2019-03-28 21:49:38,067 [http-nio-8080-exec-1] <==      Total: 1
2019-03-28 21:49:38,078 [http-nio-8080-exec-1] ==>  Preparing: select * from sys_role t order by updateTime desc limit ?, ? 
2019-03-28 21:49:38,083 [http-nio-8080-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2019-03-28 21:49:38,087 [http-nio-8080-exec-1] <==      Total: 2
2019-03-28 21:49:41,880 [http-nio-8080-exec-3] ==>  Preparing: select * from sys_permission t order by t.sort 
2019-03-28 21:49:41,882 [http-nio-8080-exec-3] ==> Parameters: 
2019-03-28 21:49:41,888 [http-nio-8080-exec-3] <==      Total: 40
2019-03-28 21:49:41,976 [http-nio-8080-exec-1] ==>  Preparing: select * from sys_role t where t.id = ? 
2019-03-28 21:49:41,979 [http-nio-8080-exec-1] ==> Parameters: 1(Long)
2019-03-28 21:49:41,981 [http-nio-8080-exec-1] <==      Total: 1
2019-03-28 21:49:42,004 [http-nio-8080-exec-6] ==>  Preparing: select p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId where rp.roleId = ? order by p.sort 
2019-03-28 21:49:42,008 [http-nio-8080-exec-6] ==> Parameters: 1(Long)
2019-03-28 21:49:42,018 [http-nio-8080-exec-6] <==      Total: 39
2019-03-28 21:49:47,937 [http-nio-8080-exec-10] ==>  Preparing: select * from sys_role t where t.name = ? 
2019-03-28 21:49:47,941 [http-nio-8080-exec-10] ==> Parameters: ADMIN(String)
2019-03-28 21:49:47,946 [http-nio-8080-exec-10] <==      Total: 1
2019-03-28 21:49:47,947 [http-nio-8080-exec-10] ==>  Preparing: update sys_role t set t.name = ?, t.description = ?, updateTime = now() where t.id = ? 
2019-03-28 21:49:47,951 [http-nio-8080-exec-10] ==> Parameters: ADMIN(String), 管理员(String), 1(Long)
2019-03-28 21:49:47,953 [http-nio-8080-exec-10] <==    Updates: 1
2019-03-28 21:49:47,955 [http-nio-8080-exec-10] ==>  Preparing: delete from sys_role_permission where roleId = ? 
2019-03-28 21:49:47,957 [http-nio-8080-exec-10] ==> Parameters: 1(Long)
2019-03-28 21:49:47,960 [http-nio-8080-exec-10] <==    Updates: 39
2019-03-28 21:49:47,967 [http-nio-8080-exec-10] ==>  Preparing: insert into sys_role_permission(roleId, permissionId) values (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) 
2019-03-28 21:49:47,975 [http-nio-8080-exec-10] ==> Parameters: 1(Long), 1(Long), 1(Long), 2(Long), 1(Long), 3(Long), 1(Long), 4(Long), 1(Long), 6(Long), 1(Long), 7(Long), 1(Long), 8(Long), 1(Long), 9(Long), 1(Long), 10(Long), 1(Long), 11(Long), 1(Long), 12(Long), 1(Long), 13(Long), 1(Long), 14(Long), 1(Long), 15(Long), 1(Long), 16(Long), 1(Long), 17(Long), 1(Long), 18(Long), 1(Long), 19(Long), 1(Long), 20(Long), 1(Long), 21(Long), 1(Long), 22(Long), 1(Long), 23(Long), 1(Long), 24(Long), 1(Long), 25(Long), 1(Long), 26(Long), 1(Long), 27(Long), 1(Long), 28(Long), 1(Long), 29(Long), 1(Long), 30(Long), 1(Long), 31(Long), 1(Long), 32(Long), 1(Long), 33(Long), 1(Long), 34(Long), 1(Long), 35(Long), 1(Long), 36(Long), 1(Long), 37(Long), 1(Long), 38(Long), 1(Long), 39(Long), 1(Long), 40(Long), 1(Long), 41(Long)
2019-03-28 21:49:47,980 [http-nio-8080-exec-10] <==    Updates: 40
2019-03-28 21:49:47,994 [taskExecutor-3] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:49:47,997 [taskExecutor-3] ==> Parameters: 1(Long), 保存角色(String), true(Boolean), null
2019-03-28 21:49:48,000 [taskExecutor-3] <==    Updates: 1
2019-03-28 21:49:49,591 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from sys_role t 
2019-03-28 21:49:49,593 [http-nio-8080-exec-3] ==> Parameters: 
2019-03-28 21:49:49,597 [http-nio-8080-exec-3] <==      Total: 1
2019-03-28 21:49:49,601 [http-nio-8080-exec-3] ==>  Preparing: select * from sys_role t order by updateTime desc limit ?, ? 
2019-03-28 21:49:49,604 [http-nio-8080-exec-3] ==> Parameters: 0(Integer), 10(Integer)
2019-03-28 21:49:49,608 [http-nio-8080-exec-3] <==      Total: 2
2019-03-28 21:49:51,819 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-03-28 21:49:51,822 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-03-28 21:49:51,827 [http-nio-8080-exec-4] <==      Total: 1
2019-03-28 21:52:32,475 [taskExecutor-4] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:52:32,477 [taskExecutor-4] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-03-28 21:52:32,482 [taskExecutor-4] <==    Updates: 1
2019-03-28 21:52:38,454 [http-nio-8080-exec-7] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-03-28 21:52:38,455 [http-nio-8080-exec-7] ==> Parameters: admin(String)
2019-03-28 21:52:38,458 [http-nio-8080-exec-7] <==      Total: 1
2019-03-28 21:52:38,461 [http-nio-8080-exec-7] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2019-03-28 21:52:38,462 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-03-28 21:52:38,468 [http-nio-8080-exec-7] <==      Total: 40
2019-03-28 21:52:38,589 [taskExecutor-5] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:52:38,591 [taskExecutor-5] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-03-28 21:52:38,596 [taskExecutor-5] <==    Updates: 1
2019-03-28 21:52:38,975 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-03-28 21:52:38,976 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-03-28 21:52:38,983 [http-nio-8080-exec-3] <==      Total: 1
2019-03-28 21:52:56,417 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-03-28 21:52:56,420 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-03-28 21:52:56,423 [http-nio-8080-exec-2] <==      Total: 1
2019-03-28 21:55:19,709 [http-nio-8080-exec-5] ==>  Preparing: select * from sys_permission t order by t.sort 
2019-03-28 21:55:19,712 [http-nio-8080-exec-5] ==> Parameters: 
2019-03-28 21:55:19,718 [http-nio-8080-exec-5] <==      Total: 40
2019-03-28 21:55:21,797 [http-nio-8080-exec-6] ==>  Preparing: select * from sys_permission t where t.type = 1 order by t.sort 
2019-03-28 21:55:21,799 [http-nio-8080-exec-6] ==> Parameters: 
2019-03-28 21:55:21,803 [http-nio-8080-exec-6] <==      Total: 17
2019-03-28 21:55:42,765 [http-nio-8080-exec-4] ==>  Preparing: insert into sys_permission(parentId, name, css, href, type, permission, sort) values(?, ?, ?, ?, ?, ?, ?) 
2019-03-28 21:55:42,770 [http-nio-8080-exec-4] ==> Parameters: 41(Long), 查询(String), (String), (String), 2(Integer), (String), 100(Integer)
2019-03-28 21:55:42,775 [http-nio-8080-exec-4] <==    Updates: 1
2019-03-28 21:55:42,778 [taskExecutor-6] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:55:42,780 [taskExecutor-6] ==> Parameters: 1(Long), 保存菜单(String), true(Boolean), null
2019-03-28 21:55:42,785 [taskExecutor-6] <==    Updates: 1
2019-03-28 21:55:44,183 [http-nio-8080-exec-3] ==>  Preparing: select * from sys_permission t order by t.sort 
2019-03-28 21:55:44,185 [http-nio-8080-exec-3] ==> Parameters: 
2019-03-28 21:55:44,190 [http-nio-8080-exec-3] <==      Total: 41
2019-03-28 21:55:46,740 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from sys_role t 
2019-03-28 21:55:46,743 [http-nio-8080-exec-9] ==> Parameters: 
2019-03-28 21:55:46,745 [http-nio-8080-exec-9] <==      Total: 1
2019-03-28 21:55:46,748 [http-nio-8080-exec-9] ==>  Preparing: select * from sys_role t order by updateTime desc limit ?, ? 
2019-03-28 21:55:46,749 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-03-28 21:55:46,752 [http-nio-8080-exec-9] <==      Total: 2
2019-03-28 21:55:49,335 [http-nio-8080-exec-10] ==>  Preparing: select * from sys_permission t order by t.sort 
2019-03-28 21:55:49,337 [http-nio-8080-exec-10] ==> Parameters: 
2019-03-28 21:55:49,343 [http-nio-8080-exec-10] <==      Total: 41
2019-03-28 21:55:49,397 [http-nio-8080-exec-1] ==>  Preparing: select * from sys_role t where t.id = ? 
2019-03-28 21:55:49,398 [http-nio-8080-exec-1] ==> Parameters: 1(Long)
2019-03-28 21:55:49,400 [http-nio-8080-exec-1] <==      Total: 1
2019-03-28 21:55:49,414 [http-nio-8080-exec-7] ==>  Preparing: select p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId where rp.roleId = ? order by p.sort 
2019-03-28 21:55:49,416 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-03-28 21:55:49,421 [http-nio-8080-exec-7] <==      Total: 40
2019-03-28 21:55:58,159 [http-nio-8080-exec-7] ==>  Preparing: select * from sys_role t where t.name = ? 
2019-03-28 21:55:58,161 [http-nio-8080-exec-7] ==> Parameters: ADMIN(String)
2019-03-28 21:55:58,164 [http-nio-8080-exec-7] <==      Total: 1
2019-03-28 21:55:58,165 [http-nio-8080-exec-7] ==>  Preparing: update sys_role t set t.name = ?, t.description = ?, updateTime = now() where t.id = ? 
2019-03-28 21:55:58,166 [http-nio-8080-exec-7] ==> Parameters: ADMIN(String), 管理员(String), 1(Long)
2019-03-28 21:55:58,168 [http-nio-8080-exec-7] <==    Updates: 1
2019-03-28 21:55:58,169 [http-nio-8080-exec-7] ==>  Preparing: delete from sys_role_permission where roleId = ? 
2019-03-28 21:55:58,170 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-03-28 21:55:58,172 [http-nio-8080-exec-7] <==    Updates: 40
2019-03-28 21:55:58,174 [http-nio-8080-exec-7] ==>  Preparing: insert into sys_role_permission(roleId, permissionId) values (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) , (?, ?) 
2019-03-28 21:55:58,180 [http-nio-8080-exec-7] ==> Parameters: 1(Long), 1(Long), 1(Long), 2(Long), 1(Long), 3(Long), 1(Long), 4(Long), 1(Long), 6(Long), 1(Long), 7(Long), 1(Long), 8(Long), 1(Long), 9(Long), 1(Long), 10(Long), 1(Long), 11(Long), 1(Long), 12(Long), 1(Long), 13(Long), 1(Long), 14(Long), 1(Long), 15(Long), 1(Long), 16(Long), 1(Long), 17(Long), 1(Long), 18(Long), 1(Long), 19(Long), 1(Long), 20(Long), 1(Long), 21(Long), 1(Long), 22(Long), 1(Long), 23(Long), 1(Long), 24(Long), 1(Long), 25(Long), 1(Long), 26(Long), 1(Long), 27(Long), 1(Long), 28(Long), 1(Long), 29(Long), 1(Long), 30(Long), 1(Long), 31(Long), 1(Long), 32(Long), 1(Long), 33(Long), 1(Long), 34(Long), 1(Long), 35(Long), 1(Long), 36(Long), 1(Long), 37(Long), 1(Long), 38(Long), 1(Long), 39(Long), 1(Long), 40(Long), 1(Long), 41(Long), 1(Long), 42(Long)
2019-03-28 21:55:58,182 [http-nio-8080-exec-7] <==    Updates: 41
2019-03-28 21:55:58,189 [taskExecutor-7] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:55:58,191 [taskExecutor-7] ==> Parameters: 1(Long), 保存角色(String), true(Boolean), null
2019-03-28 21:55:58,196 [taskExecutor-7] <==    Updates: 1
2019-03-28 21:55:59,739 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from sys_role t 
2019-03-28 21:55:59,741 [http-nio-8080-exec-2] ==> Parameters: 
2019-03-28 21:55:59,742 [http-nio-8080-exec-2] <==      Total: 1
2019-03-28 21:55:59,745 [http-nio-8080-exec-2] ==>  Preparing: select * from sys_role t order by updateTime desc limit ?, ? 
2019-03-28 21:55:59,748 [http-nio-8080-exec-2] ==> Parameters: 0(Integer), 10(Integer)
2019-03-28 21:55:59,751 [http-nio-8080-exec-2] <==      Total: 2
2019-03-28 21:56:00,941 [http-nio-8080-exec-8] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-03-28 21:56:00,944 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-03-28 21:56:00,946 [http-nio-8080-exec-8] <==      Total: 1
2019-03-28 21:56:12,701 [taskExecutor-8] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:56:12,705 [taskExecutor-8] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-03-28 21:56:12,714 [taskExecutor-8] <==    Updates: 1
2019-03-28 21:56:17,676 [http-nio-8080-exec-6] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-03-28 21:56:17,677 [http-nio-8080-exec-6] ==> Parameters: admin(String)
2019-03-28 21:56:17,679 [http-nio-8080-exec-6] <==      Total: 1
2019-03-28 21:56:17,681 [http-nio-8080-exec-6] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2019-03-28 21:56:17,682 [http-nio-8080-exec-6] ==> Parameters: 1(Long)
2019-03-28 21:56:17,689 [http-nio-8080-exec-6] <==      Total: 41
2019-03-28 21:56:17,805 [taskExecutor-9] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-03-28 21:56:17,807 [taskExecutor-9] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-03-28 21:56:17,812 [taskExecutor-9] <==    Updates: 1
2019-03-28 21:56:18,074 [http-nio-8080-exec-10] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-03-28 21:56:18,076 [http-nio-8080-exec-10] ==> Parameters: 1(Long)
2019-03-28 21:56:18,079 [http-nio-8080-exec-10] <==      Total: 1
2019-03-28 22:01:11,259 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-03-28 22:01:11,332 [http-nio-8080-exec-5] ==> Parameters: 1(Long)
2019-03-28 22:01:11,408 [http-nio-8080-exec-5] <==      Total: 1
2019-03-28 22:01:14,198 [http-nio-8080-exec-9] ==>  Preparing: select count(1) from screeninfo t 
2019-03-28 22:01:14,201 [http-nio-8080-exec-9] ==> Parameters: 
2019-03-28 22:01:14,205 [http-nio-8080-exec-9] <==      Total: 1
2019-03-28 22:01:14,211 [http-nio-8080-exec-9] ==>  Preparing: select * from screeninfo t limit ?, ? 
2019-03-28 22:01:14,216 [http-nio-8080-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2019-03-28 22:01:14,235 [http-nio-8080-exec-9] <==      Total: 10
