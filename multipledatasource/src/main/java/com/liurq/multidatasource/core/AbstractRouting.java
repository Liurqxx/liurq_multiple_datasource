package com.liurq.multidatasource.core;

import com.liurq.multidatasource.support.DsRoutingSetProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author liurq
 * @desc 路由公共方法
 * @date 2021-11-02  21:26
 */
@Slf4j
@Data
@EnableConfigurationProperties(value = {DsRoutingSetProperties.class})
public abstract class AbstractRouting implements IRouting, InitializingBean {

    @Autowired
    private DsRoutingSetProperties dsRoutingSetProperties;

    /**
     * 获取路由key的hashCode值
     *
     * @param routingFiled 路由key
     * @return
     */
    @Override
    public Integer getRoutingFileHashCode(String routingFiled) {

        return Math.abs(routingFiled.hashCode());
    }

    /**
     * 生成表的后缀名
     *
     * @param tableIndex
     * @return
     */
    @Override
    public String getFormatTableSuffix(Integer tableIndex) {

        StringBuffer stringBuffer = new StringBuffer(dsRoutingSetProperties.getTableSuffixConnect());

        try {
            stringBuffer.append(String.format(getDsRoutingSetProperties().getTableSuffixStyle(), tableIndex));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

    /**
     * 工程启动的时候，进行配置检查
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        switch (getDsRoutingSetProperties().getRoutingStategy()) {
            case "ROUTING_DS_TABLE_STATEGY":
                checkRoutingDsTableStategyConfig();
                break;
            case "ROUTING_DS_STATEGY":
                checkRoutingDsStategyConfig();
                break;
            case "ROUTING_TABLE_STATEGY":
                checkRoutingTableStategyConfig();
                break;
        }

    }

    /**
     * 多库多表配置检查
     */
    private void checkRoutingDsTableStategyConfig() {

        if (dsRoutingSetProperties.getTableNum() <= 1
                || dsRoutingSetProperties.getDataSourceNum() <= 1) {
            log.error("多库多表配置项有误.");
        }

    }

    /**
     * 多库一表配置检查
     */
    private void checkRoutingDsStategyConfig() {
        if (dsRoutingSetProperties.getTableNum() != 1
                || dsRoutingSetProperties.getDataSourceNum() <= 1) {
            log.error("多库一表配置项有误.");
        }
    }

    /**
     * 一库多表配置检查
     */
    private void checkRoutingTableStategyConfig() {
        if (dsRoutingSetProperties.getTableNum() <= 1
                || dsRoutingSetProperties.getDataSourceNum() != 1) {
            log.error("一库多表配置项有误.");
        }
    }

}
