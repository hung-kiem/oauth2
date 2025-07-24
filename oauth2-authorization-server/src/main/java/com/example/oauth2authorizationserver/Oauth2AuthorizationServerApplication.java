package com.example.oauth2authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth2AuthorizationServerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Oauth2AuthorizationServerApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("OAuth2 Authorization Server started successfully.");
    }

}
