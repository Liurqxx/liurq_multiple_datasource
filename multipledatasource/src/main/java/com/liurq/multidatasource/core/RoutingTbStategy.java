package com.liurq.multidatasource.core;

/**
 * @author liurq
 * @desc 路由策略 一库多表
 * @date 2021-11-03  21:30
 */
public class RoutingTbStategy extends AbstractRouting {
    @Override
    public String calDataSourceKey(String routingFiled) throws Exception {
        return null;
    }

    @Override
    public String calTableKey(String routingFiled) {
        return null;
    }
}
