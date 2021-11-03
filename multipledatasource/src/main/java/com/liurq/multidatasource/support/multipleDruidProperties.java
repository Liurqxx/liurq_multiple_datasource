package com.liurq.multidatasource.support;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liurq
 * @desc
 * @date 2021-11-03  21:45
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class multipleDruidProperties {

    private String druid00username;
    private String  druid00passwrod;
    private String druid00jdbcUrl;
    private String druid00driverClass;

    private String druid01username;
    private String  druid01passwrod;
    private String druid01jdbcUrl;
    private String druid01driverClass;

    private String druid02username;
    private String  druid02passwrod;
    private String druid02jdbcUrl;
    private String druid02driverClass;

}
