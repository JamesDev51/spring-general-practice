package com.james.database;

import com.james.database.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringbootJdbcPracticeApplication implements CommandLineRunner {

      private Logger logger = LoggerFactory.getLogger(this.getClass());

      @Autowired
      PersonJdbcDAO dao;

      public static void main(String[] args) {
            SpringApplication.run(SpringbootJdbcPracticeApplication.class, args);
      }

      @Override
      public void run(String... args) throws Exception {
            logger.info("All users -> {}",dao.findAll());
            logger.info("User id 10001 -> {}",dao.findById(10001));
            logger.info("Deleting User id 10002 -> No of Rows Deleted - {}",dao.deleteById(10002));

//            logger.info("Inserting 10004 - {}",dao.insert(new Person(10004, "John","Berlin",new Date())));
//
//            logger.info("Updating 10003 - {}",dao.update(new Person(10003, "Tara", "NewYork",new Date())));

      }

}
