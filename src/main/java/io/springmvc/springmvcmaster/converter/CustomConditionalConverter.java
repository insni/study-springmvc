package io.springmvc.springmvcmaster.converter;

import io.springmvc.springmvcmaster.annotation.CustomAnnotation;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;

public class CustomConditionalConverter implements ConditionalConverter {
      @Override
      public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
            // 타겟 필드에 @CustomAnnotation 주석이 있는지 확인
            return targetType.getAnnotation(CustomAnnotation.class) != null;
      }
}
