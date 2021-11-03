package com.liurq.multidatasource.core;

/**
 * @author liurq
 * @desc 路由策略 多库多表
 * @date 2021-11-03  21:29
 */
public class RoutingDsAndTbStrategy extends AbstractRouting {

    /**
     * 计算数据库key
     *
     * @param routingFiled
     * @return
     * @throws Exception
     */
    @Override
    public String calDataSourceKey(String routingFiled) throws Exception {
        return null;
    }

    /**
     * 计算数据库表key
     *
     * @param routingFiled
     * @return
     */
    @Override
    public String calTableKey(String routingFiled) {
        return null;
    }
}
