package com.liurq.busi.bean;

import com.liurq.multidatasource.dynamicdatasource.MultiDataSourceHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
public class CarType {


    private String tableSuffix;

    private Long typeId;

    /**
     * 车辆类型名称
     */
    private String name;

    public String getTableSuffix() {
        this.tableSuffix = MultiDataSourceHolder.getTableIndex();
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }
}
