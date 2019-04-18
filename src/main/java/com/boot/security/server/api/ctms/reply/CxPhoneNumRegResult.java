package com.boot.security.server.api.ctms.reply;

public class CxPhoneNumRegResult {
    private ResBean PhoneNumRegResult;

    public ResBean getPhoneNumRegResult() {
        return PhoneNumRegResult;
    }

    public void setPhoneNumRegResult(ResBean phoneNumRegResult) {
        PhoneNumRegResult = phoneNumRegResult;
    }

    public static class ResBean {
        private String ResultCode;//返回结果号，详细见附录A
        private String Message;//返回信息，详细见附录A

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

    }
}

