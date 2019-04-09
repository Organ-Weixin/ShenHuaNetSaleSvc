package com.boot.security.server.model;

//import org.hibernate.annotations.Index;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * Created by xugang
 * 2018/11/28.
 * 影院信息 影厅座位信息
 */
@Entity
@Table(name = DXSeatInfo.tableName, uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class DXSeatInfo extends IdEntity {

    public static final String tableName = "dx_seat_info";

    private String SeatCode;//座位编码
    private String GroupCode;//分组编码
    private String RowNum;//座位行号
    private String ColumnNum;//座位列号
    private String XCoord;//座位横坐标
    private String YCoord;//座位纵坐标
    private String Status;//座位状态：Available，可用Unavailable，不可用Locked，已锁定Sold，已售出Booked，已预订
    private String MemberLevelCode;//专售会员等级，无限制时，返回AllUser，仅限会员时返回AllMember，指定会员时，返回各会员等级，以英文逗号分隔

    public String getSeatCode() {
        return SeatCode;
    }

    public void setSeatCode(String SeatCode) {
        this.SeatCode = SeatCode;
    }

    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String groupCode) {
        GroupCode = groupCode;
    }

    public String getRowNum() {
        return RowNum;
    }

    public void setRowNum(String rowNum) {
        RowNum = rowNum;
    }

    public String getColumnNum() {
        return ColumnNum;
    }

    public void setColumnNum(String columnNum) {
        ColumnNum = columnNum;
    }

    public String getXCoord() {
        return XCoord;
    }

    public void setXCoord(String XCoord) {
        this.XCoord = XCoord;
    }

    public String getYCoord() {
        return YCoord;
    }

    public void setYCoord(String YCoord) {
        this.YCoord = YCoord;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMemberLevelCode() {
        return MemberLevelCode;
    }

    public void setMemberLevelCode(String memberLevelCode) {
        MemberLevelCode = memberLevelCode;
    }
}

