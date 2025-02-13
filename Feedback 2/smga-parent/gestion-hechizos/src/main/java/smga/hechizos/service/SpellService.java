package smga.hechizos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SpellService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultSpell")
    public String castSpell(String spellName) {
        return restTemplate.getForObject("http://spell-service/cast?spell=" + spellName, String.class);
    }

    public String defaultSpell(String spellName) {
        return "The spell " + spellName + " is currently unavailable. Please try again later.";
    }
}