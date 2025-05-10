package io.springmvc.springmvcmaster.validator;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
      @Override
      public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
      }
      @Override
      public void validate(Object target, Errors errors) {
            User user = (User) target;
// 공백 또는 빈 값 검증 유틸
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required");
            if (user. getAge() > 100) {
                  errors.rejectValue("age", "max", new Object[]{100},"max age is 100");
            }
// 글로벌 오류
            if ("admin".equals(user.getUserName()) && user.getAge() < 20) {
                  errors.reject("authority","authority is invalid");
            }
      }
}

