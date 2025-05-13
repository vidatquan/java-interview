package com.learn.springexam.service;

import com.learn.springexam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceSetter {
    private UserRepository userRepository;

    public UserServiceSetter() {
        System.out.println("UserServiceSetter: default constructor called");
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        System.out.println("UserServiceSetter: setter called");
        this.userRepository = userRepository;
    }

    public void doWork() {
        userRepository.print();
    }
}
