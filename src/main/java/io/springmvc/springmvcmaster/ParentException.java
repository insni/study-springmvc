package io.springmvc.springmvcmaster;

// 부모 예외 클래스
class ParentException extends RuntimeException {
      public ParentException(String message) {
            super(message);
      }
}