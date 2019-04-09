package com.boot.security.server.api.ctms.reply;

/**
 * 根据取票序号、取票验证码查询取货状态
 */
public class CxQueryDeliveryStatusResult {
    private ResBean QueryDeliveryStatusResult;

    public ResBean getQueryDeliveryStatusResult() {
        return QueryDeliveryStatusResult;
    }

    public void setQueryDeliveryStatusResult(ResBean queryDeliveryStatusResult) {
        QueryDeliveryStatusResult = queryDeliveryStatusResult;
    }

    public static class ResBean {
        private  String ResultCode;//返回结果号，详细见附录A
        private String  Message;//返回信息，详细见附录A
        private String  OrderCode;//订单编码
        private String  PrintNo;//取票序号
        private String  VerifyCode;//取票验证码
        private String  PrintStatus;//出票状态： Yes，已出票 No，未出票
        private String  PrintTime;//出票时间，格式：YYYY-MM-DD hh:mm:ss
        private String  DeliveryStatus;//卖品取货状态： Yes，已取货 No，未取货
        private String  DeliveryTime;//卖品取货时间，格式：YYYY-MM-DD hh:mm:ss

        public String getPrintStatus() {
            return PrintStatus;
        }

        public void setPrintStatus(String printStatus) {
            PrintStatus = printStatus;
        }

        public String getPrintTime() {
            return PrintTime;
        }

        public void setPrintTime(String printTime) {
            PrintTime = printTime;
        }

        public String getDeliveryStatus() {
            return DeliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            DeliveryStatus = deliveryStatus;
        }

        public String getDeliveryTime() {
            return DeliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            DeliveryTime = deliveryTime;
        }

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
