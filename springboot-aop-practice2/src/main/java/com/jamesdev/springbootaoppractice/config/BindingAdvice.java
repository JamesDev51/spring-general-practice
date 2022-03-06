package com.jamesdev.springbootaoppractice.config;

import com.jamesdev.springbootaoppractice.domain.CommonDto;
import io.sentry.Sentry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//@Controller 뜨고 @Component 뜸
//@Configuration -> @Controller 들어가기 전에 설정
@Component
@Aspect
public class BindingAdvice {

    private static final Logger log = LoggerFactory.getLogger(BindingAdvice.class);

//    @Before("execution(* com.jamesdev.springbootaoppractice.web..*Controller.*(..))")
//    public void testCheck(){
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        System.out.println("주소 : "+request.getRequestURI());
//        System.out.println("로그를 남겼습니다.");
//    }
//    @After("execution(* com.jamesdev.springbootaoppractice.web..*Controller.*(..))")
//    public void testCheck2(){
//        System.out.println("후처리 로그를 남겼습니다.");
//    }

    @Around("execution(* com.jamesdev.springbootaoppractice.web..*Controller.*(..))")
    public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String method = proceedingJoinPoint.getSignature().getName();

        System.out.println("type : " + type);
        System.out.println("method : " + method);

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {

            //서비스 : 정상적인 화면 => 사용자 요청

            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;

                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();
                    for (FieldError error : bindingResult.getFieldErrors()) {
                        errorMap.put(error.getField(), error.getDefaultMessage());

                        //로그레벨 error, warn, info, debug
                        log.warn(type+"."+method+"() => 필드 : "+error.getField()+", 메시지 : "+error.getDefaultMessage());
                        Sentry.captureMessage(type+"."+method+"() => 필드 : "+error.getField()+", 메시지 : "+error.getDefaultMessage());


                        //Exception은 에러 터졌을 때 던지기 => warn에 던지기에는 너무 김
//                        try {
//                            throw new Exception("This is a test.");
//                        } catch (Exception e) {
//                            Sentry.captureException(e);
//                        }
                        //DB연결 -> DB남기기
                        //File file = new File();


                        return new ResponseEntity<>(new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap), HttpStatus.BAD_REQUEST);
                    }
                }
            }
        }
        return proceedingJoinPoint.proceed(); //함수의 스택을 실행해라
    }
}
