package com.uzabase.assignment.converter;

import org.springframework.stereotype.Component;

@Component
public interface FeedConverter {
    String convertFeed(String feed, String criteria);
}
