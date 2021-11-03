package com.liurq.multidatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.liurq.multidatasource.dynamicdatasource.LiurqMultiDataSource;
import com.liurq.multidatasource.support.DsRoutingSetProperties;
import com.liurq.multidatasource.support.MultipleDruidProperties;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author liurq
 * @desc 多数据源配置
 * @date 2021-11-03  21:54
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({DsRoutingSetProperties.class, MultipleDruidProperties.class})
@MapperScan(basePackages = "com.liurq.busi.dao")
public class DataSourceConfig {


    @Autowired
    private DsRoutingSetProperties dsRoutingSetProperties;

    @Autowired
    private MultipleDruidProperties multipleDruidProperties;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid00")
    public DataSource dataSource00() {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(multipleDruidProperties.getDruid00username());
        druidDataSource.setPassword(multipleDruidProperties.getDruid00passwrod());
        druidDataSource.setUrl(multipleDruidProperties.getDruid00jdbcUrl());
        druidDataSource.setDriverClassName(multipleDruidProperties.getDruid00driverClass());
        return druidDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid01")
    public DataSource dataSource01() {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(multipleDruidProperties.getDruid01username());
        druidDataSource.setPassword(multipleDruidProperties.getDruid01passwrod());
        druidDataSource.setUrl(multipleDruidProperties.getDruid01jdbcUrl());
        druidDataSource.setDriverClassName(multipleDruidProperties.getDruid01driverClass());
        return druidDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid02")
    public DataSource dataSource02() {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(multipleDruidProperties.getDruid02username());
        druidDataSource.setPassword(multipleDruidProperties.getDruid02passwrod());
        druidDataSource.setUrl(multipleDruidProperties.getDruid02jdbcUrl());
        druidDataSource.setDriverClassName(multipleDruidProperties.getDruid02driverClass());
        return druidDataSource;
    }

    @Bean("liurqMultiDataSource")
    public LiurqMultiDataSource dataSource() {

        LiurqMultiDataSource liurqMultiDataSource = new LiurqMultiDataSource();

        HashMap<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("dataSource00", dataSource00());
        targetDataSource.put("dataSource01", dataSource01());
        targetDataSource.put("dataSource02", dataSource02());

        liurqMultiDataSource.setTargetDataSources(targetDataSource);
        //设置默认数据源
        liurqMultiDataSource.setDefaultTargetDataSource(dataSource00());


    }


}
