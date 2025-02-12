package com.feedback1.monitoring.aspect;

import java.util.concurrent.locks.ReentrantLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // Se ejecuta antes de otros aspectos (por ejemplo, de logging)
public class EnhancedSecurityAspect {

    // Lock utilizado para sincronizar métodos críticos
    private final ReentrantLock lock = new ReentrantLock();

    @Before("execution(* com.feedback1.monitoring.security.*.*(..))")
    public void beforeSecurityMethods() {
        System.out.println("EnhancedSecurityAspect - BEFORE: Validating security parameters");
    }

    @After("execution(* com.feedback1.monitoring.security.*.*(..))")
    public void afterSecurityMethods() {
        System.out.println("EnhancedSecurityAspect - AFTER: Security check completed");
    }

    @Around("execution(* com.feedback1.monitoring.security.*.*(..))")
    public Object aroundSecurityMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("EnhancedSecurityAspect - AROUND (Before): Starting security check with synchronization");
        Object result;
        try {
            // Sincronización para métodos críticos (por ejemplo, acceso a datos sensibles)
            lock.lock();
            result = joinPoint.proceed();
        } finally {
            lock.unlock();
            System.out.println("EnhancedSecurityAspect - AROUND (After): Finished secure processing");
        }
        return result;
    }
}