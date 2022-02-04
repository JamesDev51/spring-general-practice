package com.james.springbeanpractice;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value= ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class JdbcConnection {
      public JdbcConnection() {
            System.out.println("JDBC Connection");
      }
}
