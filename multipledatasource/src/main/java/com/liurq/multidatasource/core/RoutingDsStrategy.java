package com.liurq.multidatasource.core;

/**
 * @author liurq
 * @desc 路由策略 多库一表
 * @date 2021-11-03  21:30
 */
public class RoutingDsStrategy extends AbstractRouting {
    @Override
    public String calDataSourceKey(String routingFiled) throws Exception {
        return null;
    }

    @Override
    public String calTableKey(String routingFiled) {
        return null;
    }
}
