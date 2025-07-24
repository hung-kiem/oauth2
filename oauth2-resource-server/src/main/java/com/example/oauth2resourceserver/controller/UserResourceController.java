package com.example.oauth2resourceserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserResourceController {

    @GetMapping("/profile")
    public Map<String, Object> getUserProfile(@AuthenticationPrincipal Jwt jwt) {
        log.debug("Getting profile for user: {}", jwt.getSubject());

        Map<String, Object> profile = new HashMap<>();
        profile.put("sub", jwt.getSubject());
        profile.put("username", jwt.getClaimAsString("preferred_username"));
        profile.put("email", jwt.getClaimAsString("email"));
        profile.put("authorities", jwt.getClaimAsStringList("authorities"));
        profile.put("scopes", jwt.getClaimAsStringList("scope"));

        return profile;
    }

    @GetMapping("/resources")
    public Map<String, Object> getUserResources(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();
        log.debug("Getting resources for user: {}", userId);

        Map<String, Object> resources = new HashMap<>();
        resources.put("userId", userId);
        resources.put("documents", new String[]{"doc1.pdf", "doc2.txt", "image.png"});
        resources.put("quota", Map.of(
                "used", "150MB",
                "total", "1GB"
        ));

        return resources;
    }

    @GetMapping("/sensitive-data")
    public Map<String, Object> getSensitiveData(@AuthenticationPrincipal Jwt jwt) {
        log.info("Accessing sensitive data for user: {}", jwt.getSubject());

        return Map.of(
                "message", "This is sensitive data",
                "level", "confidential",
                "accessedBy", jwt.getSubject()
        );
    }
}