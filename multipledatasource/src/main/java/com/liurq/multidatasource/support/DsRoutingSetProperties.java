package com.liurq.multidatasource.support;

import com.liurq.multidatasource.constant.RoutingStategyConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author liurq
 * @desc
 * @date 2021-11-02  21:30
 */
@Configuration
@ConfigurationProperties(prefix = "liurq.dsroutingset")
public class DsRoutingSetProperties {

    /**
     * 数据库数量 默认为1个
     */
    @Getter
    @Setter
    public int dataSourceNum = 1;


    /**
     * 每一个数据库对应的表的数量 默认为1
     */
    @Getter
    @Setter
    public int tableNum = 1;


    /**
     * 路由字段，必须配置
     */
    @Getter
    @Setter
    public String routingFiled;

    /**
     * 所有数据库集合
     */
    @Getter
    @Setter
    public Map<Integer, String> dataSourceKeysMapping;

    /**
     * 表的后缀连接风格 ，比如 order_
     */
    @Getter
    @Setter
    public String tableSuffixConnect = "_";

    /**
     * 表的索引值，格式化为四位，与tableSuffixConnect拼接成一个完整的表名，
     * 比如：order表，索引为1 ，数据库表完整名称为：order_0001
     */
    @Getter
    @Setter
    public String tableSuffixStyle = "%04d";


    /**
     * 默认的路由策略 多库多表
     */
    @Getter
    @Setter
    public String routingStategy = RoutingStategyConstant.ROUTING_DS_TABLE_STATEGY;

}
