package com.m4ricu.single.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m4ricu.single.model.Login;
import com.m4ricu.single.model.User;
import com.m4ricu.single.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.findByCpf(user.getCpf()).isPresent()) {
            return null;
        }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return null;
        }
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public User loginUser(Login loginUser) {
        Optional<User> optionalUser = userRepository.findByUsername(loginUser.getUsername());
        User user = optionalUser.get();
        if (user.getPassword() == null) {
            return null;
        }
        return user;

    }

}
