package io.springmvc.springmvcmaster.service;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User addUser(User user) {
        return userRepository.add(user);
    }
}
