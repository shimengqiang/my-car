package com.cv.mycar.conf.interceptor;

import com.cv.mycar.conf.aop.Limit;
import com.cv.mycar.exception.MyException;
import com.cv.mycar.exception.MyStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author shimengqiang
 * @Date 2020-04-16-14:54
 * @Version 1.0
 */
@Component
public class AccessLimitInterceptor implements HandlerInterceptor {
    private final static Logger log = LoggerFactory.getLogger(AccessLimitInterceptor.class);
    @Autowired
    private RedisTemplate<String, Object>  redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        log.info("preHandle");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (!method.isAnnotationPresent(Limit.class)) {
                return true;
            }
            Limit accessLimit = method.getAnnotation(Limit.class);
            if (accessLimit == null) {
                return true;
            }
            int limit = accessLimit.limit();
            int sec = accessLimit.sec();
//            String key = IPUtil.getIpAddr(request) + request.getRequestURI();
            String key =   request.getRequestURL() .toString();
            Integer maxLimit = (Integer) redisTemplate.opsForValue().get(key);
            if (maxLimit == null) {
                redisTemplate.opsForValue().set(key, 1, sec, TimeUnit.SECONDS);
            } else if (maxLimit < limit) {
                redisTemplate.opsForValue().set(key, maxLimit + 1, sec, TimeUnit.SECONDS);
            } else {
                throw new MyException("请求太频繁");
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
        request.setAttribute("endTime", System.currentTimeMillis());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            log.info("afterCompletion");
            long startTime = (long)request.getAttribute("startTime");
            long endTime = (long)request.getAttribute("endTime");
            log.info("URL {}, 耗时 {} 毫秒", request.getRequestURL(), (endTime - startTime));
    }
}
    