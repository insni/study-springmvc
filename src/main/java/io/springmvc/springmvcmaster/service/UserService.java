package io.springmvc.springmvcmaster.service;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
      private final UserRepository<User> userRepository;

      public User getByEmail(String email){
            return userRepository.findByEmail(email);
      }

      public User addUser(User user) {
            return userRepository.save(user);
      }
}
