package com.liurq.multidatasource.dynamicdatasource;

/**
 * @author liurq
 * @desc 多数据源key 缓存类
 * @date 2021-11-02  21:48
 */
public class MultiDataSourceHolder {

    private static final ThreadLocal<String> dataSourceHoler = new ThreadLocal<>();

    private static final ThreadLocal<String> tableIndexHolder = new ThreadLocal<>();

    /**
     * 保存数据源key
     *
     * @param dsKey
     */
    public static void setDataSourceKey(String dsKey) {
        dataSourceHoler.set(dsKey);
    }

    /**
     * 从数据源中取出key
     *
     * @return
     */
    public static String getDataSourceKey() {
        return dataSourceHoler.get();
    }

    /**
     * 清楚所有key
     */
    public static void clearDataSourceKey() {
        dataSourceHoler.remove();
    }

    /**
     * 获取所有表索引key
     *
     * @return
     */
    public static String getTableIndex() {
        return tableIndexHolder.get();
    }

    /**
     * 设置表索引key
     *
     * @param tableIndex
     */
    public static void setTableIndex(String tableIndex) {
        tableIndexHolder.set(tableIndex);
    }

    /**
     * 清楚所有表索引key
     */
    public static void clearTableIndex() {
        tableIndexHolder.remove();
    }

}
