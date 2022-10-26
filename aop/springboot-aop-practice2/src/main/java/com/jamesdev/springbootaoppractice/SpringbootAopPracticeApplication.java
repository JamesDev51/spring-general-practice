package com.jamesdev.springbootaoppractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringbootAopPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopPracticeApplication.class, args);
    }

//    public FilterRegistrationBean setFilterRegistration(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new My)
//    }
}
