package org.spring.springboot.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default DataSource.write;
    public static String write = "writeDataSource";
    public static String read = "readDataSource";
}
