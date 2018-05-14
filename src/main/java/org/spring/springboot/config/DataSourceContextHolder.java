package org.spring.springboot.config;

import org.apache.log4j.Logger;

/**
 * 一个决策器-----> 利用ThreadLocal来获取线程池中的   读数据库  还是   写数据库  
 * @author hezijian
 *
 */
public class DataSourceContextHolder {


    public static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    public static void setDataSource(String dataSourceName) {
        dataSources.set(dataSourceName);
    }

    public static String getDataSource() {
        return (String)dataSources.get();
    }

    public static void clear() {
        dataSources.remove();
    }
}
