package com.liurq.multidatasource.core;

/**
 * @author liurq
 * @desc 路由接口
 * @date 2021-11-02  21:21
 */
public interface IRouting {

    /**
     * 根据规则计算出路由key
     *
     * @param routingFiled
     * @return
     * @throws Exception
     */
    String calDataSourceKey(String routingFiled) throws Exception;


    /**
     * 计算路由字段的hashCode
     *
     * @param routingFiled
     * @return
     */
    Integer getRoutingFileHashCode(String routingFiled);

    /**
     * 计算数据表在库中的位置值
     *
     * @param routingFiled
     * @return
     */
    String calTableKey(String routingFiled);

    /**
     * 生成表后缀名
     *
     * @param tableIndex
     * @return
     */
    String getFormatTableSuffix(Integer tableIndex);

}
