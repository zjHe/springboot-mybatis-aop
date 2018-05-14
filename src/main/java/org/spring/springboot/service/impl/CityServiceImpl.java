package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.annotation.DataSource;
import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by hezijian
 */
@Service
public class CityServiceImpl implements CityService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @DataSource("writeDataSource")
    @Transactional
    public void insertCity(City city) throws Exception {
        int res = cityDao.insert(city);
        if (res == 0) {
            logger.info("插入城市数据失败");
            throw new Exception("插入失败");
        }
    }

}
