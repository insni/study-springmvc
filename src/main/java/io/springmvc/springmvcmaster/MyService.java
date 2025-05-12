package io.springmvc.springmvcmaster;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class MyService {
      public Map<String,List<User>> processRequest(User user){
            List<User> users= Arrays.asList(user);
            Map<String,List<User>> response=Map.of("users",users);
            return response;
      }
}
