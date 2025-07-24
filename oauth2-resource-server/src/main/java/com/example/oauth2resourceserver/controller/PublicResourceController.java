package com.example.oauth2resourceserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/public")
public class PublicResourceController {

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        return Map.of(
                "status", "UP",
                "service", "Resource Server",
                "timestamp", LocalDateTime.now(),
                "version", "1.0.0"
        );
    }

    @GetMapping("/info")
    public Map<String, Object> getPublicInfo() {
        return Map.of(
                "name", "OAuth2 Resource Server",
                "description", "This server contains protected resources",
                "endpoints", Map.of(
                        "public", "/api/public/**",
                        "protected", "/api/user/**",
                        "admin", "/api/admin/**"
                )
        );
    }
}