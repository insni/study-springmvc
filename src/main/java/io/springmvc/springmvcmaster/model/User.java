package io.springmvc.springmvcmaster.model;


import lombok.Data;

public class User {
      private Long id;
      private String name;
      private Address address;

      public User() {
      }

      public void setId(Long id) {
            this.id = id;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setAddress(Address address) {
            this.address = address;
      }

      public String getName() {
            return name;
      }

      public Long getId() {
            return id;
      }

      public Address getAddress() {
            return address;
      }

      public User(Long id, String name, Address address) {
            this.id = id;
            this.name = name;
            this.address = address;
      }

}
