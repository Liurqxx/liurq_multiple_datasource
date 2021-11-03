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
        return null;
    }

    /**
     * 配置检查
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
