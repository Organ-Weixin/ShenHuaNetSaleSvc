package com.boot.security.server.apicontroller.reply;

import com.boot.security.server.api.ctms.reply.Dy1905GetMemberCardByMobileReply;

public class ReplyExtension {
	
	//region QueryScreensReply
	public static boolean RequestInfoGuard(QueryScreensReply reply, String Username, String Password, String CinemaCode)
    {
        if (Username.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (CinemaCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CinemaCode);
            return false;
        }
        return true;
    }
	
	//region QueryFilmReply
		public static boolean RequestInfoGuard(QueryFilmReply reply, String Username, String Password, String CinemaCode, String FilmCode)
	    {
	        if (Username.isEmpty())
	        {
	            reply.SetNecessaryParamMissReply(Username);
	            return false;
	        }
	        if (Password.isEmpty())
	        {
	            reply.SetNecessaryParamMissReply(Password);
	            return false;
	        }
	        if (CinemaCode.isEmpty())
	        {
	            reply.SetNecessaryParamMissReply(CinemaCode);
	            return false;
	        }
	        if (FilmCode.isEmpty())
	        {
	            reply.SetNecessaryParamMissReply(FilmCode);
	            return false;
	        }
	        return true;
	    }
		//endregion
	
	//region QueryScreenInfoReply
	public static boolean RequestInfoGuard(QueryScreenInfoReply reply, String Username, String Password, String CinemaCode,String ScreenCode)
    {
        if (Username.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (CinemaCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CinemaCode);
            return false;
        }
        if (ScreenCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(ScreenCode);
            return false;
        }
        return true;
    }

	//region QueryScreenSeatsReply
	public static boolean RequestInfoGuard(QueryScreenSeatsReply reply, String Username, String Password, String CinemaCode,String ScreenCode)
    {
        if (Username.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (CinemaCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CinemaCode);
            return false;
        }
        if (ScreenCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(ScreenCode);
            return false;
        }
        return true;
    }
	
	
	//region QueryCinemasReply
	public static boolean RequestInfoGuard(QueryCinemasReply reply, String Username, String Password, String AppId) {
        if (Username.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (AppId.isEmpty())
        {
            reply.SetNecessaryParamMissReply(AppId);
            return false;
        }
        
        return true;
    }
	//endregion
	
	//region 查询订单QueryOrder
	public static boolean RequestInfoGuard(QueryLocalOrderReply reply, String Username, String Password, String CinemaCode,String OrderCode)
    {
        if (Username.isEmpty()) {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty()) {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (CinemaCode.isEmpty()) {
            reply.SetNecessaryParamMissReply(CinemaCode);
            return false;
        }
        if (OrderCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(OrderCode);
			return false;
		}
        return true;
    }
	//endregion
	
	//region 查询订单QueryOrder
	public static boolean RequestInfoGuard(QueryUserOrdersReply reply, String Username, String Password, String CinemaCode,
			String OpenID, String startDate, String endDate, String CurrentPage, String PageSize)
    {
        if (Username.isEmpty()) {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty()) {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (CinemaCode.isEmpty()) {
            reply.SetNecessaryParamMissReply(CinemaCode);
            return false;
        }
        if (OpenID.isEmpty()) {
			reply.SetNecessaryParamMissReply(OpenID);
			return false;
		}
        if (startDate.isEmpty()) {
			reply.SetNecessaryParamMissReply(startDate);
			return false;
		}
        if (endDate.isEmpty()) {
			reply.SetNecessaryParamMissReply(endDate);
			return false;
		}
        if (CurrentPage.isEmpty()) {
			reply.SetNecessaryParamMissReply(CurrentPage);
			return false;
		}
        if (PageSize.isEmpty()) {
			reply.SetNecessaryParamMissReply(PageSize);
			return false;
		}
        return true;
    }
	
	//region QueryMemberCardByPhoneReply
	public static boolean RequestInfoGuard(QueryMemberCardByPhoneReply reply, String Username, String Password, String CinemaCode ,String MobilePhone)
    {
        if (Username.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (CinemaCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CinemaCode);
            return false;
        }
        if (MobilePhone.isEmpty())
        {
            reply.SetNecessaryParamMissReply(MobilePhone);
            return false;
        }
        return true;
    }
	
	//region Dy1905GetMemberCardByMobileReply
	public static boolean RequestInfoGuard(Dy1905GetMemberCardByMobileReply reply, String Username, String Password, String CinemaCode ,String MobilePhone)
    {
        if (Username.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (CinemaCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CinemaCode);
            return false;
        }
        if (MobilePhone.isEmpty())
        {
            reply.SetNecessaryParamMissReply(MobilePhone);
            return false;
        }
        return true;
    }
	//region查询影片场次信息 QuerySessionsReply
	public static boolean RequestInfoGuard(QuerySessionsReply reply,String UserName,String Password,String CinemaCode,String StartDate,String EndDate){
		if (UserName.isEmpty()) {
			reply.SetNecessaryParamMissReply(UserName);
			return false;
		}
		if(Password.isEmpty()){
			reply.SetNecessaryParamMissReply(Password);
			return false;
		}
		if(CinemaCode.isEmpty()){
			reply.SetNecessaryParamMissReply(CinemaCode);
			return false;
		}
		if(StartDate.isEmpty()){
			reply.SetNecessaryParamMissReply(StartDate);
			return false;
		}
		if(EndDate.isEmpty()){
			reply.SetNecessaryParamMissReply(EndDate);
			return false;
		}
		return true;
		
	}
	//
	public static boolean RequestInfoGuard(QueryOrderSessionReply reply, String Username, String Password, String CinemaCode,String SessionCode)
    {
        if (Username.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Username);
            return false;
        }
        if (Password.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Password);
            return false;
        }
        if (CinemaCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CinemaCode);
            return false;
        }
        if(SessionCode.isEmpty()){
        	reply.SetNecessaryParamMissReply(SessionCode);
        	return false;
        }
        return true;
    }
}
