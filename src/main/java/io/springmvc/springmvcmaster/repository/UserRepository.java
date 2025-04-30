package io.springmvc.springmvcmaster.repository;

import io.springmvc.springmvcmaster.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    public Map<Integer , User > datas=new HashMap<>();
    public User add(User user) {
        datas.put(user.getId(), user);
        return user;
    }
}
