package com.boot.security.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dongjingjun
 * 2017/7/11.
 * 区域表
 */
@Entity
@Table(name = DXRegion.tableName)
public class DXRegion extends IdEntity{
    public static final String tableName = "dx_region";
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

