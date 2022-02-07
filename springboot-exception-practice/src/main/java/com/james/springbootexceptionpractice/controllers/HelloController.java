package com.james.springbootexceptionpractice.controllers;

import com.james.springbootexceptionpractice.exceptions.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

      @ExceptionHandler(CustomException.class)
      public String customEx(CustomException ex){
            return ex.getMessage();
      }

      @GetMapping("/hello")
      public String hello(){
            throw new CustomException("컨트롤러에서 에러 발생");
//            return "hello";
      }
}
