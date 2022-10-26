package com.jamesdev.aop.web.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    public String wrongRequest(IllegalArgumentException e){
        return e.getMessage();
    }
}
