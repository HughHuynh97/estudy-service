package com.estudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudyApplication.class, args);
    }

}
