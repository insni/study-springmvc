package io.springmvc.springmvcmaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class UserConfig {

      @Bean
      public UserClient userClient(RestClient.Builder builder) {
            RestClient restClient = builder.baseUrl("https://api.example.com").build();
            return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build().createClient(UserClient.class);


      }
}
