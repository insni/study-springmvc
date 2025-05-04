package io.springmvc.springmvcmaster.repository;


import io.springmvc.springmvcmaster.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository<T> {
      private final Map<String, T> users = new HashMap<>();

      public T findByEmail(String email) {
            // Simulate a user lookup
            return users.get(email);
      }

      public T save(T t) {
            // Simulate saving a user
            User user = (User) t;
            users.put(user.getEmail(), t);
            return t;
      }
}
