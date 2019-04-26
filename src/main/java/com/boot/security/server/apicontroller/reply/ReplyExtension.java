package com.boot.security.server.apicontroller.reply;

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
	//endregion
	
	//region QueryCinemasReply
	public static boolean RequestInfoGuard(QueryCinemasReply reply, String Username, String Password, String AppId,String CurrentPage,String PageSize) {
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
        if (CurrentPage.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CurrentPage);
            return false;
        }
        if (PageSize.isEmpty())
        {
            reply.SetNecessaryParamMissReply(PageSize);
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
	//endregion

}
