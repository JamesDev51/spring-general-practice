package com.jamesdev.aop.web.config;

import com.jamesdev.aop.web.domain.CommonDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Component
@Aspect
public class BidingAop {

    private static final Logger logger = LoggerFactory.getLogger(BidingAop.class);

    @Around("execution(* com.jamesdev.aop.web.controller..*Controller.*(..))")
    public Object validCheck(ProceedingJoinPoint pj) throws Throwable{
        String type = pj.getSignature().getDeclaringTypeName();
        String method = pj.getSignature().getName();

        logger.info("type : {}",type);
        logger.info("method : {}",method);

        Object[] args = pj.getArgs();
        logger.info("args : {}", Arrays.toString(args));
        for(Object arg: args){
            if(arg instanceof BindingResult){
                BindingResult bindingResult =(BindingResult) arg;

                if(bindingResult.hasErrors()){
                    Map<String,String> errorMap= new HashMap<>();
                    for (FieldError fieldError : bindingResult.getFieldErrors()) {
                        errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());

                        logger.warn("{}.{}() => 필드 : {}, 메시지 : {}",type,method,fieldError.getField(),fieldError.getDefaultMessage());


                    }
                    return new ResponseEntity<>(new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap), HttpStatus.BAD_REQUEST);
                }
            }
        }
        return pj.proceed(); //함수의 스택을 실행해라
    }
}

