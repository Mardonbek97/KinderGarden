package com.example.kindergarden.WebScrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Scrapper {


    @GetMapping("/quotes")
    public List<Map<String, String>> getQuotes() throws IOException {
        String url = "https://quotes.toscrape.com/";
        Document doc = Jsoup.connect(url).get();

        Elements quotes = doc.select(".quote");
        List<Map<String, String>> result = new ArrayList<>();

        for (Element quote : quotes) {
            Map<String, String> item = new HashMap<>();
            item.put("text", quote.select(".text").text());
            item.put("author", quote.select(".author").text());
            result.add(item);
        }
        return result;
    }
}
