package org.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hezijian
 */
@RestController
public class CityRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    @ResponseBody
    public City findOneCity(City city) {
        logger.info("hello");
        return city;
    }

    @RequestMapping(value = "/api/city/insert", method = RequestMethod.GET)
    @ResponseBody
    public String insert(City city) {
        try{
            cityService.insertCity(city);
        }catch (Exception e){
            return e.getMessage();
        }
        return "插入成功";
    }

}
