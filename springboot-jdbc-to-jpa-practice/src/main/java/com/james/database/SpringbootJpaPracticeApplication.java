package com.james.database;

import com.james.database.entity.Person;
import com.james.database.jdbc.PersonJdbcDAO;
import com.james.database.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringbootJpaPracticeApplication implements CommandLineRunner {

      private Logger logger = LoggerFactory.getLogger(this.getClass());

      @Autowired
      PersonJpaRepository repository;

      public static void main(String[] args) {
            SpringApplication.run(SpringbootJpaPracticeApplication.class, args);
      }

      @Override
      public void run(String... args) throws Exception {
            logger.info("User id 10001  -> {}",repository.findById(10001));
//            logger.info("User id 10001 -> {}",dao.findById(10001));
//            logger.info("Deleting User id 10002 -> No of Rows Deleted - {}",dao.deleteById(10002));

            logger.info("Inserting 10004 - {}",repository.update(new Person( "John","Berlin",new Date())));
//
            logger.info("Updating 10003 - {}",repository.update(new Person(10001, "Tara", "NewYork",new Date())));
            repository.deleteById(10002);
            logger.info("All users -> {}",repository.findAll());



      }

}
