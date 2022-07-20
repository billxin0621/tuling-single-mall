package com.tulingxueyuan.mall.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面：根据注解拦截所有Controller的请求
 */
@Slf4j
@Component
@Aspect
public class WebLogInterceptor {

    /** 拦截所有controller的请求-切面 */
    @Pointcut("@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)")
    public void webLog() {}

    /** 执行拦截前后的逻辑 */
    @Around("webLog()")
    public Object doAround(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        long startTime = System.currentTimeMillis();
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        try {
            log.info("请求Controller||开始||{}||-||{}", request.getRequestURL().toString(), Arrays.toString(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
        } catch (Exception e){
            log.error("URL:{}, error_Time-执行时间:{} ms", request.getRequestURL().toString(), System.currentTimeMillis() - startTime);
            throw e;
        }
        log.info("URL:{}, Time-执行时间:{} ms", request.getRequestURL().toString(), System.currentTimeMillis() - startTime);
        return result;
    }
}
