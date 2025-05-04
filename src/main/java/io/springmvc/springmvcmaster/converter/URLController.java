package io.springmvc.springmvcmaster.converter;

import io.springmvc.springmvcmaster.config.ConversionServiceConfig;
import io.springmvc.springmvcmaster.model.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/url")
public class URLController {

      private final DefaultConversionService defaultConversionService;


      @PostMapping("/converter")
      public Map<String, Object> saveURL(@RequestParam("url") String url)
      {
            URL convertURL=defaultConversionService.convert(url,URL.class);
            return Map.of("url", url, "converterURL", convertURL);
      }

      @GetMapping("/converter")
      public Map<String,Object> getURL(@ModelAttribute URL url){
            String convertURL = defaultConversionService.convert(url,String.class);
            return Map.of("url", url, "converterURL", convertURL);
      }
}
