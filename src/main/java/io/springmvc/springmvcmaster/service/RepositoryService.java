package io.springmvc.springmvcmaster.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Map;
import java.util.Objects;

@HttpExchange("/repos")
public interface RepositoryService {
      @GetExchange("/{owner}/{repo}")
      Map<String, Object>  getRepository(@PathVariable  String owner, @PathVariable String repo);
}
