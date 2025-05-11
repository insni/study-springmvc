package io.springmvc.springmvcmaster.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword,String> {
private int minLength;

      @Override
      public void initialize(ValidPassword constraintAnnotation) {
           this.minLength=constraintAnnotation.minLength();
      }

      @Override
      public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
            boolean hasDigit=password.chars().anyMatch(Character::isDigit);
            boolean hasLowercase=password.chars().anyMatch(Character::isLowerCase);
            boolean hasUppercase=password.chars().anyMatch(Character::isUpperCase);
          return password.length()>this.minLength&&hasDigit&&hasLowercase&&hasUppercase;
      }
}
