package com.cv.mycar;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author shimengqiang
 * @Date 2020-04-14-18:18
 * @Version 1.0
 */
@SpringBootApplication
@EnableDubboConfiguration
@ServletComponentScan("com.cv.mycar.conf.filter")
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
    