package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.List;

/**
 * 提交买票订单
 */
public class CxSubmitOrderResult {
    private ResBean SubmitOrderResult;

    public ResBean getSubmitOrderResult() {
        return SubmitOrderResult;
    }

    public void setSubmitOrderResult(ResBean submitOrderResult) {
        SubmitOrderResult = submitOrderResult;
    }

    public static class ResBean {
        private String ResultCode;//返回结果号，详细见附录A
        private String Message;//返回信息，详细见附录A
        private String OrderCode;//订单编码
        private String FeatureAppNo;//放映计划编码
        private String PrintNo;//取票序号（客户输入后8位在柜台或辰星取票机取票）
        private String VerifyCode;//取票验证码
        private SeatInfosBean SeatInfos;//座位
        private SaleMerInfosBean SaleMerInfos;//卖品

        public static class SeatInfosBean {
            List<SeatInfoBean> SeatInfo;

            public List<SeatInfoBean> getSeatInfo() {
                return SeatInfo;
            }

            public void setSeatInfo(List<SeatInfoBean> seatInfo) {
                SeatInfo = seatInfo;
            }

            public static class SeatInfoBean {
                private String SeatCode;//座位编码
                private String FilmTicketCode;//电影票编码
                private String TicketInfoCode;//电影票信息码

                public String getSeatCode() {
                    return SeatCode;
                }

                public void setSeatCode(String seatCode) {
                    SeatCode = seatCode;
                }

                public String getFilmTicketCode() {
                    return FilmTicketCode;
                }

                public void setFilmTicketCode(String filmTicketCode) {
                    FilmTicketCode = filmTicketCode;
                }

                public String getTicketInfoCode() {
                    return TicketInfoCode;
                }

                public void setTicketInfoCode(String ticketInfoCode) {
                    TicketInfoCode = ticketInfoCode;
                }
            }
        }

        public static class SaleMerInfosBean {
            List<SaleMerInfoBean> SaleMerInfo;

            public List<SaleMerInfoBean> getSaleMerInfo() {
                return SaleMerInfo;
            }

            public void setSaleMerInfo(List<SaleMerInfoBean> saleMerInfo) {
                SaleMerInfo = saleMerInfo;
            }

            public static class SaleMerInfoBean {
                private String MerCode;//商品编码
                private String MerName;//商品名称
                private Integer SaleAmount;//商品数量

                public String getMerCode() {
                    return MerCode;
                }

                public void setMerCode(String merCode) {
                    MerCode = merCode;
                }

                public String getMerName() {
                    return MerName;
                }

                public void setMerName(String merName) {
                    MerName = merName;
                }

                public Integer getSaleAmount() {
                    return SaleAmount;
                }

                public void setSaleAmount(Integer saleAmount) {
                    SaleAmount = saleAmount;
                }
            }
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

        public String getFeatureAppNo() {
            return FeatureAppNo;
        }

        public void setFeatureAppNo(String featureAppNo) {
            FeatureAppNo = featureAppNo;
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

        public SeatInfosBean getSeatInfos() {
            return SeatInfos;
        }

        public void setSeatInfos(SeatInfosBean seatInfos) {
            SeatInfos = seatInfos;
        }

        public SaleMerInfosBean getSaleMerInfos() {
            return SaleMerInfos;
        }

        public void setSaleMerInfos(SaleMerInfosBean saleMerInfos) {
            SaleMerInfos = saleMerInfos;
        }
    }
}

