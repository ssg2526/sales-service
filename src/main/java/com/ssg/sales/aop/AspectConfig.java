package com.ssg.sales.aop;

import com.ssg.sales.model.context.model.DBContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Order(1)
@Slf4j
public class AspectConfig {
    @Around("@annotation(" +
            "InboundRequest)")
    private Object tenantTypeAspect(ProceedingJoinPoint joinPoint) throws Throwable {
//        joinPoint.
        log.info("setting tenant to 1");
//        DBContext.setCurrentDBContext("1");
        try {
            return joinPoint.proceed();
        } finally {
            DBContext.clear();
        }
    }
}
