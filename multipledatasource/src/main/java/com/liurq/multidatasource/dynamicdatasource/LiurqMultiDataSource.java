package com.liurq.multidatasource.dynamicdatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author liurq
 * @desc
 * @date 2021-11-02  21:44
 */
public class LiurqMultiDataSource extends AbstractRoutingDataSource {

    /**
     * 加载所有数据源key
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return MultiDataSourceHolder.getDataSourceKey();
    }
}
