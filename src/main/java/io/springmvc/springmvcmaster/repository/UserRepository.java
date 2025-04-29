package io.springmvc.springmvcmaster.repository;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<String, User> users=new HashMap<>();
    {
        users.put("1", new User(1,"anynomous"));
        users.put("2", new User(2,"insoo"));
    }

    public User getUser(String name) {
        User user = users.get(name);
        if (user != null) {
            return user;
        }
        throw new IllegalArgumentException("User not found");
    }

    public User getUserById(int id) {
        return users.values().stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User save(Integer id,String name) {
        User user = new User(id, name);
        if (users.containsKey(id+"")) {
            throw new IllegalArgumentException("User already exists");
        }
        users.put(user.getName(), user);
        return user;
    }
}
