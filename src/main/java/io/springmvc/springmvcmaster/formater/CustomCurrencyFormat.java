package io.springmvc.springmvcmaster.formater;

public @interface CustomCurrencyFormat {
      String pattern() default "#,###.###";
      int decimalPlaces() default 2;
}
