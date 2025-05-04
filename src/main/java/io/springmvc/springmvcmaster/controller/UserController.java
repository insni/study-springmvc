package io.springmvc.springmvcmaster.controller;

import io.springmvc.springmvcmaster.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
      @GetMapping
      public Map<String, String> getByUser(@RequestParam String name) throws NoSuchFieldException {
            Field field = User.class.getDeclaredField("name");
            TypeDescriptor sourceType = TypeDescriptor.valueOf(String.class); // source type
            TypeDescriptor targetType = TypeDescriptor.nested(field, 0);// target type

            StringToUserConditionalConverter converter = new StringToUserConditionalConverter();
            if (converter.matches(sourceType,targetType)) {
                  User target = converter.convert(name);
                  return Map.of("name",target.getName());
            }else
                  return Map.of("message","Conversion not possible");


      }
}
