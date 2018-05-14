package org.spring.springboot.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.spring.springboot.annotation.DataSource;
import org.spring.springboot.domain.City;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@Aspect
@Component
public class DataSourceAop {

    @Pointcut("@annotation(org.spring.springboot.annotation.DataSource)")
    public void executeService() {

    }

    @Before("executeService()")
    public void setDataSourceType(JoinPoint point) {
        try{
            Signature signature = point.getSignature();
            MethodSignature methodSignature = (MethodSignature)signature;
            Method targetMethod = methodSignature.getMethod();
            DataSource dataSource = targetMethod.getAnnotation(DataSource.class);
            System.out.println("此时的数据源 --->> " + dataSource.value() );
            System.out.println("前置通知");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
