package com.boot.security.server.apicontroller.reply;

import java.util.List;

import com.boot.security.server.api.ctms.reply.Dy1905GetMemberCardByMobileReply;
import com.boot.security.server.apicontroller.reply.PrePayOrderQueryJson.PrePayOrderQueryJsonSeat;

public class ReplyExtension {
	
	//region QueryScreensReply
	public static boolean RequestInfoGuard(QueryScreensReply reply, String Username, String Password, String CinemaCode)
    {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode))
        {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        return true;
    }
	
	//region QueryFilmReply
		public static boolean RequestInfoGuard(QueryFilmReply reply, String Username, String Password, String CinemaCode, String FilmCode)
	    {
	        if (Username == null || "".equals(Username))
	        {
	            reply.SetNecessaryParamMissReply("UserName");
	            return false;
	        }
	        if (Password == null || "".equals(Password))
	        {
	            reply.SetNecessaryParamMissReply("Password");
	            return false;
	        }
	        if (CinemaCode == null || "".equals(CinemaCode))
	        {
	            reply.SetNecessaryParamMissReply("CinemaCode");
	            return false;
	        }
	        if (FilmCode == null || "".equals(FilmCode))
	        {
	            reply.SetNecessaryParamMissReply("FilmCode");
	            return false;
	        }
	        return true;
	    }
		//endregion
	
	//region QueryScreenInfoReply
	public static boolean RequestInfoGuard(QueryScreenInfoReply reply, String Username, String Password, String CinemaCode,String ScreenCode)
    {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode))
        {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if (ScreenCode == null || "".equals(ScreenCode))
        {
            reply.SetNecessaryParamMissReply("ScreenCode");
            return false;
        }
        return true;
    }

	//region QueryScreenSeatsReply
	public static boolean RequestInfoGuard(QueryScreenSeatsReply reply, String Username, String Password, String CinemaCode,String ScreenCode)
    {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode))
        {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if (ScreenCode == null || "".equals(ScreenCode))
        {
            reply.SetNecessaryParamMissReply("ScreenCode");
            return false;
        }
        return true;
    }
	
	
	//region QueryCinemasReply
	public static boolean RequestInfoGuard(QueryCinemasReply reply, String Username, String Password, String AppId) {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (AppId == null || "".equals(AppId))
        {
            reply.SetNecessaryParamMissReply("AppId");
            return false;
        }
        
        return true;
    }
	//endregion
	
	//region 查询本地订单QueryLocalOrder
	public static boolean RequestInfoGuard(QueryLocalOrderReply reply, String Username, String Password, String CinemaCode,String OrderCode)
    {
        if (Username == null || "".equals(Username)) {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password)) {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode)) {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if (OrderCode == null || "".equals(OrderCode)) {
			reply.SetNecessaryParamMissReply("OrderCode");
			return false;
		}
        return true;
    }
	//endregion
	
	//region 查询订单QueryOrder
	public static boolean RequestInfoGuard(QueryUserOrdersReply reply, String Username, String Password, String CinemaCode,
			String OpenID, String startDate, String endDate, String CurrentPage, String PageSize)
    {
        if (Username == null || "".equals(Username)) {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password)) {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode)) {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if (OpenID == null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
        if (startDate == null || "".equals(startDate)) {
			reply.SetNecessaryParamMissReply("startDate");
			return false;
		}
        if (endDate == null || "".equals(endDate)) {
			reply.SetNecessaryParamMissReply("endDate");
			return false;
		}
        if (CurrentPage == null || "".equals(CurrentPage)) {
			reply.SetNecessaryParamMissReply("CurrentPage");
			return false;
		}
        if (PageSize == null || "".equals(PageSize)) {
			reply.SetNecessaryParamMissReply("PageSize");
			return false;
		}
        return true;
    }
	
	//region QueryMemberCardByPhoneReply
	public static boolean RequestInfoGuard(QueryMemberCardByPhoneReply reply, String Username, String Password, String CinemaCode ,String MobilePhone)
    {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode))
        {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if (MobilePhone == null || "".equals(MobilePhone))
        {
            reply.SetNecessaryParamMissReply("MobilePhone");
            return false;
        }
        return true;
    }
	
	//region Dy1905GetMemberCardByMobileReply
	public static boolean RequestInfoGuard(Dy1905GetMemberCardByMobileReply reply, String Username, String Password, String CinemaCode ,String MobilePhone)
    {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode))
        {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if (MobilePhone == null || "".equals(MobilePhone))
        {
            reply.SetNecessaryParamMissReply("MobilePhone");
            return false;
        }
        return true;
    }
	
	//region用户登陆 UserLoginReply
	public static boolean RequestInfoGuard(UserLoginReply reply,String UserName,String Password,String CinemaCode,String Code,String EncryptedData,String Iv){
		if (UserName == null || "".equals(UserName)) {
			reply.SetNecessaryParamMissReply("UserName");
			return false;
		}
		if(Password == null || "".equals(Password)){
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if(CinemaCode == null || "".equals(CinemaCode)){
			reply.SetNecessaryParamMissReply("CinemaCode");
			return false;
		}
		if(Code == null || "".equals(Code)){
			reply.SetNecessaryParamMissReply("Code");
			return false;
		}
		if(EncryptedData == null || "".equals(EncryptedData)){
			reply.SetNecessaryParamMissReply("EncryptedData");
			return false;
		}
		if(Iv == null || "".equals(Iv)){
			reply.SetNecessaryParamMissReply("Iv");
			return false;
		}
		return true;
	}
	
	//region用户登陆信息查询 UserLoginReply
	public static boolean RequestInfoGuard(UserLoginReply reply,String UserName,String Password,String CinemaCode,String OpenID){
		if (UserName == null || "".equals(UserName)) {
			reply.SetNecessaryParamMissReply("UserName");
			return false;
		}
		if(Password == null || "".equals(Password)){
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if(CinemaCode == null || "".equals(CinemaCode)){
			reply.SetNecessaryParamMissReply("CinemaCode");
			return false;
		}
		if(OpenID == null || "".equals(OpenID)){
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		
		return true;
	}
	
	//region用户手机号注册 MobilePhoneRegisterReply
	public static boolean RequestInfoGuard(MobilePhoneRegisterReply reply,String UserName,String Password,String CinemaCode,String OpenID,String MobilePhone,String VerifyCode){
		if (UserName == null || "".equals(UserName)) {
			reply.SetNecessaryParamMissReply("UserName");
			return false;
		}
		if(Password == null || "".equals(Password)){
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if(CinemaCode == null || "".equals(CinemaCode)){
			reply.SetNecessaryParamMissReply("CinemaCode");
			return false;
		}
		if(OpenID == null || "".equals(OpenID)){
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		if(MobilePhone == null || "".equals(MobilePhone)){
			reply.SetNecessaryParamMissReply("MobilePhone");
			return false;
		}
		if(VerifyCode == null || "".equals(VerifyCode)){
			reply.SetNecessaryParamMissReply("VerifyCode");
			return false;
		}
		return true;
	}
	
	//region发送验证码 SendVerifyCodeReply
	public static boolean RequestInfoGuard(SendVerifyCodeReply reply,String UserName,String Password,String CinemaCode,String OpenID,String MobilePhone){
		if (UserName == null || "".equals(UserName)) {
			reply.SetNecessaryParamMissReply("UserName");
			return false;
		}
		if(Password == null || "".equals(Password)){
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if(CinemaCode == null || "".equals(CinemaCode)){
			reply.SetNecessaryParamMissReply("CinemaCode");
			return false;
		}
		if(OpenID == null || "".equals(OpenID)){
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		if(MobilePhone == null || "".equals(MobilePhone)){
			reply.SetNecessaryParamMissReply("MobilePhone");
			return false;
		}
		return true;
	}
		
	//region查询影片场次信息 QuerySessionsReply
	public static boolean RequestInfoGuard(QuerySessionsReply reply,String UserName,String Password,String CinemaCode,String StartDate,String EndDate){
		if (UserName == null || "".equals(UserName)) {
			reply.SetNecessaryParamMissReply("UserName");
			return false;
		}
		if(Password == null || "".equals(Password)){
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if(CinemaCode == null || "".equals(CinemaCode)){
			reply.SetNecessaryParamMissReply("CinemaCode");
			return false;
		}
		if(StartDate == null || "".equals(StartDate)){
			reply.SetNecessaryParamMissReply("StartDate");
			return false;
		}
		if(EndDate == null || "".equals(EndDate)){
			reply.SetNecessaryParamMissReply("EndDate");
			return false;
		}
		return true;
		
	}
	//获取订单场次信息
	public static boolean RequestInfoGuard(QueryOrderSessionReply reply, String Username, String Password, String CinemaCode,String SessionCode)
    {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode))
        {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if(SessionCode == null || "".equals(SessionCode)){
        	reply.SetNecessaryParamMissReply("SessionCode");
        	return false;
        }
        return true;
    }
	//预支付会员卡支付
	public static boolean RequestInfoPrePayCardCharge(PayParametersReply reply, String Username, String Password, String CinemaCode,String OpenID,String ChargeAmount)
    {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode))
        {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if(OpenID == null || "".equals(OpenID)){
        	reply.SetNecessaryParamMissReply("OpenID");
        	return false;
        }
        if(ChargeAmount == null || "".equals(ChargeAmount)){
        	reply.SetNecessaryParamMissReply("ChargeAmount");
        	return false;
        }
        return true;
    }
	//预支付会员卡支付
	public static boolean RequestInfoPrePayCardRegister(PayParametersReply reply, String Username, String Password, String CinemaCode,String OpenID,String InitialAmount)
    {
        if (Username == null || "".equals(Username))
        {
            reply.SetNecessaryParamMissReply("UserName");
            return false;
        }
        if (Password == null || "".equals(Password))
        {
            reply.SetNecessaryParamMissReply("Password");
            return false;
        }
        if (CinemaCode == null || "".equals(CinemaCode))
        {
            reply.SetNecessaryParamMissReply("CinemaCode");
            return false;
        }
        if(OpenID == null || "".equals(OpenID)){
        	reply.SetNecessaryParamMissReply("OpenID");
        	return false;
        }
        if(InitialAmount == null || "".equals(InitialAmount)){
        	reply.SetNecessaryParamMissReply("InitialAmount");
        	return false;
        }
        return true;
    }	
	//region获取影片评论信息 QueryFilmCommentsReply
	public static boolean RequestInfoGuard(QueryFilmCommentsReply reply, String Username, String Password,String CinemaCode, String FilmCode) {
		if (Username==null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("UserName");
			return false;
		}
		if (Password==null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (CinemaCode==null || "".equals(CinemaCode)) {
			reply.SetNecessaryParamMissReply("CinemaCode");
			return false;
		}
		if (FilmCode==null || "".equals(FilmCode)) {
			reply.SetNecessaryParamMissReply("FilmCode");
			return false;
		}
		return true;
	}
	//region   提交影片评论       SubmitFilmCommentReply
	public static boolean RequestInfoGuard(SubmitFilmCommentReply reply,String Username, String Password, String FilmCode,String FilmName,Double Score,String CommentContent,String OpenID){
		if (Username==null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("UserName");
			return false;
		}
		if (Password==null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (FilmCode==null || "".equals(FilmCode)) {
			reply.SetNecessaryParamMissReply("FilmCode");
			return false;
		}
		if (OpenID==null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		if (Score==null || "".equals(Score)) {
			reply.SetNecessaryParamMissReply("Score");
			return false;
		}
		if (CommentContent==null || "".equals(CommentContent)) {
			reply.SetNecessaryParamMissReply("CommentContent");
			return false;
		}
		if (FilmName==null || "".equals(FilmName)) {
			reply.SetNecessaryParamMissReply("FilmName");
			return false;
		}
		return true;
	}
	//region   获取用户优惠券(分页)       SubmitFilmCommentReply 
		public static boolean RequestInfoGuard(QueryUserConponsPagedReply reply,String Username,String Password,String CinemaCode,String OpenID,String Status){
			if (Username==null || "".equals(Username)) {
				reply.SetNecessaryParamMissReply("UserName");
				return false;
			}
			if (Password==null || "".equals(Password)) {
				reply.SetNecessaryParamMissReply("Password");
				return false;
			}
			if (CinemaCode==null || "".equals(CinemaCode)) {
				reply.SetNecessaryParamMissReply("CinemaCode");
				return false;
			}
			if (OpenID==null || "".equals(OpenID)) {
				reply.SetNecessaryParamMissReply("OpenID");
				return false;
			}
			if (Status==null || "".equals(Status)) {
				reply.SetNecessaryParamMissReply("Status");
				return false;
			}
			return true;
		}
		
		public static boolean RequestInfoGuard(PrePayParametersReply reply, String Username, String Password,
				String CinemaCode, String OrderCode, List<PrePayOrderQueryJsonSeat> Seats) {
			if (Username==null||"".equals(Username)) {
				reply.SetNecessaryParamMissReply("Username");
				return false;
			}
			if (Password==null||"".equals(Password)) {
				reply.SetNecessaryParamMissReply("Password");
				return false;
			}
			if (CinemaCode==null||"".equals(CinemaCode)) {
				reply.SetNecessaryParamMissReply("CinemaCode");
				return false;
			}
			if (OrderCode==null||"".equals(OrderCode)) {
				reply.SetNecessaryParamMissReply("OrderCode");
				return false;
			}
			if (Seats.size() <= 0) {
				reply.SetNecessaryParamMissReply("Seats");
				return false;
			}
			return true;
		}
}
