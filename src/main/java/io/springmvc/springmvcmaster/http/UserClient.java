package io.springmvc.springmvcmaster.http;

import io.springmvc.springmvcmaster.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/user")
public interface UserClient {
      @GetExchange("/{id}")
      User getUserById(@PathVariable Long uesrId);
}
