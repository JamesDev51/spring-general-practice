package com.james.springbeanpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBeanPracticeApplication {

      private static Logger logger = LoggerFactory.getLogger(SpringBeanPracticeApplication.class);

      public static void main(String[] args) {
            AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(SpringBeanPracticeApplication.class);
            PersonDAO personDao = applicationContext.getBean(PersonDAO.class);
            PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);

            logger.info("personDao : {}",personDao);
            logger.info("personDao Jdbc : {}",personDao.getJdbcConnection());
            logger.info("personDao2 : {}",personDao2);
            logger.info("personDao2 Jdbc : {}",personDao2.getJdbcConnection());

      }

}
