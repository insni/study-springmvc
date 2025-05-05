package io.springmvc.springmvcmaster.config;

import io.springmvc.springmvcmaster.converter.StringToURLConverter;
import io.springmvc.springmvcmaster.format.KoreanCurrencyFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.net.URL;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ConversionConfigTest {

      ConversionConfig config = new ConversionConfig();

      @Test
      void customFormatterRegistrar() {
            DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
            FormatterRegistrar registrar = config.customFormatterRegistrar();
            registrar.registerFormatters(conversionService);

            // 테스트: ₩ 문자열을 Number로 파싱
            Number result = conversionService.convert("₩1,000", Number.class);
            assertEquals(1000, result.intValue());

            // 테스트: Number → ₩ 문자열
            String formatted = conversionService.convert(1000, String.class);
            assertEquals("₩1,000", formatted);

            // 테스트: String → URL 변환
            URL url = conversionService.convert("http://localhost:8080", URL.class);
            assertEquals("http://localhost:8080", url.toString());
      }

      @Test
      void stringToURLConverter() {
            StringToURLConverter converter = config.stringToURLConverter();
            io.springmvc.springmvcmaster.model.URL url = converter.convert("http://localhost:8080");
            assertNotNull(url);
            assertEquals("http://localhost:8080", url.toString());
      }

      @Test
      void defaultFormattingConversionService() {
            DefaultFormattingConversionService service = config.defaultFormattingConversionService();
            assertNotNull(service);
      }

      @Test
      void koreanCurrencyFormatter() {
            KoreanCurrencyFormatter formatter = config.koreanCurrencyFormatter();

            try {
                  Number parsed = formatter.parse("₩123,456", Locale.KOREA);
                  assertEquals(123456, parsed.intValue());

                  String formatted = formatter.print(123456, Locale.KOREA);
                  assertEquals("₩123,456", formatted);
            } catch (Exception e) {
                  fail("Formatter parsing or printing failed: " + e.getMessage());
            }
      }
}
