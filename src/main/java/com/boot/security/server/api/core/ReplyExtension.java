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
	
	//region ReleaseSeatReply
	public static boolean RequestInfoGuard(ReleaseSeatReply reply, String Username, String Password,
            String QueryXml)
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
            if (QueryXml.isEmpty())
            {
                reply.SetNecessaryParamMissReply(QueryXml);
                return false;
            }

            return true;
        }
	//endregion
	
	//region SubmitOrderReply
	public static boolean RequestInfoGuard(SubmitOrderReply reply, String Username, String Password,
            String QueryXml)
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
            if (QueryXml.isEmpty())
            {
                reply.SetNecessaryParamMissReply(QueryXml);
                return false;
            }

            return true;
        }
	//endregion
	
	//region QueryPrintReply
	public static boolean RequestInfoGuard(QueryPrintReply reply, String Username, String Password,
            String CinemaCode, String PrintNo, String VerifyCode)
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
            if (PrintNo.isEmpty())
            {
                reply.SetNecessaryParamMissReply(PrintNo);
                return false;
            }
            if (VerifyCode.isEmpty())
            {
                reply.SetNecessaryParamMissReply(VerifyCode);
                return false;
            }

            return true;
        }
	//endregion
	
	//region RefundTicketReply
	public static boolean RequestInfoGuard(RefundTicketReply reply, String Username, String Password,
            String CinemaCode, String PrintNo, String VerifyCode)
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
            if (PrintNo.isEmpty())
            {
                reply.SetNecessaryParamMissReply(PrintNo);
                return false;
            }
            if (VerifyCode.isEmpty())
            {
                reply.SetNecessaryParamMissReply(VerifyCode);
                return false;
            }

            return true;
        }
	//endregion
	
	//region QueryOrderReply
	public static boolean RequestInfoGuard(QueryOrderReply reply, String Username, String Password,
            String CinemaCode, String OrderCode)
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
            if (OrderCode.isEmpty())
            {
                reply.SetNecessaryParamMissReply(OrderCode);
                return false;
            }

            return true;
        }
	//endregion
	
	//region QueryTicketReply
	public static boolean RequestInfoGuard(QueryTicketReply reply, String Username, String Password,
            String CinemaCode, String PrintNo, String VerifyCode)
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
            if (PrintNo.isEmpty())
            {
                reply.SetNecessaryParamMissReply(PrintNo);
                return false;
            }
            if (VerifyCode.isEmpty())
            {
                reply.SetNecessaryParamMissReply(VerifyCode);
                return false;
            }

            return true;
        }
	//endregion
	
	//region FetchTicketReply
	public static boolean RequestInfoGuard(FetchTicketReply reply, String Username, String Password,
            String CinemaCode, String PrintNo, String VerifyCode)
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
            if (PrintNo.isEmpty())
            {
                reply.SetNecessaryParamMissReply(PrintNo);
                return false;
            }
            if (VerifyCode.isEmpty())
            {
                reply.SetNecessaryParamMissReply(VerifyCode);
                return false;
            }

            return true;
        }
	//endregion
}
