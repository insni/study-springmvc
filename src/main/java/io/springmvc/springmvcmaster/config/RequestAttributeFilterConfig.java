package io.springmvc.springmvcmaster.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestAttributeFilterConfig {
    @Bean
    public FilterRegistrationBean<MyAttributeFilter> loggingFilter(){
        FilterRegistrationBean<MyAttributeFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new MyAttributeFilter());
        registrationBean.addUrlPatterns("/example"); //  꼭 필요함!
        registrationBean.setOrder(1); // (선택) 필터 순서 지정

        return registrationBean;
    }
}
