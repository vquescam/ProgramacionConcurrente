package smga.hechizos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class GestionHechizosApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionHechizosApplication.class, args);
    }
}