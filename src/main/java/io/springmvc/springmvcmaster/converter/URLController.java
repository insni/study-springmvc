package io.springmvc.springmvcmaster.converter;

import io.springmvc.springmvcmaster.model.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/url/converter")
public class URLController {

      private final StringToURLConverter stringToURLConverter;
      private final URLToStringConverter urlToStringConverter;


      @GetMapping
      public Map<String, Object> saveURL(@RequestParam("url") String url)
      {
            URL convertURL=stringToURLConverter.convert(url);
            return Map.of("url", url, "converterURL", convertURL);
      }

      @PostMapping
      public Map<String,Object> getURL(@ModelAttribute URL url){
            String convertURL = urlToStringConverter.convert(url);
            return Map.of("url", url, "converterURL", convertURL);
      }
}
