package io.springmvc.springmvcmaster.service;

import io.springmvc.springmvcmaster.model.User;
import io.springmvc.springmvcmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public Map<String, Object> getUserByName(String name){
        try {
            User user = userRepository.getUser(name);
            return Map.of("user", user);
        } catch (Exception e) {
            return Map.of("message", "User not found");
        }
    }

    public User getUserById(int id) {
        return  userRepository.getUserById(id);
    }

    public User save(String name, Integer id) {
        return userRepository.save(id,name);
    }
}
