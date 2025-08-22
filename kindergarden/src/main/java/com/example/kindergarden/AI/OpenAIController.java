package com.example.kindergarden.AI;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.netty.http.server.HttpServerRequest;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class OpenAIController {

    private final OpenAIService openAIService;
    private final static Logger logger = LoggerFactory.getLogger(OpenAIController.class);
    public OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/detect-country")
    public String detectCountry(@RequestBody Map<String, String> request) throws Exception {
        String address = request.get("address");
        return openAIService.detectCountry(address);
    }

    @GetMapping("/detect-person")
    public String detectPerson(@RequestBody Map<String, String> request, HttpServletRequest req) throws Exception {
        String ip_address = req.getRemoteAddr();
        String name = req.getLocalName();
        String person = request.get("person");

        logger.info("Get person name ip_address:{}, name:{}, person:{}", ip_address, name, person);

        return openAIService.detectPerson(person);
    }
}
