package com.boot.security.server.model;

/**
 * websocket聊天室消息数据包
 */
public class DXChatMessage {
    private String role;   //角色2管理员,1普通用户
    private String phoneOrOpenid;   //电话号码
    private String header;  //头像
    private String nickname;    //昵称
    private String messageType;   //消息类型 0当前账号在其他地方进入了聊天室 1文字消息,2管理员发送奖品,3领取奖品成功,-1房间未开启,-2房间已结束,-3奖品被领取完了 5心跳 21领红包
    private String content;    //消息内容(如果消息类型为奖品,这里存的是图片链接,需要过滤敏感词)
    private String prizeId;   //奖品类型(消息类型为2时有值);

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getPhoneOrOpenid() {
        return phoneOrOpenid;
    }

    public void setPhoneOrOpenid(String phoneOrOpenid) {
        this.phoneOrOpenid = phoneOrOpenid;
    }

    @Override
    public String toString(){
        return "{\"role\":\""+role+"\",\"header\":\""+header+"\",\"phoneOrOpenid\":\""+phoneOrOpenid+"\",\"nickname\":\""+nickname+
                "\",\"messageType\":\""+messageType+"\",\"content\":\""+content+"\",\"prizeId\":\""+prizeId+"\"}";
    }
}
