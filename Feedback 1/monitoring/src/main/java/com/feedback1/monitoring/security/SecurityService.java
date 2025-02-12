package com.feedback1.monitoring.security;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public String processSecureData(String data) {
        // Simula una operación crítica de seguridad
        System.out.println("SecurityService: Processing secure data for " + data);
        // Se puede agregar lógica adicional (validaciones, auditorías, etc.)
        return "Secured data: " + data;
    }
}