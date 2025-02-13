package smga.dinosaurios.controller;

import smga.dinosaurios.service.DinosaurMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DinosaurDataController {

    @Autowired
    private DinosaurMonitoringService dinosaurMonitoringService;

    @GetMapping("/dinosaur-data")
    public Flux<Integer> getDinosaurData() {
        return dinosaurMonitoringService.getDinosaurData();
    }
}