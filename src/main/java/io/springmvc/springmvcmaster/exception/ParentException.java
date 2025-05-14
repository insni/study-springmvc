package io.springmvc.springmvcmaster.exception;

// 부모 예외 클래스
public class ParentException extends RuntimeException {
      public ParentException(String message) {
            super(message);
      }
}