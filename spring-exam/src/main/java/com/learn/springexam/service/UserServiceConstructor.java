package com.learn.springexam.service;

import com.learn.springexam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceConstructor {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceConstructor(UserRepository userRepository) {
        System.out.println("UserServiceConstructor: constructor called");
        this.userRepository = userRepository;
    }

    public void doWork() {
        userRepository.print();
    }
}