package com.boot.security.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * created by gw 2018/11/28 神话平台优惠券
 */
@Entity
@Table(name="dx_plat_ticket")
public class DXPlatTicket extends IdEntity{
    private String name;                //优惠券名称
    private Integer ticketType;         //优惠券类型(自己定义,需要与app和小程序商量统一;例:1电影代金券,2卖品代金券,3电影观影券)
    private Integer reduceType = 2;          //1无门槛,2满金额(现只有满金额)
    private Double achieveMoney;        //满减须达到的金额；                     如果是晨新券，这个字段代表优惠完的票价；
    private Double fixedPayMoney;       //固定支付金额(ticketType=3时有值)       如果是晨新券，这个字段代表用完券一张票的还需要付的；
    private String applicationType;     //使用范围(用英文下的","拼接,0观摩影片1普通2普通立体3巨幕4巨幕立体5胶片6其他特种电影7其他a动画片b纪录片c科教片)
    private Date startTime;             //开始时间
    private Date endTime;               //结束时间
    private Double amount;             //优惠券金额(ticktType为代金券时有值) ；   如果是晨新券，这个字段代表券可以抵的钱；
    private String ticketDesc;          //优惠券规则说明
    private Integer status;             //是否开启
    private Integer plusType;           //是否可与其他活动叠加(0否,1是)
    private Integer platformType = 1;   //平台类型,默认等于1(1本平台优惠券,2接口获取到的优惠券)
    private Integer totalNum;           //优惠券总数量
    private Integer sendNum =0;            //已发放数量
    private Integer remainNum;          //剩余数量
    private Long businessid;            //关联商家id
    private Integer groupNumber;    //每个聊天室最多发送的组数
    private Integer number;         //聊天室发放时 每组的数量
    private Integer giftType;       //临时字段,聊天室发放奖品时用到
    private String ticketNumber;    //线下券的编码
    private String exceptDate;      //排除的日期，yyyy-MM-dd格式的字符串用逗号隔开
    private Integer usedNum = 0;          //已使用数量
    private Integer overDateNumber;  //用户兑换/注册赠送等其他方式领取之后的过期天数（如果优惠券本身剩余有效期小于设置的过期天数，则以本身剩余有效起为准）
    /*-----------------------晨新券专用------------------------------*/
    private String TicketSaleOrderNo ;//票券销售单号
    private String TicketSaleOrderName;//	票券名称
    private String CouponCategoryCode;//票券一级分类编码
    private String CouponCategoryName;//票券一级分类名称
    private String CouponTypeCode;//票券分类编码
    private String CouponTypeName;//票券分类名称
    private String RuleId;//票券规则id
    private String message;//退券失败原因
    private String consumeMessage;//消费结果

    public String getConsumeMessage() {
        return consumeMessage;
    }

    public void setConsumeMessage(String consumeMessage) {
        this.consumeMessage = consumeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRuleId() {
        return RuleId;
    }

    public void setRuleId(String ruleId) {
        RuleId = ruleId;
    }

    public String getTicketSaleOrderNo() {
        return TicketSaleOrderNo;
    }

    public void setTicketSaleOrderNo(String ticketSaleOrderNo) {
        TicketSaleOrderNo = ticketSaleOrderNo;
    }

    public String getTicketSaleOrderName() {
        return TicketSaleOrderName;
    }

    public void setTicketSaleOrderName(String ticketSaleOrderName) {
        TicketSaleOrderName = ticketSaleOrderName;
    }

    public String getCouponCategoryCode() {
        return CouponCategoryCode;
    }

    public void setCouponCategoryCode(String couponCategoryCode) {
        CouponCategoryCode = couponCategoryCode;
    }

    public String getCouponCategoryName() {
        return CouponCategoryName;
    }

    public void setCouponCategoryName(String couponCategoryName) {
        CouponCategoryName = couponCategoryName;
    }

    public String getCouponTypeCode() {
        return CouponTypeCode;
    }

    public void setCouponTypeCode(String couponTypeCode) {
        CouponTypeCode = couponTypeCode;
    }

    public String getCouponTypeName() {
        return CouponTypeName;
    }

    public void setCouponTypeName(String couponTypeName) {
        CouponTypeName = couponTypeName;
    }

    public Integer getUsedNum() {
        return usedNum;
    }

    public void setUsedNum(Integer usedNum) {
        this.usedNum = usedNum;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Integer getTicketType() {
        return ticketType;
    }

    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }

    public Integer getReduceType() {
        return reduceType;
    }

    public void setReduceType(Integer reduceType) {
        this.reduceType = reduceType;
    }

    public Double getAchieveMoney() {
        return achieveMoney;
    }

    public void setAchieveMoney(Double achieveMoney) {
        this.achieveMoney = achieveMoney;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getPlusType() {
        return plusType;
    }

    public void setPlusType(Integer plusType) {
        this.plusType = plusType;
    }

    public Long getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Long businessid) {
        this.businessid = businessid;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Transient
    public Integer getGiftType() {
        return giftType;
    }

    public void setGiftType(Integer giftType) {
        this.giftType = giftType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Double getFixedPayMoney() {
        return fixedPayMoney;
    }

    public void setFixedPayMoney(Double fixedPayMoney) {
        this.fixedPayMoney = fixedPayMoney;
    }


    @Column(length = 1000)
    public String getExceptDate() {
        return exceptDate;
    }

    public void setExceptDate(String exceptDate) {
        this.exceptDate = exceptDate;
    }

    public Integer getOverDateNumber() {
        return overDateNumber;
    }

    public void setOverDateNumber(Integer overDateNumber) {
        this.overDateNumber = overDateNumber;
    }
}