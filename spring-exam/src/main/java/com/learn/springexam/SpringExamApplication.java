package com.learn.springexam;

import com.learn.springexam.service.UserServiceConstructor;
import com.learn.springexam.service.UserServiceSetter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringExamApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringExamApplication.class, args);

        System.out.println("--- Running Context ---");

        UserServiceSetter service = context.getBean(UserServiceSetter.class);
        service.doWork();
    }

    @Bean
    public CommandLineRunner run(UserServiceConstructor service1, UserServiceSetter service2) {
        return args -> {
            System.out.println("--- Running Constructor Injection ---");
            service1.doWork();

            System.out.println("--- Running Setter Injection ---");
            service2.doWork();
        };
    }

}
