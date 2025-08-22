package com.example.kindergarden.GeminiAI;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/detect-country")
    public String detectCountry(@RequestParam String address) {
        return geminiService.detectCountry(address);
    }
}
