package com.boot.security.server.api.core;

public class ReplyExtension { 

	// region QueryCinemaListReply
	public static boolean RequestInfoGuard(QueryCinemaListReply reply, String Username, String Password) {
		if (Username.isEmpty()) {
			reply.SetNecessaryParamMissReply(Username);
			return false;
		}
		if (Password.isEmpty()) {
			reply.SetNecessaryParamMissReply(Password);
			return false;
		}
		return true;
	}
	// endregion

	// region QueryCinemaReply
	public static boolean RequestInfoGuard(QueryCinemaReply reply, String Username, String Password,
			String CinemaCode) {
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
		return true;
	}
	// endregion

	// region QuerySeatReply
	public static boolean RequestInfoGuard(QuerySeatReply reply, String Username, String Password, String CinemaCode,
			String ScreenCode) {
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
		if (ScreenCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(ScreenCode);
			return false;
		}
		return true;
	}
	// endregion

	// region QueryFilmReply
	public static boolean RequestInfoGuard(QueryFilmReply reply, String Username, String Password, String CinemaCode,
			String StartDate, String EndDate) {
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
		if (StartDate.isEmpty()) {
			reply.SetNecessaryParamMissReply(StartDate);
			return false;
		}
		if (EndDate.isEmpty()) {
			reply.SetNecessaryParamMissReply(EndDate);
			return false;
		}

		return true;
	}
	// endregion

	// region QuerySessionReply
	public static boolean RequestInfoGuard(QuerySessionReply reply, String Username, String Password, String CinemaCode,
			String StartDate, String EndDate) {
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
		if (StartDate.isEmpty()) {
			reply.SetNecessaryParamMissReply(StartDate);
			return false;
		}
		if (EndDate.isEmpty()) {
			reply.SetNecessaryParamMissReply(EndDate);
			return false;
		}
		return true;
	}
	// endregion

	// region QuerySessionSeatReply
	public static boolean RequestInfoGuard(QuerySessionSeatReply reply, String Username, String Password,
			String CinemaCode, String SessionCode, String Status) {
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
		if (SessionCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(SessionCode);
			return false;
		}
		if (Status.isEmpty()) {
			reply.SetNecessaryParamMissReply(Status);
			return false;
		}

		return true;
	}
	// endregion

	// region LockSeatReply
	public static boolean RequestInfoGuard(LockSeatReply reply, String Username, String Password, String QueryXml) {
		if (Username.isEmpty()) {
			reply.SetNecessaryParamMissReply(Username);
			return false;
		}
		if (Password.isEmpty()) {
			reply.SetNecessaryParamMissReply(Password);
			return false;
		}
		if (QueryXml.isEmpty()) {
			reply.SetNecessaryParamMissReply(QueryXml);
			return false;
		}
		return true;
	}
	// endregion

	// region ReleaseSeatReply
	public static boolean RequestInfoGuard(ReleaseSeatReply reply, String Username, String Password, String QueryXml) {
		if (Username.isEmpty()) {
			reply.SetNecessaryParamMissReply(Username);
			return false;
		}
		if (Password.isEmpty()) {
			reply.SetNecessaryParamMissReply(Password);
			return false;
		}
		if (QueryXml.isEmpty()) {
			reply.SetNecessaryParamMissReply(QueryXml);
			return false;
		}

		return true;
	}
	// endregion

	// region SubmitOrderReply
	public static boolean RequestInfoGuard(SubmitOrderReply reply, String Username, String Password, String QueryXml) {
		if (Username.isEmpty()) {
			reply.SetNecessaryParamMissReply(Username);
			return false;
		}
		if (Password.isEmpty()) {
			reply.SetNecessaryParamMissReply(Password);
			return false;
		}
		if (QueryXml.isEmpty()) {
			reply.SetNecessaryParamMissReply(QueryXml);
			return false;
		}

		return true;
	}
	// endregion
	
	// region SubmitOrderReply
	public static boolean RequestInfoGuard(SubmitMixOrderReply reply, String Username, String Password, String QueryXml) {
		if (Username == null || "".equals(Username)) {
			reply.SetNecessaryParamMissReply("Username");
			return false;
		}
		if (Password == null || "".equals(Password)) {
			reply.SetNecessaryParamMissReply("Password");
			return false;
		}
		if (QueryXml == null || "".equals(QueryXml)) {
			reply.SetNecessaryParamMissReply("QueryXml");
			return false;
		}

		return true;
	}
	// endregion
		

	// region QueryPrintReply
	public static boolean RequestInfoGuard(QueryPrintReply reply, String Username, String Password, String CinemaCode,
			String PrintNo, String VerifyCode) {
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
		if (PrintNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(PrintNo);
			return false;
		}
		if (VerifyCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(VerifyCode);
			return false;
		}

		return true;
	}
	// endregion

