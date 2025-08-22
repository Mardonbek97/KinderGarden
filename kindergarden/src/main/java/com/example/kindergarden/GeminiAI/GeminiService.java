package com.example.kindergarden.GeminiAI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.create("https://generativelanguage.googleapis.com");

    public String detectCountry(String address) {
        String prompt = "What is the country of this address? Answer only the country name in English: " + address;

        GeminiRequest request = new GeminiRequest(new Content[] {
                new Content(new Part[] { new Part(prompt) })
        });

        try {
            GeminiResponse response = webClient.post()
                    .uri(uriBuilder -> uriBuilder
                            .path("/v1beta/models/gemini-1.5-pro:generateContent")
                            .queryParam("key", apiKey)
                            .build())
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(GeminiResponse.class)
                    .block();
            System.out.print(response);

            return response.candidates[0].content.parts[0].text.trim();
        } catch (Exception e) {
            e.printStackTrace();
            return  "Unknown";
        }
    }

    // DTO lar:
    record GeminiRequest(Content[] contents) {}
    record Content(Part[] parts) {}
    record Part(String text) {}

    record GeminiResponse(Candidate[] candidates) {}
    record Candidate(Content content) {}
}
