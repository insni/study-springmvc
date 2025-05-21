package io.springmvc.springmvcmaster;

import io.springmvc.springmvcmaster.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientSsl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Map;

@SpringBootTest
public class ClientProxy {

      @Test
      void  restClient(){
            RestClient restClient = RestClient.builder().baseUrl("https://api.github.com/").build();
            RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
            HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
            RepositoryService repositoryService = httpServiceProxyFactory.createClient(RepositoryService.class);
            Map<String, Object> repository = repositoryService.getRepository("spring-projects", "spring-boot");
           assert null==repository;
      }

      @Test
      void webClient(){
            WebClient webClient = WebClient.builder().baseUrl("https://api.github.com/").build();
            WebClientAdapter adapter = WebClientAdapter.create(webClient);
            HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
            RepositoryService service = factory.createClient(RepositoryService.class);
            assert null==service;
      }

      @Test
      void restTemplate(){
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://api.github.com/"));
            RestTemplateAdapter restTemplateAdapter=RestTemplateAdapter.create(restTemplate);
            HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restTemplateAdapter).build();
            RepositoryService client = httpServiceProxyFactory.createClient(RepositoryService.class);
            assert null==client;
      }
}
