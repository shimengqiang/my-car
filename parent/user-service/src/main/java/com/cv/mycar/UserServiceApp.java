package com.cv.mycar;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shimengqiang
 * @Date 2020-04-14-15:54
 * @Version 1.0
 */
@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("com.cv.mycar.dao.mapper")
public class UserServiceApp {

    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        SpringApplication.run(UserServiceApp.class,args);
    }


}
    