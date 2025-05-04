package io.springmvc.springmvcmaster.model;

import io.springmvc.springmvcmaster.annotation.CustomAnnotation;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;


@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class User {
      @CustomAnnotation
      private String name;
}

