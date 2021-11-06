package com.liurq.multidatasource.core;

import com.liurq.multidatasource.dynamicdatasource.MultiDataSourceHolder;

/**
 * @author liurq
 * @desc 路由策略 一库多表
 * @date 2021-11-03  21:30
 */
public class RoutingTbStategy extends AbstractRouting {


    /**
     * 计算数据源key
     *
     * @param routingFiled
     * @return
     * @throws Exception
     */
    @Override
    public String calDataSourceKey(String routingFiled) throws Exception {
        String dataSourceKey = null;
        //路由key的hashCode
        Integer routingFileHashCode = getRoutingFileHashCode(routingFiled);
        //计算数据库索引值
        Integer dsIndex = routingFileHashCode % getDsRoutingSetProperties().getDataSourceNum();

        //根据索引值得到对应的数据源
        dataSourceKey = getDsRoutingSetProperties().getDataSourceKeysMapping().get(dsIndex);

        //加入线程变量中
        MultiDataSourceHolder.setDataSourceKey(dataSourceKey);

        return dataSourceKey;
    }

    /**
     * 计算表后缀名
     *
     * @param routingFiled
     * @return
     */
    @Override
    public String calTableKey(String routingFiled) {

        //路由key的hashCode
        Integer routingFileHashCode = getRoutingFileHashCode(routingFiled);
        //计算表索引
        Integer tbIndex = routingFileHashCode % getDsRoutingSetProperties().getTableNum();

        //拼接后缀
        String tableSuffix = getFormatTableSuffix(tbIndex);
        MultiDataSourceHolder.setTableIndex(tableSuffix);
        return tableSuffix;
    }
}
