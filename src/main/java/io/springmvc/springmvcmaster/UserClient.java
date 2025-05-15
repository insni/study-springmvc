package io.springmvc.springmvcmaster;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/user")
public interface UserClient {
      @GetExchange("/{id}")
      User getUserById(@PathVariable Long uesrId);
}
