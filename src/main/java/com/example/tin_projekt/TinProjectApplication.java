package com.example.tin_projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"database"})
public class TinProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinProjectApplication.class, args);
    }

}
