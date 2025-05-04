package io.springmvc.springmvcmaster.model;

import io.springmvc.springmvcmaster.annotation.CustomAnnotation;
import lombok.Data;

@Data
public class User {
      @CustomAnnotation
      private String name;
}
