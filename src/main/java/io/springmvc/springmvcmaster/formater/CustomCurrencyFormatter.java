package io.springmvc.springmvcmaster.formater;

import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@RequiredArgsConstructor
public class CustomCurrencyFormatter implements Formatter<BigDecimal> {
      private final String pattern;
      private final int decimalPlaces;

      @Override
      public BigDecimal parse(String text, Locale locale) throws ParseException {
            NumberFormat numberFormat = new DecimalFormat(pattern);
            Number number = numberFormat.parse(text);
            return BigDecimal.valueOf(number.doubleValue())
                        .setScale(decimalPlaces, RoundingMode.HALF_UP);
      }

      @Override
      public String print(BigDecimal object, Locale locale) {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            currencyInstance.setMaximumFractionDigits(decimalPlaces);
            return currencyInstance.format(object);
      }
}

