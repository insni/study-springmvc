package io.springmvc.springmvcmaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class URL {
      private String protocol;
      private String domain;
      private int port;
}
