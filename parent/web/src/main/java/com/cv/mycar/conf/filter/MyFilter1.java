package com.cv.mycar.conf.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author smq
 */
//@Component
public class MyFilter1 implements Filter {
    private final static Logger log = LoggerFactory.getLogger(MyFilter1.class);

    @Override public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override public void doFilter(ServletRequest request, ServletResponse response,
                                   FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        log.info("MyFilter1 过滤 request");
        //执行下一个锅过滤器或业务代码
        chain.doFilter(request, response);
        log.info("MyFilter1 处理 response");
        log.info("IP {}, 耗时 {} 毫秒", request.getRemoteHost(), (System.currentTimeMillis() - start));

    }

    @Override public void destroy() {

    }
}
