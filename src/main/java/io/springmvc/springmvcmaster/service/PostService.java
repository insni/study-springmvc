package io.springmvc.springmvcmaster.service;

import io.springmvc.springmvcmaster.entity.Post;
import io.springmvc.springmvcmaster.http.PostClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
      private final PostClient postClient;
      public Post execute(){
            Post post = postClient.getPostById(1L);
            Post newPost = new Post(null,"title","new post",1L);
            Post createPost = postClient.createPost(newPost);
            return createPost;

      }
}
