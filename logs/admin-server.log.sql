2019-04-22 09:27:27,665 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 09:27:28,050 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 09:27:28,085 [main] <==      Total: 1
2019-04-22 09:27:28,097 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 09:27:28,099 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 09:27:28,111 [main] <==      Total: 1
2019-04-22 09:27:28,120 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 09:27:28,122 [main] ==> Parameters: 33097601(String), 2(String)
2019-04-22 09:27:28,135 [main] <==      Total: 0
2019-04-22 09:33:34,504 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 09:33:34,639 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 09:33:34,663 [main] <==      Total: 1
2019-04-22 09:33:34,675 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 09:33:34,677 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 09:33:34,689 [main] <==      Total: 1
2019-04-22 09:33:34,699 [main] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and t.levelcode = ? 
2019-04-22 09:33:34,701 [main] ==> Parameters: 33097601(String), 2(String)
2019-04-22 09:33:34,738 [main] <==      Total: 1
2019-04-22 09:33:37,855 [main] ==>  Preparing: delete from membercardlevel where cinemacode = ? 
2019-04-22 09:33:37,858 [main] ==> Parameters: 33097601(String)
2019-04-22 09:33:37,886 [main] <==    Updates: 2
2019-04-22 09:33:37,899 [main] ==>  Preparing: insert into membercardlevel(CinemaCode, LevelCode, LevelName) values(?, ?, ?) 
2019-04-22 09:33:37,945 [main] ==> Parameters: 33097601(String), 4(String), 月卡(String)
2019-04-22 09:33:37,967 [main] <==    Updates: 1
2019-04-22 09:33:38,125 [main] ==>  Preparing: insert into membercardlevel(CinemaCode, LevelCode, LevelName) values(?, ?, ?) 
2019-04-22 09:33:38,126 [main] ==> Parameters: 33097601(String), 2(String), 储值卡(String)
2019-04-22 09:33:38,168 [main] <==    Updates: 1
2019-04-22 09:33:38,179 [main] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and t.levelcode = ? 
2019-04-22 09:33:38,180 [main] ==> Parameters: 33097601(String), 2(String)
2019-04-22 09:33:38,196 [main] <==      Total: 1
2019-04-22 09:33:38,210 [main] ==>  Preparing: insert into membercard(Id, CinemaCode, CardNo, CardPassword, MobilePhone, LevelCode, LevelName, Score, Balance, UserName, Sex, CreditNum, Birthday, ExpireDate, CreateTime, Status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 09:33:38,224 [main] ==> Parameters: null, 33097601(String), e042208925(String), mima123(String), 15268553143(String), 2(String), 储值卡(String), null, 150.0(Double), 刘钰栋(String), 1(String), 41061119971208453X(String), null, 2039-04-22 23:59:59.0(Timestamp), 2019-04-22 09:33:34.0(Timestamp), 0(Integer)
2019-04-22 09:33:38,260 [main] <==    Updates: 1
2019-04-22 09:42:36,250 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 09:42:36,401 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 09:42:36,464 [main] <==      Total: 1
2019-04-22 09:42:36,477 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 09:42:36,479 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 09:42:36,490 [main] <==      Total: 1
2019-04-22 09:42:36,501 [main] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and t.levelcode = ? 
2019-04-22 09:42:36,502 [main] ==> Parameters: 33097601(String), 4(String)
2019-04-22 09:42:36,513 [main] <==      Total: 1
2019-04-22 09:42:38,578 [main] ==>  Preparing: delete from membercardlevel where cinemacode = ? 
2019-04-22 09:42:38,582 [main] ==> Parameters: 33097601(String)
2019-04-22 09:42:38,618 [main] <==    Updates: 2
2019-04-22 09:42:38,627 [main] ==>  Preparing: insert into membercardlevel(CinemaCode, LevelCode, LevelName) values(?, ?, ?) 
2019-04-22 09:42:38,666 [main] ==> Parameters: 33097601(String), 4(String), 月卡(String)
2019-04-22 09:42:38,720 [main] <==    Updates: 1
2019-04-22 09:42:38,731 [main] ==>  Preparing: insert into membercardlevel(CinemaCode, LevelCode, LevelName) values(?, ?, ?) 
2019-04-22 09:42:38,733 [main] ==> Parameters: 33097601(String), 2(String), 储值卡(String)
2019-04-22 09:42:38,759 [main] <==    Updates: 1
2019-04-22 09:42:38,769 [main] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? and t.levelcode = ? 
2019-04-22 09:42:38,770 [main] ==> Parameters: 33097601(String), 4(String)
2019-04-22 09:42:38,782 [main] <==      Total: 1
2019-04-22 09:42:38,793 [main] ==>  Preparing: insert into membercard(Id, CinemaCode, CardNo, CardPassword, MobilePhone, LevelCode, LevelName, Score, Balance, UserName, Sex, CreditNum, Birthday, ExpireDate, CreateTime, Status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 09:42:38,801 [main] ==> Parameters: null, 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), null, 120.0(Double), 刘钰栋(String), 1(String), 41061119971208453X(String), null, 2019-05-22 23:59:59.0(Timestamp), 2019-04-22 09:42:35.0(Timestamp), 0(Integer)
2019-04-22 09:42:38,827 [main] <==    Updates: 1
2019-04-22 09:50:40,777 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 09:50:40,907 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 09:50:40,933 [main] <==      Total: 1
2019-04-22 09:50:40,943 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 09:50:40,945 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 09:50:41,081 [main] <==      Total: 1
2019-04-22 09:50:42,338 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 09:50:42,338 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 09:50:42,353 [main] <==      Total: 1
2019-04-22 09:50:42,465 [main] ==>  Preparing: update membercard t SET Id = ?, CinemaCode = ?, CardNo = ?, CardPassword = ?, MobilePhone = ?, LevelCode = ?, LevelName = ?, Balance = ?, UserName = ?, ExpireDate = ?, Status = ? where t.id = ? 
2019-04-22 09:50:42,470 [main] ==> Parameters: 1509(Long), 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), 120.0(Double), 刘钰栋(String), 2019-05-22 00:00:00.0(Timestamp), 0(Integer), 1509(Long)
2019-04-22 09:50:42,497 [main] <==    Updates: 1
2019-04-22 09:50:42,509 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 09:50:42,509 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 09:50:42,525 [main] <==      Total: 1
2019-04-22 09:53:03,163 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 09:53:03,327 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 09:53:03,357 [main] <==      Total: 1
2019-04-22 09:53:03,365 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 09:53:03,367 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 09:53:03,425 [main] <==      Total: 1
2019-04-22 09:53:11,444 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 09:53:11,445 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 09:53:11,505 [main] <==      Total: 1
2019-04-22 09:53:11,541 [main] ==>  Preparing: update membercard t SET Id = ?, CinemaCode = ?, CardNo = ?, CardPassword = ?, MobilePhone = ?, LevelCode = ?, LevelName = ?, Balance = ?, UserName = ?, ExpireDate = ?, Status = ? where t.id = ? 
2019-04-22 09:53:11,546 [main] ==> Parameters: 1509(Long), 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), 120.0(Double), 刘钰栋(String), 2019-05-22 00:00:00.0(Timestamp), 0(Integer), 1509(Long)
2019-04-22 09:53:11,598 [main] <==    Updates: 1
2019-04-22 09:53:11,610 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 09:53:11,610 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 09:53:11,626 [main] <==      Total: 1
2019-04-22 09:57:44,651 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 09:57:44,806 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 09:57:44,837 [main] <==      Total: 1
2019-04-22 09:57:44,850 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 09:57:44,852 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 09:57:44,912 [main] <==      Total: 1
2019-04-22 09:57:46,026 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 09:57:46,028 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 09:57:46,042 [main] <==      Total: 1
2019-04-22 09:57:46,081 [main] ==>  Preparing: update membercard t SET Id = ?, CinemaCode = ?, CardNo = ?, CardPassword = ?, MobilePhone = ?, LevelCode = ?, LevelName = ?, Balance = ?, UserName = ?, ExpireDate = ?, Status = ? where t.id = ? 
2019-04-22 09:57:46,088 [main] ==> Parameters: 1509(Long), 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), 120.0(Double), 刘钰栋(String), 2019-05-22 00:00:00.0(Timestamp), 0(Integer), 1509(Long)
2019-04-22 09:57:46,118 [main] <==    Updates: 1
2019-04-22 09:57:46,129 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 09:57:46,129 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 09:57:46,144 [main] <==      Total: 1
2019-04-22 10:01:25,051 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 10:01:25,195 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 10:01:25,218 [main] <==      Total: 1
2019-04-22 10:01:25,227 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 10:01:25,229 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 10:01:25,240 [main] <==      Total: 1
2019-04-22 10:01:26,358 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 10:01:26,360 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 10:01:26,380 [main] <==      Total: 1
2019-04-22 10:01:26,410 [main] ==>  Preparing: update membercard t SET Id = ?, CinemaCode = ?, CardNo = ?, CardPassword = ?, MobilePhone = ?, LevelCode = ?, LevelName = ?, Balance = ?, UserName = ?, ExpireDate = ?, Status = ? where t.id = ? 
2019-04-22 10:01:26,414 [main] ==> Parameters: 1509(Long), 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), 120.0(Double), 刘钰栋(String), 2019-05-22 00:00:00.0(Timestamp), 0(Integer), 1509(Long)
2019-04-22 10:01:26,448 [main] <==    Updates: 1
2019-04-22 10:01:26,464 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 10:01:26,465 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 10:01:26,483 [main] <==      Total: 1
2019-04-22 10:02:14,075 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 10:02:14,222 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 10:02:14,296 [main] <==      Total: 1
2019-04-22 10:02:14,342 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 10:02:14,344 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 10:02:14,363 [main] <==      Total: 1
2019-04-22 10:02:15,565 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 10:02:15,566 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 10:02:15,591 [main] <==      Total: 1
2019-04-22 10:02:15,623 [main] ==>  Preparing: update membercard t SET Id = ?, CinemaCode = ?, CardNo = ?, CardPassword = ?, MobilePhone = ?, LevelCode = ?, LevelName = ?, Balance = ?, UserName = ?, ExpireDate = ?, Status = ? where t.id = ? 
2019-04-22 10:02:15,627 [main] ==> Parameters: 1509(Long), 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), 120.0(Double), 刘钰栋(String), 2019-05-22 00:00:00.0(Timestamp), 0(Integer), 1509(Long)
2019-04-22 10:02:15,673 [main] <==    Updates: 1
2019-04-22 10:02:15,688 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 10:02:15,689 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 10:02:15,706 [main] <==      Total: 1
2019-04-22 10:10:52,548 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 10:10:52,686 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 10:10:52,710 [main] <==      Total: 1
2019-04-22 10:10:52,719 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 10:10:52,720 [main] ==> Parameters: 12(Long), 33096401(String)
2019-04-22 10:10:52,731 [main] <==      Total: 1
2019-04-22 10:10:54,634 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,636 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:54,688 [main] <==      Total: 1
2019-04-22 10:10:54,700 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,702 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:54,717 [main] <==      Total: 1
2019-04-22 10:10:54,725 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,726 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:54,737 [main] <==      Total: 1
2019-04-22 10:10:54,745 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,745 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:54,758 [main] <==      Total: 1
2019-04-22 10:10:54,766 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,767 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:54,778 [main] <==      Total: 1
2019-04-22 10:10:54,794 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,795 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:54,811 [main] <==      Total: 1
2019-04-22 10:10:54,822 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,823 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:54,837 [main] <==      Total: 1
2019-04-22 10:10:54,847 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,848 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:54,862 [main] <==      Total: 1
2019-04-22 10:10:54,870 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,871 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:54,885 [main] <==      Total: 1
2019-04-22 10:10:54,893 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,894 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:54,904 [main] <==      Total: 1
2019-04-22 10:10:54,913 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,913 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:54,924 [main] <==      Total: 1
2019-04-22 10:10:54,933 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,934 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:54,954 [main] <==      Total: 1
2019-04-22 10:10:54,963 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:54,964 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,016 [main] <==      Total: 1
2019-04-22 10:10:55,025 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,028 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,042 [main] <==      Total: 1
2019-04-22 10:10:55,054 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,056 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,067 [main] <==      Total: 1
2019-04-22 10:10:55,078 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,079 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,093 [main] <==      Total: 1
2019-04-22 10:10:55,105 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,106 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,117 [main] <==      Total: 1
2019-04-22 10:10:55,126 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,126 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,138 [main] <==      Total: 1
2019-04-22 10:10:55,147 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,147 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,161 [main] <==      Total: 1
2019-04-22 10:10:55,171 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,172 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:55,184 [main] <==      Total: 1
2019-04-22 10:10:55,193 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,194 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,208 [main] <==      Total: 1
2019-04-22 10:10:55,218 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,218 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:55,229 [main] <==      Total: 1
2019-04-22 10:10:55,237 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,237 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:55,250 [main] <==      Total: 1
2019-04-22 10:10:55,260 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,261 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,273 [main] <==      Total: 1
2019-04-22 10:10:55,285 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,286 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,299 [main] <==      Total: 1
2019-04-22 10:10:55,308 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,309 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,323 [main] <==      Total: 1
2019-04-22 10:10:55,336 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,337 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,352 [main] <==      Total: 1
2019-04-22 10:10:55,364 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,366 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,379 [main] <==      Total: 1
2019-04-22 10:10:55,389 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,390 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,402 [main] <==      Total: 1
2019-04-22 10:10:55,412 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,413 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,435 [main] <==      Total: 1
2019-04-22 10:10:55,445 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,446 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,459 [main] <==      Total: 1
2019-04-22 10:10:55,469 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,470 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:55,483 [main] <==      Total: 1
2019-04-22 10:10:55,492 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,493 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,506 [main] <==      Total: 1
2019-04-22 10:10:55,516 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,516 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:55,529 [main] <==      Total: 1
2019-04-22 10:10:55,540 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,541 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:55,557 [main] <==      Total: 1
2019-04-22 10:10:55,569 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,571 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,586 [main] <==      Total: 1
2019-04-22 10:10:55,601 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,602 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,614 [main] <==      Total: 1
2019-04-22 10:10:55,636 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,636 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,646 [main] <==      Total: 1
2019-04-22 10:10:55,654 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,654 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,665 [main] <==      Total: 1
2019-04-22 10:10:55,674 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,675 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,699 [main] <==      Total: 1
2019-04-22 10:10:55,708 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,708 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,720 [main] <==      Total: 1
2019-04-22 10:10:55,744 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,745 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,759 [main] <==      Total: 1
2019-04-22 10:10:55,779 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,780 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,795 [main] <==      Total: 1
2019-04-22 10:10:55,806 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,807 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:55,822 [main] <==      Total: 1
2019-04-22 10:10:55,839 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,841 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,851 [main] <==      Total: 1
2019-04-22 10:10:55,860 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,861 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:55,873 [main] <==      Total: 1
2019-04-22 10:10:55,884 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,885 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:55,895 [main] <==      Total: 1
2019-04-22 10:10:55,903 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,904 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,920 [main] <==      Total: 1
2019-04-22 10:10:55,929 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,930 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,946 [main] <==      Total: 1
2019-04-22 10:10:55,955 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,956 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:55,968 [main] <==      Total: 1
2019-04-22 10:10:55,980 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:55,981 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:55,995 [main] <==      Total: 1
2019-04-22 10:10:56,009 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,010 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,025 [main] <==      Total: 1
2019-04-22 10:10:56,039 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,040 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,053 [main] <==      Total: 1
2019-04-22 10:10:56,063 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,064 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,081 [main] <==      Total: 1
2019-04-22 10:10:56,090 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,091 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,102 [main] <==      Total: 1
2019-04-22 10:10:56,113 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,114 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:56,124 [main] <==      Total: 1
2019-04-22 10:10:56,133 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,134 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,146 [main] <==      Total: 1
2019-04-22 10:10:56,153 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,154 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:56,164 [main] <==      Total: 1
2019-04-22 10:10:56,173 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,173 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:56,192 [main] <==      Total: 1
2019-04-22 10:10:56,202 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,203 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,216 [main] <==      Total: 1
2019-04-22 10:10:56,225 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,226 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,245 [main] <==      Total: 1
2019-04-22 10:10:56,254 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,255 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,266 [main] <==      Total: 1
2019-04-22 10:10:56,275 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,275 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,287 [main] <==      Total: 1
2019-04-22 10:10:56,295 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,295 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,311 [main] <==      Total: 1
2019-04-22 10:10:56,320 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,320 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,330 [main] <==      Total: 1
2019-04-22 10:10:56,338 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,339 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,350 [main] <==      Total: 1
2019-04-22 10:10:56,361 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,362 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,374 [main] <==      Total: 1
2019-04-22 10:10:56,383 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,385 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:56,396 [main] <==      Total: 1
2019-04-22 10:10:56,404 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,405 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,417 [main] <==      Total: 1
2019-04-22 10:10:56,426 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,427 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:56,438 [main] <==      Total: 1
2019-04-22 10:10:56,447 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,447 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:56,460 [main] <==      Total: 1
2019-04-22 10:10:56,469 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,469 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,483 [main] <==      Total: 1
2019-04-22 10:10:56,491 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,492 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,513 [main] <==      Total: 1
2019-04-22 10:10:56,522 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,523 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,534 [main] <==      Total: 1
2019-04-22 10:10:56,542 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,543 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,557 [main] <==      Total: 1
2019-04-22 10:10:56,572 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,573 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,585 [main] <==      Total: 1
2019-04-22 10:10:56,594 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,595 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,609 [main] <==      Total: 1
2019-04-22 10:10:56,619 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,620 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,632 [main] <==      Total: 1
2019-04-22 10:10:56,640 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,640 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,652 [main] <==      Total: 1
2019-04-22 10:10:56,660 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,660 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:56,670 [main] <==      Total: 1
2019-04-22 10:10:56,678 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,679 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,693 [main] <==      Total: 1
2019-04-22 10:10:56,703 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,703 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:56,714 [main] <==      Total: 1
2019-04-22 10:10:56,733 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,734 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:56,750 [main] <==      Total: 1
2019-04-22 10:10:56,760 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,761 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,774 [main] <==      Total: 1
2019-04-22 10:10:56,785 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,785 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,796 [main] <==      Total: 1
2019-04-22 10:10:56,807 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,808 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,819 [main] <==      Total: 1
2019-04-22 10:10:56,829 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,830 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,842 [main] <==      Total: 1
2019-04-22 10:10:56,850 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,850 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,862 [main] <==      Total: 1
2019-04-22 10:10:56,870 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,871 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,882 [main] <==      Total: 1
2019-04-22 10:10:56,895 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,895 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,906 [main] <==      Total: 1
2019-04-22 10:10:56,914 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,914 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:56,925 [main] <==      Total: 1
2019-04-22 10:10:56,933 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,934 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:56,954 [main] <==      Total: 1
2019-04-22 10:10:56,966 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,966 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:56,978 [main] <==      Total: 1
2019-04-22 10:10:56,986 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:56,987 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:56,998 [main] <==      Total: 1
2019-04-22 10:10:57,006 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,007 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:57,019 [main] <==      Total: 1
2019-04-22 10:10:57,027 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,028 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,040 [main] <==      Total: 1
2019-04-22 10:10:57,049 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,049 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,064 [main] <==      Total: 1
2019-04-22 10:10:57,072 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,072 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,087 [main] <==      Total: 1
2019-04-22 10:10:57,098 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,099 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,110 [main] <==      Total: 1
2019-04-22 10:10:57,119 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,120 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,132 [main] <==      Total: 1
2019-04-22 10:10:57,141 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,142 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,155 [main] <==      Total: 1
2019-04-22 10:10:57,164 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,164 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,176 [main] <==      Total: 1
2019-04-22 10:10:57,184 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,185 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,196 [main] <==      Total: 1
2019-04-22 10:10:57,205 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,206 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:57,219 [main] <==      Total: 1
2019-04-22 10:10:57,229 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,230 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,245 [main] <==      Total: 1
2019-04-22 10:10:57,254 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,255 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:57,267 [main] <==      Total: 1
2019-04-22 10:10:57,276 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,277 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:57,299 [main] <==      Total: 1
2019-04-22 10:10:57,307 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,307 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,319 [main] <==      Total: 1
2019-04-22 10:10:57,327 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,327 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,338 [main] <==      Total: 1
2019-04-22 10:10:57,355 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,356 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,369 [main] <==      Total: 1
2019-04-22 10:10:57,378 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,379 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,392 [main] <==      Total: 1
2019-04-22 10:10:57,402 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,403 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,414 [main] <==      Total: 1
2019-04-22 10:10:57,422 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,422 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,433 [main] <==      Total: 1
2019-04-22 10:10:57,442 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,442 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,454 [main] <==      Total: 1
2019-04-22 10:10:57,463 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,463 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,475 [main] <==      Total: 1
2019-04-22 10:10:57,483 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,484 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:57,508 [main] <==      Total: 1
2019-04-22 10:10:57,518 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,519 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,531 [main] <==      Total: 1
2019-04-22 10:10:57,540 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,541 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:57,553 [main] <==      Total: 1
2019-04-22 10:10:57,561 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,562 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:57,575 [main] <==      Total: 1
2019-04-22 10:10:57,584 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,585 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,595 [main] <==      Total: 1
2019-04-22 10:10:57,604 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,604 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,614 [main] <==      Total: 1
2019-04-22 10:10:57,622 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,623 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,634 [main] <==      Total: 1
2019-04-22 10:10:57,642 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,643 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,652 [main] <==      Total: 1
2019-04-22 10:10:57,661 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,661 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,670 [main] <==      Total: 1
2019-04-22 10:10:57,683 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,683 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,702 [main] <==      Total: 1
2019-04-22 10:10:57,710 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,711 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,721 [main] <==      Total: 1
2019-04-22 10:10:57,731 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,732 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,743 [main] <==      Total: 1
2019-04-22 10:10:57,757 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,757 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:57,771 [main] <==      Total: 1
2019-04-22 10:10:57,791 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,792 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:57,825 [main] <==      Total: 1
2019-04-22 10:10:57,844 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,844 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:57,864 [main] <==      Total: 1
2019-04-22 10:10:57,883 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,883 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:57,903 [main] <==      Total: 1
2019-04-22 10:10:57,918 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,918 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,940 [main] <==      Total: 1
2019-04-22 10:10:57,957 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:57,958 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:57,983 [main] <==      Total: 1
2019-04-22 10:10:58,003 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,004 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:58,024 [main] <==      Total: 1
2019-04-22 10:10:58,041 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,042 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:58,055 [main] <==      Total: 1
2019-04-22 10:10:58,064 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,065 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:58,076 [main] <==      Total: 1
2019-04-22 10:10:58,087 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,088 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:58,099 [main] <==      Total: 1
2019-04-22 10:10:58,107 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,107 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:58,118 [main] <==      Total: 1
2019-04-22 10:10:58,126 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,126 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:58,147 [main] <==      Total: 1
2019-04-22 10:10:58,157 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,158 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:58,170 [main] <==      Total: 1
2019-04-22 10:10:58,179 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,180 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:58,193 [main] <==      Total: 1
2019-04-22 10:10:58,201 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,202 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:58,221 [main] <==      Total: 1
2019-04-22 10:10:58,230 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,231 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:58,241 [main] <==      Total: 1
2019-04-22 10:10:58,251 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,252 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:58,269 [main] <==      Total: 1
2019-04-22 10:10:58,277 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,278 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:58,290 [main] <==      Total: 1
2019-04-22 10:10:58,298 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,298 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:58,308 [main] <==      Total: 1
2019-04-22 10:10:58,315 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,315 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:58,325 [main] <==      Total: 1
2019-04-22 10:10:58,338 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,339 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:58,348 [main] <==      Total: 1
2019-04-22 10:10:58,356 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,356 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:58,369 [main] <==      Total: 1
2019-04-22 10:10:58,379 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,379 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:58,394 [main] <==      Total: 1
2019-04-22 10:10:58,403 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,403 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:58,414 [main] <==      Total: 1
2019-04-22 10:10:58,423 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,424 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:58,436 [main] <==      Total: 1
2019-04-22 10:10:58,450 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,451 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:58,461 [main] <==      Total: 1
2019-04-22 10:10:58,470 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,470 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:58,489 [main] <==      Total: 1
2019-04-22 10:10:58,510 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,510 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:58,532 [main] <==      Total: 1
2019-04-22 10:10:58,540 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,541 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:58,559 [main] <==      Total: 1
2019-04-22 10:10:58,566 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,566 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:58,576 [main] <==      Total: 1
2019-04-22 10:10:58,584 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,585 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:58,602 [main] <==      Total: 1
2019-04-22 10:10:58,611 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,611 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:58,622 [main] <==      Total: 1
2019-04-22 10:10:58,634 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,634 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:58,644 [main] <==      Total: 1
2019-04-22 10:10:58,652 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,653 [main] ==> Parameters: 33096401(String), 1072(String)
2019-04-22 10:10:58,664 [main] <==      Total: 1
2019-04-22 10:10:58,671 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,672 [main] ==> Parameters: 33096401(String), 1071(String)
2019-04-22 10:10:58,682 [main] <==      Total: 1
2019-04-22 10:10:58,690 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,690 [main] ==> Parameters: 33096401(String), 1069(String)
2019-04-22 10:10:58,702 [main] <==      Total: 1
2019-04-22 10:10:58,718 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,719 [main] ==> Parameters: 33096401(String), 1070(String)
2019-04-22 10:10:58,742 [main] <==      Total: 1
2019-04-22 10:10:58,753 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:10:58,754 [main] ==> Parameters: 33096401(String), 1068(String)
2019-04-22 10:10:58,769 [main] <==      Total: 1
2019-04-22 10:10:58,828 [main] ==>  Preparing: delete from sessioninfo WHERE CCode = ? and UserId = ? and StartTime >= ? and ? >= StartTime 
2019-04-22 10:10:58,832 [main] ==> Parameters: 33096401(String), 12(Long), 2019-01-01(String), 2019-06-20(String)
2019-04-22 10:11:01,707 [main] <==    Updates: 155
2019-04-22 10:11:01,718 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:01,788 [main] ==> Parameters: 33096401(String), 3095299(String), 0000000000000003(String), 2019-04-24 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:01,835 [main] <==    Updates: 1
2019-04-22 10:11:01,844 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:01,846 [main] ==> Parameters: 33096401(String), 3095300(String), 0000000000000005(String), 2019-04-24 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:01,888 [main] <==    Updates: 1
2019-04-22 10:11:01,897 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:01,899 [main] ==> Parameters: 33096401(String), 3095301(String), 0000000000000003(String), 2019-04-24 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:01,929 [main] <==    Updates: 1
2019-04-22 10:11:01,938 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:01,941 [main] ==> Parameters: 33096401(String), 3095302(String), 0000000000000005(String), 2019-04-24 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:01,970 [main] <==    Updates: 1
2019-04-22 10:11:01,982 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:01,983 [main] ==> Parameters: 33096401(String), 3095303(String), 0000000000000003(String), 2019-04-24 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,015 [main] <==    Updates: 1
2019-04-22 10:11:02,024 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,026 [main] ==> Parameters: 33096401(String), 3095304(String), 0000000000000005(String), 2019-04-24 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,054 [main] <==    Updates: 1
2019-04-22 10:11:02,062 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,062 [main] ==> Parameters: 33096401(String), 3095305(String), 0000000000000003(String), 2019-04-24 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,091 [main] <==    Updates: 1
2019-04-22 10:11:02,100 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,102 [main] ==> Parameters: 33096401(String), 3095306(String), 0000000000000004(String), 2019-04-24 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,138 [main] <==    Updates: 1
2019-04-22 10:11:02,146 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,147 [main] ==> Parameters: 33096401(String), 3095307(String), 0000000000000005(String), 2019-04-24 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,173 [main] <==    Updates: 1
2019-04-22 10:11:02,181 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,182 [main] ==> Parameters: 33096401(String), 3095308(String), 0000000000000002(String), 2019-04-24 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,208 [main] <==    Updates: 1
2019-04-22 10:11:02,218 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,220 [main] ==> Parameters: 33096401(String), 3095309(String), 0000000000000001(String), 2019-04-24 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,250 [main] <==    Updates: 1
2019-04-22 10:11:02,259 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,260 [main] ==> Parameters: 33096401(String), 3095310(String), 0000000000000003(String), 2019-04-24 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,291 [main] <==    Updates: 1
2019-04-22 10:11:02,299 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,299 [main] ==> Parameters: 33096401(String), 3095311(String), 0000000000000003(String), 2019-04-25 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,329 [main] <==    Updates: 1
2019-04-22 10:11:02,338 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,340 [main] ==> Parameters: 33096401(String), 3095312(String), 0000000000000005(String), 2019-04-25 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,368 [main] <==    Updates: 1
2019-04-22 10:11:02,377 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,379 [main] ==> Parameters: 33096401(String), 3095313(String), 0000000000000003(String), 2019-04-25 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,403 [main] <==    Updates: 1
2019-04-22 10:11:02,413 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,415 [main] ==> Parameters: 33096401(String), 3095314(String), 0000000000000005(String), 2019-04-25 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,445 [main] <==    Updates: 1
2019-04-22 10:11:02,455 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,456 [main] ==> Parameters: 33096401(String), 3095315(String), 0000000000000003(String), 2019-04-25 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,496 [main] <==    Updates: 1
2019-04-22 10:11:02,503 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,504 [main] ==> Parameters: 33096401(String), 3095316(String), 0000000000000005(String), 2019-04-25 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,552 [main] <==    Updates: 1
2019-04-22 10:11:02,561 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,564 [main] ==> Parameters: 33096401(String), 3095317(String), 0000000000000003(String), 2019-04-25 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,591 [main] <==    Updates: 1
2019-04-22 10:11:02,600 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,600 [main] ==> Parameters: 33096401(String), 3095318(String), 0000000000000004(String), 2019-04-25 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,648 [main] <==    Updates: 1
2019-04-22 10:11:02,656 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,658 [main] ==> Parameters: 33096401(String), 3095319(String), 0000000000000005(String), 2019-04-25 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,690 [main] <==    Updates: 1
2019-04-22 10:11:02,699 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,701 [main] ==> Parameters: 33096401(String), 3095320(String), 0000000000000002(String), 2019-04-25 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,726 [main] <==    Updates: 1
2019-04-22 10:11:02,735 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,736 [main] ==> Parameters: 33096401(String), 3095321(String), 0000000000000001(String), 2019-04-25 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,764 [main] <==    Updates: 1
2019-04-22 10:11:02,773 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,775 [main] ==> Parameters: 33096401(String), 3095322(String), 0000000000000003(String), 2019-04-25 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,804 [main] <==    Updates: 1
2019-04-22 10:11:02,812 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,812 [main] ==> Parameters: 33096401(String), 3095323(String), 0000000000000003(String), 2019-04-26 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,838 [main] <==    Updates: 1
2019-04-22 10:11:02,847 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,848 [main] ==> Parameters: 33096401(String), 3095324(String), 0000000000000005(String), 2019-04-26 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,879 [main] <==    Updates: 1
2019-04-22 10:11:02,889 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,891 [main] ==> Parameters: 33096401(String), 3095325(String), 0000000000000003(String), 2019-04-26 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,933 [main] <==    Updates: 1
2019-04-22 10:11:02,942 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,943 [main] ==> Parameters: 33096401(String), 3095326(String), 0000000000000005(String), 2019-04-26 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:02,974 [main] <==    Updates: 1
2019-04-22 10:11:02,983 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:02,983 [main] ==> Parameters: 33096401(String), 3095327(String), 0000000000000003(String), 2019-04-26 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,010 [main] <==    Updates: 1
2019-04-22 10:11:03,021 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,022 [main] ==> Parameters: 33096401(String), 3095328(String), 0000000000000005(String), 2019-04-26 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,053 [main] <==    Updates: 1
2019-04-22 10:11:03,062 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,062 [main] ==> Parameters: 33096401(String), 3095329(String), 0000000000000003(String), 2019-04-26 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,086 [main] <==    Updates: 1
2019-04-22 10:11:03,107 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,109 [main] ==> Parameters: 33096401(String), 3095330(String), 0000000000000004(String), 2019-04-26 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,137 [main] <==    Updates: 1
2019-04-22 10:11:03,146 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,148 [main] ==> Parameters: 33096401(String), 3095331(String), 0000000000000005(String), 2019-04-26 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,176 [main] <==    Updates: 1
2019-04-22 10:11:03,185 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,186 [main] ==> Parameters: 33096401(String), 3095332(String), 0000000000000002(String), 2019-04-26 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,212 [main] <==    Updates: 1
2019-04-22 10:11:03,222 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,223 [main] ==> Parameters: 33096401(String), 3095333(String), 0000000000000001(String), 2019-04-26 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,252 [main] <==    Updates: 1
2019-04-22 10:11:03,267 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,268 [main] ==> Parameters: 33096401(String), 3095334(String), 0000000000000003(String), 2019-04-26 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,294 [main] <==    Updates: 1
2019-04-22 10:11:03,307 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,309 [main] ==> Parameters: 33096401(String), 3095335(String), 0000000000000003(String), 2019-04-27 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,339 [main] <==    Updates: 1
2019-04-22 10:11:03,347 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,348 [main] ==> Parameters: 33096401(String), 3095336(String), 0000000000000005(String), 2019-04-27 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,371 [main] <==    Updates: 1
2019-04-22 10:11:03,379 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,380 [main] ==> Parameters: 33096401(String), 3095337(String), 0000000000000003(String), 2019-04-27 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,420 [main] <==    Updates: 1
2019-04-22 10:11:03,430 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,431 [main] ==> Parameters: 33096401(String), 3095338(String), 0000000000000005(String), 2019-04-27 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,461 [main] <==    Updates: 1
2019-04-22 10:11:03,470 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,471 [main] ==> Parameters: 33096401(String), 3095339(String), 0000000000000003(String), 2019-04-27 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,497 [main] <==    Updates: 1
2019-04-22 10:11:03,512 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,513 [main] ==> Parameters: 33096401(String), 3095340(String), 0000000000000005(String), 2019-04-27 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,543 [main] <==    Updates: 1
2019-04-22 10:11:03,552 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,553 [main] ==> Parameters: 33096401(String), 3095341(String), 0000000000000003(String), 2019-04-27 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,593 [main] <==    Updates: 1
2019-04-22 10:11:03,605 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,606 [main] ==> Parameters: 33096401(String), 3095342(String), 0000000000000004(String), 2019-04-27 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,634 [main] <==    Updates: 1
2019-04-22 10:11:03,648 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,649 [main] ==> Parameters: 33096401(String), 3095343(String), 0000000000000005(String), 2019-04-27 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,675 [main] <==    Updates: 1
2019-04-22 10:11:03,684 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,687 [main] ==> Parameters: 33096401(String), 3095344(String), 0000000000000002(String), 2019-04-27 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,710 [main] <==    Updates: 1
2019-04-22 10:11:03,719 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,721 [main] ==> Parameters: 33096401(String), 3095345(String), 0000000000000001(String), 2019-04-27 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,748 [main] <==    Updates: 1
2019-04-22 10:11:03,756 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,756 [main] ==> Parameters: 33096401(String), 3095346(String), 0000000000000003(String), 2019-04-27 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,780 [main] <==    Updates: 1
2019-04-22 10:11:03,790 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,791 [main] ==> Parameters: 33096401(String), 3095347(String), 0000000000000003(String), 2019-04-28 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,820 [main] <==    Updates: 1
2019-04-22 10:11:03,829 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,830 [main] ==> Parameters: 33096401(String), 3095348(String), 0000000000000005(String), 2019-04-28 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,853 [main] <==    Updates: 1
2019-04-22 10:11:03,861 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,861 [main] ==> Parameters: 33096401(String), 3095349(String), 0000000000000003(String), 2019-04-28 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,885 [main] <==    Updates: 1
2019-04-22 10:11:03,897 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,899 [main] ==> Parameters: 33096401(String), 3095350(String), 0000000000000005(String), 2019-04-28 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,928 [main] <==    Updates: 1
2019-04-22 10:11:03,937 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,939 [main] ==> Parameters: 33096401(String), 3095351(String), 0000000000000003(String), 2019-04-28 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:03,972 [main] <==    Updates: 1
2019-04-22 10:11:03,981 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:03,981 [main] ==> Parameters: 33096401(String), 3095352(String), 0000000000000005(String), 2019-04-28 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,003 [main] <==    Updates: 1
2019-04-22 10:11:04,011 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,013 [main] ==> Parameters: 33096401(String), 3095353(String), 0000000000000003(String), 2019-04-28 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,046 [main] <==    Updates: 1
2019-04-22 10:11:04,056 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,057 [main] ==> Parameters: 33096401(String), 3095354(String), 0000000000000004(String), 2019-04-28 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,089 [main] <==    Updates: 1
2019-04-22 10:11:04,098 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,099 [main] ==> Parameters: 33096401(String), 3095355(String), 0000000000000005(String), 2019-04-28 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,121 [main] <==    Updates: 1
2019-04-22 10:11:04,129 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,129 [main] ==> Parameters: 33096401(String), 3095356(String), 0000000000000002(String), 2019-04-28 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,152 [main] <==    Updates: 1
2019-04-22 10:11:04,159 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,160 [main] ==> Parameters: 33096401(String), 3095357(String), 0000000000000001(String), 2019-04-28 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,185 [main] <==    Updates: 1
2019-04-22 10:11:04,199 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,200 [main] ==> Parameters: 33096401(String), 3095358(String), 0000000000000003(String), 2019-04-28 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,225 [main] <==    Updates: 1
2019-04-22 10:11:04,234 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,235 [main] ==> Parameters: 33096401(String), 3095359(String), 0000000000000003(String), 2019-04-29 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,265 [main] <==    Updates: 1
2019-04-22 10:11:04,273 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,274 [main] ==> Parameters: 33096401(String), 3095360(String), 0000000000000005(String), 2019-04-29 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,297 [main] <==    Updates: 1
2019-04-22 10:11:04,305 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,307 [main] ==> Parameters: 33096401(String), 3095361(String), 0000000000000003(String), 2019-04-29 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,334 [main] <==    Updates: 1
2019-04-22 10:11:04,342 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,343 [main] ==> Parameters: 33096401(String), 3095362(String), 0000000000000005(String), 2019-04-29 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,364 [main] <==    Updates: 1
2019-04-22 10:11:04,372 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,373 [main] ==> Parameters: 33096401(String), 3095363(String), 0000000000000003(String), 2019-04-29 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,398 [main] <==    Updates: 1
2019-04-22 10:11:04,408 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,409 [main] ==> Parameters: 33096401(String), 3095364(String), 0000000000000005(String), 2019-04-29 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,436 [main] <==    Updates: 1
2019-04-22 10:11:04,445 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,446 [main] ==> Parameters: 33096401(String), 3095365(String), 0000000000000003(String), 2019-04-29 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,468 [main] <==    Updates: 1
2019-04-22 10:11:04,476 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,478 [main] ==> Parameters: 33096401(String), 3095366(String), 0000000000000004(String), 2019-04-29 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,500 [main] <==    Updates: 1
2019-04-22 10:11:04,509 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,509 [main] ==> Parameters: 33096401(String), 3095367(String), 0000000000000005(String), 2019-04-29 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,537 [main] <==    Updates: 1
2019-04-22 10:11:04,546 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,547 [main] ==> Parameters: 33096401(String), 3095368(String), 0000000000000002(String), 2019-04-29 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,574 [main] <==    Updates: 1
2019-04-22 10:11:04,582 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,583 [main] ==> Parameters: 33096401(String), 3095369(String), 0000000000000001(String), 2019-04-29 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,608 [main] <==    Updates: 1
2019-04-22 10:11:04,618 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,618 [main] ==> Parameters: 33096401(String), 3095370(String), 0000000000000003(String), 2019-04-29 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,642 [main] <==    Updates: 1
2019-04-22 10:11:04,651 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,653 [main] ==> Parameters: 33096401(String), 3095371(String), 0000000000000003(String), 2019-04-30 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,679 [main] <==    Updates: 1
2019-04-22 10:11:04,688 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,688 [main] ==> Parameters: 33096401(String), 3095372(String), 0000000000000005(String), 2019-04-30 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,710 [main] <==    Updates: 1
2019-04-22 10:11:04,718 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,719 [main] ==> Parameters: 33096401(String), 3095373(String), 0000000000000003(String), 2019-04-30 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,744 [main] <==    Updates: 1
2019-04-22 10:11:04,751 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,751 [main] ==> Parameters: 33096401(String), 3095374(String), 0000000000000005(String), 2019-04-30 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,778 [main] <==    Updates: 1
2019-04-22 10:11:04,787 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,788 [main] ==> Parameters: 33096401(String), 3095375(String), 0000000000000003(String), 2019-04-30 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,822 [main] <==    Updates: 1
2019-04-22 10:11:04,830 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,831 [main] ==> Parameters: 33096401(String), 3095376(String), 0000000000000005(String), 2019-04-30 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,857 [main] <==    Updates: 1
2019-04-22 10:11:04,865 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,866 [main] ==> Parameters: 33096401(String), 3095377(String), 0000000000000003(String), 2019-04-30 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,889 [main] <==    Updates: 1
2019-04-22 10:11:04,898 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,899 [main] ==> Parameters: 33096401(String), 3095378(String), 0000000000000004(String), 2019-04-30 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,923 [main] <==    Updates: 1
2019-04-22 10:11:04,931 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,932 [main] ==> Parameters: 33096401(String), 3095379(String), 0000000000000005(String), 2019-04-30 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,957 [main] <==    Updates: 1
2019-04-22 10:11:04,966 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:04,967 [main] ==> Parameters: 33096401(String), 3095380(String), 0000000000000002(String), 2019-04-30 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:04,991 [main] <==    Updates: 1
2019-04-22 10:11:05,005 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,007 [main] ==> Parameters: 33096401(String), 3095381(String), 0000000000000001(String), 2019-04-30 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,033 [main] <==    Updates: 1
2019-04-22 10:11:05,041 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,041 [main] ==> Parameters: 33096401(String), 3095382(String), 0000000000000003(String), 2019-04-30 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,071 [main] <==    Updates: 1
2019-04-22 10:11:05,079 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,079 [main] ==> Parameters: 33096401(String), 3095383(String), 0000000000000003(String), 2019-05-01 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,102 [main] <==    Updates: 1
2019-04-22 10:11:05,110 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,112 [main] ==> Parameters: 33096401(String), 3095384(String), 0000000000000005(String), 2019-05-01 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,133 [main] <==    Updates: 1
2019-04-22 10:11:05,142 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,142 [main] ==> Parameters: 33096401(String), 3095385(String), 0000000000000003(String), 2019-05-01 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,168 [main] <==    Updates: 1
2019-04-22 10:11:05,176 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,178 [main] ==> Parameters: 33096401(String), 3095386(String), 0000000000000005(String), 2019-05-01 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,216 [main] <==    Updates: 1
2019-04-22 10:11:05,224 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,225 [main] ==> Parameters: 33096401(String), 3095387(String), 0000000000000003(String), 2019-05-01 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,246 [main] <==    Updates: 1
2019-04-22 10:11:05,260 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,260 [main] ==> Parameters: 33096401(String), 3095388(String), 0000000000000005(String), 2019-05-01 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,282 [main] <==    Updates: 1
2019-04-22 10:11:05,291 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,291 [main] ==> Parameters: 33096401(String), 3095389(String), 0000000000000003(String), 2019-05-01 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,314 [main] <==    Updates: 1
2019-04-22 10:11:05,326 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,327 [main] ==> Parameters: 33096401(String), 3095390(String), 0000000000000004(String), 2019-05-01 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,356 [main] <==    Updates: 1
2019-04-22 10:11:05,365 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,366 [main] ==> Parameters: 33096401(String), 3095391(String), 0000000000000005(String), 2019-05-01 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,395 [main] <==    Updates: 1
2019-04-22 10:11:05,403 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,403 [main] ==> Parameters: 33096401(String), 3095392(String), 0000000000000002(String), 2019-05-01 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,436 [main] <==    Updates: 1
2019-04-22 10:11:05,444 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,445 [main] ==> Parameters: 33096401(String), 3095393(String), 0000000000000001(String), 2019-05-01 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,473 [main] <==    Updates: 1
2019-04-22 10:11:05,481 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,482 [main] ==> Parameters: 33096401(String), 3095394(String), 0000000000000003(String), 2019-05-01 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,507 [main] <==    Updates: 1
2019-04-22 10:11:05,516 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,517 [main] ==> Parameters: 33096401(String), 3095395(String), 0000000000000003(String), 2019-05-02 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,545 [main] <==    Updates: 1
2019-04-22 10:11:05,554 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,555 [main] ==> Parameters: 33096401(String), 3095396(String), 0000000000000005(String), 2019-05-02 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,594 [main] <==    Updates: 1
2019-04-22 10:11:05,603 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,604 [main] ==> Parameters: 33096401(String), 3095397(String), 0000000000000003(String), 2019-05-02 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,638 [main] <==    Updates: 1
2019-04-22 10:11:05,646 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,647 [main] ==> Parameters: 33096401(String), 3095398(String), 0000000000000005(String), 2019-05-02 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,673 [main] <==    Updates: 1
2019-04-22 10:11:05,681 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,682 [main] ==> Parameters: 33096401(String), 3095399(String), 0000000000000003(String), 2019-05-02 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,709 [main] <==    Updates: 1
2019-04-22 10:11:05,718 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,719 [main] ==> Parameters: 33096401(String), 3095400(String), 0000000000000005(String), 2019-05-02 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,748 [main] <==    Updates: 1
2019-04-22 10:11:05,756 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,757 [main] ==> Parameters: 33096401(String), 3095401(String), 0000000000000003(String), 2019-05-02 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,785 [main] <==    Updates: 1
2019-04-22 10:11:05,794 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,795 [main] ==> Parameters: 33096401(String), 3095402(String), 0000000000000004(String), 2019-05-02 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,825 [main] <==    Updates: 1
2019-04-22 10:11:05,835 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,836 [main] ==> Parameters: 33096401(String), 3095403(String), 0000000000000005(String), 2019-05-02 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,868 [main] <==    Updates: 1
2019-04-22 10:11:05,877 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,878 [main] ==> Parameters: 33096401(String), 3095404(String), 0000000000000002(String), 2019-05-02 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,905 [main] <==    Updates: 1
2019-04-22 10:11:05,913 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,914 [main] ==> Parameters: 33096401(String), 3095405(String), 0000000000000001(String), 2019-05-02 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,952 [main] <==    Updates: 1
2019-04-22 10:11:05,960 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:05,961 [main] ==> Parameters: 33096401(String), 3095406(String), 0000000000000003(String), 2019-05-02 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:05,989 [main] <==    Updates: 1
2019-04-22 10:11:06,000 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,000 [main] ==> Parameters: 33096401(String), 3095407(String), 0000000000000003(String), 2019-05-03 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,028 [main] <==    Updates: 1
2019-04-22 10:11:06,036 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,036 [main] ==> Parameters: 33096401(String), 3095408(String), 0000000000000005(String), 2019-05-03 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,078 [main] <==    Updates: 1
2019-04-22 10:11:06,086 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,086 [main] ==> Parameters: 33096401(String), 3095409(String), 0000000000000003(String), 2019-05-03 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,111 [main] <==    Updates: 1
2019-04-22 10:11:06,119 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,119 [main] ==> Parameters: 33096401(String), 3095410(String), 0000000000000005(String), 2019-05-03 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,143 [main] <==    Updates: 1
2019-04-22 10:11:06,151 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,151 [main] ==> Parameters: 33096401(String), 3095411(String), 0000000000000003(String), 2019-05-03 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,178 [main] <==    Updates: 1
2019-04-22 10:11:06,187 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,188 [main] ==> Parameters: 33096401(String), 3095412(String), 0000000000000005(String), 2019-05-03 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,219 [main] <==    Updates: 1
2019-04-22 10:11:06,228 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,229 [main] ==> Parameters: 33096401(String), 3095413(String), 0000000000000003(String), 2019-05-03 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,266 [main] <==    Updates: 1
2019-04-22 10:11:06,280 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,281 [main] ==> Parameters: 33096401(String), 3095414(String), 0000000000000004(String), 2019-05-03 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,311 [main] <==    Updates: 1
2019-04-22 10:11:06,318 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,319 [main] ==> Parameters: 33096401(String), 3095415(String), 0000000000000005(String), 2019-05-03 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,346 [main] <==    Updates: 1
2019-04-22 10:11:06,355 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,362 [main] ==> Parameters: 33096401(String), 3095416(String), 0000000000000002(String), 2019-05-03 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,387 [main] <==    Updates: 1
2019-04-22 10:11:06,396 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,397 [main] ==> Parameters: 33096401(String), 3095417(String), 0000000000000001(String), 2019-05-03 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,425 [main] <==    Updates: 1
2019-04-22 10:11:06,432 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,433 [main] ==> Parameters: 33096401(String), 3095418(String), 0000000000000003(String), 2019-05-03 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,473 [main] <==    Updates: 1
2019-04-22 10:11:06,485 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,486 [main] ==> Parameters: 33096401(String), 3095419(String), 0000000000000003(String), 2019-05-04 09:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,526 [main] <==    Updates: 1
2019-04-22 10:11:06,534 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,534 [main] ==> Parameters: 33096401(String), 3095420(String), 0000000000000005(String), 2019-05-04 10:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,564 [main] <==    Updates: 1
2019-04-22 10:11:06,570 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,571 [main] ==> Parameters: 33096401(String), 3095421(String), 0000000000000003(String), 2019-05-04 12:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,596 [main] <==    Updates: 1
2019-04-22 10:11:06,604 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,604 [main] ==> Parameters: 33096401(String), 3095422(String), 0000000000000005(String), 2019-05-04 13:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,648 [main] <==    Updates: 1
2019-04-22 10:11:06,657 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,658 [main] ==> Parameters: 33096401(String), 3095423(String), 0000000000000003(String), 2019-05-04 15:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,690 [main] <==    Updates: 1
2019-04-22 10:11:06,697 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,698 [main] ==> Parameters: 33096401(String), 3095424(String), 0000000000000005(String), 2019-05-04 16:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,721 [main] <==    Updates: 1
2019-04-22 10:11:06,731 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,732 [main] ==> Parameters: 33096401(String), 3095425(String), 0000000000000003(String), 2019-05-04 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,755 [main] <==    Updates: 1
2019-04-22 10:11:06,763 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,764 [main] ==> Parameters: 33096401(String), 3095426(String), 0000000000000004(String), 2019-05-04 19:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,789 [main] <==    Updates: 1
2019-04-22 10:11:06,799 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,799 [main] ==> Parameters: 33096401(String), 3095427(String), 0000000000000005(String), 2019-05-04 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,820 [main] <==    Updates: 1
2019-04-22 10:11:06,829 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,829 [main] ==> Parameters: 33096401(String), 3095428(String), 0000000000000002(String), 2019-05-04 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,856 [main] <==    Updates: 1
2019-04-22 10:11:06,866 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,866 [main] ==> Parameters: 33096401(String), 3095429(String), 0000000000000001(String), 2019-05-04 21:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,898 [main] <==    Updates: 1
2019-04-22 10:11:06,906 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,906 [main] ==> Parameters: 33096401(String), 3095430(String), 0000000000000003(String), 2019-05-04 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,930 [main] <==    Updates: 1
2019-04-22 10:11:06,938 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,939 [main] ==> Parameters: 33096401(String), 3095966(String), 0000000000000003(String), 2019-04-24 00:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), en(String), null, 45.0(Double), 20.0(Double), 50.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:06,966 [main] <==    Updates: 1
2019-04-22 10:11:06,983 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:06,984 [main] ==> Parameters: 33096401(String), 3142051(String), 0000000000000004(String), 2019-04-22 10:20:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,008 [main] <==    Updates: 1
2019-04-22 10:11:07,035 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,035 [main] ==> Parameters: 33096401(String), 3142052(String), 0000000000000001(String), 2019-04-22 10:50:00.0(Timestamp), 2465(String), 境·界（数字）(2D)(String), 108(Integer), jp(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,061 [main] <==    Updates: 1
2019-04-22 10:11:07,069 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,069 [main] ==> Parameters: 33096401(String), 3142053(String), 0000000000000005(String), 2019-04-22 11:40:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 100(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,101 [main] <==    Updates: 1
2019-04-22 10:11:07,109 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,110 [main] ==> Parameters: 33096401(String), 3142054(String), 0000000000000002(String), 2019-04-22 12:00:00.0(Timestamp), 2494(String), 神奇乐园历险记（数字）(2D)(String), 85(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,139 [main] <==    Updates: 1
2019-04-22 10:11:07,147 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,147 [main] ==> Parameters: 33096401(String), 3142055(String), 0000000000000004(String), 2019-04-22 12:10:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,169 [main] <==    Updates: 1
2019-04-22 10:11:07,182 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,182 [main] ==> Parameters: 33096401(String), 3142056(String), 0000000000000003(String), 2019-04-22 12:30:00.0(Timestamp), 2457(String), 雷霆沙赞！（数字3D）(3D)(String), 132(Integer), or(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,205 [main] <==    Updates: 1
2019-04-22 10:11:07,214 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,215 [main] ==> Parameters: 33096401(String), 3142057(String), 0000000000000001(String), 2019-04-22 13:00:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 90(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,243 [main] <==    Updates: 1
2019-04-22 10:11:07,252 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,252 [main] ==> Parameters: 33096401(String), 3142058(String), 0000000000000005(String), 2019-04-22 13:30:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 100(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,281 [main] <==    Updates: 1
2019-04-22 10:11:07,292 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,293 [main] ==> Parameters: 33096401(String), 3142059(String), 0000000000000002(String), 2019-04-22 13:35:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,348 [main] <==    Updates: 1
2019-04-22 10:11:07,357 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,358 [main] ==> Parameters: 33096401(String), 3142060(String), 0000000000000004(String), 2019-04-22 14:00:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,397 [main] <==    Updates: 1
2019-04-22 10:11:07,410 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,411 [main] ==> Parameters: 33096401(String), 3142061(String), 0000000000000001(String), 2019-04-22 14:40:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 90(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,450 [main] <==    Updates: 1
2019-04-22 10:11:07,462 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,462 [main] ==> Parameters: 33096401(String), 3142062(String), 0000000000000003(String), 2019-04-22 14:50:00.0(Timestamp), 2457(String), 雷霆沙赞！（数字3D）(3D)(String), 132(Integer), or(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,484 [main] <==    Updates: 1
2019-04-22 10:11:07,493 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,493 [main] ==> Parameters: 33096401(String), 3142063(String), 0000000000000002(String), 2019-04-22 15:15:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,519 [main] <==    Updates: 1
2019-04-22 10:11:07,526 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,527 [main] ==> Parameters: 33096401(String), 3142064(String), 0000000000000005(String), 2019-04-22 15:20:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 100(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,557 [main] <==    Updates: 1
2019-04-22 10:11:07,568 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,568 [main] ==> Parameters: 33096401(String), 3142065(String), 0000000000000004(String), 2019-04-22 15:50:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,597 [main] <==    Updates: 1
2019-04-22 10:11:07,613 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,614 [main] ==> Parameters: 33096401(String), 3142066(String), 0000000000000001(String), 2019-04-22 16:20:00.0(Timestamp), 2465(String), 境·界（数字）(2D)(String), 108(Integer), jp(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,637 [main] <==    Updates: 1
2019-04-22 10:11:07,646 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,647 [main] ==> Parameters: 33096401(String), 3142067(String), 0000000000000002(String), 2019-04-22 16:55:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,669 [main] <==    Updates: 1
2019-04-22 10:11:07,677 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,677 [main] ==> Parameters: 33096401(String), 3142068(String), 0000000000000005(String), 2019-04-22 17:10:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 100(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,717 [main] <==    Updates: 1
2019-04-22 10:11:07,727 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,728 [main] ==> Parameters: 33096401(String), 3142069(String), 0000000000000003(String), 2019-04-22 17:20:00.0(Timestamp), 2457(String), 雷霆沙赞！（数字3D）(3D)(String), 132(Integer), or(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,750 [main] <==    Updates: 1
2019-04-22 10:11:07,763 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,764 [main] ==> Parameters: 33096401(String), 3142070(String), 0000000000000004(String), 2019-04-22 17:40:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,785 [main] <==    Updates: 1
2019-04-22 10:11:07,793 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,794 [main] ==> Parameters: 33096401(String), 3142071(String), 0000000000000002(String), 2019-04-22 18:35:00.0(Timestamp), 2494(String), 神奇乐园历险记（数字）(2D)(String), 85(Integer), cn(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,815 [main] <==    Updates: 1
2019-04-22 10:11:07,823 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,824 [main] ==> Parameters: 33096401(String), 3142072(String), 0000000000000001(String), 2019-04-22 18:40:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 90(Integer), cn(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,844 [main] <==    Updates: 1
2019-04-22 10:11:07,853 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,854 [main] ==> Parameters: 33096401(String), 3142073(String), 0000000000000005(String), 2019-04-22 19:00:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 100(Integer), cn(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,874 [main] <==    Updates: 1
2019-04-22 10:11:07,882 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,882 [main] ==> Parameters: 33096401(String), 3142074(String), 0000000000000004(String), 2019-04-22 19:30:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,905 [main] <==    Updates: 1
2019-04-22 10:11:07,916 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,917 [main] ==> Parameters: 33096401(String), 3142075(String), 0000000000000003(String), 2019-04-22 19:40:00.0(Timestamp), 2457(String), 雷霆沙赞！（数字3D）(3D)(String), 132(Integer), or(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,940 [main] <==    Updates: 1
2019-04-22 10:11:07,947 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,947 [main] ==> Parameters: 33096401(String), 3142076(String), 0000000000000002(String), 2019-04-22 20:10:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 90(Integer), cn(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:07,970 [main] <==    Updates: 1
2019-04-22 10:11:07,978 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:07,980 [main] ==> Parameters: 33096401(String), 3142077(String), 0000000000000001(String), 2019-04-22 20:20:00.0(Timestamp), 2465(String), 境·界（数字）(2D)(String), 108(Integer), jp(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:08,002 [main] <==    Updates: 1
2019-04-22 10:11:08,010 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:08,012 [main] ==> Parameters: 33096401(String), 3142078(String), 0000000000000005(String), 2019-04-22 20:50:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 100(Integer), cn(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:08,032 [main] <==    Updates: 1
2019-04-22 10:11:08,040 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:08,040 [main] ==> Parameters: 33096401(String), 3142079(String), 0000000000000004(String), 2019-04-22 21:20:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 45.0(Double), 20.0(Double), 42.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:08,061 [main] <==    Updates: 1
2019-04-22 10:11:08,069 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:08,070 [main] ==> Parameters: 33096401(String), 3142080(String), 0000000000000002(String), 2019-04-22 21:50:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:08,089 [main] <==    Updates: 1
2019-04-22 10:11:08,097 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:08,098 [main] ==> Parameters: 33096401(String), 3142081(String), 0000000000000003(String), 2019-04-22 22:00:00.0(Timestamp), 2457(String), 雷霆沙赞！（数字3D）(3D)(String), 132(Integer), or(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:08,123 [main] <==    Updates: 1
2019-04-22 10:11:08,131 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:11:08,132 [main] ==> Parameters: 33096401(String), 3142082(String), 0000000000000001(String), 2019-04-22 22:20:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 45.0(Double), 20.0(Double), 39.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:11:08,156 [main] <==    Updates: 1
2019-04-22 10:11:08,164 [main] ==>  Preparing: select * from sessioninfo t where t.userid=? and t.ccode = ? and t.starttime>=? and t.starttime<=? 
2019-04-22 10:11:08,165 [main] ==> Parameters: 12(Long), 33096401(String), 2019-01-01 00:00:00.0(Timestamp), 2019-06-20 00:00:00.0(Timestamp)
2019-04-22 10:11:10,957 [main] <==      Total: 165
2019-04-22 10:38:13,894 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 10:38:14,041 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 10:38:14,084 [main] <==      Total: 1
2019-04-22 10:38:14,105 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 10:38:14,107 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 10:38:14,127 [main] <==      Total: 1
2019-04-22 10:38:14,135 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 10:38:14,137 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 10:38:14,153 [main] <==      Total: 1
2019-04-22 10:38:14,162 [main] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.scode = ? and t.userID = ? 
2019-04-22 10:38:14,165 [main] ==> Parameters: 33097601(String), 3095299(String), 12(Long)
2019-04-22 10:38:16,690 [main] <==      Total: 0
2019-04-22 10:40:37,720 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:40:37,844 [main] ==> Parameters: 33096401(String), 1044(String)
2019-04-22 10:40:37,906 [main] <==      Total: 0
2019-04-22 10:42:57,845 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:57,966 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:57,995 [main] <==      Total: 1
2019-04-22 10:42:58,006 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,007 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,019 [main] <==      Total: 1
2019-04-22 10:42:58,036 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,037 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,049 [main] <==      Total: 1
2019-04-22 10:42:58,058 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,058 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:58,071 [main] <==      Total: 1
2019-04-22 10:42:58,081 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,082 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,094 [main] <==      Total: 1
2019-04-22 10:42:58,104 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,105 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:58,118 [main] <==      Total: 1
2019-04-22 10:42:58,129 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,129 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:58,143 [main] <==      Total: 1
2019-04-22 10:42:58,173 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,174 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:42:58,186 [main] <==      Total: 1
2019-04-22 10:42:58,200 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,200 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:58,212 [main] <==      Total: 1
2019-04-22 10:42:58,229 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,229 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,247 [main] <==      Total: 1
2019-04-22 10:42:58,261 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,262 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,279 [main] <==      Total: 1
2019-04-22 10:42:58,289 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,290 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,307 [main] <==      Total: 1
2019-04-22 10:42:58,318 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,319 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:58,333 [main] <==      Total: 1
2019-04-22 10:42:58,348 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,349 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,362 [main] <==      Total: 1
2019-04-22 10:42:58,370 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,372 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:58,385 [main] <==      Total: 1
2019-04-22 10:42:58,399 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,410 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:58,427 [main] <==      Total: 1
2019-04-22 10:42:58,437 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,437 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:42:58,449 [main] <==      Total: 1
2019-04-22 10:42:58,458 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,458 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,470 [main] <==      Total: 1
2019-04-22 10:42:58,478 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,479 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,491 [main] <==      Total: 1
2019-04-22 10:42:58,499 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,500 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,511 [main] <==      Total: 1
2019-04-22 10:42:58,519 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,520 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:58,532 [main] <==      Total: 1
2019-04-22 10:42:58,540 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,541 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,554 [main] <==      Total: 1
2019-04-22 10:42:58,563 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,563 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:58,580 [main] <==      Total: 1
2019-04-22 10:42:58,591 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,592 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:58,604 [main] <==      Total: 1
2019-04-22 10:42:58,619 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,619 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,633 [main] <==      Total: 1
2019-04-22 10:42:58,643 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,644 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,656 [main] <==      Total: 1
2019-04-22 10:42:58,665 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,666 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,677 [main] <==      Total: 1
2019-04-22 10:42:58,685 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,686 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:58,698 [main] <==      Total: 1
2019-04-22 10:42:58,707 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,708 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,720 [main] <==      Total: 1
2019-04-22 10:42:58,730 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,731 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:58,742 [main] <==      Total: 1
2019-04-22 10:42:58,751 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,751 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:58,767 [main] <==      Total: 1
2019-04-22 10:42:58,775 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,776 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,791 [main] <==      Total: 1
2019-04-22 10:42:58,813 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,814 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,827 [main] <==      Total: 1
2019-04-22 10:42:58,835 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,836 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,848 [main] <==      Total: 1
2019-04-22 10:42:58,858 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,859 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:58,874 [main] <==      Total: 1
2019-04-22 10:42:58,884 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,885 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,899 [main] <==      Total: 1
2019-04-22 10:42:58,909 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,910 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:58,922 [main] <==      Total: 1
2019-04-22 10:42:58,931 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,933 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:58,946 [main] <==      Total: 1
2019-04-22 10:42:58,955 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,956 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,969 [main] <==      Total: 1
2019-04-22 10:42:58,982 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:58,983 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:58,998 [main] <==      Total: 1
2019-04-22 10:42:59,010 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,011 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,025 [main] <==      Total: 1
2019-04-22 10:42:59,035 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,036 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:59,048 [main] <==      Total: 1
2019-04-22 10:42:59,061 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,062 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,073 [main] <==      Total: 1
2019-04-22 10:42:59,082 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,082 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:59,096 [main] <==      Total: 1
2019-04-22 10:42:59,112 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,113 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:59,126 [main] <==      Total: 1
2019-04-22 10:42:59,136 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,137 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,148 [main] <==      Total: 1
2019-04-22 10:42:59,157 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,157 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,170 [main] <==      Total: 1
2019-04-22 10:42:59,181 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,181 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,193 [main] <==      Total: 1
2019-04-22 10:42:59,203 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,204 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:59,217 [main] <==      Total: 1
2019-04-22 10:42:59,226 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,226 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,239 [main] <==      Total: 1
2019-04-22 10:42:59,249 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,250 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:59,263 [main] <==      Total: 1
2019-04-22 10:42:59,273 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,273 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:59,292 [main] <==      Total: 1
2019-04-22 10:42:59,301 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,301 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,312 [main] <==      Total: 1
2019-04-22 10:42:59,321 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,322 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,333 [main] <==      Total: 1
2019-04-22 10:42:59,342 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,342 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,353 [main] <==      Total: 1
2019-04-22 10:42:59,363 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,364 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:59,376 [main] <==      Total: 1
2019-04-22 10:42:59,385 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,386 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,398 [main] <==      Total: 1
2019-04-22 10:42:59,410 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,411 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:59,424 [main] <==      Total: 1
2019-04-22 10:42:59,433 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,433 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:59,445 [main] <==      Total: 1
2019-04-22 10:42:59,457 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,458 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,472 [main] <==      Total: 1
2019-04-22 10:42:59,481 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,482 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,495 [main] <==      Total: 1
2019-04-22 10:42:59,505 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,506 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,519 [main] <==      Total: 1
2019-04-22 10:42:59,528 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,529 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:59,543 [main] <==      Total: 1
2019-04-22 10:42:59,552 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,554 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,567 [main] <==      Total: 1
2019-04-22 10:42:59,577 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,578 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:59,590 [main] <==      Total: 1
2019-04-22 10:42:59,600 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,600 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:59,611 [main] <==      Total: 1
2019-04-22 10:42:59,619 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,620 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,632 [main] <==      Total: 1
2019-04-22 10:42:59,645 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,646 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,658 [main] <==      Total: 1
2019-04-22 10:42:59,667 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,668 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,681 [main] <==      Total: 1
2019-04-22 10:42:59,692 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,693 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:59,704 [main] <==      Total: 1
2019-04-22 10:42:59,715 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,715 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,727 [main] <==      Total: 1
2019-04-22 10:42:59,736 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,736 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:59,748 [main] <==      Total: 1
2019-04-22 10:42:59,758 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,759 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:59,771 [main] <==      Total: 1
2019-04-22 10:42:59,780 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,781 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,792 [main] <==      Total: 1
2019-04-22 10:42:59,800 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,801 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,812 [main] <==      Total: 1
2019-04-22 10:42:59,821 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,821 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,832 [main] <==      Total: 1
2019-04-22 10:42:59,843 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,844 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:42:59,856 [main] <==      Total: 1
2019-04-22 10:42:59,865 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,866 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,877 [main] <==      Total: 1
2019-04-22 10:42:59,886 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,888 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:59,900 [main] <==      Total: 1
2019-04-22 10:42:59,909 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,909 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:42:59,924 [main] <==      Total: 1
2019-04-22 10:42:59,933 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,934 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:42:59,946 [main] <==      Total: 1
2019-04-22 10:42:59,955 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,955 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:42:59,967 [main] <==      Total: 1
2019-04-22 10:42:59,976 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,977 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:42:59,989 [main] <==      Total: 1
2019-04-22 10:42:59,999 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:42:59,999 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,013 [main] <==      Total: 1
2019-04-22 10:43:00,022 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,023 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:00,035 [main] <==      Total: 1
2019-04-22 10:43:00,044 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,045 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,055 [main] <==      Total: 1
2019-04-22 10:43:00,064 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,064 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:00,075 [main] <==      Total: 1
2019-04-22 10:43:00,085 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,090 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,102 [main] <==      Total: 1
2019-04-22 10:43:00,111 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,111 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:00,123 [main] <==      Total: 1
2019-04-22 10:43:00,131 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,132 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,145 [main] <==      Total: 1
2019-04-22 10:43:00,155 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,156 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:00,171 [main] <==      Total: 1
2019-04-22 10:43:00,180 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,180 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,192 [main] <==      Total: 1
2019-04-22 10:43:00,201 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,202 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:43:00,221 [main] <==      Total: 1
2019-04-22 10:43:00,230 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,231 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,243 [main] <==      Total: 1
2019-04-22 10:43:00,252 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,252 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:43:00,265 [main] <==      Total: 1
2019-04-22 10:43:00,273 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,273 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,286 [main] <==      Total: 1
2019-04-22 10:43:00,310 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,310 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:43:00,322 [main] <==      Total: 1
2019-04-22 10:43:00,333 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,334 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,353 [main] <==      Total: 1
2019-04-22 10:43:00,364 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,364 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:43:00,375 [main] <==      Total: 1
2019-04-22 10:43:00,395 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,395 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:43:00,408 [main] <==      Total: 1
2019-04-22 10:43:00,415 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,415 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,426 [main] <==      Total: 1
2019-04-22 10:43:00,435 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,436 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:43:00,448 [main] <==      Total: 1
2019-04-22 10:43:00,457 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,457 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,469 [main] <==      Total: 1
2019-04-22 10:43:00,478 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,478 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:43:00,489 [main] <==      Total: 1
2019-04-22 10:43:00,512 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,512 [main] ==> Parameters: 33097601(String), 1049(String)
2019-04-22 10:43:00,524 [main] <==      Total: 1
2019-04-22 10:43:00,534 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,534 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,547 [main] <==      Total: 1
2019-04-22 10:43:00,555 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,555 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,569 [main] <==      Total: 1
2019-04-22 10:43:00,587 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,588 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,600 [main] <==      Total: 1
2019-04-22 10:43:00,609 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,610 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,624 [main] <==      Total: 1
2019-04-22 10:43:00,634 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,634 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:00,649 [main] <==      Total: 1
2019-04-22 10:43:00,659 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,660 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,671 [main] <==      Total: 1
2019-04-22 10:43:00,679 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,679 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,689 [main] <==      Total: 1
2019-04-22 10:43:00,700 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,700 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,712 [main] <==      Total: 1
2019-04-22 10:43:00,721 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,721 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,733 [main] <==      Total: 1
2019-04-22 10:43:00,745 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,746 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,760 [main] <==      Total: 1
2019-04-22 10:43:00,771 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,772 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,785 [main] <==      Total: 1
2019-04-22 10:43:00,794 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,795 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,808 [main] <==      Total: 1
2019-04-22 10:43:00,818 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,818 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,830 [main] <==      Total: 1
2019-04-22 10:43:00,838 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,838 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:00,850 [main] <==      Total: 1
2019-04-22 10:43:00,868 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,869 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,881 [main] <==      Total: 1
2019-04-22 10:43:00,890 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,891 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:00,903 [main] <==      Total: 1
2019-04-22 10:43:00,918 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,918 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:00,931 [main] <==      Total: 1
2019-04-22 10:43:00,942 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,943 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:00,958 [main] <==      Total: 1
2019-04-22 10:43:00,967 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,967 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:00,980 [main] <==      Total: 1
2019-04-22 10:43:00,989 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:00,990 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,001 [main] <==      Total: 1
2019-04-22 10:43:01,025 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,025 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,040 [main] <==      Total: 1
2019-04-22 10:43:01,060 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,061 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,073 [main] <==      Total: 1
2019-04-22 10:43:01,082 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,083 [main] ==> Parameters: 33097601(String), 1048(String)
2019-04-22 10:43:01,102 [main] <==      Total: 1
2019-04-22 10:43:01,115 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,116 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:43:01,128 [main] <==      Total: 1
2019-04-22 10:43:01,137 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,138 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:43:01,154 [main] <==      Total: 1
2019-04-22 10:43:01,166 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,167 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,183 [main] <==      Total: 1
2019-04-22 10:43:01,193 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,194 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:01,207 [main] <==      Total: 1
2019-04-22 10:43:01,218 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,218 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:01,228 [main] <==      Total: 1
2019-04-22 10:43:01,236 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,237 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:43:01,249 [main] <==      Total: 1
2019-04-22 10:43:01,258 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,259 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,272 [main] <==      Total: 1
2019-04-22 10:43:01,280 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,281 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:43:01,292 [main] <==      Total: 1
2019-04-22 10:43:01,300 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,301 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:01,315 [main] <==      Total: 1
2019-04-22 10:43:01,329 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,329 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:01,341 [main] <==      Total: 1
2019-04-22 10:43:01,350 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,350 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:43:01,370 [main] <==      Total: 1
2019-04-22 10:43:01,379 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,380 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,392 [main] <==      Total: 1
2019-04-22 10:43:01,402 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,402 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:43:01,414 [main] <==      Total: 1
2019-04-22 10:43:01,434 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,435 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:01,451 [main] <==      Total: 1
2019-04-22 10:43:01,460 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,461 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:01,478 [main] <==      Total: 1
2019-04-22 10:43:01,487 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,487 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,499 [main] <==      Total: 1
2019-04-22 10:43:01,510 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,511 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:43:01,523 [main] <==      Total: 1
2019-04-22 10:43:01,532 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,533 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:43:01,545 [main] <==      Total: 1
2019-04-22 10:43:01,553 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,553 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:01,565 [main] <==      Total: 1
2019-04-22 10:43:01,573 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,574 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:01,587 [main] <==      Total: 1
2019-04-22 10:43:01,598 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,599 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,611 [main] <==      Total: 1
2019-04-22 10:43:01,621 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,622 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:43:01,638 [main] <==      Total: 1
2019-04-22 10:43:01,648 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,649 [main] ==> Parameters: 33097601(String), 1048(String)
2019-04-22 10:43:01,660 [main] <==      Total: 1
2019-04-22 10:43:01,682 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,683 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:43:01,694 [main] <==      Total: 1
2019-04-22 10:43:01,702 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,703 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:01,715 [main] <==      Total: 1
2019-04-22 10:43:01,727 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,728 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:01,740 [main] <==      Total: 1
2019-04-22 10:43:01,748 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,748 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,776 [main] <==      Total: 1
2019-04-22 10:43:01,801 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,801 [main] ==> Parameters: 33097601(String), 1048(String)
2019-04-22 10:43:01,851 [main] <==      Total: 1
2019-04-22 10:43:01,862 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,862 [main] ==> Parameters: 33097601(String), 1051(String)
2019-04-22 10:43:01,874 [main] <==      Total: 1
2019-04-22 10:43:01,886 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,886 [main] ==> Parameters: 33097601(String), 1044(String)
2019-04-22 10:43:01,898 [main] <==      Total: 1
2019-04-22 10:43:01,908 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,908 [main] ==> Parameters: 33097601(String), 1047(String)
2019-04-22 10:43:01,920 [main] <==      Total: 1
2019-04-22 10:43:01,929 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,930 [main] ==> Parameters: 33097601(String), 1050(String)
2019-04-22 10:43:01,942 [main] <==      Total: 1
2019-04-22 10:43:01,952 [main] ==>  Preparing: select * from screeninfo t where t.ccode = ? and t.screenid=? 
2019-04-22 10:43:01,953 [main] ==> Parameters: 33097601(String), 1046(String)
2019-04-22 10:43:01,974 [main] <==      Total: 1
2019-04-22 10:43:02,014 [main] ==>  Preparing: delete from sessioninfo WHERE CCode = ? and UserId = ? and StartTime >= ? 
2019-04-22 10:43:02,019 [main] ==> Parameters: 33097601(String), 12(Long), 2019-04-22(String)
2019-04-22 10:43:04,339 [main] <==    Updates: 128
2019-04-22 10:43:04,350 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,414 [main] ==> Parameters: 33097601(String), 3093944(String), 0000000000000001(String), 2019-04-24 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,445 [main] <==    Updates: 1
2019-04-22 10:43:04,453 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,453 [main] ==> Parameters: 33097601(String), 3093945(String), 0000000000000001(String), 2019-04-24 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,490 [main] <==    Updates: 1
2019-04-22 10:43:04,500 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,503 [main] ==> Parameters: 33097601(String), 3093946(String), 0000000000000001(String), 2019-04-24 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,526 [main] <==    Updates: 1
2019-04-22 10:43:04,536 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,536 [main] ==> Parameters: 33097601(String), 3093947(String), 0000000000000007(String), 2019-04-24 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,566 [main] <==    Updates: 1
2019-04-22 10:43:04,574 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,575 [main] ==> Parameters: 33097601(String), 3093948(String), 0000000000000001(String), 2019-04-24 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,613 [main] <==    Updates: 1
2019-04-22 10:43:04,623 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,625 [main] ==> Parameters: 33097601(String), 3093949(String), 0000000000000008(String), 2019-04-24 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,649 [main] <==    Updates: 1
2019-04-22 10:43:04,664 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,666 [main] ==> Parameters: 33097601(String), 3093950(String), 0000000000000003(String), 2019-04-24 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,693 [main] <==    Updates: 1
2019-04-22 10:43:04,703 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,706 [main] ==> Parameters: 33097601(String), 3093951(String), 0000000000000004(String), 2019-04-24 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,736 [main] <==    Updates: 1
2019-04-22 10:43:04,745 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,747 [main] ==> Parameters: 33097601(String), 3093952(String), 0000000000000007(String), 2019-04-24 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,782 [main] <==    Updates: 1
2019-04-22 10:43:04,790 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,793 [main] ==> Parameters: 33097601(String), 3093953(String), 0000000000000001(String), 2019-04-25 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,830 [main] <==    Updates: 1
2019-04-22 10:43:04,839 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,842 [main] ==> Parameters: 33097601(String), 3093954(String), 0000000000000001(String), 2019-04-25 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,865 [main] <==    Updates: 1
2019-04-22 10:43:04,875 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,876 [main] ==> Parameters: 33097601(String), 3093955(String), 0000000000000001(String), 2019-04-25 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,901 [main] <==    Updates: 1
2019-04-22 10:43:04,909 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,910 [main] ==> Parameters: 33097601(String), 3093956(String), 0000000000000007(String), 2019-04-25 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,941 [main] <==    Updates: 1
2019-04-22 10:43:04,953 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,955 [main] ==> Parameters: 33097601(String), 3093957(String), 0000000000000001(String), 2019-04-25 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:04,982 [main] <==    Updates: 1
2019-04-22 10:43:04,990 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:04,992 [main] ==> Parameters: 33097601(String), 3093958(String), 0000000000000008(String), 2019-04-25 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,014 [main] <==    Updates: 1
2019-04-22 10:43:05,025 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,027 [main] ==> Parameters: 33097601(String), 3093959(String), 0000000000000003(String), 2019-04-25 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,051 [main] <==    Updates: 1
2019-04-22 10:43:05,060 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,062 [main] ==> Parameters: 33097601(String), 3093960(String), 0000000000000004(String), 2019-04-25 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,086 [main] <==    Updates: 1
2019-04-22 10:43:05,094 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,095 [main] ==> Parameters: 33097601(String), 3093961(String), 0000000000000001(String), 2019-04-26 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,128 [main] <==    Updates: 1
2019-04-22 10:43:05,137 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,137 [main] ==> Parameters: 33097601(String), 3093962(String), 0000000000000001(String), 2019-04-26 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,162 [main] <==    Updates: 1
2019-04-22 10:43:05,171 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,173 [main] ==> Parameters: 33097601(String), 3093963(String), 0000000000000001(String), 2019-04-26 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,196 [main] <==    Updates: 1
2019-04-22 10:43:05,208 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,208 [main] ==> Parameters: 33097601(String), 3093964(String), 0000000000000007(String), 2019-04-26 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,238 [main] <==    Updates: 1
2019-04-22 10:43:05,248 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,248 [main] ==> Parameters: 33097601(String), 3093965(String), 0000000000000001(String), 2019-04-26 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,271 [main] <==    Updates: 1
2019-04-22 10:43:05,280 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,282 [main] ==> Parameters: 33097601(String), 3093966(String), 0000000000000008(String), 2019-04-26 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,307 [main] <==    Updates: 1
2019-04-22 10:43:05,316 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,318 [main] ==> Parameters: 33097601(String), 3093967(String), 0000000000000003(String), 2019-04-26 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,352 [main] <==    Updates: 1
2019-04-22 10:43:05,361 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,362 [main] ==> Parameters: 33097601(String), 3093968(String), 0000000000000001(String), 2019-04-27 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,390 [main] <==    Updates: 1
2019-04-22 10:43:05,398 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,399 [main] ==> Parameters: 33097601(String), 3093969(String), 0000000000000001(String), 2019-04-27 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,436 [main] <==    Updates: 1
2019-04-22 10:43:05,444 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,445 [main] ==> Parameters: 33097601(String), 3093970(String), 0000000000000001(String), 2019-04-27 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,469 [main] <==    Updates: 1
2019-04-22 10:43:05,478 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,480 [main] ==> Parameters: 33097601(String), 3093971(String), 0000000000000007(String), 2019-04-27 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,504 [main] <==    Updates: 1
2019-04-22 10:43:05,513 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,514 [main] ==> Parameters: 33097601(String), 3093972(String), 0000000000000001(String), 2019-04-27 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,545 [main] <==    Updates: 1
2019-04-22 10:43:05,556 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,557 [main] ==> Parameters: 33097601(String), 3093973(String), 0000000000000008(String), 2019-04-27 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,584 [main] <==    Updates: 1
2019-04-22 10:43:05,593 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,595 [main] ==> Parameters: 33097601(String), 3093974(String), 0000000000000003(String), 2019-04-27 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,622 [main] <==    Updates: 1
2019-04-22 10:43:05,630 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,631 [main] ==> Parameters: 33097601(String), 3093975(String), 0000000000000001(String), 2019-04-28 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,654 [main] <==    Updates: 1
2019-04-22 10:43:05,662 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,663 [main] ==> Parameters: 33097601(String), 3093976(String), 0000000000000001(String), 2019-04-28 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,697 [main] <==    Updates: 1
2019-04-22 10:43:05,708 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,708 [main] ==> Parameters: 33097601(String), 3093977(String), 0000000000000001(String), 2019-04-28 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,729 [main] <==    Updates: 1
2019-04-22 10:43:05,738 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,738 [main] ==> Parameters: 33097601(String), 3093978(String), 0000000000000007(String), 2019-04-28 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,762 [main] <==    Updates: 1
2019-04-22 10:43:05,769 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,770 [main] ==> Parameters: 33097601(String), 3093979(String), 0000000000000001(String), 2019-04-28 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,794 [main] <==    Updates: 1
2019-04-22 10:43:05,803 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,803 [main] ==> Parameters: 33097601(String), 3093980(String), 0000000000000008(String), 2019-04-28 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,832 [main] <==    Updates: 1
2019-04-22 10:43:05,840 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,841 [main] ==> Parameters: 33097601(String), 3093981(String), 0000000000000003(String), 2019-04-28 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,871 [main] <==    Updates: 1
2019-04-22 10:43:05,880 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,881 [main] ==> Parameters: 33097601(String), 3093982(String), 0000000000000001(String), 2019-04-29 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,902 [main] <==    Updates: 1
2019-04-22 10:43:05,911 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,911 [main] ==> Parameters: 33097601(String), 3093983(String), 0000000000000001(String), 2019-04-29 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,933 [main] <==    Updates: 1
2019-04-22 10:43:05,944 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,946 [main] ==> Parameters: 33097601(String), 3093984(String), 0000000000000001(String), 2019-04-29 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,968 [main] <==    Updates: 1
2019-04-22 10:43:05,977 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:05,978 [main] ==> Parameters: 33097601(String), 3093985(String), 0000000000000007(String), 2019-04-29 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:05,999 [main] <==    Updates: 1
2019-04-22 10:43:06,008 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,009 [main] ==> Parameters: 33097601(String), 3093986(String), 0000000000000001(String), 2019-04-29 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,030 [main] <==    Updates: 1
2019-04-22 10:43:06,038 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,039 [main] ==> Parameters: 33097601(String), 3093987(String), 0000000000000008(String), 2019-04-29 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,059 [main] <==    Updates: 1
2019-04-22 10:43:06,067 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,068 [main] ==> Parameters: 33097601(String), 3093988(String), 0000000000000003(String), 2019-04-29 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,088 [main] <==    Updates: 1
2019-04-22 10:43:06,096 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,096 [main] ==> Parameters: 33097601(String), 3093989(String), 0000000000000001(String), 2019-04-30 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,117 [main] <==    Updates: 1
2019-04-22 10:43:06,126 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,127 [main] ==> Parameters: 33097601(String), 3093990(String), 0000000000000001(String), 2019-04-30 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,147 [main] <==    Updates: 1
2019-04-22 10:43:06,159 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,159 [main] ==> Parameters: 33097601(String), 3093991(String), 0000000000000001(String), 2019-04-30 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,184 [main] <==    Updates: 1
2019-04-22 10:43:06,192 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,193 [main] ==> Parameters: 33097601(String), 3093992(String), 0000000000000007(String), 2019-04-30 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,214 [main] <==    Updates: 1
2019-04-22 10:43:06,230 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,231 [main] ==> Parameters: 33097601(String), 3093993(String), 0000000000000001(String), 2019-04-30 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,254 [main] <==    Updates: 1
2019-04-22 10:43:06,265 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,267 [main] ==> Parameters: 33097601(String), 3093994(String), 0000000000000008(String), 2019-04-30 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,294 [main] <==    Updates: 1
2019-04-22 10:43:06,303 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,304 [main] ==> Parameters: 33097601(String), 3093995(String), 0000000000000003(String), 2019-04-30 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,331 [main] <==    Updates: 1
2019-04-22 10:43:06,343 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,343 [main] ==> Parameters: 33097601(String), 3093996(String), 0000000000000001(String), 2019-05-01 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,366 [main] <==    Updates: 1
2019-04-22 10:43:06,375 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,375 [main] ==> Parameters: 33097601(String), 3093997(String), 0000000000000001(String), 2019-05-01 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,413 [main] <==    Updates: 1
2019-04-22 10:43:06,430 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,432 [main] ==> Parameters: 33097601(String), 3093998(String), 0000000000000001(String), 2019-05-01 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,454 [main] <==    Updates: 1
2019-04-22 10:43:06,466 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,467 [main] ==> Parameters: 33097601(String), 3093999(String), 0000000000000007(String), 2019-05-01 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,494 [main] <==    Updates: 1
2019-04-22 10:43:06,502 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,503 [main] ==> Parameters: 33097601(String), 3094000(String), 0000000000000001(String), 2019-05-01 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,530 [main] <==    Updates: 1
2019-04-22 10:43:06,543 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,543 [main] ==> Parameters: 33097601(String), 3094001(String), 0000000000000008(String), 2019-05-01 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,575 [main] <==    Updates: 1
2019-04-22 10:43:06,584 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,585 [main] ==> Parameters: 33097601(String), 3094002(String), 0000000000000003(String), 2019-05-01 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,609 [main] <==    Updates: 1
2019-04-22 10:43:06,617 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,618 [main] ==> Parameters: 33097601(String), 3094003(String), 0000000000000001(String), 2019-05-02 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,641 [main] <==    Updates: 1
2019-04-22 10:43:06,648 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,649 [main] ==> Parameters: 33097601(String), 3094004(String), 0000000000000001(String), 2019-05-02 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,672 [main] <==    Updates: 1
2019-04-22 10:43:06,682 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,683 [main] ==> Parameters: 33097601(String), 3094005(String), 0000000000000001(String), 2019-05-02 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,711 [main] <==    Updates: 1
2019-04-22 10:43:06,721 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,722 [main] ==> Parameters: 33097601(String), 3094006(String), 0000000000000007(String), 2019-05-02 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,745 [main] <==    Updates: 1
2019-04-22 10:43:06,753 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,754 [main] ==> Parameters: 33097601(String), 3094007(String), 0000000000000001(String), 2019-05-02 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,781 [main] <==    Updates: 1
2019-04-22 10:43:06,794 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,796 [main] ==> Parameters: 33097601(String), 3094008(String), 0000000000000008(String), 2019-05-02 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,850 [main] <==    Updates: 1
2019-04-22 10:43:06,858 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,859 [main] ==> Parameters: 33097601(String), 3094009(String), 0000000000000003(String), 2019-05-02 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,888 [main] <==    Updates: 1
2019-04-22 10:43:06,898 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,900 [main] ==> Parameters: 33097601(String), 3094010(String), 0000000000000001(String), 2019-05-03 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,926 [main] <==    Updates: 1
2019-04-22 10:43:06,933 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,934 [main] ==> Parameters: 33097601(String), 3094011(String), 0000000000000001(String), 2019-05-03 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,960 [main] <==    Updates: 1
2019-04-22 10:43:06,969 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:06,969 [main] ==> Parameters: 33097601(String), 3094012(String), 0000000000000001(String), 2019-05-03 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:06,994 [main] <==    Updates: 1
2019-04-22 10:43:07,008 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,008 [main] ==> Parameters: 33097601(String), 3094013(String), 0000000000000007(String), 2019-05-03 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,034 [main] <==    Updates: 1
2019-04-22 10:43:07,044 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,044 [main] ==> Parameters: 33097601(String), 3094014(String), 0000000000000001(String), 2019-05-03 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,068 [main] <==    Updates: 1
2019-04-22 10:43:07,076 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,077 [main] ==> Parameters: 33097601(String), 3094015(String), 0000000000000008(String), 2019-05-03 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,100 [main] <==    Updates: 1
2019-04-22 10:43:07,108 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,108 [main] ==> Parameters: 33097601(String), 3094016(String), 0000000000000003(String), 2019-05-03 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,139 [main] <==    Updates: 1
2019-04-22 10:43:07,150 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,152 [main] ==> Parameters: 33097601(String), 3094017(String), 0000000000000001(String), 2019-05-04 09:50:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,183 [main] <==    Updates: 1
2019-04-22 10:43:07,191 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,192 [main] ==> Parameters: 33097601(String), 3094018(String), 0000000000000001(String), 2019-05-04 13:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,217 [main] <==    Updates: 1
2019-04-22 10:43:07,225 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,226 [main] ==> Parameters: 33097601(String), 3094019(String), 0000000000000001(String), 2019-05-04 16:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,246 [main] <==    Updates: 1
2019-04-22 10:43:07,255 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,255 [main] ==> Parameters: 33097601(String), 3094020(String), 0000000000000007(String), 2019-05-04 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,279 [main] <==    Updates: 1
2019-04-22 10:43:07,294 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,295 [main] ==> Parameters: 33097601(String), 3094021(String), 0000000000000001(String), 2019-05-04 19:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,318 [main] <==    Updates: 1
2019-04-22 10:43:07,334 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,334 [main] ==> Parameters: 33097601(String), 3094022(String), 0000000000000008(String), 2019-05-04 19:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,355 [main] <==    Updates: 1
2019-04-22 10:43:07,363 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,363 [main] ==> Parameters: 33097601(String), 3094023(String), 0000000000000003(String), 2019-05-04 20:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,400 [main] <==    Updates: 1
2019-04-22 10:43:07,416 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,418 [main] ==> Parameters: 33097601(String), 3095673(String), 0000000000000006(String), 2019-04-26 20:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,441 [main] <==    Updates: 1
2019-04-22 10:43:07,449 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,450 [main] ==> Parameters: 33097601(String), 3096085(String), 0000000000000008(String), 2019-04-24 00:05:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,475 [main] <==    Updates: 1
2019-04-22 10:43:07,483 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,483 [main] ==> Parameters: 33097601(String), 3105864(String), 0000000000000001(String), 2019-04-24 00:05:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,510 [main] <==    Updates: 1
2019-04-22 10:43:07,520 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,521 [main] ==> Parameters: 33097601(String), 3109960(String), 0000000000000007(String), 2019-04-24 12:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,551 [main] <==    Updates: 1
2019-04-22 10:43:07,560 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,560 [main] ==> Parameters: 33097601(String), 3109961(String), 0000000000000004(String), 2019-04-24 14:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,593 [main] <==    Updates: 1
2019-04-22 10:43:07,601 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,601 [main] ==> Parameters: 33097601(String), 3109962(String), 0000000000000007(String), 2019-04-24 15:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,636 [main] <==    Updates: 1
2019-04-22 10:43:07,645 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,647 [main] ==> Parameters: 33097601(String), 3109963(String), 0000000000000004(String), 2019-04-24 17:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,670 [main] <==    Updates: 1
2019-04-22 10:43:07,677 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,678 [main] ==> Parameters: 33097601(String), 3109964(String), 0000000000000007(String), 2019-04-25 12:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,700 [main] <==    Updates: 1
2019-04-22 10:43:07,708 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,708 [main] ==> Parameters: 33097601(String), 3109965(String), 0000000000000004(String), 2019-04-25 14:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,744 [main] <==    Updates: 1
2019-04-22 10:43:07,757 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,758 [main] ==> Parameters: 33097601(String), 3109966(String), 0000000000000007(String), 2019-04-25 15:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,782 [main] <==    Updates: 1
2019-04-22 10:43:07,790 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,790 [main] ==> Parameters: 33097601(String), 3109967(String), 0000000000000004(String), 2019-04-25 17:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,816 [main] <==    Updates: 1
2019-04-22 10:43:07,825 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,827 [main] ==> Parameters: 33097601(String), 3109968(String), 0000000000000007(String), 2019-04-26 12:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,853 [main] <==    Updates: 1
2019-04-22 10:43:07,863 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,864 [main] ==> Parameters: 33097601(String), 3109969(String), 0000000000000006(String), 2019-04-26 14:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,900 [main] <==    Updates: 1
2019-04-22 10:43:07,908 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,909 [main] ==> Parameters: 33097601(String), 3109970(String), 0000000000000007(String), 2019-04-26 15:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:07,945 [main] <==    Updates: 1
2019-04-22 10:43:07,959 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:07,960 [main] ==> Parameters: 33097601(String), 3109971(String), 0000000000000006(String), 2019-04-26 17:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,003 [main] <==    Updates: 1
2019-04-22 10:43:08,013 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,014 [main] ==> Parameters: 33097601(String), 3109972(String), 0000000000000007(String), 2019-04-27 12:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,037 [main] <==    Updates: 1
2019-04-22 10:43:08,046 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,046 [main] ==> Parameters: 33097601(String), 3109973(String), 0000000000000006(String), 2019-04-27 14:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,072 [main] <==    Updates: 1
2019-04-22 10:43:08,081 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,082 [main] ==> Parameters: 33097601(String), 3109974(String), 0000000000000007(String), 2019-04-27 15:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,105 [main] <==    Updates: 1
2019-04-22 10:43:08,113 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,114 [main] ==> Parameters: 33097601(String), 3109975(String), 0000000000000006(String), 2019-04-27 17:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,136 [main] <==    Updates: 1
2019-04-22 10:43:08,145 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,146 [main] ==> Parameters: 33097601(String), 3109976(String), 0000000000000006(String), 2019-04-27 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,168 [main] <==    Updates: 1
2019-04-22 10:43:08,178 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,179 [main] ==> Parameters: 33097601(String), 3109977(String), 0000000000000007(String), 2019-04-28 12:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,203 [main] <==    Updates: 1
2019-04-22 10:43:08,215 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,217 [main] ==> Parameters: 33097601(String), 3109978(String), 0000000000000006(String), 2019-04-28 14:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,252 [main] <==    Updates: 1
2019-04-22 10:43:08,261 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,271 [main] ==> Parameters: 33097601(String), 3109979(String), 0000000000000007(String), 2019-04-28 15:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,295 [main] <==    Updates: 1
2019-04-22 10:43:08,303 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,303 [main] ==> Parameters: 33097601(String), 3109980(String), 0000000000000006(String), 2019-04-28 17:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,332 [main] <==    Updates: 1
2019-04-22 10:43:08,339 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,339 [main] ==> Parameters: 33097601(String), 3109981(String), 0000000000000006(String), 2019-04-28 20:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,362 [main] <==    Updates: 1
2019-04-22 10:43:08,371 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,373 [main] ==> Parameters: 33097601(String), 3109982(String), 0000000000000007(String), 2019-04-28 22:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,400 [main] <==    Updates: 1
2019-04-22 10:43:08,409 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,410 [main] ==> Parameters: 33097601(String), 3109983(String), 0000000000000003(String), 2019-05-03 10:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,440 [main] <==    Updates: 1
2019-04-22 10:43:08,448 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,449 [main] ==> Parameters: 33097601(String), 3109984(String), 0000000000000007(String), 2019-05-03 12:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,474 [main] <==    Updates: 1
2019-04-22 10:43:08,484 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,484 [main] ==> Parameters: 33097601(String), 3109985(String), 0000000000000003(String), 2019-05-03 13:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,506 [main] <==    Updates: 1
2019-04-22 10:43:08,514 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,515 [main] ==> Parameters: 33097601(String), 3109986(String), 0000000000000007(String), 2019-05-03 15:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,536 [main] <==    Updates: 1
2019-04-22 10:43:08,544 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,544 [main] ==> Parameters: 33097601(String), 3109987(String), 0000000000000003(String), 2019-05-03 16:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,566 [main] <==    Updates: 1
2019-04-22 10:43:08,574 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,575 [main] ==> Parameters: 33097601(String), 3128772(String), 0000000000000003(String), 2019-04-24 10:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,605 [main] <==    Updates: 1
2019-04-22 10:43:08,614 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,615 [main] ==> Parameters: 33097601(String), 3128773(String), 0000000000000003(String), 2019-04-24 13:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,637 [main] <==    Updates: 1
2019-04-22 10:43:08,646 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,647 [main] ==> Parameters: 33097601(String), 3128774(String), 0000000000000003(String), 2019-04-24 16:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,670 [main] <==    Updates: 1
2019-04-22 10:43:08,683 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,684 [main] ==> Parameters: 33097601(String), 3128775(String), 0000000000000003(String), 2019-04-25 10:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,715 [main] <==    Updates: 1
2019-04-22 10:43:08,725 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,725 [main] ==> Parameters: 33097601(String), 3128776(String), 0000000000000003(String), 2019-04-25 13:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,756 [main] <==    Updates: 1
2019-04-22 10:43:08,765 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,766 [main] ==> Parameters: 33097601(String), 3128777(String), 0000000000000003(String), 2019-04-25 16:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,789 [main] <==    Updates: 1
2019-04-22 10:43:08,797 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,798 [main] ==> Parameters: 33097601(String), 3128778(String), 0000000000000003(String), 2019-04-27 10:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,818 [main] <==    Updates: 1
2019-04-22 10:43:08,829 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,830 [main] ==> Parameters: 33097601(String), 3128779(String), 0000000000000004(String), 2019-04-27 12:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,854 [main] <==    Updates: 1
2019-04-22 10:43:08,863 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,864 [main] ==> Parameters: 33097601(String), 3128780(String), 0000000000000003(String), 2019-04-27 13:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,887 [main] <==    Updates: 1
2019-04-22 10:43:08,899 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,899 [main] ==> Parameters: 33097601(String), 3128781(String), 0000000000000004(String), 2019-04-27 15:10:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,920 [main] <==    Updates: 1
2019-04-22 10:43:08,928 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,928 [main] ==> Parameters: 33097601(String), 3128782(String), 0000000000000003(String), 2019-04-27 16:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,949 [main] <==    Updates: 1
2019-04-22 10:43:08,957 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,958 [main] ==> Parameters: 33097601(String), 3128783(String), 0000000000000004(String), 2019-04-27 18:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:08,978 [main] <==    Updates: 1
2019-04-22 10:43:08,986 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:08,987 [main] ==> Parameters: 33097601(String), 3128784(String), 0000000000000004(String), 2019-04-27 21:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,009 [main] <==    Updates: 1
2019-04-22 10:43:09,028 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,029 [main] ==> Parameters: 33097601(String), 3128785(String), 0000000000000003(String), 2019-04-28 10:20:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,062 [main] <==    Updates: 1
2019-04-22 10:43:09,070 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,070 [main] ==> Parameters: 33097601(String), 3128786(String), 0000000000000003(String), 2019-04-28 13:30:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,093 [main] <==    Updates: 1
2019-04-22 10:43:09,103 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,103 [main] ==> Parameters: 33097601(String), 3128787(String), 0000000000000003(String), 2019-04-28 16:40:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,132 [main] <==    Updates: 1
2019-04-22 10:43:09,141 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,141 [main] ==> Parameters: 33097601(String), 3131981(String), 0000000000000005(String), 2019-04-24 19:00:00.0(Timestamp), 2490(String), 复仇者联盟4：终局之战（数字3D）(3D)(String), 181(Integer), or(String), null, 50.0(Double), 20.0(Double), 46.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,168 [main] <==    Updates: 1
2019-04-22 10:43:09,176 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,177 [main] ==> Parameters: 33097601(String), 3142603(String), 0000000000000008(String), 2019-04-22 11:50:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 98(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,198 [main] <==    Updates: 1
2019-04-22 10:43:09,207 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,208 [main] ==> Parameters: 33097601(String), 3142604(String), 0000000000000001(String), 2019-04-22 12:10:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,232 [main] <==    Updates: 1
2019-04-22 10:43:09,241 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,242 [main] ==> Parameters: 33097601(String), 3142605(String), 0000000000000003(String), 2019-04-22 12:20:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 50.0(Double), 20.0(Double), 28.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,264 [main] <==    Updates: 1
2019-04-22 10:43:09,272 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,273 [main] ==> Parameters: 33097601(String), 3142606(String), 0000000000000004(String), 2019-04-22 12:30:00.0(Timestamp), 2494(String), 神奇乐园历险记（数字）(2D)(String), 86(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,293 [main] <==    Updates: 1
2019-04-22 10:43:09,300 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,301 [main] ==> Parameters: 33097601(String), 3142607(String), 0000000000000007(String), 2019-04-22 13:00:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 91(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,321 [main] <==    Updates: 1
2019-04-22 10:43:09,329 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,329 [main] ==> Parameters: 33097601(String), 3142608(String), 0000000000000008(String), 2019-04-22 13:40:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 98(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,352 [main] <==    Updates: 1
2019-04-22 10:43:09,360 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,360 [main] ==> Parameters: 33097601(String), 3142609(String), 0000000000000003(String), 2019-04-22 14:00:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 50.0(Double), 20.0(Double), 28.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,382 [main] <==    Updates: 1
2019-04-22 10:43:09,393 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,393 [main] ==> Parameters: 33097601(String), 3142610(String), 0000000000000001(String), 2019-04-22 14:00:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,415 [main] <==    Updates: 1
2019-04-22 10:43:09,423 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,423 [main] ==> Parameters: 33097601(String), 3142611(String), 0000000000000004(String), 2019-04-22 14:10:00.0(Timestamp), 2465(String), 境·界（数字）(2D)(String), 108(Integer), or(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,448 [main] <==    Updates: 1
2019-04-22 10:43:09,455 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,456 [main] ==> Parameters: 33097601(String), 3142612(String), 0000000000000007(String), 2019-04-22 14:40:00.0(Timestamp), 2457(String), 雷霆沙赞！（数字3D）(3D)(String), 132(Integer), or(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 3d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,478 [main] <==    Updates: 1
2019-04-22 10:43:09,486 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,486 [main] ==> Parameters: 33097601(String), 3142613(String), 0000000000000008(String), 2019-04-22 15:30:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 98(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,508 [main] <==    Updates: 1
2019-04-22 10:43:09,516 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,517 [main] ==> Parameters: 33097601(String), 3142614(String), 0000000000000003(String), 2019-04-22 15:40:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 50.0(Double), 20.0(Double), 28.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,541 [main] <==    Updates: 1
2019-04-22 10:43:09,549 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,549 [main] ==> Parameters: 33097601(String), 3142615(String), 0000000000000001(String), 2019-04-22 15:50:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,585 [main] <==    Updates: 1
2019-04-22 10:43:09,593 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,594 [main] ==> Parameters: 33097601(String), 3142616(String), 0000000000000004(String), 2019-04-22 16:10:00.0(Timestamp), 2465(String), 境·界（数字）(2D)(String), 108(Integer), or(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,616 [main] <==    Updates: 1
2019-04-22 10:43:09,624 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,625 [main] ==> Parameters: 33097601(String), 3142617(String), 0000000000000007(String), 2019-04-22 17:00:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 91(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,644 [main] <==    Updates: 1
2019-04-22 10:43:09,652 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,653 [main] ==> Parameters: 33097601(String), 3142618(String), 0000000000000003(String), 2019-04-22 17:20:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 50.0(Double), 20.0(Double), 28.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,672 [main] <==    Updates: 1
2019-04-22 10:43:09,680 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,681 [main] ==> Parameters: 33097601(String), 3142619(String), 0000000000000008(String), 2019-04-22 17:20:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 98(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,702 [main] <==    Updates: 1
2019-04-22 10:43:09,710 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,711 [main] ==> Parameters: 33097601(String), 3142620(String), 0000000000000001(String), 2019-04-22 17:40:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,730 [main] <==    Updates: 1
2019-04-22 10:43:09,738 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,738 [main] ==> Parameters: 33097601(String), 3142621(String), 0000000000000004(String), 2019-04-22 18:15:00.0(Timestamp), 2494(String), 神奇乐园历险记（数字）(2D)(String), 86(Integer), cn(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,759 [main] <==    Updates: 1
2019-04-22 10:43:09,769 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,770 [main] ==> Parameters: 33097601(String), 3142622(String), 0000000000000007(String), 2019-04-22 18:40:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 91(Integer), cn(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,796 [main] <==    Updates: 1
2019-04-22 10:43:09,804 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,805 [main] ==> Parameters: 33097601(String), 3142623(String), 0000000000000003(String), 2019-04-22 19:00:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 50.0(Double), 20.0(Double), 30.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,825 [main] <==    Updates: 1
2019-04-22 10:43:09,834 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,835 [main] ==> Parameters: 33097601(String), 3142624(String), 0000000000000008(String), 2019-04-22 19:10:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 98(Integer), cn(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,857 [main] <==    Updates: 1
2019-04-22 10:43:09,868 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,870 [main] ==> Parameters: 33097601(String), 3142625(String), 0000000000000005(String), 2019-04-22 19:20:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 91(Integer), cn(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,891 [main] <==    Updates: 1
2019-04-22 10:43:09,899 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,899 [main] ==> Parameters: 33097601(String), 3142626(String), 0000000000000001(String), 2019-04-22 19:30:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,918 [main] <==    Updates: 1
2019-04-22 10:43:09,928 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,929 [main] ==> Parameters: 33097601(String), 3142627(String), 0000000000000004(String), 2019-04-22 20:00:00.0(Timestamp), 2465(String), 境·界（数字）(2D)(String), 108(Integer), or(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,954 [main] <==    Updates: 1
2019-04-22 10:43:09,962 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:09,963 [main] ==> Parameters: 33097601(String), 3142628(String), 0000000000000007(String), 2019-04-22 20:20:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:09,990 [main] <==    Updates: 1
2019-04-22 10:43:09,999 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:10,000 [main] ==> Parameters: 33097601(String), 3142629(String), 0000000000000003(String), 2019-04-22 20:40:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 50.0(Double), 20.0(Double), 30.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:10,022 [main] <==    Updates: 1
2019-04-22 10:43:10,030 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:10,031 [main] ==> Parameters: 33097601(String), 3142630(String), 0000000000000005(String), 2019-04-22 21:00:00.0(Timestamp), 2484(String), 狗眼看人心(2D)(String), 91(Integer), cn(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:10,055 [main] <==    Updates: 1
2019-04-22 10:43:10,064 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:10,065 [main] ==> Parameters: 33097601(String), 3142631(String), 0000000000000008(String), 2019-04-22 21:00:00.0(Timestamp), 2448(String), 反贪风暴4(2D)(String), 98(Integer), cn(String), null, 50.0(Double), 20.0(Double), 35.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:10,086 [main] <==    Updates: 1
2019-04-22 10:43:10,094 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:10,094 [main] ==> Parameters: 33097601(String), 3142632(String), 0000000000000001(String), 2019-04-22 21:20:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:10,120 [main] <==    Updates: 1
2019-04-22 10:43:10,129 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:10,130 [main] ==> Parameters: 33097601(String), 3142633(String), 0000000000000004(String), 2019-04-22 22:00:00.0(Timestamp), 2465(String), 境·界（数字）(2D)(String), 108(Integer), or(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:10,150 [main] <==    Updates: 1
2019-04-22 10:43:10,160 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:10,161 [main] ==> Parameters: 33097601(String), 3142634(String), 0000000000000007(String), 2019-04-22 22:10:00.0(Timestamp), 2485(String), 如影随心(2D)(String), 96(Integer), cn(String), null, 50.0(Double), 20.0(Double), 32.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:10,184 [main] <==    Updates: 1
2019-04-22 10:43:10,192 [main] ==>  Preparing: insert into sessioninfo(CCode, SCode, ScreenCode, StartTime, FilmCode, FilmName, Duration, Language, UpdateTime, StandardPrice, LowestPrice, SettlePrice, AddFee, CinemaAllowance, TicketFee, IsAvalible, PlaythroughFlag, Dimensional, Sequence, UserID, ListingPrice, FeatureNo, SessionId, SessionKey, InternalUpdateTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:43:10,193 [main] ==> Parameters: 33097601(String), 3142635(String), 0000000000000003(String), 2019-04-22 22:20:00.0(Timestamp), 2481(String), 转型团伙(2D)(String), 90(Integer), cn(String), null, 50.0(Double), 20.0(Double), 28.0(Double), 10.0(Double), 0.0(Double), 0.0(Double), 1(Integer), 0(String), 2d(String), 1(Integer), 12(Long), null, null, null, null, null
2019-04-22 10:43:10,216 [main] <==    Updates: 1
2019-04-22 10:43:28,765 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 10:43:28,904 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 10:43:28,933 [main] <==      Total: 1
2019-04-22 10:43:28,942 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 10:43:28,943 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 10:43:29,005 [main] <==      Total: 1
2019-04-22 10:43:29,016 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 10:43:29,019 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 10:43:29,066 [main] <==      Total: 1
2019-04-22 10:43:29,074 [main] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.scode = ? and t.userID = ? 
2019-04-22 10:43:29,076 [main] ==> Parameters: 33097601(String), 3095299(String), 12(Long)
2019-04-22 10:43:31,449 [main] <==      Total: 0
2019-04-22 10:59:05,730 [main] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-04-22 10:59:05,869 [main] ==> Parameters: 33097601(String)
2019-04-22 10:59:05,903 [main] <==      Total: 1
2019-04-22 10:59:05,934 [main] ==>  Preparing: update cinema t SET Id = ?, MId = ?, Code = ?, Name = ?, Address = ?, ScreenCount = ?, IsDel = ?, ManualAdd = ?, IsOpen = ?, CinemaId = ? where t.Code = ? 
2019-04-22 10:59:05,938 [main] ==> Parameters: 7408(Long), 60(Integer), 33097601(String), 浙江金华荣耀激光影城(String), 金华(String), 9(Integer), 0(Integer), 1(Integer), 1(Integer), 194(String), 33097601(String)
2019-04-22 10:59:05,961 [main] <==    Updates: 1
2019-04-22 10:59:06,123 [main] ==>  Preparing: select * from cinema t where t.Code= ? 
2019-04-22 10:59:06,124 [main] ==> Parameters: 33097601(String)
2019-04-22 10:59:06,137 [main] <==      Total: 1
2019-04-22 10:59:06,145 [main] ==>  Preparing: update cinema t SET Id = ?, MId = ?, Code = ?, Name = ?, Address = ?, ScreenCount = ?, IsDel = ?, ManualAdd = ?, IsOpen = ?, CinemaId = ? where t.Code = ? 
2019-04-22 10:59:06,145 [main] ==> Parameters: 7408(Long), 60(Integer), 33097601(String), 浙江金华荣耀激光影城(String), 金华(String), 9(Integer), 0(Integer), 1(Integer), 1(Integer), 194(String), 33097601(String)
2019-04-22 10:59:06,169 [main] <==    Updates: 1
2019-04-22 10:59:06,184 [main] ==>  Preparing: delete from screeninfo where ccode = ? 
2019-04-22 10:59:06,185 [main] ==> Parameters: 33097601(String)
2019-04-22 10:59:06,223 [main] <==    Updates: 9
2019-04-22 10:59:06,232 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,259 [main] ==> Parameters: 33097601(String), 0000000000000001(String), 4.20周年庆1号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1044(String)
2019-04-22 10:59:06,286 [main] <==    Updates: 1
2019-04-22 10:59:06,294 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,295 [main] ==> Parameters: 33097601(String), 0000000000000002(String), 4.20周年庆2号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1045(String)
2019-04-22 10:59:06,319 [main] <==    Updates: 1
2019-04-22 10:59:06,327 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,327 [main] ==> Parameters: 33097601(String), 0000000000000003(String), 4.20周年庆3号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1046(String)
2019-04-22 10:59:06,362 [main] <==    Updates: 1
2019-04-22 10:59:06,373 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,374 [main] ==> Parameters: 33097601(String), 0000000000000004(String), 4.20周年庆4号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1047(String)
2019-04-22 10:59:06,411 [main] <==    Updates: 1
2019-04-22 10:59:06,425 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,426 [main] ==> Parameters: 33097601(String), 0000000000000005(String), 4.20周年庆5号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1048(String)
2019-04-22 10:59:06,451 [main] <==    Updates: 1
2019-04-22 10:59:06,459 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,459 [main] ==> Parameters: 33097601(String), 0000000000000006(String), 4.20周年庆6号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1049(String)
2019-04-22 10:59:06,490 [main] <==    Updates: 1
2019-04-22 10:59:06,499 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,500 [main] ==> Parameters: 33097601(String), 0000000000000007(String), 4.20周年庆7号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1050(String)
2019-04-22 10:59:06,527 [main] <==    Updates: 1
2019-04-22 10:59:06,538 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,539 [main] ==> Parameters: 33097601(String), 0000000000000008(String), 4.20周年庆8号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1051(String)
2019-04-22 10:59:06,563 [main] <==    Updates: 1
2019-04-22 10:59:06,575 [main] ==>  Preparing: insert into screeninfo(CCode, SCode, SName, UpdateTime, SeatCount, Type, ScreenId) values(?, ?, ?, ?, ?, ?, ?) 
2019-04-22 10:59:06,576 [main] ==> Parameters: 33097601(String), 0000000000000009(String), 9号厅(String), 2019-04-22 10:59:06.17(Timestamp), null, 3d(String), 1078(String)
2019-04-22 10:59:06,605 [main] <==    Updates: 1
2019-04-22 11:01:38,773 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:01:38,919 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:01:38,959 [main] <==      Total: 1
2019-04-22 11:01:38,977 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:01:38,979 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:01:38,998 [main] <==      Total: 1
2019-04-22 11:01:39,009 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:01:39,012 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:01:39,028 [main] <==      Total: 1
2019-04-22 11:01:39,038 [main] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.scode = ? and t.userID = ? 
2019-04-22 11:01:39,043 [main] ==> Parameters: 33097601(String), 3093945(String), 12(Long)
2019-04-22 11:01:41,304 [main] <==      Total: 1
2019-04-22 11:14:56,893 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:14:57,022 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:14:57,067 [main] <==      Total: 1
2019-04-22 11:14:57,080 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:14:57,083 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:14:57,114 [main] <==      Total: 1
2019-04-22 11:14:57,123 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:14:57,124 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:14:57,140 [main] <==      Total: 1
2019-04-22 11:14:57,149 [main] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.scode = ? and t.userID = ? 
2019-04-22 11:14:57,150 [main] ==> Parameters: 33097601(String), 3093945(String), 75(Long)
2019-04-22 11:14:59,390 [main] <==      Total: 0
2019-04-22 11:15:51,712 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:15:51,887 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:15:51,918 [main] <==      Total: 1
2019-04-22 11:15:51,936 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:15:51,939 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:15:51,960 [main] <==      Total: 1
2019-04-22 11:15:53,136 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:15:53,138 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:15:53,151 [main] <==      Total: 1
2019-04-22 11:15:53,180 [main] ==>  Preparing: update membercard t SET Id = ?, CinemaCode = ?, CardNo = ?, CardPassword = ?, MobilePhone = ?, LevelCode = ?, LevelName = ?, Balance = ?, UserName = ?, ExpireDate = ?, Status = ? where t.id = ? 
2019-04-22 11:15:53,185 [main] ==> Parameters: 1509(Long), 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), 120.0(Double), 刘钰栋(String), 2019-05-22 00:00:00.0(Timestamp), 0(Integer), 1509(Long)
2019-04-22 11:15:53,213 [main] <==    Updates: 1
2019-04-22 11:15:53,223 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:15:53,223 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:15:53,237 [main] <==      Total: 1
2019-04-22 11:20:14,210 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:20:14,347 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:20:14,388 [main] <==      Total: 1
2019-04-22 11:20:14,430 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:20:14,431 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:20:14,448 [main] <==      Total: 1
2019-04-22 11:20:14,460 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:20:14,463 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:20:14,483 [main] <==      Total: 1
2019-04-22 11:20:14,510 [main] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.scode = ? and t.userID = ? 
2019-04-22 11:20:14,512 [main] ==> Parameters: 33097601(String), 3093945(String), 75(Long)
2019-04-22 11:20:16,783 [main] <==      Total: 0
2019-04-22 11:22:20,799 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:22:20,938 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:22:20,982 [main] <==      Total: 1
2019-04-22 11:22:20,993 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:22:20,995 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:22:21,021 [main] <==      Total: 1
2019-04-22 11:22:21,033 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:22:21,035 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:22:21,071 [main] <==      Total: 1
2019-04-22 11:22:21,084 [main] ==>  Preparing: select * from sessioninfo t where t.ccode = ? and t.scode = ? and t.userID = ? 
2019-04-22 11:22:21,087 [main] ==> Parameters: 33097601(String), 3093945(String), 12(Long)
2019-04-22 11:22:23,386 [main] <==      Total: 1
2019-04-22 11:23:20,273 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:23:20,419 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:23:20,452 [main] <==      Total: 1
2019-04-22 11:23:20,461 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:23:20,463 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:23:20,532 [main] <==      Total: 1
2019-04-22 11:23:24,628 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:23:24,630 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:23:24,648 [main] <==      Total: 1
2019-04-22 11:23:24,701 [main] ==>  Preparing: update membercard t SET Id = ?, CinemaCode = ?, CardNo = ?, CardPassword = ?, MobilePhone = ?, LevelCode = ?, LevelName = ?, Balance = ?, UserName = ?, ExpireDate = ?, Status = ? where t.id = ? 
2019-04-22 11:23:24,705 [main] ==> Parameters: 1509(Long), 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), 90.0(Double), 刘钰栋(String), 2019-05-22 00:00:00.0(Timestamp), 0(Integer), 1509(Long)
2019-04-22 11:23:24,737 [main] <==    Updates: 1
2019-04-22 11:23:24,760 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:23:24,761 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:23:24,778 [main] <==      Total: 1
2019-04-22 11:30:29,985 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:30:30,116 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:30:30,141 [main] <==      Total: 1
2019-04-22 11:30:30,153 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:30:30,155 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:30:30,167 [main] <==      Total: 1
2019-04-22 11:30:30,174 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:30:30,175 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:30:30,190 [main] <==      Total: 1
2019-04-22 11:32:50,895 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:32:51,040 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:32:51,063 [main] <==      Total: 1
2019-04-22 11:32:51,072 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:32:51,073 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:32:51,085 [main] <==      Total: 1
2019-04-22 11:32:51,093 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:32:51,095 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:32:51,112 [main] <==      Total: 1
2019-04-22 11:33:27,584 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:33:27,708 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:33:27,733 [main] <==      Total: 1
2019-04-22 11:33:27,743 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:33:27,745 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:33:27,758 [main] <==      Total: 1
2019-04-22 11:33:27,767 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:33:27,768 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:33:27,780 [main] <==      Total: 1
2019-04-22 11:33:55,361 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:33:55,532 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:33:55,566 [main] <==      Total: 1
2019-04-22 11:33:55,577 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:33:55,579 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:33:55,594 [main] <==      Total: 1
2019-04-22 11:33:55,602 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:33:55,604 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:33:55,619 [main] <==      Total: 1
2019-04-22 11:34:23,961 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:34:24,126 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:34:24,152 [main] <==      Total: 1
2019-04-22 11:34:24,164 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:34:24,166 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:34:24,178 [main] <==      Total: 1
2019-04-22 11:34:25,305 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:34:25,308 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:34:25,322 [main] <==      Total: 1
2019-04-22 11:34:25,356 [main] ==>  Preparing: update membercard t SET Id = ?, CinemaCode = ?, CardNo = ?, CardPassword = ?, MobilePhone = ?, LevelCode = ?, LevelName = ?, Balance = ?, UserName = ?, ExpireDate = ?, Status = ? where t.id = ? 
2019-04-22 11:34:25,364 [main] ==> Parameters: 1509(Long), 33097601(String), e042282308(String), mima123(String), 15268553143(String), 4(String), 月卡(String), 190.0(Double), 刘钰栋(String), 2019-05-22 00:00:00.0(Timestamp), 0(Integer), 1509(Long)
2019-04-22 11:34:25,390 [main] <==    Updates: 1
2019-04-22 11:34:25,400 [main] ==>  Preparing: select * from membercard t where t.cinemacode = ? and t.cardno=? 
2019-04-22 11:34:25,401 [main] ==> Parameters: 33097601(String), e042282308(String)
2019-04-22 11:34:25,413 [main] <==      Total: 1
2019-04-22 11:37:02,264 [main] ==>  Preparing: select * from userinfo t where t.username = ? and t.password = ? 
2019-04-22 11:37:02,439 [main] ==> Parameters: MiniProgram(String), 6BF477EBCC446F54E6512AFC0E976C41(String)
2019-04-22 11:37:02,468 [main] <==      Total: 1
2019-04-22 11:37:02,480 [main] ==>  Preparing: select * from usercinemaview t where t.userid = ? and t.cinemacode=? 
2019-04-22 11:37:02,483 [main] ==> Parameters: 12(Long), 33097601(String)
2019-04-22 11:37:02,494 [main] <==      Total: 1
2019-04-22 11:37:03,713 [main] ==>  Preparing: delete from membercardlevel where cinemacode = ? 
2019-04-22 11:37:03,715 [main] ==> Parameters: 33097601(String)
2019-04-22 11:37:03,773 [main] <==    Updates: 2
2019-04-22 11:37:03,784 [main] ==>  Preparing: insert into membercardlevel(CinemaCode, LevelCode, LevelName) values(?, ?, ?) 
2019-04-22 11:37:03,855 [main] ==> Parameters: 33097601(String), 4(String), 月卡(String)
2019-04-22 11:37:03,882 [main] <==    Updates: 1
2019-04-22 11:37:03,892 [main] ==>  Preparing: insert into membercardlevel(CinemaCode, LevelCode, LevelName) values(?, ?, ?) 
2019-04-22 11:37:03,893 [main] ==> Parameters: 33097601(String), 2(String), 储值卡(String)
2019-04-22 11:37:03,936 [main] <==    Updates: 1
2019-04-22 11:37:03,952 [main] ==>  Preparing: select * from membercardlevel t where t.cinemacode = ? 
2019-04-22 11:37:03,955 [main] ==> Parameters: 33097601(String)
2019-04-22 11:37:03,968 [main] <==      Total: 2
2019-04-22 12:09:43,347 [http-nio-8080-exec-8] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-04-22 12:09:43,354 [http-nio-8080-exec-8] ==> Parameters: admin(String)
2019-04-22 12:09:43,382 [http-nio-8080-exec-8] <==      Total: 1
2019-04-22 12:09:43,398 [http-nio-8080-exec-8] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-04-22 12:09:43,402 [http-nio-8080-exec-8] ==> Parameters: 1(Long)
2019-04-22 12:09:43,423 [http-nio-8080-exec-8] <==      Total: 55
2019-04-22 12:09:43,545 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 12:09:43,553 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-04-22 12:09:43,579 [taskExecutor-1] <==    Updates: 1
2019-04-22 12:09:43,992 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 12:09:43,995 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-04-22 12:09:44,004 [http-nio-8080-exec-2] <==      Total: 1
2019-04-22 13:46:28,872 [http-nio-8080-exec-7] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 13:46:28,883 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-04-22 13:46:28,903 [http-nio-8080-exec-7] <==      Total: 1
2019-04-22 13:46:35,854 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from sys_role ss, (select id from sys_role WHERE id = ? ) s where ss.createUserId = s.id or ss.id = s.id 
2019-04-22 13:46:35,856 [http-nio-8080-exec-2] ==> Parameters: 1(String)
2019-04-22 13:46:35,883 [http-nio-8080-exec-2] <==      Total: 1
2019-04-22 13:46:35,892 [http-nio-8080-exec-2] ==>  Preparing: select ss.* from sys_role ss, (select id from sys_role WHERE id = ? ) s where (ss.createUserId = s.id or ss.id = s.id) order by ss.id asc limit ?, ? 
2019-04-22 13:46:35,895 [http-nio-8080-exec-2] ==> Parameters: 1(String), 0(Integer), 10(Integer)
2019-04-22 13:46:35,909 [http-nio-8080-exec-2] <==      Total: 6
2019-04-22 14:02:41,715 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:02:41,718 [taskExecutor-1] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-04-22 14:02:41,747 [taskExecutor-1] <==    Updates: 1
2019-04-22 14:03:58,382 [http-nio-8080-exec-1] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-04-22 14:03:58,398 [http-nio-8080-exec-1] ==> Parameters: admin(String)
2019-04-22 14:03:58,484 [http-nio-8080-exec-1] <==      Total: 1
2019-04-22 14:03:58,524 [http-nio-8080-exec-1] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-04-22 14:03:58,528 [http-nio-8080-exec-1] ==> Parameters: 1(Long)
2019-04-22 14:03:58,582 [http-nio-8080-exec-1] <==      Total: 55
2019-04-22 14:03:59,375 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:03:59,382 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-04-22 14:03:59,474 [taskExecutor-1] <==    Updates: 1
2019-04-22 14:04:00,151 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 14:04:00,153 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-04-22 14:04:00,185 [http-nio-8080-exec-2] <==      Total: 1
2019-04-22 14:04:26,021 [taskExecutor-2] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:04:26,021 [taskExecutor-2] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-04-22 14:04:26,075 [taskExecutor-2] <==    Updates: 1
2019-04-22 14:05:10,370 [http-nio-8080-exec-4] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-04-22 14:05:10,377 [http-nio-8080-exec-4] ==> Parameters: admin(String)
2019-04-22 14:05:10,404 [http-nio-8080-exec-4] <==      Total: 1
2019-04-22 14:05:10,429 [http-nio-8080-exec-4] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-04-22 14:05:10,433 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-04-22 14:05:10,454 [http-nio-8080-exec-4] <==      Total: 55
2019-04-22 14:05:11,074 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:05:11,080 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-04-22 14:05:11,122 [taskExecutor-1] <==    Updates: 1
2019-04-22 14:05:11,919 [http-nio-8080-exec-5] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 14:05:11,921 [http-nio-8080-exec-5] ==> Parameters: 1(Long)
2019-04-22 14:05:11,931 [http-nio-8080-exec-5] <==      Total: 1
2019-04-22 14:07:14,231 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:07:14,443 [taskExecutor-1] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-04-22 14:07:14,480 [taskExecutor-1] <==    Updates: 1
2019-04-22 14:07:28,105 [http-nio-8080-exec-7] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-04-22 14:07:28,107 [http-nio-8080-exec-7] ==> Parameters: admin(String)
2019-04-22 14:07:28,134 [http-nio-8080-exec-7] <==      Total: 1
2019-04-22 14:07:28,148 [http-nio-8080-exec-7] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-04-22 14:07:28,151 [http-nio-8080-exec-7] ==> Parameters: 1(Long)
2019-04-22 14:07:28,172 [http-nio-8080-exec-7] <==      Total: 55
2019-04-22 14:07:28,282 [taskExecutor-2] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:07:28,283 [taskExecutor-2] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-04-22 14:07:28,331 [taskExecutor-2] <==    Updates: 1
2019-04-22 14:07:28,539 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 14:07:28,541 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-04-22 14:07:28,559 [http-nio-8080-exec-4] <==      Total: 1
2019-04-22 14:08:29,142 [http-nio-8080-exec-2] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 14:08:29,318 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-04-22 14:08:29,360 [http-nio-8080-exec-2] <==      Total: 1
2019-04-22 14:08:41,536 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:08:41,546 [taskExecutor-1] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-04-22 14:08:41,584 [taskExecutor-1] <==    Updates: 1
2019-04-22 14:08:48,865 [http-nio-8080-exec-2] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-04-22 14:08:48,867 [http-nio-8080-exec-2] ==> Parameters: admin(String)
2019-04-22 14:08:48,878 [http-nio-8080-exec-2] <==      Total: 1
2019-04-22 14:08:48,900 [http-nio-8080-exec-2] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-04-22 14:08:48,902 [http-nio-8080-exec-2] ==> Parameters: 1(Long)
2019-04-22 14:08:48,923 [http-nio-8080-exec-2] <==      Total: 55
2019-04-22 14:08:49,016 [taskExecutor-2] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:08:49,017 [taskExecutor-2] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-04-22 14:08:49,040 [taskExecutor-2] <==    Updates: 1
2019-04-22 14:08:49,654 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 14:08:49,657 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-04-22 14:08:49,667 [http-nio-8080-exec-3] <==      Total: 1
2019-04-22 14:10:51,208 [http-nio-8080-exec-4] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 14:10:51,397 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-04-22 14:10:51,428 [http-nio-8080-exec-4] <==      Total: 1
2019-04-22 14:10:55,363 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:10:55,368 [taskExecutor-1] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-04-22 14:10:55,410 [taskExecutor-1] <==    Updates: 1
2019-04-22 14:11:06,432 [http-nio-8080-exec-4] ==>  Preparing: select * from sys_user t where t.username = ? 
2019-04-22 14:11:06,432 [http-nio-8080-exec-4] ==> Parameters: admin(String)
2019-04-22 14:11:06,444 [http-nio-8080-exec-4] <==      Total: 1
2019-04-22 14:11:06,460 [http-nio-8080-exec-4] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_user ru on ru.roleId = rp.roleId where ru.id = ? order by p.sort 
2019-04-22 14:11:06,464 [http-nio-8080-exec-4] ==> Parameters: 1(Long)
2019-04-22 14:11:06,493 [http-nio-8080-exec-4] <==      Total: 55
2019-04-22 14:11:06,587 [taskExecutor-2] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:11:06,587 [taskExecutor-2] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2019-04-22 14:11:06,612 [taskExecutor-2] <==    Updates: 1
2019-04-22 14:11:06,892 [http-nio-8080-exec-3] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2019-04-22 14:11:06,894 [http-nio-8080-exec-3] ==> Parameters: 1(Long)
2019-04-22 14:11:06,904 [http-nio-8080-exec-3] <==      Total: 1
2019-04-22 14:18:35,419 [taskExecutor-3] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2019-04-22 14:18:35,420 [taskExecutor-3] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2019-04-22 14:18:35,466 [taskExecutor-3] <==    Updates: 1
