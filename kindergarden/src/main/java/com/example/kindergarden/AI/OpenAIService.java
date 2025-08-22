package com.example.kindergarden.AI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.ConstantBootstraps;


@Service
public class OpenAIService {

    //private static final Logger logger = LoggerFactory.getLogger(OpenAIService.class);

    @Value("${openai.api-key}")
    private String apiKey;

    @Value("${openai.url}")
    private String openAiUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String detectCountry(String address) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {


            //logger.info("Detect Country ishlatildi; address=> {}",  address);

            HttpPost request = new HttpPost(openAiUrl);
            request.addHeader("Authorization", "Bearer " + apiKey);
            request.addHeader("Content-Type", "application/json");

            // ObjectMapper orqali JSON tuzamiz
            ObjectMapper mapper = new ObjectMapper();

            ObjectNode rootNode = mapper.createObjectNode();
            rootNode.put("model", "gpt-4o");
            rootNode.put("max_tokens", 10);

            ArrayNode messages = mapper.createArrayNode();
            ObjectNode userMessage = mapper.createObjectNode();
            userMessage.put("role", "user");
            userMessage.put("content", "Find out which country the following address belongs to.\n" +
                    "Reply only with the official English name of the country. \n" +
                    "Do not explain anything, do not add text, just reply with the country name in English. \"" + address + "\"");
            messages.add(userMessage);

            rootNode.set("messages", messages);

            String jsonBody = mapper.writeValueAsString(rootNode);
            System.out.println("Yuborilayotgan JSON: " + jsonBody);

            request.setEntity(new StringEntity(jsonBody));

            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            String responseString = new String(response.getEntity().getContent().readAllBytes());
            System.out.println("OpenAI javobi: " + responseString);

            JsonNode jsonNode = mapper.readTree(responseString);
            return jsonNode.at("/choices/0/message/content").asText().trim();
        }
    }


    public String detectPerson(String person) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {

            //logger.info("Detect Person ishlatildi; person=> {}", person);

            HttpPost request = new HttpPost(openAiUrl);
            request.addHeader("Authorization", "Bearer " + apiKey);
            request.addHeader("Content-Type", "application/json");

            // ObjectMapper orqali JSON tuzamiz
            ObjectMapper mapper = new ObjectMapper();

            ObjectNode rootNode = mapper.createObjectNode();
            rootNode.put("model", "gpt-4o");
            rootNode.put("max_tokens", 10);

            ArrayNode messages = mapper.createArrayNode();
            ObjectNode userMessage = mapper.createObjectNode();
            userMessage.put("role", "user");
            userMessage.put("content", "Check whether the following name or address belongs to an individual person or a company/organization. \n" +
                    "Reply only with \"physic\" if it is a natural person, or \"uridic\" if it is a legal entity. \n" +
                    "Do not explain anything, do not add text, just reply with one word: Physical or Juridical. \n" +
                    "Name or address: %s\n \"" + person + "\"");
            messages.add(userMessage);

            rootNode.set("messages", messages);

            String jsonBody = mapper.writeValueAsString(rootNode);
            System.out.println("Yuborilayotgan JSON: " + jsonBody);

            request.setEntity(new StringEntity(jsonBody));

            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            String responseString = new String(response.getEntity().getContent().readAllBytes());
            System.out.println("OpenAI javobi: " + responseString);

            JsonNode jsonNode = mapper.readTree(responseString);
            return jsonNode.at("/choices/0/message/content").asText().trim();
        }
    }

}
