package io.springmvc.springmvcmaster.model;

import lombok.Data;

@Data
public class Order {
      private String productName;
      private int price;
      private int quantity;
}
