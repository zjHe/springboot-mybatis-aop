package org.spring.springboot.dao;

import org.spring.springboot.domain.City;

/**
 * 城市 DAO 接口类
 *
 * Created by hezijian
 */
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(String cityName);

    int insert (City city);
}
