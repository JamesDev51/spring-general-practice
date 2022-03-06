package com.jamesdev.aop.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyCalculator {
    private static final Logger logger = LoggerFactory.getLogger(MyCalculator.class);

    @TrackTime
    public int add(int a, int b){
        logger.info("####### add method 실행######");
        return a+b;
    }
    public int sub(int a, int b){
        logger.info("####### sub method 실행#######");
        return a-b;
    }

    @TrackTime
    public int div(int a, int b){
        logger.info("####### div method 실행 #######");
        return a/b;
    }
    public int mul(int a, int b){
        logger.info("####### mul method 실행 #######");
        return a*b;
    }

}
