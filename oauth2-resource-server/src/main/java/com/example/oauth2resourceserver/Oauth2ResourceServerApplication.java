package com.example.oauth2resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth2ResourceServerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Oauth2ResourceServerApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("OAuth2 Resource Server started successfully.");
    }

}
