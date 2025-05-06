package io.springmvc.springmvcmaster.formater;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class CustomCurrencyFormatterFactory implements AnnotationFormatterFactory<CustomCurrencyFormat> {
      @Override
      public Set<Class<?>> getFieldTypes() {
            Set<Class<?>>  fieldTypes=  new HashSet<>();
            fieldTypes.add(BigDecimal.class);
            return fieldTypes;
      }

      @Override
      public Printer<?> getPrinter(CustomCurrencyFormat annotation, Class<?> fieldType) {
            return new CustomCurrencyFormatter(annotation.pattern(),annotation.decimalPlaces());
      }

      @Override
      public Parser<?> getParser(CustomCurrencyFormat annotation, Class<?> fieldType) {
            return new CustomCurrencyFormatter(annotation.pattern(),annotation.decimalPlaces());

      }
}
