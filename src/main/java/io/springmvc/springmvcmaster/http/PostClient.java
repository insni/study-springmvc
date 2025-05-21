package io.springmvc.springmvcmaster.http;

import io.springmvc.springmvcmaster.entity.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/posts")
public interface PostClient {
      @GetExchange("/{id}")
      Post getPostById(@PathVariable Long id);
      @PostExchange
      Post  createPost(@RequestBody Post newPost);



}
