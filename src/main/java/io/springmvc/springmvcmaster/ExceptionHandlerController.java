package io.springmvc.springmvcmaster;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


//우선 순위에 따른 예외 처리
// 예외가 발생했을 때 자식 클래스 예외 처리 메서드는
// 항상 상위 클래스 예외 처리 메서드보다 우선적으로 호출된다
//• 즉 구체적인 예외 클래스가 선언된 @ExceptionHandler 가
// 우선적으로 호출되며 덜 구체적인 예외 처리 메서드는 그 다음 순위로 처리된다
@RestController
public class ExceptionHandlerController {
      @GetMapping("/name")
      public String handlePriority(@RequestParam(required = false, value = "name") String name) {
            if ("child1".equals(name)) {
//           @ExceptionHandler(ChildException1.class) 메서드 호출
                  throw new ChildException1("child1 exception");
            } else if ("child2".equals(name)) {
//            @ExceptionHandler(ParentException.class) 메서드 호출
                  throw new ChildException2("child2 exception");
            }
//       @ExceptionHandler(ParentException.class) 메서드 호출
            throw new ParentException("parent exception");
      }

      @ExceptionHandler(ChildException1.class) // 보다 구체적인 예외를 먼저 처리
      public Map<String,String> handleChildException1(ChildException1 ex) {
            return Map.of("cause","child1 exception");
      }

      @ExceptionHandler(ParentException.class)
//   상위 클래스인 ParentException 은 마지막에 처리
      public Map<String, String> handleParentException(ParentException ex) {
            return Map.of("cause","parent exception");
      }

//   여러 개의 예외를 지정
      @ExceptionHandler({IllegalArgumentException.class,
      IllegalStateException.class,
      IllegalAccessError.class})
      public Map<String, String> handleIllegalException(Exception ex) {
           return Map.of("cause","illegal exception");
      }


}
