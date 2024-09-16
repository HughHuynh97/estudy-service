package com.estudy.schedler;

import com.estudy.utils.JsonConverter;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.logging.Level;

@Service
@RequiredArgsConstructor
@Log
public class CrawlingScheduler {
    private final RestTemplate restTemplate;

    @PostConstruct
    public void getAllAppList() {
        try {
            final String url = "https://estudyme.com/";
            // Make HTTP request to get the HTML content
            var response = restTemplate.getForEntity(url, String.class);
            String htmlContent = response.getBody();

            // Parse the HTML using Jsoup
            var doc = Jsoup.parse(htmlContent);

            // Find the script tag with id="__NEXT_DATA__"
            var scriptTag = doc.select("script#__NEXT_DATA__").first();

            if (scriptTag != null) {
                // Get the JSON content
                System.out.println(scriptTag.html());
                var jsonData = JsonConverter.readValue(scriptTag.html(), Map.class);
            }
        } catch (Exception exception) {
            log.log(Level.WARNING, "getAllAppList got exception", exception);
        }

    }

}
