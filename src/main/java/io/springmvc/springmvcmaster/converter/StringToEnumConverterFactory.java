package io.springmvc.springmvcmaster.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class StringToEnumConverterFactory implements ConverterFactory<String,Enum> {

      @Override
      public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
//            1
            return new StringToEnumConverter<>(targetType);

//            2
//            StringToEnumConverter stringToEnumConverter = new StringToEnumConverter(targetType);
//            return stringToEnumConverter;

      }

      private static class StringToEnumConverter<T extends Enum> implements Converter<String, T> {
            private final Class<T> enumType;
            public StringToEnumConverter(Class<T> enumType) {
                  this.enumType = enumType;
            }
            @Override
            public T convert(String source) {
                  if (source == null || source.trim().isEmpty()) return null;
                  return (T) Enum.valueOf(this.enumType, source.trim().toUpperCase());
            }
      }


}
