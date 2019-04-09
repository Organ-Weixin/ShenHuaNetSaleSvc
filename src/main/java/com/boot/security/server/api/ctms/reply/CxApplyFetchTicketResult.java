package com.boot.security.server.api.ctms.reply;

import java.util.List;

public class CxApplyFetchTicketResult {
	private ResBean ApplyFetchTicketResult;

	public ResBean getApplyFetchTicketResult() {
		return ApplyFetchTicketResult;
	}

	public void setApplyFetchTicketResult(ResBean applyFetchTicketResult) {
		ApplyFetchTicketResult = applyFetchTicketResult;
	}
	public static class ResBean{
		private String ResultCode;
		private String Message;
		private TicketsBean Tickets;
		public String getResultCode() {
			return ResultCode;
		}
		public void setResultCode(String resultCode) {
			ResultCode = resultCode;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public TicketsBean getTickets() {
			return Tickets;
		}
		public void setTickets(TicketsBean tickets) {
			Tickets = tickets;
		}
		public static class TicketsBean{
			private List<TicketBean> Ticket;

			public List<TicketBean> getTicket() {
				return Ticket;
			}

			public void setTicket(List<TicketBean> ticket) {
				Ticket = ticket;
			}
			public static class TicketBean{
				private String PrintNo;
				private String ReturnValue;
				public String getPrintNo() {
					return PrintNo;
				}
				public void setPrintNo(String printNo) {
					PrintNo = printNo;
				}
				public String getReturnValue() {
					return ReturnValue;
				}
				public void setReturnValue(String returnValue) {
					ReturnValue = returnValue;
				}
				
			}
			
		}
	}

}
