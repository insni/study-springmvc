package io.springmvc.springmvcmaster.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Set;

class UserTest {

      @Test
      void testInvalidUser() throws ParseException {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            User user = new User();
            user.setUsername("ab"); // 길이가 3보다 짧음
            user.setEmail("invalid-email"); // 이메일 형식이 아님
            user.setAge(-1); // 나이가 0보다 작음
            Set<ConstraintViolation<User>> violations = validator.validate(user);
            Assertions.assertThat(3).isEqualTo(violations.size());
            for (ConstraintViolation<User> violation : violations) {
                  String propertyPath = violation.getPropertyPath().toString();
                  String message = violation.getMessage();
                  if (propertyPath.equals("username")) {
                        Assertions.assertThat("사용자명은 3~15 길이 입니다.").isEqualTo(message);
                  } else if (propertyPath.equals("email")) {
                        Assertions.assertThat("이메일 형식에 맞지 않습니다.").isEqualTo(message);
                  } else if (propertyPath.equals("age")) {
                        Assertions.assertThat("나이는 0 보다 커야 합니다.").isEqualTo(message);
                  }
            }
      }
}