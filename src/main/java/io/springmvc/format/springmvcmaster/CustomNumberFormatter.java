package io.springmvc.format.springmvcmaster;

import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CustomNumberFormatter implements Formatter<Number> {
      @Override
      public Number parse(String text, Locale locale) throws ParseException {
            NumberFormat format = NumberFormat.getInstance(locale);
            return format.parse(text);
      }

      @Override
      public String print(Number object, Locale locale) {
            NumberFormat format= NumberFormat.getInstance(locale);
            return format.format(object);
      }
}
