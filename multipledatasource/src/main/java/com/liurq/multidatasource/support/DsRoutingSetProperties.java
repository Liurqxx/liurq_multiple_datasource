package com.liurq.multidatasource.support;

import com.liurq.multidatasource.enumuration.RoutingStategyEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author liurq
 * @desc
 * @date 2021-11-02  21:30
 */
@Data
@ConfigurationProperties(prefix = "liurq.dsroutingset")
public class DsRoutingSetProperties {

    /**
     * 数据库数量 默认为1个
     */
    private Integer dataSourceNum = 1;


    /**
     * 每一个数据库对应的表的数量 默认为1
     */
    private Integer tableNum = 1;


    /**
     * 路由字段，必须配置
     */
    private String routingFiled;

    /**
     * 所有数据库集合
     */
    private Map<Integer, String> dataSourceKeysMapping;

    /**
     * 表的后缀连接风格 ，比如 order_
     */
    private String tableSuffixConnect = "_";

    /**
     * 表的索引值，格式化为四位，与tableSuffixConnect拼接成一个完整的表名，
     * 比如：order表，索引为1 ，数据库表完整名称为：order_0001
     */
    private String tableSuffixStyle = "%04d";


    /**
     * 默认的路由策略 多库多表
     */
    private String routingStategy = RoutingStategyEnum.ROUTING_DS_TABLE_STATEGY.getCode();

}
