package com.uzabase.assignment;

import com.uzabase.assignment.converter.ExcludeWordConverter;
import com.uzabase.assignment.converter.FeedConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RSSFeedConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("excludefeedconverter")
    public FeedConverter feedConverter() {
        return new ExcludeWordConverter();
    }

}
