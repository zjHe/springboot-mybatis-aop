package org.spring.springboot.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 数据库路由
 * @author hezijian
 *
 */
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource{


	@Override
	protected Object determineCurrentLookupKey() {
		String typeKey = DataSourceContextHolder.getDataSource();
        return typeKey;
	}

}
