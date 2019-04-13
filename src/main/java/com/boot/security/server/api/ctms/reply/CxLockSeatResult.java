package com.boot.security.server.api.ctms.reply;

import java.util.Date;
import java.util.List;
/**
 * 锁定座位
 */
public class CxLockSeatResult {
    private ResBean LockSeatResult;
    public ResBean getLockSeatResult() {
        return LockSeatResult;
    }
    public void setLockSeatResult(ResBean lockSeatResult) {
        LockSeatResult = lockSeatResult;
    }
    public static class ResBean{
        private String ResultCode;
        private String Message;
        private Date AutoUnlockDatetime;//自动解锁时间，格式为YYYY-MM-DD hh:mm:ss
        private String OrderCode;//订单编码
        private Integer LockLength;//锁座时长，单位：分钟
        private String FeatureAppNo;//放映计划编码
        private LockSeatInfosBean SeatInfos;
        public static class LockSeatInfosBean{
            private  List<SeatInfoBean> SeatInfo;
            public List<SeatInfoBean> getSeatCode() {
                return SeatInfo;
            }
            public void setSeatCode(List<SeatInfoBean> SeatInfo) {
            	SeatInfo = SeatInfo;
            }
            public static class SeatInfoBean{
            	private String SeatCode;

				public String getSeatCode() {
					return SeatCode;
				}

				public void setSeatCode(String seatCode) {
					SeatCode = seatCode;
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

        public Date getAutoUnlockDatetime() {
            return AutoUnlockDatetime;
        }

        public void setAutoUnlockDatetime(Date autoUnlockDatetime) {
            AutoUnlockDatetime = autoUnlockDatetime;
        }

        public String getOrderCode() {
            return OrderCode;
        }

        public void setOrderCode(String orderCode) {
            OrderCode = orderCode;
        }

        public Integer getLockLength() {
            return LockLength;
        }

        public void setLockLength(Integer lockLength) {
            LockLength = lockLength;
        }

        public String getFeatureAppNo() {
            return FeatureAppNo;
        }

        public void setFeatureAppNo(String featureAppNo) {
            FeatureAppNo = featureAppNo;
        }

        public LockSeatInfosBean getSeatInfos() {
            return SeatInfos;
        }

        public void setSeatInfos(LockSeatInfosBean seatInfos) {
            SeatInfos = seatInfos;
        }
        @Override
        public String toString() {
            return "ResBean{" +
                    "ResultCode=" + ResultCode +
                    ", Message='" + Message + '\'' +
                    ", AutoUnlockDatetime='" + AutoUnlockDatetime + '\'' +
                    ", LockLength='" + LockLength + '\'' +
                    ", FeatureAppNo='" + FeatureAppNo + '\'' +
                    ", OrderCode=" + OrderCode +
                    '}';
        }
    }
}

