package com.tuomi.develop.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
@Aspect
public class TheLogger {
    private static final Logger log = LoggerFactory.getLogger(TheLogger.class);

    @Pointcut("execution(* com.tuomi.develop.service..*.*(..))")
    public void pointcut() {
    }
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，参数是："
                +Arrays.toString(jp.getArgs()));
        Object result;
        try {
            result = jp.proceed();//调用目标方法
            log.info("执行"+jp.getTarget()+"的"+jp.getSignature().getName()+
                    "方法完毕，返回值是"+result);
        } catch (Throwable e) {
            log.info(jp.getTarget()+"的"+jp.getSignature().getName()+"方法发生异常："
                    +e);
            throw e;
        }finally {
            log.info(jp.getTarget()+"的"+jp.getSignature().getName()+"最终执行完成");
        }
        return result;
    }
}
