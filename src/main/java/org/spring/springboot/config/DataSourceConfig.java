package org.spring.springboot.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据源配置
 */
@Configuration
public class DataSourceConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${datasource.type}")
    private Class<? extends DataSource> dataSourceType;


    //写 - 数据源
    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.write")
    public DataSource writeDataSource() {
        logger.info("-------------------- writeDataSource init ---------------------");
        System.out.println(dataSourceType);
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    //读 - 数据源
    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.read")
    public DataSource readDataSource() {
        logger.info("-------------------- readDataSourceOne init ---------------------");
        System.out.println(dataSourceType);
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "readDataSources")
    public List<DataSource> readDataSources() {
        List<DataSource> dataSources = new ArrayList<DataSource>();
        dataSources.add(readDataSource());
        return dataSources;
    }

}
