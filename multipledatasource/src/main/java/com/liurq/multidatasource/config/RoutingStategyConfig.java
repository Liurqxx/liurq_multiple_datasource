package com.liurq.multidatasource.config;

import com.liurq.multidatasource.core.IRouting;
import com.liurq.multidatasource.core.RoutingDsAndTbStrategy;
import com.liurq.multidatasource.core.RoutingDsStrategy;
import com.liurq.multidatasource.core.RoutingTbStategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liurq
 * @desc 路由策略配置, 根据配置文件选择对应的策略生效
 * @date 2021-11-03  21:53
 */
@Configuration
public class RoutingStategyConfig {

    @Bean
    @ConditionalOnProperty(prefix = "liurq.dsroutingset", name = "routingStategy", havingValue = "ROUTING_DS_TABLE_STATEGY")
    public IRouting routingDsAndTbStrategy() {
        return new RoutingDsAndTbStrategy();
    }

    @Bean
    @ConditionalOnProperty(prefix = "liurq.dsroutingset", name = "routingStategy", havingValue = "ROUTING_DS_STATEGY")
    public IRouting routingDsStrategy() {
        return new RoutingDsStrategy();
    }

    @Bean
    @ConditionalOnProperty(prefix = "liurq.dsroutingset", name = "routingStategy", havingValue = "ROUTING_TABLE_STATEGY")
    public IRouting routingTbStrategy() {
        return new RoutingTbStategy();
    }

}
