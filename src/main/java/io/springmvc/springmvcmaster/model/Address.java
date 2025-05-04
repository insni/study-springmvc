package io.springmvc.springmvcmaster.model;

public
      class Address {
            private String city;
            private Integer zipcode;

            public Address() {
            }

            public Address(String city, Integer zipcode) {
                  this.city = city;
                  this.zipcode = zipcode;
            }

            public String getCity() {
                  return city;
            }

            public Integer getZipcode() {
                  return zipcode;
            }

            public void setCity(String city) {
                  this.city = city;
            }

            public void setZipcode(Integer zipcode) {
                  this.zipcode = zipcode;
            }
      }