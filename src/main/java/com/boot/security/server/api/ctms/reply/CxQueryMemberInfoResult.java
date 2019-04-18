package com.boot.security.server.api.ctms.reply;

public class CxQueryMemberInfoResult {
    private ResBean QueryMemberInfoResult;

    public ResBean getQueryMemberInfoResult() {
        return QueryMemberInfoResult;
    }

    public void setQueryMemberInfoResult(ResBean queryMemberInfoResult) {
        QueryMemberInfoResult = queryMemberInfoResult;
    }

    public static class ResBean {
        private String ResultCode;//返回结果号，详细见附录A
        private String Message;//	返回信息，详细见附录A
        private String ID;//会员账号的唯一标识
        private String CardNum;//会员卡号
        private String UserName;//姓名
        private String Sex;//	性别
        private String CreditNum;//身份证
        private String MobileNum;//手机号
        private String LevelCode;//会员等级标识(编码)
        private String LevelName;//会员等级
        private String Birthday;//生日格式：2012-10-09
        private String BusinessName;//注册商户名称
        private String BusinessCode;//注册商户编号
        private String RegistDate;//注册日期
        private String BasicBalance;//基本账户余额
        private String DonateBalance;//赠送账户余额
        private String IntegralBalance;//积分余额
        private Double Lower;//单次充值下限
        private Double Upper;//单次充值上限
        private Integer IntegralToCashBasis;//积分兑换现金比例基数
        private Integer IntegralToCashValue;//积分兑换现金比例值
        private String AllowConsumeType;//允许消费商品类型，0-全部；1-影票；2-卖品
        private String AllowIntegralType;//允许积分商品类型，0-全部；1-影票；2-卖品
        private Double TicketProportion;//影票消费积分比例（%）
        private Double GoodsProportion;//卖品消费积分比例（%）
        private String MemberStatus;//会员账户状态
        private String CardStatus;//会员卡状态

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

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getCardNum() {
            return CardNum;
        }

        public void setCardNum(String cardNum) {
            CardNum = cardNum;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String sex) {
            Sex = sex;
        }

        public String getCreditNum() {
            return CreditNum;
        }

        public void setCreditNum(String creditNum) {
            CreditNum = creditNum;
        }

        public String getMobileNum() {
            return MobileNum;
        }

        public void setMobileNum(String mobileNum) {
            MobileNum = mobileNum;
        }

        public String getLevelCode() {
            return LevelCode;
        }

        public void setLevelCode(String levelCode) {
            LevelCode = levelCode;
        }

        public String getLevelName() {
            return LevelName;
        }

        public void setLevelName(String levelName) {
            LevelName = levelName;
        }

        public String getBirthday() {
            return Birthday;
        }

        public void setBirthday(String birthday) {
            Birthday = birthday;
        }

        public String getBusinessName() {
            return BusinessName;
        }

        public void setBusinessName(String businessName) {
            BusinessName = businessName;
        }

        public String getBusinessCode() {
            return BusinessCode;
        }

        public void setBusinessCode(String businessCode) {
            BusinessCode = businessCode;
        }

        public String getRegistDate() {
            return RegistDate;
        }

        public void setRegistDate(String registDate) {
            RegistDate = registDate;
        }

        public String getBasicBalance() {
            return BasicBalance;
        }

        public void setBasicBalance(String basicBalance) {
            BasicBalance = basicBalance;
        }

        public String getDonateBalance() {
            return DonateBalance;
        }

        public void setDonateBalance(String donateBalance) {
            DonateBalance = donateBalance;
        }

        public String getIntegralBalance() {
            return IntegralBalance;
        }

        public void setIntegralBalance(String integralBalance) {
            IntegralBalance = integralBalance;
        }

        public Double getLower() {
            return Lower;
        }

        public void setLower(Double lower) {
            Lower = lower;
        }

        public Double getUpper() {
            return Upper;
        }

        public void setUpper(Double upper) {
            Upper = upper;
        }

        public Integer getIntegralToCashBasis() {
            return IntegralToCashBasis;
        }

        public void setIntegralToCashBasis(Integer integralToCashBasis) {
            IntegralToCashBasis = integralToCashBasis;
        }

        public Integer getIntegralToCashValue() {
            return IntegralToCashValue;
        }

        public void setIntegralToCashValue(Integer integralToCashValue) {
            IntegralToCashValue = integralToCashValue;
        }

        public String getAllowConsumeType() {
            return AllowConsumeType;
        }

        public void setAllowConsumeType(String allowConsumeType) {
            AllowConsumeType = allowConsumeType;
        }

        public String getAllowIntegralType() {
            return AllowIntegralType;
        }

        public void setAllowIntegralType(String allowIntegralType) {
            AllowIntegralType = allowIntegralType;
        }

        public Double getTicketProportion() {
            return TicketProportion;
        }

        public void setTicketProportion(Double ticketProportion) {
            TicketProportion = ticketProportion;
        }

        public Double getGoodsProportion() {
            return GoodsProportion;
        }

        public void setGoodsProportion(Double goodsProportion) {
            GoodsProportion = goodsProportion;
        }

        public String getMemberStatus() {
            return MemberStatus;
        }

        public void setMemberStatus(String memberStatus) {
            MemberStatus = memberStatus;
        }

        public String getCardStatus() {
            return CardStatus;
        }

        public void setCardStatus(String cardStatus) {
            CardStatus = cardStatus;
        }
    }
}
