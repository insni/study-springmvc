package io.springmvc.springmvcmaster.reflect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Getter
public class ReflectExecutor {
      private final ReflectFieldManager reflectFieldManager;
      private final ReflectMethodManager reflectMethodManager;


}
