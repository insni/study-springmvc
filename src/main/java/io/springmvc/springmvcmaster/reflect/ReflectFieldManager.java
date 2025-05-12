package io.springmvc.springmvcmaster.reflect;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class ReflectFieldManager {
      final Map<String, Field> fields = new HashMap<>();


      public ReflectFieldManager(Class<?> clazz) {

            this.fields.putAll(Arrays.stream(clazz.getDeclaredFields())
                        .peek(f -> f.setAccessible(true)) // 필드 접근 가능 설정
                        .collect(Collectors.toMap(Field::getName, f -> f)));

      }

      public Field getField(String fieldName) {
            return fields.entrySet().stream().filter(e -> e.getKey().equals(fieldName))
                        .findAny().get().getValue();
      }

      public void setField(Object target,
                           String fieldName,
                           Object value) throws IllegalAccessException {
            Field field = getField(fieldName);
            if (field == null) return;
            field.set(target, value);

      }


      public Object getFieldValue(Object target,
                                  String fieldName) throws IllegalAccessException {

            Field field = getField(fieldName);
            if (field == null) return Optional.empty();
           return field.get(target);
      }
}


