package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/repos")
public interface RepositoryService {
      @GetExchange("/{owner}/{repo}")
      Repository getRepository(@PathVariable  String owner,@PathVariable String repo);
}
