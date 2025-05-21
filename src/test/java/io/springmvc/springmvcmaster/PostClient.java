package io.springmvc.springmvcmaster;

import io.springmvc.springmvcmaster.entity.Post;
import io.springmvc.springmvcmaster.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostClient {
      @Autowired
      private PostService postService;

      @Test
      void getPostById(){
            Post postById = postService.getPostById(1L);
            assert null != postById;
      }

}
