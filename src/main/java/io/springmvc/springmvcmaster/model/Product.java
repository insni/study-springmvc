package io.springmvc.springmvcmaster.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Product {
      @NotNull
      private String productName;

      @Min(1)
      @Max(120)
      private Integer productPrice;

}
