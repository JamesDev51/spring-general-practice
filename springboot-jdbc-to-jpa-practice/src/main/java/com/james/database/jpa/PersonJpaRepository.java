package com.james.database.jpa;

import com.james.database.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonJpaRepository {

      // connect to the database
      @PersistenceContext
      EntityManager entityManager;

      public Person findById(int id){
            return entityManager.find(Person.class,id); //JPA
      }

      public Person update(Person person){
            return entityManager.merge(person);
      }

}
