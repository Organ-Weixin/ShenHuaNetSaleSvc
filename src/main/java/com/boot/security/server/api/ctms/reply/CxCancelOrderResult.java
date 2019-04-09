package com.boot.security.server.api.ctms.reply;

/**
 * 根据取票序号、取票验证码取消交易订单
 */
public class CxCancelOrderResult {
    private ResBean CancelOrderResult;

    public ResBean getCancelOrderResult() {
        return CancelOrderResult;
    }

    public void setCancelOrderResult(ResBean cancelOrderResult) {
        CancelOrderResult = cancelOrderResult;
    }

    public static class ResBean {
        private  String ResultCode;//返回结果号，详细见附录A
        private String  Message;//返回信息，详细见附录A
        private String  OrderCode;//订单编码
        private String  PrintNo;//取票序号
        private String  VerifyCode;//取票验证码

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

        public String getOrderCode() {
            return OrderCode;
        }

        public void setOrderCode(String orderCode) {
            OrderCode = orderCode;
        }

        public String getPrintNo() {
            return PrintNo;
        }

        public void setPrintNo(String printNo) {
            PrintNo = printNo;
        }

        public String getVerifyCode() {
            return VerifyCode;
        }

        public void setVerifyCode(String verifyCode) {
            VerifyCode = verifyCode;
        }
    }
}
