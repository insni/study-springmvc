package io.springmvc.springmvcmaster.validator;

import io.springmvc.springmvcmaster.model.Admin;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AdminValidator implements Validator {
      @Override
      public boolean supports(Class<?> clazz) {
            return Admin.class.isAssignableFrom(clazz);
      }
      @Override
      public void validate(Object target, Errors errors) {
            Admin admin = (Admin) target;
            // 공백 또는 빈 값 검증 유틸
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminName", "required",new Object[]{admin.getAdminName()},"어드민 이름을 필수로 입력하세요");
            if (admin. getAge() > 100)
                  errors.rejectValue("age", "max", new Object[]{100},"허용나이를 초과했습니다");

            // 글로벌 오류
            if ("admin".equals(admin.getAdminName()) && admin.getAge() < 20)
                  errors.reject("authority","어드민 권한없음");

      }
}

