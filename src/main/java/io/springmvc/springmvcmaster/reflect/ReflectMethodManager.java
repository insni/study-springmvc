package io.springmvc.springmvcmaster.reflect;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class ReflectMethodManager {
      private final Map<String, Method> methods=new HashMap<>();

      public ReflectMethodManager(Class<?> clazz) {
            Map<String, Method> collect = Arrays.stream(clazz.getDeclaredMethods())
                        .peek(m -> m.setAccessible(true))
                        .collect(Collectors.toMap(Method::getName, m -> m));
            this.methods.putAll(collect);

      }

      public Method getMethod(String methodName){
            return methods.get(methodName);
      }

      public Object invokeMethod(Object target,
                                 String methodName,
                                 Object... args) throws InvocationTargetException, IllegalAccessException {
            java.lang.reflect.Method method = getMethod(methodName);
            if (method == null) return Optional.empty();
            return method.invoke(target, args);
      }
}
