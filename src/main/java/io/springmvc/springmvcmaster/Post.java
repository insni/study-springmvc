package io.springmvc.springmvcmaster;

import jakarta.servlet.ServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Post {
      private Long userId;
      private String title;
      private String body;
      private Long id;
}
