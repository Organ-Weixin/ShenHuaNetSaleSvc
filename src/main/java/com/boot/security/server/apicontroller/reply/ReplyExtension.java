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
	
	//region 
	//endregion

}
