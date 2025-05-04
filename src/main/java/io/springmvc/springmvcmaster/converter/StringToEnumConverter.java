package io.springmvc.springmvcmaster.converter;

import io.springmvc.springmvcmaster.constant.Color;
import io.springmvc.springmvcmaster.constant.Status;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.*;

public class StringToEnumConverter implements Converter<String, Enum> {

      Optional<Status> status = Optional.empty();
      Optional<Color> color = Optional.empty();

      public <T extends Enum> StringToEnumConverter(Class<T> targetType) {
            if (targetType.getClass().equals(Color.class)) {
                  color = Optional.of(Color.valueOf(targetType.toString()));
                  status = Optional.empty();
            } else if (targetType.getClass().equals(Status.class)) {
                  status = Optional.of(Status.valueOf(targetType.toString()));
                  color = Optional.empty();
            } else {
                  status = Optional.empty();
                  color = Optional.empty();
            }
      }

      @Override
      public Enum convert(String source) {
            if (status.isPresent()) {
                  return Enum.valueOf(Color.class, source);
            } else if (color.isPresent()) {
                  return Enum.valueOf(Status.class, source);
            }
            throw new IllegalArgumentException("Invalid enum value: " + source);
      }
}
