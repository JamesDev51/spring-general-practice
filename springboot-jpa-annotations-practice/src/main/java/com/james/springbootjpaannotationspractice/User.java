package com.james.springbootjpaannotationspractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
public class User {

      private static Logger logger = LoggerFactory.getLogger(User.class);

      @Id
      @GeneratedValue
      private int id;

      private String userName;
      private String firstName;
      private String lastName;
      @Transient
      private String fullName;

      @PrePersist
      public void logNewUserAttempt(){
            logger.info("새로운 유저가 생성되기 이전. userName : "+userName);
      }

      @PostPersist
      public void logNewUserAdded(){
            logger.info("새로운 유저가 생성되었음. userName : "+userName);
      }

      @PreRemove
      public void logUserRemovalAttempt(){
            logger.info("유저가 삭제되기 이전. userName : "+userName);
      }

      @PostRemove
      public void logUserRemoval(){
            logger.info("유저가 삭제되었음. userName : "+userName);
      }

      @PreUpdate
      public void logUserUpdateAttempt(){
            logger.info("유저가 업데이트 되기 이전. userName : "+userName);
      }

      @PostUpdate
      public void logUserUpdate(){
            logger.info("유저가 업데이트 되었음. userName : "+userName);
      }

      @PostLoad
      public void logUserLoad(){
            //db에는 fullName이 들어가지 않지만 사용하기 위해 select시 만들어줌
            fullName = firstName + " "+lastName;
      }
}
