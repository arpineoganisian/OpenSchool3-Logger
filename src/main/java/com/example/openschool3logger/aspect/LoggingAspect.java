package com.example.openschool3logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {
    static final Logger log = LogManager.getLogger(LoggingAspect.class.getName());

    // все public методы OrderService с любым типом возврата * и количеством аргументов (..)
    @Pointcut("execution(public * com.example.openschool3logger.service.*.*(..))")
    public void callAtOrderServicePublic() {}

    @Before("callAtOrderServicePublic()")
    public void beforeCall(JoinPoint joinPoint) {
        String args = Arrays
                .stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("before " + joinPoint + ", args=[" + args + "]");
    }

    @After("callAtOrderServicePublic()")
    public void afterCall(JoinPoint joinPoint) {
        log.info("after " + joinPoint.toString());
    }
}
