package io.springmvc.springmvcmaster.converter;

import io.springmvc.springmvcmaster.model.URL;
import org.springframework.core.convert.converter.Converter;


public class URLToStringConverter implements Converter<URL,String> {
      @Override
      public String convert(URL source) {
            if (source == null)
                  throw new IllegalArgumentException("URL Cant be null");
            return source.getProtocol() + "://" + source.getDomain() + ":" + source.getPort();
      }
}
