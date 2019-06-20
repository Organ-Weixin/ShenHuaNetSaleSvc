package com.boot.security.server.apicontroller.reply;

import java.util.List;

import com.boot.security.server.api.ctms.reply.Dy1905GetMemberCardByMobileReply;
import com.boot.security.server.apicontroller.reply.PrePayGoodsOrderQueryJson.PrePayGoodsOrderQueryJsonGoods;
import com.boot.security.server.apicontroller.reply.PrePayMixOrderQueryJson.PrePayMixOrderQueryJsonGoods;
import com.boot.security.server.apicontroller.reply.PrePayMixOrderQueryJson.PrePayMixOrderQueryJsonSeat;
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
	//endregion
	
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
	//endregion
	
	//region QueryScreenRoom 放映厅
	public static boolean RequestInfoGuard(QueryScreenRoomReply reply, String Username, String Password, String CinemaCode){
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
        
        return true;
    }
	//endregion
	
	//region QueryRoomGiftReply 放映厅礼物
	public static boolean RequestInfoGuard(QueryRoomGiftReply reply, String Username, String Password, String CinemaCode){
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
        
        return true;
    }
	//endregion
	
	//region SendGiftReply 放映厅礼物发放
	public static boolean RequestInfoGuard(SendGiftReply reply, String Username, String Password, String CinemaCode, 
			String RoomCode, String GiftCode, String GiftType, int SendNumber, String OpenID){
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
        if (RoomCode == null || "".equals(RoomCode)) {
            reply.SetNecessaryParamMissReply("RoomCode");
            return false;
        }
        if (GiftCode == null || "".equals(GiftCode)) {
            reply.SetNecessaryParamMissReply("GiftCode");
            return false;
        }
        if (GiftType == null || "".equals(GiftType)) {
            reply.SetNecessaryParamMissReply("GiftType");
            return false;
        }
        if (SendNumber <= 0) {
            reply.SetNecessaryParamMissReply("SendNumber");
            return false;
        }
        if (OpenID == null || "".equals(OpenID)) {
            reply.SetNecessaryParamMissReply("OpenID");
            return false;
        }
        
        return true;
    }
	//endregion
	
	//region QueryRoomGiftRecordReply 放映厅用户领取奖品记录
	public static boolean RequestInfoGuard(QueryRoomGiftRecordReply reply, String Username, String Password, String CinemaCode, 
			String RoomCode, String OpenID){
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
        if (RoomCode == null || "".equals(RoomCode)) {
            reply.SetNecessaryParamMissReply("RoomCode");
            return false;
        }
        if (OpenID == null || "".equals(OpenID)) {
            reply.SetNecessaryParamMissReply("OpenID");
            return false;
        }
        
        return true;
    }
	//endregion
	
	//region QueryRoomGiftRecordReply 放映厅用户领取奖品记录
	public static boolean RequestInfoGuard(QueryRoomGiftRecordReply reply, String Username, String Password, String CinemaCode, String OpenID){
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
        
        return true;
    }
	//endregion
	//region QueryActivitysReply 获取活动轮播图片
	public static boolean RequestInfoGuard(QueryActivitysReply reply, String Username, String Password, String CinemaCode, String GradeCode) {
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
        if (GradeCode == null || "".equals(GradeCode)) {
            reply.SetNecessaryParamMissReply("GradeCode");
            return false;
        }
        return true;
    }
	//endregion
	
	//region QueryComponentsReply 商品推荐套餐
	public static boolean RequestInfoGuard(QueryComponentsReply reply, String Username, String Password, String CinemaCode, String seatNum) {
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
        if (seatNum == null || "".equals(seatNum)) {
            reply.SetNecessaryParamMissReply("seatNum");
            return false;
        }
        return true;
    }
	//endregion
		
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
	//endregion
	
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
	//endregion
	
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
	//endregion
	
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
	//endregion
	
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
	//endregion
	
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
	//endregion
	
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
	//endregion
	
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
	//endregion
	
		
	//region 获取订单场次信息
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
	//endregion
	
	//region 预支付会员卡充值
	public static boolean RequestInfoPrePayCardCharge(PrePayParametersReply reply, String Username, String Password, String CinemaCode,String OpenID,String ChargeAmount)
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
	//endregion
	
	//region 预支付会员卡注册
	public static boolean RequestInfoPrePayCardRegister(PrePayParametersReply reply, String Username, String Password, String CinemaCode,String OpenID,String InitialAmount)
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
	//endregion
	
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
	//endregion
	
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
	//endregion
		
	//region PrePayParametersReply
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
		//endregion
		
    //region   获取所有启用优惠券  QueryUsingConpons 
	public static boolean RequestInfoGuard(QueryUsingConponsReply reply,String Username,String Password,String CinemaCode){
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
		
		return true;
	}
	//endregion
				
	//region   获取用户优惠券(不分页)       QueryUserConponsReply 
	public static boolean RequestInfoGuard(QueryUserConponsReply reply,String Username,String Password,String CinemaCode,String OpenID,String Status){
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
	//endregion
		
	//region QueryGoodsTypeReply
	public static boolean RequestInfoGuard(QueryGoodsTypeReply reply,String Username,String Password,String CinemaCode){
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
		return true;
	}
    //endregion
		
	//region QueryGoodsReply
	public static boolean RequestInfoGuard(QueryGoodsReply reply,String Username,String Password,String CinemaCode){
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
		return true;
	}
	//endregion
		
	//region QueryLocalGoodsOrderReply
	public static boolean RequestInfoGuard(QueryLocalGoodsOrderReply reply,String Username,String Password,String CinemaCode,String LocalOrderCode){
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
		if (LocalOrderCode==null || "".equals(LocalOrderCode)) {
			reply.SetNecessaryParamMissReply("LocalOrderCode");
			return false;
		}
		return true;
	}
	//endregion
	
	//region QueryGoodsOrderReply
	public static boolean RequestInfoGuard(QueryGoodsOrderReply reply,String Username,String Password,String CinemaCode,String OrderCode){
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
		if (OrderCode==null || "".equals(OrderCode)) {
			reply.SetNecessaryParamMissReply("OrderCode");
			return false;
		}
		return true;
	}
	//endregion
	
	//region QueryTicketOrderReply
	public static boolean RequestInfoGuard(QueryTicketOrderReply reply,String Username,String Password,String CinemaCode,String OrderCode){
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
		if (OrderCode==null || "".equals(OrderCode)) {
			reply.SetNecessaryParamMissReply("OrderCode");
			return false;
		}
		return true;
	}
	//endregion
	
	//region QueryGoodsOrderReply
		public static boolean RequestInfoGuard(QueryFilmSessionsReply reply,String Username,String Password,String CinemaCode){
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
			return true;
		}
		//endregion
		
		//region QueryCardLevelReply
		public static boolean RequestInfoGuard(QueryCardLevelReply reply,String Username,String Password,String CinemaCode){
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
			return true;
		}
		
	//endregion
		
		//region  查询用户的电影票
		public static boolean RequestInfoGuard(QueryCinemaTicketReply reply,String Username,String Password,String CinemaCode,String OpenID){
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
			if(OpenID == null || "".equals(OpenID)){
				reply.SetNecessaryParamMissReply("OpenID");
				return false;
			}
			return true;
		}
		//endregion
		
		//region QueryFilmReply
		public static boolean RequestInfoGuard(QueryMemberCardByOpenIDReply reply, String Username, String Password, String CinemaCode, String OpenID)
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
	        if (OpenID == null || "".equals(OpenID))
	        {
	            reply.SetNecessaryParamMissReply("OpenID");
	            return false;
	        }
	        return true;
	    }
	//endregion
		
		//region  查询用户的小食
		public static boolean RequestInfoGuard(QueryCinemaGoodsReply reply,String Username,String Password,String CinemaCode,String OpenID){
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
			if(OpenID == null || "".equals(OpenID)){
				reply.SetNecessaryParamMissReply("OpenID");
				return false;
			}
			return true;
		}
		//endregion
		
		//region QueryMemberCardLevelReply
		public static boolean RequestInfoGuard(QueryMemberCardLevelReply reply, String Username, String Password, String CinemaCode)
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
		//endregion
		
		//region QueryMemberCardLevelReply
		public static boolean RequestInfoGuard(QueryMemberCardLevelRuleReply reply, String Username, String Password, String CinemaCode, String LevelCode)
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
	        if (LevelCode == null || "".equals(LevelCode))
	        {
	            reply.SetNecessaryParamMissReply("LevelCode");
	            return false;
	        }
	        return true;
	    }
		//endregion
		
		//region  查询用户看过的电影
		public static boolean RequestInfoGuard(QueryMovieSeenReply reply,String Username,String Password,String CinemaCode,String OpenID){
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
			if(OpenID == null || "".equals(OpenID)){
				reply.SetNecessaryParamMissReply("OpenID");
				return false;
			}
			return true;
		}
		//endregion
		
		//region QueryMemberCardLevelReply
		public static boolean RequestInfoGuard(MemberCardUnbindReply reply, String Username, String Password, String CinemaCode, String CardNo, String CardPassword)
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
	        if (CardNo == null || "".equals(CardNo))
	        {
	            reply.SetNecessaryParamMissReply("CardNo");
	            return false;
	        }
	        if (CardPassword == null || "".equals(CardPassword))
	        {
	            reply.SetNecessaryParamMissReply("CardPassword");
	            return false;
	        }
	        return true;
	    }
		//endregion
		
		//region QueryFimlSessionPriceReply
		public static boolean RequestInfoGuard(QueryFilmSessionPriceReply reply, String Username, String Password, String CinemaCode, String FilmCode)
	    {
	        if (Username == null || "".equals(Username))
	        {
	            reply.SetNecessaryParamMissReply("Username");
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
		
		//region PrePayParametersReply
		public static boolean RequestInfoGuard2(PrePayParametersReply reply, String Username, String Password,
				String CinemaCode, String OrderCode,List<PrePayGoodsOrderQueryJsonGoods> GoodsList) {
			if (Username == null || "".equals(Username)) {
				reply.SetNecessaryParamMissReply("Username");
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
			if (GoodsList.size() <= 0) {
				reply.SetNecessaryParamMissReply("GoodsList");
				return false;
			}
			return true;
		}
		//endregion
		
		//region RefundPaymentReply
		public static boolean RequestInfoGuard(RefundPaymentReply reply, String Username, String Password, String CinemaCode,String LockOrderCode)
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
	        if (LockOrderCode == null || "".equals(LockOrderCode)) {
				reply.SetNecessaryParamMissReply("LockOrderCode");
				return false;
			}
	        return true;
	    }
		//endregion
	
	//region QueryScreenSeatsArrangementReply
	public static boolean RequestInfoGuard(QueryScreenSeatsArrangementReply reply, String Username, String Password, String CinemaCode,String ScreenCode)
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
	//endregion
	
	//region 查询未支付订单
	public static boolean RequestInfoGuard(QueryNonPayOrdersReply reply, String Username, String Password, String CinemaCode,
			String OpenID)
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
        return true;
    }
	//endregion
	
	//region RefundPaymentReply
	public static boolean RequestInfoGuard2(RefundPaymentReply reply, String Username, String Password, String CinemaCode,String LocalOrderCode)
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
        if (LocalOrderCode == null || "".equals(LocalOrderCode)) {
			reply.SetNecessaryParamMissReply("LocalOrderCode");
			return false;
		}
        return true;
    }
	//endregion
    
  //region BindCouponsReply
  	public static boolean RequestInfoGuard(BindCouponsReply reply, String Username, String Password, String CinemaCode, String OpenID, String CouponsCode)
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
          if (CouponsCode == null || "".equals(CouponsCode)) {
    		reply.SetNecessaryParamMissReply("CouponsCode");
    		return false;
    	 }
          return true;
      }
  	//endregion
	
	//region PrePayParametersReply
	public static boolean RequestInfoGuard(PrePayParametersReply reply, String Username, String Password,
			String CinemaCode, String OrderCode,List<PrePayMixOrderQueryJsonSeat> Seats,List<PrePayMixOrderQueryJsonGoods> GoodsList) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
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
		if(Seats.size()<=0){
			reply.SetNecessaryParamMissReply("Seats");
			return false;
		}
		if (GoodsList.size() <= 0) {
			reply.SetNecessaryParamMissReply("GoodsList");
			return false;
		}
		return true;
	}
	//endregion
	
	//region UserWantedFilmReply
	public static boolean RequestInfoGuard(UpdateUserWantedFilmReply reply, String Username, String Password, String OpenID, String FilmCode, String Status) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
			return false;
		}
		if (Password == null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (OpenID == null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		if (FilmCode == null || "".equals(FilmCode)) {
			reply.SetNecessaryParamMissReply("FilmCode");
			return false;
		}
		if (Status == null || "".equals(Status)) {
			reply.SetNecessaryParamMissReply("Status");
			return false;
		}
		return true;
	}
	//endregion
	
	//region QueryWantedFilmReply
	public static boolean RequestInfoGuard(QueryUserFilmReply reply, String Username, String Password,String OpenID) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
			return false;
		}
		if (Password == null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (OpenID == null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		return true;
	}
	//endregion
	
	//region CheckUserFilmOrdersReply
	public static boolean RequestInfoGuard(CheckUserFilmOrdersReply reply, String Username, String Password, String OpenID, String FilmCode) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
			return false;
		}
		if (Password == null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (OpenID == null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		if (FilmCode == null || "".equals(FilmCode)) {
			reply.SetNecessaryParamMissReply("FilmCode");
			return false;
		}
		return true;
	}
	//endregion
	
	//region CheckUserFilmOrdersReply
	public static boolean RequestInfoGuard(QueryUserNumberReply reply, String Username, String Password, String OpenID, String FilmCode) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
			return false;
		}
		if (Password == null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (OpenID == null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		if (FilmCode == null || "".equals(FilmCode)) {
			reply.SetNecessaryParamMissReply("FilmCode");
			return false;
		}
		return true;
	}
	//endregion  QueryUserInfoReply
	
	//region 
	public static boolean RequestInfoGuard(QueryUserInfoReply reply, String Username, String Password, String OpenID) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
			return false;
		}
		if (Password == null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (OpenID == null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		return true;
	}
	//endregion   UpdateUserInfoReply
	
	//region 
	public static boolean RequestInfoGuard(UpdateUserInfoReply reply, String Username, String Password, String OpenID) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
			return false;
		}
		if (Password == null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (OpenID == null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		return true;
	}
	//endregion
	
	//region 
	public static boolean RequestInfoGuard(QueryUserTicketReply reply, String Username, String Password, String CinemaCode, String OpenID) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
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
		return true;
	}
	//endregion
	
	//region QueryUserLookedFilmsReply
	public static boolean RequestInfoGuard(QueryUserLookedFilmsReply reply, String Username, String Password,String OpenID) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
			return false;
		}
		if (Password == null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (OpenID == null || "".equals(OpenID)) {
			reply.SetNecessaryParamMissReply("OpenID");
			return false;
		}
		return true;
	}
	//endregion
	
	//region smsNoticeReply
	public static boolean RequestInfoGuard(SmsNoticeReply reply, String Username, String Password,String CinemaCode,String OrderCode) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
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
}
