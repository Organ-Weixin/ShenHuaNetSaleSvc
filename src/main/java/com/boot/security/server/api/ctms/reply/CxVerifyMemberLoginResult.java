package com.boot.security.server.api.ctms.reply;

public class CxVerifyMemberLoginResult {
    private ResBean VerifyMemberLoginResult;

    public ResBean getVerifyMemberLoginResult() {
        return VerifyMemberLoginResult;
    }

    public void setVerifyMemberLoginResult(ResBean verifyMemberLoginResult) {
        VerifyMemberLoginResult = verifyMemberLoginResult;
    }

    public static class ResBean {
        private String ResultCode;//返回结果号，详细见附录A
        private String Message;//	返回信息，详细见附录A
        private String CardNum;//会员卡号
        private String PhoneNum;//手机号
        private String LevelName;//等级名称
        private String LevelCode;//会员等级标识(编码)

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

        public String getCardNum() {
            return CardNum;
        }

        public void setCardNum(String cardNum) {
            CardNum = cardNum;
        }

        public String getPhoneNum() {
            return PhoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            PhoneNum = phoneNum;
        }

        public String getLevelName() {
            return LevelName;
        }

        public void setLevelName(String levelName) {
            LevelName = levelName;
        }

        public String getLevelCode() {
            return LevelCode;
        }

        public void setLevelCode(String levelCode) {
            LevelCode = levelCode;
        }
    }
}
