package com.zulvit.userDatabaseSpring.service;

import com.zulvit.userDatabaseSpring.database.UserRepository;
import com.zulvit.userDatabaseSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;

    @Autowired
    public AdminService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User findById(Long id){
        return userRepository.getOne(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
