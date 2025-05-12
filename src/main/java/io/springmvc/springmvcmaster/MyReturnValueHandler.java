package io.springmvc.springmvcmaster;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

public class MyReturnValueHandler implements  HandlerMethodReturnValueHandler{
      @Override
      public boolean supportsReturnType(MethodParameter returnType) {
            return returnType.getParameterType().equals(String.class)
                        ||  Map.class.isAssignableFrom(returnType.getParameterType());
      }

      @Override
      public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
            if (returnValue != null) {
                  if (returnValue instanceof Map) {
                        Map<?, ?> map = (Map<?, ?>) returnValue;
                        // 모든 key가 String인지 확인
                        boolean allKeysAreStrings = map.keySet().stream().allMatch(key -> key instanceof String);

                        if (!allKeysAreStrings) {
                              throw new IllegalArgumentException("Map keys must be of type String.");
                        }

                        // 안전하게 Map<String, ?>로 변환
                        @SuppressWarnings("unchecked")
                        Map<String, ?> stringKeyedMap = (Map<String, ?>) map;
                        mavContainer.addAllAttributes(stringKeyedMap);

                  } else {
                        // String 타입 처리
                        mavContainer.addAttribute("result", returnValue);
                  }
            }
      }

}