	// region RefundTicketReply
	public static boolean RequestInfoGuard(RefundTicketReply reply, String Username, String Password, String CinemaCode,
			String PrintNo, String VerifyCode) {
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
		if (PrintNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(PrintNo);
			return false;
		}
		if (VerifyCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(VerifyCode);
			return false;
		}

		return true;
	}
	// endregion

	// region QueryOrderReply
	public static boolean RequestInfoGuard(QueryOrderReply reply, String Username, String Password, String CinemaCode,
			String OrderCode) {
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
	// endregion

	// region QueryTicketReply
	public static boolean RequestInfoGuard(QueryTicketReply reply, String Username, String Password, String CinemaCode,
			String PrintNo, String VerifyCode) {
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
		if (PrintNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(PrintNo);
			return false;
		}
		if (VerifyCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(VerifyCode);
			return false;
		}

		return true;
	}
	// endregion

	// region FetchTicketReply
	public static boolean RequestInfoGuard(FetchTicketReply reply, String Username, String Password, String CinemaCode,
			String PrintNo, String VerifyCode) {
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
		if (PrintNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(PrintNo);
			return false;
		}
		if (VerifyCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(VerifyCode);
			return false;
		}

		return true;
	}
	// endregion

	// region LoginCardReply
	public static boolean RequestInfoGuard(LoginCardReply reply, String Username, String Password, String CinemaCode,
			String CardNo, String CardPassword) {
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
		if (CardNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardNo);
			return false;
		}
		if (CardPassword.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardPassword);
			return false;
		}
		return true;
	}
	// endregion

	// region QueryCardReply
	public static boolean RequestInfoGuard(QueryCardReply reply, String Username, String Password, String CinemaCode,
			String CardNo, String CardPassword) {
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
		if (CardNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardNo);
			return false;
		}
		if (CardPassword.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardPassword);
			return false;
		}
		return true;
	}
	// endregion

	// region QueryDiscountReply
	public static boolean RequestInfoGuard(QueryDiscountReply reply, String Username, String Password,
			String CinemaCode, String TicketCount, String CardNo, String CardPassword, String LevelCode,
			String SessionCode, String SessionTime, String FilmCode, String ScreenType, String ListingPrice,
			String LowestPrice) {
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
		if (TicketCount.isEmpty()) {
			reply.SetNecessaryParamMissReply(TicketCount);
			return false;
		}
		if (CardNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardNo);
			return false;
		}
		if (CardPassword.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardPassword);
			return false;
		}
		if (LevelCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(LevelCode);
			return false;
		}
		if (SessionCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(SessionCode);
			return false;
		}
		if (SessionTime.isEmpty()) {
			reply.SetNecessaryParamMissReply(SessionTime);
			return false;
		}
		if (FilmCode.isEmpty()) {
			reply.SetNecessaryParamMissReply(FilmCode);
			return false;
		}
		if (ScreenType.isEmpty()) {
			reply.SetNecessaryParamMissReply(ScreenType);
			return false;
		}
		if (ListingPrice.isEmpty()) {
			reply.SetNecessaryParamMissReply(ListingPrice);
			return false;
		}
		if (LowestPrice.isEmpty()) {
			reply.SetNecessaryParamMissReply(LowestPrice);
			return false;
		}

		return true;
	}
	// endregion

	// region CardPayReply
	public static boolean RequestInfoGuard(CardPayReply reply, String Username, String Password, String CinemaCode,
			String CardNo, String CardPassword, String PayAmount,String GoodsPayAmount, String SessionCode, String FilmCode,
			String TicketNum) {
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
		if (CardNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardNo);
			return false;
		}
		if (CardPassword.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardPassword);
			return false;
		}
		if (PayAmount.isEmpty()) {
			reply.SetNecessaryParamMissReply(PayAmount);
			return false;
		}
		if (GoodsPayAmount.isEmpty()) {
			reply.SetNecessaryParamMissReply(GoodsPayAmount);
			return false;
		}
		return true;
	}
	// endregion

	// region CardPayBackReply
	public static boolean RequestInfoGuard(CardPayBackReply reply, String Username, String Password, String CinemaCode,
			String CardNo, String CardPassword, String TradeNo, String PayBackAmount) {
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
		if (CardNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardNo);
			return false;
		}
		if (CardPassword.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardPassword);
			return false;
		}
		if (TradeNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(TradeNo);
			return false;
		}
		if (PayBackAmount.isEmpty()) {
			reply.SetNecessaryParamMissReply(PayBackAmount);
			return false;
		}
		return true;
	}
	// endregion

	// region QueryCardTradeRecordReply
	public static boolean RequestInfoGuard(QueryCardTradeRecordReply reply, String Username, String Password,
			String CinemaCode, String CardNo, String CardPassword, String StartDate, String EndDate, String PageSize,
			String PageNum) {
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
		if (CardNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardNo);
			return false;
		}
		if (CardPassword.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardPassword);
			return false;
		}
		if (StartDate.isEmpty()) {
			reply.SetNecessaryParamMissReply(StartDate);
			return false;
		}
		if (EndDate.isEmpty()) {
			reply.SetNecessaryParamMissReply(EndDate);
			return false;
		}
		if (PageSize.isEmpty()) {
			reply.SetNecessaryParamMissReply(PageSize);
			return false;
		}
		if (PageNum.isEmpty()) {
			reply.SetNecessaryParamMissReply(PageNum);
			return false;
		}
		return true;
	}
	// endregion

	// region CardChargeReply
	public static boolean RequestInfoGuard(CardChargeReply reply, String Username, String Password, String CinemaCode,
			String CardNo, String CardPassword, String ChargeType, String ChargeAmount) {
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
		if (CardNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardNo);
			return false;
		}
		if (CardPassword.isEmpty()) {
			reply.SetNecessaryParamMissReply(CardPassword);
			return false;
		}
		if (ChargeType.isEmpty()) {
			reply.SetNecessaryParamMissReply(ChargeType);
			return false;
		}
		if (ChargeAmount.isEmpty()) {
			reply.SetNecessaryParamMissReply(ChargeAmount);
			return false;
		}
		return true;
	}
	// endregion
	
	//region QueryCardLevelReply
	public static boolean RequestInfoGuard(QueryCardLevelReply reply, String Username, String Password,
            String CinemaCode)
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
	
	//region CardRegisterReply
	public static boolean RequestInfoGuard(CardRegisterReply reply, String Username, String Password, String CinemaCode, String CardPassword, String LevelCode, String InitialAmount, String CardUserName, String MobilePhone, String IDNumber, String Sex)
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
        if (CardPassword.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CardPassword);
            return false;
        }
        if (LevelCode.isEmpty())
        {
            reply.SetNecessaryParamMissReply(LevelCode);
            return false;
        }
        if (InitialAmount.isEmpty())
        {
            reply.SetNecessaryParamMissReply(InitialAmount);
            return false;
        }
        if (CardUserName.isEmpty())
        {
            reply.SetNecessaryParamMissReply(CardUserName);
            return false;
        }
        if (MobilePhone.isEmpty())
        {
            reply.SetNecessaryParamMissReply(MobilePhone);
            return false;
        }
        if (IDNumber.isEmpty())
        {
            reply.SetNecessaryParamMissReply(IDNumber);
            return false;
        }
        if (Sex.isEmpty())
        {
            reply.SetNecessaryParamMissReply(Sex);
            return false;
        }
        return true;
    }
	//endregion
	
	//region QueryGoodsReply
	public static boolean RequestInfoGuard(QueryGoodsReply reply, String Username, String Password, String CinemaCode) {
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
		return true;
	}
	//endregion
	
	//region SubmitGoodsOrderReply
	public static boolean RequestInfoGuard(SubmitGoodsOrderReply reply, String Username, String Password, String QueryXml) {
		if (Username.isEmpty()) {
			reply.SetNecessaryParamMissReply(Username);
			return false;
		}
		if (Password.isEmpty()) {
			reply.SetNecessaryParamMissReply(Password);
			return false;
		}
		if (QueryXml.isEmpty()) {
			reply.SetNecessaryParamMissReply(QueryXml);
			return false;
		}

		return true;
	}
	//endregion
	
	//region CreateGoodsOrderReply
	public static boolean RequestInfoGuard(CreateGoodsOrderReply reply, String Username, String Password, String QueryXml) {
		if (Username.isEmpty()) {
			reply.SetNecessaryParamMissReply(Username);
			return false;
		}
		if (Password.isEmpty()) {
			reply.SetNecessaryParamMissReply(Password);
			return false;
		}
		if (QueryXml.isEmpty()) {
			reply.SetNecessaryParamMissReply(QueryXml);
			return false;
		}
		return true;
	}
	//endregion
	
	//region QueryGoodsOrderReply
	public static boolean RequestInfoGuard(QueryGoodsOrderReply reply, String Username, String Password, String CinemaCode,
			String OrderCode) {
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
	
	//region RefundGoodsReply
	public static boolean RequestInfoGuard(RefundGoodsReply reply, String Username, String Password, String CinemaCode,
			String OrderCode, String PaySeqNo) {
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
		if (PaySeqNo.isEmpty()) {
			reply.SetNecessaryParamMissReply(PaySeqNo);
			return false;
		}

		return true;
	}
	//endregion
}
