package com.boot.security.server.model;

import java.util.List;

/**
 * 发送短信返回
 * @author zpj
 * @date 2018/5/28 13:49
 */
public class MsgResponse {

    /**
     * code : 0
     * msg : 提交成功
     * rets : [{"respCode":0,"mobile":"13485769883","sendId":"123"},{"respCode":0,"mobile":"13480983746","sendId":"456"}]
     */

    private int code;
    private String msg;
    private List<RetsBean> rets;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RetsBean> getRets() {
        return rets;
    }

    public void setRets(List<RetsBean> rets) {
        this.rets = rets;
    }

    public static class RetsBean {
        /**
         * respCode : 0
         * mobile : 13485769883
         * sendId : 123
         */

        private int respCode;
        private String mobile;
        private String sendId;

        public int getRespCode() {
            return respCode;
        }

        public void setRespCode(int respCode) {
            this.respCode = respCode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getSendId() {
            return sendId;
        }

        public void setSendId(String sendId) {
            this.sendId = sendId;
        }
    }
}
