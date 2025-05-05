package io.springmvc.springmvcmaster.format;

import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class KoreanCurrencyFormatter implements Formatter<Number> {
      @Override
      public String print(Number object, Locale locale) {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            String format = currencyInstance.format(object);
            return format;

      }

      @Override
      public Number parse(String text, Locale locale) throws ParseException {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            Number parse = currencyInstance.parse(text);
            return parse;
      }


}
