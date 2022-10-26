package com.james.jpa.hibernate.entity;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

      @Id
      @GeneratedValue
      private Long id;

      private String name;

      protected Course() {
      }



      private Course(String name){
            this.name=name;
      }

      public Long getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      @Override
      public String toString() {
            return "Course{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
      }
}
