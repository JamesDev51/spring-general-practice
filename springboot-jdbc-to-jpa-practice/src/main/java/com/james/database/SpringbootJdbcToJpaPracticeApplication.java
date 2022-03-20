package com.james.database;

import com.james.database.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJdbcToJpaPracticeApplication implements CommandLineRunner {

      private Logger logger = LoggerFactory.getLogger(this.getClass());

      @Autowired
      PersonJdbcDAO dao;

      public static void main(String[] args) {
            SpringApplication.run(SpringbootJdbcToJpaPracticeApplication.class, args);
      }

      @Override
      public void run(String... args) throws Exception {
            logger.info("All users -> {}",dao.findAll());
      }
}
