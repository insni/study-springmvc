package io.springmvc.springmvcmaster.repository;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository

public class UserRepository {
      private static List<User> repository =
                  new ArrayList<>();
      public User save(User user){
            repository.add(user);
            return user;
      }
}
