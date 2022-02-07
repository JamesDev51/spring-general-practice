package com.james.springbootexceptionpractice.exceptions;

import java.util.Map;

public class CustomException2 extends RuntimeException{
      private Map<String,String> errorMap;

      public CustomException2(String message) {
            super(message);
      }

      public CustomException2(String message, Map<String, String> errorMap) {
            super(message);
            this.errorMap = errorMap;
      }

      public Map<String, String> getErrorMap() {
            return errorMap;
      }
}
