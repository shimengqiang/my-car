package com.cv.mycar.conf.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author shimengqiang
 * @Date 2020-04-16-14:56
 * @Version 1.0
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "MyFilter")
public class MyFilter implements Filter {

    private final static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        log.info("MyFilter 过滤 request");
        //执行下一个过滤器或业务代码
        chain.doFilter(request, response);
        log.info("MyFilter 处理 response");
        log.info("IP {}, 耗时 {} 毫秒", request.getRemoteHost(), (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {

    }
}
    