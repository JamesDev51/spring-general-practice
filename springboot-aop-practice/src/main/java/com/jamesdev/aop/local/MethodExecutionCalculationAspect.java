package com.jamesdev.aop.local;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodExecutionCalculationAspect {

    private static final Logger logger= LoggerFactory.getLogger(MethodExecutionCalculationAspect.class);

    @Pointcut("@annotation(com.jamesdev.aop.local.TrackTime)")
    public void trackTimeAnnotation(){}


    @Around("trackTimeAnnotation()")
    public Object checkTime(ProceedingJoinPoint pj) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object result = pj.proceed();
        long timeTaken = System.currentTimeMillis()-startTime;
        System.out.println("time checker");
        logger.info("Time Taken by {} is {}",pj,timeTaken);
        return result;
    }
}
