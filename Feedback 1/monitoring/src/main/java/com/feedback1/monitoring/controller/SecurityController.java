package com.feedback1.monitoring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.feedback1.monitoring.security.SecurityService;

@RestController
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/secure")
    public String secureEndpoint(@RequestParam String data) {
        return securityService.processSecureData(data);
    }
}