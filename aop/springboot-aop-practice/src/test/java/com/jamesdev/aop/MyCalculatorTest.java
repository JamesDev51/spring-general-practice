package com.jamesdev.aop;

import com.jamesdev.aop.local.MyCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MyCalculatorTest {

    @Autowired
    private MyCalculator myCalculator;

    private static final Logger logger = LoggerFactory.getLogger(MyCalculatorTest.class);

    @Test
    public void addTest(){
        System.out.println(myCalculator.add(5,5));
    }
    @Test
    public void subTest(){
        System.out.println(myCalculator.sub(5,3));
    }
    @Test
    public void divTest(){
        System.out.println(myCalculator.div(5,2));
    }
    @Test
    public void mulTest(){
        System.out.println(myCalculator.mul(5,5));
    }

}