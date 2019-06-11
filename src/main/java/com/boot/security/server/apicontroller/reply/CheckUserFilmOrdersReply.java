package com.boot.security.server.apicontroller.reply;

public class CheckUserFilmOrdersReply extends BaseReply{
	private Integer Result;
	private String ResultMessage;

	public Integer getResult() {
		return Result;
	}

	public void setResult(Integer result) {
		Result = result;
	}

	public String getResultMessage() {
		return ResultMessage;
	}

	public void setResultMessage(String resultMessage) {
		ResultMessage = resultMessage;
	}
	
}
