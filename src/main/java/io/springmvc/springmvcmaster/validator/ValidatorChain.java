package io.springmvc.springmvcmaster.validator;

import io.springmvc.springmvcmaster.model.Admin;
import io.springmvc.springmvcmaster.model.User;
import jakarta.servlet.Filter;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.List;

@Component
@Getter
public class ValidatorChain {
      private final List<Validator> validators = new LinkedList<>();

      {
            validators.add(new AdminValidator());
            validators.add(new UserValidator());
      }

      public void doValidate(Object target, Errors errors) {
            for (Validator validator : validators) {
                  validator.validate(target, errors);
            }

      }

      public void addValidator(Validator validator) {
            validators.add(validator);
      }


}
