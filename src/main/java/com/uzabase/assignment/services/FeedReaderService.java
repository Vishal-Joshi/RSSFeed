package com.uzabase.assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class FeedReaderService {

    private RestTemplate restTemplate;

    private String uzabaseFeedUrl;

    @Autowired
    public FeedReaderService(RestTemplate restTemplate, @Value("${uzabase.rss.feed.url}") String uzabaseFeedUrl) {
        this.restTemplate = restTemplate;
        this.uzabaseFeedUrl = uzabaseFeedUrl;
    }

    public Optional<String> fetchFeed() {
        ResponseEntity<String> feedEntity = restTemplate.getForEntity(uzabaseFeedUrl, String.class);
        if (feedEntity.getStatusCode().equals(HttpStatus.OK)) {
            return Optional.of(feedEntity.getBody());
        }
        return Optional.empty();
    }
}
