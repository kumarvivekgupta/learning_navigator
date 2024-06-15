package com.example.navigator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.navigator.entities.User;
import com.example.navigator.exception.UserNotFoundException;
import com.example.navigator.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId){

        if(userRepository.existsById(userId)){
            return userRepository.findById(userId).get();

        }else{

            throw new UserNotFoundException("Wrong User Id");

        }

    }
}