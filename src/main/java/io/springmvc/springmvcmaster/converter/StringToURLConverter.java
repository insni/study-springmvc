package io.springmvc.springmvcmaster.converter;

import io.springmvc.springmvcmaster.model.URL;
import org.springframework.core.convert.converter.Converter;

public class StringToURLConverter implements Converter<String,URL> {

      @Override
      public URL convert(String source) {
            if (source == null || source.trim().isEmpty()) {
                  throw new IllegalArgumentException("URL String Cant be null");
            }

            String[] parts = source.split("://");
            String protocol = parts[0];
            String domainPort = parts[1];

            String[] parts2 = domainPort.split(":");
            String domain = parts2[0];
            int port = Integer.parseInt(parts2[1]);

            return new URL(protocol, domain, port);
      }
}
