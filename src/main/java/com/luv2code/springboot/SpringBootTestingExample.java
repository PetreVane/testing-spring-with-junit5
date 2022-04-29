package com.luv2code.springboot;

import com.luv2code.springboot.models.CollegeStudent;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringBootTestingExample {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestingExample.class, args);
    }

    @Bean
    @Scope(value = "prototype v")
    CollegeStudent collegeStudent() {
        return new CollegeStudent();
    }

}

