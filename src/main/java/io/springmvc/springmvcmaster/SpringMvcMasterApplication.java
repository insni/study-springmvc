package io.springmvc.springmvcmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication @ServletComponentScan
public class SpringMvcMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcMasterApplication.class, args);
    }

}
