package com.james.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name="person")
public class Person {

      @Id
      @GeneratedValue
      private int id;

      @Column(name="name")
      private String name;
      private String location;
      private Date birthDate;

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getLocation() {
            return location;
      }

      public void setLocation(String location) {
            this.location = location;
      }

      public Date getBirthDate() {
            return birthDate;
      }

      public void setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
      }

      public Person() {
      }

      public Person(String name, String location, Date birthDate) {
            this.name = name;
            this.location = location;
            this.birthDate = birthDate;
      }

      @Override
      public String toString() {
            return "\nPerson{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", location='" + location + '\'' +
                        ", birthDate=" + birthDate +
                        '}' ;
      }
}
