package com.james.springbootexceptionpractice.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

      @ExceptionHandler(CustomException.class)
      public String CustomException(CustomException ex){
            return ex.getMessage();
      }
      @ExceptionHandler(CustomException2.class)
      public String CustomException2(CustomException2 ex){
            return ex.getMessage();
      }
}