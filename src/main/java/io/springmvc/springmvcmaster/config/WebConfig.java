package io.springmvc.springmvcmaster.config;

import io.springmvc.springmvcmaster.handler.MyHttpRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HttpRequestHandler myHttpRequestHandler() {
        return new MyHttpRequestHandler();
    }

    @Bean
    public HandlerMapping simpleUrlHandlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Map<String, Object> urlMap = new HashMap<>();
        urlMap.put("/example2", myHttpRequestHandler());
        mapping.setUrlMap(urlMap);
        mapping.setOrder(Integer.MIN_VALUE);
        return mapping;
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping2(){
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties urlProperties = new Properties();
        urlProperties.setProperty("/simpleUrl","myHttpRequestHandler");
        mapping.setMappings(urlProperties);
        mapping.setOrder(1);
        return mapping;
    }


}
