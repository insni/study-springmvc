package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.annotation.CustomAnnotation;
import io.springmvc.springmvcmaster.model.User;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;

public class StringToUserConditionalConverter implements Converter<String, User>,
            ConditionalConverter {
      @Override
      public User convert(String source) {
            User target = new User();
            target.setName(source);
            return target;
      }

      @Override
      public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
            boolean match = Arrays.stream(targetType.getAnnotations()).anyMatch(annotation ->
                        annotation instanceof CustomAnnotation);
            return match;
      }
}
