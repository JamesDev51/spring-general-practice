package com.james.springbeanpractice;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {
      public JdbcConnection() {
            System.out.println("JDBC Connection");
      }
}
