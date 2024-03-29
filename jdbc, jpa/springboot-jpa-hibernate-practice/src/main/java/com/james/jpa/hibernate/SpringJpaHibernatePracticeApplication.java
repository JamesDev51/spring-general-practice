package com.james.jpa.hibernate;

import com.james.jpa.hibernate.entity.Course;
import com.james.jpa.hibernate.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaHibernatePracticeApplication implements CommandLineRunner {

      private Logger logger = LoggerFactory.getLogger(this.getClass());

      @Autowired
      private CourseRepository courseRepository;

      public static void main(String[] args) {
            SpringApplication.run(SpringJpaHibernatePracticeApplication.class, args);
      }

      @Override
      public void run(String... args) throws Exception {
            Course course=courseRepository.findById(10001L);
            logger.info("Course 10001 -> {}",course);

//            courseRepository.deleteById(10001L);
      }
}
