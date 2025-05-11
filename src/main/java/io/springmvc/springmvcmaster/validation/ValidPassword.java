package io.springmvc.springmvcmaster.validation;

import jakarta.security.auth.message.callback.PasswordValidationCallback;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
      String message() default "잘못된 비밀번호입니다. 비밀번호는 최소 8자 이상이어야 하며, 대문자, 소문자, 숫자를 포함해야 합니다.";
      Class<?>[] groups() default {};
      Class<? extends Payload>[] payload() default {};
      int minLength() default 8; // 최소 길이 속성 추가

}