package smga.dinosaurios.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class DinosaurMonitoringService {
    public Flux<Integer> getDinosaurData() {
        // Simulación de flujo de datos reactivos
        return Flux.fromStream(Stream.generate(() -> (int)(Math.random() * 100)))
                .delayElements(Duration.ofSeconds(1));
    }
}