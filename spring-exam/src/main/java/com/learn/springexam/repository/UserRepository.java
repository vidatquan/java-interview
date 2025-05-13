package com.learn.springexam.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public UserRepository() {
        System.out.println("UserRepository: constructor called");
    }

    public void print() {
        System.out.println("UserRepository: method called");
    }
}
