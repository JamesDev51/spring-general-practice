package com.james.jpa.hibernate;

import  static org.junit.jupiter.api.Assertions.*;
import com.james.jpa.hibernate.entity.Course;
import com.james.jpa.hibernate.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringJpaHibernatePracticeApplication.class)
public class CourseRepositoryTest {

      private Logger logger = LoggerFactory.getLogger(this.getClass());

      @Autowired
      CourseRepository repository;

      @Test
      public void findById_basic(){
            Course course =repository.findById(10001L);
            assertEquals("JPA in 50 Steps", course.getName());
      }
      @Test
      public void deleteById_basic(){
            repository.deleteById(10002L);
//            assertNull(repository.findById(10002L));
      }

}
