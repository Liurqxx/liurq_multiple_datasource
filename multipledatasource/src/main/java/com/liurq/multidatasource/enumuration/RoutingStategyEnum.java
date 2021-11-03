package com.liurq.multidatasource.enumuration;

/**
 * @author liurq
 * @desc 路由策略枚举
 * @date 2021-11-03  21:40
 */
public enum RoutingStategyEnum {

    ROUTING_DS_TABLE_STATEGY("ROUTING_DS_TABLE_STATEGY", "多库多表"),
    ROUTING_DS_STATEGY("ROUTING_DS_STATEGY", "一库多表"),
    ROUTING_TABLE_STATEGY("ROUTING_TABLE_STATEGY", "多库一表");


    private String code;

    private String desc;


    RoutingStategyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
