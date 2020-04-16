package com.cv.mycar.conf.aop;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author shimengqiang
 * @Date 2020-04-16-15:31
 * @Version 1.0
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Limit {
    int limit() default 5;
    int sec() default 5;
}
