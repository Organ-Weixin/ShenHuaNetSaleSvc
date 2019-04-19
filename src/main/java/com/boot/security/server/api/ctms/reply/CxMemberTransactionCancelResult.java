package com.boot.security.server.api.ctms.reply; 

public class CxMemberTransactionCancelResult {
    private ResBean MemberTransactionCancelResult;

    public ResBean getMemberTransactionCancelResult() {
        return MemberTransactionCancelResult;
    }

    public void setMemberTransactionCancelResult(ResBean memberTransactionCancelResult) {
        MemberTransactionCancelResult = memberTransactionCancelResult;
    }

    public static class ResBean {
        private String ResultCode;//返回结果号，详细见附录A
        private String Message;//返回信息，详细见附录A
        private String TransactionNo;//会员交易流水号

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
    }
}
