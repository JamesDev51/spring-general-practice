package com.jamesdev.aop.local;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect //AOP 사용
//@Component //빈 등록
public class CalculatorAspect {

    @Pointcut("execution(* com.jamesdev.aop.*.*(..))") //aop 패키지 안에 있는 모든 메서드
    public void allMethod(){}

    @Pointcut("execution(* com.jamesdev.aop.local.*.*(..))") //local 패키지 안에 있는 모든 메서드
    public void localPackage(){}

    @Pointcut("execution(* com.jamesdev.aop.local.MyCalculator.*(..))")
    public void localMyCalculator(){}

    private static final Logger logger = LoggerFactory .getLogger(CalculatorAspect.class);


    @Before(value ="localMyCalculator()")
    public void beforeLog(JoinPoint joinPoint){
        logger.info("### "+joinPoint.getSignature().getName() + " : before execute");
    }

    @AfterReturning(value = "localMyCalculator())")
    public void afterReturning(JoinPoint jointPoint){
        logger.info("### "+jointPoint.getSignature().getName() + " : after returning execute");
    }
    @AfterThrowing(value = "localMyCalculator())",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        logger.info("### "+joinPoint.getSignature().getName()+" : after throwing execute");
        logger.info("### "+e.getMessage()+" : exception occurred");
    }
//
//    @Around("execution(* com.jamesdev.aop.local.MyCalculator.*(..))")
//    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        logger.info("### "+proceedingJoinPoint.getSignature().getName() +" : before around execute");
//        try{
//            Object result = proceedingJoinPoint.proceed();
//            logger.info("This is the result : "+result.toString());
//            return result;
//        }finally {
//            logger.info("### "+proceedingJoinPoint.getSignature().getName()+" : after around execute");
//        }
//    }


}
