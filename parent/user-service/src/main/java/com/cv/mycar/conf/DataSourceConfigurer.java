package com.cv.mycar.conf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author smq
 */
@Configuration
public class DataSourceConfigurer {
    @Bean
    public DataSource dataSource(Environment environment) {
        return DruidDataSourceBuilder
            .create()
            .build(environment, "spring.datasource.druid.");
    }
}
