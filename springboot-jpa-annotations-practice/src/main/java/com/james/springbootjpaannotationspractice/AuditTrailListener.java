package com.james.springbootjpaannotationspractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

public class AuditTrailListener {
      private static Logger logger = LoggerFactory.getLogger(AuditTrailListener.class);

      @PrePersist
      @PreUpdate
      @PreRemove
      private void beforeAnyUpdate(User user){
            logger.info("유저 엔티티에 생성, 업데이트, 삭제가 되기 전 userName : "+user.getUserName());
      }

      @PostPersist
      @PostUpdate
      @PostRemove
      private void afterAnyUpdate(User user){
            logger.info("유저 엔티티에 생성, 업데이트, 삭제가 된 후 userName : "+user.getUserName());
      }

      @PostLoad
      private void afterLoad(User user){
            logger.info("유저 엔티티가 로드 됨. userName : " +user.getUserName());
      }
}
