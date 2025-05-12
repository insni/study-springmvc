package io.springmvc.springmvcmaster.reflect;


public class ReflectTarget {
      private String name;
      private Integer age;


      public ReflectTarget(String name, Integer age) {
            this.name = name;
            this.age = age;
      }

      @Override
      public String toString() {
            return "ReflectTarget{name='" + name + "', age=" + age + "}";
      }

      public String getName() {
            return name;
      }

      public Integer getAge() {
            return age;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setAge(Integer age) {
            this.age = age;
      }
}
