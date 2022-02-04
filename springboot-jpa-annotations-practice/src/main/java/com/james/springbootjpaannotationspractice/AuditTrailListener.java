package com.james.springbootjpaannotationspractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AuditTrailListener {
      private static Logger logger = LoggerFactory.getLogger(AuditTrailListener.class);

      @PrePersist
      @PreUpdate
      @PreRemove
      private void beforeAnyUpdate(User user){

      }
}
