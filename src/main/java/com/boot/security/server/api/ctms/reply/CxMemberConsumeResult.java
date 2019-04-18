package com.boot.security.server.api.ctms.reply;

public class CxMemberConsumeResult {
    private ResBean MemberConsumeResult;

    public ResBean getMemberConsumeResult() {
        return MemberConsumeResult;
    }

    public void setMemberConsumeResult(ResBean memberConsumeResult) {
        MemberConsumeResult = memberConsumeResult;
    }

    public static class ResBean {
        private String ResultCode;//返回结果号，详细见附录A
        private String Message;//返回信息，详细见附录A
        private String TransactionNo;//会员交易流水号
        private Float GiveAmount;//赠送账户扣除金额

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

        public String getTransactionNo() {
            return TransactionNo;
        }

        public void setTransactionNo(String transactionNo) {
            TransactionNo = transactionNo;
        }

        public Float getGiveAmount() {
            return GiveAmount;
        }

        public void setGiveAmount(Float giveAmount) {
            GiveAmount = giveAmount;
        }
    }
}
